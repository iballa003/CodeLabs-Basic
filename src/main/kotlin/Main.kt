import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Color

@Composable
@Preview
fun App() {
    MaterialTheme {

            myApp()

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
    Text(
        text = "Welcome to the basic codelab",
        modifier = modifier
    )
    Button(onClick = {}){
        Text(text = "Continue")
    }
    }
}

@Composable
fun Greeting2(name : String, modifier: Modifier = Modifier){
    Surface(color = MaterialTheme.colors.primary, modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier.padding(4.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = name)
                Button(
                    onClick = { /* TODO */ },
                ) {
                    Text("Show more")
                 }
            }
        }
    }
}

@Composable
fun myApp(modifier: Modifier = Modifier){
    val lista : List<String> = listOf("Prueba1","Prueba2","Prueba3","Prueba4","Prueba5")
    Column(modifier.padding(vertical = 4.dp)) {
        lista.forEach { item ->
            Greeting2(item)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        title = "jetpack compose basics",
        state = rememberWindowState(width = 800.dp, height = 800.dp)
        ) {
        App()
    }
}
