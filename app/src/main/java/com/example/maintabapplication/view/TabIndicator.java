package com.example.maintabapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.maintabapplication.R;

/**
 * @ClassName TabIndicator
 * @Author name
 * @Date 2023/5/15
 * @Description
 */
public class TabIndicator extends RelativeLayout {

    private int focusId = -1;
    private int normalId = -1;
    private String labelText = "";
    private int focusColor = -1;
    private int normalColor = -1;



    private ImageView tabIv;
    private TextView tabTv;
    public TabIndicator(Context context) {
        this(context,null);
    }

    public TabIndicator(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.tab_indicator,this);
        TypedArray a =context.obtainStyledAttributes(attrs, R.styleable.TabIndicator);
        if(null != a ){
            focusId = a.getResourceId(R.styleable.TabIndicator_tab_backimg_focus,-1);
            normalId = a.getResourceId(R.styleable.TabIndicator_tab_backimg_normal,-1);
            labelText = a.getString(R.styleable.TabIndicator_tab_string);
            focusColor = a.getColor(R.styleable.TabIndicator_tab_color_focus,getResources().getColor(R.color.purple_200));
            normalColor = a.getColor(R.styleable.TabIndicator_tab_color_focus,getResources().getColor(R.color.black));
        }

        initView();
    }

    private void initView(){
        tabIv = findViewById(R.id.tab_img);
        tabTv = findViewById(R.id.tab_tv);
        tabIv.setImageResource(normalId);
        tabTv.setText(labelText);
    }

    public void setFource(Boolean fource){
        if(fource){
            tabIv.setImageResource(focusId);
            tabTv.setTextColor(focusColor);
        }else{
            tabIv.setImageResource(normalId);
            tabTv.setTextColor(normalColor);
        }
    }
}
