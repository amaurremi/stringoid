package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.quoord.tapatalkpro.adapter.forum.AttachDialogHelperAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewPMAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewPostAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PrivateMessage;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.UploadImageInfo;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ExifUtil;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.UploadAttachmentTool;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.quoord.tools.uploadanddownload.UploadImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CreatePmActivity
        extends Activity
        implements ForumActivityStatus {
    public static final int CAMERA = 12;
    public static final int FORWARD = 2;
    public static final int GALLERY = 11;
    public static final int MENU_DISCARD = 1;
    public static final int MENU_PHOTO = 10;
    public static final int MENU_SEND = 0;
    public static final int NEW_PM = 6;
    public static final int REPLYPM = 1;
    public static final int REPLYPMALL = 3;
    public static final int REPLY_ALL_NO_QUOTE = 5;
    public static final int REPLY_NO_QUOTE = 4;
    public static final int SUBMIT = 0;
    private int action = 1;
    private ActionBar bar = null;
    private TapaButton discardButton;
    private ForumStatus forumStatus;
    private CreatePmActivity mActivity;
    ProgressDialog mProgressDialog = null;
    private Handler mUIhandler;
    public UploadAdapter mUploadAdapter;
    private ProgressDialog mUploadProgressDialog = null;
    private SignInWithOtherUtil mUtil;
    private LinearLayout main;
    private int menuItemValue;
    private EditText msgcontent;
    private EditText msgsubject;
    private EditText msgto;
    private NewPostAdapter npAdapter;
    private Uri photoUri;
    private PrivateMessage pm;
    private String pmto;
    private int rotate = 0;
    private boolean saveDraft = true;
    private CheckBox signatureTag;
    private TapaButton submitButton;
    MenuItem submitItem;
    private Uri tempUri;

    public static String getHost(String paramString) {
        try {
            String str = new URL(paramString).getHost();
            return str;
        } catch (MalformedURLException localMalformedURLException) {
            localMalformedURLException.printStackTrace();
        }
        return paramString;
    }

    public void clearDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.remove(this.forumStatus.getForumId() + "|draft_pm_content");
        localEditor.remove(this.forumStatus.getForumId() + "|draft_pm_subject");
        localEditor.remove(this.forumStatus.getForumId() + "|draft_pm_recipient");
        localEditor.commit();
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 0);
    }

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
        }
    }

    public Activity getContext() {
        return this;
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

    public void initialView() {
        setContentView(2130903285);
        int i = 0;
        this.msgsubject = ((EditText) findViewById(2131231418));
        this.msgsubject.setSingleLine(false);
        this.msgsubject.setEnabled(true);
        this.msgto = ((EditText) findViewById(2131231417));
        this.msgcontent = ((EditText) findViewById(2131231419));
        this.discardButton = ((TapaButton) findViewById(2131231422));
        this.submitButton = ((TapaButton) findViewById(2131231421));
        this.signatureTag = ((CheckBox) findViewById(2131231407));
        this.main = ((LinearLayout) findViewById(2131231416));
        this.discardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                CreatePmActivity.this.mActivity.showDialog(15);
            }
        });
        this.submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                new NewPMAdapter(CreatePmActivity.this.mActivity, CreatePmActivity.this.forumStatus.getUrl()).submit(CreatePmActivity.this.msgcontent.getEditableText().toString(), CreatePmActivity.this.msgsubject.getText().toString(), CreatePmActivity.this.msgto.getText().toString(), CreatePmActivity.this.action, CreatePmActivity.this.pm);
            }
        });
        String str2 = "";
        String str1;
        if (this.pm != null) {
            if (this.menuItemValue == 1) {
                this.msgsubject.setText(this.mActivity.getString(2131099775) + " " + this.pm.getMsgSubject());
                if (this.forumStatus.getApiLevel() >= 3) {
                    str1 = this.pm.getTextBody();
                    this.msgto.setText(this.pm.getMsgFrom());
                    this.msgcontent.requestFocus();
                }
            }
        }
        for (; ; ) {
            str2 = SettingsFragment.getSingature(this.mActivity, this.forumStatus.getSigType(), this.forumStatus);
            if (str1 != null) {
                i = str1.length();
            }
            if ((str1 != null) && (str1.length() > 0)) {
                this.msgcontent.setText(str1);
            }
            if ((this.forumStatus.isSupportSignature()) && (str2 != null) && (str2.length() > 0)) {
                this.signatureTag.setVisibility(0);
                this.signatureTag.setText(str2);
            }
            this.msgcontent.setSelection(i);
            return;
            str1 = "[QUOTE]" + this.pm.getTextBody() + "[/QUOTE]" + "\n";
            break;
            if (this.menuItemValue == 3) {
                this.msgsubject.setText(this.mActivity.getString(2131099775) + " " + this.pm.getMsgSubject());
                if (this.forumStatus.getApiLevel() >= 3) {
                }
                for (str1 = this.pm.getTextBody(); ; str1 = "[QUOTE]" + this.pm.getTextBody() + "[/QUOTE]" + "\n") {
                    this.msgto.setText(this.pm.getReplyAllString(this.forumStatus.tapatalkForum.getUserName()));
                    this.msgcontent.requestFocus();
                    break;
                }
            }
            if (this.menuItemValue == 2) {
                this.msgsubject.setText(this.mActivity.getString(2131099776) + " " + this.pm.getMsgSubject());
                str1 = this.pm.getTextBody() + "\n";
            } else if (this.menuItemValue == 4) {
                this.msgto.setText(this.pm.getMsgFrom());
                this.msgsubject.setText(this.mActivity.getString(2131099775) + " " + this.pm.getMsgSubject());
                this.msgcontent.requestFocus();
                str1 = str2;
            } else {
                str1 = str2;
                if (this.menuItemValue == 5) {
                    this.msgto.setText(this.pm.getReplyAllString(this.forumStatus.tapatalkForum.getUserName()));
                    this.msgsubject.setText(this.mActivity.getString(2131099775) + " " + this.pm.getMsgSubject());
                    this.msgcontent.requestFocus();
                    str1 = str2;
                    continue;
                    str1 = str2;
                    if (this.pmto != null) {
                        this.msgto.setText(this.pmto);
                        str1 = str2;
                    }
                }
            }
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 11) {
            if (paramInt2 == -1) {
                this.photoUri = paramIntent.getData();
                uploadToTk();
            }
        }
        do {
            return;
            if (paramInt1 != 12) {
                break;
            }
        } while (paramInt2 != -1);
        paramIntent = new File(UploadImage.SD_CARD_TEMP_DIR);
        this.rotate = ExifUtil.getExif(paramIntent);
        paramInt1 = (int) paramIntent.length();
        try {
            this.photoUri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), paramIntent.getAbsolutePath(), null, null));
            uploadToTk();
            return;
        } catch (FileNotFoundException paramIntent) {
            for (; ; ) {
                paramIntent.printStackTrace();
            }
        }
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        try {
            paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
            paramConfiguration.setMargins((int) getResources().getDimension(2131427375), 0, (int) getResources().getDimension(2131427375), 0);
            this.main.setLayoutParams(paramConfiguration);
            return;
        } catch (Exception paramConfiguration) {
        }
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.mActivity = this;
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setIcon(2130837525);
        if (getIntent().hasExtra("action")) {
            this.menuItemValue = getIntent().getIntExtra("action", 0);
            if (this.menuItemValue != 1) {
                break label366;
            }
            this.action = 1;
            this.bar.setTitle(getString(2131099797));
        }
        for (; ; ) {
            if (getIntent().hasExtra("pm")) {
                this.pm = ((PrivateMessage) getIntent().getSerializableExtra("pm"));
            }
            if (getIntent().hasExtra("pmto")) {
                this.pmto = getIntent().getStringExtra("pmto");
            }
            this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
            GoogleAnalyticsTools.trackPageView(this, "pm/wirte", this.forumStatus.getForumId(), this.forumStatus.getUrl());
            paramBundle = getPreferences(0);
            if ((paramBundle.contains(this.forumStatus.getForumId() + "|draft_pm_content")) || (paramBundle.contains(this.forumStatus.getForumId() + "|draft_pm_subject")) || (paramBundle.contains(this.forumStatus.getForumId() + "|draft_pm_recipient"))) {
                showDialog(44);
            }
            this.mUploadAdapter = new UploadAdapter(getContext(), this.forumStatus.getMaxJpgSize());
            this.mUIhandler = new Handler() {
                public void handleMessage(Message paramAnonymousMessage) {
                    boolean bool2;
                    if (paramAnonymousMessage.what == 24) {
                        bool2 = false;
                    }
                    do {
                        try {
                            bool1 = ((Boolean) paramAnonymousMessage.obj).booleanValue();
                            if (bool1) {
                                Toast.makeText(CreatePmActivity.this.mActivity, CreatePmActivity.this.mActivity.getString(2131100050), 1).show();
                                CreatePmActivity.this.mActivity.setResult(-1);
                                CreatePmActivity.this.saveDraft = false;
                                CreatePmActivity.this.finish();
                                return;
                            }
                        } catch (Exception localException) {
                            for (; ; ) {
                                boolean bool1 = bool2;
                                if (paramAnonymousMessage.obj != null) {
                                    bool1 = bool2;
                                    if ((paramAnonymousMessage.obj instanceof HashMap)) {
                                        bool1 = ((Boolean) ((HashMap) paramAnonymousMessage.obj).get("result")).booleanValue();
                                    }
                                }
                            }
                            Toast.makeText(CreatePmActivity.this.mActivity, CreatePmActivity.this.mActivity.getString(2131099774), 1).show();
                            CreatePmActivity.this.mActivity.closeProgress();
                            return;
                        }
                        if (13 == paramAnonymousMessage.what) {
                            paramAnonymousMessage = (String) ((HashMap) paramAnonymousMessage.obj).get("errormessage");
                            CreatePmActivity.this.closeProgress();
                            Toast.makeText(CreatePmActivity.this.mActivity, CreatePmActivity.this.mActivity.getString(2131100071), 1).show();
                            return;
                        }
                    } while ((31 != paramAnonymousMessage.what) || (CreatePmActivity.this.mProgressDialog == null));
                    int i = ((Integer) paramAnonymousMessage.obj).intValue();
                    paramAnonymousMessage = "";
                    if (i == 0) {
                        paramAnonymousMessage = CreatePmActivity.this.getString(2131099870);
                    }
                    for (; ; ) {
                        CreatePmActivity.this.mProgressDialog.setMessage(paramAnonymousMessage);
                        return;
                        if (i == 1) {
                            paramAnonymousMessage = CreatePmActivity.this.getString(2131099871);
                        } else if (i == 2) {
                            paramAnonymousMessage = CreatePmActivity.this.getString(2131099872);
                        } else if (i == 3) {
                            paramAnonymousMessage = CreatePmActivity.this.getString(2131099873);
                        }
                    }
                }
            };
            this.mUtil = new SignInWithOtherUtil(this);
            initialView();
            return;
            this.menuItemValue = 1;
            break;
            label366:
            if (this.menuItemValue == 2) {
                this.action = 2;
                this.bar.setTitle(getString(2131099800));
            } else if (this.menuItemValue == 3) {
                this.action = 1;
                this.bar.setTitle(getString(2131099798));
            } else if (this.menuItemValue == 4) {
                this.action = 1;
                this.bar.setTitle(getString(2131099801));
            } else if (this.menuItemValue == 6) {
                this.action = 1;
                this.bar.setTitle(getString(2131099799));
            } else {
                this.action = 1;
                this.bar.setTitle(getString(2131099802));
            }
        }
    }

    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 0:
                ProgressDialog localProgressDialog = new ProgressDialog(this);
                localProgressDialog.setMessage(this.mActivity.getString(2131099870));
                localProgressDialog.setIndeterminate(true);
                localProgressDialog.setCancelable(true);
                this.mProgressDialog = localProgressDialog;
                return localProgressDialog;
            case 15:
                new AlertDialog.Builder(this).setTitle(this.mActivity.getString(2131099901)).setPositiveButton(this.mActivity.getString(2131099900), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreatePmActivity.this.saveDraft = false;
                        CreatePmActivity.this.clearDraft();
                        CreatePmActivity.this.mActivity.finish();
                    }
                }).setNegativeButton(this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).setNeutralButton(this.mActivity.getString(2131099793), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreatePmActivity.this.mActivity.finish();
                    }
                }).create();
            case 44:
                new AlertDialog.Builder(this).setMessage(this.mActivity.getString(2131100148)).setPositiveButton(this.mActivity.getString(2131100149), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        Object localObject = CreatePmActivity.this.getPreferences(0);
                        paramAnonymousDialogInterface = ((SharedPreferences) localObject).getString(CreatePmActivity.this.forumStatus.getForumId() + "|draft_pm_subject", "");
                        String str = ((SharedPreferences) localObject).getString(CreatePmActivity.this.forumStatus.getForumId() + "|draft_pm_content", "");
                        localObject = ((SharedPreferences) localObject).getString(CreatePmActivity.this.forumStatus.getForumId() + "|draft_pm_recipient", "");
                        CreatePmActivity.this.msgsubject.setText(paramAnonymousDialogInterface);
                        CreatePmActivity.this.msgcontent.setText(str);
                        CreatePmActivity.this.msgto.setText((CharSequence) localObject);
                    }
                }).setNegativeButton(this.mActivity.getString(2131100150), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreatePmActivity.this.clearDraft();
                    }
                }).create();
            case 9:
                new AlertDialog.Builder(this).setTitle(getString(2131099804)).setAdapter(new AttachDialogHelperAdapter(this, this.forumStatus), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        if (paramAnonymousInt == 0) {
                            if ((CreatePmActivity.this.forumStatus.tapatalkForum.isMedia_sharing()) || (CreatePmActivity.this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                                paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                                paramAnonymousDialogInterface.setType("image/*");
                                CreatePmActivity.this.startActivityForResult(paramAnonymousDialogInterface, 11);
                            }
                            return;
                        }
                        if ((CreatePmActivity.this.forumStatus.tapatalkForum.isMedia_sharing()) || (CreatePmActivity.this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                            paramAnonymousDialogInterface = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
                            Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                            CreatePmActivity.this.tempUri = Uri.fromFile(new File(paramAnonymousDialogInterface));
                            localIntent.putExtra("output", CreatePmActivity.this.tempUri);
                            localIntent.putExtra("android.intent.extra.videoQuality", 1);
                            CreatePmActivity.this.startActivityForResult(localIntent, 12);
                            return;
                        }
                        CreatePmActivity.this.showDialog(18);
                    }
                }).create();
            case 18:
                new AlertDialog.Builder(this).setMessage(getApplicationContext().getString(2131099951)).setPositiveButton(getText(2131099976).toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).create();
        }
        this.mUploadProgressDialog = new ProgressDialog(getContext());
        this.mUploadProgressDialog.setIcon(17301633);
        this.mUploadProgressDialog.setTitle(getContext().getString(2131100203));
        this.mUploadProgressDialog.setProgressStyle(1);
        this.mUploadProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface paramAnonymousDialogInterface) {
            }
        });
        return this.mUploadProgressDialog;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getKeyCode() == 4) {
            showDialog(15);
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
        }
        for (; ; ) {
            return false;
            showDialog(15);
            Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
            return true;
            NewPMAdapter localNewPMAdapter = new NewPMAdapter(this.mActivity, this.forumStatus.getUrl());
            String str = SettingsFragment.getSingature(this.mActivity, this.forumStatus.getSigType(), this.forumStatus);
            Object localObject = this.msgcontent.getEditableText().toString();
            paramMenuItem = (MenuItem) localObject;
            if (this.forumStatus.isSupportEmoji()) {
                paramMenuItem = BBcodeUtil.parseAllForumPublicSmileToEmojiBBCode((String) localObject);
            }
            localObject = paramMenuItem;
            if (this.forumStatus.isSupportSignature()) {
                localObject = paramMenuItem;
                if (str != null) {
                    localObject = paramMenuItem;
                    if (str.length() > 0) {
                        localObject = paramMenuItem;
                        if (this.signatureTag.isChecked()) {
                            localObject = paramMenuItem + "\n\n" + str + "\n\n";
                        }
                    }
                }
            }
            localNewPMAdapter.submit((String) localObject, this.msgsubject.getText().toString(), this.msgto.getText().toString(), this.action, this.pm);
            continue;
            if (this.forumStatus.isTapatalkSignIn(this.mActivity)) {
                showDialog(9);
            } else {
                this.mUtil.showShouldSignInDialog();
            }
        }
    }

    public void onPause() {
        if (this.saveDraft) {
            saveDraft();
        }
        for (; ; ) {
            super.onPause();
            CustomTracker.comScorePause(this);
            return;
            clearDraft();
        }
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        MenuItem localMenuItem = paramMenu.add(0, 0, 0, this.mActivity.getString(2131100185));
        localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_send_title", this));
        localMenuItem.setShowAsAction(2);
        if ((this.forumStatus != null) && ((this.forumStatus.tapatalkForum.isMedia_sharing()) || (this.forumStatus.tapatalkForum.isSupportTkUpload())) && (!getApplication().getResources().getBoolean(2131558401))) {
            paramMenu = paramMenu.add(0, 10, 0, getString(2131100698));
            paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("menu_image", this));
            paramMenu.setShowAsAction(0);
        }
        return true;
    }

    protected void onResume() {
        super.onResume();
        CustomTracker.comScoreResume(this);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void saveDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.putString(this.forumStatus.getForumId() + "|draft_pm_content", this.msgcontent.getText().toString());
        localEditor.putString(this.forumStatus.getForumId() + "|draft_pm_subject", this.msgsubject.getText().toString());
        localEditor.putString(this.forumStatus.getForumId() + "|draft_pm_recipient", this.msgto.getText().toString());
        localEditor.commit();
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void updateDialog(int paramInt) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = 31;
        localMessage.obj = new Integer(paramInt);
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateUI(int paramInt, Object paramObject) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateUI(String paramString) {
    }

    public void uploadToTk() {
        getContext().removeDialog(42);
        showDialog(42);
        new AsyncTask() {
            protected ArrayList doInBackground(String... paramAnonymousVarArgs) {
                if (CreatePmActivity.this.npAdapter == null) {
                    CreatePmActivity.this.npAdapter = new NewPostAdapter(CreatePmActivity.this.getContext(), CreatePmActivity.this.forumStatus.getUrl());
                }
                paramAnonymousVarArgs = new ArrayList();
                int i = ExifUtil.getExif(CreatePmActivity.this.getContext(), CreatePmActivity.this.photoUri);
                if (CreatePmActivity.this.mUploadAdapter != null) {
                    CreatePmActivity.this.mUploadAdapter.setUri(CreatePmActivity.this.photoUri, i);
                    paramAnonymousVarArgs.add(CreatePmActivity.this.npAdapter.attachImage(CreatePmActivity.this.mUploadAdapter));
                }
                UserBehavior.logUserShareForum(CreatePmActivity.this.getContext());
                return paramAnonymousVarArgs;
            }

            protected void onPostExecute(ArrayList paramAnonymousArrayList) {
                try {
                    CreatePmActivity.this.getContext().dismissDialog(42);
                    Object localObject = UploadAttachmentTool.getUploadImageInfo((String) paramAnonymousArrayList.get(0));
                    if (((UploadImageInfo) localObject).getResult() == 1) {
                        if ((((UploadImageInfo) localObject).getUrl() != null) && (((UploadImageInfo) localObject).getUrl().length() > 0)) {
                            paramAnonymousArrayList = CreatePmActivity.this.msgcontent.getText();
                            localObject = "[IMG]" + ((UploadImageInfo) localObject).getUrl() + "[/IMG]";
                            int i = ((String) localObject).length();
                            paramAnonymousArrayList.insert(CreatePmActivity.this.msgcontent.getSelectionStart(), (CharSequence) localObject, 0, i);
                        }
                    } else if (((UploadImageInfo) localObject).getResult_text() != null) {
                        Toast.makeText(CreatePmActivity.this.getContext(), ((UploadImageInfo) localObject).getResult_text(), 1).show();
                        return;
                    }
                } catch (Exception paramAnonymousArrayList) {
                }
            }
        }.execute(new String[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/CreatePmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */