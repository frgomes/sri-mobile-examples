package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.components.{Text, TextC, TouchableHighlight}
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav

object UIExplorerButton {

  class Component extends ComponentP[() => _] {

    def render() = {
      TouchableHighlight(onPress = props,
                         style = styles.button,
                         underlayColor = "grey")(
        TextC(children)
      )
    }
  }

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val button = style(borderColor := "#696969",
                       borderRadius := 8,
                       borderWidth := 1,
                       padding := 10,
                       margin := 5,
                       alignItems.center,
                       justifyContent.center,
                       backgroundColor := "#d3d3d3")
  }

  def apply(onPress: () => _)(children: ReactNode*) =
    CreateElementWithChildren[Component](onPress,
                                         children = children.toJSArray)

}
