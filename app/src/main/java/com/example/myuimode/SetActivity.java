package com.example.myuimode;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.myuimode.utils.SharedPreferencesUtil;
import com.example.myuimode.utils.UIModeUtil;

public class SetActivity extends AppCompatActivity {

    //切换夜间模式的选中框
    private CheckBox checkBox;

    private AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        activity = this;
        initView();
    }

    private void initView(){
        checkBox = findViewById(R.id.checkbox);
        int mode = SharedPreferencesUtil.getNight(this);
        if(mode == AppCompatDelegate.MODE_NIGHT_YES){
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }
        //监听夜间模式的切换
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                UIModeUtil.changeModeUI(activity);
                recreate();
            }
        });
    }
}
