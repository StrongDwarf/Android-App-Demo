package com.demo.xiaobaicai.littledemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.xiaobaicai.littledemo.R;

/**
 * 订阅
 * @author ansen
 * @create time 2016-04-19
 */
public class SubscribeFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.i("xiaobaicai","sub start");
		View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
		TextView tvContent = (TextView) rootView.findViewById(R.id.tv_content);
		tvContent.setText("订阅");
		Log.i("xiaobaicai","sub end");
		return rootView;
	}
}
