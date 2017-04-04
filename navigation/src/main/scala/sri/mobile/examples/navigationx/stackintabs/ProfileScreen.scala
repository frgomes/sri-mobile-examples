package sri.mobile.examples.navigationx.stackintabs

import sri.navigation.NavigationScreenOptionsImplicits._
import sri.navigation._
import sri.universal.components._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
trait ProfileParams extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

@ScalaJSDefined
class ProfileScreen extends NavigationScreenComponent[ProfileParams, Null] {
  def render() =
    MyNavScreen(s"${if (params.get.mode.exists(_ == "edit")) "Now Editing"
    else ""} ${params.get.name.getOrElse("")}")
}

object ProfileScreen {
//    implicit def ftoJSF1[R,T <: js.Object](
//                             in: scala.Function1[NavigationScreenProp[NavigationRoute[T]], R])
//    : OptionalParam[NavigationScreenOption2[R,T]] = {
//      in: js.Function1[NavigationScreenProp[NavigationRoute[T]], R]
//    }
  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[ProfileScreen](
    title = "Profile",
    header = ((navigation: NavigationScreenProp[ProfileParams]) => {
      HeaderConfig(
        title = navigation.state.params.get.name.getOrElse("").toString,
        right = Button(
          title =
            if (navigation.state.params.get.mode.exists(_ == "edit")) "Done"
            else "Edit",
          onPress = () =>
            navigation.setParams(new ProfileParams {
              override val mode: js.UndefOr[String] =
                if (navigation.state.params.get.mode.exists(_ == "edit")) ""
                else "edit"
            })
        )
      )
    })
  )
}
