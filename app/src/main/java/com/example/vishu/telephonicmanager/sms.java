package com.example.vishu.telephonicmanager;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.string.no;

public class sms extends AppCompatActivity {

    EditText number,msg;
    Button send;
    SmsManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        number=(EditText)findViewById(R.id.editText);
        msg=(EditText)findViewById(R.id.editText2);
        send=(Button) findViewById(R.id.button4);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=number.getText().toString();
                String b=msg.getText().toString();

                Intent intent=new Intent(getApplicationContext(),sms.class);
                PendingIntent pi=PendingIntent.getActivities(getApplicationContext(),0, new Intent[]{intent},0);

                sm=SmsManager.getDefault();
                sm.sendTextMessage(a,null,b,pi,null);

                Toast.makeText(getApplicationContext(),"sent successfully",Toast.LENGTH_LONG).show();

            }
        });
    }
}
