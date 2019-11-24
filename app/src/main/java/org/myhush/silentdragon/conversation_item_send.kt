package org.myhush.silentdragon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.myhush.silentdragon.chat.Message

class conversation_item_send : Fragment() {
    var msg: Message? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_conversation_item_send, container, false)
        v.findViewById<TextView>(R.id.message).text = msg?.memo
        return v
    }
}
