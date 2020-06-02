package udit.programmer.co.rss.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import udit.programmer.co.rss.Interface.ItemClickListener
import udit.programmer.co.rss.Models.RSSObject
import udit.programmer.co.rss.R

class FeedAdapter(private val rssObject: RSSObject, private val mContext: Context) :
    RecyclerView.Adapter<FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = rssObject.items.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        holder.txtTitle.text = rssObject.items[position].title
        holder.txtPubDate.text = rssObject.items[position].pubDate
        holder.txtContent.text = rssObject.items[position].content

        holder.SetItemClickListener(ItemClickListener { view, position, isLongClick ->
            if (!isLongClick) {
                mContext.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(rssObject.items[position].link)
                    )
                )
            }
        })
    }

}