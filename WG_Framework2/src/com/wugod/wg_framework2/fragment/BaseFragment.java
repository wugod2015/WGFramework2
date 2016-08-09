package com.wugod.wg_framework2.fragment;

import com.wugod.wg_framework2.R;
import com.wugod.wg_framework2.utils.ToastUtils;
import com.wugod.wg_framework2.view.BaseView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

public abstract class BaseFragment extends Fragment implements BaseView {

	private static final String TAG = "BaseFragment";

	Context mContext;
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mContext=getActivity();
		initView(getView());
	}

	protected abstract void initView(View view);

	@Override
	public void onServerFailure() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onServerFailure");
		if (isAdded())
			ToastUtils.showShortToast(getActivity(),
					getString(R.string.server_failure));

	}
}
