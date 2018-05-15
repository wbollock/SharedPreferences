package com.example.wbollock.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView buckysText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        buckysText = (TextView) findViewById(R.id.buckysText);

    }

    //Save users login info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit(); //give us object that we can use to write to the file
        editor.putString("username",usernameInput.getText().toString());// make a key called username, and the value is whatever the user typed in
        editor.putString("password",passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Save", Toast.LENGTH_LONG).show(); // whenever button clicked, toast notification
    }

    //print out the saved data
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", ""); // find the username and return the second value, which is empty to make room for the input
        String pw = sharedPref.getString("password", ""); // second parameter is what it returns
        buckysText.setText(name + " " + pw);

    }

}
