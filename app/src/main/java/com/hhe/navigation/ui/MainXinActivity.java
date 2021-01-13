package com.hhe.navigation.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.hhe.navigation.R;
import com.hhe.navigation.databinding.ActivityMainXinBinding;

public class MainXinActivity extends AppCompatActivity {

    private ActivityMainXinBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main_xin);
        //国际化翻译插件 https://github.com/shiweibsw/Translation-Tools
//        getSupportFragmentManager().beginTransaction().add(R.id.fl_content,new MainFragment()).commit();
    }


}