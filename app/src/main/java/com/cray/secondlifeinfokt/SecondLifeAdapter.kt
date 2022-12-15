package com.cray.secondlifeinfokt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SecondLifeAdapter (
    val context: Context,
    val secondListInfoList: ArrayList<SecondListInfo>
) : BaseAdapter ()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val InfoOne = secondListInfoList[position]
        val view: View =
            LayoutInflater.from(context)
                .inflate(R.layout.list_item_info, null)

        //view.findViewById<ImageView>(R.id.iv_url)
        //    .setImageResource(android.R.drawable.ic_menu_compass)

        Glide.with(context)
            .load(InfoOne.urlimg) // 불러올 이미지 url
            .into(view.findViewById(R.id.iv_url)) // 이미지를 넣을 뷰

        view.findViewById<TextView>(R.id.tv_name)
            .text = InfoOne.name

        view.findViewById<TextView>(R.id.tv_desc)
            .text = InfoOne.desc

        return view
    }

    override fun getCount(): Int {
        return secondListInfoList.size
    }

    override fun getItem(position: Int): Any {
        return secondListInfoList[position];
    }

    override fun getItemId(position: Int): Long {
        return 0;
    }



}