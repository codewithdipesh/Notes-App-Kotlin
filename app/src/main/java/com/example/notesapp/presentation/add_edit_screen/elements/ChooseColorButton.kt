package com.example.notesapp.presentation.add_edit_screen.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import androidx.compose.ui.unit.sp


@Composable
fun ChooseColorButton(
    color: Color,
    onColorChanged : (Color) -> Unit
) {
    Box(modifier = Modifier
        .clip(CircleShape)
        .size(50.dp)
        .background(color)
        .clickable {
            //TODO click color
            onColorChanged(color)

        }
        .border(BorderStroke(1.dp,Color.Black), CircleShape)
    )
}


@Preview
@Composable

fun ChooseColorButtonPreview(){
//    ChooseColorButton(color = colorResource(id = R.color.button_red))
}