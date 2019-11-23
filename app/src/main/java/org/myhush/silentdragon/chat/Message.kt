package org.myhush.silentdragon.chat

enum class MessageType{
    SEND,
    RECIEVE
}

class Message {
    var memo = ""
    var fromAddress = ""
    var toAddress = ""
    var messageType = MessageType.SEND
    var dateTime: Long = 0

    constructor(memo: String, toAddress: String, fromAddress: String){
        this.memo = memo
        this.fromAddress = fromAddress
    }
    constructor(memo: String, toAddress: String, fromAddress: String, dateTime: Long){
        this.memo = memo
        this.fromAddress = fromAddress
        this.dateTime = dateTime
    }
}