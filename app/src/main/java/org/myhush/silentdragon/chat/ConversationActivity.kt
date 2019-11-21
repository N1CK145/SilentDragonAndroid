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
    var messages = HashMap<Boolean, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        findViewById<TextView>(R.id.textViewContactName2)
        displayName = intent.extras.get("displayName").toString()

        restoreChat()
    }

    private fun restoreChat(){
        addMessage("Lorem Ipsum", true)
        addMessage("Lorem Ipsum", true)
        addMessage("Lorem Ipsum", false)
        addMessage("Lorem Ipsum", true)
    }



    fun addMessage(message: String, recived: Boolean){
        val fragTx: FragmentTransaction = supportFragmentManager.beginTransaction()

        if(recived){
            val fragment = conversation_item_recive()
            fragment.message.text = message
            fragTx.add(R.id.MessageList, fragment)

        }else{
            val fragment = conversation_item_send()
            fragment.message.text = message
            fragTx.add(R.id.MessageList, fragment)
        }
        fragTx.commit()
    }
}
