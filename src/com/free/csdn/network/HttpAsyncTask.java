package com.free.csdn.network;

import android.content.Context;
import android.os.AsyncTask;

import com.free.csdn.util.HttpUtil;

/**
 * Http请求
 * 
 * @author Frank
 *
 */
public class HttpAsyncTask extends AsyncTask<String, Void, String> {

	public HttpAsyncTask(Context context) {
		
	}

	private OnResponseListener onResponseListener;

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

	}

	@Override
	protected String doInBackground(String... params) {
		// 获取网页html数据
		String result = HttpUtil.httpGet(params[0]);

		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (null != onResponseListener) {
			if (null == result) {
				onResponseListener.onResponse(null);
			} else {
				onResponseListener.onResponse(result);
			}
		}
	}

	public interface OnResponseListener {
		public void onResponse(String resultString);
	}

	public OnResponseListener getResponseListener() {
		return onResponseListener;
	}

	public void setOnCompleteListener(OnResponseListener onResponseListener) {
		this.onResponseListener = onResponseListener;
	}
}
