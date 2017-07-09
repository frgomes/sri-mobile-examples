package sri.mobile.examples.uiexplorer.components

import sri.core.{ComponentNoPS, CreateElementNoProps}
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal
import sri.universal._
import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce

object ScrollViewSimpleExample extends UIExample {

  val NUM_ITEMS = 20

  class Component extends ComponentNoPS {
    def render() = {
      val items = makeItems(NUM_ITEMS, styles.itemWrapper)

      UIExplorerPage(
        ScrollView(style = styles.verticalScrollView)(items)
      )
    }

    def makeItems(nItems: Int, style: js.Any) = {
      (1 to nItems).toList
        .map(i =>
          TouchableOpacity(key = i.toString, style = style)(TextC(s"Item $i")))
        .toJSArray
    }
  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val verticalScrollView = style(margin := 10)

    val itemWrapper = style(backgroundColor := "#dddddd",
                            alignItems.center,
                            borderRadius := 5,
                            borderWidth := 5,
                            borderColor := "#a52a2a",
                            padding := 30,
                            margin := 5)

    val horizontalItemWrapper = style(padding := 50)

    val horizontalScrollView = js.Array(itemWrapper, horizontalItemWrapper)
  }

  override def title: String = "ScrollView"

  override def description: String =
    "Component that enables scrolling through child components"
}
