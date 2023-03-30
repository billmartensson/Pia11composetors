package se.magictechnology.pia11composetors

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.magictechnology.pia11composetors.ui.theme.Pia11composetorsTheme

@Composable
fun Fruitrow(fruit : Fruit) {
    Row(modifier = Modifier.clickable {
        Log.i("PIA11DEBUG", "CLICK ROW")
        //fruit.fruitok = false
    }) {
        Text(fruit.fruitname, modifier = Modifier.padding(5.dp))
        Column {
            Text(fruit.fruitamount.toString())
            if(fruit.fruitok) {
                Text("Är ok")
            } else {
                Text("Inte ok")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FruitPreview() {

    var pfruit = Fruit()
    pfruit.fruitname = "Apelsin"
    pfruit.fruitamount = 7
    pfruit.fruitok = false

    Pia11composetorsTheme {
        Fruitrow(pfruit)
    }
}