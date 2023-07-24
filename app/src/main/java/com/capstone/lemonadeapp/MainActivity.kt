package com.capstone.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.capstone.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeScreen()
                }
            }
        }
    }
}

@Composable
fun LemonadeScreen(){
    var pageId by remember {
        mutableStateOf(1)
    }
    val imageSelected = when(pageId){
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        4->R.drawable.lemon_restart
        else->R.drawable.lemon_tree
    }
    val textSelected = when(pageId){
        2->"Keep Taping lemonade"
        3->"tap lemonade to drink"
        4->"tap the empty glass to start drink again"
        else->"tap the lemon on the tree"
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = textSelected)
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter =
            painterResource(id = imageSelected), contentDescription = pageId.toString(),
            Modifier.clickable { when(pageId++){
                    2->pageId = (1..5).random()
                    4->pageId = 1
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeAppTheme {
        LemonadeScreen()
    }
}