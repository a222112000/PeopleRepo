package com.example.virginmoney.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.databinding.PeopleRowViewBinding
import com.example.virginmoney.model.PeopleResponseItem
import com.squareup.picasso.Picasso

class PeopleAdapter(private val peopleList: MutableList<PeopleResponseItem> = mutableListOf()): RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setPeople(people: MutableList<PeopleResponseItem>){
        peopleList.clear()
        peopleList.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder =
        PeopleViewHolder(PeopleRowViewBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(peopleList[position])
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    class PeopleViewHolder(private val bindings: PeopleRowViewBinding): RecyclerView.ViewHolder(bindings.root){
        fun bind(peoples: PeopleResponseItem){
            bindings.nametxt.text = peoples.firstName
            bindings.emailtxt.text = peoples.email
            bindings.addresstxt.text = peoples.email
            Picasso.get()
                .load(peoples.avatar)
                .placeholder(R.mipmap.ic_launcher)
                .into(bindings.albumimage)
        }
    }
}