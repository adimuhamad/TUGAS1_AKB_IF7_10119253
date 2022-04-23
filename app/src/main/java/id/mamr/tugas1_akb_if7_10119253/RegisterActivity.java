package id.mamr.tugas1_akb_if7_10119253;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister, btnLogin;
    private EditText inUsername, inEmail, inPassword, inRepassword;
    private String username, password, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setData();
        backLogin();
    }

    public void onBackPressed() {
        finish();
    }

    public void initView(){
        btnRegister = findViewById(R.id.btn_register);
        btnLogin = findViewById(R.id.btn_login);
        inUsername = findViewById(R.id.in_username);
        inEmail = findViewById(R.id.in_email);
        inPassword = findViewById(R.id.in_password);
        inRepassword = findViewById(R.id.in_repassword);
    }

    public void setData() {
        btnRegister.setOnClickListener(v -> {

            username = inUsername.getText().toString();
            password = inPassword.getText().toString();
            repassword = inRepassword.getText().toString();

            // action
            if( TextUtils.isEmpty(inUsername.getText())){
                inUsername.setError( "Username is required!" );
            }else if ( TextUtils.isEmpty(inEmail.getText())) {
                inEmail.setError( "Email is required!" );
            }else if ( TextUtils.isEmpty(inPassword.getText())) {
                inPassword.setError( "Password is required!" );
            }else if ( TextUtils.isEmpty(inRepassword.getText())) {
                inRepassword.setError("Please confirm password!");
            } else if (!password.equals(repassword)){
                Toast.makeText(RegisterActivity.this, "Password don't match!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
                Toast.makeText(RegisterActivity.this, "Register success!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void backLogin(){
        btnLogin.setOnClickListener(v -> {
            // action
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
        });
    }
}

//Tanggal Pengerjaan : 23 April 2022
//NIM : 10119253
//Nama : Mochamad Adi Maulia Rahman
//Kelas : IF-7