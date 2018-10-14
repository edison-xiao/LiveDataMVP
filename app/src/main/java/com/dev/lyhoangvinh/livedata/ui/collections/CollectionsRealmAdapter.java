package com.dev.lyhoangvinh.livedata.ui.collections;

import android.support.annotation.NonNull;
import android.view.View;

import com.bumptech.glide.Glide;
import com.dev.lyhoangvinh.livedata.R;
import com.dev.lyhoangvinh.livedata.base.adapter.BaseRealmAdapter;
import com.dev.lyhoangvinh.livedata.local.CollectionsLocal;
import com.dev.lyhoangvinh.livedata.utils.MyFunctions;

import io.realm.RealmResults;

public class CollectionsRealmAdapter extends BaseRealmAdapter<CollectionsLocal, CollectionsViewHolder> {

    public CollectionsRealmAdapter(RealmResults<CollectionsLocal> data) {
        super(data);
    }

    @Override
    public int getItemLayoutResource() {
        return R.layout.item_collection;
    }

    @Override
    public CollectionsViewHolder createViewHolder(View view) {
        return new CollectionsViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(CollectionsViewHolder holder, @NonNull CollectionsLocal dto) {
        holder.tvTitle.setText(dto.getTitle());
        Glide.with(holder.itemView.getContext()).load(dto.getCoverUrl())
                .apply(MyFunctions.getRequestOptions()).into(holder.img);
    }
}
