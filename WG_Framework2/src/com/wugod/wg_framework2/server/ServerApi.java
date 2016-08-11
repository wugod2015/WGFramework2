package com.wugod.wg_framework2.server;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.utils.CommonUtils;
import rx.Observable;
import android.app.Activity;
import android.text.TextUtils;

import com.wugod.wg_framework2.bean.BaseDataResult;
import com.wugod.wg_framework2.bean.DataResult;
import com.wugod.wg_framework2.bean.Movie;
import com.wugod.wg_framework2.bean.MovieResult;
import com.wugod.wg_framework2.bean.WeatherResult;
import com.wugod.wg_framework2.bean.xml.DataResult_XML;
import com.wugod.wg_framework2.bean.xml.MovieResult_XML;

public class ServerApi extends BaseApi {

	private interface BaseService {
		@GET("movie")
		Observable<DataResult<MovieResult<List<Movie>>>> getMoviesObservable(
				@QueryMap Map<String, String> params);

		@GET("movie")
		Observable<DataResult_XML> getMoviesObservable_XML(
				@QueryMap Map<String, String> params);

		// @Headers("Cache-Control: public, max-age=30")
		@GET("weather")
		Observable<DataResult<WeatherResult>> getWeathersObservable(
				@QueryMap Map<String, String> params);

		@Multipart
		@POST("接口")
		Observable<BaseDataResult> saveFiles(
				@PartMap Map<String, RequestBody> params);
		// 请求 xml 格式
		// @Headers({ "Content-Type: text/xml", "Accept-Charset: utf-8" })
		// @POST("cimservice_api/service")
		// Observable<String> getXML(@Body String xml );
	}

	protected final static BaseService service = getRetrofit().create(
			BaseService.class);
	protected final static BaseService service_XML = getRetrofit_XML().create(
			BaseService.class);

	/*
	 * 请求 xml 格式 public static Observable<String> getXML() { // TODO
	 * Auto-generated method stub String xml ="xml"; return service.getXML(xml);
	 * }
	 */
	public static Observable<DataResult<MovieResult<List<Movie>>>> getMovies(
			String location) {
		// TODO Auto-generated method stub

		return service.getMoviesObservable(getMovies_params(location, true));
	}

	public static Observable<DataResult_XML> getMovies_XML(
			String location) {
		// TODO Auto-generated method stub

		return service_XML.getMoviesObservable_XML(getMovies_params(location, false));
	}

	/**
	 * @author hanhuizhong
	 * @date 2016-8-10
	 * @param location
	 * @param isJSON
	 *            默认xml
	 * @return
	 */
	private static Map<String, String> getMovies_params(String location,
			boolean isJSON) {
		// TODO Auto-generated method stub
		Map<String, String> params = new HashMap<>();
		params.put("qt", "hot_movie");
		if (TextUtils.isEmpty(location))
			params.put("location", "石家庄");
		else
			params.put("location", location);
		if (isJSON)
			params.put("output", "json");
		params.put("ak", "ZqSI8jEqG2HHZjtp246dUf5XPC4phR53");
		params.put(
				"mcode",
				"DF:27:51:65:09:8B:23:76:7B:64:52:96:E9:08:76:10:49:64:21:BF;com.wugod.forestofmemory");
		return params;
	}

	public static Observable<DataResult<WeatherResult>> getWeathers(
			String location) {
		// TODO Auto-generated method stub

		Map<String, String> params = new HashMap<>();
		if (TextUtils.isEmpty(location))
			params.put("location", "石家庄");
		else
			params.put("location", location);
		params.put("output", "json");
		params.put("ak", "ZqSI8jEqG2HHZjtp246dUf5XPC4phR53");
		params.put(
				"mcode",
				"DF:27:51:65:09:8B:23:76:7B:64:52:96:E9:08:76:10:49:64:21:BF;com.wugod.forestofmemory");
		return service.getWeathersObservable(params);
	}

	public static Observable<BaseDataResult> saveFiles(Activity activity,
			Map<String, String> params, List<File> files) {
		// TODO Auto-generated method stub

		return service.saveFiles(CommonUtils.updateFilesParams(activity,
				params, files));
	}

}
