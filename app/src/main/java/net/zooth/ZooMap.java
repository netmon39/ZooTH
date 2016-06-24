package net.zooth;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ZooMap extends Fragment {

    private OnSettingClickListener mOnSettingClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_zoo_map, container, false);

        Button camera = (Button) view.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dataintent = new Intent(getActivity(), ZooCamera.class);
                startActivity(dataintent);
            }
        });

        Button menutab = (Button) view.findViewById(R.id.menutab);
        menutab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnSettingClickListener != null)
                    mOnSettingClickListener.onSettingClicked();
            }
        });

        //MAP// Work with TouchImageView API here
        TouchImageView olo = (TouchImageView) view.findViewById(R.id.map);
        olo.setImageResource(R.drawable.dice);//select map image here
        olo.setMaxZoom(20);

        return view;
    }

    public void setOnSettingClickListener(OnSettingClickListener pOnSettingClickListener) {
        this.mOnSettingClickListener = pOnSettingClickListener;
    }

    public interface OnSettingClickListener{
        public void onSettingClicked();

    }




}