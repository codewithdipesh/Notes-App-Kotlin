package com.example.notesapp.presentation.home_screen.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import com.example.notesapp.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.ui.theme.customFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppBar(
    name:String = "",
    onBackNavClicked:()->Unit = {},
    menuButtonClicked:()->Unit = {},
    backgroundColor : Color = Color.Black
){
    val navigationIcon : (
            @Composable () -> Unit
    ) = if(name.isEmpty()){
        {
            MyCircularIcon(
                icon = Icons.Default.KeyboardArrowLeft,
                backgroundColor = colorResource(id = R.color.light_gray),
                buttonColor = Color.Black,
                onclick = onBackNavClicked
            )
        }
    }else{
        {
            MyCircularIcon(
                icon = Icons.Default.AccountCircle,
                backgroundColor = Color.White,
                buttonColor = Color.DarkGray,
                onclick = {
                    //TODO IMAGE CLICK
                }
            )
        }
    }

    val menuButton :(
            @Composable () -> Unit
    ) = if(name.isEmpty()){
        {
            MyCircularIcon(
                icon = Icons.Default.Menu,
                backgroundColor = colorResource(id = R.color.light_gray),
                buttonColor = Color.Black,
                onclick = menuButtonClicked
            )
        }
    }else{
        {
            MyCircularIcon(
                icon = Icons.Default.Menu,
                backgroundColor = colorResource(id = R.color.ash),
                buttonColor = Color.White,
                onclick = menuButtonClicked
            )
        }
    }

    TopAppBar(
        title = {
            if(name.isNotEmpty()){
                    //TODO pROFILE iMAGE
                    Text(
                        text = "Hi,$name",
                        modifier = Modifier
                            .padding(4.dp)
                            .heightIn(max=30.dp),
                        color = Color.White,
                        style =MaterialTheme.typography.bodyLarge
                        )
            }else{
                null
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor
        ),
        navigationIcon = navigationIcon
        ,
        actions = {
            menuButton()
        },

    )


}


@Preview(showBackground = true)
@Composable

fun NoteAppBarPreview(){
    NoteAppBar(name = "Dipesh")
}