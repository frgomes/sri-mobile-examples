package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.mobile.examples.uiexplorer.components.ListExamplesShared.{
  ItemComponent,
  PlainInput,
  renderSmallSwitchOption
}
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.ScalaJSDefined

object FlatListExample extends UIExample {

  val VIEWABILITY_CONFIG = new ViewabilityConfig {
    override val viewAreaCoveragePercentThreshold: UndefOr[Double] = 100
    override val minimumViewTime: UndefOr[Double] = 3000
    override val waitForInteraction: UndefOr[Boolean] = true
  }

  case class State(data: js.Array[ListExamplesShared.Item],
                   filterText: String = "",
                   debug: Boolean = false,
                   horizontal: Boolean = false,
                   fixedHeight: Boolean = false,
                   logViewable: Boolean = false,
                   virtualized: Boolean = true)

  @ScalaJSDefined
  class Component extends ComponentS[State] {

    initialState(State(data = ListExamplesShared.genItemData(1000)))

    def render() = {
      val data =
        if (state.filterText.trim.isEmpty) state.data
        else
          state.data.filter(
            _.text.toLowerCase().contains(state.filterText.toLowerCase()))
      UIExplorerPage(UIExplorerPage.Props(scroll = false))(
        View(style = styles.searchRow)(
          View(style = styles.options)(
            PlainInput(placeholder = "Search...",
                       value = state.filterText,
                       onChange = searchTextChange _),
            PlainInput(placeholder = "scrollIndex..",
                       onChange = scrollIndexChange _)
          ),
          View(style = styles.options)(
            renderSmallSwitchOption(
              key = "virtualized",
              value = state.virtualized,
              onChange = (value: Boolean) =>
                setState((state: State) => state.copy(virtualized = value))),
            renderSmallSwitchOption(
              key = "horizontal",
              value = state.horizontal,
              onChange = (value: Boolean) =>
                setState((state: State) => state.copy(horizontal = value))),
            renderSmallSwitchOption(
              key = "fixedHeight",
              value = state.fixedHeight,
              onChange = (value: Boolean) =>
                setState((state: State) => state.copy(fixedHeight = value))),
            renderSmallSwitchOption(
              key = "logViewable",
              value = state.logViewable,
              onChange = (value: Boolean) =>
                setState((state: State) => state.copy(logViewable = value))),
            renderSmallSwitchOption(
              key = "debug",
              value = state.debug,
              onChange = (value: Boolean) =>
                setState((state: State) => state.copy(debug = value)))
          )
        ),
        FlatList(
          data = data,
          ref = storeListRef _,
          ListHeaderComponent = () => ListExamplesShared.HeaderComponent,
          ListFooterComponent = () => ListExamplesShared.FooterComponent,
          ItemSeparatorComponent = () => ListExamplesShared.SeparatorComponent,
          debug = state.debug,
          horizontal = state.horizontal,
          disableVirtualization = !state.virtualized,
          renderItem = renderItem _
        )
      )
    }

    var listRef: FlatListComponent.type = null

    def storeListRef(ref: FlatListComponent.type) = {
      listRef = ref
    }

    private def renderItem(info: ListItem[ListExamplesShared.Item]) =
      ItemComponent(
        ItemComponent.Props(item = info.item, onPress = pressItem _))

    private def searchTextChange(in: String) = {
      setState((state: State) => state.copy(filterText = in))
    }

    private def scrollIndexChange(in: String) = {
      if (in.trim.nonEmpty) listRef.scrollToIndex(new ScrollToIndexParams {
        override val index: Int = in.toInt
        override val viewPosition: UndefOr[Double] = 0.5
      })
    }
    private def pressItem(key: Int) = {
      println("Item pressed")
    }
  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends UniversalStyleSheet {

    val options =
      style(flexDirection = row, flexWrap = wrap, alignItems = center)
    val searchRow = style(paddingHorizontal = 0)
  }

  override def title: String = "FlatList"

  override def description: String = "Performant, scrollable list of data."
}
