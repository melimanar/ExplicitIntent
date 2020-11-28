package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="meli" ;
    TextView txtShow;
Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showInfo(View view) {
        Intent intent=new Intent(getApplicationContext(),userInfoActivity.class);
        startActivityForResult(intent,1);
        txtShow=findViewById(R.id.txtShow);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==1)
        {
            User user= (User) data.getSerializableExtra("obj");
            String name=user.getUsername();
            String email=user.getEmail();
            String phone=user.getPhone();
            int age=user.getAge();
            String gender=user.getGender();
            txtShow.setText("Name : "+name+"\n Email : "+email+"\n Phone : "+phone+"\n Age : "+age+"\n Gender : "+gender);

        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: "+"event");
    }
}
