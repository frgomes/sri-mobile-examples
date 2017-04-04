package sri.mobile.examples.navigationx.simplestack

import sri.navigation.{
  NavigationScreenComponent,
  NavigationScreenComponentNoPS,
  NavigationScreenOptions
}

import scala.scalajs.{LinkingInfo, js}
import scala.scalajs.js.annotation.{JSExportStatic, JSImport, ScalaJSDefined}

@ScalaJSDefined
class HomeScreen extends NavigationScreenComponentNoPS {

  def render() = MyNavScreen("Home Screen1")
}

object HomeScreen {
  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[HomeScreen](
    title = "Home"
  )
}
