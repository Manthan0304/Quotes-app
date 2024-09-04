package com.example.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.models.Quote
import com.google.gson.Gson

object datamanager {
    var data = emptyArray<Quote>()
    var currentquote: Quote? = null
    var currentpage = mutableStateOf(Pages.LISTING)
    var isdataloaded = mutableStateOf(false)
    fun loadassetsfromfile(context: Context){
        val inputStream = context.assets.open("quotes js.json")
        val size:Int=inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isdataloaded.value = true
    }

    fun switchpages(quote: Quote?){
        if (currentpage.value == Pages.LISTING){
            currentquote = quote
            currentpage.value = Pages.DETAIL
        }else{
            currentpage.value = Pages.LISTING
        }
    }
}