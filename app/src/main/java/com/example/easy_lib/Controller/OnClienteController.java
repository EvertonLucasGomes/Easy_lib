package com.example.easy_lib.Controller;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.easy_lib.Model.Cliente;
import com.example.easy_lib.Model.ClienteFirebaseDAO;
import com.example.easy_lib.Model.ICliente;
import com.example.easy_lib.View.IClienteView;

public class OnClienteController implements IOnClienteController{

    private IClienteView view;
    private ClienteFirebaseDAO clienteFirebaseDAO;

    public OnClienteController(IClienteView view) {
        this.view = view;
        clienteFirebaseDAO = new ClienteFirebaseDAO();
    }

    @Override
    public void insertCliente(String nome, String cpf, String data_nascimento, String telefone, String rua, String numero, String bairro, String cidade) {
        clienteFirebaseDAO.insertCliente(
                new Cliente(
                        cpf,
                        nome,
                        data_nascimento,
                        telefone,
                        cidade,
                        bairro,
                        rua,
                        numero
                )
        );
    }

    @Override
    public void updateCliente(String nome, String cpf, String data_nascimento, String telefone, String rua, String numero, String bairro, String cidade) {

    }

    @Override
    public void deleteCliente(String cpf) {

    }

    @Override
    public void onExibirTodosClientes() {

    }

    @Override
    public void onExibirCliente(String cpf) {

    }

    @Override
    public void onExibirClientesPorNome(String nome) {

    }

    @Override
    public void onExibirQuantidadeClientes() {

    }
}
