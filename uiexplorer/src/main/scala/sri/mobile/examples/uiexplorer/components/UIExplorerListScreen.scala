package sri.mobile.examples.uiexplorer.components

import org.scalajs.dom
import sri.core.ReactElement
import sri.mobile.examples.uiexplorer.apis._
import sri.mobile.examples.uiexplorer.apis.android._
import sri.mobile.examples.uiexplorer.components.android._
import sri.mobile.examples.uiexplorer.components.ios._
import sri.navigation.NavigationScreenComponentS
import sri.platform.SriPlatform
import sri.universal._
import sri.universal.apis.PixelRatio
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.|

class UIExplorerListScreen
    extends NavigationScreenComponentS[UIExplorerListScreen.State] {
  import UIExplorerListScreen._
  initialState(State())
  dom.window.console.log(
    s"hello",
    json(componenets = finalComponentsList, apis = finalAPIList))

  def render() = {
    View(style = styles.listContainer)(
      View(style = styles.searchRow)(
        TextInput(
          autoCapitalize = TextInputAutoCapitalize.NONE,
          autoCorrect = false,
          clearButtonMode = "always",
          onChangeText = handleSearchTextChange _,
          placeholder = "Search ..",
          style = styles.searchTextInput
        )
      ),
      ListView(style = styles.list,
               dataSource = state.datasource,
               renderRow = renderRow _,
               renderSectionHeader = renderSectionHeader _)
    )
  }

  def onPressRow(example: UIExample): Unit = {
    navigation.navigate[UIExplorerDetailsScreen](new Params {
      override val component: () => ReactElement = example.component
      override val title: String = example.title
    })
  }

  def handleSearchTextChange(text: String): Unit = {
    val filter = (e: UIExample) =>
      e.title.toLowerCase.contains(text.toLowerCase.trim)
    val filteredComponents = finalComponentsList.filter(filter)
    val filteredAPIS = finalAPIList.filter(filter)
    setState(
      (state: State) =>
        state.copy(datasource = ds.cloneWithRowsAndSections(
          json(componenets = filteredComponents, apis = filteredAPIS))))
  }

  def renderRow(example: UIExample,
                sectionID: String | Int,
                rowId: String | Int,
                highlightRow: js.Function2[String | Int, String | Int, _]) = {
    View(key = example.title)(
      TouchableHighlight(onPress = () => onPressRow(example))(
        View(style = styles.listRow)(
          Text(style = styles.rowTitleText)(
            example.title
          ),
          Text(style = styles.rowDetailText)(
            example.description
          )
        )
      ),
      View(style = styles.separator)()
    )
  }

  def renderSectionHeader(data: Any, sectionID: String) = {
    View(style = styles.sectionHeader)(
      Text(style = styles.sectionHeaderTitle)(
        sectionID.toString.toUpperCase
      )
    )
  }

}

object UIExplorerListScreen {

  val COMPONENTS: List[UIExample] = List(
    ViewExample,
    KeyboardAvoidingViewExample,
    TouchableExample,
    TextInputExample,
    ButtonExample,
    AnimatedExample,
    SliderExample,
    SwitchExample,
    RefreshControlExample,
    FlatListExample,
    SectionListExample,
//    LayoutEventsExample,
    ActivityIndicatorExample
    //    NavigatorExample
  )

  val IOS_COMPONENTS: List[UIExample] = List(
    SegmentedControlExample,
    ScrollViewExample,
    ModalExample,
    WebViewExample
  )

  val ANDROID_COMPONENTS: List[UIExample] =
    List(ToolbarAndroidExample, ScrollViewSimpleExample)

  val APIS: List[UIExample] = List(
    AlertExample,
    GeolocationExample,
    LinkingExample,
    AsyncStorageExample,
    AppStateExample

    //    NetInfoExample
  )

  val IOS_APIS: List[UIExample] = List(
    )

  val ANDROID_APIS: List[UIExample] = List(ToastAndroidExample)

  def getComponents() = {
    if (SriPlatform.isIOS) {
      COMPONENTS.++(IOS_COMPONENTS).toJSArray
    } else COMPONENTS.++(ANDROID_COMPONENTS).toJSArray
  }

  def getAPIs() = {
    if (SriPlatform.isIOS) {
      APIS.++(IOS_APIS).toJSArray
    } else APIS.++(ANDROID_APIS).toJSArray
  }

  val finalComponentsList = getComponents()

  val finalAPIList = getAPIs()

  val ds = createListViewDataSource(
    rowHasChanged = (r1: UIExample, r2: UIExample) => r1 != r2,
    sectionHeaderHasChanged = (h1: String, h2: String) => h1 != h2)

  case class State(
      datasource: ListViewDataSource[UIExample, String] =
        ds.cloneWithRowsAndSections(
          json(componenets = finalComponentsList, apis = finalAPIList)))

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val listContainer = style(
      flex := 1
    )
    val list = style(
      backgroundColor := "#eeeeee"
    )
    val sectionHeader = style(
      padding := 5
    )
    val group = style(
      backgroundColor := "white"
    )
    val sectionHeaderTitle = style(
      fontWeight := "500",
      fontSize := 11
    )
    val listRow = style(
      backgroundColor := "white",
      justifyContent.center,
      paddingHorizontal := 15,
      paddingVertical := 8
    )
    val separator = style(
      height := 1.0 / PixelRatio.get(),
      backgroundColor := "#bbbbbb",
      marginLeft := 15
    )
    val rowTitleText = style(
      fontSize := 17,
      fontWeight := "500"
    )
    val rowDetailText = style(
      fontSize := 15,
      color := "#888888",
      lineHeight := 20
    )
    val searchRow = style(
      backgroundColor := "#eeeeee",
      padding := 10
    )
    val searchTextInput = style(
      backgroundColor := "white",
      borderColor := "#cccccc",
      borderRadius := 3,
      borderWidth := 1,
      height := 40,
      paddingLeft := 8
    )
  }

}
