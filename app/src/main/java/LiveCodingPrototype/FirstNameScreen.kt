package LiveCodingPrototype

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import LiveCodingPrototype.Person

//list
val Persons = mutableStateListOf<Person>()

@Composable
fun FirstNameScreen(){
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top= 30.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            TextField(
                value = text,
                onValueChange = {text = it},
                label = {Text ("Enter your name")},
                modifier = Modifier.weight(1f)
            )
            Button(onClick = {
                val CleanedSpace = text.trim().replaceFirstChar { it.uppercase() }
                if(CleanedSpace.isNotBlank()) {
                    Persons.add(Person(CleanedSpace))
                    text = ""
                }
            })
            {
                Text("Add")
            }
        }
        Persons.forEach { p ->
            Text("👤 ${p.name}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
