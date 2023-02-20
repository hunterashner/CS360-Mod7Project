package com.example.module7project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private EditText _username;
    private EditText _password;
    private Button _createAccountButton;
    private myDbAdapter _adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _username = (EditText) findViewById(R.id.loginEmailAddressField);
        _password = (EditText) findViewById(R.id.loginPasswordField);
        _createAccountButton = (Button) findViewById(R.id.createAccountButton);
        _adapter = new myDbAdapter(this);
    }

    //Add new user to the database
    public void addUser(View view){
        String field1 = _username.getText().toString();
        String field2 = _password.getText().toString();
        if(field1.isEmpty() || field2.isEmpty()){
            Message.message(getApplicationContext(), "Both username and password required");
        } else {
            long id = _adapter.insertData(field1, field2);
            if(id <= 0){
                Message.message(getApplicationContext(), "Database Insertion Unsuccessful");
                _username.setText("");
                _password.setText("");
            } else {
                Message.message(getApplicationContext(), "Database Insertion Successful");
                _username.setText("");
                _password.setText("");
                Dashboard.doInitilization(this);
            }
        }
    }

    //test user against database need to add conditional logic to handle login
    public void submitLogin(View view){
        String field1 = _username.getText().toString();
        String field2 = _password.getText().toString();
        if(field1.isEmpty() || field2.isEmpty()){
            Message.message(getApplicationContext(), "Username and Password Required.");
        } else {

        }
    }

    public void viewData(View view){
        String data = _adapter.getData();
        Message.message(this, data);
    }
}