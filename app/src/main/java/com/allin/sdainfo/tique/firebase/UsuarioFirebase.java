package com.allin.sdainfo.tique.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.allin.sdainfo.tique.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class UsuarioFirebase {

    public static String getUsuarioId() {
        FirebaseAuth usuario = ConfigurarFirebase.getAutenticado();
        String idUser = usuario.getCurrentUser().getUid();

        return idUser;
    }

    public static FirebaseUser getUsuarioAtual() {
        FirebaseAuth usuario = ConfigurarFirebase.getAutenticado();
        return usuario.getCurrentUser();
    }

    public static boolean atualizarNomeUsuario(String nome) {
        try {
            FirebaseUser firebaseUser = getUsuarioAtual();
            UserProfileChangeRequest perfil = new UserProfileChangeRequest.Builder()
                    .setDisplayName(nome)
                    .build();
            firebaseUser.updateProfile(perfil).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (!task.isSuccessful()) {
                        Log.d("Perfil", "erro atualizar nome");
                    }
                }
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static Usuario getUsuarioLogado() {

        FirebaseUser usuario_logado = getUsuarioAtual();

        Usuario usuario = new Usuario();
        usuario.setNome(usuario_logado.getDisplayName());
        usuario.setEmail(usuario_logado.getEmail());

        return usuario;
    }

    public void salvarUsuario() {
        DatabaseReference banco = ConfigurarFirebase.getBanco_dados();
        DatabaseReference usuario = banco.child(Constantes.NOH_USUARIO).child(getUsuarioId());
        usuario.setValue(this);
    }
    public void deletarUsuario() {// arrumar codigo
        DatabaseReference banco = ConfigurarFirebase.getBanco_dados();
        DatabaseReference usuario = banco.child(Constantes.NOH_USUARIO).child(getUsuarioId());
        usuario.setValue(this);
    }

    public void atualizarUsuario() {
        String usuario = UsuarioFirebase.getUsuarioId();
        DatabaseReference banco = ConfigurarFirebase.getBanco_dados();
        DatabaseReference noh_usuario_filho = banco.child(Constantes.NOH_USUARIO).child(usuario);

        Map<String, Object> dados_atualizar = converterEmMap();

        noh_usuario_filho.updateChildren(dados_atualizar);
    }

    @Exclude
    public Map<String, Object> converterEmMap() {
        HashMap<String, Object> map_usuario = new HashMap<>();
        map_usuario.put(Constantes.NOME, getUsuarioLogado().getNome());//getNome());
        map_usuario.put(Constantes.EMAIL,getUsuarioLogado().getEmail());//getEmail());
        map_usuario.put(Constantes.SENHA, getUsuarioLogado().getSenha());//getSenha());
        return map_usuario;
    }


}
