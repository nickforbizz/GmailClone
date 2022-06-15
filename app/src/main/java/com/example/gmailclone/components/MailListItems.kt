package com.example.gmailclone.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.mailListData
import com.example.gmailclone.models.MailData


@Composable
fun MailListItems (paddingValues: PaddingValues){
    
    Box(modifier = Modifier.padding(paddingValues)){
        LazyColumn(modifier= Modifier
            .fillMaxSize()
            .padding(16.dp) ){

            items(mailListData){
                mailData -> 
                    MailItem(mailData = mailData)
            }
        }
    }
}


@Composable
fun MailItem (mailData: MailData){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ){
        Card(modifier = Modifier
            .padding(top = 8.dp, end = 8.dp)
            .size(40.dp)
            .clip(CircleShape),
            backgroundColor = Color.LightGray
            ) {
            Text(text = mailData.username[0].toString(), textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp))
        }
        
        Column(modifier = Modifier.weight(2.0f)) {
            Text(text = mailData.username, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = mailData.subject, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(text = mailData.body, fontSize = 14.sp)
        }
        
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = mailData.timestamp)
            IconButton(
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 15.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "favorites")
            }
        }
    }
}




@Preview
@Composable
fun MailItemPreview(){
//    MailItem(mailData = MailData(
//        id=1,
//        username= "Njoro wa Leah",
//        subject = "AM available to guide on water hatchement",
//        body="What we do is allow our users to work at any time with the ideas that are of bennefiy to them",
//        timestamp = "20:01"
//    ))
}