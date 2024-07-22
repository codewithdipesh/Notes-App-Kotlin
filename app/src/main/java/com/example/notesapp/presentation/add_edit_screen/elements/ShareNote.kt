package com.example.notesapp.presentation.add_edit_screen.elements

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager


fun ShareNote(
    context: Context,
    title : String,
    description : String
){
    val packageManager = context.packageManager
    val shareContent = "$title\n\n$description"
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, shareContent)

    }
    if(intent.resolveActivity(packageManager) != null){
         context.startActivity(Intent.createChooser(intent,"Share Note"))
    }
}