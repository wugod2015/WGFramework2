package com.wugod.wg_framework2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.wugod.wg_framework2.activity.LockActivity;
import com.wugod.wg_framework2.activity.LoginActivity;
import com.wugod.wg_framework2.activity.MovieActivity;
import com.wugod.wg_framework2.activity.MoviesActivity;
import com.wugod.wg_framework2.activity.WeathersActivity;
import com.wugod.wg_framework2.bean.Movie;
import com.wugod.wg_framework2.utils.LogUtils;

public class ActivityUtils {

	final static public String TAG = "ActivityUtils";

	final static public int REQUEST_CODE_LOCK = 1;
	final static public int REQUEST_CODE_FILE_SELECT = 2;

	public static void startLoginActivity(Context context) {
		LogUtils.d(TAG, "startLoginActivity");

		Intent intent = new Intent(context, LoginActivity.class);
		context.startActivity(intent);
	}

	public static void startLockActivity(Activity activity, int requestCode) {
		LogUtils.d(TAG, "startLockActivity");

		Intent intent = new Intent(activity, LockActivity.class);
		activity.startActivityForResult(intent, requestCode);
	}

	public static void startMovieActivity(Context context, Movie movie) {
		LogUtils.d(TAG, "startMovieActivity");

		Intent intent = new Intent(context, MovieActivity.class);
		intent.putExtra("Movie", movie);
		context.startActivity(intent);
	}

	public static void startMoviesActivity(Context context) {
		LogUtils.d(TAG, "startMoviesActivity");

		Intent intent = new Intent(context, MoviesActivity.class);
		context.startActivity(intent);
	}

	public static void startWeathersActivity(Context context) {
		LogUtils.d(TAG, "startWeathersActivity");

		Intent intent = new Intent(context, WeathersActivity.class);
		context.startActivity(intent);
	}

}
