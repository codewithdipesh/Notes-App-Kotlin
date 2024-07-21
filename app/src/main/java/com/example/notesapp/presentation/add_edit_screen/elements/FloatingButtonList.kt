package com.example.notesapp.presentation.add_edit_screen.elements

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import com.example.notesapp.utils.toColor


@Composable
fun FloatingActionButtonList(
    onClickButton:()-> Unit
){

        Row (
            modifier = Modifier
                .background(
                    colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(50.dp)
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            ChooseColorButton(color = colorResource(id = R.color.button_blue))
            Spacer(modifier = Modifier.width(2.dp))
            ChooseColorButton(color = colorResource(id = R.color.button_red))
            Spacer(modifier = Modifier.width(2.dp))
            ChooseColorButton(color = colorResource(id = R.color.button_green))
            Spacer(modifier = Modifier.width(2.dp))
            ChooseColorButton(color = colorResource(id = R.color.button_yellow))
            Spacer(modifier = Modifier.width(2.dp))
            IconButton(onClick = {
                //TODO
                                 onClickButton()
            },
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Black, CircleShape)
                    .padding()

            ) {
                Icon(
                    imageVector = Icons.Default.Create , 
                    contentDescription = null,
                    tint = Color.White)
            }
        }

}


@Preview(showBackground = true)
@Composable

fun FloatingActionButtonListPreview(){
//    FloatingActionButtonList()
}