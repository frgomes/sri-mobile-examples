package sri.mobile.examples.uiexplorer.components

import sri.core.{ComponentP, CreateElement}
import sri.macros.OptDefault
import sri.mobile.examples.uiexplorer.images._
import sri.platform.SriPlatForm
import sri.universal._
import sri.universal.apis.StyleSheet
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce
import scala.scalajs.js.annotation.ScalaJSDefined

object ListExamplesShared {

  val LOREM_IPSUM =
    s"""
       |Lorem ipsum dolor sit amet, ius ad pertinax oportere accommodare, an vix
       |civibus corrumpit referrentur. Te nam case ludus inciderint, te mea facilisi adipiscing. Sea id
       |integre luptatum. In tota sale consequuntur nec. Erat ocurreret mei ei. Eu paulo sapientem
       |vulputate est, vel an accusam intellegam interesset. Nam eu stet pericula reprimique, ea vim illud
       |modus, putant invidunt reprehendunt ne qui.;
     """.stripMargin

  @ScalaJSDefined
  trait Item extends js.Object {
    val title: String
    val key: Int
    val text: String
    val pressed: js.UndefOr[Boolean] = js.undefined
    val noImage: js.UndefOr[Boolean] = js.undefined
  }

  def genItemData(count: Int): js.Array[Item] = {
    (0 to count)
      .map(i => {
        val itemHash = js.Math.abs(hashCode2(s"Item $i"))
        new Item {
          override val text: String =
            LOREM_IPSUM.substring(0, itemHash % 301 + 20)
          override val key: Int = i
          override val pressed: js.UndefOr[Boolean] = false
          override val title: String = s"Item $i"
        }.asInstanceOf[Item]
      })
      .toJSArray
  }
  val SEPARATOR_HEIGHT = StyleSheet.hairlineWidth

  val SeparatorComponent = View(style = styles.separator)(null)

  val HeaderComponent = View(
    View(style = styles.headerFooter)(
      Text("LIST HEADER")
    ),
    SeparatorComponent
  )

  val FooterComponent = View(
    SeparatorComponent,
    View(style = styles.headerFooter)(Text("LIST FOOTER")))

  val THUMB_URLS = js.Array(LikeImage,
                            DislikeImage,
                            CallImage,
                            FistImage,
                            BandagedImage,
                            FlowersImage,
                            HeartImage,
                            LikingImage,
                            PartyImage,
                            PokeImage,
                            SuperLikeImage,
                            VictoryImage)

  val HORIZ_WIDTH = 200

  @ScalaJSDefined
  class ItemComponent extends ComponentP[ItemComponent.Props] {

    def render() = {
      val itemHash = js.Math.abs(hashCode2(props.item.title))
      val imageSource: js.Any = THUMB_URLS(itemHash % THUMB_URLS.length)
      TouchableHighlight(
        onPress = () => props.onPress(props.item.key),
        style = if (props.horizontal) styles.horizItem else styles.item)(
        View(
          style =
            if (props.horizontal)
              js.Array(styles.itemRow,
                       UniversalStyleSheet.style(width = HORIZ_WIDTH,
                                                 registerStyle = false))
            else styles.itemRow)(
          if (props.item.noImage.isEmpty)
            Image(style = styles.thumb, sourceDynamic = imageSource)
          else null,
          Text(style = styles.text,
               numberOfLines =
                 if (props.horizontal || props.fixedHeight) 3 else OptDefault)(
            s"${props.item.title} - ${props.item.text}"
          )
        )
      )
    }

  }

  object ItemComponent {
    case class Props(fixedHeight: Boolean = false,
                     horizontal: Boolean = false,
                     item: Item,
                     onPress: Int => Unit)
    def apply(props: Props) = CreateElement[ItemComponent](props)
  }

  def hashCode2(str: String): Int = {
    var hash = 15
    (str.length - 1 to (0, -1)).foreach(i => {
      hash = (hash << 5 - hash) + str.charAt(i).toInt
    })
    hash
  }

  @inline
  def PlainInput(placeholder: String,
                 value: js.UndefOr[String] = js.undefined,
                 onChange: String => _) = {
    TextInput(
      autoCapitalize = TextInputAutoCapitalize.NONE,
      autoCorrect = false,
      clearButtonMode = "always",
      underlineColorAndroid = "transparent",
      style = styles.searchTextInput,
      placeholder = placeholder,
      value = value,
      onChangeText = onChange
    )
  }

  @inline
  def renderSmallSwitchOption(key: String,
                              value: Boolean,
                              onChange: Boolean => _) = {
    View(style = styles.option)(
      Text(key),
      Switch(style = styles.smallSwitch,
             value = value,
             onValueChange = onChange)
    )
  }

  object styles extends UniversalStyleSheet {
    val headerFooter = style(
      height = 30,
      width = 100,
      alignSelf = "center",
      alignItems = "center",
      justifyContent = "center"
    )
    val horizItem = style(
      alignSelf = "flex-start" // Necessary for touch highlight
    )
    val item = style(
      flex = 1
    )
    val option = style(
      flexDirection = "row",
      padding = 8,
      paddingRight = 0
    )
    val itemRow = style(
      flexDirection = "row",
      padding = 10,
      backgroundColor = "#F6F6F6"
    )
    val searchTextInput = style(
      backgroundColor = "white",
      borderColor = "#cccccc",
      borderRadius = 3,
      borderWidth = 1,
      paddingLeft = 8,
      paddingVertical = 0,
      height = 26,
      fontSize = 14,
      flexGrow = 1
    )
    val separator = style(
      height = SEPARATOR_HEIGHT,
      backgroundColor = "gray"
    )
    val smallSwitch =
      if (SriPlatForm.isAndroid)
        style(
          top = 1,
          margin = -6
          //        transform = [{scale = 0.7}]
        )
      else
        style(
          top = 4,
          margin = -10
          //        transform = [{scale = 0.5}]
        )
    val stacked = style(
      alignItems = "center",
      backgroundColor = "#F6F6F6",
      padding = 10
    )
    val thumb = style(
      width = 64,
      height = 64
    )
    val stackedText = style(
      padding = 4,
      fontSize = 18
    )
    val text = style(
      flex = 1
    )
  }

}
