package com.dev.lyhoangvinh.livedata.base.view;

import com.dev.lyhoangvinh.livedata.base.response.ErrorEntity;

public interface BaseView {
    void showProgress();

    void hideProgress();

    void onError(ErrorEntity error);

}
