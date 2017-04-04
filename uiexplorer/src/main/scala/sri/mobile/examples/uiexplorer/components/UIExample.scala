package sri.mobile.examples.uiexplorer.components

import sri.core.ReactElement

trait UIExample {

  def title : String
  def description : String
  def component : () => ReactElement
}
