package com.qxkj.smartservice.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qxkj.smartservice.R;


/**
 * 顶部通用状态栏
 */
public class CustomToolbar extends LinearLayout {
    private TextView mTvTitle;//中间标题
    private LinearLayout mLlContainer;//右边的view容器

    public CustomToolbar(Context context) {
        this(context, null);
    }

    public CustomToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_simple_toolbar, this);
        mTvTitle = findViewById(R.id.tv_title);
        mLlContainer = findViewById(R.id.ll_container);
    }

    /**
     * 设置中间标题
     *
     * @param color 文字颜色
     * @param text  文字内容
     */
    public void setMainTitle(int color, String text) {
        mTvTitle.setTextColor(color);
        mTvTitle.setText(text);
    }

    /**
     * 添加右侧view
     * @param view  控件
     * @param src   图片资源id
     * @param listener  点击监听
     */
    public void addRightChildView(View view,int src,OnClickListener listener) {
        if (view instanceof ImageView){
            ((ImageView)view).setImageResource(src);
        }
        view.setOnClickListener(listener);
       mLlContainer.addView(view);
    }

}
