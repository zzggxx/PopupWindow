package com.example.popupwindow01.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.popupwindow01.R;

/**
 * Created by will on 2017/9/19.
 */

public class TestPopupWindow extends PopupWindow {
    public TestPopupWindow(Context context) {
        super(context);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        /*外部点击是否起作用*/
        setOutsideTouchable(true);
        /*默认都是false,若是内部有editText的话,就需要填写成true,不然无法获取到焦点*/
        setFocusable(false);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = LayoutInflater.from(context).inflate(R.layout.test_popupwindow, null);
        setContentView(view);
    }
}
