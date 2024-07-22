package com.example.notesapp.presentation.add_edit_screen.elements

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.notesapp.presentation.NoteViewModel


@Composable
fun DropDownMenuOptions(
    expanded : Boolean,
    onDismissRequest :() -> Unit,
    onDelete:()->Unit,
    modifier: Modifier = Modifier
){
   DropdownMenu(
       expanded = expanded ,
       onDismissRequest = onDismissRequest,
       modifier =modifier)
   {
       DropdownMenuItem(
           text = {
                  DropDownOption(text = "Share Note" , icon = Icons.Default.Share)
                  },
           onClick = {
              //TODO SHARE NOTE
           }
       )

       DropdownMenuItem(
           text = {
               DropDownOption(text = "Delete" ,
                   icon = Icons.Default.Delete ,
                   iconColor = Color.Red,
                   color = Color.Red)
           },
           onClick = {
              onDelete()
           }
       )

   }
}



@Composable
fun DropDownOption(
    text : String,
    color : Color = Color.Black,
    icon : ImageVector,
    iconColor : Color = Color.Black
){
    Row (modifier = Modifier.padding(4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = icon ,
            contentDescription = null,
            tint = iconColor
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = color
        )


    }
}