package com.example.unicare.fragment;

import org.json.JSONException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unicare.R;
import com.example.unicare.common.Tool;
import com.example.unicare.request.MonitorAlarmInfo;
import com.example.unicare.response.MonitorAlarmInfoResponse;
import com.example.unicare.response.MonitorAlarmInfoResponse.AlarmInfo;
import com.example.unicare.threads.ThreadUtil;
import com.google.gson.Gson;

@SuppressLint("ValidFragment")
public class SettingFragment extends Fragment implements OnClickListener {

	private Context context;
	private Gson gson = new Gson();
	private View view;
	
	// handler是主线程与子线程通讯的句柄
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			if (msg.what == 1) {
				// 成功获取服务器端数据
				try {
					receiveDataSuccuess(bundle.getString("data"));
				} catch (Exception e) {
					e.printStackTrace();
					Tool.ShowMessage(context, "抱歉，返回数据处理异常");
				}
			} else {
				Tool.ShowMessage(context, "网络不太好哦，请检查~");
			}

		}
	};

	public SettingFragment() {

	}

	public SettingFragment(Context context) {
		this.context = context;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		requestData();
	}

	/**
	 * 通过intent以及sharedpreference等初始化views的数据
	 */
	private void initData() {

	}

	/**
	 * 向服务器发送请求数据
	 */
	private void requestData() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.change_password, container, false);
		return view;
	}

	/**
	 * 成功接收到服务器端返回的xxxx后执行的操作
	 * 
	 * @throws JSONException
	 */
	protected void receiveDataSuccuess(String jsonData) throws JSONException {
		MonitorAlarmInfoResponse response = gson.fromJson(jsonData,
				MonitorAlarmInfoResponse.class);

	}

	@Override
	public void onClick(View arg0) {

	}

}
