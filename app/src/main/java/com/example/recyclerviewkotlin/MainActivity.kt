package com.example.recyclerviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit var recyclerView :RecyclerView
    lateinit var binding: ActivityMainBinding
    lateinit var items : MutableList<ContactItem>
    lateinit var adapter :ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        //recyclerView = findViewById(R.id.contact_recyclerview)
        createDataList();
        adapter = ContactAdapter(items);
//        adapter.listener = object :OnItemClickListener{
//            override fun OnItemClick(item: ContactItem) {
//                TODO("Not yet implemented")
//            }
//
//        }
        adapter.onItemClickListener =  object :ContactAdapter.OnItemClickListener{
            override fun onItemClick(item: ContactItem) {
//                TODO("Not yet implemented")
                val intent:Intent = Intent(this@MainActivity,DetailsActivity::class.java)
        intent.putExtra("img",item.contact_img)
        intent.putExtra("name",item.title)
        startActivity(intent)
                Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_SHORT).show()
            }

        }
        binding.contactRecyclerview.adapter = adapter

    }

    fun createDataList(){
//        items = listOf(
//            ContactItem(R.drawable.ic_contact,"omar_abdelrazik",R.drawable.ic_dial)
//        )
        items = mutableListOf()


        for(i in 0..10 step 1) {
            items.add(
                ContactItem(
                    R.drawable.ic_baseline_contact_phone_24,
                    "omar_abdelrazik",
                    R.drawable.ic_blue_dial
                )
            )
            items.add(ContactItem(R.drawable.ic_contact,"Contact $i",R.drawable.ic_dial))
        }
    }
//
//    override fun OnItemClick(item: ContactItem) {
//        TODO("Not yet implemented")
////        val intent:Intent = Intent(this@MainActivity,DetailsActivity::class.java)
////        //intent.putExtra("img",item.contact_img)
////        intent.putExtra("name",item.title)
////        startActivity(intent)
//        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
//    }
}