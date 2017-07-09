package sri.mobile.examples.uiexplorer.apis

import sri.core.{CreateElementSF, CreateElementSFNoP}
import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.universal.apis.Linking
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.Thenable.Implicits._

object LinkingExample extends UIExample {

  override val title: String = "LinkingExample"
  override val description: String = "Shows how to use Linking to open URLs."

  object OpenURLButton {

    val Component = (props: String) =>
      TouchableOpacity(onPress = () => handleClick(props))(
        View(style = styles.button)(
          Text(style = styles.text)(s"Open ${props}")
        )
    )

    def handleClick(url: String): Unit = {
      Linking
        .canOpenURL(url)
        .map(supported => {
          if (supported) Linking.openURL(url)
          else println(s"Dont know how to open this url ${url}")
        })
    }

    def apply(url: String) = CreateElementSF(Component, props = url)
  }

  val Component = () => {
    UIExplorerPage(
      UIExplorerBlock("Open external URLs")(
        OpenURLButton("http://www.scala-js.org/"),
        OpenURLButton("https://www.facebook.com"),
        OpenURLButton("http://facebook.com"),
        OpenURLButton("geo:37.484847,-122.148386")
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val container =
      style(flex := 1,
            backgroundColor := "white",
            padding := 10,
            paddingTop := 30)

    val button =
      style(padding := 10, backgroundColor := "#3B5998", marginBottom := 10)
    val text = style(color := "white")
  }

}
