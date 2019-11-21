package org.myhush.silentdragon.chat

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.myhush.silentdragon.R

class ChatItemFragment : Fragment() {
    var firstName: String = ""
    var lastName: String = ""
    var lastMessage: String = "No messages..."
    var v: View? = null

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        v = inflater.inflate(R.layout.fragment_chat_item, container, false)

        updateData()
        initListener()
        return v!!
    }

    private fun initListener() {
        v?.setOnClickListener {
            val intent = Intent(activity, ConversationActivity::class.java)
            startActivity(intent)
        }
    }

    fun updateData(){
        v!!.findViewById<TextView>(R.id.textViewContactName).text = "$firstName $lastName"
        v!!.findViewById<TextView>(R.id.textViewLastMessage).text = lastMessage
    }


}