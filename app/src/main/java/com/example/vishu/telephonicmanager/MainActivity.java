package com.example.vishu.telephonicmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView vtxt;
    TelephonyManager vtm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      vtm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        vtxt=(TextView)findViewById(R.id.txt);


       String IMEnumber=vtm.getDeviceId();
        String subsctiberId= vtm.getDeviceId();
        String  SimSerialNumber= vtm.getSimSerialNumber();
        String nwCountryIso=vtm.getNetworkCountryIso();
        String swVersion=vtm.getDeviceSoftwareVersion();
        String SimcountryIso=vtm.getNetworkCountryIso();
        boolean roaming=vtm.isNetworkRoaming();
       checkroaming();



        String phonedetail= " IMEnumb "+IMEnumber + "subscriberid " +subsctiberId +"simcountryiso "
        +SimcountryIso +"networkcountryiso"+ nwCountryIso +" SimserialNumber "+ SimSerialNumber
                +"s/w verison "+swVersion +"  roaming "+ roaming;



        vtxt.setText(phonedetail);
    }

    public boolean checkroaming() {
        if (vtm.getPhoneType() == TelephonyManager.PHONE_TYPE_CDMA) {
            Toast.makeText(getApplicationContext(), "CDMA", Toast.LENGTH_LONG).show();
        } else if(vtm.getPhoneType() == TelephonyManager.PHONE_TYPE_GSM)
        {
            Toast.makeText(getApplicationContext(), "GSM", Toast.LENGTH_LONG).show();
        }
        else
        {

        }
    return  true;
    }

    public  void sms(View view)
    {
        startActivity(new Intent(this, sms.class));
    }
    public  void mail(View view)
    {
        startActivity(new Intent(this, mail.class));
    }
    public  void call(View view)
    {
        startActivity(new Intent(this, calling.class));
    }

}
