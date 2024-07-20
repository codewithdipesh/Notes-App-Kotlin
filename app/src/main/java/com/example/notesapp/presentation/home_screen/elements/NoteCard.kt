package com.example.notesapp.presentation.home_screen.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.data.Note
import com.example.notesapp.utils.toColor

@Composable
fun NoteCard(note : Note,onClick:()-> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = note.color.toColor()
        ),
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "${note.title}",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${note.description}",
                maxLines = 5,
                color = Color.DarkGray)

        }
    }

}

@Preview(showBackground = true)
@Composable

fun NoteCardPreview(){
    NoteCard(note = Note(1
        ,"Tax Payment Before the march ",
        "the hiudg gf3fu3hfo3f 3fof"),{})
}








