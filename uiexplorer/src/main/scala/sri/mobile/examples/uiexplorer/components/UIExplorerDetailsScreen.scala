package sri.mobile.examples.uiexplorer.components

import sri.core.ReactElement
import sri.navigation.NavigationScreenOptionsImplicits._
import sri.navigation.{
  NavigationRoute,
  NavigationScreenComponent,
  NavigationScreenOptions,
  NavigationScreenProp
}
import sri.universal.components._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

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

object UIExplorerDetailsScreen {
  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[UIExplorerDetailsScreen](
    title = (navigation: NavigationScreenProp[Params]) => {
      navigation.state.params.get.title
    }
  )
}
