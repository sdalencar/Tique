package com.allin.sdainfo.tique.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allin.sdainfo.tique.R;

public class ViewHolderLoja extends RecyclerView.ViewHolder {
    public TextView nome, endereco, telefone, responsavel;

    public ViewHolderLoja(@NonNull View itemView) {
        super(itemView);

        nome = itemView.findViewById(R.id.tv_adapter_loja_nome);
        endereco = itemView.findViewById(R.id.tv_adapter_loja_endereco);
        telefone = itemView.findViewById(R.id.tv_adapter_loja_telefone);
        responsavel = itemView.findViewById(R.id.tv_adapter_loja_responsavel);
    }
}
