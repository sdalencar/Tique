package com.allin.sdainfo.tique.act;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaSession2Service;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.allin.sdainfo.tique.R;
import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Mensagens;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {

    private Mensagens msg;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        auth = ConfigurarFirebase.getAutenticado();

        msg = new Mensagens(getApplicationContext());
    }


    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.bt_01:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_02:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_03:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_04:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_05:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_06:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_07:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_08:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_09:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_10:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_11:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_12:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_13:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_14:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_15:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_16:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_17:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_18:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_19:
                startActivity(new Intent(this, LojaActivity.class));
                break;
            case R.id.bt_20:
                confirmarSaida();
                break;


        }

    }

    private void confirmarSaida() {
        new AlertDialog.Builder(this)
                .setTitle("sair da aplicação.")
                .setMessage("tem certeza que quer fechar aplicação?.")
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        msg.msgLonga("saindo...");
                        //auth.signOut();
                    }
                })
                .create()
                .show();
    }


}