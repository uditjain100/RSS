package udit.programmer.co.rss.Interface

import android.view.View

interface OnClickLisrtener {
    fun onClick(view: View, position: Int, isLongClick: Boolean)
}