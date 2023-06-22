package com.finaannisarahmasari.tugassensor2023akbif_510120179;

//NIM  : 10120179
//Nama : Fina Annisa Rahmasari
//Kelas: IF-5

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.finaannisarahmasari.tugassensor2023akbif_510120179.adapter.SectionPagerAdapter;

public class InfoFragment extends Fragment {
    View myFragments;

    ViewPager viewPager;
    TabLayout tabLayout;


    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragments = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = myFragments.findViewById(R.id.viewPager);
        tabLayout = myFragments.findViewById(R.id.tabLayout);

        return myFragments;
    }

//    onActivity create method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new Info1Fragment(), "About");
        adapter.addFragment(new Info2Fragment(), "Version");

        viewPager.setAdapter(adapter);
    }
}