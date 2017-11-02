package com.jzb.android.classroom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jzb.android.classroom.mvp.ClassroomPresenter;
import com.jzb.android.mvp.IPresenterK;

/**
 * Created by wikipeng on 2017/11/2.
 */
public class ClassroomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMvp();
    }

    protected void initMvp() {
        IPresenterK presenter = new ClassroomPresenter(this);
        presenter.refresh(true);
    }
}
