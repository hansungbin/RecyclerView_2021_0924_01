package com.example.recyclerview_2021_0924_01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val context: Context, private val items: ArrayList<DataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * A companion object where we can declare the constant values.
     */
    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == VIEW_TYPE_ONE) {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_custom_row,
                    parent,
                    false
                )
            )
        } else {
            return AnotherViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_another_custom_row,
                    parent,
                    false
                )
            )
        }
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = items[position]

        if (holder is ViewHolder) {
            holder.tvItem.text = item.itemName
//            holder.tvItem.text = item.item

            // Updating the background color according to the odd/even positions in list.
            if (position % 2 == 0) {
                holder.cardViewItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorLightGray
                    )
                )
            } else {
                holder.cardViewItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorWhite
                    )
                )
            }
        } else if (holder is AnotherViewHolder) {
            holder.tvAnotherItemName.text = item.itemName

            // Updating the background color according to the odd/even positions in list.
            if (position % 2 == 0) {
                holder.cardViewAnotherItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorLightGray
                    )
                )
            } else {
                holder.cardViewAnotherItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorWhite
                    )
                )
            }
        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Get the ItemViewType from the list items.
     */
    override fun getItemViewType(position: Int): Int {

        return items[position].viewType
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to

        val tvItem : TextView = view.findViewById(R.id.tv_item_name)
        val cardViewItem : CardView = view.findViewById(R.id.card_view_item)
    }

    class AnotherViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvAnotherItemName : TextView = view.findViewById(R.id.tv_another_item_name)
        val cardViewAnotherItem : CardView = view.findViewById(R.id.card_view_another_item)
    }
}