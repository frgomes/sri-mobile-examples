package sri.mobile.examples.uiexplorer.components

import sri.core.{ReactElement, _}
import sri.universal._
import sri.universal.apis.{Animated, AnimatedValue, TimingAnimationConfig}
import sri.universal.components.{Text, View, _}
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js

object AnimatedExample extends UIExample {

  object FadeInView {

    case class State(fadeAnim: AnimatedValue = new AnimatedValue(0))

    class Component extends ComponentS[State] {

      initialState(State())

      def render() = {
        AnimatedView(style = styles.fadeInViewstyle(state.fadeAnim))(
          children
        )
      }

      override def componentDidMount(): Unit = {
        Animated
          .timing(state.fadeAnim, new TimingAnimationConfig {
            toValue = 1
            duration = 2000
          })
          .start()
      }
    }

    def apply(children: ReactElement) =
      CreateElementNoPropsWithChildren[Component](
        children = js.Array(children))

  }

  object FadeInExample {

    case class State(show: Boolean = true)

    class Component extends ComponentS[State] {

      initialState(State())

      def render() = {
        ViewC(
          UIExplorerButton(
            () => setState((state: State) => state.copy(show = !state.show)))(
            s"Press to ${if (state.show) "Hide" else "Show"}"
          ),
          state.show ?= FadeInView(
            View(style = styles.content)(TextC("FadeInView")))
        )
      }

    }

    def apply() = CreateElementNoProps[Component]()

  }

  class Component extends ComponentNoPS {

    def render() = UIExplorerPage(
      UIExplorerBlock(
        "FadeInView",
        description =
          "Uses a simple timing animation to bring opacity from 0 to 1 when the component mounts.")(
        FadeInExample()
      )
//      ,
//      UIExplorerBlock("Transform Bounce",
//        description = "One `Animated.Value` is driven by a  spring with custom constants and mapped to an  ordered set of transforms.  Each transform has  an interpolation to convert the value into the  right range and units.")(
//        FadeInExample()
//      )
    )

  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    def fadeInViewstyle(value: AnimatedValue) =
      styleUR(opacity := value)

    val content = style(backgroundColor := "deepskyblue",
                        borderWidth := 1,
                        borderColor := "dodgerblue",
                        padding := 20,
                        margin := 20,
                        borderRadius := 10,
                        alignItems.center)

  }

  override def title: String = "Animated"

  override def description: String = "Animated Example"
}
