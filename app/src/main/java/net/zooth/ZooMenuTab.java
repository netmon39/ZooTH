package net.zooth;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ZooMenuTab extends Fragment implements View.OnClickListener {

    private Button homeBtn, aboutBtn, graphBtn;
    private OnMenuClickListener myOnMenuClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_zoo_menu_tab,container,false);

        homeBtn = (Button) v.findViewById(R.id.menu_layout_button_home);
        aboutBtn = (Button) v.findViewById(R.id.menu_layout_button_about);
        graphBtn = (Button) v.findViewById(R.id.menu_layout_button_graph);

        homeBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
        graphBtn.setOnClickListener(this);
        return v;
    }

    public void setOnMenuClickListener(OnMenuClickListener myOnMenuClickListener) {
        this.myOnMenuClickListener = myOnMenuClickListener;
    }

    @Override
    public void onClick(View v) {
        if(myOnMenuClickListener != null){
            if(v.equals(homeBtn))
                myOnMenuClickListener.onHomeClicked();
            else if(v.equals(aboutBtn))
                myOnMenuClickListener.onAboutClicked();
            else  if(v.equals(graphBtn))
                myOnMenuClickListener.onGraphClicked();
        }
    }

    public interface OnMenuClickListener{
        public void onHomeClicked();
        public void onAboutClicked();
        public void onGraphClicked();
    }



}