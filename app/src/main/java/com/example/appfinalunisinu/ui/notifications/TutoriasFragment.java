package com.example.appfinalunisinu.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appfinalunisinu.databinding.FragmentTutoriasBinding;

public class TutoriasFragment extends Fragment {

    private FragmentTutoriasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TutoriasViewModel tutoriasViewModel =
                new ViewModelProvider(this).get(TutoriasViewModel.class);

        binding = FragmentTutoriasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}