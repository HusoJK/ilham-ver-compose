package com.example.inspire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspire.ui.theme.InspireTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InspireTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val ilhamlar = listOf(
        "Aç kal, akılsız kal.",
        "Yaratıcılık, şeyleri birbirine bağlamaktır.",
        "Kaliteli iş çıkarmak, hiç bitmeyen bir öğrenme sürecidir.",
        "Bazen hayat sizi tuğlayla kafanıza vuracak. İnancınızı kaybetmeyin.",
        "Başkalarının gürültüsünün kendi iç sesinizi bastırmasına izin vermeyin.",
        "Büyük işler yapmanın tek yolu, yaptığınız işi sevmektir.",
        "Yenilik, lideri takipçiden ayırt eder.",
        "Tasarım sadece nasıl göründüğü değil, nasıl çalıştığıdır.",
        "Odaklanmak, hayır demektir.",
        "En iyi reklamcılık iyi bir üründür."
    )

var index by remember { mutableStateOf(0) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "İLHAM VER") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.main_color),
                    titleContentColor = colorResource(R.color.white)
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        painter = painterResource(R.drawable.stevejobs), contentDescription = ""
                    )
                    Text(
                        text = "STEVE JOBS",
                        fontSize = 22.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }

                Text(
                    modifier = Modifier.padding(20.dp),
                    textAlign = TextAlign.Center,
                    text = ilhamlar[index]
                )

                Button(
                    onClick = {
                        index = ilhamlar.indices.random()
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "İLHAM VER")
                }

            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InspireTheme {
        MainScreen()
    }
}