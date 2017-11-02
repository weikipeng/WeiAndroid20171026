package com.eduu.bang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by wikipeng on 2017/11/2.
 */
public class TestMvpActivity extends AppCompatActivity {
    protected AppCompatDelegate mAppCompatDelegate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMvp();
    }

    private void initMvp() {

    }
}
