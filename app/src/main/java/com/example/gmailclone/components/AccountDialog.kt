package com.example.gmailclone.components

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailclone.R
import com.example.gmailclone.models.GmailDialogData
import com.example.gmailclone.otherMailsData

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>){
    Dialog(
        onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false)
    ){
        AccountDialogUI(openDialog= openDialog)
    }
}



@Composable
fun AccountDialogUI(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>){
    Card {
        Column (
            modifier
                .background(Color.White)
                .padding(bottom = 15.dp),
            ){


            Row(
                modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp), verticalAlignment = Alignment.CenterVertically) {
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
                        modifier
                            .padding(top = 5.dp, end = 8.dp)
                            .clickable { openDialog.value = false })
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



            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp),
                horizontalArrangement = Arrangement.Center) {

                Card(
                    modifier.requiredWidth(220.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.Gray)
                    ) {
                    Text(text = "Google Account", Modifier.padding(8.dp), textAlign = TextAlign.Center)
                }
            }

            Divider(modifier = Modifier.padding(top=15.dp, bottom = 15.dp))


            Column {
                otherMailsData.forEach{
                    item -> OtherGmailAccount(item)
                }
            }

            Column(modifier = Modifier.padding(top=15.dp)) {
                AddAccount(icon = Icons.Outlined.ManageAccounts, "Manage Account.")
                AddAccount(icon = Icons.Default.PersonAddAlt, "Add Another Account.")
            }

            Divider(modifier = Modifier.padding(top=15.dp, bottom = 15.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier.padding(top=10.dp).size(3.dp),
                    backgroundColor = Color.Black
                ){}
                Text(text = "Terms of Service")
            }

        }
    }
}


@Composable
fun OtherGmailAccount(gmailAccount: GmailDialogData){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 8.dp, bottom = 8.dp)
    ){
        Card(modifier = Modifier
            .padding(top = 8.dp, end = 8.dp)
            .size(40.dp)
            .clip(CircleShape),
            backgroundColor = Color.LightGray
        ) {
            Text(text = gmailAccount.name[0].toString(), textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp))
        }

        Column(modifier = Modifier
            .weight(2.0f)
            .padding(start = 8.dp)) {
            Text(text = gmailAccount.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = gmailAccount.myEmailText, fontSize = 15.sp)
        }

        Column(modifier = Modifier.padding(5.dp)) {
            val countEmails = gmailAccount.emailCount
            if (countEmails > 99){
                Text(text = "99+")
            }else {
                Text(text = "$countEmails")
            }

        }



    }
}


@Composable
fun AddAccount(icon: ImageVector, title:String){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, bottom = 2.dp)
    ){
        IconButton(
            onClick = { /*TODO*/ }) {
            Icon(imageVector = icon, contentDescription = title, modifier=Modifier.padding(bottom=8.dp))
        }
        Text(text = title, fontWeight = FontWeight.SemiBold,  modifier=Modifier.padding(top=8.dp))
    }
}



@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountDialogUIPreview(){
    AccountDialogUI(openDialog = mutableStateOf(false))
}