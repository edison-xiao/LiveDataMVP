package com.dev.lyhoangvinh.livedata.base.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dev.lyhoangvinh.livedata.MyApplication;
import com.dev.lyhoangvinh.livedata.base.api.ApiClient;
import com.dev.lyhoangvinh.livedata.base.api.ApiService;
import com.dev.lyhoangvinh.livedata.base.api.ApiUtils;
import com.dev.lyhoangvinh.livedata.base.interfaces.Destroyable;
import com.dev.lyhoangvinh.livedata.base.interfaces.PlainConsumer;
import com.dev.lyhoangvinh.livedata.base.response.BaseResponse;
import com.dev.lyhoangvinh.livedata.base.response.ErrorEntity;
import com.dev.lyhoangvinh.livedata.base.view.BaseView;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import lombok.Getter;

@Getter
public abstract class BasePresenter<V extends BaseView> implements Destroyable {

    @Nullable
    private V view;

    protected Context context;

    @NonNull
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter(@Nullable V mView, Context context) {
        this.view = mView;
        this.context = context;
        mCompositeDisposable = new CompositeDisposable();
    }

    public ApiService getApi(){
        return ApiClient.makeService(ApiService.class);
    }


    /**
     * NULL SAFE
     * Add new api request to {@link CompositeDisposable} and execute immediately
     * All error case and progress showing will be handled automatically
     * @param request           observable request
     * @param showProgress      true if should show loading progress
     *
     * @param responseConsumer   callback for success response.
     * @param errorConsumer     callback for error case.
     *                          If both of these listeners are null, the request will be subscribed
     *                          on io thread without observing on main thread
     *                          * no update UI in case of both success and error are null
     * @param forceResponseWithoutCheckNullView the success result will be returned without check null for view
     * @param <T> Type of response body
     */
    protected <T> void addRequest(
            Single<BaseResponse<T>> request, boolean showProgress,
            boolean forceResponseWithoutCheckNullView,
            @Nullable PlainConsumer<T> responseConsumer,
            @Nullable PlainConsumer<ErrorEntity> errorConsumer) {

        boolean shouldUpdateUI = showProgress || responseConsumer != null || errorConsumer != null;

        if (showProgress && view != null) {
            view.showProgress();
        }

        Disposable disposable = ApiUtils.makeRequest(request, shouldUpdateUI, response -> {
            if (responseConsumer != null && (forceResponseWithoutCheckNullView || view != null)) {
                responseConsumer.accept(response);
            }
        }, error -> {
            if (errorConsumer != null) {
                errorConsumer.accept(error);
            } else if (view != null) {
                view.onError(error);
            }
        }, () -> {
            // complete
            if (showProgress && view != null) {
                view.hideProgress();
            }
        });

        if (mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**
     * Add a request without handling error and no update UI
     */
    protected <T> void addRequest(Single<BaseResponse<T>> request) {
        addRequest(request, false, false, null, null);
    }

    /**
     * Add a request with success listener
     */
    protected <T> void addRequest(Single<BaseResponse<T>> request, boolean showProgress,
                                  @Nullable PlainConsumer<T> responseConsumer) {
        addRequest(request, showProgress, false, responseConsumer, null);
    }

    /**
     * Add a request with success listener and error listener
     */
    protected <T> void addRequest(Single<BaseResponse<T>> request, boolean showProgress,
                                  @Nullable PlainConsumer<T> responseConsumer,
                                  @Nullable PlainConsumer<ErrorEntity> errorListener) {
        addRequest(request, showProgress, false, responseConsumer, errorListener);
    }

    /**
     * Add a request with success listener and forceResponseWithoutCheckNullView param
     */
    protected <T> void addRequest(Single<BaseResponse<T>> request, boolean showProgress,
                                  boolean forceResponseWithoutCheckNullView,
                                  @Nullable PlainConsumer<T> responseConsumer) {
        addRequest(request, showProgress, forceResponseWithoutCheckNullView, responseConsumer, null);
    }

    @Override
    public void onDestroy() {
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }
}
