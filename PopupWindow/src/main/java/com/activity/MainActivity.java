package com.activity;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private PopupWindow popWindow;
	private Button btnPop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_menu).setOnClickListener(this);
		btnPop = (Button) findViewById(R.id.btn_pop);
		btnPop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_pop:
//			downPopwindow();
			upPopwindow();
//			lPopwindow();
			break;
		case R.id.pop_b:
			Toast.makeText(this, "百度搜索", Toast.LENGTH_SHORT).show();
			popWindow.dismiss();
			break;
		case R.id.pop_a:
			Toast.makeText(this, "阿里网购", Toast.LENGTH_SHORT).show();
			popWindow.dismiss();
			break;
		case R.id.pop_t:
			Toast.makeText(this, "腾讯社交", Toast.LENGTH_SHORT).show();
			popWindow.dismiss();
			break;
		case R.id.btn_menu:
			menuPopwindow();
			break;
		case R.id.pop_java:
			Toast.makeText(this, "我是Java", Toast.LENGTH_SHORT).show();
			popWindow.dismiss();
			break;
		case R.id.pop_ios:
			Toast.makeText(this, "我是Ios", Toast.LENGTH_SHORT).show();
			popWindow.dismiss();
			break;
		case R.id.pop_android:
			Toast.makeText(this, "我是Android", Toast.LENGTH_SHORT).show();
			popWindow.dismiss();
			break;
		default:
			break;
		}
	}

	private void downPopwindow() {
		// showAsDropDown(View anchor);相对某个控件的位置（正左下方），无偏移
		// showAsDropDown(View anchor, int x, int
		// y);相对某个控件的位置，有偏移;x表示相对x轴的偏移，正表示向左，负表示向右；y表示相对y轴的偏移，正是向下，负是向上；
		View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_down, null);
		// 这里就给具体大小的数字，要不然位置不好计算
		popWindow = new PopupWindow(contentView, 380, 460);
		popWindow.setAnimationStyle(R.style.anim);// 淡入淡出动画
		// popWindow.setTouchable(false);// 是否响应touch事件
		// popWindow.setFocusable(false);// 是否具有获取焦点的能力
		// 点击PopupWindow以外的区域，PopupWindow是否会消失。
		popWindow.setBackgroundDrawable(new BitmapDrawable());
		popWindow.setOutsideTouchable(true);

		contentView.findViewById(R.id.pop_b).setOnClickListener(this);
		contentView.findViewById(R.id.pop_a).setOnClickListener(this);
		contentView.findViewById(R.id.pop_t).setOnClickListener(this);

		int popupWidth = popWindow.getWidth();
		int popupHeight = popWindow.getHeight();
		int width = btnPop.getWidth();
		int height = btnPop.getHeight();
//		Toast.makeText(this, popupWidth + "=" + popupHeight + "=" + width + "=" + height, 1).show();
		popWindow.showAsDropDown(btnPop, (width - popupWidth) / 2, -(popupHeight + 2*height));
	}
	
	private void upPopwindow() {
		View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_up, null);
		popWindow = new PopupWindow(contentView, 380, 460);
		popWindow.setAnimationStyle(R.style.anim);
		popWindow.setBackgroundDrawable(new BitmapDrawable());
		popWindow.setOutsideTouchable(true);

		contentView.findViewById(R.id.pop_b).setOnClickListener(this);
		contentView.findViewById(R.id.pop_a).setOnClickListener(this);
		contentView.findViewById(R.id.pop_t).setOnClickListener(this);

		int popupWidth = popWindow.getWidth();
		int popupHeight = popWindow.getHeight();
		int width = btnPop.getWidth();
		int height = btnPop.getHeight();
		popWindow.showAsDropDown(btnPop, (width - popupWidth) / 2, 0);
	}
	
	private void lPopwindow() {
		View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_lr, null);
		popWindow = new PopupWindow(contentView, 300, 400);
		popWindow.setAnimationStyle(R.style.anim);
		popWindow.setBackgroundDrawable(new BitmapDrawable());
		popWindow.setOutsideTouchable(true);
		
		contentView.findViewById(R.id.pop_b).setOnClickListener(this);
		contentView.findViewById(R.id.pop_a).setOnClickListener(this);
		contentView.findViewById(R.id.pop_t).setOnClickListener(this);

		int popupWidth = popWindow.getWidth();
		int popupHeight = popWindow.getHeight();
		int width = btnPop.getWidth();
		int height = btnPop.getHeight();
		Toast.makeText(this, popupWidth + "=" + popupHeight + "=" + width + "=" + height, 1).show();
		popWindow.showAsDropDown(btnPop, -(popupWidth+20), -((popupHeight/2)+(height/2)));
	}

	private void menuPopwindow() {
		// showAtLocation(View parent, int gravity, int x, int
		// y);相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
		View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_menu, null);
		popWindow = new PopupWindow(contentView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
		popWindow.setBackgroundDrawable(new BitmapDrawable());
		popWindow.setOutsideTouchable(true);

		// 设置各个控件的点击响应
		contentView.findViewById(R.id.pop_java).setOnClickListener(this);
		contentView.findViewById(R.id.pop_ios).setOnClickListener(this);
		contentView.findViewById(R.id.pop_android).setOnClickListener(this);

		// 显示PopupWindow
		View rootview = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
		popWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			if (null != popWindow && popWindow.isShowing()) {
				popWindow.dismiss();
			} else {
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}