package org.myhush.silentdragon.chat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.widget.TextView
import org.myhush.silentdragon.R

class ConversationActivity : AppCompatActivity() {
    var displayName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)
        findViewById<TextView>(R.id.textViewContactName2)

        displayName = intent.extras.get("displayName").toString()

        restoreChat()
        setViews()
    }

    private fun setViews() {
        findViewById<TextView>(R.id.textViewContactName2).text = displayName
    }

    private fun restoreChat(){
        val message1 = Message()
        message1.content = "  Hallo!    "
        message1.type = ConversationFragmentType.RECIVE
        message1.dateTime = 0

        addMessage(message1)

        val message2 = Message()
        message2.content = "  Wie geht es dir?        "
        message2.type = ConversationFragmentType.SEND
        message2.dateTime = 0

        //addMessage("     Wie gehts?", ConversationFragmentType.RECIVE, 0)
        //addMessage("Follow me on YouTube! <3      ", ConversationFragmentType.RECIVE, 0)
        //addMessage("   .", ConversationFragmentType.SEND, 0)
        //addMessage("f", ConversationFragmentType.SEND, 0)
    }



    private fun addMessage(message: Message){
        var memo = message.content

        while (memo.startsWith(" ") || memo.endsWith(" ")){
            memo = memo.removePrefix(" ")
            memo = memo.removeSuffix(" ")
        }

        if(!memo.isNullOrEmpty()){
            val fragTx: FragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = ConversationItemFragment()

            fragment.message = message

            fragTx.commit()
        }
    }
}
