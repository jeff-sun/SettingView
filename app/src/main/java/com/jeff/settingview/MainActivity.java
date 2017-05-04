package com.jeff.settingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jeff.settingitem.SettingView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SettingView item = (SettingView) findViewById(R.id.setting);
        item.setOnItemViewClick(new SettingView.OnItemViewClick() {
            @Override
            public void itemClick() {
                //do something
            }
        });
    }
}
