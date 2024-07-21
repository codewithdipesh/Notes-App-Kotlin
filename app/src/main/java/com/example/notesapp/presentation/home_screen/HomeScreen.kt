package com.example.notesapp.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.notesapp.R
import com.example.notesapp.data.DummyNote
import com.example.notesapp.data.Screen
import com.example.notesapp.presentation.NoteViewModel
import com.example.notesapp.presentation.home_screen.elements.NoteAppBar
import com.example.notesapp.presentation.home_screen.elements.NoteCard


@Composable
fun HomeView(
    viewmodel : NoteViewModel = hiltViewModel(),
    navController: NavController
){
    Scaffold(
        topBar = {
            NoteAppBar(
                name = "Dipesh",
                //TODO NAVBUTTONCLICKED
                backgroundColor = Color.Black
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                 navController.navigate(Screen.AddScreen.route+"/0L")

            },
                modifier = Modifier.padding(20.dp),
                containerColor = colorResource(id = R.color.orange),
                ) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = "new note",
                        tint = Color.White)
            }
        },
        containerColor = Color.Black
    ) {

        val noteList = viewmodel.allNotes.collectAsState(initial = listOf())

        //Heading
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Text(
                text = "My Notes",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16.dp, bottom = 20.dp, top = 8.dp)

            )
            //TODO SCROLLABLE ROW

            LazyColumn( ){
                items(noteList.value){
                        note->
                    NoteCard(
                        note = note)
                    {

                        val id = note.id
                        navController.navigate(Screen.AddScreen.route+"/$id")
                    }
                }
            }
        }

    }


}



@Preview(showBackground = true)
@Composable
fun HomeViewPreview(){
//    HomeView()
}