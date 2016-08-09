package com.wugod.wg_framework2.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.wugod.wg_framework2.utils.LogUtils;

/**
 * baseAdapter with head
 * 
 * @author hanhuizhong
 * @date 2016-8-9
 */
public abstract class BaseRecyclerAdapter extends Adapter<ViewHolder> implements
		OnClickListener {
	final static int VIEW_TYPE_HEAD = 1;
	final static String TAG = "BaseRecyclerAdapter";

	public Context context;
	public List<?> list;

	public View headView;
	public int headHeight;

	public View getHeadView() {
		return headView;
	}

	public void setHeadView(View headView) {
		this.headView = headView;
	}

	public void setHeadView(View headView, int headHeight) {
		this.headView = headView;
		this.headHeight = headHeight;
	}

	public BaseRecyclerAdapter(Context context, List<?> list) {
		// TODO Auto-generated constructor stub

		LogUtils.d(TAG, "BaseRecyclerAdapter:");
		this.context = context;
		this.list = list;
		if (headView != null)
			this.list.add(0, null);
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	protected void onBindViewHolderHead(ViewHolder viewHolder, int position) {
	};

	protected abstract void onBindViewHolderItem(ViewHolder viewHolder,
			int position);

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		// TODO Auto-generated method stub

		viewHolder.itemView.setTag(list.get(position));
		viewHolder.itemView.setOnClickListener(this);
		if (headView != null && position == 0) {

			if (headHeight > 0) {
				viewHolder.itemView.setMinimumHeight(headHeight);
			}
			onBindViewHolderHead(viewHolder, position);
		} else
			onBindViewHolderItem(viewHolder, position);
	}

	protected ViewHolder onCreateViewHolderHead(ViewGroup parent, int viewType) {
		return new ViewHolder(headView) {
		};
	}

	protected abstract ViewHolder onCreateViewHolderItem(ViewGroup parent,
			int viewType);

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		if (VIEW_TYPE_HEAD == viewType)
			return onCreateViewHolderHead(parent, viewType);
		else
			return onCreateViewHolderItem(parent, viewType);
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "getItemViewType:" + "position=" + position);
		if (headView != null && position == 0)
			return VIEW_TYPE_HEAD;
		return super.getItemViewType(position);
	}

	public static interface OnRecyclerViewItemClickListener {
		void onItemClick(View view, Object item);
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
			mOnItemClickListener.onItemClick(v, v.getTag());
		}
	}
}
