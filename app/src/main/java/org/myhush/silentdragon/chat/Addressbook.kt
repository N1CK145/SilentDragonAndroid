package org.myhush.silentdragon.chat

object Addressbook {
    class Contact {
        var addressList: ArrayList<String> = ArrayList()
        val messageList: ArrayList<Message> = ArrayList()
        var firstName = ""
        var lastName = ""

        constructor(firstName: String, lastName: String){
            this.firstName = firstName
            this.lastName = lastName
        }
        constructor(firstName: String, lastName: String, address: String){
            this.firstName = firstName
            this.lastName = lastName
            this.addressList.add(address)
        }
        constructor(firstName: String, lastName: String, addressList: ArrayList<String>){
            this.firstName = firstName
            this.lastName = lastName
            this.addressList = addressList
        }
    }

    val contactList = ArrayList<Contact>()
}