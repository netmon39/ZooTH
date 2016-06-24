package net.zooth;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ZooMenuTab extends Fragment implements View.OnClickListener {

    private Button information, activity, travel, contact;
    private OnMenuClickListener myOnMenuClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_zoo_menu_tab,container,false);

        information = (Button) v.findViewById(R.id.menu_layout_button_information);
        activity = (Button) v.findViewById(R.id.menu_layout_button_activity);
        travel = (Button) v.findViewById(R.id.menu_layout_button_travel);
        contact = (Button) v.findViewById(R.id.menu_layout_button_contact);

        information.setOnClickListener(this);
        activity.setOnClickListener(this);
        travel.setOnClickListener(this);
        contact.setOnClickListener(this);
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
                myOnMenuClickListener.onTravelClicked();
            else  if(v.equals(contact))
                myOnMenuClickListener.onContactClicked();
        }
    }

    public interface OnMenuClickListener{
        public void onInformationClicked();
        public void onActivityClicked();
        public void onTravelClicked();
        public void onContactClicked();
    }

}