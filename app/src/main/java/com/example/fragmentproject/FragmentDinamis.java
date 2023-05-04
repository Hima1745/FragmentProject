package com.example.fragmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentproject.fragment.FirstFragment;
import com.example.fragmentproject.fragment.SecondFragment;

public class FragmentDinamis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dinamis);
        //Menentukan tampilan awal (spt homepage dll)
        loadFragment(new FirstFragment());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Merubah tampilan layar ketika device di mode landscape/potrait
//        Configuration config = getResources().getConfiguration();
//
//        if (config.orientation == Configuration.ORIENTATION_PORTRAIT){
            //mode potrait
//            FirstFragment first = new FirstFragment();
//            fragmentTransaction.replace(R.id.frame_fragment, first);
//        }else {
            //mode landscape
//            SecondFragment second = new SecondFragment();
//            fragmentTransaction.replace(R.id.frame_fragment, second);
//        }
//        fragmentTransaction.commit();

        //NGUBAH TAMPILAN DGN TRIGGER BUTTON
        //binding button
        Button btn1, btn2;
        btn1 = findViewById(R.id.btn_first);
        btn2 = findViewById(R.id.btn_second);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new FirstFragment();
                //utk menghapus fragment yg sedang ditampilkan
                getSupportFragmentManager().popBackStackImmediate();
                //panggil method utk nampilin fragment
                loadFragment(frag);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new SecondFragment();
                //utk menghapus fragment yg sedang ditampilkan
                getSupportFragmentManager().popBackStackImmediate();
                //panggil method utk nampilin fragment
                loadFragment(frag);
            }
        });
    }

        private void loadFragment (Fragment fragment){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).commit();
        }
    }