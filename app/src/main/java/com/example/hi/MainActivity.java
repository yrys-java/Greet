package com.example.hi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextPersonName;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        if (savedInstanceState != null && name.isEmpty()) {
            name = savedInstanceState.getString("name");
            display((name));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",name);
    }


    public void button(View view) {
        name = (editTextTextPersonName.getText().toString());

        if (TextUtils.isEmpty(editTextTextPersonName.getText())) {
            Context context = getApplicationContext();
            CharSequence text = "Input your name, please!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            display("Hello, " +name);
        }
    }


    public void display(String name) {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(name);
    }

}