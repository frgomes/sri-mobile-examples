package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
package object simplestack {

  val root = StackNavigator(registerScreen[HomeScreen],
                            registerScreen[PhotosScreen],
                            registerScreen[ProfileScreen])
}
