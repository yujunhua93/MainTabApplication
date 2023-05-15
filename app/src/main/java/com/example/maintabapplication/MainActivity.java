package com.example.maintabapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.maintabapplication.fragment.BlankFragment1;
import com.example.maintabapplication.fragment.BlankFragment2;
import com.example.maintabapplication.fragment.BlankFragment3;
import com.example.maintabapplication.fragment.BlankFragment4;
import com.example.maintabapplication.view.TabIndicator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int tabPostion = 0; // tab位置

    public FragmentManager fragmentManager;
    BlankFragment1 blankFragment1;
    BlankFragment2 blankFragment2;
    BlankFragment3 blankFragment3;
    BlankFragment4 blankFragment4;

    private TabIndicator tab1;
    private TabIndicator tab2;
    private TabIndicator tab3;
    private TabIndicator tab4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        tab4 = findViewById(R.id.tab4);
        fragmentManager = getSupportFragmentManager();
        blankFragment1 = new BlankFragment1();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4  = new BlankFragment4();

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTag(0);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTag(1);
            }
        });

        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTag(2);
            }
        });

        tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTag(3);
            }
        });

        selectTag(tabPostion);


    }


    private void selectTag(int tabPostion){
        tab1.setFource(false);
        tab2.setFource(false);
        tab3.setFource(false);
        tab4.setFource(false);
        this.tabPostion = tabPostion;
        switch (tabPostion){
            case 0:
                tab1.setFource(true);
                switchFragment(R.id.home_frame,blankFragment1);
                break;
            case 1:
                tab2.setFource(true);
                switchFragment(R.id.home_frame,blankFragment2);
                break;
            case 2:
                tab3.setFource(true);
                switchFragment(R.id.home_frame,blankFragment3);
                break;
            case 3:
                tab4.setFource(true);
                switchFragment(R.id.home_frame,blankFragment4);
                break;
        }
    }

    private void switchFragment(int id,Fragment fragment){
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        List<Fragment> fragments =  fragmentManager.getFragments();
        if(null == fragments || fragments.size() == 0|| !fragments.contains(fragment)){
            transaction.add(id,fragment);
        }

        if(null != fragments){
            for (Fragment f:fragments) {
                if(null == f){
                    continue;
                }
                if (f == fragment){
                    transaction.show(f);
                }else{
                    transaction.hide(f);
                }
            }
        }

        transaction.commitAllowingStateLoss();
    }


}