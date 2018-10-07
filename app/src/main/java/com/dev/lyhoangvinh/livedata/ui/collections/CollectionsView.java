package com.dev.lyhoangvinh.livedata.ui.collections;


import com.dev.lyhoangvinh.livedata.base.view.BaseView;
import com.dev.lyhoangvinh.livedata.model.Collections;

import java.util.List;

public interface CollectionsView extends BaseView {
    void clearList();

    void setLoadingMoreIndicator();

    void onLoadDataPage(List<Collections> collectionsList, boolean add2List);
}
