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

        zoo1 = (Button) findViewById(R.id.button);
        zoo1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, Zoo.class);
                startActivity(intent);
                break;
        }
    }
}
