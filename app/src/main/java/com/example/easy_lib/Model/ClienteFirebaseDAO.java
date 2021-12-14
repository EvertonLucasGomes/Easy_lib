package com.example.easy_lib.Model;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

public class ClienteFirebaseDAO implements IClienteFirebaseDAO{

    private DatabaseReference databaseReference;
    private final String father = Cliente.class.getSimpleName();

    public ClienteFirebaseDAO(){
        //INSTANCIA O BANCO DE DADOS
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        //REFERENCIA DO BANCO DE DADOS
        databaseReference = db.getReference();
    }

    @Override
    public Task<Void> insertCliente(Cliente cliente) {
        //.d("ENTROU", "insertCliente: " + cliente);
        //CPF PARA PAI DO NÓ SEM PONTOS E TRAÇOS
        String cpf_formated = cliente.getCpf().replace(".", "").replace("-", "");

        //ADICIONA NO BD
        return databaseReference.child(father).child(cpf_formated).setValue(cliente);
    }

    @Override
    public Task<Void> updateCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Task<Void> deleteCliente(String cpf) {
        return null;
    }

    @Override
    public Query getTodosClientes() {
        return null;
    }

    @Override
    public Query getCliente(String cpf) {
        return null;
    }

    @Override
    public Query getClientePorNome(String nome) {
        return null;
    }

    @Override
    public Query getQuantidadeClientes() {
        return null;
    }
}
