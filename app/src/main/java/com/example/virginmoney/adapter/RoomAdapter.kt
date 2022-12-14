package com.example.virginmoney.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.databinding.RoomRowViewBinding
import com.example.virginmoney.model.RoomResponseItem
import com.squareup.picasso.Picasso

class RoomAdapter(private val roomList: MutableList<RoomResponseItem> = mutableListOf()):
    RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    fun setRoom( room: MutableList<RoomResponseItem>){
        roomList.clear()
        roomList.addAll(room)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder =
        RoomViewHolder(
            RoomRowViewBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.bind(roomList[position])
    }

    override fun getItemCount(): Int {
        return roomList.size
    }

    class RoomViewHolder(private var bindings: RoomRowViewBinding): RecyclerView.ViewHolder(bindings.root){
        @SuppressLint("ResourceAsColor")
        fun bind(room: RoomResponseItem){
            bindings.title.text = room.name
            bindings.thumbnailUrl.text = room.created_at
            if(room.is_occupied) {
                bindings.cardbg.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.red));
            }else{
                bindings.cardbg.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.green));
            }
        }
    }
}