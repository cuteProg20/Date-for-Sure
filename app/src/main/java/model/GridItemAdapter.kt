package model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dateforsure.R
import com.squareup.picasso.Picasso

class GridItemAdapter (private val cardTitles : Array<String>, private val cardImages: Array<String>) : RecyclerView.Adapter< GridItemAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

       val cardImage: ImageView = itemView.findViewById(R.id.card_images)
        val cardTitle : TextView = itemView.findViewById(R.id.card_titles)


}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text = cardTitles[position]
        Picasso.get().load(cardImages[position]).into(holder.cardImage)
    }

    override fun getItemCount(): Int {
         return cardTitles.size
    }


}