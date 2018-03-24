package com.example.apurva.sharedprefrencesexamole;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button save,load,go_next;
    EditText name;
    TextView saved_data;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save=findViewById(R.id.btn_save);
        load=findViewById(R.id.btn_load);
        name=findViewById(R.id.et_name);
        go_next=findViewById(R.id.btn_next);
        saved_data=findViewById(R.id.tv_save_data);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences=getSharedPreferences("MySavedData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("myValue",name.getText().toString());
                editor.apply();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saved_data.setText(sharedPreferences.getString("myValue","Data not found"));
            }
        });
        go_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
