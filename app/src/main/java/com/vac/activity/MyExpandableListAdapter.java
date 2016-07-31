package com.vac.activity;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vac.sportapp.R;
import com.vac.sportapp.SFirstFragment;

/**
 * Created by vac on 2016/7/20.
 */
public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private String[] cities_L = new String[23];
    private String[][] cities = {
            {"鞍山","阿克苏地区","安庆","安康","安阳","安顺"},
            {"北京","宝鸡","白城","滨州","保山","百色","本溪"},
            {"成都","赤峰","崇左","长春","滁州","重庆","常德","朝阳","郴州","沧州","长沙","昌都地区"},
            {"大连","大同","德州","迪庆藏族自治州","德阳","定西","达州","东莞","大庆","东营","大理白族自治州","丹东"},
            {"鄂尔多斯","鄂州","恩施土家族苗族自治州"},
            {"福州","佛山","抚顺","抚州","阜阳","防城港","阜新"},
            {"广州","广元","贵阳","赣州","甘孜藏族自治州","贵港","广安","桂林","甘南藏族自治州"},
            {"杭州","淮安","湖州","衡阳","贺州","黑河","哈密地区","淮南","黄冈","汉中","海口","鹤岗"},
            {"嘉兴","晋城","济南","吉安","晋中","酒泉","焦作","金昌","景德镇","荆州","金华","九江"},
            {"克拉玛依","开封","昆明"},
            {"丽江","柳州","漯河","六盘水","连云港","娄底","拉萨","莱芜","龙岩","临沧","兰州","临汾"},
            {"梅州","眉山","茂名","马鞍山","绵阳","牡丹江","曼谷"},
            {"南京","宁德","南昌","宁波","内江","南充","南宁","南通","南平","南阳"},
            {},
            {"盘锦","萍乡","莆田","平凉","思茅","攀枝花","濮阳","平顶山","普吉"},
            {"青岛","泉州","庆阳","蒲州","衢州","钦州","七台河","齐齐哈尔","曲靖","秦皇岛","琼海","清迈"},
            {"日照"},
            {"上海","深圳","苏州","宿州","石家庄","商丘","朔州","汕头","韶关","三亚","十堰","石嘴山","上饶"},
            {"台州","天津","太原","铜陵","通辽","铁岭","泰安","唐山","天水","同化","大理白族自治州","丹东"},
            {"武汉","武威","太原","铜陵","通辽","铁岭","泰安","唐山","天水","同化","大理白族自治州","丹东"},
            {"厦门","宣城","太原","铜陵","通辽","铁岭","泰安","唐山","天水","同化","大理白族自治州","丹东"},
            {"营口","宜春","太原","铜陵","通辽","铁岭","泰安","唐山","天水","同化","大理白族自治州","丹东"},
            {"郑州","中山","太原","铜陵","通辽","铁岭","泰安","唐山","天水","同化","大理白族自治州","丹东"},
    };
    public MyExpandableListAdapter(Context context) {
        super();
        this.context = context;
        this.cities_L = this.context.getResources().getStringArray(R.array.cities_L);
    }

    @Override
    public int getGroupCount() {
        return cities_L.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return cities[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return cities_L[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return cities[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.expandlist_group,null);
            groupHolder = new GroupHolder();
            groupHolder.textView = (TextView) convertView.findViewById(R.id.expandlist_group_text);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        groupHolder.textView.setText(cities_L[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ItemHolder itemHolder = null;
        if(convertView == null){
            itemHolder = new ItemHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.expandlist_item,null);
            itemHolder.textView = (TextView) convertView.findViewById(R.id.expandlist_item_text);
            convertView.setTag(itemHolder);
        }else {
            itemHolder = (ItemHolder) convertView.getTag();
        }
        itemHolder.textView.setText(cities[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder{
        public TextView textView;
    }
    class ItemHolder{
        public TextView textView;
    }
}
