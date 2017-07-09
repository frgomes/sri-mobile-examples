package sri.mobile.examples.uiexplorer.components.ios

import sri.core._
import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.universal.components._
import sri.mobile.components.ios._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}

object SegmentedControlExample extends UIExample {

  object BasicSegmentedControlExample {

    val Component = () => {
      ViewC(
        SegmentedControlIOS(values = js.Array("One", "Two"))
      )
    }

    def apply(key: String = null) = CreateElementSFNoP(Component)
  }

  object PreSelectedSegmentedControlExample {

    val Component = () => {
      ViewC(
        SegmentedControlIOS(values = js.Array("One", "Two"), selectedIndex = 0)
      )
    }

    def apply(key: String = null) = CreateElementSFNoP(Component)
  }

  object MomentarySegmentedControlExample {

    val Component = () => {
      ViewC(
        SegmentedControlIOS(values = js.Array("One", "Two"), momentary = true)
      )
    }

    def apply(key: String = null) = CreateElementSFNoP(Component)
  }

  object DisabledSegmentedControlExample {

    val Component = () => {
      ViewC(
        SegmentedControlIOS(values = js.Array("One", "Two"),
                            enabled = false,
                            selectedIndex = 0)
      )
    }

    def apply(key: String = null) = CreateElementSFNoP(Component)
  }

  object ColorSegmentedControlExample {

    val Component = () => {
      ViewC(
        SegmentedControlIOS(values = js.Array("One", "Two"),
                            selectedIndex = 0,
                            tintColor = "#ff0000")
      )
    }

    def apply(key: String = null) = CreateElementSFNoP(Component)
  }

  object EventSegmentedControlExample {

    case class State(values: js.Array[String] =
                       js.Array("One", "Two", "Three", "Four"),
                     value: String = "One",
                     index: Int = 0)

    class Component extends ComponentS[State] {

      initialState(State())

      def render() = ViewC(
        Text(style = styles.text)(s"Value : ${state.value}"),
        Text(style = styles.text)(
          s"Index : ${state.values.indexOf(state.value)}"),
        SegmentedControlIOS(values = state.values,
                            selectedIndex = state.index,
                            tintColor = "#cf00a2",
                            onChange = onChange _,
                            onValueChange = onValueChange _)
      )

      def onChange(e: js.Dynamic) = {
        val index = e.nativeEvent.selectedSegmentIndex.toString.toInt
        setState((state: State) => state.copy(index = index))
      }

      def onValueChange(value: String) =
        setState((state: State) => state.copy(value = value))
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component]()

  }

  val Component = () => {
    UIExplorerPage(
      ViewC(
        UIExplorerBlock("Segmented controls can have values")(
          BasicSegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can have a pre-selected value")(
          PreSelectedSegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can be momentary")(
          MomentarySegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can be disabled")(
          DisabledSegmentedControlExample()
        ),
        UIExplorerBlock("Custom colors can be provided")(
          ColorSegmentedControlExample()
        ),
        UIExplorerBlock("Change events can be detected")(
          EventSegmentedControlExample()
        )
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val text = style(fontSize := 14,
                     textAlign.center,
                     fontWeight := "500",
                     margin := 10)

  }

  override def title: String = "SegmentedControlIOS"

  override def description: String = "Native segmented control"
}
