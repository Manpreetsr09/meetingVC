package man.run2.mymeetingapp

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoginPage(
){
    var meetingId by remember { mutableStateOf("")
    }

    var username by remember { mutableStateOf("")
    }
    val context = LocalContext.current
    Column( 
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.my_background))
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)){
            Text(text = "Easy Meet",
            modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                textAlign = TextAlign.Center,
                )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White)
            .padding(32.dp)
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                OutlinedTextField(
                    value = meetingId,
                    onValueChange ={
                       if (it.length <= 10)
                        meetingId = it },
                    label = { Text(text = "Meeting Id")},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    )
                    )
                OutlinedTextField(
                    value = username,
                    onValueChange ={
                            username = it },
                    label = { Text(text = "your name")},
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    enabled = meetingId.length ==10 && username .length >= 3,
                    onClick = {
                        val intent = Intent(context, ConfrenceActivity :: class.java)
                        intent.putExtra("MEETING_ID",meetingId)
                        intent.putExtra("USERNAME", username)
                        context.startActivity(intent)

                    }
                , modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.my_background)
                    )) {
                    Text(text = "Join  Metting")
                }
                Button(
                    enabled = username.length >= 3,
                    onClick = {
                              var RandomMeetingID =
                                  (1..10).map{(0..9)
                                      .random()}.joinToString ("")

                              val intent = Intent(context, ConfrenceActivity :: class.java)
                        intent.putExtra("MEETING_ID",RandomMeetingID)
                              intent.putExtra("USERNAME", username)
                              context.startActivity(intent)
                              }
                    , modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.my_background)
                    )) {
                    Text(text = "Create  Me")
                }

            }
        }
    }
    
}