package com.yangdxg.immersive;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private View mNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        mNav = findViewById(R.id.nav);
        toolbar.setTitle("沉浸式");
        setSupportActionBar(toolbar);
        setToolBarStyle(toolbar,mNav, Color.GREEN);
    }
}
