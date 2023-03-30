package se.magictechnology.pia11composetors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.magictechnology.pia11composetors.ui.theme.Pia11composetorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pia11composetorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Maincomp()
                }
            }
        }
    }
}

@Composable
fun Maincomp() {

    var errormessage = remember {
        mutableStateOf("")
    }

    var addfruitname = remember {
        mutableStateOf("")
    }
    var addfruitamount = remember {
        mutableStateOf("")
    }

    var allfruit = remember {
        mutableStateListOf<Fruit>()
    }

    Column(modifier = Modifier.padding(8.dp)) {
        if(errormessage.value != "") {
            Text(errormessage.value)
        }

        Row() {
            TextField(value = addfruitname.value, onValueChange = {
                addfruitname.value = it
            }, modifier = Modifier.width(100.dp))
            TextField(value = addfruitamount.value, onValueChange = {
                addfruitamount.value = it
            }, modifier = Modifier.width(100.dp))
            Button(onClick = {
                if(addfruitamount.value.toIntOrNull() == null) {
                    errormessage.value = "Inte siffra!!"
                } else {
                    var afruit = Fruit()
                    afruit.fruitname = addfruitname.value
                    afruit.fruitamount = addfruitamount.value.toInt()
                    afruit.fruitok = true
                    allfruit.add(afruit)
                }

            }) {
                Text("Lägg till")
            }
        }

        LazyColumn {
            items(allfruit) {
                Fruitrow(it)
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pia11composetorsTheme {
        Maincomp()
    }
}