package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotesapp.screens.Quotelistscreen
import com.example.quotesapp.screens.quotedetail
import com.example.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            datamanager.loadassetsfromfile(applicationContext)
        }
        setContent {
            app()
        }
    }
}


@Composable
fun app() {
    if (datamanager.isdataloaded.value) {
        if (datamanager.currentpage.value == Pages.LISTING) {
            Quotelistscreen(data = datamanager.data) {
                datamanager.switchpages(it)
            }
        }
            else{
            datamanager.currentquote?.let { quotedetail(quote = it) }
            }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                "Loading...",
                style = MaterialTheme.typography.headlineMedium,
                fontFamily = FontFamily.Cursive
            )
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}
