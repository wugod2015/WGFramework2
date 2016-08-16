package com.wugod.wg_framework2.adapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.wugod.wg_framework2.R;
import com.wugod.wg_framework2.bean.PhotoWallItem;
import com.wugod.wg_framework2.utils.BitmapUtil;
import com.wugod.wg_framework2.utils.LogUtils;
import com.wugod.wg_framework2.utils.PaletteUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoWallAdapter extends BaseRecyclerAdapter {

	public PhotoWallAdapter(Context context, List<?> list, View headView) {
		super(context, list, headView);
		// TODO Auto-generated constructor stub
	}

	public PhotoWallAdapter(Context context, List<?> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onBindViewHolderItem(ViewHolder viewHolder, int position) {
		// TODO Auto-generated method stub
		PhotoWallHolder holder = (PhotoWallHolder) viewHolder;
		PhotoWallItem item = (PhotoWallItem) list.get(position);

		holder.text.setText("item" + position);
		final TextView textView = holder.text;
		final ImageView imgView = holder.img;
		Glide.with(context).load(item.url).asBitmap()/*
													 * .placeholder(R.drawable.
													 * ic_launcher)
													 */
		.into(new SimpleTarget<Bitmap>() {

			@Override
			public void onResourceReady(Bitmap bitmap,
					GlideAnimation<? super Bitmap> glideAnimation) {
				// TODO Auto-generated method stub

				imgView.setImageBitmap(BitmapUtil.scale(bitmap,
						bitmap.getWidth() | imgView.getLayoutParams().width));
				LogUtils.d(TAG, "bitmap-width:"+bitmap.getWidth()+";"+imgView.getLayoutParams().width);
				textView.setBackgroundColor(PaletteUtils.getColorByPalette(
						bitmap, R.color.white));
			}
		});
	}

	@Override
	protected ViewHolder onCreateViewHolderItem(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		PhotoWallHolder holder = new PhotoWallHolder(LayoutInflater.from(
				context).inflate(R.layout.activity_photo_wall, parent, false));
		return holder;
	}

	class PhotoWallHolder extends ViewHolder {

		ImageView img;
		TextView text;

		public PhotoWallHolder(View v) {
			super(v);
			// TODO Auto-generated constructor stub
			img = (ImageView) v.findViewById(R.id.img);
			text = (TextView) v.findViewById(R.id.text);
		}

	}
}
