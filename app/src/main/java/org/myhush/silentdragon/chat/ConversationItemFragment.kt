package org.myhush.silentdragon.chat

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.content_tx_details.*
import org.myhush.silentdragon.R

enum class ConversationFragmentType{
    SEND,
    RECIVE
}

class ConversationItemFragment: Fragment() {
    var message: Message = Message()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_conversation_item, container, false)
        val msgView = v.findViewById<TextView>(R.id.message)
        Toast.makeText(v.context, "onCreateView", Toast.LENGTH_SHORT)

        msgView.text = message.content

        when (message.type){
            ConversationFragmentType.SEND -> {
                var set = ConstraintSet()

                set.clone(constraintLayout)
                set.connect(R.id.message, ConstraintSet.RIGHT, parentFragment!!.id, ConstraintSet.RIGHT, 8)
                set.connect(R.id.message, ConstraintSet.TOP, parentFragment!!.id, ConstraintSet.TOP, 8)
                set.applyTo(constraintLayout)

                msgView.background = Drawable.createFromPath("drawable/chat_background_send.xml")
            }

            ConversationFragmentType.RECIVE -> {
                var set = ConstraintSet()

                set.clone(constraintLayout)
                set.connect(R.id.message, ConstraintSet.LEFT, parentFragment!!.id, ConstraintSet.LEFT, 8)
                set.connect(R.id.message, ConstraintSet.TOP, parentFragment!!.id, ConstraintSet.TOP, 8)
                set.applyTo(constraintLayout)

                msgView.background = Drawable.createFromPath("drawable/chat_background_recive.xml")
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}