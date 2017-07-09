package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal._
import sri.universal.components.{Text, View}
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav

object UIExplorerBlock {

  case class Props(title: String, description: String)

  class Component extends ComponentP[Props] {

    def render() = {
      View(style = styles.container)(
        View(style = styles.titleContainer)(
          Text(style = styles.titleText)(props.title),
          props.description.nonEmpty ?= Text(style = styles.descriptionText)(
            props.description)
        ),
        View(style = styles.children)(
          children
        )
      )
    }
  }

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val container = style(
      borderRadius := 3,
      borderWidth := 0.5,
      borderColor := "#d6d7da",
      backgroundColor := "#ffffff",
      margin := 10,
      marginVertical := 5,
      overflow := "hidden"
    )

    val titleContainer = style(
      borderWidth := 0.5,
      borderColor := "#d6d7da",
      backgroundColor := "#f6f7f8",
      paddingHorizontal := 10,
      paddingVertical := 5
    )

    val titleText = style(fontSize := 14, fontWeight := "500")

    val descriptionText = style(fontSize := 14)

    val children = style(padding := 10)
  }

  def apply(title: String, description: String = "")(children: ReactNode*) =
    CreateElementWithChildren[Component](Props(title, description),
                                         children = children.toJSArray)

}
