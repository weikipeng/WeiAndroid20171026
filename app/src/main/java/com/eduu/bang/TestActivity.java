package com.eduu.bang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jzb.android.annotationprocessor.processor.JzbVH;

/**
 * Created by wikipeng on 2017/10/27.
 */
@JzbVH
public class TestActivity extends AppCompatActivity {


    @JzbVH
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    private void showAnnotationMessage() {
//        GeneratedClass generatedClass = new GeneratedClass();
//        String         message        = generatedClass.getMessage();
//         android.support.v7.app.AlertDialog
//        new AlertDialog.Builder(this)
//                .setPositiveButton("Ok", null)
//                .setTitle("Annotation Processor Messages")
//                .setMessage(message)
//                .show();
//    }
}
