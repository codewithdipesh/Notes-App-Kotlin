package com.example.notesapp.presentation.add_edit_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesapp.data.Note
import com.example.notesapp.presentation.NoteViewModel
import com.example.notesapp.presentation.add_edit_screen.elements.NoteTextField
import com.example.notesapp.presentation.home_screen.elements.NoteAppBar
import com.example.notesapp.utils.toArgbInt
import com.example.notesapp.utils.toColor
import kotlinx.coroutines.flow.collect

@Composable
fun AddorEditScreen(
    id:Long,
    viewModel: NoteViewModel = hiltViewModel(),
    navController: NavHostController
){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(id){
        if(id != 0L){
            viewModel.getNoteById(id).collect{note->
                viewModel.titleState = note.title
                viewModel.descriptionState = note.description
                viewModel.colorState = note.color
                viewModel.isImportantState = note.isImportant
            }
        }else{
            viewModel.titleState = ""
            viewModel.descriptionState = ""
            viewModel.colorState = Color.LightGray.toArgbInt()
            viewModel.isImportantState = false

        }

    }

    val containerColor by remember { derivedStateOf { viewModel.colorState.toColor() } }

    Scaffold (
        topBar = {
            NoteAppBar(
                "",
                {
                    //TODO BACK BUTTON
                },
                {
                    //TODO MENU BUTTON
                },
                backgroundColor = viewModel.colorState.toColor()
                )
        },
        containerColor = containerColor

    ){
        Surface (modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            Column(modifier =Modifier.padding(16.dp)) {
                NoteTextField(
                    label = "Title",
                    value = viewModel.titleState,
                    onValueChanged = { viewModel.onNoteTitleChanged(it) },
                    maxline = 3,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    context = context
                )
                Spacer(modifier = Modifier.height(16.dp))
                NoteTextField(
                    label = "Description",
                    value = viewModel.descriptionState,
                    onValueChanged = { viewModel.onNoteDescriptionChanged(it) },
                    maxline = 3,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    context = context
                )
            }
        }
    }



}