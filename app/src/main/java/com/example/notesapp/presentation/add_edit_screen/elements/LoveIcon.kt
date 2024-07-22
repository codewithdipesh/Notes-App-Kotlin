package com.example.notesapp.presentation.add_edit_screen.elements


import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.notesapp.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LoveIcon(
    isImportant : Boolean = false,
    onClick : ()-> Unit = {}
){
   var showLove by remember {
       mutableStateOf(isImportant)
   }
   var color : Color = if(showLove) Color.Red else Color.White
    
   IconButton(onClick = {
       onClick()
       showLove = !showLove
   }) {
       Icon(
           imageVector = Icons.Default.Favorite ,
           contentDescription = null,
           tint = color
       )
   }

}














@Preview(showBackground = true)
@Composable

fun LoveIconPreview(){
    LoveIcon(isImportant = true)
}