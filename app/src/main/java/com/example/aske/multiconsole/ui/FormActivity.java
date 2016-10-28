package com.example.aske.multiconsole.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.aske.multiconsole.R;

/**
 * Created by abasurto on 26/10/2016.
 */

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        //((App) getApplication()).getApplicationComponent().inject(this);
        //ButterKnife.bind(this);
        /*initView();
        presenter.attachView(this);
        presenter.init(this);*/
    }


}
