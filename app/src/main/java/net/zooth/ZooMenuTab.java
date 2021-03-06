package net.zooth;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ZooMenuTab extends Fragment implements View.OnClickListener {

    private Button information, activity, travel, nav, contact;
    private OnMenuClickListener myOnMenuClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_zoo_menu_tab,container,false);

        information = (Button) v.findViewById(R.id.menu_layout_button_information);
        activity = (Button) v.findViewById(R.id.menu_layout_button_activity);
        travel = (Button) v.findViewById(R.id.menu_layout_button_history);
        contact = (Button) v.findViewById(R.id.menu_layout_button_contact);
        nav =(Button) v.findViewById(R.id.menu_layout_button_nav);

        information.setOnClickListener(this);
        activity.setOnClickListener(this);
        travel.setOnClickListener(this);
        contact.setOnClickListener(this);
        nav.setOnClickListener(this);

        return v;
    }

    public void setOnMenuClickListener(OnMenuClickListener myOnMenuClickListener) {
        this.myOnMenuClickListener = myOnMenuClickListener;
    }

    @Override
    public void onClick(View v) {
        if(myOnMenuClickListener != null){
            if(v.equals(information))
                myOnMenuClickListener.onInformationClicked();
            else if(v.equals(activity))
                myOnMenuClickListener.onActivityClicked();
            else  if(v.equals(travel))
                myOnMenuClickListener.onHistoryClicked();
            else  if(v.equals(contact))
                myOnMenuClickListener.onContactClicked();
            else if(v.equals(nav))
                myOnMenuClickListener.onNavClicked();
        }
    }

    public interface OnMenuClickListener{
        void onInformationClicked();
        void onActivityClicked();
        void onHistoryClicked();
        void onContactClicked();
        void onNavClicked();
    }

}