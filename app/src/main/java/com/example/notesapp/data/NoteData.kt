package com.example.notesapp.data


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.R
import com.example.notesapp.utils.toArgbInt
import java.util.Date

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo("note_title")
    val title:String = "",
    @ColumnInfo("note_description")
    val description:String = "",
    @ColumnInfo("note_isImportant")
    val isImportant:Boolean = false,
    @ColumnInfo("note_color")
    val color: Int = Color.Gray.toArgbInt()
)


object DummyNote{
    val noteList = listOf(
        Note(1,"Tax payment before th end of march","Lorem ipsum dolor sit amet, consectetur adipisicing elit. At atque aut autem commodi ea eius eum expedita facere fugiat libero maiores neque nobis nulla, odio optio perferendis praesentium quae quaerat qui quidem quis quos, ratione sapiente, sequi sunt. Aspernatur commodi et officiis quaerat quam quasi soluta. Consectetur debitis labore porro."),
        Note(1,"Tax payment before th end of march","Lorem ipsum dolor sit amet, consectetur adipisicing elit. At atque aut autem commodi ea eius eum expedita facere fugiat libero maiores neque nobis nulla, odio optio perferendis praesentium quae quaerat qui quidem quis quos, ratione sapiente, sequi sunt. Aspernatur commodi et officiis quaerat quam quasi soluta. Consectetur debitis labore porro."),
        Note(1,"Password WIFI gelato cafe near the stattion","Lorem ipsum dolor sit amet, consectetur adipisicing elit. At atque aut autem commodi ea eius eum expedita facere fugiat libero maiores neque nobis nulla, odio optio perferendis praesentium quae quaerat qui quidem quis quos, ratione sapiente, sequi sunt. Aspernatur commodi et officiis quaerat quam quasi soluta. Consectetur debitis labore porro."),
        Note(1,"Password WIFI gelato cafe near the stattion","Lorem ipsum dolor sit amet, consectetur adipisicing elit. At atque aut autem commodi ea eius eum expedita facere fugiat libero maiores neque nobis nulla, odio optio perferendis praesentium quae quaerat qui quidem quis quos, ratione sapiente, sequi sunt. Aspernatur commodi et officiis quaerat quam quasi soluta. Consectetur debitis labore porro.")
    )
}