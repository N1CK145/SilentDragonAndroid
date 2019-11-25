package org.myhush.silentdragon.chat

object Addressbook {
    class Contact {
        var addressList: ArrayList<String> = ArrayList()
        val messageList: ArrayList<Message> = ArrayList()
        var fullname = ""
        var nickname = ""

        constructor(fullname: String, nickname: String){
            this.fullname = fullname
            this.nickname = nickname
        }
        constructor(fullname: String, nickname: String, address: String){
            this.fullname = fullname
            this.nickname = nickname
            this.addressList.add(address)
        }
        constructor(fullname: String, nickname: String, addressList: ArrayList<String>){
            this.fullname = fullname
            this.nickname = nickname
            this.addressList = addressList
        }
    }

    val contactList = ArrayList<Contact>()
}