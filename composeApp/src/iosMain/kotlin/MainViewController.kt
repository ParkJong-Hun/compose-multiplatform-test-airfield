import androidx.compose.ui.window.ComposeUIViewController
import presentation.App
import presentation.navigation.AppNavigator

@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController {
    App(appNavigator = AppNavigator())
}