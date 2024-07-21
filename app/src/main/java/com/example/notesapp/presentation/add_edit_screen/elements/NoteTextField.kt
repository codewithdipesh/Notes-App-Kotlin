package com.example.notesapp.presentation.add_edit_screen.elements

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.notesapp.R


@Composable
fun NoteTextField(
    label:String,
    value:String,
    onValueChanged : (String)-> Unit,
    maxline :Int,
    fontWeight: FontWeight,
    color: Color =Color.Black,
    fontSize: TextUnit,
    context: Context
) {
    val maxwords = 18*maxline

    Box(modifier = Modifier.fillMaxWidth()) {
        if (value.isEmpty()) {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = fontSize,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(id = R.color.light_text_label) // Hint color
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        BasicTextField(
            value = value,
            onValueChange = {//TODO allow users only to write upto 3 maxline
                   if(it.length <= maxwords ){
                       onValueChanged(it)
                   }else{
                       Toast.makeText(context,"Length of the title can't be more than ${maxwords}",Toast.LENGTH_SHORT).show()
                   }
            },
            modifier = Modifier.fillMaxWidth(),
            maxLines = maxline,
            textStyle = TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = color // Text color
            )
        )
    }


}


@Preview(showBackground = true)
@Composable

fun NoteTextFieldPreview(){
//    NoteTextField("Title","",{})
}