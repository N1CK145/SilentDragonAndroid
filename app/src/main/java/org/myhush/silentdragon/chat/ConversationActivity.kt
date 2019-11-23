package org.myhush.silentdragon.chat

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_conversation_item_send.*
import org.myhush.silentdragon.R
import org.myhush.silentdragon.conversation_item_recive
import org.myhush.silentdragon.conversation_item_send

class ConversationActivity : AppCompatActivity() {
    var displayName = ""
    var messages: ArrayList<Message> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        displayName = intent.extras.get("displayName").toString()

        restoreChat()
    }

    private fun restoreChat(){
        val m1 = Message("Test", "XXXXX", "YYYYYY", 99999999)
        //attachMessage(m1)
    }



    fun attachMessage(message: Message){
        val fragTx: FragmentTransaction = supportFragmentManager.beginTransaction()

        when (message.messageType){
            MessageType.SEND -> {
                val fragment = conversation_item_send()
                fragment.message.text = message.memo
                fragTx.add(R.id.MessageList, fragment)
            }

            MessageType.RECIEVE -> {
                val fragment = conversation_item_recive()
                fragment.message.text = message.memo
                fragTx.add(R.id.MessageList, fragment)
            }
        }
        fragTx.commit()
    }
}
