package net.zooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.widget.DrawerLayout;

public class Zoo extends FragmentActivity implements ZooMap.OnSettingClickListener, ZooMenuTab.OnMenuClickListener {

    private View menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);

        menuView = findViewById(R.id.activity_main_framelayout_menu);

        ZooMap zoomap = new ZooMap();
        ZooMenuTab zoomenutab = new ZooMenuTab();


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
    public void onHomeClicked() {

        closeMenu();
      /*  Intent intent = new Intent(this, DisplayIncome.class);
        startActivity(intent);*/
    }

    @Override
    public void onAboutClicked() {

        closeMenu();
      /*  Intent intent = new Intent(this, About.class);
        startActivity(intent);*/


    }

    @Override
    public void onGraphClicked() {

        closeMenu();
    }
}
