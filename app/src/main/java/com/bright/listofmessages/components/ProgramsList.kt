package com.bright.listofmessages.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bright.listofmessages.data.Program
import com.bright.listofmessages.ui.theme.Padding

@Composable
fun ProgramsList(programs : List<Program>, itemView: @Composable (Program) -> Unit){
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(Padding.medium)
    ){
        items(programs) {program -> itemView(program) }
    }
}