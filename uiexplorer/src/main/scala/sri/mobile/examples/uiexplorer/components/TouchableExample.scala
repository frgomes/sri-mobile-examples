package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.apis.PixelRatio
import sri.universal.components.{ImageSource, _}
import sri.universal.styles.InlineStyleSheetUniversal
import sri.universal._
import scala.scalajs.js

object TouchableExample extends UIExample {

  val heartImage = ImageSource(
    uri = "https://pbs.twimg.com/media/BlXBfT3CQAA6cVZ.png:small")

  object TouchableFeedbackEvents {

    case class State(eventLog: js.Array[String] = js.Array())

    class Component extends ComponentS[State] {

      initialState(State())

      def render() = ViewC(
        View(style = styles.wrapper)(
          TouchableOpacity(
            style = styles.wrapper,
            onPress = () => appendEvent("press"),
            onPressIn = () => appendEvent("pressIn"),
            onPressOut = () => appendEvent("pressOut"),
            onLongPress = () => appendEvent("longPress")
          )(
            Text(style = styles.button)("Press Me")
          )
        ),
        View(style = styles.eventLogBox)(
          state.eventLog.zipWithIndex.map {
            case (e, i) => Text(key = i.toString)(e)
          }
        )
      )

      def appendEvent(name: String) = {
        val eventLog = state.eventLog.slice(0, 5)
        setState((state: State) => state.copy(eventLog = name +: eventLog))
      }
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component](key = key, ref = ref)

  }

  val Component = () => {
    UIExplorerPage(
      UIExplorerBlock(title = "TouchableHighlight")(
        View(style = styles.touchableRow)(
          TouchableHighlight(style = styles.wrapper,
                             onPress =
                               () => println("stock THW image - highlight"))(
            Image(source = heartImage, style = styles.image)
          ),
          TouchableHighlight(style = styles.wrapper,
                             activeOpacity = 1.0,
                             underlayColor = "rgb(210, 230, 255)",
                             onPress =
                               () => println("custom THW text - hightlight"))(
            Text(style = styles.text)(
              "Tap Here For Custom Highlight!"
            )
          )
        )
      ),
      UIExplorerBlock(title = "Touchable feedback events")(
        TouchableFeedbackEvents()
      )
    )

  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val touchableRow = style(justifyContent.center, flexDirection.row)

    val icon = style(width := 24, height := 24)

    val image = style(width := 50, height := 50)

    val text = style(fontSize := 15)

    val button = style(color := "#007AFF")

    val wrapper = style(borderRadius := 8)

    val wrapperCustom = style(
      borderRadius := 8,
      padding := 6
    )
    val logBox = style(
      padding := 20,
      margin := 10,
      borderWidth := 1.0 / PixelRatio.get(),
      borderColor := "#f0f0f0",
      backgroundColor := "#f9f9f9"
    )
    val eventLogBox = style(
      padding := 10,
      margin := 10,
      height := 120,
      borderWidth := 1.0 / PixelRatio.get(),
      borderColor := "#f0f0f0",
      backgroundColor := "#f9f9f9"
    )

    val textBlock = style(
      fontWeight := "500",
      color := "blue"
    )
  }

  override def title: String = "Touchable*"

  override def description: String = "TouchableHighlight,TouchableOpacity .."

}
