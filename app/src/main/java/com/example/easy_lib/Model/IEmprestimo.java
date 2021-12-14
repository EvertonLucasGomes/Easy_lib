package com.example.easy_lib.Model;

import java.util.Date;

public interface IEmprestimo {

    static final double TAXA_ATRASO = 2.00;
    static final double MULTA_POR_DIA = 0.50;
    double calcularMulta(Date dataAtual);



}
