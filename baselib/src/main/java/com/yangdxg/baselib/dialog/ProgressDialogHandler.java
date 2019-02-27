package com.yangdxg.baselib.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.yangdxg.baselib.R;

/**
 * 作者： yangdongxing
 * 日期： 2019/2/27.
 * 功能：
 */

public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;
    private final Context mContext;
    private final ProgressCancleLisenter mLisenter;
    private final boolean mCancleable;
    private ProgressDialog mProgressDialog;

    public ProgressDialogHandler(Context context, ProgressCancleLisenter lisenter, boolean cancleable) {
        mContext = context;
        mLisenter = lisenter;
        mCancleable = cancleable;
    }

    private void initProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext,R.style.ProgressDialog);
            mProgressDialog.setCancelable(mCancleable);
            mProgressDialog.setCanceledOnTouchOutside(false);

            if (mCancleable) {
                mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        mLisenter.onCancleProgress();
                    }
                });
            }
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();

                mProgressDialog.setContentView(R.layout.load_dialog);
                WindowManager.LayoutParams params = mProgressDialog.getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                mProgressDialog.getWindow().setAttributes(params);

            }
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
