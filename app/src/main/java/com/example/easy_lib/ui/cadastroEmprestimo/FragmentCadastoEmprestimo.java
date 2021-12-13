package com.example.easy_lib.ui.cadastroEmprestimo;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easy_lib.R;

public class FragmentCadastoEmprestimo extends Fragment {

    private FragmentCadastoEmprestimoViewModel mViewModel;

    public static FragmentCadastoEmprestimo newInstance() {
        return new FragmentCadastoEmprestimo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadasto_emprestimo, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentCadastoEmprestimoViewModel.class);
        // TODO: Use the ViewModel
    }

}