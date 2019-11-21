package org.myhush.silentdragon

class Addressbook {
    private val data = ArrayList<Contact>()

    fun addContact(contact: Contact){
        data.add(contact)
    }

    fun getContactByAddress(address: String): Contact? {
        data.forEach {
            if (it.zaddress == address)
                return it
        }
        return null
    }

    fun getContactsByFirstName(firstName: String): ArrayList<Contact> {
        val list = ArrayList<Contact>()
        data.forEach {
            if (it.firstName == firstName)
                list.add(it)
        }
        return list
    }

    fun getContactsByLastName(lastName: String): ArrayList<Contact> {
        val list = ArrayList<Contact>()
        data.forEach {
            if (it.lastName == lastName)
                list.add(it)
        }
        return list    }

    fun getContactsByFullName(firstName: String, lastName: String): ArrayList<Contact> {
        val list = ArrayList<Contact>()
        data.forEach {
            if (it.firstName == firstName && it.lastName == lastName)
                list.add(it)
        }
        return list
    }
}