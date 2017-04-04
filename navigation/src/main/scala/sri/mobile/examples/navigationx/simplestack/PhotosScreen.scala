package sri.mobile.examples.navigationx.simplestack

import sri.navigation.{NavigationScreenComponentNoPS, NavigationScreenOptions}

import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
class PhotosScreen extends NavigationScreenComponentNoPS {

  def render() = MyNavScreen("Home Screen")
}

object PhotosScreen {
  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[PhotosScreen](
    title = "Photos"
  )
}
