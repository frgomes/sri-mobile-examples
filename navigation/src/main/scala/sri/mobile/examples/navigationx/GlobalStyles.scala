package sri.mobile.examples.navigationx

import sri.platform.SriPlatform
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js

object GlobalStyles extends InlineStyleSheetUniversal {

  import dsl._

  val sampleText =
    style(margin := 14, shadowOffset := js.Dynamic.literal(height = 10))
  val navScreenContainer = style(
    marginTop := (if (SriPlatform.isIOS) 20 else 0))

  def dynamicColor(c: String) = styleUR(color := c)
}
