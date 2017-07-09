package sri.mobile.examples.uiexplorer.apis

import sri.core.{Component, CreateElement, CreateElementSFNoP}
import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.universal.apis.AppState
import sri.universal.components._

import scala.scalajs.js

object AppStateExample extends UIExample {

  class AppStateSubscription
      extends Component[AppStateSubscription.Props, AppStateSubscription.State] {
    import AppStateSubscription._
    initialState(State())

    def render() = ViewC(
      if (props.state) TextC(state.appState)
      else TextC(state.previousAppSates.mkString(","))
    )

    val handleAppStateChange = (appState: String) => {
      setState((state: State) =>
        state.copy(appState, state.previousAppSates.+:(appState)))
    }

    override def componentDidMount(): Unit =
      AppState.addEventListener("change", handleAppStateChange)

    override def componentWillUnmount(): Unit =
      AppState.removeEventListener("change", handleAppStateChange)
  }
  object AppStateSubscription {

    case class State(appState: String = AppState.currentState.get,
                     previousAppSates: js.Array[String] = js.Array())

    case class Props(state: Boolean)
    def apply(state: Boolean,
              key: String = null,
              ref: js.Function1[AppStateSubscription, Unit] = null) =
      CreateElement[AppStateSubscription](Props(state), key = key, ref = ref)

  }

  val Component = () => {
    UIExplorerPage(
      UIExplorerBlock("AppState.currentState")(
        TextC(AppState.currentState.get)
      ),
      UIExplorerBlock("Subscribed AppState:")(
        AppStateSubscription(true)
      ),
      UIExplorerBlock("Previous states:")(
        AppStateSubscription(false)
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  override def title: String = "AppState"

  override def description: String = "app background status"
}
