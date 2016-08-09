package com.wugod.wg_framework2.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wugod.wg_framework2.R;
import com.wugod.wg_framework2.bean.Movie;

public class MoviesAdapter extends Adapter<MoviesAdapter.ListViewHolder>
		implements OnClickListener {
	Context context;
	List<Movie> list;

	public MoviesAdapter(Context context, List<Movie> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(ListViewHolder holder, int position) {
		// TODO Auto-generated method stub

		holder.itemView.setTag(list.get(position));

		Movie item = list.get(position);
		holder.movie_name.setText(item.getMovie_name());
		holder.movie_message.setText(item.getMovie_message());
		holder.movie_release_date.setText(item.getMovie_release_date() + "上映");
		Glide.with(context).load(item.getMovie_picture())
				.placeholder(R.drawable.ic_launcher).centerCrop().crossFade()
				.into(holder.movie_picture);
		if ("1".equals(item.getIs_new()))
			holder.is_new.setVisibility(View.VISIBLE);
		else
			holder.is_new.setVisibility(View.GONE);
	}

	@Override
	public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(context).inflate(R.layout.item_movies,
				parent, false);
		ListViewHolder holder = new ListViewHolder(view);
		view.setOnClickListener(this);
		return holder;
	}

	public class ListViewHolder extends ViewHolder {

		TextView movie_name;
		TextView movie_release_date;
		TextView movie_message;
		ImageView movie_picture;
		ImageView is_new;

		public ListViewHolder(View v) {
			super(v);
			// TODO Auto-generated constructor stub
			movie_name = (TextView) v.findViewById(R.id.movie_name);
			movie_release_date = (TextView) v
					.findViewById(R.id.movie_release_date);
			movie_message = (TextView) v.findViewById(R.id.movie_message);
			movie_picture = (ImageView) v.findViewById(R.id.movie_picture);
			is_new = (ImageView) v.findViewById(R.id.is_new);
		}

	}

	public static interface OnRecyclerViewItemClickListener {
		void onItemClick(View view, Movie item);
	}

	private OnRecyclerViewItemClickListener mOnItemClickListener = null;

	public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
		this.mOnItemClickListener = listener;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mOnItemClickListener != null) {
			// 注意这里使用getTag方法获取数据
			mOnItemClickListener.onItemClick(v, (Movie) v.getTag());
		}
	}
}
