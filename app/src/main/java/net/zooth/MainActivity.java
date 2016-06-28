package net.zooth;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    //private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //next = (Button) findViewById(R.id.button9);
        //next.setOnClickListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ChooseOrganization.class);
                MainActivity.this.startActivity(intent);
            }
        }, 3000);


    }

/*    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button9:
                Intent intent = new Intent(this, ChooseOrganization.class);
                startActivity(intent);
                break;
        }
    }*/
}