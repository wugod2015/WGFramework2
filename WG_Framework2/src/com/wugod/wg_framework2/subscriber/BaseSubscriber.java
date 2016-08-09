package com.wugod.wg_framework2.subscriber;

import java.net.ConnectException;

import com.google.gson.JsonSyntaxException;
import com.wugod.wg_framework2.BaseApplication;
import com.wugod.wg_framework2.R;
import com.wugod.wg_framework2.utils.LogUtils;
import com.wugod.wg_framework2.utils.ToastUtils;

import rx.Subscriber;

public abstract class BaseSubscriber<T> extends Subscriber<T> {
	final static String TAG = "BaseSubscriber";

	@Override
	public void onCompleted() {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onCompleted");

	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onError:" + throwable);

		String errorStr = BaseApplication.getInstance().getString(
				R.string.server_failure);
		try {
			throw throwable;
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ToastUtils.showShortToast(errorStr);
		onErrorResult(errorStr);
	}

	protected abstract void onErrorResult(String errorStr);
}
