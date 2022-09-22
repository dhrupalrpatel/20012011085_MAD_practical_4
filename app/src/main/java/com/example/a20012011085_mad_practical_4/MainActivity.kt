package com.example.a20012011085_mad_practical_4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    lateinit var btn_ref_browser:Button
    lateinit var btn_ref_map:Button
    lateinit var btn_ref_sendmsg:Button
    lateinit var btn_ref_call:Button
    lateinit var btn_ref_set:Button
    lateinit var textInputLayoutWeb:TextInputLayout
    lateinit var textInputLayoutMap:TextInputLayout
    lateinit var textInputLayoutSendMessage:TextInputLayout
    lateinit var textInputLayoutCall:TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ref_browser = findViewById(R.id.button)
        btn_ref_map = findViewById(R.id.button2)
        btn_ref_sendmsg = findViewById(R.id.button3)
        btn_ref_call = findViewById(R.id.button4)
        btn_ref_set = findViewById(R.id.button5)

        textInputLayoutWeb=findViewById(R.id.textInputLayoutWeb)
        textInputLayoutMap=findViewById(R.id.textInputLayoutMap)
        textInputLayoutSendMessage=findViewById(R.id.textInputLayoutSendMessage)
        textInputLayoutCall=findViewById(R.id.textInputLayoutCall)

        implicit_intent();
    }

    fun implicit_intent() {
        btn_ref_browser.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse(textInputLayoutWeb.editText?.text.toString())).also {
                startActivity(it)
            }
        }
        btn_ref_map.setOnClickListener {
            val addresses_url: Uri = Uri.parse("geo:0,0?q=" + textInputLayoutMap.editText?.text.toString())
            val it = Intent(Intent.ACTION_VIEW, addresses_url)
            startActivity(it)
        }
        btn_ref_sendmsg.setOnClickListener {
            val uri=Uri.parse("smsto:7383294044")
            val intent=Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body",textInputLayoutSendMessage.editText?.text.toString())
            startActivity(intent)
        }
        btn_ref_call.setOnClickListener{
            val intent=Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:"+textInputLayoutCall.editText?.text.toString()))
            startActivity(intent)
        }
        btn_ref_set.setOnClickListener {
            val intent=Intent(AlarmClock.ACTION_SET_ALARM)
            intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Test Alarm")
            intent.putExtra(AlarmClock.EXTRA_HOUR,8)
            intent.putExtra(AlarmClock.EXTRA_MINUTES,30)
            startActivity(intent)
        }

    }

}