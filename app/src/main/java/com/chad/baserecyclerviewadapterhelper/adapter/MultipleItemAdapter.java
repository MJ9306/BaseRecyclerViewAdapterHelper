package com.chad.baserecyclerviewadapterhelper.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
@Deprecated
public class MultipleItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private static final int TEXT_TYPE = 1;
    private int mTextLayoutResId;


    public MultipleItemAdapter( List data, int... layoutResId) {
        super( layoutResId[0], data);
        mTextLayoutResId = layoutResId[1];
    }

    @Override
    protected int getDefItemViewType(int position) {
        if (position % 2 == 0)
            return TEXT_TYPE;
        return super.getDefItemViewType(position);
    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TEXT_TYPE)
            return new TextViewHolder(getItemView(mTextLayoutResId, parent));
        return super.onCreateDefViewHolder(parent, viewType);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        Glide.with(mContext).load(item).crossFade().into((ImageView) helper.getView(R.id.iv));
    }

    public class TextViewHolder extends BaseViewHolder {
        public TextViewHolder(View itemView) {
            super(itemView);
        }
    }

}
