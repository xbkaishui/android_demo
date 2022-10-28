package com.example.uiwidgettest.news;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.uiwidgettest.R;

public class NewsContentActivity extends AppCompatActivity {

    /**
     * 用于创建 NewsContentActivity
     * @param context
     * @param newsTitle
     * @param newsContent
     */
    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("title", newsTitle);
        intent.putExtra("content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        NewContentFragment contentFragment = (NewContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        Log.i("NewsContentActivity", "start new fragment");
        contentFragment.refresh(title, content);
    }
}