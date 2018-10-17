package com.dev.lyhoangvinh.livedata.ui.collections;

import android.content.Context;
import com.dev.lyhoangvinh.livedata.base.managers.ServiceManager;
import com.dev.lyhoangvinh.livedata.base.presenter.BasePresenter;
import com.dev.lyhoangvinh.livedata.di.qualifier.ActivityContext;
import com.dev.lyhoangvinh.livedata.di.scopes.PerFragment;
import com.dev.lyhoangvinh.livedata.ui.collections.CollectionsView;

import javax.inject.Inject;

@PerFragment
public class CollecttionsNewPresenter extends BasePresenter<CollectionsView> {
    private int mPageIndex = 0;

    @Inject
    public CollecttionsNewPresenter(@ActivityContext Context context, ServiceManager manager) {
        super(context, manager);
    }

    public void loadData(boolean forceUpdate) {
        mPageIndex = 0;
        getData(mPageIndex, forceUpdate);
    }

    public void loadMoreData() {
        int nextPageIndex = mPageIndex + 1;
        getData(nextPageIndex, false);
    }

    private void getData(int pageIndex, boolean forceUpdate) {
        if (forceUpdate && mPageIndex == 0 && getView() != null) {
            getView().clearList();
        }
        if (pageIndex > 0 && getView() != null) {
            getView().setLoadingMoreIndicator();
        }

        addRequest(getApi().getCollections(pageIndex), forceUpdate, dto -> {
            if (getView() != null) {
                getView().onLoadDataPage(dto.getCollections(), dto.isHasMore());
            }
        });
    }
}
