package net.zooth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Contact extends AppCompatActivity {


    private int y;
    private TextView add,tel,email,fb,web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Intent value = getIntent();
        y = value.getIntExtra("zooname", 1);



        add = (TextView) findViewById(R.id.addresstext);
        tel = (TextView) findViewById(R.id.telephonetext);
        email = (TextView) findViewById(R.id.emailtext);
        fb = (TextView) findViewById(R.id.facebooktext);
        web = (TextView) findViewById(R.id.websitetext);

        if(y==1){
            add.setText("71 ถนนพระราม 5 เขตดุสิต กรุงเทพฯ 10300");
            tel.setText("0-2281-2000");
            email.setText("-");
            fb.setText("Fb.com/dusitzootha");
            fb.setMovementMethod(LinkMovementMethod.getInstance());
            web.setText("http://www.dusitzoo.org");
            web.setMovementMethod(LinkMovementMethod.getInstance());
        }else  if(y==2){
            add.setText("235 ม.7 ต.บางพระ อ.ศรีราชา จ.ชลบุรี 20110");
            tel.setText("0-3831-8444, 0-3831-8444 ");
            email.setText("admin@kkopenzoo.com");
            fb.setText("Fb.com/kkopenzoo");
            web.setText("http://www.kkopenzoo.com");
        }else  if(y==3){
            add.setText("เลขที่ 100 ถนนห้วยแก้ว ตำบลสุเทพ\tเมือง\tเชียงใหม่\t50200\tไทย");
            tel.setText(" 053221179, 053221179 ");
            email.setText("-");
            fb.setText("-");
            web.setText("http://www.chiangmaizoo.com");
        }else  if(y==4){
            add.setText("เลขที่ 111 หมู่ 1 ถนนราชสีมา-ปักธงชัย ตำบลไชยมงคล อำเภอเมือง จังหวัดนครราชสีมา 30000");
            tel.setText("044-934647, 044-934537 ");
            email.setText("prmarketing.krz@gmail.com");
            fb.setText("www.facebook.com/Nakhonratchasimazoofanpage");
            web.setText(" www.koratzoo.org");
        }else  if(y==5){
            add.setText("สวนสัตว์สงขลา  เลขที่ 189 ม.5 ถ.สงขลา - นาทวี ต.เขารูปช้าง อ.เมือง จ.สงขลา 90000  ");
            tel.setText(" 0-7459-8838–9,  0-7459-8555");
            email.setText("songkhlazoo55@gmail.com");
            fb.setText("-");
            web.setText("http://www.songkhlazoo.com");
        }else  if(y==6){
            add.setText("112 หมู่ 17 ตำบลขามใหญ่ อำเภอเมือง จังหวัดอุบลราชธานี 34000");
            tel.setText("045-252-761");
            email.setText("-");
            fb.setText("https://www.facebook.com/ubonzoo.zpo/");
            web.setText("http://www.ubon-zoo.com");
        }else  if(y==7){
            add.setText("สวนสัตว์ขอนแก่น เลขที่ 88 หมู่ที่ 8 ตำบลคำม่วง อำเภอเขาสวนกวาง จังหวัดขอนแก่น รหัสไปรษณีย์ 40280");
            tel.setText("086-4556341, 086-4594192");
            email.setText("khonkaenzoo@gmail.com");
            fb.setText("https://www.facebook.com/สวนสัตว์ขอนแก่น-khonkaen-zoo-413430082085345/");
            web.setText("http://www.khonkaenzoo.com");
        }else  if(y==8){
            add.setText("-");
            tel.setText("-");
            email.setText("-");
            fb.setText("-");
            web.setText("-");
        }
    }
}
