package net.zooth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseZoo extends AppCompatActivity implements View.OnClickListener {
    private Button zoo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_zoo);

        zoo1 = (Button) findViewById(R.id.zoo1);
        zoo1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zoo1:
                Intent intent = new Intent(this, Zoo.class);
                intent.putExtra("zoo",1);
                startActivity(intent);
                break;
            case R.id.zoo2:
                Intent intent2 = new Intent(this, Zoo.class);
                intent2.putExtra("zoo",2);
                startActivity(intent2);
                break;
            case R.id.zoo3:
                Intent intent3 = new Intent(this, Zoo.class);
                intent3.putExtra("zoo",3);
                startActivity(intent3);
                break;
            case R.id.zoo4:
                Intent intent4 = new Intent(this, Zoo.class);
                intent4.putExtra("zoo",4);
                startActivity(intent4);
                break;
            case R.id.zoo5:
                Intent intent5 = new Intent(this, Zoo.class);
                intent5.putExtra("zoo",5);
                startActivity(intent5);
                break;
            case R.id.zoo6:
                Intent intent6 = new Intent(this, Zoo.class);
                intent6.putExtra("zoo",6);
                startActivity(intent6);
                break;
            case R.id.zoo7:
                Intent intent7 = new Intent(this, Zoo.class);
                intent7.putExtra("zoo",7);
                startActivity(intent7);
                break;
            case R.id.zoo8:
                Intent intent8 = new Intent(this, Zoo.class);
                intent8.putExtra("zoo",8);
                startActivity(intent8);
                break;
        }
    }
}
