package com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_cl

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.ngopidev.project.androidlatihan9_10_jetpackktx.R
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People
import kotlinx.android.synthetic.main.contact_list.view.*


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/
class ListPeopleAdapter(private val items : List<People>,
                        private val clickListener: OnItemClickListener)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface OnItemClickListener{
        fun onItemClick(people: People, itemView: View)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.contact_list, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as ViewHolder).bind(items[p1], clickListener)
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(people: People, listener : OnItemClickListener) = with(itemView){
            tvName.text = people.nama
            tvMet.text = people.lokasi
            btnContact.text = people.contact
            btnContact.setOnClickListener {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:${people.contact}")
                itemView.context.startActivity(dialIntent)
            }
            setOnClickListener {
                listener.onItemClick(people, it)
            }
        }
    }
}