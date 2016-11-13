package com.techpalle.flipkartapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView tv6, tv7, tv8, tv9, tv10, tv11;
    Button b2, b3;
    String item, price;
    public static final int REQ_CD1 = 1;
    //this is request for my firstchild (third)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //now we receive data from 1stscreen
        final Intent in = getIntent();
        Bundle b = in.getExtras();
        item = b.getString("item");
        price = b.getString("price");


        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        tv6 = (TextView) findViewById(R.id.textView6);
        tv7 = (TextView) findViewById(R.id.textView7);
        tv8 = (TextView) findViewById(R.id.textView8);
        tv9 = (TextView) findViewById(R.id.textView9);
        tv10 = (TextView) findViewById(R.id.textView10);
        tv11 = (TextView) findViewById(R.id.textView11);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String name="ccavenue";
                Intent in = new Intent(Main2Activity.this, Main3Activity.class);
                in.putExtra("item", "item");
                in.putExtra("price", "price");
                in.putExtra("name", "CCAvenue");
                startActivityForResult(in, REQ_CD1);


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Main2Activity.this, Main3Activity.class);
                in.putExtra("item", "item");
                in.putExtra("price", "price");
                in.putExtra("name", "paypal");
                startActivityForResult(in, REQ_CD1);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent in) {
        //if any data come from child screen,we will catch here


            //making textview visible
        tv6.setVisibility(View.VISIBLE);
        tv7.setVisibility(View.VISIBLE);
        tv8.setVisibility(View.VISIBLE);
        tv9.setVisibility(View.VISIBLE);
        tv10.setVisibility(View.VISIBLE);
        tv11.setVisibility(View.VISIBLE);

        Bundle b=in.getExtras();
        tv6.setText("item:"+item);
        tv7.setText("price:"+price);


        String bankacno=b.getString("bankacno");
        String ifsc=b.getString("ifsc");
        String bankname=b.getString("bankname");
        String address=b.getString("address");

        tv8.setText("bankacno:"+bankacno);
        tv9.setText("bankname:"+bankname);
        tv10.setText("address:"+address);

            if (requestcode == REQ_CD1) {
                //if control comes here ,means user has successfully paid amount
                if(resultcode==RESULT_OK){
                    tv11.setText("status:"+"success");
            }else {
                    tv11.setText("status:"+"failure");
                }
        }
            //this should be always is the endin on_activity_result
       // super.onActivityResult(requestcode,resultcode,in);
    }
}