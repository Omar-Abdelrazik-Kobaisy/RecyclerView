package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.ContactItemBinding


class ContactAdapter(var items : List<ContactItem>)
    :RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {

//    var items :List<ContactItem>
//    constructor(items:List<ContactItem>)
//    {
//        this.items = items
//    }
    var onItemClickListener :OnItemClickListener? = null
    class ItemViewHolder(val itemViewbinder :ContactItemBinding) : RecyclerView.ViewHolder(itemViewbinder.root){


    //    val contact_img:ImageView = itemView.contactImg
//    val title:TextView = itemView.nameTv
//    val dail_img:ImageView = itemView.dialImg
//        val contact_img:ImageView = itemView.findViewById(R.id.contact_img)
//        val title:TextView = itemView.findViewById(R.id.name_tv)
//        val dail_img:ImageView = itemView.findViewById(R.id.dial_img)
    // another way
//        constructor(itemView: View) :super(itemView)
//        {
//            contact_img = itemView.findViewById(R.id.contact_img)
//            title = itemView.findViewById(R.id.name_tv)
//            dail_img = itemView.findViewById(R.id.dial_img)
//        }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        TODO("Not yet implemented")
//        val v :View = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
//        return ItemViewHolder(v)
        val binding :ContactItemBinding = ContactItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        TODO("Not yet implemented")
        val item :ContactItem = items.get(position)
        //Data_Binding
//        if(item.contact_img != null)
//        holder.contact_img.setImageResource(item.contact_img)
//        holder.title.setText(item.title)
//        if(item.dail_img != null)
//        holder.dail_img.setImageResource(item.dail_img)
        //----------------------------------------------------------------
//        holder.contact_img.setImageResource(item.contact_img ?: 0)
//        holder.title.text = item.title
//        holder.dail_img.imageAlpha = item.dail_img ?: 0
        //-----------------------------------------------------------------
//        holder.itemViewbinder.contactImg.setImageResource(item.contact_img ?: 0)
//        holder.itemViewbinder.nameTv.text = item.title
//        holder.itemViewbinder.dialImg.imageAlpha = item.dail_img ?: 0
        //-----------------------------------------------------------------
        with(holder)
        {

            with(itemViewbinder)
            {
                contactImg.setImageResource(item.contact_img ?:0)
                nameTv.text = item.title
                dialImg.imageAlpha = item.dail_img ?:0
//                root.setOnClickListener {
//                    listener.OnItemClick(item)
//                }
                root.setOnClickListener {
                    onItemClickListener?.onItemClick(item)
                }
            }
        }
    }

//    override fun getItemCount(): Int {
////        TODO("Not yet implemented")
//        return items.size;
//    }
    override fun getItemCount() = items.size
interface OnItemClickListener{
    fun onItemClick(item: ContactItem)
}
}