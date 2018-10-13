package com.dev.lyhoangvinh.livedata.ui.collections;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dev.lyhoangvinh.livedata.R;
import com.dev.lyhoangvinh.livedata.base.adapter.EndlessRecyclerViewScrollListener;
import com.dev.lyhoangvinh.livedata.base.adapter.SimpleDividerItemDecoration;
import com.dev.lyhoangvinh.livedata.base.fragment.BaseFragment;
import com.dev.lyhoangvinh.livedata.model.Collections;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CollectionsFragment extends BaseFragment implements CollectionsView {

    @BindView(R.id.rcv)
    RecyclerView rcv;

    private CollectionsAdapter adapter;
    private CollectionsPresenter presenter;
    private EndlessRecyclerViewScrollListener endlessScrollListener;

    @Override
    protected int getLayout() {
        return R.layout.fragment_collections;
    }

    @Override
    protected void initialize(Context ctx) {
        presenter = new CollectionsPresenter(this, ctx);
        List<Collections> list = new ArrayList<>();
        adapter = new CollectionsAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setItemAnimator(new DefaultItemAnimator());
        rcv.setHasFixedSize(true);
        rcv.addItemDecoration(new SimpleDividerItemDecoration(ctx, SimpleDividerItemDecoration.VERTICAL, R.drawable.list_divider_margin));
        rcv.setAdapter(adapter);
        endlessScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int totalItemsCount) {
                presenter.loadMoreData();
            }
        };
        rcv.addOnScrollListener(endlessScrollListener);
        presenter.loadData(getListCount() == 0);
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
    public void onLoadDataPage(List<Collections> collectionsList, boolean add2List) {
        rcv.post(() -> {
            if (!add2List) {
                adapter.setDataSetToAdapter(collectionsList);
            } else {
                adapter.addDataSetToAdapter(collectionsList);
            }
        });
    }
}
