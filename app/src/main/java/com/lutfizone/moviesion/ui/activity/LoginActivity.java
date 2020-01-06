package com.lutfizone.moviesion.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lutfizone.moviesion.PreferenceLogin;
import com.lutfizone.moviesion.R;
import com.lutfizone.moviesion.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private PreferenceLogin login;
    private EditText etNim; // form input nim
    private EditText etPass; // form input password
    private Button btnLogin; // tombol login

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        login = PreferenceLogin.getInstance(getApplicationContext());
        login.setPass("123456");
    }

    @Override
    public void findView() {
        etNim = findViewById(R.id.login_Nim);
        etPass = findViewById(R.id.loginPass);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void initView() {

    }


    @Override
    public void loadView() {

    }

    @Override
    public void listener() {
        btnLogin.setOnClickListener(v -> {
            // ambil isi dari form
            String nim = etNim.getText().toString();
            String pass = etPass.getText().toString();
            // pengecekan nama dan nim
            if ((nim.equals("17.11.0953")
                    || nim.equals("17.11.0937")
                    || nim.equals("17.11.0972"))
                    && pass.equals("123456")) {
                // set login
                login.setLogin(true);
                login.setNim(nim);

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show(); // tampilkan psesan berhasil login

                // pindah ke tampilan main
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

            } else if (nim.equals("") && pass.equals("")) {

                Toast.makeText(this, "Nim dan Password harus diisi", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Input Nim atau Password anda salah", Toast.LENGTH_SHORT).show();

            }

        });
    }

}
