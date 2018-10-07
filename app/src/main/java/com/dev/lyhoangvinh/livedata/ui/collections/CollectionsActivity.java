package com.dev.lyhoangvinh.livedata.ui.collections;

import com.dev.lyhoangvinh.livedata.base.activity.BaseSingleFragmentActivity;

public class CollectionsActivity extends BaseSingleFragmentActivity<CollectionsFragment> {
    @Override
    protected CollectionsFragment createFragment() {
        return new CollectionsFragment();
    }
}
