package sri.mobile.examples.uiexplorer.apis

import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.universal.apis.{AsyncStorage, AsyncStorageException}
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.async.Async.{async, await}
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import sri.core._
import sri.universal._

object AsyncStorageExample extends UIExample {

  val STORAGE_KEY = "@AsyncStorageExample:key"
  val COLORS = js.Array("red", "orange", "yellow", "green", "blue")

  case class State(selectedValue: String = COLORS.head,
                   messages: js.Array[String] = js.Array())

  class Component extends ComponentS[State] {

    initialState(State())

    def render() = {
      UIExplorerPage(
        UIExplorerBlock("Basics - getItem, setItem, removeItem")(
          ViewC(
            Picker(selectedValue = state.selectedValue,
                   onValueChange = onValueChange)(
              COLORS.map(v => PickerItem(key = v, value = v, label = v))
            ),
            TextC(
              "Selected : ",
              Text(style = styles.getColorstyle(state.selectedValue))(
                state.selectedValue)
            ),
            TextC(" "),
            Text(onPress = () => removeStorage)(
              "Press here to remove from storage"),
            TextC(" "),
            TextC("Messages : "),
            ViewC(
              state.messages.map(m => TextC(m)).asInstanceOf[ReactNode]
            )
          )
        )
      )
    }

    def appendMessage(message: String) = {
      setState(
        (state: State) => state.copy(messages = state.messages.+:(message)))
    }

    val saveError: PartialFunction[Throwable, _] = {
      case (ex: Throwable) => {
        appendMessage(
          s"AsyncStorage Error ${ex.asInstanceOf[AsyncStorageException].err.message.toString}")
      }
    }

    override def componentDidMount(): Unit = {
      async {
        val result = await(AsyncStorage.getItem(STORAGE_KEY).toFuture)
        if (result != null) {
          setState(
            (state: State) =>
              state.copy(selectedValue = result,
                         messages = js.Array(
                           s"Recovered selection from disk : ${result}")))
        } else {
          appendMessage(s"Initialized with no selection on disk")
        }
      }.recover(saveError)
    }

    val onValueChange = (selectedValue: String, position: Int) => {
      setState((state: State) => state.copy(selectedValue = selectedValue))
      async {
        val result =
          await(AsyncStorage.setItem(STORAGE_KEY, selectedValue).toFuture)
        appendMessage(s"Saved selection to disk ${selectedValue}")
      }.recover(saveError)
    }

    def removeStorage(): Unit =
      async {
        val result = await(AsyncStorage.removeItem(STORAGE_KEY).toFuture)
        appendMessage(s"Selection Removed from Disk")
      }.recover(saveError)
  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends InlineStyleSheetUniversal {
    import dsl._
    def getColorstyle(c: String) = styleUR(color := c)
  }

  override def title: String = "AsyncStorage"

  override def description: String = "Asynchronous local disk storage."
}
