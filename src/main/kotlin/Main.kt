import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Color

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showInicio by remember { mutableStateOf(true) }
        if (showInicio) {
            Inicio{showInicio = false}
        } else {
            SegundaPantalla()
        }
    }
}

@Composable
fun Inicio(changeShowInicio: () -> Unit){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Esta es la pantalla de inicio")
        Button(
            onClick = changeShowInicio,
            colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color(0xff9b88f6))
        ){
            Text(
                text = "Continuar",
                color = androidx.compose.ui.graphics.Color.Red
            )
        }
    }

}

@Composable
fun SegundaPantalla(){
    val textos: MutableList<String> = mutableListOf(
        "Prueba1",
        "Prueba2",
        "Prueba3",
        "Prueba4"
    )
    LazyColumn {
        items(textos){ texto->
            Tarjeta(texto)
        }
    }
}

@Composable
fun Tarjeta(texto: String = ""){
    var expanded by rememberSaveable { mutableStateOf(0.dp) }
    var isExpanded by remember { mutableStateOf(false) }
    val animationPadding by
    animateDpAsState(
        if (isExpanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow                )
    )
    val currentPadding = animationPadding.coerceAtLeast(0.dp)
    Card(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        backgroundColor = androidx.compose.ui.graphics.Color(0xffdee3ff),
        elevation = 2.dp,
        shape = MaterialTheme.shapes.small,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = currentPadding)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = texto
            )
            Button(
                onClick = {
                    if (isExpanded) {
                        expanded = 0.dp
                        isExpanded = !isExpanded
                    } else{
                        expanded = 120.dp
                        isExpanded = !isExpanded
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color(0xff9b88f6))
            ){
                Text(
                    text = (if (isExpanded) "Show less" else "Show more"),
                    color = androidx.compose.ui.graphics.Color.White
                )
            }
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
