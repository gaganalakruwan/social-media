package com.example.gagana.socialmedia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText email,pasword,cpasword;
    private Button btnreg;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth =FirebaseAuth.getInstance();

        email=(EditText)findViewById(R.id.register_email);
        pasword=(EditText)findViewById(R.id.register_passwrd);
        cpasword=(EditText)findViewById(R.id.registercpasword);
        btnreg=(Button)findViewById(R.id.btnok);
        loadingBar =new ProgressDialog(this);

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewAcc();
            }
        });
    }
    private void CreateNewAcc()
    {
        String emil=email.getText().toString();
        String password=pasword.getText().toString();
        String ConfirmPassword=cpasword.getText().toString();

        if(TextUtils.isEmpty(emil))
        {
            Toast.makeText(this,"Please Write Your Email",Toast.LENGTH_SHORT);
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please Write Your Password",Toast.LENGTH_SHORT);
        }

        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please Confirm Your Password",Toast.LENGTH_SHORT);
        }
        else if(!password.equals(ConfirmPassword))
        {
            Toast.makeText(this,"Password Does not Match",Toast.LENGTH_SHORT);
        }
        else
        {
            loadingBar.setTitle("Creating new account");
            loadingBar.setMessage("Please waite while for creating account");
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);
            mAuth.createUserWithEmailAndPassword(emil,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        SendusertoProfile();
                        Toast.makeText(RegisterActivity.this,"Your Account Create Successful",Toast.LENGTH_SHORT);
                        loadingBar.dismiss();
                    }
                    else
                    {
                        String message = task.getException().getMessage();
                        Toast.makeText(RegisterActivity.this,"Error Occurd",Toast.LENGTH_SHORT);
                        loadingBar.dismiss();
                    }

                }
            });
        }
    }

    private void SendusertoProfile()
    {
        Intent profileact=new Intent(RegisterActivity.this,ProfileActivity.class);
        profileact.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(profileact);
        finish();
    }
}
