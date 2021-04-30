package com.allin.sdainfo.tique.act;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.allin.sdainfo.tique.R;
import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Mensagens;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Mensagens msg;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = new Mensagens(getApplicationContext());
        autenticacao = ConfigurarFirebase.getAutenticado();

        tipoLogin();

    }

    public void onClickLogar(View view) {
        alertaLogar();
    }


    private void alertaLogar() {
        new AlertDialog.Builder(this)
                .setTitle("Tela de Login")
                .setMessage("Preencha os campos para entrar no sistema.")
                .setView(R.layout.login)
                .setCancelable(false)
                .setPositiveButton("Logar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText eemail = ((Dialog) dialogInterface).findViewById(R.id.et_logar_email);
                        EditText esenha = ((Dialog) dialogInterface).findViewById(R.id.et_logar_senha);
                        logar(eemail.getText().toString(), esenha.getText().toString());

                    }
                })
                .create()
                .show();
    }

    private void logar(String nome, String senha) {

        if (!nome.isEmpty()) {
            if (!senha.isEmpty()) {
                autenticacao.signInWithEmailAndPassword(nome, senha)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            tipoLogin();
                        } else {
                            msg.msgLonga("Erro: " + task.getException());
                        }
                    }
                })
                ;
            } else {
                msg.msgCurta("Preencha a senha");
            }
        } else {
            msg.msgCurta("Preencha o e-mail");
        }
    }

    private void tipoLogin() {
        startActivity(new Intent(MainActivity.this, AdminActivity.class));
    }
}