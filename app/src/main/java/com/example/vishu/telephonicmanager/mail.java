package com.example.vishu.telephonicmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mail extends AppCompatActivity {


    EditText mailid,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        mailid=(EditText)findViewById(R.id.editText3);
        msg=(EditText)findViewById(R.id.editText4);
        send=(Button) findViewById(R.id.button5);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=mailid.getText().toString();
                String message=msg.getText().toString();

                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{mail});
                //email.putExtra(Intent.EXTRA_CC,);
                //email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT,message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"choose an email client"));
            }
        });

    }
}
