package com.techpalle.flipkartapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3;
    EditText et1,et2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText) findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic for check out button
                String item = null;
                String price = null;
                if (cb1.isChecked() == true) {
                    item = "shoes";
                    price = "INR 2000";
                } else if (cb2.isChecked() == true) {
                    item = "jewellery";
                    price = "INR 25000";

                } else if (cb3.isChecked() == true) {
                    item = "T-shirt";
                    price = "INR 750";
                }

                //send item and price to secod screen
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("item", item);
                intent.putExtra("price", price);
                startActivity(intent);

            }
        });
    
    }
}


































