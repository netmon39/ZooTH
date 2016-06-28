package net.zooth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseOrganization extends AppCompatActivity implements View.OnClickListener {

    private Button organization,zoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_organization);

        organization = (Button) findViewById(R.id.organization);
        zoo = (Button) findViewById(R.id.zoo);

        organization.setOnClickListener(this);
        zoo.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.organization:
                Intent intent = new Intent(this, Organization.class);
                startActivity(intent);
                break;
            case R.id.zoo:
                Intent intent2 = new Intent(this, ChooseZoo.class);
                startActivity(intent2);
                break;
        }
    }
}
