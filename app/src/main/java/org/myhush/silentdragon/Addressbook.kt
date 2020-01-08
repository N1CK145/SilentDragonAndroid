package org.myhush.silentdragon

import org.myhush.silentdragon.chat.Message

object Addressbook {
    class Contact {
        var fullname = ""
        var nickname = ""
        var address = ""
        val messageList = ArrayList<Message>()

        constructor(fullname: String, nickname: String) {
            this.fullname = fullname
            this.nickname = nickname
        }

        constructor(fullname: String, nickname: String, address: String) {
            this.fullname = fullname
            this.nickname = nickname
            this.address = address
        }
    }

    val contactList = ArrayList<Contact>()

    fun addContact(fullname: String, nickname: String) {
        contactList.add(Contact(fullname, nickname))
    }

    fun addContact(fullname: String, nickname: String, address: String) {
        contactList.add(Contact(fullname, nickname, address))
    }

    fun addContact(contact: Contact){
        contactList.add(contact)
    }

    fun findContactByAddress(address: String): Contact? {
        contactList.forEach {
            if(it.address == address)
                return it
        }
        return null
    }
    fun clear() {
        contactList.clear()
    }
}