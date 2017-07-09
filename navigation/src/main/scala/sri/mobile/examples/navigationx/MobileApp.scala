package sri.mobile.examples.navigationx

import sri.universal.apis.AppRegistry

import scala.scalajs.js.JSApp

object MobileApp {

  def main(args: Array[String]) = {
    AppRegistry.registerComponent("navigation", () => simplestack.root)
  }
}
