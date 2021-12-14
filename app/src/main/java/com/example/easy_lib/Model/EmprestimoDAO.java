package com.example.easy_lib.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO  implements IEmprestimoDAO {

    Context mcontext;

    public EmprestimoDAO(Context context) {
        mcontext = context;
    }


    @Override
    public void insertEmprestimo(Emprestimo emprestimo) {
        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_DATA_EMPRESTIMO, emprestimo.getDataEmprestimo());
        values.put(COLUNA_DATA_DEVOLUCAO, emprestimo.getDataDevolucao());
        values.put(COLUNA_STATUS, emprestimo.getStatus());
        values.put(COLUNA_CPF_USUARIO, emprestimo.getCpfUsuario());
        values.put(COLUNA_CODIGO_LIVRO, emprestimo.getCodLivro());

        db.insert(TABELA_EMPRESTIMO, null, values);
        db.close();


    }

    @Override
    public void deleteEmprestimo(int codigo) {
        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();


        db.delete(
                TABELA_EMPRESTIMO,
                COLUNA_CODIGO + " = ?",
                new String[]{String.valueOf(codigo)}
        );

        db.close();


    }

    @Override
    public void updateEmprestimo(Emprestimo emprestimo) {

        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(COLUNA_DATA_EMPRESTIMO, emprestimo.getDataEmprestimo());
        values.put(COLUNA_DATA_EMPRESTIMO, emprestimo.getDataDevolucao());
        values.put(COLUNA_STATUS, emprestimo.getStatus());
        values.put(COLUNA_CPF_USUARIO, emprestimo.getCpfUsuario());
        values.put(COLUNA_CODIGO_LIVRO, emprestimo.getCodLivro());

        db.update(
                TABELA_EMPRESTIMO,
                values,
                COLUNA_CODIGO + " = ?",
                new String[]{String.valueOf(emprestimo.getCodigo())}
        );


    }

    @Override
    public Emprestimo getEmprestimo(int codigo) {
        Emprestimo emprestimo = null;

        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();


        String QUERY_LIVRO_NOME = "SELECT * FROM " + TABELA_EMPRESTIMO + " WHERE " + COLUNA_CODIGO + " = " + codigo + ";";

        Cursor cursor = db.rawQuery(QUERY_LIVRO_NOME, null);

        if (cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {

                emprestimo =
                        new Emprestimo(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5)

                        );

            }
        }

        return emprestimo;
    }

    @Override
    public List<Emprestimo> getEmprestimoCPF(String cpf) {
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();


        String QUERY_EMPRESTIMO_CPF = "SELECT * FROM " + TABELA_EMPRESTIMO + " WHERE " + COLUNA_CPF_USUARIO + " = " + cpf + ";";

        Cursor cursor = db.rawQuery(QUERY_EMPRESTIMO_CPF, null);

            if (cursor.moveToFirst()) {
                do {
                    emprestimos.add(
                            new Emprestimo(
                                    cursor.getInt(0),
                                    cursor.getString(1),
                                    cursor.getString(2),
                                    cursor.getString(3),
                                    cursor.getString(4),
                                    cursor.getInt(5)

                            )
                    );

                } while (cursor.moveToNext());
            }

        db.close();
        return emprestimos;
    }

    @Override
    public List<Emprestimo> getTodosEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();

        Cursor cursor = db.rawQuery(QUERY_TODOS_EMPRESTIMOS, null);

        if(cursor.moveToFirst()){
            do{
                emprestimos.add(
                        new Emprestimo(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5)

                        )
                );
            }while (cursor.moveToNext());

        }
        db.close();
        return emprestimos;
    }

    @Override
    public List<Emprestimo> getEmprestimosPendentes() {

        List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
        SQLiteDatabase db = Persistencia.getInstance(mcontext).getWritableDatabase();

        Cursor cursor = db.rawQuery(QUERY_EMPRESTIMOS_PENDENTES, null);

        if(cursor.moveToFirst()){
            do{
                emprestimos.add(
                        new Emprestimo(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5)

                        )
                );
            }while (cursor.moveToNext());

        }
        db.close();
        return emprestimos;

    }


}

