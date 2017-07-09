package sri.mobile.examples.uiexplorer.components.android

import sri.core._
import sri.mobile.components.android.{
  ToolbarAndroid,
  ToolbarAndroidAction,
  ToolbarAndroidActionShow
}
import sri.mobile.examples.uiexplorer.components.{
  UIExample,
  UIExplorerBlock,
  UIExplorerPage
}
import sri.mobile.examples.uiexplorer.images._
import sri.universal.components._
import sri.universal.styles.InlineStyleSheetUniversal

import scala.scalajs.js

object ToolbarAndroidExample extends UIExample {

  override val title: String = "ToolbarAndroid"

  override val description: String = "Examples of using the Android toolbar"

  val toolbarActions = js.Array(
    ToolbarAndroidAction(title = "Create",
                         icon = CreateImage,
                         show = ToolbarAndroidActionShow.ALWAYS),
    ToolbarAndroidAction(title = "Filter"),
    ToolbarAndroidAction(title = "Settings",
                         icon = SettingImage,
                         show = ToolbarAndroidActionShow.ALWAYS)
  )

  case class State(actionText: String = "Example app with toolbar component",
                   toolbarSwitch: Boolean = false,
                   titleColor: String = "#3b5998",
                   subtitleColor: String = "#6a7180")

  class Component extends ComponentS[State] {

    initialState(State())

    def render() = {
      UIExplorerPage(
        UIExplorerBlock("Toolbar with title/subtitle and actions")(
          ToolbarAndroid(
            actions = toolbarActions,
            style = styles.toolbar,
            title = "Toolbar",
            navIconDynamic = BlackMenuImage,
            onActionSelected = onActionSelected _,
            subtitle = state.actionText
          )(),
          TextC(state.actionText)
        ),
        UIExplorerBlock(
          "Toolbar with logo & custom title view (a View with Switch+Text)")(
          ToolbarAndroid(logoDynamic = LauncherImage, style = styles.toolbar)(
            View(style = styles.view1)(
              Switch(value = state.toolbarSwitch,
                     onValueChange = handleSwitchChange _),
              TextC(s"a switch")
            )
          )
        ),
        UIExplorerBlock("Toolbar with no icon")(
          ToolbarAndroid(actions = toolbarActions,
                         style = styles.toolbar,
                         subtitle = "there is no icon here")()
        ),
        UIExplorerBlock("Toolbar with navIcon & logo, no title")(
          ToolbarAndroid(actions = toolbarActions,
                         style = styles.toolbar,
                         logoDynamic = LauncherImage,
                         navIconDynamic = BlackMenuImage)()
        ),
        UIExplorerBlock("Toolbar with custom title colors")(
          ToolbarAndroid(
            style = styles.toolbar,
            navIconDynamic = BlackMenuImage,
            title = "Wow such a toolbar",
            subtitle = "Much Native",
            subtitleColor = state.subtitleColor,
            titleColor = state.titleColor
          )(),
          TextC(
            "Touch the icon to reset the custom colors to the default (theme-provided) ones.")
        )
      )
    }

    def onActionSelected(position: Int) = {
      val text = toolbarActions(position).title
      setState((state: State) => state.copy(actionText = text))
    }

    def handleSwitchChange(value: Boolean) = {
      setState((state: State) => state.copy(toolbarSwitch = value))
    }

  }

  val component = () => CreateElementNoProps[Component]()

  object styles extends InlineStyleSheetUniversal {

    import dsl._

    val toolbar = style(backgroundColor := "#e9eaed", height := 56)

    val view1 =
      style(height := 56, flexDirection.row, alignItems.center)
  }

}
