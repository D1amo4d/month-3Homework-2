package com.example.month_3homework2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


public class OneFragment extends Fragment {

    private int numIncrement=0;
    TextView tvAge;
    MaterialButton btnPlus, btnMinus,btnPerehodFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        clikBnt();
    }


    private void initView() {
        tvAge=requireActivity().findViewById(R.id.tv_mn);
        btnPlus=requireActivity().findViewById(R.id.btn_plus);
        btnMinus=requireActivity().findViewById(R.id.btn_minus);
        btnPerehodFragment=requireActivity().findViewById(R.id.btn_go);
    }
    private void clikBnt() {
        btnPlus.setOnClickListener(view -> {
            numIncrement++;
            numm();
        });

        btnMinus.setOnClickListener(view -> {
            numIncrement--;
            numm();
        });

        btnPerehodFragment.setOnClickListener(view -> {
            String ageNormal = tvAge.getText().toString();
            Bundle bundle=new Bundle();
            bundle.putString("ageNam",ageNormal);
            TwoFragment twoFragment=new TwoFragment();
            twoFragment.setArguments(bundle);
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_one,twoFragment)
                    .addToBackStack(null).commit();
        });

    }

    private void numm() {
        tvAge.setText(String.valueOf(numIncrement));

    }
}