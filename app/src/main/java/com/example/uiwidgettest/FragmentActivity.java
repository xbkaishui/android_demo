package com.example.uiwidgettest;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.uiwidgettest.fragment.AnotherRightFragment;
import com.example.uiwidgettest.fragment.RightFragment;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btn = findViewById(R.id.lf_btn);
        btn.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    private void replaceFragment(Fragment fragment) {
        //修改 fragment 实现
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        //不让直接退出
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lf_btn: {
                replaceFragment(new AnotherRightFragment());
                break;
            }
            default:
                break;
        }
    }
}