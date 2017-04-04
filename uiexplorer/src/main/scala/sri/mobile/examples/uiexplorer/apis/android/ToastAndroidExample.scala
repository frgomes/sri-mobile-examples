package sri.mobile.examples.uiexplorer.apis.android

import sri.core.CreateElementSFNoP
import sri.mobile.apis.android.ToastAndroid
import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js.Dynamic.{literal => json}

object ToastAndroidExample extends UIExample {

  override val title: String = "Toast Example"
  override val description: String =
    "Example that demonstrates the use of an Android Toast to provide feedback."

  val Component = () => {
    UIExplorerPage(
      UIExplorerBlock("Simple toast")(
        TouchableWithoutFeedback(
          onPress = () =>
            ToastAndroid.show("This is a toast with short duration",
                              ToastAndroid.SHORT))(
          View(Text(style = styles.text)("Click me."))
        )
      ),
      UIExplorerBlock("Toast with long duration")(
        TouchableWithoutFeedback(
          onPress = () =>
            ToastAndroid.show("This is a toast with long duration",
                              ToastAndroid.LONG))(
          View(Text(style = styles.text)("Click me too."))
        )
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends UniversalStyleSheet {
    val text = style(color = "black")
  }

}
