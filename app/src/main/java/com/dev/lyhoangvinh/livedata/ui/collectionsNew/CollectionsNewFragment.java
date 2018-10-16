package com.dev.lyhoangvinh.livedata.ui.collectionsNew;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dev.lyhoangvinh.livedata.R;
import com.dev.lyhoangvinh.livedata.base.adapter.EndlessRecyclerViewScrollListener;
import com.dev.lyhoangvinh.livedata.base.fragment.BasePresenterFragment;
import com.dev.lyhoangvinh.livedata.data.model.Collectionss;
import com.dev.lyhoangvinh.livedata.ui.collections.CollectionsAdapter;
import com.dev.lyhoangvinh.livedata.ui.collections.CollectionsView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CollectionsNewFragment extends BasePresenterFragment<CollectionsView, CollecttionsNewPresenter> implements CollectionsView {

    @BindView(R.id.rcv)
    RecyclerView rcv;
    private CollectionsAdapter adapter;
    private EndlessRecyclerViewScrollListener endlessScrollListener;
    @Override
    protected int getLayout() {
        return R.layout.fragment_collections;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Override
    protected void initialize(Context ctx) {
        super.initialize(ctx);
        getPresenter().loadData(getListCount() == 0);
        List<Collectionss> list = new ArrayList<>();
        adapter = new CollectionsAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setItemAnimator(new DefaultItemAnimator());
        rcv.setHasFixedSize(true);
        endlessScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int totalItemsCount) {
                presenter.loadMoreData();
            }
        };
        rcv.addOnScrollListener(endlessScrollListener);
        rcv.setAdapter(adapter);
    }

    private int getListCount() {
        return adapter != null ? adapter.getItemCount() : 0;
    }


    @Override
    public void clearList() {
        if (adapter != null){
            adapter.resetAdapter();
        }
    }

    @Override
    public void setLoadingMoreIndicator() {
        if (endlessScrollListener != null) {
            endlessScrollListener.onLoadMoreComplete();
        }
    }

    @Override
    public void onLoadDataPage(List<Collectionss> collectionsList, boolean add2List) {
        rcv.post(() -> {
            if (!add2List) {
                adapter.setDataSetToAdapter(collectionsList);
            } else {
                adapter.addDataSetToAdapter(collectionsList);
            }
        });
    }
}
