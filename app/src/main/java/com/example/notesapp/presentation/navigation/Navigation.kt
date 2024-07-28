package com.example.notesapp.presentation.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.MainActivity
import com.example.notesapp.data.Screen
import com.example.notesapp.presentation.NoteViewModel
import com.example.notesapp.presentation.add_edit_screen.AddorEditScreen
import com.example.notesapp.presentation.home_screen.HomeView

@Composable
fun Navigation (
    viewModel : NoteViewModel,
    navController: NavHostController = rememberNavController(),
    sharedText :String?
) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeView(viewModel,navController)
        }
        composable(Screen.AddScreen.route+"/{id}",
            arguments = listOf(
               navArgument("id"){
                   type = NavType.LongType
                   nullable = false
                   defaultValue = 0L
               }
            )
        ){entry->
            val id = if(entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddorEditScreen(id = id, navController =navController, viewModel = viewModel , sharedText = sharedText)
        }
    }

    sharedText?.let {
        navController.navigate(Screen.AddScreen.route + "/0")
    }

}