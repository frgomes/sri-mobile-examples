package sri.mobile.examples.uiexplorer.components

import org.scalajs.dom
import sri.core.{ComponentNoPS, ComponentS, CreateElementNoProps}
import sri.universal.components.{ActivityIndicator, ActivityIndicatorSize, _}
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js

object ActivityIndicatorExample extends UIExample {

  object ToggleAnimatingActivityIndicator {

    case class State(animating: Boolean = true)

    class Component extends ComponentS[State] {

      initialState(State())

      var timers: Seq[Int] = List()

      def render() =
        ActivityIndicator(animating = state.animating,
                          style = styles.animating,
                          size = ActivityIndicatorSize.LARGE)

      override def componentDidMount() = {
        setToggleTimeout
      }

      override def componentWillUnmount(): Unit = {
        timers.foreach(id => dom.window.clearTimeout(id))
      }

      def setToggleTimeout: Unit = {
        val id = dom.window.setTimeout(() => {
          setState((state: State) => state.copy(animating = !state.animating))
          setToggleTimeout
        }, 1200)
        timers :+= id
      }
    }

    def apply(key: js.UndefOr[String] = js.undefined,
              ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component]()
  }

  class Component extends ComponentNoPS {
    def render() = UIExplorerPage(
      UIExplorerBlock("Default white")(
        ActivityIndicator(style = styles.default, color = "white")
      ),
      UIExplorerBlock("Gray")(
        ActivityIndicator(style = styles.default)
      ),
      UIExplorerBlock("Large")(
        ActivityIndicator(style = styles.default,
                          color = "white",
                          size = ActivityIndicatorSize.LARGE)
      ),
      UIExplorerBlock("Large custom colors")(
        View(style = styles.horizontal)(
          ActivityIndicator(key = "3",
                            color = "#00aa00",
                            size = ActivityIndicatorSize.LARGE)
        )
      ),
      UIExplorerBlock("Start/Stop")(
        ToggleAnimatingActivityIndicator()
      )
    )

  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends InlineStyleSheetUniversal {
    import dsl._

    val centering = style(
      alignItems.center,
      justifyContent.center
    )

    val gray = style(backgroundColor := "#cccccc")

    val horizontal =
      style(flexDirection.row, justifyContent.center)

    val default = js.Array(centering, gray, style(height := 40))

    val animating = js.Array(centering, style(height := 80))
  }

  override def title: String = "ActivityIndicator"

  override def description: String = "Animated loading indicators."
}
