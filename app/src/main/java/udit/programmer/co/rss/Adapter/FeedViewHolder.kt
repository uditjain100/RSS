package udit.programmer.co.rss.Adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udit.programmer.co.rss.Interface.ItemClickListener
import udit.programmer.co.rss.R

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener, View.OnLongClickListener {

    var txtTitle: TextView
    var txtPubDate: TextView
    var txtContent: TextView
    var itemClickListener: ItemClickListener? = null

    init {
        txtTitle = itemView.findViewById(R.id.pubtitle) as TextView
        txtPubDate = itemView.findViewById(R.id.pubdate) as TextView
        txtContent = itemView.findViewById(R.id.pubcontent) as TextView
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
    }

    fun SetItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View) {
        itemClickListener!!.onClick(v, adapterPosition, false)
    }

    override fun onLongClick(v: View): Boolean {
        itemClickListener!!.onClick(v, adapterPosition, true)
        return true
    }

}