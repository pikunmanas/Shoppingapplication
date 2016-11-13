package com.techpalle.flipkartapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView tv2,tv3,tv4;
    EditText et3,et5,et6,et7;
    Button b4,b5;
    String name,price,item;



    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
        tv4=(TextView)findViewById(R.id.textView4);
        et3=(EditText)findViewById(R.id.editText3);
        et5=(EditText)findViewById(R.id.editText5);
        et6=(EditText)findViewById(R.id.editText6);
        et7=(EditText)findViewById(R.id.editText7);
        b4= (Button) findViewById(R.id.button4);
        b5= (Button) findViewById(R.id.button5);

            //we will read data from second acricity
            Intent in = getIntent();
            Bundle bd=in.getExtras();
            item=bd.getString("item");
            price=bd.getString("price");
            name=bd.getString("name");
            tv2.append(name);
            tv3.append(item);
            tv4.append(price);





        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String ifsc = et5.getText().toString();
                String bankname = et6.getText().toString();
                String address = et7.getText().toString();

                Intent in = new Intent();
                in.putExtra("bankacno", et3.getText().toString());
                in.putExtra("ifsc", ifsc);
                in.putExtra("bankname", bankname);
                in.putExtra("address", address);
                setResult(RESULT_OK, in);
                finish();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bankacno=et3.getText().toString();
                String ifsc=et5.getText().toString();
                String bankname=et6.getText().toString();
                String address=et7.getText().toString();

                Intent in=new Intent();
                in.putExtra("bankacno",bankacno);
                in.putExtra("ifsc",ifsc);
                in.putExtra("bankname",bankname);
                in.putExtra("address",address);
                setResult(RESULT_CANCELED,in);
                finish();
            }
        });

    }
}
