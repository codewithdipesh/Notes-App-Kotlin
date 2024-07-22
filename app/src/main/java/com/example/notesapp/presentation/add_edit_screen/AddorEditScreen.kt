package com.example.notesapp.presentation.add_edit_screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.notesapp.data.Note
import com.example.notesapp.presentation.NoteViewModel
import com.example.notesapp.presentation.add_edit_screen.elements.DropDownMenuOptions
import com.example.notesapp.presentation.add_edit_screen.elements.FloatingActionButtonList
import com.example.notesapp.presentation.add_edit_screen.elements.LoveIcon
import com.example.notesapp.presentation.add_edit_screen.elements.NoteTextField
import com.example.notesapp.presentation.add_edit_screen.elements.ShareNote
import com.example.notesapp.presentation.home_screen.elements.NoteAppBar
import com.example.notesapp.utils.toArgbInt
import com.example.notesapp.utils.toColor
import kotlinx.coroutines.flow.collect

@Composable
fun AddorEditScreen(
    id:Long,
    viewModel: NoteViewModel = hiltViewModel(),
    navController: NavController
){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var snackMessage by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(id){
        if(id != 0L){
            viewModel.getNoteById(id).collect{note->
                //thats check is helpfful when deleting any note and it gives error beacuse it tries to access null note
                if(note != null){
                    viewModel.titleState = note.title
                    viewModel.descriptionState = note.description
                    viewModel.colorState = note.color
                    viewModel.isImportantState = note.isImportant
                }else{
                    navController.navigateUp()
                }

            }
        }
        else{
            viewModel.titleState = ""
            viewModel.descriptionState = ""
            viewModel.colorState = Color.Gray.toArgbInt()
            viewModel.isImportantState = false

        }

    }

    val containerColor = remember(viewModel.colorState) {
        viewModel.colorState.toColor()
    }

    Scaffold (
        topBar = {
                NoteAppBar(
                    "",
                    {
                        navController.navigateUp()
                    },
                    {
                        expanded = !expanded
                    },
                    backgroundColor = containerColor
                )

        },
        floatingActionButton = {
            FloatingActionButtonList(onClickButton = {
                //check input is empty or not
                if(viewModel.titleState.isEmpty() || viewModel.descriptionState.isEmpty()){
                    if(viewModel.titleState.isEmpty()){
                        snackMessage = "Title can't be empty"
                        Toast.makeText(context,snackMessage,Toast.LENGTH_SHORT).show()
                    }else if(viewModel.descriptionState.isEmpty()){
                        snackMessage = "Description can't be empty"
                        Toast.makeText(context,snackMessage,Toast.LENGTH_SHORT).show()
                    }
                }else{
                    if(id != 0L){
                        //update a note
                        viewModel.updateNote(Note(
                            id = id,
                            title = viewModel.titleState.trim(),
                            description = viewModel.descriptionState.trim(),
                            color = viewModel.colorState,
                            isImportant = viewModel.isImportantState
                        )
                        )

                    }else{
                        //Add a new Note
                        viewModel.addNote(Note(
                            title = viewModel.titleState.trim(),
                            description = viewModel.descriptionState.trim(),
                            color = viewModel.colorState,
                            isImportant = viewModel.isImportantState
                        ))
                    }

                    navController.navigateUp()
                }



            },
                onClickColor = {
                    viewModel.onColorStateChanged(it)
                })
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = containerColor

    ){
//        Text(text = "Text",modifier =Modifier.padding(it))
        Surface (modifier = Modifier
            .fillMaxSize()
            .padding(it),
            color = containerColor
        ){
            Box(modifier = Modifier
                .fillMaxSize() //TODO FIX MENU POSITION
                .padding(end = 16.dp, top = 16.dp, start = 250.dp),
                contentAlignment = Alignment.TopEnd
                ){
                DropDownMenuOptions(
                    expanded = expanded,
                    onDismissRequest = {expanded = false},
                    onDelete = {
                        //TODO CHANGE TO  DELETE BY ID
                        viewModel.deleteNote(Note(
                            id = id,
                            title = viewModel.titleState.trim(),
                            description = viewModel.descriptionState.trim(),
                            color = viewModel.colorState,
                            isImportant = viewModel.isImportantState
                        )
                        )
                        expanded = false
                        navController.navigateUp()
                    },
                    onShare = {
                        ShareNote(
                            context = context,
                            title = viewModel.titleState,
                            description = viewModel.descriptionState
                        )
                        expanded = false
                    }

                )
            }

            Column(modifier =Modifier.padding(start = 20.dp, bottom = 20.dp, end = 20.dp, top = 10.dp)) {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(2.dp),
                    contentAlignment = Alignment.TopEnd

                )
                {
                    LoveIcon(isImportant = viewModel.isImportantState){
                        //change the state
                        viewModel.onImportantStateChanged(!viewModel.isImportantState)
                    }
                }
                NoteTextField(
                    label = "Title",
                    value = viewModel.titleState,
                    onValueChanged = { viewModel.onNoteTitleChanged(it) },
                    maxline = 3,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    context = context
                )
                Spacer(modifier = Modifier.height(12.dp))
                HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
                Spacer(modifier = Modifier.height(12.dp))
                NoteTextField(
                    label = "Description",
                    value = viewModel.descriptionState,
                    onValueChanged = { viewModel.onNoteDescriptionChanged(it) },
                    maxline = 100,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    context = context
                )
            }
        }
    }



}
