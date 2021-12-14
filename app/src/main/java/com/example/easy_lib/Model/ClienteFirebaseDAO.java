package com.example.easy_lib.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ClienteFirebaseDAO implements IClienteDAO{

    private DatabaseReference databaseReference;
    private final String father = Cliente.class.getSimpleName();

    public ClienteFirebaseDAO(){
        //INSTANCIA O BANCO DE DADOS
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        //REFERENCIA DO BANCO DE DADOS
        databaseReference = db.getReference();
    }

    @Override
    public void insertCliente(Cliente cliente) {
        //INSERE O CLIENTE
        databaseReference.child(father).push().setValue(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {

    }

    @Override
    public void deleteCliente(String cpf) {

    }

    @Override
    public List<Cliente> getTodosClientes() {
        return null;
    }

    @Override
    public Cliente getCliente(String cpf) {
        return null;
    }

    @Override
    public List<Cliente> getClientePorNome(String nome) {
        return null;
    }

    @Override
    public int getQuantidadeClientes() {
        return 0;
    }
}
