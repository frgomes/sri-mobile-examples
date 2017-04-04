package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.components.{Text, TouchableHighlight}
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.annotation.ScalaJSDefined

object UIExplorerButton {

  @ScalaJSDefined
  class Component extends ComponentP[() => _] {

    def render() = {
      TouchableHighlight(onPress = props,
                         style = styles.button,
                         underlayColor = "grey")(
        Text(children)
      )
    }
  }

  object styles extends UniversalStyleSheet {

    val button = style(borderColor = "#696969",
                       borderRadius = 8,
                       borderWidth = 1,
                       padding = 10,
                       margin = 5,
                       alignItems = "center",
                       justifyContent = "center",
                       backgroundColor = "#d3d3d3")
  }

  def apply(onPress: () => _)(children: ReactNode*) =
    CreateElementWithChildren[Component](onPress,
                                         children = children.toJSArray)

}
