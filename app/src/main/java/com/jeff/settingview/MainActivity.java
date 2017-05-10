package com.jeff.settingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jeff.settingitem.SettingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SettingView mItem = (SettingView) findViewById(R.id.setting);
        mItem.setOnItemViewClick(new SettingView.OnItemViewClick() {
            @Override
            public void itemClick() {
                //do something
            }
        });
        mItem.setItemText("消息");    //设置条目文字
        mItem.showDot(false);       //是否显示红点
        mItem.showRightIcon(true);      //是否显示右边icon
        mItem.showLeftIcon(true);       //是否显示左边icon

    }
}
