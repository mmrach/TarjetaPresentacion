package com.example.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.primary)
        .fillMaxHeight()
    ){
        LogoSection(
            logoId = R.drawable.android_logo,
            name ="Miguel O. Martínez Rach",
            cargo = "Desarrollador Jetpack Compose Android",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        )
        // Adding a Spacer of height 20dp
        //Spacer(modifier = Modifier.height(100.dp))
        InfoSection(
            phone = "+34 666 66 66 66",
            social = "@mmrach",
            email = "mmrach@mail.com",
            modifier = Modifier.padding(bottom = 20.dp).fillMaxHeight()
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun LogoSection(
    name: String = "Name",
    logoId: Int? = null,
    cargo:String = "Developer",
    modifier: Modifier,
){
    val logo: Painter =  painterResource(id = logoId ?: R.drawable.image_placeholder )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Image(
            painter = logo,
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
        )
        Text(
            text=name,
            color=MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text=cargo,
            color= Color.Green,
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun InfoSection(
    email:String="",
    phone:String="",
    social:String="",
    modifier: Modifier
){
    Column(
        modifier = modifier, // = Modifier.fillMaxSize().padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Bottom
    ){
        Divider(color = MaterialTheme.colorScheme.onPrimary, thickness = 1.dp)
        Row(Modifier
            .padding(start = 50.dp, top=10.dp, bottom = 10.dp)
        ){
            Icon(Icons.Rounded.Phone,contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
            Text(
                text= phone,
                color= MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Divider(color = MaterialTheme.colorScheme.onPrimary, thickness = 1.dp)
        Row(Modifier
            .padding(start = 50.dp, top=10.dp, bottom = 10.dp)
        ){
            Icon(Icons.Rounded.Share,contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
            Text(
                text= social,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Divider(color = MaterialTheme.colorScheme.onPrimary, thickness = 1.dp)
        Row(Modifier
            .padding(start = 50.dp, top=10.dp, bottom = 10.dp)
        ){
            Icon(Icons.Rounded.Email,contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)
            Text(
                text= email,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Divider(color = MaterialTheme.colorScheme.onPrimary, thickness = 1.dp)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TarjetaPresentacionTheme {
        Surface {
            MainContent()
        }
    }
}