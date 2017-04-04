package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.components._

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class UIExplorerPage extends ComponentP[UIExplorerPage.Props] {

  def render() = {
    if (props.scroll)
      ScrollView(
        style = GlobalStyles.wholeContainer,
        keyboardShouldPersistTaps = ScrollViewKeyboardPersistTaps.HANDLED,
        keyboardDismissMode = ScrollViewKeyboardDismissMode.INTERACTIVE
      )(
        children
      )
    else View(style = GlobalStyles.wholeContainer)(children)
  }

}
object UIExplorerPage {

  case class Props(scroll: Boolean = true)

  def apply(props: Props)(
      children: ReactNode*): ReactElement { type Instance = UIExplorerPage } =
    CreateElementWithChildren[UIExplorerPage](props,
                                              children = children.toJSArray)
  def apply(
      children: ReactNode*): ReactElement { type Instance = UIExplorerPage } =
    apply(Props())(children: _*)

}
