package com.dev.lyhoangvinh.livedata.ui.collections;


import com.dev.lyhoangvinh.livedata.base.view.BaseView;
import com.dev.lyhoangvinh.livedata.data.model.Collectionss;

import java.util.List;

public interface CollectionsView extends BaseView {
    void clearList();

    void setLoadingMoreIndicator();

    void onLoadDataPage(List<Collectionss> collectionsList, boolean add2List);
}
