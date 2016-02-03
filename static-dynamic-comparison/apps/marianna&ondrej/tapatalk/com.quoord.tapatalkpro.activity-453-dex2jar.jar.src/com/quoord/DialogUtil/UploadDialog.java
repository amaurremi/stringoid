package com.quoord.DialogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.forum.AttachDialogHelperAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.util.ExifUtil;
import com.quoord.tapatalkpro.util.TapatalkEngine;

import java.io.File;
import java.util.ArrayList;

public class UploadDialog {
    public static final int CAMERA = 1;
    public static final int GALLERY = 0;
    static String SD_CARD_TEMP_DIR = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
    private TapatalkEngine engine;
    private ForumStatus forumStatus;
    private Activity mActivity;
    private UploadAdapter mUploadAdapter;
    private ProgressDialog mUploadProgressDialog;

    public UploadDialog(Activity paramActivity, ForumStatus paramForumStatus, TapatalkEngine paramTapatalkEngine) {
        this.mUploadAdapter = new UploadAdapter(paramActivity);
        this.mUploadAdapter.mUploadDialog = this;
        this.mActivity = paramActivity;
        this.engine = paramTapatalkEngine;
        this.forumStatus = paramForumStatus;
    }

    public void activityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if ((paramInt1 == 0) && (paramInt2 == -1)) {
            paramIntent = paramIntent.getData();
            this.mUploadAdapter.recycle();
            this.mUploadAdapter = new UploadAdapter(this.mActivity);
            if (paramIntent != null) {
                this.mUploadAdapter.setUri(paramIntent, 0);
                getUploadConfirmDialog().show();
            }
        }
        if ((paramInt1 == 1) && (paramInt2 == -1)) {
            paramIntent = new File(SD_CARD_TEMP_DIR);
        }
        try {
            Uri localUri = Uri.parse(MediaStore.Images.Media.insertImage(this.mActivity.getContentResolver(), paramIntent.getAbsolutePath(), null, null));
            this.mUploadAdapter.recycle();
            this.mUploadAdapter = new UploadAdapter(this.mActivity);
            paramInt1 = ExifUtil.getExif(paramIntent);
            if (localUri != null) {
                this.mUploadAdapter.setUri(localUri, Math.round((float) paramIntent.length()), paramInt1);
                getUploadConfirmDialog().show();
            }
            paramIntent.delete();
            return;
        } catch (Exception paramIntent) {
            paramIntent.printStackTrace();
        }
    }

    public void closeDialog() {
        if (this.mUploadProgressDialog != null) {
            this.mUploadProgressDialog.dismiss();
        }
    }

    public int getRealSize() {
        return this.mUploadAdapter.realSize;
    }

    public AlertDialog getUploadConfirmDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getText(2131100012).toString()).setView(this.mUploadAdapter.getView(true)).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (UploadDialog.this.mUploadAdapter.isFromGallery) {
                    paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                    paramAnonymousDialogInterface.setType("image/*");
                    UploadDialog.this.mActivity.startActivityForResult(paramAnonymousDialogInterface, 0);
                }
            }
        });
        localBuilder.setNeutralButton(this.mActivity.getString(2131099977), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                UploadDialog.this.uploadAvatar(UploadDialog.this.mUploadAdapter);
                UploadDialog.this.mUploadProgressDialog = new ProgressDialog(UploadDialog.this.mActivity);
                UploadDialog.this.mUploadProgressDialog.setIcon(17301633);
                UploadDialog.this.mUploadProgressDialog.setTitle(UploadDialog.this.mActivity.getString(2131100203));
                UploadDialog.this.mUploadProgressDialog.setProgressStyle(1);
                UploadDialog.this.mUploadProgressDialog.show();
                ((ForumActivityStatus) UploadDialog.this.mActivity).updateDialog(4);
            }
        });
        return localBuilder.create();
    }

    public AlertDialog getUploadSelectorDialog() {
        new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getString(2131099804)).setAdapter(new AttachDialogHelperAdapter(this.mActivity, this.forumStatus), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (paramAnonymousInt == 0) {
                    paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                    paramAnonymousDialogInterface.setType("image/*");
                    UploadDialog.this.mActivity.startActivityForResult(paramAnonymousDialogInterface, 1000);
                    return;
                }
                paramAnonymousDialogInterface = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
                Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                localIntent.putExtra("output", Uri.fromFile(new File(paramAnonymousDialogInterface)));
                localIntent.putExtra("android.intent.extra.videoQuality", 1);
                UploadDialog.this.mActivity.startActivityForResult(localIntent, 1001);
            }
        }).create();
    }

    public void updateDialog(int paramInt) {
        try {
            this.mUploadProgressDialog.setMax(getRealSize());
            this.mUploadProgressDialog.setProgress(paramInt);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void uploadAvatar(UploadAdapter paramUploadAdapter) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramUploadAdapter);
        this.mUploadAdapter.mUploadDialog = this;
        this.engine.call("upload_avatar_x", localArrayList);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/UploadDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */