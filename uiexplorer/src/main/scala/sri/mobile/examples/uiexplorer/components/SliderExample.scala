package sri.mobile.examples.uiexplorer.components

import sri.core.{ComponentS, CreateElementNoProps}
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js.annotation.ScalaJSDefined

object SliderExample extends UIExample {

  case class State(value: Double = 0)

  @ScalaJSDefined
  class Component extends ComponentS[State] {

    initialState(State())

    def render() = UIExplorerPage(
      UIExplorerBlock("SliderIOS")(
        View(
          Text(style = styles.text)(
            state.value
          ),
          Slider(style = styles.slider,
                 value = state.value,
                 onValueChange = handleValueChnage _)
        )
      )
    )

    def handleValueChnage(value: Double): Unit = {
      setState((state: State) => state.copy(value = value))
    }
  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends UniversalStyleSheet {
    val slider = style(height = 10, margin = 10)

    val text = style(
      fontSize = 14,
      textAlign = "center",
      fontWeight = "500",
      margin = 10
    )

  }

  override def title: String = "Slider"

  override def description: String = "Slider Example"
}
