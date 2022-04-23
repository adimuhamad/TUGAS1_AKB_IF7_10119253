package id.mamr.tugas1_akb_if7_10119253;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvUsername;
    private Button btnProfil, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
        profilView();
        logOut();
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void initView(){
        tvUsername = findViewById(R.id.txt_username);
        btnLogout = findViewById(R.id.btn_logout);
        btnProfil = findViewById(R.id.btn_profil);
    }

    public void setData(){
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        tvUsername.setText(username);
    }

    public void profilView(){
        btnProfil.setOnClickListener(v -> {
            // action
            Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
            startActivity(intent);
        });
    }

    public void logOut(){
        btnLogout.setOnClickListener(v -> {
            // action
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure want to logout?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            MainActivity.super.onBackPressed();
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }
}

//Tanggal Pengerjaan : 23 April 2022
//NIM : 10119253
//Nama : Mochamad Adi Maulia Rahman
//Kelas : IF-7