package com.example.easy_lib.View;

import com.google.firebase.database.Query;

public interface IClienteView {
    void exibirClientes(Query query);
    void exibirCliente(Query query);
    void exibirClientesPorNome(Query query);
    void exibirQuantidadeClientes(Query query);

    void showMensagem(String mensagem);
}
