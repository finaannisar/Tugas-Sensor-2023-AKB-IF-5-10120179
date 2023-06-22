package com.finaannisarahmasari.tugassensor2023akbif_510120179;

//NIM  : 10120179
//Nama : Fina Annisa Rahmasari
//Kelas: IF-5

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    //inisialisasi variable
    MeowBottomNavigation bottomNav;
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign the variable
        bottomNav = findViewById(R.id.bottomNav);

        //add menu items to bottom nav
        bottomNav.add(new MeowBottomNavigation.Model(1, R.drawable.ic_info));
        bottomNav.add(new MeowBottomNavigation.Model(2, R.drawable.ic_mylocation));
        bottomNav.add(new MeowBottomNavigation.Model(3, R.drawable.ic_resto));
        bottomNav.add(new MeowBottomNavigation.Model(4, R.drawable.ic_profile));

        //set bottom nav on show listener
        bottomNav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //inisialisasi fragment

                if(item.getId()==1){
                    fragment = new InfoFragment();
                    loadFragment(fragment);
                }else if(item.getId()==2) {
                    fragment = new MyLocationFragment();
                    loadFragment(fragment);
                } else if(item.getId()==3) {
                    fragment = new RestoFragment();
                    loadFragment(fragment);
                }else if(item.getId()==4) {
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                }



                //load the fragment
                //loadFragment(fragment);
            }
        });



        //set initially selected fragment
        bottomNav.show(1,true);

        //set menu item on click listener
        bottomNav.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //display a toast
                Toast.makeText(getApplicationContext(),"You clicked"+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        //set on reselect listener
        bottomNav.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"You reselected"+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        //replace the fragment
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.nav_host_fragment_container,fragment,null)
                .commit();
    }
}