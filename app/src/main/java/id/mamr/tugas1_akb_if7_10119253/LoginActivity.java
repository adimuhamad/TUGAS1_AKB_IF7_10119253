package id.mamr.tugas1_akb_if7_10119253;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private EditText inUsername, inPassword;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setData();
        goRegister();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void initView(){
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        inUsername = findViewById(R.id.in_username);
        inPassword = findViewById(R.id.in_password);
    }

    public void setData(){

        btnLogin.setOnClickListener(v -> {
            username = inUsername.getText().toString();
            // action
            if( TextUtils.isEmpty(inUsername.getText())){
                inUsername.setError( "Username is required!" );
            }else if ( TextUtils.isEmpty(inPassword.getText())) {
                inPassword.setError( "Password is required!" );
            }else {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void goRegister(){
        btnRegister.setOnClickListener(v -> {
            // action
            Intent intent = new Intent( LoginActivity.this, RegisterActivity.class );
            startActivity(intent);
        });
    }
}

//Tanggal Pengerjaan : 23 April 2022
//NIM : 10119253
//Nama : Mochamad Adi Maulia Rahman
//Kelas : IF-7