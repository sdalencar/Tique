package com.allin.sdainfo.tique.firebase;

import com.allin.sdainfo.tique.conf.ConfigurarFirebase;
import com.allin.sdainfo.tique.helper.Constantes;
import com.allin.sdainfo.tique.model.Funcionario;
import com.allin.sdainfo.tique.model.Cliente;
import com.google.firebase.database.DatabaseReference;

public class ClienteFirebase {

    public void salvarPessoa() {
        Cliente id_funcionario = new Cliente();
        DatabaseReference tabela_funcionario = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_FUNCIONARIO);
        tabela_funcionario.child(id_funcionario.getId()).setValue(this);
    }


    public void deletarFuncionario(Funcionario funcionario) {
        String id_user = funcionario.getId();
        DatabaseReference tabela_funcionario = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_FUNCIONARIO).child(id_user);
        tabela_funcionario.removeValue();
    }


    public void atualizarFuncionario(String id_funcionario) {
        DatabaseReference tabela_funcionario = ConfigurarFirebase.getBanco_dados().child(Constantes.NOH_FUNCIONARIO);
        tabela_funcionario.child(id_funcionario).setValue(this);
    }

}
