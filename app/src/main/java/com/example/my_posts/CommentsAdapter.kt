package com.example.my_posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CommentsAdapter(var postComment: List<Comments>):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.comments_list_items,false)
        return CommentsViewHolder(itemView)

        }
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=postComment.get(position)
        holder.name.text=currentComment.name
        holder.name.text=currentComment.email
        holder.body.text=currentComment.body
    }

    override fun getItemCount(): Int {
        return postComment.size
    }
}
class CommentsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var name=itemView.findViewById<TextView>(R.id.tvName)
    var email=itemView.findViewById<TextView>(R.id.tvEmail)
    var body=itemView.findViewById<TextView>(R.id.tvBody)
}