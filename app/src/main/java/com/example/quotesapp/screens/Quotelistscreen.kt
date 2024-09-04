package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotesapp.R
import com.example.quotesapp.models.Quote



@Composable
fun Quotelistscreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column() {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = androidx.compose.ui.Modifier.padding(8.dp, 24.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily.Cursive
        )
        QuoteList(data = data,onClick)
    }
}