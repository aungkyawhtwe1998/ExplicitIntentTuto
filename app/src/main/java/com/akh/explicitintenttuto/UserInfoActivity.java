package com.akh.explicitintenttuto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class UserInfoActivity extends AppCompatActivity {

    EditText edtName,edtEmail,edtphone,edtage;
    RadioGroup rdbGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        edtName = findViewById(R.id.edt_user_name);
        edtEmail = findViewById(R.id.edt_user_email);
        edtphone = findViewById(R.id.edt_user_phone);
        edtage = findViewById(R.id.edt_user_age);
        rdbGroup = findViewById(R.id.radio_gender);

    }

    public void onClickBtnSave(View view) {
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtphone.getText().toString();
        int age= Integer.parseInt(edtage.getText().toString());

        String gender ="";
        int id= rdbGroup.getCheckedRadioButtonId();
        if(id == R.id.rdb_male){
            gender = "Male";
        }else {
            gender = "Female";
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("email", email);
        intent.putExtra( "phone", phone);
        intent.putExtra("age",age);
        intent.putExtra("gender",gender);
        setResult(1,intent);
        finish();

    }
}