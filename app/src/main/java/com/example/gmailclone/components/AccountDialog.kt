package com.example.gmailclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.gmailclone.R

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>){
    Dialog(
        onDismissRequest = { openDialog.value = false }
    ){
        AccountDialogUI()
    }
}



@Composable
fun AccountDialogUI(modifier: Modifier = Modifier){
    Card() {
        Column (
            modifier
                .background(Color.White)
                .padding(bottom = 15.dp),
            ){


            Row(modifier.fillMaxWidth().padding(bottom = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier
                        .weight(2.0f)
                        .padding(start = 5.dp, top = 5.dp), horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = "Account Dialog",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                        )
                }
                Column{
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        modifier.padding(top=5.dp, end = 8.dp).clickable {  })
                }

            }

            Divider()


            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_mail_24),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)

                )

                Column(
                    modifier
                        .weight(2.0f)
                        .padding(start = 15.dp, bottom = 15.dp)) {
                    Text(text = "Gmail UI With Kotlin", fontWeight = FontWeight.SemiBold)
                    Text(text = "nickforbizz@gmail.com")
                }
                Text(text = "99+", modifier = Modifier.padding(end=15.dp))
            }

            Divider()


            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp),
                horizontalArrangement = Arrangement.Center) {

                Card(
                    modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.Gray)
                    ) {
                    Text(text = "Google Account", Modifier.padding(8.dp), textAlign = TextAlign.Center)
                }
            }
        }
    }
}



@Preview
@Composable
fun AccountDialogUIPreview(){
    AccountDialogUI()
}