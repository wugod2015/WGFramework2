package com.wugod.wg_framework2.subscriber;

import java.util.List;

import com.wugod.wg_framework2.bean.xml.DataResult_XML;
import com.wugod.wg_framework2.bean.xml.MovieResult_XML;
import com.wugod.wg_framework2.conf.Constant;
import com.wugod.wg_framework2.utils.LogUtils;
import com.wugod.wg_framework2.utils.ToastUtils;

public abstract class DataResultSubscriber_XML extends BaseSubscriber<DataResult_XML>{

	final static String TAG = "DataResultSubscriber_XML";

	@Override
	public void onNext(DataResult_XML dataResult) {
		// TODO Auto-generated method stub
		
		LogUtils.d(TAG, "onNext");
		if (dataResult == null)
			return;
		if (Constant.GETDATA_OK == dataResult.error){
			if (dataResult.result==null)
				onResults(dataResult.status, dataResult.results);
			else
				onResult(dataResult.status, dataResult.result);
		}else {

			ToastUtils.showShortToast(dataResult.message);
			onErrorResult(dataResult.message);
		}

	}

	@Override
	protected void onErrorResult(String errorStr) {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onErrorResult");
	}

	public abstract void onResult(String msg, MovieResult_XML result);

	protected void onResults(String msg, List<MovieResult_XML> results) {

		if (results != null && results.size() > 0)
			onResult(msg, results.get(0));
	}
}
