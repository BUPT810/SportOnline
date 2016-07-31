package com.vac.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vac.sportapp.R;

import java.util.List;

/*
在item的布局文件中，设置了item的背景与checked的状态相关，但是却没有效果
所以重写该类，用于在点击是更换背景
 */
public class MyArrayAdapter extends BaseAdapter{

    private Context context;
    private List<String> list;
    private int selectedPosition = -1;
    public MyArrayAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectedPosition(int position){
        this.selectedPosition = position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.simple_list_item,null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.simple_list_item_text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position));
        if(selectedPosition == position)
        {convertView.setBackgroundColor(context.getResources().getColor(R.color.bg_white));}
        else{convertView.setBackgroundColor(context.getResources().getColor(R.color.bg_gray));}
        return convertView;
    }
    class ViewHolder{
        TextView textView;
    }
}
