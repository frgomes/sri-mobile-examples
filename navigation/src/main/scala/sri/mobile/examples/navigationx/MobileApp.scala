package sri.mobile.examples.navigationx

import sri.universal.apis.AppRegistry

object MobileApp {

  def main(args: Array[String]) = {
    AppRegistry.registerComponent("navigation", () => simplestack.root)
  }
}
