package com.dev.lyhoangvinh.livedata.base.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import com.dev.lyhoangvinh.livedata.R;
import com.dev.lyhoangvinh.livedata.base.response.ErrorEntity;
import com.dev.lyhoangvinh.livedata.base.view.BaseView;
import com.dev.lyhoangvinh.livedata.di.InjectionHelper;
import com.dev.lyhoangvinh.livedata.di.component.DaggerFragmentComponent;
import com.dev.lyhoangvinh.livedata.di.component.FragmentComponent;
import com.dev.lyhoangvinh.livedata.di.module.FragmentModule;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {

    @Nullable
    private FragmentComponent mFragmentComponent;

    private Dialog progress_dialog = null;

    protected abstract int getLayout();

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view, getActivity());
    }

    protected abstract void initialize(View view, Context ctx);


    public FragmentComponent fragmentComponent() {
        if (mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(new FragmentModule(this))
                    .appComponent(InjectionHelper.getAppComponent(this))
                    .build();
        }
        return mFragmentComponent;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        mFragmentComponent = null;
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
        showProgressDialog(false);
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    public void showProgressDialog(boolean cancelable) {
        if (getActivity() != null && progress_dialog == null) {
            progress_dialog = new Dialog(getActivity());
            progress_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            progress_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progress_dialog.setContentView(R.layout.progress_dialog);
        }

        if (!progress_dialog.isShowing()) {
            progress_dialog.setCanceledOnTouchOutside(cancelable);
            progress_dialog.setCancelable(cancelable);
            progress_dialog.show();
        }

        if (!isNetworkAvailable(getActivity())) {
            progress_dialog.dismiss();
        }
    }

    public void showProgressDialogNew(boolean cancelable) {
        if (getActivity() != null && progress_dialog == null) {
            progress_dialog = new Dialog(getActivity());
            progress_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            progress_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progress_dialog.setContentView(R.layout.progress_dialog);
        }

        if (!progress_dialog.isShowing()) {
            progress_dialog.setCanceledOnTouchOutside(cancelable);
            progress_dialog.setCancelable(cancelable);
            progress_dialog.show();
        }
    }

    public void hideProgressDialog() {
        if (progress_dialog != null && progress_dialog.isShowing()) {
            progress_dialog.dismiss();
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }


    @Override
    public void onError(ErrorEntity error) {
        showToast(error.getMessage());
    }

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}
