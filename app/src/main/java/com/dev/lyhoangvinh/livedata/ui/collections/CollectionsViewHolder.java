package com.dev.lyhoangvinh.livedata.ui.collections;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.dev.lyhoangvinh.livedata.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img)
    ImageView img;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    public CollectionsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
