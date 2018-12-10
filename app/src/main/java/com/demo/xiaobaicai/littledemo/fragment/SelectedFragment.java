package com.demo.xiaobaicai.littledemo.fragment;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.xiaobaicai.littledemo.R;
import com.demo.xiaobaicai.littledemo.adapter.SelectedAdapter;
import com.demo.xiaobaicai.littledemo.adapter.SelectedPagerAdapter;
import com.demo.xiaobaicai.littledemo.iview.ICarousePagerSelectView;


/**
 * 精选
 * @author ansen
 * @create time 2016-04-19
 */
public class SelectedFragment extends Fragment{
	private ViewPager viewPager;
	private SelectedPagerAdapter selectedPagerAdapter;
	
	private ImageView[] tips;//底部。。。
	
	private Timer timer;
	private final int  CAROUSEL_TIME = 3000;//滚动间隔
	
	private int currentIndex=0;//当前选中
	
	private TextView tvContent;
	private String[] carousePageStr=new String[]{"Android开发666","公众号:Ansen_666","Python 的练手项目有哪些值得推荐"};
	
	private ListView listView;
	private SelectedAdapter selectedAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
		Log.i("xiaobaicai","select1");
		View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_selected, null);
		
		View headView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_selected_header, null);
		
		tvContent=(TextView) headView.findViewById(R.id.tv_content);
		tvContent.setText(carousePageStr[0]);
		
		viewPager = (ViewPager)headView.findViewById(R.id.viewpager);
		selectedPagerAdapter=new SelectedPagerAdapter(getActivity(),carousePagerSelectView);
		viewPager.setOffscreenPageLimit(2);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(onPageChangeListener);
		viewPager.setAdapter(selectedPagerAdapter);
		Log.i("xiaobaicai","select2");
		ViewGroup group = (ViewGroup) headView.findViewById(R.id.viewGroup);// 初始化底部显示控件
		tips = new ImageView[3];
		for (int i = 0; i < tips.length; i++){
			ImageView imageView = new ImageView(getActivity());
			if (i == 0) {
				imageView.setBackgroundResource(R.mipmap.page_indicator_focused);
			} else {
				imageView.setBackgroundResource(R.mipmap.page_indicator_unfocused);
			}
			
			tips[i] = imageView;
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			layoutParams.leftMargin = 10;// 设置点点点view的左边距
			layoutParams.rightMargin = 10;// 设置点点点view的右边距
			group.addView(imageView, layoutParams);
		}
		Log.i("xiaobaicai","select3");
		timer = new Timer(true);//初始化计时器
		timer.schedule(task, 0, CAROUSEL_TIME);//延时0ms后执行,3000ms执行一次
		
		listView=(ListView) rootView.findViewById(R.id.list);
		listView.addHeaderView(headView);
		listView.setAdapter(selectedAdapter=new SelectedAdapter(getActivity()));
		Log.i("xiaobaicai","selectend");
		return rootView;
	}
	
	private ICarousePagerSelectView carousePagerSelectView=new ICarousePagerSelectView() {
		@Override
		public void carouseSelect(int index) {
			Toast.makeText(getActivity(), carousePageStr[index], Toast.LENGTH_SHORT).show();
		}
	};
	
	TimerTask task = new TimerTask() {
		public void run() {
			handler.sendEmptyMessage(CAROUSEL_TIME);
		}
	};
	
	private Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case CAROUSEL_TIME:
				if(currentIndex>=tips.length-1){//已经滚动到最后,从第一页开始
					viewPager.setCurrentItem(0);
				}else{//开始下一页
					viewPager.setCurrentItem(currentIndex+1);
				}
				break;
			}
		};
	};

	/*
	@Override
	public void onDestroy(){
	    super.onDestroy();
		task.cancel();
		System.exit(0);
	}
	*/
	
	private OnPageChangeListener onPageChangeListener=new OnPageChangeListener() {
		@Override
		public void onPageSelected(int index) {
			tvContent.setText(carousePageStr[index]);
			setImageBackground(index);// 改变点点点的切换效果
			currentIndex=index;
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2){}
		@Override
		public void onPageScrollStateChanged(int arg0) {}
	};
	
	/**
	 * 改变点点点的切换效果
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		for (int i = 0; i < tips.length; i++) {
			if (i == selectItems) {
				tips[i].setBackgroundResource(R.mipmap.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.mipmap.page_indicator_unfocused);
			}
		}
	}
}
