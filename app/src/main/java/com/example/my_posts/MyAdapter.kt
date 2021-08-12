package com.example.my_posts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
class MyAdaptervar(var context:Context,var postList: List<Posts>):RecyclerView.Adapter<UserViewHHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHHolder {
  var itemView=LayoutInflater.from(parent.context).inflate(R.layout.user_list_items,parent,false)
        return UserViewHHolder(itemView)
    }
    override fun onBindViewHolder(holder: UserViewHHolder, position: Int) {
        var currentList=postList.get(position)
        holder.etUserId.text=currentList.userId.toString()
        holder.etId.text=currentList.id.toString()
        holder.etTitle.text=currentList.title
        holder.etBody.text=currentList.body
        holder.cd.setOnClickListener{
            var intent=Intent(context,ViewPost::class.java)
            intent.putExtra("POST_ID",currentList.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
       return postList.size
    }
}
class UserViewHHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var etUserId=itemView.findViewById<TextView>(R.id.etUserId)
    var etId=itemView.findViewById<TextView>(R.id.etId)
    var etTitle=itemView.findViewById<TextView>(R.id.etTitle)
    var etBody=itemView.findViewById<TextView>(R.id.etBody)
    var cd=itemView.findViewById<CardView>(R.id.cd)

}