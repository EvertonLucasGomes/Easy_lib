package com.example.easy_lib.Controller;

import androidx.annotation.NonNull;

import com.example.easy_lib.Model.Cliente;
import com.example.easy_lib.Model.ClienteFirebaseDAO;
import com.example.easy_lib.View.IClienteView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class OnClienteController implements IOnClienteController{

    private IClienteView view;
    private ClienteFirebaseDAO clienteFirebaseDAO;

    public OnClienteController(IClienteView view) {
        this.view = view;
        clienteFirebaseDAO = new ClienteFirebaseDAO();
    }

    @Override
    public void insertCliente(String nome, String cpf, String data_nascimento, String telefone, String rua, String numero, String bairro, String cidade) {

        //INSTANCIA DO CLIENTE
        Cliente cliente = new Cliente(cpf, nome.toUpperCase(), data_nascimento, telefone, cidade, bairro, rua, numero);

        //VALIDA OS CAMPOS
        if(onValidarCampos(cliente)) {
            clienteFirebaseDAO.insertCliente(
                    cliente
            ).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    //SUCESSO AO REALIZAR O INSERT
                    view.limparCampos();

                    //MENSAGEM DE SUCESSO
                    view.showMensagem("Cliente salvo");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    //CASO OCORRA ALGUM ERROR
                    view.showMensagem("Error ao salvar o Cliente");
                }
            });
        }
        else{
            //CAMPOS FAZIOS
            view.showMensagem("Preencha os Campos Obrigatórios");
        }
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

    @Override
    public boolean onValidarCampos(Cliente cliente) {
        if(cliente.getCpf().isEmpty() || cliente.getNome().isEmpty() || cliente.getData_nascimento().isEmpty()
                || cliente.getTelefone().isEmpty() || cliente.getCidade().isEmpty() || cliente.getBairro().isEmpty()
                || cliente.getRua().isEmpty() || cliente.getNumero_complemento().isEmpty())
            //ALGUM CAMPO VAZIO
            return false;

        //CAMPOS NÃO VAZIOS
        return true;
    }
}
