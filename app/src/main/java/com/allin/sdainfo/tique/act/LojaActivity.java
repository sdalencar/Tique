package com.allin.sdainfo.tique.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allin.sdainfo.tique.R;
import com.allin.sdainfo.tique.adapter.AdapterLoja;
import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.allin.sdainfo.tique.helper.Mensagens;
import com.allin.sdainfo.tique.helper.RecyclerItemClickListener;
import com.allin.sdainfo.tique.model.Loja;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LojaActivity extends AppCompatActivity {

    private EditText enome, eendereco, etelefone, eresponsavel;
    private Mensagens msg;

    private FirebaseAuth autentincacao;
    private RecyclerView recyclerViewPublico;
    private AdapterLoja adapterLoja;
    private List<Loja> listaLoja = new ArrayList<>();
    private DatabaseReference tb_loja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);

        Toolbar toolbar = findViewById(R.id.tb_loja_cad);
        toolbar.setTitle(R.string.voltar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_voltar);


        iniciarComponentes();

        recyclerViewPublico.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPublico.setHasFixedSize(true);
        adapterLoja = new AdapterLoja(listaLoja, this);
        recyclerViewPublico.setAdapter(adapterLoja);

        listarNomeLoja();
        recyclerViewPublico.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerViewPublico, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Loja nome = listaLoja.get(position);

                //Intent intent = new Intent(LojaActivity.this, EditarLojaActivity.class);
                //intent.putExtra(Constantes.NOH_NOME_LOJA, nome);
                //startActivity(intent);

                enome.setText(nome.getNome());
                eendereco.setText(nome.getEndereco());
                etelefone.setText(nome.getTelefone());
                eresponsavel.setText(nome.getResponsavel());
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }
        ));

    }

    private void listarNomeLoja() {
        tb_loja = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_NOME_LOJA);
        tb_loja.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaLoja.clear();
                for (DataSnapshot nomes : snapshot.getChildren()) {
                    Loja nome = nomes.getValue(Loja.class);
                    listaLoja.add(nome);
                }

                Collections.reverse(listaLoja);
                adapterLoja.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }


    private void iniciarComponentes() {

        msg = new Mensagens(getApplicationContext());

        recyclerViewPublico = findViewById(R.id.rv_loja);

        enome = findViewById(R.id.et_loja_nome);
        eendereco = findViewById(R.id.et_loja_endereco);
        etelefone = findViewById(R.id.et_loja_telefone);
        eresponsavel = findViewById(R.id.et_loja_responsavel);

        Button bt_salvar = findViewById(R.id.bt_loja_salvar);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarCampos();
            }
        });

    }

    private void verificarCampos() {

        String nome = enome.getText().toString();
        String endereco = eendereco.getText().toString();
        String telefone = etelefone.getText().toString();
        String responsavel = eresponsavel.getText().toString();

        if (!nome.isEmpty()) {
            if (!endereco.isEmpty()) {
                if (!telefone.isEmpty()) {
                    if (!responsavel.isEmpty()) {
                        dadosCadastro(nome, endereco, telefone, responsavel);
                    } else {
                        msg.msgCurta("digite o nome do responsável.");
                    }
                } else {
                    msg.msgCurta("digite o telefone.");
                }
            } else {
                msg.msgCurta("digite o endereço.");
            }
        } else {
            msg.msgCurta("digite o nome.");
        }


    }

    private void dadosCadastro(String nome, String endereco, String telefone, String responsavel) {
        Loja nomeLoja = new Loja();
        nomeLoja.setNome(nome);
        nomeLoja.setEndereco(endereco);
        nomeLoja.setTelefone(telefone);
        nomeLoja.setResponsavel(responsavel);

        nomeLoja.salvarLojaDados();

        limparCampos();
    }

    private void limparCampos() {
        enome.setText("");
        eendereco.setText("");
        etelefone.setText("");
        eresponsavel.setText("");
    }


}