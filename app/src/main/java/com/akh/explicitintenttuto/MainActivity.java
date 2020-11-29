package com.akh.explicitintenttuto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtShowText;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShowText= findViewById(R.id.showText);
    }
    public void onClickBtn(View view) {
        Intent intent = new Intent(getApplicationContext(),UserInfoActivity.class);
        startActivityForResult(intent,1);

    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && requestCode == 1){
            String name = data.getStringExtra("name");
            String email = data.getStringExtra("email");
            String phone = data.getStringExtra("phone");
            int age = data.getIntExtra("age",0);
            String gender = data.getStringExtra("gender");

            txtShowText.setText("Name :" +name+"\n Email : "+email+"\n phone : "+ phone +"\n age : "+age + "\n gender : "+ gender);
        }
    }*/

     @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && requestCode == 1){
            User user = (User) data.getSerializableExtra("obj");
            String name= user.getUsername();
            String email= user.getEmail();
            String phone= user.getPhone();
            int age= user.getAge();
            String gender=user.getGender();
            txtShowText.setText("Name :"+name+"\n Email: "+email+"\n phone: "+phone+"\n age: "+ age+"\n gender: "+gender);
        }
    }
}