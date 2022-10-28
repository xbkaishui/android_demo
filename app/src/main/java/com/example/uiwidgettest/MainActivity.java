package com.example.uiwidgettest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uiwidgettest.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NetworkChangeReceiver networkChangeReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        Button button = findViewById(R.id.login_btn);
        button.setOnClickListener(this);

        Button sw_list_btn = findViewById(R.id.sw_list_btn);
        sw_list_btn.setOnClickListener(this);

        Button fragment_btn = findViewById(R.id.fragment_btn);
        fragment_btn.setOnClickListener(this);

        Button news_btn = findViewById(R.id.test_news_btn);
        news_btn.setOnClickListener(this);

        Button offline_btn = findViewById(R.id.test_force_offline_btn);
        offline_btn.setOnClickListener(this);

        //注册广播
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        Log.i("MainActivity","register network chagne broastcase");
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn: {
                Log.i("MainActivity", "on click btn");
                EditText username = findViewById(R.id.username);
                Log.i("MainActivity", "user name " + username.getText());
                break;
            }
            case R.id.sw_list_btn:{
                Intent intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.fragment_btn:{
                Intent intent = new Intent(this, FragmentActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.test_news_btn:{
                Intent intent = new Intent(this, NewsMainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.test_force_offline_btn: {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("NetworkChangeReceiver", "recv network changes");
            Toast.makeText(context, "network changes", Toast.LENGTH_LONG).show();
        }
    }
}