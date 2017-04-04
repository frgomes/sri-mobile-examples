package sri.mobile.examples.navigationx

import sri.core
import sri.universal.apis.AppRegistry

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSImport

object MobileApp extends JSApp {

  def main() = {
    core.setReactElementType
    AppRegistry.registerComponent("navigation", () => drawerstacktab.root)
  }
}
