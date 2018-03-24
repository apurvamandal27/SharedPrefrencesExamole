package com.example.apurva.sharedprefrencesexamole;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView myTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myTextview=findViewById(R.id.textView);

        SharedPreferences sharedPreferences=getSharedPreferences("MySavedData", Context.MODE_PRIVATE);
        String data=sharedPreferences.getString("myValue","Data not found");
        myTextview.setText(data);
    }
}
