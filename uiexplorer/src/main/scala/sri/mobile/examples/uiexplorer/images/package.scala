package sri.mobile.examples.uiexplorer

import sri.universal.AssetLoader

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object images {

  def LikeImage =
    AssetLoader
      .require[js.Dynamic]("../images/thumbnails/like.png")

  def DislikeImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/dislike.png")

  def CallImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/call.png")

  def FistImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/fist.png")

  def BandagedImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/bandaged.png")

  def FlowersImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/flowers.png")

  def HeartImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/heart.png")

  def LikingImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/liking.png")

  def PartyImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/party.png")

  def PokeImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/poke.png")

  def SuperLikeImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/superlike.png")

  def VictoryImage =
    AssetLoader.require[js.Dynamic]("../images/thumbnails/victory.png")

  def CreateImage =
    AssetLoader.require[js.Dynamic]("../images/ic_create_black_48dp.png")

  def SettingImage =
    AssetLoader.require[js.Dynamic]("../images/ic_settings_black_48dp.png")

  def BlackMenuImage =
    AssetLoader.require[js.Dynamic]("../images/ic_menu_black_24dp.png")

  def LauncherImage =
    AssetLoader.require[js.Dynamic]("../images/launcher_icon.png")

  def AndroidSearchWhiteImage =
    AssetLoader.require[js.Dynamic]("../images/android_search_white.png")

  def AndroidBackWhiteImage =
    AssetLoader.require[js.Dynamic]("../images/android_back_white.png")
}
