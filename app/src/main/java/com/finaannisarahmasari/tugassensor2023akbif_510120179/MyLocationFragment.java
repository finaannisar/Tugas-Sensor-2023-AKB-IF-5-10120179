package com.finaannisarahmasari.tugassensor2023akbif_510120179;

//NIM  : 10120179
//Nama : Fina Annisa Rahmasari
//Kelas: IF-5

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyLocationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_my_location, container, false);

        Button cariLokasi = (Button) rootView.findViewById(R.id.cariLokasi);

        cariLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyLocationActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}