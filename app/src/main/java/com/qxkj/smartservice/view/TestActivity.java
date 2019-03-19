package com.qxkj.smartservice.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.qxkj.smartservice.R;
import com.qxkj.smartservice.base.BaseActivity;
import com.qxkj.smartservice.widget.CustomToolbar;

public class TestActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void businessLogic(Bundle savedInstanceState) {
        CustomToolbar toolbar = getToolbar();
        setToolbarShow(View.VISIBLE);
        toolbar.setMainTitle(Color.WHITE,"我的代办（99999999）");
        Button button=new Button(this);
        button.setPadding(40,20,40,20);
        button.setText("返回");
        button.setTextColor(Color.BLACK);
        View.OnClickListener listener= v -> Toast.makeText(TestActivity.this,"按钮点击===",Toast.LENGTH_SHORT).show();
        toolbar.addRightChildView(button,-1,listener);
    }
}
