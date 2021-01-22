package com.example.shymko_hw_lesson14_110121_recycler_v1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycle_layout.view.*

class ReciclerAdaptor(
    var personList: List<Person>
) : RecyclerView.Adapter<ReciclerAdaptor.PersonViewHolder>() {
    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.itemView.apply {
           tvPersonName.text = personList[position].name
           tvPersonAge.text = personList[position].age.toString()
        }
    }
}