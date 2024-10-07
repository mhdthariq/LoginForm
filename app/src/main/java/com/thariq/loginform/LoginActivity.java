package com.thariq.loginform;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);

        // Optionally pre-set a default username/password for testing
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "admin");
        editor.putString("password", "password123");
        editor.apply();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String inputUsername = etUsername.getText().toString().trim();
        String inputPassword = etPassword.getText().toString().trim();
        String savedUsername = sharedPreferences.getString("username", null);
        String savedPassword = sharedPreferences.getString("password", null);

        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
