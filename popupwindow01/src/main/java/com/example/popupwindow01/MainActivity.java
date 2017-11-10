package com.example.popupwindow01;

import android.os.Bundle;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.popupwindow01.popupwindow.TestPopupWindow;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private TestPopupWindow mPopupWindow;
    private int xoff;
    private int yoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.tv);

        mPopupWindow = new TestPopupWindow(this);
        /*-----------------------------------------*/
        View contentView = mPopupWindow.getContentView();
        contentView.measure(makeDropDownMeasureSpec(mPopupWindow.getWidth()), makeDropDownMeasureSpec(mPopupWindow.getHeight()));
        xoff = mPopupWindow.getContentView().getMeasuredWidth();
        yoff = mPopupWindow.getContentView().getMeasuredHeight();
        /*-----------------------------------------*/

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*一般不能在oncreate开始的时候显示,渲染完毕一般来讲就是点击之后出现的popwindow*/

//                方法1
//                PopupWindowCompat.showAsDropDown(mPopupWindow, mTextView, 0, 0, Gravity.START);
                /*@1:居左*/
                PopupWindowCompat.showAsDropDown(mPopupWindow, mTextView, -xoff, 0, Gravity.START);
                /*@2:*/

//                方法2
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    mPopupWindow.showAsDropDown(mTextView, 0, 0, Gravity.LEFT);
//                }

//                方法3,有点不知道其含义
//                mPopupWindow.showAtLocation(mTextView, Gravity.CENTER, 0, 0);
            }
        });

    }

    @SuppressWarnings("ResourceType")
    private int makeDropDownMeasureSpec(int measureSpec) {
        int mode;
        if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            mode = View.MeasureSpec.UNSPECIFIED;
        } else {
            mode = View.MeasureSpec.EXACTLY;
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode);
    }
}
