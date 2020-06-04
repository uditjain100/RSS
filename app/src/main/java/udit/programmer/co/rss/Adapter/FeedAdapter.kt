package udit.programmer.co.rss.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import udit.programmer.co.rss.Interface.ItemClickListener
import udit.programmer.co.rss.Models.RSSObject
import udit.programmer.co.rss.R

class FeedAdapter(private val rssObject: RSSObject) : RecyclerView.Adapter<FeedViewHolder>() {
    var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = rssObject.items.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        holder.bind(rssObject.items[position])
        holder.itemView.setOnClickListener {
            onItemClickListener?.onClick(rssObject.items[position], false)
        }

        holder.itemView.setOnLongClickListener {
            onItemClickListener?.onClick(rssObject.items[position], true)
            return@setOnLongClickListener true
        }
    }
}