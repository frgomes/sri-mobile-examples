package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

object SwitchExample extends UIExample {

  case class BasicState(trueSwitchIsOn: Boolean = true,
                        falseSwitchIsOn: Boolean = false)

  object BasicSwitchExample {

    @ScalaJSDefined
    class Component extends ComponentS[BasicState] {

      initialState(BasicState())

      def render() = View(
        Switch(onValueChange = handleFalseSwitch _,
               style = styles.basicFalseSwitch,
               value = state.falseSwitchIsOn),
        Switch(onValueChange = handleTrueSwitch _,
               value = state.trueSwitchIsOn)
      )

      def handleFalseSwitch(value: Boolean) = {
        setState((state: BasicState) => state.copy(falseSwitchIsOn = value))
      }

      def handleTrueSwitch(value: Boolean) = {
        setState((state: BasicState) => state.copy(trueSwitchIsOn = value))
      }
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component](key = key)

  }

  object DisabledSwitchExample {

    @ScalaJSDefined
    class Component extends ComponentNoPS {
      def render() = View(
        Switch(disabled = true, style = styles.basicFalseSwitch, value = true),
        Switch(disabled = true, value = false)
      )
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component](key = key, ref = ref)
  }

  object ColorSwitchExample {

    @ScalaJSDefined
    class Component extends ComponentS[BasicState] {

      initialState(BasicState())

      def render() = View(
        Switch(onValueChange = handleFalseSwitch _,
               style = styles.basicFalseSwitch,
               onTintColor = "#00ff00",
               tintColor = "#ff0000",
               value = state.falseSwitchIsOn),
        Switch(onValueChange = handleTrueSwitch _,
               onTintColor = "#00ff00",
               tintColor = "#ff0000",
               value = state.trueSwitchIsOn)
      )

      def handleFalseSwitch(value: Boolean) = {
        setState((state: BasicState) => state.copy(falseSwitchIsOn = value))
      }

      def handleTrueSwitch(value: Boolean) = {
        setState((state: BasicState) => state.copy(trueSwitchIsOn = value))
      }
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component](key = key, ref = ref)

  }

  object EventSwitchExample {

    case class State(eventSwitchIsOn: Boolean = false,
                     eventSwitchRegressionIsOn: Boolean = true)

    @ScalaJSDefined
    class Component extends ComponentS[State] {

      initialState(State())

      def render() = View(style = styles.eventsContainer)(
        View(
          Switch(onValueChange = handleEventSwitch _,
                 style = styles.basicFalseSwitch,
                 value = state.eventSwitchIsOn),
          Switch(onValueChange = handleEventSwitch _,
                 style = styles.basicFalseSwitch,
                 value = state.eventSwitchIsOn),
          Text(if (state.eventSwitchIsOn) "On" else "Off")
        ),
        View(
          Switch(onValueChange = handleEventSwitchRegression _,
                 style = styles.basicFalseSwitch,
                 value = state.eventSwitchRegressionIsOn),
          Switch(onValueChange = handleEventSwitchRegression _,
                 style = styles.basicFalseSwitch,
                 value = state.eventSwitchRegressionIsOn),
          Text(if (state.eventSwitchRegressionIsOn) "On" else "Off")
        )
      )

      def handleEventSwitch(value: Boolean) = {
        setState((state: State) => state.copy(eventSwitchIsOn = value))
      }

      def handleEventSwitchRegression(value: Boolean) = {
        setState(
          (state: State) => state.copy(eventSwitchRegressionIsOn = value))
      }
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component](key = key)

  }

  val Component = () => {
    UIExplorerPage(
      UIExplorerBlock("Basic Switch")(
        BasicSwitchExample()
      ),
      UIExplorerBlock("Disabled Switches")(
        DisabledSwitchExample()
      ),
      UIExplorerBlock("Colored Switches")(
        ColorSwitchExample()
      ),
      UIExplorerBlock("Change events can be detected")(
        EventSwitchExample()
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends UniversalStyleSheet {

    val basicFalseSwitch = style(marginBottom = 10)

    val eventsContainer =
      style(flexDirection = "row", justifyContent = "space-around")
  }

  override def title: String = "Switch"

  override def description: String = "Native boolean input"
}
