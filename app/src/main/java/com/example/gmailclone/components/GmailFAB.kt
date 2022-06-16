package com.example.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp


@Composable
fun GmailFAB(scrollState: ScrollState){

    if (scrollState.value > 50){
        ExtendedFloatingActionButton(
            text = { Text(text = "Compose", fontSize = 15.sp) },
            icon = { Icon(imageVector = Icons.Default.Edit, contentDescription = "edit fab") },
            backgroundColor = MaterialTheme.colors.surface,
            onClick = { /*TODO*/ })
    }else{
        FloatingActionButton(
            backgroundColor = MaterialTheme.colors.surface,
            onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "edit fab")
        }
    }

}