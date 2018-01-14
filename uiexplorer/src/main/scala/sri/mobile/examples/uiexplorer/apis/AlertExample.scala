package sri.mobile.examples.uiexplorer.apis

import sri.core.CreateElementSFNoP
import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.universal.apis.{Alert, AlertButton}
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce

object AlertExample extends UIExample {
  override def title: String = "Alert"

  val Component = () => {
    val a1 = () => Alert.alert("Foo title", "alert message")
    val a2 = () =>
      Alert.alert("Foo title",
                  "alert message",
                  buttons = js.Array(AlertButton(
                    text = "Button",
                    onPress = (() => println("Button Pressed"))
                  )))
    val a3 = () =>
      Alert.alert(
        title = "Foo Title",
        message = "My Alert Msg",
        buttons = js.Array(
          AlertButton(
            text = "Foo",
            onPress = (() => println("Foo Button Pressed"))
          )
          ,
          AlertButton(
            text = "Bar",
            onPress = (() => println("Bar Button Pressed"))
          )
        )
    )
    val a4 = () =>
      Alert.alert(
        title = "Foo Title",
        buttons = js.Array(
          AlertButton(
            text = "Foo",
            onPress = (() => println("Foo Button Pressed"))
          ),
          AlertButton(
            text = "Bar",
            onPress = (() => println("Bar Button Pressed"))
          ),
          AlertButton(
            text = "Baz",
            onPress = (() => println("Baz Button Pressed"))
          )
        )
    )
    val a5 = () =>
      Alert.alert(
        title = "Foo title",
        buttons = (1 to 10)
          .map(i =>
            AlertButton(
              text = s"Button $i",
              onPress = (() => println(s"Button $i pressed"))
            ))
          .toJSArray)

    UIExplorerPage(
      UIExplorerBlock("Alerts")(
        View(style = json(flex = 1))(
          TouchableHighlight(style = styles.wrapper, onPress = a1)(
            View(style = styles.button)(
              TextC("Alert Message with default button")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a2)(
            View(style = styles.button)(
              TextC("Alert with only one button")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a3)(
            View(style = styles.button)(
              TextC("Alert with two buttons")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a4)(
            View(style = styles.button)(
              TextC("Alert with 3 buttons")
            )
          ),
          TouchableHighlight(style = styles.wrapper, onPress = a5)(
            View(style = styles.button)(
              TextC("Alert with too many buttons")
            )
          )
        )
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends InlineStyleSheetUniversal {

    import dsl._
    val alertsContainer = style(backgroundColor := "white", padding := 20)
    val wrapper = style(borderRadius := 5, marginBottom := 5)
    val button = style(backgroundColor := "#eeeeee", padding := 10)
  }

  override def description: String = "alerts and action sheets"
}
