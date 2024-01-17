package com.example.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var quotelist : List<MyDataItem>
    var pos : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var quote =findViewById<TextView>(R.id.title)
        var author = findViewById<TextView>(R.id.author)
        var nxt = findViewById<ImageView>(R.id.right)
        var back =findViewById<ImageView>(R.id.left)

        ApiCall().getRandomQuotes { listquote ->
            if(listquote != null){
                quotelist =  listquote
                quote.text = quotelist.get(0).text
                author.text = "~ "+quotelist.get(0).author
            }
            else{
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        }

        nxt.setOnClickListener {
            nxtQuote(quote,author)
        }

        back.setOnClickListener {
            prevQuote(quote,author)
        }
    }



    fun nxtQuote(quote:TextView, author:TextView){
        if(pos<quotelist.size && pos>=0){
            pos++;
            quote.text = quotelist[pos].text
            author.text ="~ "+ quotelist[pos].author
        } else{
            Toast.makeText(this@MainActivity,"You are on the first Page",Toast.LENGTH_SHORT).show()
        }
    }
    fun prevQuote(quote:TextView, author:TextView){
        if(pos<quotelist.size && pos>0){
            pos--;
            quote.text= quotelist[pos].text
            author.text="~ "+ quotelist[pos].author
        } else{
            Toast.makeText(this@MainActivity,"You are on the first Page",Toast.LENGTH_SHORT).show()
        }
    }
}