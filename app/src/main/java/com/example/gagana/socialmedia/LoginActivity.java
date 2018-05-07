package com.example.gagana.socialmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button loginbtn;
    private EditText txtpswrd,txtemail;
    private TextView txtview;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtview=(TextView) findViewById(R.id.txtcreteacc);
        txtemail=(EditText)findViewById(R.id.login_email);
        txtpswrd=(EditText)findViewById(R.id.login_passwrd);
        loginbtn=(Button)findViewById(R.id.btnlog);

       mAuth=FirebaseAuth.getInstance();

        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Goregister();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoLogin();
            }
        });
    }

    private void GoLogin()
    {
        String Uemail=txtemail.toString();
        String Upassword=txtpswrd.toString();

        if(TextUtils.isEmpty(Uemail))
        {
            Toast.makeText(this,"Please Enter Your Email",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(Upassword))
        {
            Toast.makeText(this,"Please Enter Your Password",Toast.LENGTH_SHORT).show();
        }
    }

    private  void Goregister()
    {
        Intent registerintent=new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(registerintent);
    }
}
