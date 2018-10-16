package com.dev.lyhoangvinh.livedata.ui.collections;

import android.support.annotation.NonNull;
import android.view.View;
import com.bumptech.glide.Glide;
import com.dev.lyhoangvinh.livedata.R;
import com.dev.lyhoangvinh.livedata.base.adapter.BaseAdapter;
import com.dev.lyhoangvinh.livedata.data.model.Collectionss;
import com.dev.lyhoangvinh.livedata.utils.MyFunctions;

import java.util.List;


public class CollectionsAdapter extends BaseAdapter<Collectionss, CollectionsViewHolder> {

    public CollectionsAdapter(@NonNull List<Collectionss> data) {
        super(data);
    }

    @Override
    public int getItemLayoutResource() {
        return R.layout.item_collection;
    }

    @Override
    public CollectionsViewHolder createViewHolder(View itemView) {
        return new CollectionsViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(CollectionsViewHolder holder, @NonNull Collectionss item) {
        holder.tvTitle.setText(item.getTitle());
        Glide.with(holder.itemView.getContext()).load(item.getCoverUrl())
                .apply(MyFunctions.getRequestOptions()).into(holder.img);
    }
}
