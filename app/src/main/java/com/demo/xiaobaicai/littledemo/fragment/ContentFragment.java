package com.demo.xiaobaicai.littledemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.xiaobaicai.littledemo.R;

public class ContentFragment extends Fragment{
	private TextView tvContent;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		View rootView=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_content, null);
		tvContent=(TextView) rootView.findViewById(R.id.tv_content);
		return rootView;
	}
	
	public void setContent(String content){
		tvContent.setText(content);
	}
}
