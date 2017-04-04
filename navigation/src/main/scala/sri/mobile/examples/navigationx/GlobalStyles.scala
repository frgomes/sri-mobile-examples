package sri.mobile.examples.navigationx

import sri.platform.SriPlatForm
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js

object GlobalStyles extends UniversalStyleSheet {
  val sampleText =
    style(margin = 14, shadowOffset = js.Dynamic.literal(height = 10))
  val navScreenContainer = style(marginTop = if (SriPlatForm.isIOS) 20 else 0)
}
