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
 * 发现
 * @author ansen
 * @create time 2016-04-19
 */
public class FindFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		Log.i("xiaobaicai","find start");
		View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
		TextView tvContent = (TextView) rootView.findViewById(R.id.tv_content);
		tvContent.setText("发现");
		Log.i("xiaobaicai","find end");
		return rootView;
	}
}
