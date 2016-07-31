package com.vac.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.vac.sportapp.R;

/**
 * Created by vac on 2016/7/27.
 */
public class GymMap extends Activity {
    private MapView mapView;
    private double longitude,latitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.gym_map);
        mapView = (MapView) findViewById(R.id.mapView);
        BaiduMap baiduMap = mapView.getMap();
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        Intent intent = getIntent();
        longitude = intent.getDoubleExtra("longitude",0);
        latitude = intent.getDoubleExtra("latitude",0);
        Log.i("LOG",""+latitude);
        Log.i("LOG",""+longitude);
        LatLng point = new LatLng(latitude,longitude);//new LatLng(39.963175, 116.400244);//
        BitmapDescriptor descriptor = BitmapDescriptorFactory.fromResource(R.mipmap.location_mini);
        OverlayOptions options = new MarkerOptions().position(point).icon(descriptor);
        baiduMap.addOverlay(options);
    }
}
