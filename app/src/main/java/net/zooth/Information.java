package net.zooth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    private int y;
    private TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent value = getIntent();
        y = value.getIntExtra("zooname", 1);

        time = (TextView) findViewById(R.id.timetextscv);

        switch (y){
            case 1:

                break;
            case 2:
                time.setText("เปิดบริการทุกวัน 8:00 - 18:00 น.");

                break;
            case 3:
                time.setText("เปิดบริการทุกวัน 8:00 - 18:00 น.");

                break;
            case 4:
                time.setText("เปิดบริการทุกวัน 8:00 - 17:00 น.");

                break;
            case 5:
                time.setText("เปิดบริการทุกวัน 8:30 - 17:30 น.");

                break;
            case 6:
                time.setText("เปิดบริการทุกวัน 8:30 - 16:30 น.");

                break;
            case 7:
                time.setText("เปิดบริการทุกวัน 8:00 - 18:00 น.");
                break;
            case 8:
                time.setText("-");
                break;
        }
    }
}
