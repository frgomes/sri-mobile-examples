package sri.mobile.examples.uiexplorer.components

import sri.core._
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet
import sri.universal.{ReactEvent, TextInputEvent}

import scala.scalajs.js
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.annotation.ScalaJSDefined

object TextInputExample extends UIExample {

  object WithLabel {

    @ScalaJSDefined
    class Component extends ComponentP[String] {

      def render() = {
        View(style = styles.labelContainer, key = props)(
          View(style = styles.label, key = "lab")(
            Text(key = "tex")(
              props
            )
          ),
          children
        )
      }
    }

    def apply(label: String, key: String = null)(children: ReactNode*) =
      CreateElementWithChildren[Component](label,
                                           key = key,
                                           children = children.toJSArray)
  }

  object TextEventsExample {

    case class State(curText: String = "No Event",
                     prevText: String = "No Event")

    @ScalaJSDefined
    class Component extends ComponentS[State] {

      initialState(State())

      def render() = View(
        TextInput(
          autoCapitalize = TextInputAutoCapitalize.NONE,
          placeholder = "Enter text to see events",
          autoCorrect = false,
          onFocus = (e: ReactEvent[TextInputEvent]) => upDateTex("onFocus"),
          onBlur = (e: ReactEvent[TextInputEvent]) => upDateTex("onBlur"),
          onChange = (e: ReactEvent[TextInputEvent]) =>
            upDateTex(s"onChange text ${e.nativeEvent.text}"),
          onEndEditing = (e: ReactEvent[TextInputEvent]) =>
            upDateTex(s"onEndEditing text ${e.nativeEvent.text}"),
          onSubmitEditing = (e: ReactEvent[TextInputEvent]) =>
            upDateTex(s"onSubmitEditing text ${e.nativeEvent.text}"),
          style = styles.default
        ),
        Text(style = styles.eventLabel)(
          state.curText,
          s"\n prev : ${state.prevText}"
        )
      )

      def upDateTex(text: String) = {
        setState((state: State) => state.copy(text, state.curText))
      }

      def handleInputEvent(e: ReactEvent[TextInputEvent]) = {}
    }

    def apply(key: String = null, ref: js.Function1[Component, Unit] = null) =
      CreateElementNoProps[Component](key = key, ref = ref)

  }

  val Component = () => {
    UIExplorerPage(
      UIExplorerBlock("Auto-focus")(
        TextInput(autoFocus = true, style = styles.default)
      ),
      UIExplorerBlock("Auto-capitalize")(
        View(
          WithLabel("none")(
            TextInput(autoCapitalize = TextInputAutoCapitalize.NONE,
                      key = "none",
                      style = styles.default)),
          WithLabel("sentences")(
            TextInput(autoCapitalize = TextInputAutoCapitalize.SENTENCES,
                      key = "sentences",
                      style = styles.default)),
          WithLabel("words")(
            TextInput(autoCapitalize = TextInputAutoCapitalize.WORDS,
                      key = "words",
                      style = styles.default)),
          WithLabel("characters")(
            TextInput(autoCapitalize = TextInputAutoCapitalize.CHARACTERS,
                      key = "chars",
                      style = styles.default))
        )
      ),
      UIExplorerBlock("Event handling")(
        TextEventsExample()
      ),
      UIExplorerBlock("Auto-correct")(
        View(
          WithLabel("true")(
            TextInput(autoCorrect = true,
                      key = "none",
                      style = styles.default)),
          WithLabel("false")(
            TextInput(autoCorrect = false,
                      key = "none",
                      style = styles.default))
        )
      ),
      UIExplorerBlock("Clear button mode")(
        View(
          WithLabel("never")(
            TextInput(clearButtonMode = "never",
                      key = "never",
                      style = styles.default)),
          WithLabel("while editing")(
            TextInput(clearButtonMode = "while-editing",
                      key = "sentences",
                      style = styles.default)),
          WithLabel("unless editing")(
            TextInput(clearButtonMode = "unless-editing",
                      key = "unless-editing",
                      style = styles.default)),
          WithLabel("always")(
            TextInput(clearButtonMode = "always",
                      key = "chars",
                      style = styles.default))
        )
      )
    )
  }

  val component = () => CreateElementSFNoP(Component)

  object styles extends UniversalStyleSheet {

    val page = style(paddingBottom = 30)

    val default = style(height = 26,
                        borderWidth = 0.5,
                        borderColor = "#0f0f0f",
                        flex = 1,
                        fontSize = 13)

    val multiline = style(borderWidth = 0.5,
                          borderColor = "#0f0f0f",
                          flex = 1,
                          fontSize = 13,
                          height = 50)

    val label = style(width = 120,
                      justifyContent = "flex-end",
                      flexDirection = "row",
                      marginRight = 10,
                      paddingTop = 2)

    val eventLabel = style(margin = 3, fontSize = 12)

    val labelContainer =
      style(flexDirection = "row", marginVertical = 2, flex = 1)

  }

  override def title: String = "TextInput"

  override def description: String = "Single line text inputs"
}
