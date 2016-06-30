package net.zooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.widget.DrawerLayout;

public class Zoo extends FragmentActivity implements ZooMap.OnSettingClickListener, ZooMenuTab.OnMenuClickListener {

    private View menuView;
    private int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);

        menuView = findViewById(R.id.activity_main_framelayout_menu);

        Intent value = getIntent();
        x = value.getIntExtra("zoo", 1);

        ZooMap zoomap = new ZooMap();
        ZooMenuTab zoomenutab = new ZooMenuTab();

        if(x==1){
            zoomap.ChangeZooName("สวนสัตว์ดุสิต");
        }else if (x==2){
            zoomap.ChangeZooName("สวนสัตว์เปิดเขาเขียว");
        }else if (x==2){
            zoomap.ChangeZooName("สวนสัตว์เปิดเขาเขียว");
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager
                .beginTransaction()
                .add(R.id.activity_main_framelayout_main, zoomap, "Main")
                .commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.activity_main_framelayout_menu, zoomenutab, "Menu")
                .commit();

        zoomap.setOnSettingClickListener(this);
        zoomenutab.setOnMenuClickListener(this);

    }

    @Override
    public void onSettingClicked() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(!drawerLayout.isDrawerOpen(menuView)){
            drawerLayout.openDrawer(menuView);
        }
    }

    private void closeMenu(){
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(menuView)){
            drawerLayout.closeDrawer(menuView);
        }
    }


    @Override
    public void onInformationClicked() {
        closeMenu();
        Intent intent = new Intent(this, Information.class);
        intent.putExtra("zooname",x);
        startActivity(intent);
    }

    @Override
    public void onActivityClicked() {

        closeMenu();
        Intent intent = new Intent(this, Activity.class);
        startActivity(intent);


    }

    @Override
    public void onHistoryClicked() {

        closeMenu();
        Intent intent = new Intent(this, History.class);

        startActivity(intent);
    }

    @Override
    public void onContactClicked() {

        closeMenu();
        Intent intent = new Intent(this, Contact.class);
        intent.putExtra("zooname",x);
        startActivity(intent);
    }

    @Override
    public void onNavClicked() {

        closeMenu();
        Intent intent = new Intent(this, Nav.class);
        startActivity(intent);
    }

}
