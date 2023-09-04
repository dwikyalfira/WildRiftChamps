package com.dicoding.wildriftchamps

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListChampionAdapter(private val listChampion: ArrayList<Champion>) : RecyclerView.Adapter<ListChampionAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_champion, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, role, region, description, photo) = listChampion[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvRole.text = role
        holder.tvRegion.text = region


        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_champion", listChampion[position])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listChampion.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_champion_name)
        val tvRole: TextView = itemView.findViewById(R.id.tv_champion_role)
        val tvRegion: TextView = itemView.findViewById(R.id.tv_champion_region)
//        val tvDescription: TextView = itemView.findViewById(R.id.tv_champion_description)
    }

}