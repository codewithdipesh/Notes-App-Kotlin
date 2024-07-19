package com.example.notesapp.presentation.home_screen.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R

@Composable
fun MyCircularIcon(
    backgroundColor: Color = colorResource(id = R.color.ash) ,
    buttonColor:Color = Color.White,
    onclick:()->Unit = {},
    icon : ImageVector,
    modifier: Modifier =Modifier
){
    Box (modifier = Modifier
        .clip(CircleShape)
        .background(color = backgroundColor )
        .clickable {
            //TODO
            onclick()
        }){
       Icon(
           imageVector = icon,
           contentDescription = "Menu Button",
           tint = buttonColor,
           modifier = Modifier.padding(8.dp))
    }

}

@Preview(showBackground = true)
@Composable

fun MyOptionMenuButtonPreview(){
    MyCircularIcon(icon = Icons.Default.Menu)
}