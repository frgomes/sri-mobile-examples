package sri.mobile.examples.uiexplorer.components

import sri.core.{ComponentS, CreateElementNoPropsWithChildren, ReactNode}
import sri.universal.apis.InteractionManager
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav

object UIExplorerPageLazyLoad {

  case class State(isLoading: Boolean = true)

  class Component extends ComponentS[State] {

    initialState(State())

    def render() = {
      if (state.isLoading)
        View(style = styles.spinner)(
          ActivityIndicator(size = ActivityIndicatorSize.LARGE,
                            color = "black"))
      else
        ScrollView(
          style = GlobalStyles.wholeContainer,
          keyboardShouldPersistTaps = ScrollViewKeyboardPersistTaps.HANDLED,
          keyboardDismissMode = ScrollViewKeyboardDismissMode.INTERACTIVE
        )(
          children
        )
    }

    override def componentDidMount(): Unit = {
      InteractionManager.runAfterInteractions(() => {
        setState((state: State) => state.copy(isLoading = false))
      })
    }
  }

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val spinner =
      style(justifyContent.center, alignItems.center, marginTop := 40)
  }

  def apply(children: ReactNode*) =
    CreateElementNoPropsWithChildren[Component](children = children.toJSArray)

}
