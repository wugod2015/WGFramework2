package com.wugod.wg_framework2.fragment;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wugod.wg_framework2.R;
import com.wugod.wg_framework2.bean.Weather;
import com.wugod.wg_framework2.bean.WeatherResult;
import com.wugod.wg_framework2.db.DBHelper;
import com.wugod.wg_framework2.db.WeatherDao;
import com.wugod.wg_framework2.db.WeatherResultDao;
import com.wugod.wg_framework2.server.ServerApi;
import com.wugod.wg_framework2.subscriber.DataResultSubscriber;

public class WeathersFragment extends BaseFragment implements OnRefreshListener {
	private static final String TAG = "WeathersFragment";
	private static final String ARG_LOCATION = "location";

	public static WeathersFragment newInstance(String location) {
		WeathersFragment fragment = new WeathersFragment();
		Bundle args = new Bundle();
		args.putString(ARG_LOCATION, location);
		fragment.setArguments(args);
		return fragment;
	}

	String location;

	SwipeRefreshLayout swipeRefreshLayout;

	WeatherResultDao weatherResultDao;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_weathers, container,
				false);
		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		location = getArguments().getString(ARG_LOCATION);
		weatherResultDao = DBHelper.getDaoMaster(mContext).newSession()
				.getWeatherResultDao();
		getWeathers(location);
	}

	private void getWeathers(String location) {
		// TODO Auto-generated method stub

		swipeRefreshLayout.setRefreshing(true);

		//initWeathers(weatherResultDao.queryBuilder().unique());

		ServerApi.getWeathers(location).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new DataResultSubscriber<WeatherResult>() {

					@Override
					public void onResult(String msg, WeatherResult t) {

						// TODO Auto-generated method stub

						swipeRefreshLayout.setRefreshing(false);

						initWeathers(t);
					}
				});
	}

	private void initWeathers(WeatherResult weatherResult) {
		// TODO Auto-generated method stub
		if (weatherResult == null)
			return;
		List<Weather> weathers = new ArrayList<Weather>();
		weathers.addAll(weatherResult.getWeather_data());
		locationText.setText(weatherResult.getCurrentCity());
		if (weathers.size() < 1)
			return;
		dateText.setText(weathers.get(0).getDate());
		weatherText.setText(weathers.get(0).getWeather());
		windText.setText(weathers.get(0).getWind());
		temperatureText.setText(weathers.get(0).getTemperature());

		Glide.with(mContext).load(weathers.get(0).getDayPictureUrl())
				.placeholder(R.drawable.ic_launcher).centerCrop().crossFade()
				.into(dayPicture);
	}

	TextView locationText, dateText, weatherText, windText, temperatureText;
	ImageView dayPicture;

	@Override
	protected void initView(View view) {
		// TODO Auto-generated method stub
		swipeRefreshLayout = (SwipeRefreshLayout) view
				.findViewById(R.id.swipe_refresh_layout);
		locationText = (TextView) view.findViewById(R.id.location);
		dateText = (TextView) view.findViewById(R.id.date);
		weatherText = (TextView) view.findViewById(R.id.weather);
		windText = (TextView) view.findViewById(R.id.wind);
		temperatureText = (TextView) view.findViewById(R.id.temperature);
		dayPicture = (ImageView) view.findViewById(R.id.dayPicture);

		swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN,
				Color.BLUE);
		swipeRefreshLayout.setOnRefreshListener(this);
		// 这句话是为了，第一次进入页面的时候显示加载进度条
		swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
				.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
						.getDisplayMetrics()));
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub

		getWeathers(location);
	}

}
