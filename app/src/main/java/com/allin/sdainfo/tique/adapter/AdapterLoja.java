package com.allin.sdainfo.tique.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.allin.sdainfo.tique.R;
import com.allin.sdainfo.tique.model.Loja;
import com.allin.sdainfo.tique.view.ViewHolderLoja;

import java.util.List;

public class AdapterLoja extends RecyclerView.Adapter<ViewHolderLoja> {

    private List<Loja> listaLoja;
    private Context context;

    public AdapterLoja(List<Loja> lojas, Context context) {
        this.listaLoja = lojas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderLoja onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_loja, parent, false);

        return new ViewHolderLoja(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLoja holder, int position) {

        Loja nome = listaLoja.get(position);
        holder.nome.setText(nome.getNome());
        holder.endereco.setText(nome.getEndereco());
        holder.telefone.setText(nome.getTelefone());
        holder.responsavel.setText(nome.getResponsavel());

    }

    @Override
    public int getItemCount() {
        return listaLoja.size();
    }
}
