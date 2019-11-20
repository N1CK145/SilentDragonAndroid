package org.myhush.silentdragon.chat

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_chat.*
import org.myhush.silentdragon.MainActivity
import org.myhush.silentdragon.R
import org.myhush.silentdragon.ReceiveActivity
import org.myhush.silentdragon.SendActivity

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        initListener()
        restoreSoonChats()
        //TODO: restoreSoonChats()
        //TODO: restoreSoonChats()
    }

    private fun restoreSoonChats() {
        addChat("Nil", "Armstrong")
        addChat("Peter", "Parker")
        addChat("Mark", "Zuckerberg")
    }

    private fun initListener(){
        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_send -> {
                    val intent = Intent(this, SendActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_bal -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_chat -> true
                R.id.action_recieve -> {
                    val intent = Intent(this, ReceiveActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    fun addChat(firstName: String, lastName: String){
        val fragment = ChatItemFragment()
        val fragTx: FragmentTransaction = supportFragmentManager.beginTransaction()

        fragment.firstName = firstName
        fragment.lastName = lastName

        fragTx.add(R.id.ChatTable, fragment)
        fragTx.commit()
    }
}
