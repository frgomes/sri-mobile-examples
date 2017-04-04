package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

object ModalExample extends UIExample {

//
//  object Button {
//
//    case class State(active: Boolean = false)
//
//    @ScalaJSDefined
//    class Component extends Component[Props, State] {
//
//      initialState(State())
//
//      def render() = {
//        TouchableHighlight(onHideUnderlay = onUnhighlight _,
//          onPress = props.onPress,
//          onShowUnderlay = onHighlight _,
//          style = styles.buttonstyle(props.style),
//          underlayColor = "#a9d9d4")(
//          Text(style = styles.buttonTextstyle(state.active))(children)
//        )
//      }
//
//      def onHighlight() = setState((state:State) => state.copy(active = true))
//
//      def onUnhighlight() = setState((state:State) => state.copy(active = false))
//
//    }
//
//    case class Props(onPress: () => Unit, style: js.Any)
//
//    def apply(onPress: () => Unit, style: js.Any = js.Dynamic.literal())(children: ReactNode) = CreateElementWithChildren[Component](Props(onPress, style),children = js.Array(children))
//
//  }

  case class State(animationType: ModalAnimationType = ModalAnimationType.NONE,
                   modalVisible: Boolean = false,
                   transparent: Boolean = false)

  @ScalaJSDefined
  class Component extends ComponentS[State] {

    initialState(State())

    def render() = {
      UIExplorerPage(
        Modal(animationType = state.animationType,
              transparent = state.transparent,
              visible = state.modalVisible)(
          View(style = styles.customContainer(state.transparent))(
            View(style = styles.customInnerContainer(state.transparent))(
              Text(
                s"This modal was presented ${if (state.animationType == ModalAnimationType.NONE) "without"
                else "with"} animation"),
              Button(onPress = () => setModalVisible(false),
                     style = styles.modalButton,
                     title = "Close")
            )
          )
        ),
        View(style = styles.modalRow)(
          Text(style = styles.rowTitle)("Animation Type"),
          Button(
            onPress = () => setAnimationType(ModalAnimationType.NONE),
            style =
              if (state.animationType == ModalAnimationType.NONE)
                styles.activeButtonStyle
              else js.Dynamic.literal(),
            title = "None"
          ),
          Button(
            onPress = () => setAnimationType(ModalAnimationType.FADE),
            style =
              if (state.animationType == ModalAnimationType.FADE)
                styles.activeButtonStyle
              else js.Dynamic.literal(),
            title = "Fade"
          ),
          Button(
            onPress = () => setAnimationType(ModalAnimationType.SLIDE),
            style =
              if (state.animationType == ModalAnimationType.SLIDE)
                styles.activeButtonStyle
              else js.Dynamic.literal(),
            title = "Slide"
          )
        ),
        View(style = styles.modalRow)(
          Text(style = styles.rowTitle)("Transparent"),
          Switch(value = state.transparent,
                 onValueChange = toggleTransparent _)
        ),
        Button(onPress = () => setModalVisible(true), title = "Present")
      )
    }

    def setModalVisible(visible: Boolean) = {
      setState((state: State) => state.copy(modalVisible = visible))
    }

    def setAnimationType(modalAnimationType: ModalAnimationType) = {
      setState(
        (state: State) => state.copy(animationType = modalAnimationType))
    }

    def toggleTransparent(value: Boolean) = {
      setState((state: State) => state.copy(transparent = !state.transparent))
    }

  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends UniversalStyleSheet {
    val container =
      style(flex = 1, justifyContent = "center", padding = 20)
    val innerContainer = style(borderRadius = 10)
    val modalRow = style(alignItems = "center",
                         flex = 1,
                         flexDirection = "row",
                         marginBottom = 20)

    val rowTitle = style(flex = 1, fontWeight = "bold")

    val button = style(borderRadius = 5,
                       flex = 1,
                       height = 44,
                       justifyContent = "center",
                       overflow = "hidden")

    val buttonText =
      style(fontSize = 18, margin = 5, textAlign = "center")

    val modalButton = style(marginTop = 100)

    def buttonstyle(userStyle: js.Any) = js.Array(button, userStyle)

    def buttonTextstyle(active: Boolean) = {
      val c = if (active) "#fff" else "#000"
      js.Array(buttonText, style(color = c))
    }

    def customContainer(transparent: Boolean) = {
      val c = if (transparent) "rgba(0, 0, 0, 0.5)" else "#f5fcff"
      js.Array(container, style(backgroundColor = c))
    }

    def customInnerContainer(transparent: Boolean) = {
      val c =
        if (transparent) style(backgroundColor = "#fff", padding = 20)
        else style()
      js.Array(innerContainer, c)
    }

    val activeButtonStyle = style(backgroundColor = "#ddd")
  }

  override def title: String = "Modal"

  override def description: String = "Component for presenting modal views."
}
