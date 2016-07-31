package com.vac.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vac.sportapp.R;

/**
 * Created by vac on 2016/7/22.
 */
public class MyAdapterForGym extends BaseAdapter {
    private Context context;
    private int[] images = {R.mipmap.sports0,R.mipmap.sports1,R.mipmap.sports2,
            R.mipmap.sports3,R.mipmap.sports5,R.mipmap.sports6,R.mipmap.sports7};
    private String[] gymName = {"北京邮电大学体育馆","九玄健身","新白鹿健身中心","非凡乒羽跆拳道",
            "健康100健身中心","万商运动中心","踏浪游泳馆"};
    private String[] gymType = {"综合体育馆","健身中心","健身中心","跆拳道馆","健身中心","综合运动中心","游泳馆"};
    private String[] distance = {"3.4km","5km","3km","1km","800m","4km","3km"};

    public MyAdapterForGym(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        Gym gym = new Gym();
        gym.image = images[position];
        gym.gymName = gymName[position];
        gym.gymType = gymType[position];
        gym.distance = distance[position];
        return gym;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyAdapterForGym.ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gymlist_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.image_gym = (ImageView) convertView.findViewById(R.id.image_gym);
            viewHolder.image_star = (ImageView) convertView.findViewById(R.id.image_star);
            viewHolder.text_gymName = (TextView) convertView.findViewById(R.id.text_gytName);
            viewHolder.text_gymType = (TextView) convertView.findViewById(R.id.text_type);
            viewHolder.text_distance = (TextView) convertView.findViewById(R.id.text_distance);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.image_gym.setImageResource(images[position]);
        viewHolder.image_star.setImageResource(R.mipmap.fstars);
        viewHolder.text_gymName.setText(gymName[position]);
        viewHolder.text_gymType.setText(gymType[position]);
        viewHolder.text_distance.setText(distance[position]);
        return convertView;
    }

    class Gym{
        String gymName;
        String gymType;
        String distance;
        int image;
    }

    class ViewHolder{
        ImageView image_gym,image_star;
        TextView text_gymName,text_gymType,text_distance;
    }
}
