package com.example.myuimode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myuimode.utils.SharedPreferencesUtil;
import com.example.myuimode.utils.UIModeUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //打开设置页面的按钮
    private Button btn_set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btn_set = findViewById(R.id.btn_set);
        btn_set.setOnClickListener(this);
    }

    //每次执行该方法检查是否设置夜间模式
    @Override
    protected void onStart() {
        super.onStart();
        int mode = SharedPreferencesUtil.getNight(this);
        UIModeUtil.showModeUI(this,mode);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,SetActivity.class);
        startActivity(intent);
    }
}
