package org.myhush.silentdragon.chat

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.FragmentTransaction
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_conversation.*
import org.myhush.silentdragon.*
import java.time.LocalDateTime
import java.util.*

class ConversationActivity : AppCompatActivity() {
    var displayName = ""
    var contact: Addressbook.Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        val address = intent.extras.getString("contactAddress")

        displayName = intent.extras.getString("displayName")
        contact = Addressbook.findContactByAddress(address)


        findViewById<TextView>(R.id.textViewContactName2).text = displayName
        findViewById<TextView>(R.id.textView_zAddress).text = contact?.address

        buttonSend.setOnClickListener{
            sendMessage()
        }

        restoreChat()
    }

    private fun sendMessage(){
        // TODO
        //val memo = findViewById<TextView>(R.id.userInput).text.toString()
    }

    private fun restoreChat() {
        contact?.messageList?.asReversed()?.forEach {
            attachMessage(it)
        }
    }

    fun attachMessage(message: Message){
        val fragTx: FragmentTransaction = supportFragmentManager.beginTransaction()

        when (message.messageType){
            MessageType.SEND -> {
                val fragment = conversation_item_send()
                fragment.msg = message
                fragTx.add(R.id.MessageList, fragment)
            }

            MessageType.RECIEVE -> {
                val fragment = conversation_item_recive()
                fragment.msg = message
                fragTx.add(R.id.MessageList, fragment)
            }
        }
        fragTx.commit()
    }
}
