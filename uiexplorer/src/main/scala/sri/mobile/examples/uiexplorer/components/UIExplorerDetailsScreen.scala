package sri.mobile.examples.uiexplorer.components

import sri.core.ReactElement
import sri.navigation.NavigationScreenComponent
import sri.universal.components._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
trait Params extends js.Object {
  val title: String
  val component: () => ReactElement
}
@ScalaJSDefined
class UIExplorerDetailsScreen extends NavigationScreenComponent[Params, Null] {

  def render() = View(style = GlobalStyles.wholeContainer)(
    params.get.component()
  )

}
