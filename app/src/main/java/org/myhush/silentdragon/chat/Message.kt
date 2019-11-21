package org.myhush.silentdragon.chat

class Message {
    var content: String = ""
    var dateTime: Long = 0
    var type: ConversationFragmentType = ConversationFragmentType.SEND
}