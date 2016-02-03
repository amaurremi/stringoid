package com.quoord.tapatalkpro.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.CallBackChecker;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.NewPostAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ExifUtil;
import com.quoord.tapatalkpro.util.GeoPictureUploader;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.UserBehavior;

import java.util.ArrayList;
import java.util.HashMap;

public class UploadActivity
        extends FragmentActivity
        implements ForumActivityStatus, TryTwiceCallBackInterface {
    private static final int CANCEL = 0;
    public static final int SUBMIT = 2;
    public static final int TO_FORUM = 0;
    public static final int TO_TAPA = 1;
    public static final int UPLOADTAPATALK = 1;
    public static final int UPLOADTOFORUM = 0;
    public ArrayList attachIds = new ArrayList();
    private ActionBar bar = null;
    private Bitmap bitmap = null;
    private boolean canUploadAttachment = false;
    protected TapatalkEngine engine = null;
    private String forumId = null;
    private ForumStatus forumStatus = null;
    public String groupId = null;
    private ImageView imgView = null;
    private boolean isAvatar = false;
    private boolean isConver = false;
    private boolean isTapa = true;
    private TapatalkJsonEngine jsonEngine;
    private Activity mActivity = null;
    private NewPostAdapter mAdapter = null;
    private int mSize;
    private UploadAdapter mUploadAdapter = null;
    private SignInWithOtherUtil mUtil;
    private ProgressDialog progress = null;
    private int round = 0;
    private boolean tryTwice = false;
    private Uri uri = null;

    public String attachImage(UploadAdapter paramUploadAdapter) {
        return new GeoPictureUploader(this.forumStatus.getForumId(), Util.getMD5(Util.getMacAddress(this.mActivity)), (ForumActivityStatus) this.mActivity).uploadPicture(paramUploadAdapter, this.forumStatus.tapatalkForum.getUserName(), this.forumStatus.getUserId(), Util.getMD5(Util.getMacAddress(this.mActivity)), this.forumStatus.getForumId());
    }

    public void attachImage(UploadAdapter paramUploadAdapter, String paramString) {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        localArrayList.add(paramUploadAdapter);
        if (this.groupId != null) {
            localArrayList.add(this.groupId);
        }
        this.engine.call("upload_attachment_x", localArrayList);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this, this.forumStatus, this.engine, isOpCancel(), this)) && (paramEngineResponse.getMethod().endsWith("upload_attachment_x"))) {
            try {
                this.mUploadAdapter.closeByteStream();
                boolean bool = paramEngineResponse.isSuccess();
                Object localObject2 = (HashMap) paramEngineResponse.getResponse();
                Object localObject1;
                String str1;
                String str2;
                return;
            } catch (Exception localException1) {
                try {
                    this.mActivity.dismissDialog(42);
                    if (bool) {
                        if ((((HashMap) localObject2).containsKey("result")) && (((Boolean) ((HashMap) localObject2).get("result")).booleanValue())) {
                            if (((HashMap) localObject2).containsKey("attachment_id")) {
                                this.attachIds.add((String) ((HashMap) localObject2).get("attachment_id"));
                            }
                            if (((HashMap) localObject2).containsKey("group_id")) {
                                this.groupId = ((String) ((HashMap) localObject2).get("group_id"));
                            }
                            localObject1 = this.mActivity.getIntent();
                            localObject2 = new Bundle();
                            ((Bundle) localObject2).putSerializable("attachIds", this.attachIds);
                            ((Bundle) localObject2).putSerializable("size", Integer.valueOf(this.mUploadAdapter.mSize));
                            ((Bundle) localObject2).putSerializable("imgName", this.mUploadAdapter.imageName);
                            ((Bundle) localObject2).putParcelable("uri", this.uri);
                            ((Bundle) localObject2).putSerializable("groupId", this.groupId);
                            ((Intent) localObject1).putExtras((Bundle) localObject2);
                            this.mActivity.setResult(6, (Intent) localObject1);
                        }
                    }
                    for (; ; ) {
                        this.mActivity.finish();
                        this.progress.dismiss();
                        return;
                        localObject1 = "";
                        bool = ((HashMap) localObject2).containsKey("result_text");
                        if (bool) {
                        }
                        try {
                            localObject1 = new String((byte[]) ((HashMap) localObject2).get("result_text"), "UTF-8");
                            localObject2 = new HashMap();
                            ((HashMap) localObject2).put("errormessage", localObject1);
                            updateUI(13, localObject2);
                            continue;
                            localException1 = localException1;
                            localException1.printStackTrace();
                            if (!(paramEngineResponse.getResponse() instanceof String)) {
                                return;
                            }
                            Toast.makeText(this.mActivity, paramEngineResponse.getResponse().toString(), 1).show();
                            return;
                        } catch (Exception localException2) {
                            for (; ; ) {
                                str1 = new String((byte[]) ((HashMap) localObject2).get("result_text"));
                            }
                        }
                        str1 = "";
                        bool = ((HashMap) localObject2).containsKey("result_text");
                        if (bool) {
                        }
                        try {
                            str1 = new String((byte[]) ((HashMap) localObject2).get("result_text"), "UTF-8");
                            localObject2 = new HashMap();
                            ((HashMap) localObject2).put("errormessage", str1);
                            updateUI(13, localObject2);
                        } catch (Exception localException3) {
                            for (; ; ) {
                                str2 = new String((byte[]) ((HashMap) localObject2).get("result_text"));
                            }
                        }
                    }
                } catch (Exception localException4) {
                    for (; ; ) {
                    }
                }
            }
        }
    }

    public void closeProgress() {
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public ForumActivityStatus getForumActivityStatus() {
        return this;
    }

    public ForumStatus getForumStatus() {
        return this.forumStatus;
    }

    public ForumStatus getForumStatus(TapatalkForum paramTapatalkForum) {
        return null;
    }

    public boolean getSaxCall() {
        return false;
    }

    public boolean getTryTwice() {
        return this.tryTwice;
    }

    public boolean isOpCancel() {
        return false;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 0) {
            if (paramIntent == null) {
                break label144;
            }
            this.uri = paramIntent.getData();
            this.mUploadAdapter.recycle();
            if (this.bitmap != null) {
                this.bitmap = null;
            }
            this.mUploadAdapter = new UploadAdapter(this.mActivity, this.forumStatus.getMaxJpgSize());
            paramInt1 = ExifUtil.getExif(this, this.uri);
            if (this.uri != null) {
                if (this.round == 0) {
                    break label129;
                }
                this.mUploadAdapter.setUri(this.uri, this.round, paramInt1);
            }
        }
        for (; ; ) {
            this.bitmap = Util.decodeLocalImageUri(this.mActivity, this.uri, 1024, 1024);
            this.imgView.setImageBitmap(this.bitmap);
            return;
            label129:
            this.mUploadAdapter.setUri(this.uri, paramInt1);
        }
        label144:
        finish();
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.bar = getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setTitle(2131100007);
        this.mActivity = this;
        setContentView(2130903416);
        this.imgView = ((ImageView) findViewById(2131231697));
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
        paramBundle = getIntent().getExtras();
        if (paramBundle != null) {
            this.uri = ((Uri) paramBundle.getParcelable("uri"));
            this.forumStatus = ((ForumStatus) paramBundle.getSerializable("forumstatus"));
            this.forumId = ((String) paramBundle.getSerializable("forumId"));
            this.round = ((Integer) paramBundle.getSerializable("round")).intValue();
            this.groupId = ((String) paramBundle.getSerializable("groupId"));
            this.isAvatar = paramBundle.getBoolean("isAvatar", false);
            this.isConver = paramBundle.getBoolean("isConver", false);
            this.canUploadAttachment = paramBundle.getBoolean("canUpload", false);
        }
        this.bitmap = Util.decodeLocalImageUri(this.mActivity, this.uri, 1024, 1024);
        this.imgView.setImageBitmap(this.bitmap);
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
        this.jsonEngine = new TapatalkJsonEngine(this.mActivity, this);
        this.mUtil = new SignInWithOtherUtil(this, this.jsonEngine, new Handler());
        this.mUploadAdapter = new UploadAdapter(this.mActivity, this.forumStatus.getMaxJpgSize());
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if (!this.isAvatar) {
            if ((!getResources().getBoolean(2131558401)) && (this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                paramMenu.add(0, 1, 0, getResources().getString(2131099806)).setShowAsAction(6);
            }
            if (this.canUploadAttachment) {
                paramMenu.add(0, 0, 0, getResources().getString(2131100558)).setShowAsAction(6);
            }
        }
        for (; ; ) {
            return super.onCreateOptionsMenu(paramMenu);
            paramMenu.add(0, 2, 0, getResources().getString(2131099972)).setShowAsAction(6);
        }
    }

    public void onDestroy() {
        if (this.bitmap != null) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        if (this.mUploadAdapter != null) {
            this.mUploadAdapter.recycleAll();
            this.mUploadAdapter = null;
        }
        this.progress.dismiss();
        super.onDestroy();
    }

    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
        int i = paramMenuItem.getItemId();
        if (i == 1) {
            if (this.mActivity.getResources().getBoolean(2131558401)) {
                this.isTapa = true;
                upLoad();
            }
        }
        for (; ; ) {
            return super.onMenuItemSelected(paramInt, paramMenuItem);
            if (this.forumStatus.isTapatalkSignIn(this.mActivity)) {
                this.isTapa = true;
                upLoad();
            } else {
                this.mUtil.showShouldSignInDialog();
                continue;
                if (i == 0) {
                    if (this.mActivity.getResources().getBoolean(2131558401)) {
                        this.isTapa = false;
                        upLoad();
                    } else {
                        this.isTapa = false;
                        upLoad();
                    }
                } else if (i == 2) {
                    uploadToTk();
                } else if (i == 16908332) {
                    finish();
                }
            }
        }
    }

    protected void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    protected void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
        this.tryTwice = paramBoolean;
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void tryFailed(String paramString) {
    }

    public void upLoad() {
        this.progress.show();
        if (this.isTapa) {
            upload_check();
            return;
        }
        int i = ExifUtil.getExif(this.mActivity, this.uri);
        if (this.mSize != 0) {
            this.mUploadAdapter.setUri(this.uri, this.mSize, i);
        }
        for (; ; ) {
            attachImage(this.mUploadAdapter, this.forumId);
            return;
            this.mUploadAdapter.setUri(this.uri, i);
        }
    }

    public void updateDialog(int paramInt) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
        switch (paramInt) {
            default:
                return;
        }
        paramObject = (String) ((HashMap) paramObject).get("errormessage");
        Toast.makeText(this.mActivity, (CharSequence) paramObject, 1).show();
    }

    public void updateUI(String paramString) {
    }

    public void uploadToTk() {
        this.progress.show();
        new AsyncTask() {
            protected ArrayList doInBackground(String... paramAnonymousVarArgs) {
                if (UploadActivity.this.mAdapter == null) {
                    UploadActivity.this.mAdapter = new NewPostAdapter(UploadActivity.this.mActivity, UploadActivity.this.forumStatus.getUrl());
                }
                paramAnonymousVarArgs = new ArrayList();
                int i = ExifUtil.getExif(UploadActivity.this.mActivity, UploadActivity.this.uri);
                if (UploadActivity.this.mUploadAdapter != null) {
                    if (UploadActivity.this.round == 0) {
                        break label143;
                    }
                    UploadActivity.this.mUploadAdapter.setUri(UploadActivity.this.uri, UploadActivity.this.round, i);
                }
                for (; ; ) {
                    paramAnonymousVarArgs.add(UploadActivity.this.attachImage(UploadActivity.this.mUploadAdapter));
                    UserBehavior.logUserShareForum(UploadActivity.this.mActivity);
                    return paramAnonymousVarArgs;
                    label143:
                    UploadActivity.this.mUploadAdapter.setUri(UploadActivity.this.uri, i);
                }
            }

            protected void onPostExecute(ArrayList paramAnonymousArrayList) {
                try {
                    UploadActivity.this.engine.getLoginStatus();
                    String str = (String) paramAnonymousArrayList.get(0);
                    Object localObject = "";
                    if ((str != null) && (str.contains("OKAY:"))) {
                        paramAnonymousArrayList = str.replace("OKAY: ", "");
                    }
                    while ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.length() > 0)) {
                        localObject = UploadActivity.this.mActivity.getIntent();
                        ((Intent) localObject).putExtra("url", paramAnonymousArrayList);
                        UploadActivity.this.mActivity.setResult(5, (Intent) localObject);
                        UploadActivity.this.mActivity.finish();
                        return;
                        paramAnonymousArrayList = (ArrayList) localObject;
                        if (str != null) {
                            paramAnonymousArrayList = (ArrayList) localObject;
                            if (str.length() > 0) {
                                Toast.makeText(UploadActivity.this.mActivity, str, 1).show();
                                paramAnonymousArrayList = (ArrayList) localObject;
                            }
                        }
                    }
                    return;
                } catch (Exception paramAnonymousArrayList) {
                    paramAnonymousArrayList.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }

    public void upload_check() {
        uploadToTk();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/UploadActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */