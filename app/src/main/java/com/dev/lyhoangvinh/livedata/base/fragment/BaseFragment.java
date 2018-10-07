package com.dev.lyhoangvinh.livedata.base.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dev.lyhoangvinh.livedata.base.response.ErrorEntity;
import com.dev.lyhoangvinh.livedata.base.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {

    protected abstract int getLayout();

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(getActivity());
    }

    protected abstract void initialize(Context ctx);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public void finishFragment() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().finishAfterTransition();
        } else {
            getActivity().finish();
        }
    }

    /**
     * @return true if fragment should handle back press, false if not (activity will handle back press event)
     */

    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
      
    }

    @Override
    public void onError(ErrorEntity error) {
        showToast(error.getMessage());
    }

    public void showToast(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}
