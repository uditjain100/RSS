package udit.programmer.co.rss.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import udit.programmer.co.rss.Models.Item

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item) {
        itemView.pubtitle.text = item.title
        itemView.pubdate.text = item.pubDate
        itemView.pubcontent.text = item.content
    }
}