package com.huriati.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    MaterialEditText username, email, password;
    Button regsiter;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        regsiter = findViewById(R.id.signUp);

        regsiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
