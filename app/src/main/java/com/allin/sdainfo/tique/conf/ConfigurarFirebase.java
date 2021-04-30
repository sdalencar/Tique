package com.allin.sdainfo.tique.conf;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfigurarFirebase {

    public static DatabaseReference referencia_banco_dados;
    public static FirebaseAuth referencia_autenticacao;
    public static StorageReference referencia_storage;


    public static DatabaseReference getBanco_dados() {
        if (referencia_banco_dados == null) {
            referencia_banco_dados = FirebaseDatabase.getInstance().getReference();
        }
        return referencia_banco_dados;
    }

    public static FirebaseAuth getAutenticado() {
        if (referencia_autenticacao == null) {
            referencia_autenticacao = FirebaseAuth.getInstance();
        }
        return referencia_autenticacao;
    }

    public static StorageReference getStorage() {
        if (referencia_storage == null) {
            referencia_storage = FirebaseStorage.getInstance().getReference();
        }
        return referencia_storage;
    }

    //retorno id_usuario
    public static String getIdUsuario(){
        FirebaseAuth userId = getAutenticado();
        return  userId.getCurrentUser().getUid();
    }
}
