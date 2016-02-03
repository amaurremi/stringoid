package com.quoord.tapatalkpro.activity.forum.conversation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.action.CallBackChecker;
import com.quoord.tapatalkpro.action.RemoveAttach;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.AttachDialogHelperAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewPostAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.adapter.forum.conversation.ConvManagerAdapter;
import com.quoord.tapatalkpro.bean.AttachmentInfo;
import com.quoord.tapatalkpro.bean.Conversation;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.PostData;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.UploadImageInfo;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ui.SmileInputBuilder;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.ExifUtil;
import com.quoord.tapatalkpro.util.InsertContent;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.UploadAttachmentTool;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.TapaButton;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.uploadanddownload.UploadImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateOrReplyConversationActivity
        extends Activity
        implements ForumActivityStatus, TryTwiceCallBackInterface {
    public static final int CAMERA = 1;
    public static final int GALLERY = 0;
    public static final int MENU_ATTCHMENT = 15;
    public static final int MENU_LINK = 2;
    public static final int MENU_PHOTO = 3;
    public static final int MENU_SEND = 5;
    public static final int MENU_SMILE = 4;
    public static final int UPLOAD = 7;
    public static final int UPLOAD_FORUM = 6;
    public static final int UPLOAD_TAPA = 8;
    private boolean IS_NEWCONVERSATION = false;
    private boolean IS_QUOTE = false;
    private boolean IS_REPLY = false;
    private boolean IS_SAVE_CREATECONVERSATION_DRAFT = true;
    private boolean IS_SAVE_QUOTECONVERSATION_DRAFT = true;
    private boolean IS_SAVE_REPLYCONVERSATION_DRAFT = true;
    private final int MENU_IMAGE_LINK = 11;
    private final int MENU_URL = 8;
    private AttachmentInfo achInfo;
    private int attachmentSize = 0;
    private ActionBar bar;
    private boolean canUpload = false;
    private Conversation conv;
    TextView conv_attachSection;
    LinearLayout conv_attachlay;
    private ImageButton conv_camera_button;
    private String conv_id = "";
    private ImageButton conv_link_button;
    private ImageButton conv_smile_button;
    private TapaButton discardButton;
    protected TapatalkEngine engine = null;
    private String extensions;
    private RelativeLayout footView;
    private ForumStatus forumStatus;
    private String groupId = null;
    public String imageName;
    private ConvManagerAdapter mAdapter;
    private TextView mAttachSectionTitle;
    private LinearLayout mAttachlay;
    private View mContentClickHandler;
    private Bitmap mImage;
    ProgressDialog mProgressDialog = null;
    private boolean mShouldShowContentClickHandler;
    public int mSize;
    private Handler mUIhandler;
    public UploadAdapter mUploadAdapter;
    private ProgressDialog mUploadProgressDialog = null;
    private SignInWithOtherUtil mUtil;
    private LinearLayout main;
    public String mimeType = "";
    private EditText msgcontent;
    private EditText msgsubject;
    private EditText msgto;
    private NewPostAdapter npAdapter;
    private Uri photoUri;
    private String quickqeply_text;
    private String quote_msg = "";
    private int rotate = 0;
    private CheckBox signatureTag;
    private MenuItem simle;
    private String singature = "";
    private GridView smileView;
    public boolean smileflag = false;
    private TapaButton submitButton;
    MenuItem submitItem;
    private Uri tempUri;
    private boolean upload;
    private String[] uploadTypes = null;
    public int upload_style = 0;
    private EditText urlView;

    private View addAttachment(ArrayList paramArrayList, Uri paramUri, int paramInt, String paramString) {
        final AttachmentInfo localAttachmentInfo = new AttachmentInfo();
        localAttachmentInfo.size = paramInt;
        localAttachmentInfo.contentType = "image/jepg";
        localAttachmentInfo.name = paramString;
        localAttachmentInfo.attachmentId = paramArrayList.get(paramArrayList.size() - 1).toString();
        final RelativeLayout localRelativeLayout = (RelativeLayout) getLayoutInflater().inflate(2130903418, this.mAttachlay, false);
        localRelativeLayout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("attachment_bg", this));
        paramArrayList = (ImageView) localRelativeLayout.findViewById(2131231702);
        if (this.mimeType.contains("image/")) {
            paramArrayList.setImageBitmap(getThumbnail(paramUri, paramInt));
        }
        TextView localTextView1 = (TextView) localRelativeLayout.findViewById(2131231704);
        TextView localTextView2 = (TextView) localRelativeLayout.findViewById(2131231705);
        paramArrayList = paramString;
        paramUri = "*";
        paramInt = paramString.lastIndexOf('.');
        if (paramInt >= 0) {
            paramArrayList = paramString.substring(0, paramInt);
            paramUri = paramString.substring(paramInt + 1);
        }
        localTextView1.setText(paramArrayList);
        if (localAttachmentInfo.size > 0L) {
            localTextView2.setText(Util.formatSize((float) localAttachmentInfo.size) + " / " + paramUri.toUpperCase());
        }
        for (; ; ) {
            paramArrayList = (ImageView) localRelativeLayout.findViewById(2131231703);
            paramArrayList.setImageDrawable(ThemeUtil.getDrawableByPicName("upload_attachment", this));
            paramArrayList.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    new RemoveAttach(localAttachmentInfo.attachmentId, "0", CreateOrReplyConversationActivity.this.npAdapter.groupId, CreateOrReplyConversationActivity.this.npAdapter.attachIds, CreateOrReplyConversationActivity.this, CreateOrReplyConversationActivity.this.forumStatus, CreateOrReplyConversationActivity.this.conv_id);
                    CreateOrReplyConversationActivity.this.mAttachlay.removeView(localRelativeLayout);
                    CreateOrReplyConversationActivity.this.updateAttachNumberText();
                }
            });
            return localRelativeLayout;
            localTextView2.setText(paramUri.toUpperCase());
        }
    }

    private EditText getFocusView() {
        View localView = getCurrentFocus();
        Object localObject;
        if (localView != null) {
            localObject = localView;
            if ((localView instanceof EditText)) {
            }
        } else {
            localObject = this.msgcontent;
        }
        return (EditText) localObject;
    }

    private void initUI() {
        Object localObject = new SmileInputBuilder(this);
        if (this.forumStatus.isIP()) {
            ((SmileInputBuilder) localObject).setForumType(0);
            ((SmileInputBuilder) localObject).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    paramAnonymousAdapterView = (String) CreateOrReplyConversationActivity.this.smileView.getAdapter().getItem(paramAnonymousInt);
                    paramAnonymousInt = CreateOrReplyConversationActivity.this.msgcontent.getSelectionStart();
                    CreateOrReplyConversationActivity.this.msgcontent.getEditableText().insert(paramAnonymousInt, paramAnonymousAdapterView);
                }
            });
            this.smileView = ((SmileInputBuilder) localObject).create();
            this.msgsubject = ((EditText) findViewById(2131231404));
            this.msgsubject.setSingleLine(false);
            this.msgsubject.setEnabled(true);
            this.conv_camera_button = ((ImageButton) findViewById(2131231412));
            if ((this.forumStatus.getForumId() == null) || (this.forumStatus.getForumId().equalsIgnoreCase("0"))) {
                this.conv_camera_button.setVisibility(8);
            }
            this.conv_link_button = ((ImageButton) findViewById(2131231413));
            this.conv_smile_button = ((ImageButton) findViewById(2131231414));
            this.msgto = ((EditText) findViewById(2131231403));
            this.msgcontent = ((EditText) findViewById(2131231405));
            if ((this.quickqeply_text != null) && (!this.quickqeply_text.equals(""))) {
                this.msgcontent.setText(this.quickqeply_text);
            }
            this.footView = ((RelativeLayout) findViewById(2131231415));
            this.conv_attachlay = ((LinearLayout) findViewById(2131231409));
            this.conv_attachSection = ((TextView) findViewById(2131231408));
            this.signatureTag = ((CheckBox) findViewById(2131231407));
            this.main = ((LinearLayout) findViewById(2131231416));
            if ((this.forumStatus.isSupportSignature()) && (this.singature != null) && (this.singature.length() > 0)) {
                this.signatureTag.setVisibility(0);
                this.signatureTag.setText(this.singature);
            }
            if (!this.IS_REPLY) {
                break label755;
            }
            this.msgsubject.setVisibility(8);
            this.msgto.setVisibility(8);
            label350:
            this.discardButton = ((TapaButton) findViewById(2131231411));
            this.submitButton = ((TapaButton) findViewById(2131231410));
            if (getResources().getConfiguration().orientation != 0) {
                break label897;
            }
            this.smileView.setColumnWidth(9);
            this.smileView.setLayoutParams(new RelativeLayout.LayoutParams(-1, 300));
            label418:
            this.discardButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    CreateOrReplyConversationActivity.this.getContext().showDialog(15);
                }
            });
            this.submitButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    CreateOrReplyConversationActivity.this.submit();
                }
            });
            if ((!this.forumStatus.tapatalkForum.isMedia_sharing()) && (!this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                break label941;
            }
            this.conv_camera_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    CreateOrReplyConversationActivity.this.getContext().showDialog(9);
                }
            });
        }
        for (; ; ) {
            this.conv_link_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    CreateOrReplyConversationActivity.this.getContext().showDialog(45);
                }
            });
            this.conv_smile_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (!CreateOrReplyConversationActivity.this.smileflag) {
                        CreateOrReplyConversationActivity.this.footView.addView(CreateOrReplyConversationActivity.this.smileView);
                        CreateOrReplyConversationActivity.this.conv_smile_button.setImageResource(2130837668);
                        ((InputMethodManager) CreateOrReplyConversationActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(CreateOrReplyConversationActivity.this.msgcontent.getApplicationWindowToken(), 2);
                        CreateOrReplyConversationActivity.this.smileflag = true;
                        return;
                    }
                    CreateOrReplyConversationActivity.this.conv_smile_button.setImageResource(2130837678);
                    CreateOrReplyConversationActivity.this.footView.removeView(CreateOrReplyConversationActivity.this.smileView);
                    ((InputMethodManager) CreateOrReplyConversationActivity.this.getSystemService("input_method")).showSoftInput(CreateOrReplyConversationActivity.this.msgcontent, 1);
                    CreateOrReplyConversationActivity.this.smileflag = false;
                }
            });
            if (this.forumStatus.isDefaultSmilies()) {
                this.msgcontent.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                        if (CreateOrReplyConversationActivity.this.msgcontent.isFocused()) {
                            if (CreateOrReplyConversationActivity.this.smileflag) {
                                CreateOrReplyConversationActivity.this.conv_smile_button.setImageResource(2130837678);
                                CreateOrReplyConversationActivity.this.footView.removeView(CreateOrReplyConversationActivity.this.smileView);
                                ((InputMethodManager) CreateOrReplyConversationActivity.this.getSystemService("input_method")).showSoftInput(CreateOrReplyConversationActivity.this.msgcontent, 1);
                                CreateOrReplyConversationActivity.this.smileflag = false;
                            }
                            return false;
                        }
                        CreateOrReplyConversationActivity.this.msgcontent.requestFocus();
                        return false;
                    }
                });
                this.msgcontent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                        if (!paramAnonymousBoolean) {
                            CreateOrReplyConversationActivity.this.conv_smile_button.setVisibility(8);
                            CreateOrReplyConversationActivity.this.conv_smile_button.setImageResource(2130837678);
                            CreateOrReplyConversationActivity.this.footView.removeView(CreateOrReplyConversationActivity.this.smileView);
                            ((InputMethodManager) CreateOrReplyConversationActivity.this.getSystemService("input_method")).showSoftInput(CreateOrReplyConversationActivity.this.msgcontent, 1);
                            CreateOrReplyConversationActivity.this.smileflag = false;
                            return;
                        }
                        CreateOrReplyConversationActivity.this.conv_smile_button.setVisibility(0);
                        CreateOrReplyConversationActivity.this.conv_smile_button.setImageResource(2130837678);
                        if (!CreateOrReplyConversationActivity.this.smileflag) {
                            ((InputMethodManager) CreateOrReplyConversationActivity.this.getSystemService("input_method")).showSoftInput(CreateOrReplyConversationActivity.this.msgcontent, 1);
                            return;
                        }
                        ((InputMethodManager) CreateOrReplyConversationActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(CreateOrReplyConversationActivity.this.msgcontent.getApplicationWindowToken(), 2);
                    }
                });
            }
            return;
            if ((this.forumStatus.isKN1()) || (this.forumStatus.isKN2()) || (this.forumStatus.isKN3())) {
                ((SmileInputBuilder) localObject).setForumType(1);
                break;
            }
            if (this.forumStatus.isMB()) {
                ((SmileInputBuilder) localObject).setForumType(2);
                break;
            }
            if (this.forumStatus.isPB()) {
                ((SmileInputBuilder) localObject).setForumType(3);
                break;
            }
            if (this.forumStatus.isSMF1()) {
                ((SmileInputBuilder) localObject).setForumType(4);
                break;
            }
            if (this.forumStatus.isSMF2()) {
                ((SmileInputBuilder) localObject).setForumType(5);
                break;
            }
            if (this.forumStatus.isXF()) {
                ((SmileInputBuilder) localObject).setForumType(6);
                break;
            }
            if (this.forumStatus.isVB3()) {
                ((SmileInputBuilder) localObject).setForumType(10);
                break;
            }
            if (this.forumStatus.isVB4()) {
                ((SmileInputBuilder) localObject).setForumType(11);
                break;
            }
            if (this.forumStatus.isVB5()) {
                ((SmileInputBuilder) localObject).setForumType(12);
                break;
            }
            ((SmileInputBuilder) localObject).setForumType(7);
            break;
            label755:
            if (!this.IS_QUOTE) {
                break label350;
            }
            String str = "";
            this.msgsubject.setVisibility(8);
            this.msgto.setVisibility(8);
            localObject = str;
            if (this.forumStatus.isSupportSignature()) {
                localObject = str;
                if (this.singature != null) {
                    localObject = str;
                    if (this.singature.length() > 0) {
                        localObject = "\n\n" + this.singature;
                    }
                }
            }
            this.msgcontent.setText("");
            this.msgcontent.setText(this.quote_msg + "\n" + (String) localObject);
            this.msgcontent.setSelection(this.quote_msg.length());
            break label350;
            label897:
            if (getResources().getConfiguration().orientation != 1) {
                break label418;
            }
            this.smileView.setColumnWidth(6);
            this.smileView.setLayoutParams(new RelativeLayout.LayoutParams(-1, 300));
            break label418;
            label941:
            this.conv_camera_button.setVisibility(8);
        }
    }

    private void submit() {
        this.forumStatus.getUrl();
        this.mAdapter = new ConvManagerAdapter(getContext(), this.forumStatus.getUrl());
        Object localObject2 = this.msgcontent.getText().toString();
        Object localObject1 = localObject2;
        if (this.forumStatus.isSupportEmoji()) {
            localObject1 = BBcodeUtil.parseAllForumPublicSmileToEmojiBBCode((String) localObject2);
        }
        if (this.IS_REPLY) {
            if (this.msgcontent.getEditableText().length() == 0) {
                Toast.makeText(getContext(), getContext().getString(2131099777), 1).show();
                return;
            }
            localObject2 = new ArrayList();
            if ((this.forumStatus.isSupportSignature()) && (this.singature != null) && (this.singature.length() > 0) && (this.signatureTag.isChecked())) {
                localObject1 = (localObject1 + "\n\n" + this.singature + "\n\n").getBytes();
                ((ArrayList) localObject2).add(this.conv_id);
                ((ArrayList) localObject2).add(localObject1);
                if (this.npAdapter.attachIds.size() != 0) {
                    ((ArrayList) localObject2).add(new String().getBytes());
                    ((ArrayList) localObject2).add(this.npAdapter.attachIds.toArray(new String[this.npAdapter.attachIds.size()]));
                    if (this.npAdapter.groupId == null) {
                        break label317;
                    }
                    ((ArrayList) localObject2).add(this.npAdapter.groupId);
                }
            }
            for (; ; ) {
                this.mAdapter.ReplyConversation((ArrayList) localObject2, this.conv);
                getContext().showDialog(0);
                this.IS_SAVE_REPLYCONVERSATION_DRAFT = false;
                clearReplyConvDraft();
                return;
                localObject1 = ((String) localObject1).getBytes();
                break;
                label317:
                ((ArrayList) localObject2).add("");
            }
        }
        if (this.IS_QUOTE) {
            if (this.msgcontent.getEditableText().length() == 0) {
                Toast.makeText(getContext(), getContext().getString(2131099777), 1).show();
                return;
            }
            localObject2 = new ArrayList();
            localObject1 = ((String) localObject1).getBytes();
            ((ArrayList) localObject2).add(this.conv_id);
            ((ArrayList) localObject2).add(localObject1);
            if (this.npAdapter.attachIds.size() != 0) {
                ((ArrayList) localObject2).add(this.npAdapter.attachIds.toArray(new String[this.npAdapter.attachIds.size()]));
                if (this.npAdapter.groupId == null) {
                    break label492;
                }
                ((ArrayList) localObject2).add(this.npAdapter.groupId);
            }
            for (; ; ) {
                this.mAdapter.ReplyConversation((ArrayList) localObject2, this.conv);
                getContext().showDialog(0);
                this.IS_SAVE_QUOTECONVERSATION_DRAFT = false;
                clearQuoteConvDraft();
                return;
                label492:
                ((ArrayList) localObject2).add("");
            }
        }
        if (this.msgcontent.getEditableText().length() == 0) {
            Toast.makeText(getContext(), getContext().getString(2131099777), 1).show();
            return;
        }
        if (this.msgsubject.getText().toString().length() == 0) {
            Toast.makeText(getContext(), getContext().getString(2131099778), 1).show();
            return;
        }
        if (this.msgto.getText().toString().length() == 0) {
            Toast.makeText(getContext(), getContext().getString(2131099779), 1).show();
            return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject2 = this.msgto.getText().toString().split(";");
        Object[] arrayOfObject = new Object[localObject2.length];
        int i = 0;
        for (; ; ) {
            if (i >= localObject2.length) {
                localArrayList.add(arrayOfObject);
                if ((!this.forumStatus.isSupportSignature()) || (this.singature == null) || (this.singature.length() <= 0) || (!this.signatureTag.isChecked())) {
                    break label886;
                }
                localObject1 = (localObject1 + "\n\n" + this.singature + "\n\n").getBytes();
            }
            try {
                for (; ; ) {
                    localObject2 = this.msgsubject.getText().toString().getBytes("UTF-8");
                    localArrayList.add(localObject2);
                    localArrayList.add(localObject1);
                    if (this.npAdapter.attachIds.size() != 0) {
                        localArrayList.add(this.npAdapter.attachIds.toArray(new String[this.npAdapter.attachIds.size()]));
                        if (this.npAdapter.groupId == null) {
                            break label914;
                        }
                        localArrayList.add(this.npAdapter.groupId);
                    }
                    this.mAdapter.CreateNewConversation(localArrayList);
                    getContext().showDialog(0);
                    this.IS_SAVE_CREATECONVERSATION_DRAFT = false;
                    clearCreateConvDraft();
                    return;
                    arrayOfObject[i] = localObject2[i].getBytes();
                    i += 1;
                    break;
                    label886:
                    localObject1 = ((String) localObject1).getBytes();
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    byte[] arrayOfByte = this.msgsubject.getText().toString().getBytes();
                    continue;
                    label914:
                    localArrayList.add("");
                }
            }
        }
    }

    public void attachImage() {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("");
        localArrayList.add(this.conv_id);
        localArrayList.add(this.mUploadAdapter);
        if (this.groupId != null) {
            localArrayList.add(this.groupId);
        }
        localArrayList.add("pm");
        if (this.imageName != null) {
            localArrayList.add(this.imageName);
            localArrayList.add(this.mimeType);
        }
        this.engine.call("upload_attachment_x", localArrayList);
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this, this.forumStatus, this.engine, isOpCancel(), this)) && (paramEngineResponse.getMethod().endsWith("upload_attachment_x"))) {
            try {
                this.mUploadAdapter.closeByteStream();
                boolean bool = paramEngineResponse.isSuccess();
                HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
                String str1;
                String str2;
                return;
            } catch (Exception localException1) {
                try {
                    dismissDialog(42);
                    if (bool) {
                        if ((localHashMap.containsKey("result")) && (((Boolean) localHashMap.get("result")).booleanValue())) {
                            str1 = "";
                            if (localHashMap.containsKey("attachment_id")) {
                                str1 = (String) localHashMap.get("attachment_id");
                            }
                            if (localHashMap.containsKey("group_id")) {
                                this.groupId = ((String) localHashMap.get("group_id"));
                            }
                            upload_forum(this.photoUri, str1, this.groupId);
                            return;
                        }
                        str1 = "";
                        bool = localHashMap.containsKey("result_text");
                        if (bool) {
                        }
                        try {
                            str1 = new String((byte[]) localHashMap.get("result_text"), "UTF-8");
                            new HashMap().put("errormessage", str1);
                            Toast.makeText(this, str1, 0).show();
                            return;
                            localException1 = localException1;
                            localException1.printStackTrace();
                            if ((paramEngineResponse.getResponse() instanceof String)) {
                                Toast.makeText(this, paramEngineResponse.getResponse().toString(), 1).show();
                                return;
                            }
                        } catch (Exception localException2) {
                            for (; ; ) {
                                str2 = new String((byte[]) localHashMap.get("result_text"));
                            }
                        }
                    }
                } catch (Exception localException3) {
                    for (; ; ) {
                    }
                }
            }
        }
    }

    public void clearCreateConvDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.remove(this.forumStatus.getForumId() + "|conv_createConv_draft_content");
        localEditor.remove(this.forumStatus.getForumId() + "|conv_createConv_draft_subject");
        localEditor.remove(this.forumStatus.getForumId() + "|conv_createConv_draft_msgto");
        localEditor.commit();
    }

    public void clearQuoteConvDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.remove(this.forumStatus.getForumId() + "|conv_quoteConv_draft_content");
        localEditor.commit();
    }

    public void clearReplyConvDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.remove(this.forumStatus.getForumId() + "|conv_replyConv_draft_content");
        localEditor.commit();
    }

    public void closeProgress() {
    }

    public Activity getContext() {
        return this;
    }

    public Activity getDefaultActivity() {
        return this;
    }

    public void getEachExtensionSize() {
        if (this.mimeType.contains("\\/")) {
            this.mSize = ((Integer) this.forumStatus.getEach_extension_size().get(this.mimeType.split("\\/")[(this.mimeType.split("\\/").length - 1)])).intValue();
        }
    }

    /* Error */
    public void getFileInfo() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 266	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:photoUri	Landroid/net/Uri;
        //   4: ifnull +86 -> 90
        //   7: aload_0
        //   8: invokevirtual 897	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:getContentResolver	()Landroid/content/ContentResolver;
        //   11: aload_0
        //   12: getfield 266	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:photoUri	Landroid/net/Uri;
        //   15: iconst_3
        //   16: anewarray 360	java/lang/String
        //   19: dup
        //   20: iconst_0
        //   21: ldc_w 899
        //   24: aastore
        //   25: dup
        //   26: iconst_1
        //   27: ldc_w 901
        //   30: aastore
        //   31: dup
        //   32: iconst_2
        //   33: ldc_w 903
        //   36: aastore
        //   37: aconst_null
        //   38: aconst_null
        //   39: aconst_null
        //   40: invokevirtual 909	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   43: astore_1
        //   44: aload_1
        //   45: ifnull +46 -> 91
        //   48: aload_1
        //   49: invokeinterface 914 1 0
        //   54: ifeq +37 -> 91
        //   57: aload_0
        //   58: aload_1
        //   59: iconst_0
        //   60: invokeinterface 915 2 0
        //   65: putfield 219	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:mimeType	Ljava/lang/String;
        //   68: aload_0
        //   69: aload_1
        //   70: iconst_1
        //   71: invokeinterface 915 2 0
        //   76: putfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   79: aload_0
        //   80: aload_1
        //   81: iconst_2
        //   82: invokeinterface 918 2 0
        //   87: putfield 888	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:mSize	I
        //   90: return
        //   91: aconst_null
        //   92: astore 4
        //   94: aconst_null
        //   95: astore 5
        //   97: aconst_null
        //   98: astore_3
        //   99: aload 5
        //   101: astore_1
        //   102: aload_0
        //   103: aload_0
        //   104: getfield 266	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:photoUri	Landroid/net/Uri;
        //   107: invokevirtual 921	android/net/Uri:toString	()Ljava/lang/String;
        //   110: putfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   113: aload 5
        //   115: astore_1
        //   116: aload_0
        //   117: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   120: ldc_w 923
        //   123: invokevirtual 364	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   126: ifeq +41 -> 167
        //   129: aload 5
        //   131: astore_1
        //   132: aload_0
        //   133: aload_0
        //   134: getfield 925	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:achInfo	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
        //   137: aload_0
        //   138: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   141: ldc_w 927
        //   144: invokevirtual 734	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   147: aload_0
        //   148: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   151: ldc_w 927
        //   154: invokevirtual 734	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   157: arraylength
        //   158: iconst_1
        //   159: isub
        //   160: aaload
        //   161: invokevirtual 930	com/quoord/tapatalkpro/bean/AttachmentInfo:getUploadType	(Ljava/lang/String;)Ljava/lang/String;
        //   164: putfield 219	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:mimeType	Ljava/lang/String;
        //   167: aload 5
        //   169: astore_1
        //   170: new 395	java/lang/StringBuilder
        //   173: dup
        //   174: invokespecial 931	java/lang/StringBuilder:<init>	()V
        //   177: invokestatic 937	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   180: invokevirtual 940	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   183: ldc_w 942
        //   186: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   192: astore_2
        //   193: aload 5
        //   195: astore_1
        //   196: aload_0
        //   197: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   200: aload_2
        //   201: invokevirtual 364	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   204: ifeq +134 -> 338
        //   207: aload 5
        //   209: astore_1
        //   210: aload_0
        //   211: aload_0
        //   212: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   215: aload_2
        //   216: invokevirtual 734	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   219: iconst_1
        //   220: aaload
        //   221: putfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   224: aload 5
        //   226: astore_1
        //   227: new 944	java/io/File
        //   230: dup
        //   231: new 395	java/lang/StringBuilder
        //   234: dup
        //   235: aload_2
        //   236: invokestatic 405	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   239: invokespecial 408	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   242: aload_0
        //   243: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   246: invokevirtual 414	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   249: invokevirtual 418	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   252: invokespecial 945	java/io/File:<init>	(Ljava/lang/String;)V
        //   255: astore_2
        //   256: aload 5
        //   258: astore_1
        //   259: aload_0
        //   260: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   263: ldc_w 942
        //   266: invokevirtual 364	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   269: ifeq +34 -> 303
        //   272: aload 5
        //   274: astore_1
        //   275: aload_0
        //   276: aload_0
        //   277: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   280: ldc_w 877
        //   283: invokevirtual 734	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   286: aload_0
        //   287: getfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   290: ldc_w 877
        //   293: invokevirtual 734	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   296: arraylength
        //   297: iconst_1
        //   298: isub
        //   299: aaload
        //   300: putfield 756	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:imageName	Ljava/lang/String;
        //   303: aload 5
        //   305: astore_1
        //   306: new 947	java/io/FileInputStream
        //   309: dup
        //   310: aload_2
        //   311: invokespecial 950	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   314: astore_2
        //   315: aload_0
        //   316: aload_2
        //   317: invokevirtual 953	java/io/FileInputStream:available	()I
        //   320: putfield 888	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:mSize	I
        //   323: aload_2
        //   324: ifnull -234 -> 90
        //   327: aload_2
        //   328: invokevirtual 956	java/io/FileInputStream:close	()V
        //   331: return
        //   332: astore_1
        //   333: aload_1
        //   334: invokevirtual 957	java/io/IOException:printStackTrace	()V
        //   337: return
        //   338: aload 5
        //   340: astore_1
        //   341: new 944	java/io/File
        //   344: dup
        //   345: aload_0
        //   346: getfield 266	com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity:photoUri	Landroid/net/Uri;
        //   349: invokevirtual 921	android/net/Uri:toString	()Ljava/lang/String;
        //   352: invokespecial 945	java/io/File:<init>	(Ljava/lang/String;)V
        //   355: astore_2
        //   356: goto -100 -> 256
        //   359: astore_1
        //   360: aload_3
        //   361: astore_2
        //   362: aload_1
        //   363: astore_3
        //   364: aload_2
        //   365: astore_1
        //   366: aload_3
        //   367: invokevirtual 958	java/io/FileNotFoundException:printStackTrace	()V
        //   370: aload_2
        //   371: ifnull -281 -> 90
        //   374: aload_2
        //   375: invokevirtual 956	java/io/FileInputStream:close	()V
        //   378: return
        //   379: astore_1
        //   380: aload_1
        //   381: invokevirtual 957	java/io/IOException:printStackTrace	()V
        //   384: return
        //   385: astore_3
        //   386: aload 4
        //   388: astore_2
        //   389: aload_2
        //   390: astore_1
        //   391: aload_3
        //   392: invokevirtual 957	java/io/IOException:printStackTrace	()V
        //   395: aload_2
        //   396: ifnull -306 -> 90
        //   399: aload_2
        //   400: invokevirtual 956	java/io/FileInputStream:close	()V
        //   403: return
        //   404: astore_1
        //   405: aload_1
        //   406: invokevirtual 957	java/io/IOException:printStackTrace	()V
        //   409: return
        //   410: astore_3
        //   411: aload_1
        //   412: astore_2
        //   413: aload_3
        //   414: astore_1
        //   415: aload_2
        //   416: ifnull +7 -> 423
        //   419: aload_2
        //   420: invokevirtual 956	java/io/FileInputStream:close	()V
        //   423: aload_1
        //   424: athrow
        //   425: astore_2
        //   426: aload_2
        //   427: invokevirtual 957	java/io/IOException:printStackTrace	()V
        //   430: goto -7 -> 423
        //   433: astore_1
        //   434: goto -19 -> 415
        //   437: astore_3
        //   438: goto -49 -> 389
        //   441: astore_3
        //   442: goto -78 -> 364
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	445	0	this	CreateOrReplyConversationActivity
        //   43	263	1	localObject1	Object
        //   332	2	1	localIOException1	IOException
        //   340	1	1	localObject2	Object
        //   359	4	1	localFileNotFoundException1	FileNotFoundException
        //   365	1	1	localObject3	Object
        //   379	2	1	localIOException2	IOException
        //   390	1	1	localObject4	Object
        //   404	8	1	localIOException3	IOException
        //   414	10	1	localObject5	Object
        //   433	1	1	localObject6	Object
        //   192	228	2	localObject7	Object
        //   425	2	2	localIOException4	IOException
        //   98	269	3	localFileNotFoundException2	FileNotFoundException
        //   385	7	3	localIOException5	IOException
        //   410	4	3	localObject8	Object
        //   437	1	3	localIOException6	IOException
        //   441	1	3	localFileNotFoundException3	FileNotFoundException
        //   92	295	4	localObject9	Object
        //   95	244	5	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   327	331	332	java/io/IOException
        //   102	113	359	java/io/FileNotFoundException
        //   116	129	359	java/io/FileNotFoundException
        //   132	167	359	java/io/FileNotFoundException
        //   170	193	359	java/io/FileNotFoundException
        //   196	207	359	java/io/FileNotFoundException
        //   210	224	359	java/io/FileNotFoundException
        //   227	256	359	java/io/FileNotFoundException
        //   259	272	359	java/io/FileNotFoundException
        //   275	303	359	java/io/FileNotFoundException
        //   306	315	359	java/io/FileNotFoundException
        //   341	356	359	java/io/FileNotFoundException
        //   374	378	379	java/io/IOException
        //   102	113	385	java/io/IOException
        //   116	129	385	java/io/IOException
        //   132	167	385	java/io/IOException
        //   170	193	385	java/io/IOException
        //   196	207	385	java/io/IOException
        //   210	224	385	java/io/IOException
        //   227	256	385	java/io/IOException
        //   259	272	385	java/io/IOException
        //   275	303	385	java/io/IOException
        //   306	315	385	java/io/IOException
        //   341	356	385	java/io/IOException
        //   399	403	404	java/io/IOException
        //   102	113	410	finally
        //   116	129	410	finally
        //   132	167	410	finally
        //   170	193	410	finally
        //   196	207	410	finally
        //   210	224	410	finally
        //   227	256	410	finally
        //   259	272	410	finally
        //   275	303	410	finally
        //   306	315	410	finally
        //   341	356	410	finally
        //   366	370	410	finally
        //   391	395	410	finally
        //   419	423	425	java/io/IOException
        //   315	323	433	finally
        //   315	323	437	java/io/IOException
        //   315	323	441	java/io/FileNotFoundException
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

    public Bitmap getThumbnail(Uri paramUri, int paramInt) {
        localObject1 = null;
        try {
            localObject2 = getContentResolver().openInputStream(paramUri);
            localObject1 = localObject2;
        } catch (FileNotFoundException localFileNotFoundException) {
            try {
                Object localObject2;
                ((InputStream) localObject1).close();
                try {
                    paramUri = getContentResolver().openInputStream(paramUri);
                    localObject1 = paramUri;
                } catch (FileNotFoundException paramUri) {
                    for (; ; ) {
                        paramUri.printStackTrace();
                    }
                }
                int i = i * j / 2000000;
                paramUri = new BitmapFactory.Options();
                int j = paramInt / 70000;
                paramInt = j;
                if (i <= j) {
                    break label106;
                }
                paramInt = i;
                paramUri.inSampleSize = ((int) Math.sqrt(paramInt) + 1);
                this.mImage = BitmapFactory.decodeStream((InputStream) localObject1, null, paramUri);
                paramInt = this.mImage.getWidth();
                i = this.mImage.getHeight();
                paramUri = new Matrix();
                paramUri.postScale(Util.getPxFromDip(this, 62.0F) / paramInt, Util.getPxFromDip(this, 62.0F) / i);
                return Bitmap.createBitmap(this.mImage, 0, 0, paramInt, i, paramUri, true);
                localFileNotFoundException = localFileNotFoundException;
                localFileNotFoundException.printStackTrace();
            } catch (IOException localIOException) {
                for (; ; ) {
                    localIOException.printStackTrace();
                }
            }
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options) localObject2).inJustDecodeBounds = true;
        BitmapFactory.decodeStream((InputStream) localObject1, null, (BitmapFactory.Options) localObject2);
        i = ((BitmapFactory.Options) localObject2).outWidth;
        j = ((BitmapFactory.Options) localObject2).outHeight;
    }

    public boolean getTryTwice() {
        return false;
    }

    public void initEditText(AttachmentInfo paramAttachmentInfo, int paramInt) {
        String str = "";
        EditText localEditText2 = getFocusView();
        EditText localEditText1 = localEditText2;
        if (localEditText2 == this.msgsubject) {
            localEditText1 = this.msgcontent;
        }
        if (this.forumStatus.isVB()) {
            str = "[ATTACH]" + paramAttachmentInfo.attachmentId + "[/ATTACH]";
        }
        for (; ; ) {
            localEditText1.getEditableText().insert(localEditText1.getSelectionStart(), str);
            return;
            if (this.forumStatus.isPB()) {
                str = "[attachment=" + paramInt + "]" + paramAttachmentInfo.name + "[/attachment]";
            } else if (this.forumStatus.isIP()) {
                str = "[attachment=" + paramAttachmentInfo.attachmentId + ":" + paramAttachmentInfo.name + "]";
            } else if (this.forumStatus.isXF()) {
                str = "[ATTACH=full]" + paramAttachmentInfo.attachmentId + "[/ATTACH]";
            } else if (this.forumStatus.isMB()) {
                str = "[attachment=" + paramAttachmentInfo.attachmentId + "]";
            } else if ((this.forumStatus.isKN1()) || (this.forumStatus.isKN2())) {
                str = "[attachment=" + paramAttachmentInfo.attachmentId + "]" + paramAttachmentInfo.name + "[/attachment]";
            }
        }
    }

    public boolean isAllowType() {
        if (this.mimeType.equals("*/*")) {
            return true;
        }
        int i;
        if (this.uploadTypes != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.uploadTypes.length) {
                return false;
            }
            if (this.uploadTypes[i].equals(this.mimeType)) {
                return true;
            }
            i += 1;
        }
    }

    public boolean isOpCancel() {
        return false;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 0) {
            if (paramInt2 == -1) {
                this.photoUri = paramIntent.getData();
                if (this.photoUri != null) {
                    getFileInfo();
                    if (this.upload_style == 3) {
                        uploadToTk();
                    }
                    if ((this.upload_style == 15) && (this.forumStatus != null) && (this.forumStatus.isCan_upload_attachment_conv())) {
                        if (this.extensions == null) {
                            break label160;
                        }
                        if (!isAllowType()) {
                            break label144;
                        }
                        if (this.mSize > this.attachmentSize) {
                            break label96;
                        }
                        uploadAttachment();
                    }
                }
            }
        }
        label96:
        label144:
        label160:
        do {
            return;
            Toast.makeText(this, getString(2131100915, new Object[]{Integer.valueOf(this.mSize / 1024), Integer.valueOf(this.attachmentSize / 1024)}), 0).show();
            return;
            Toast.makeText(this, getString(2131100913), 0).show();
            return;
            uploadAttachment();
            return;
            if (paramInt1 != 1) {
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
        if (getApplicationContext().getResources().getConfiguration().orientation == 2) {
            this.smileView.setColumnWidth(9);
            this.smileView.setLayoutParams(new RelativeLayout.LayoutParams(-1, 300));
        }
        while (getApplicationContext().getResources().getConfiguration().orientation != 1) {
            return;
        }
        this.smileView.setColumnWidth(6);
        this.smileView.setLayoutParams(new RelativeLayout.LayoutParams(-1, 300));
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.bar = getActionBar();
        this.bar.setIcon(2130837525);
        this.bar.setDisplayHomeAsUpEnabled(true);
        setContentView(2130903283);
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        this.engine = new TapatalkEngine(this, this.forumStatus, this);
        this.npAdapter = new NewPostAdapter(this, this.forumStatus.getUrl());
        if (this.forumStatus == null) {
            return;
        }
        this.singature = SettingsFragment.getSingature(getContext(), this.forumStatus.getSigType(), this.forumStatus);
        this.mUploadAdapter = new UploadAdapter(getContext(), this.forumStatus.getMaxJpgSize());
        paramBundle = getIntent();
        this.IS_QUOTE = getContext().getIntent().getBooleanExtra("is_quote", false);
        this.IS_NEWCONVERSATION = paramBundle.getBooleanExtra("is_newConversation", false);
        this.IS_REPLY = paramBundle.getBooleanExtra("is_reply", false);
        this.conv = ((Conversation) paramBundle.getSerializableExtra("conv"));
        this.quickqeply_text = paramBundle.getStringExtra("quickqeply_text");
        this.canUpload = paramBundle.getBooleanExtra("can_upload", false);
        SharedPreferences localSharedPreferences = getPreferences(0);
        if (this.IS_QUOTE) {
            this.quote_msg = paramBundle.getStringExtra("conv_content");
            this.conv_id = paramBundle.getStringExtra("conv_id");
            if (localSharedPreferences.contains(this.forumStatus.getForumId() + "|conv_quoteConv_draft_content")) {
                showDialog(44);
            }
        }
        initUI();
        if (this.IS_NEWCONVERSATION) {
            this.bar.setTitle(getString(2131100164));
            PostData localPostData = (PostData) paramBundle.getSerializableExtra("postData");
            String str = (String) paramBundle.getSerializableExtra("conversationName");
            if (localPostData != null) {
                this.msgto.setText(localPostData.authorName);
            }
            if (str != null) {
                this.msgto.setText(str);
            }
            this.msgto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                }
            });
            if ((localSharedPreferences.contains(this.forumStatus.getForumId() + "|conv_createConv_draft_content")) || (localSharedPreferences.contains(this.forumStatus.getForumId() + "|conv_createConv__draft_subject")) || (localSharedPreferences.contains(this.forumStatus.getForumId() + "|conv_createConv_draft_msgto"))) {
                showDialog(44);
            }
        }
        if (this.IS_REPLY) {
            this.bar.setTitle(getString(2131100165));
            this.conv_id = paramBundle.getStringExtra("conv_id");
            if ((this.conv_id != null) && (localSharedPreferences.contains(this.forumStatus.getForumId() + "|conv_replyConv_draft_content"))) {
                showDialog(44);
            }
        }
        this.mUIhandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                int i;
                if (37 == paramAnonymousMessage.what) {
                    i = ((Integer) paramAnonymousMessage.obj).intValue();
                }
                try {
                    CreateOrReplyConversationActivity.this.mUploadProgressDialog.setMax(CreateOrReplyConversationActivity.this.mUploadAdapter.realSize);
                    CreateOrReplyConversationActivity.this.mUploadProgressDialog.setProgress(i);
                    if (i == CreateOrReplyConversationActivity.this.mUploadAdapter.realSize) {
                        CreateOrReplyConversationActivity.this.mUploadProgressDialog.setTitle(CreateOrReplyConversationActivity.this.getContext().getString(2131100202));
                    }
                    return;
                } catch (Exception paramAnonymousMessage) {
                    paramAnonymousMessage.printStackTrace();
                }
            }
        };
        this.upload = Prefs.get(this).getBoolean("photoandattachment", true);
        this.mUtil = new SignInWithOtherUtil(this);
    }

    protected Dialog onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 0:
                localObject = new ProgressDialog(this);
                ((ProgressDialog) localObject).setMessage(getContext().getString(2131100166));
                ((ProgressDialog) localObject).setIndeterminate(true);
                ((ProgressDialog) localObject).setCancelable(true);
                this.mProgressDialog = ((ProgressDialog) localObject);
                return (Dialog) localObject;
            case 42:
                this.mUploadProgressDialog = new ProgressDialog(getContext());
                this.mUploadProgressDialog.setMax(100);
                this.mUploadProgressDialog.setProgress(0);
                this.mUploadProgressDialog.setIcon(17301640);
                this.mUploadProgressDialog.setTitle(getContext().getString(2131100203));
                this.mUploadProgressDialog.setProgressStyle(1);
                this.mUploadProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface paramAnonymousDialogInterface) {
                    }
                });
                this.mUploadProgressDialog.setCanceledOnTouchOutside(false);
                return this.mUploadProgressDialog;
            case 2:
                new AlertDialog.Builder(this).setTitle(getApplicationContext().getString(2131099953)).setMessage(getApplicationContext().getString(2131099952)).setPositiveButton(getContext().getText(2131099976).toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreateOrReplyConversationActivity.this.uploadToTk();
                    }
                }).setNegativeButton(getContext().getText(2131099974).toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).create();
            case 15:
                new AlertDialog.Builder(this).setTitle(getContext().getString(2131099901)).setPositiveButton(getContext().getString(2131099900), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        if (CreateOrReplyConversationActivity.this.IS_NEWCONVERSATION) {
                            CreateOrReplyConversationActivity.this.IS_SAVE_CREATECONVERSATION_DRAFT = false;
                            CreateOrReplyConversationActivity.this.clearCreateConvDraft();
                        }
                        if (CreateOrReplyConversationActivity.this.IS_REPLY) {
                            CreateOrReplyConversationActivity.this.IS_SAVE_REPLYCONVERSATION_DRAFT = false;
                            CreateOrReplyConversationActivity.this.clearReplyConvDraft();
                        }
                        if (CreateOrReplyConversationActivity.this.IS_QUOTE) {
                            CreateOrReplyConversationActivity.this.IS_SAVE_QUOTECONVERSATION_DRAFT = false;
                            CreateOrReplyConversationActivity.this.clearQuoteConvDraft();
                        }
                        CreateOrReplyConversationActivity.this.getContext().finish();
                    }
                }).setNegativeButton(getContext().getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).setNeutralButton(getContext().getString(2131099793), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreateOrReplyConversationActivity.this.getContext().finish();
                    }
                }).create();
            case 44:
                new AlertDialog.Builder(this).setMessage(getContext().getString(2131100148)).setPositiveButton(getContext().getString(2131100149), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        SharedPreferences localSharedPreferences = CreateOrReplyConversationActivity.this.getPreferences(0);
                        paramAnonymousDialogInterface = "";
                        if (CreateOrReplyConversationActivity.this.IS_NEWCONVERSATION) {
                            String str1 = localSharedPreferences.getString(CreateOrReplyConversationActivity.this.forumStatus.getForumId() + "|conv_createConv_draft_subject", "");
                            paramAnonymousDialogInterface = localSharedPreferences.getString(CreateOrReplyConversationActivity.this.forumStatus.getForumId() + "|conv_createConv_draft_content", "");
                            String str2 = localSharedPreferences.getString(CreateOrReplyConversationActivity.this.forumStatus.getForumId() + "|conv_createConv_draft_msgto", "");
                            CreateOrReplyConversationActivity.this.msgsubject.setText(str1);
                            CreateOrReplyConversationActivity.this.msgcontent.setText(paramAnonymousDialogInterface);
                            CreateOrReplyConversationActivity.this.msgcontent.requestFocus();
                            CreateOrReplyConversationActivity.this.msgto.setText(str2);
                        }
                        if (CreateOrReplyConversationActivity.this.IS_REPLY) {
                            paramAnonymousDialogInterface = localSharedPreferences.getString(CreateOrReplyConversationActivity.this.forumStatus.getForumId() + "|conv_replyConv_draft_content", "");
                            CreateOrReplyConversationActivity.this.msgcontent.setText(paramAnonymousDialogInterface);
                            CreateOrReplyConversationActivity.this.msgcontent.requestFocus();
                        }
                        if (CreateOrReplyConversationActivity.this.IS_QUOTE) {
                            paramAnonymousDialogInterface = localSharedPreferences.getString(CreateOrReplyConversationActivity.this.forumStatus.getForumId() + "|conv_quoteConv_draft_content", "");
                            CreateOrReplyConversationActivity.this.msgcontent.setText(paramAnonymousDialogInterface);
                            CreateOrReplyConversationActivity.this.msgcontent.requestFocus();
                        }
                        try {
                            paramAnonymousInt = paramAnonymousDialogInterface.indexOf(SettingsFragment.getSingature(CreateOrReplyConversationActivity.this.getContext(), CreateOrReplyConversationActivity.this.forumStatus.getSigType(), CreateOrReplyConversationActivity.this.forumStatus));
                            if (paramAnonymousInt > 1) {
                                CreateOrReplyConversationActivity.this.msgcontent.setSelection(paramAnonymousInt - 2);
                                return;
                            }
                            CreateOrReplyConversationActivity.this.msgcontent.setSelection(paramAnonymousDialogInterface.length());
                            return;
                        } catch (Exception paramAnonymousDialogInterface) {
                        }
                    }
                }).setNegativeButton(getContext().getString(2131100150), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        if (CreateOrReplyConversationActivity.this.IS_NEWCONVERSATION) {
                            CreateOrReplyConversationActivity.this.clearCreateConvDraft();
                        }
                        if (CreateOrReplyConversationActivity.this.IS_REPLY) {
                            CreateOrReplyConversationActivity.this.clearReplyConvDraft();
                        }
                        if (CreateOrReplyConversationActivity.this.IS_QUOTE) {
                            CreateOrReplyConversationActivity.this.clearQuoteConvDraft();
                        }
                    }
                }).create();
            case 9:
                new AlertDialog.Builder(this).setTitle(getContext().getString(2131099804)).setAdapter(new AttachDialogHelperAdapter(getContext(), this.forumStatus), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        if (paramAnonymousInt == 0) {
                            if ((CreateOrReplyConversationActivity.this.forumStatus.tapatalkForum.isMedia_sharing()) || (CreateOrReplyConversationActivity.this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                                paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                                paramAnonymousDialogInterface.setType("image/*");
                                CreateOrReplyConversationActivity.this.startActivityForResult(paramAnonymousDialogInterface, 0);
                            }
                            return;
                        }
                        if ((CreateOrReplyConversationActivity.this.forumStatus.tapatalkForum.isMedia_sharing()) || (CreateOrReplyConversationActivity.this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                            paramAnonymousDialogInterface = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
                            Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                            CreateOrReplyConversationActivity.this.tempUri = Uri.fromFile(new File(paramAnonymousDialogInterface));
                            localIntent.putExtra("output", CreateOrReplyConversationActivity.this.tempUri);
                            localIntent.putExtra("android.intent.extra.videoQuality", 1);
                            CreateOrReplyConversationActivity.this.startActivityForResult(localIntent, 1);
                            return;
                        }
                        CreateOrReplyConversationActivity.this.getContext().showDialog(18);
                    }
                }).create();
            case 45:
                localObject = new ArrayList();
                ((ArrayList) localObject).add(getContext().getString(2131099773));
                ((ArrayList) localObject).add(getContext().getString(2131100068));
                String[] arrayOfString = (String[]) ((ArrayList) localObject).toArray(new String[((ArrayList) localObject).size()]);
                new AlertDialog.Builder(this).setItems(arrayOfString, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        paramAnonymousDialogInterface = (String) localObject.get(paramAnonymousInt);
                        if (paramAnonymousDialogInterface.equalsIgnoreCase(CreateOrReplyConversationActivity.this.getContext().getString(2131099773))) {
                        }
                        try {
                            CreateOrReplyConversationActivity.this.getContext().removeDialog(14);
                            new InsertContent(CreateOrReplyConversationActivity.this.msgcontent, 0);
                            do {
                                return;
                            }
                            while (!paramAnonymousDialogInterface.equalsIgnoreCase(CreateOrReplyConversationActivity.this.getContext().getString(2131100068)));
                            try {
                                CreateOrReplyConversationActivity.this.getContext().removeDialog(39);
                                new InsertContent(CreateOrReplyConversationActivity.this.msgcontent, 1);
                                return;
                            } catch (Exception paramAnonymousDialogInterface) {
                                for (; ; ) {
                                }
                            }
                        } catch (Exception paramAnonymousDialogInterface) {
                            for (; ; ) {
                            }
                        }
                    }
                }).create();
            case 14:
                localObject = (LinearLayout) LayoutInflater.from(this).inflate(2130903362, null);
                this.urlView = ((EditText) ((LinearLayout) localObject).getChildAt(0));
                this.urlView.requestFocus();
                new AlertDialog.Builder(this).setTitle(getContext().getString(2131099808)).setView((View) localObject).setCancelable(false).setPositiveButton(getContext().getString(2131099899), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        String str = CreateOrReplyConversationActivity.this.urlView.getText().toString();
                        if ((str != null) && (str.length() > 0)) {
                            paramAnonymousDialogInterface = CreateOrReplyConversationActivity.this.msgcontent.getText();
                            str = "[URL]" + str + "[/URL]";
                            paramAnonymousInt = str.length();
                            paramAnonymousDialogInterface.insert(CreateOrReplyConversationActivity.this.msgcontent.getSelectionStart(), str, 0, paramAnonymousInt);
                        }
                    }
                }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).create();
            case 39:
                localObject = (LinearLayout) LayoutInflater.from(this).inflate(2130903362, null);
                this.urlView = ((EditText) ((LinearLayout) localObject).getChildAt(0));
                this.urlView.requestFocus();
                new AlertDialog.Builder(this).setTitle(getContext().getString(2131100068)).setView((View) localObject).setCancelable(false).setPositiveButton(getContext().getString(2131099899), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        String str = CreateOrReplyConversationActivity.this.urlView.getText().toString();
                        if ((str != null) && (str.length() > 0)) {
                            paramAnonymousDialogInterface = CreateOrReplyConversationActivity.this.msgcontent.getText();
                            str = "[IMG]" + str + "[/IMG]";
                            paramAnonymousInt = str.length();
                            paramAnonymousDialogInterface.insert(CreateOrReplyConversationActivity.this.msgcontent.getSelectionStart(), str, 0, paramAnonymousInt);
                        }
                    }
                }).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).create();
            case 18:
                new AlertDialog.Builder(this).setMessage(getApplicationContext().getString(2131099951)).setPositiveButton(getContext().getText(2131099976).toString(), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).create();
        }
        final Object localObject = new AlertDialog.Builder(this).setView(this.mUploadAdapter.getView(false)).setNegativeButton(2131099974, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        if (((this.forumStatus.tapatalkForum.isMedia_sharing()) || (this.forumStatus.tapatalkForum.isSupportTkUpload())) && (!getResources().getBoolean(2131558402))) {
            ((AlertDialog.Builder) localObject).setPositiveButton(getContext().getString(2131100010), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (CreateOrReplyConversationActivity.this.getPreferences(0).getBoolean("dialogshow_notification", true)) {
                        CreateOrReplyConversationActivity.this.getContext().showDialog(2);
                        paramAnonymousDialogInterface = CreateOrReplyConversationActivity.this.getPreferences(0).edit();
                        paramAnonymousDialogInterface.putBoolean("dialogshow_notification", false);
                        paramAnonymousDialogInterface.commit();
                        return;
                    }
                    CreateOrReplyConversationActivity.this.uploadToTk();
                }
            });
        }
        return ((AlertDialog.Builder) localObject).create();
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
            default:
            case 16908332:
            case 5:
                for (; ; ) {
                    return false;
                    showDialog(15);
                    if (this.submitButton != null) {
                        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.submitButton.getWindowToken(), 0);
                    }
                    return true;
                    submit();
                }
            case 4:
                if (!this.smileflag) {
                    this.footView.addView(this.smileView);
                    this.simle.setIcon(2130839071);
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.smileView.getApplicationWindowToken(), 2);
                }
                for (this.smileflag = true; ; this.smileflag = false) {
                    return true;
                    this.simle.setIcon(2130839092);
                    this.footView.removeView(this.smileView);
                    ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.smileView, 1);
                }
            case 8:
                new InsertContent(this.msgcontent, 0);
                return true;
            case 11:
                new InsertContent(this.msgcontent, 1);
                return true;
            case 3:
                this.upload_style = 3;
                if (this.forumStatus.isTapatalkSignIn(this)) {
                    getContext().showDialog(9);
                }
                for (; ; ) {
                    return true;
                    this.mUtil.showShouldSignInDialog();
                }
        }
        this.upload_style = 15;
        int i = this.forumStatus.getMaxAttachments();
        this.extensions = this.forumStatus.getAllowed_extensions();
        if (this.extensions != null) {
            if (this.npAdapter != null) {
                if (this.npAdapter.attachIds.size() < i) {
                    break label366;
                }
                Toast.makeText(this, getString(2131100916), 0).show();
            }
        }
        for (; ; ) {
            return true;
            label366:
            this.achInfo = new AttachmentInfo();
            Intent localIntent = new Intent();
            localIntent.addCategory("android.intent.category.OPENABLE");
            this.attachmentSize = this.forumStatus.getMax_attachment_size();
            paramMenuItem = null;
            new StringBuffer();
            if (this.extensions != null) {
                if (this.extensions.contains(",")) {
                    paramMenuItem = this.extensions.split(",");
                }
                this.uploadTypes = new String[paramMenuItem.length];
                i = 0;
                label456:
                if (i >= paramMenuItem.length) {
                    localIntent.setType("*/*");
                    if ((this.uploadTypes != null) && (this.uploadTypes.length != 0)) {
                        if (Build.VERSION.SDK_INT < 19) {
                            break label564;
                        }
                        localIntent.setAction("android.intent.action.OPEN_DOCUMENT");
                        localIntent.putExtra("android.intent.extra.MIME_TYPES", this.uploadTypes);
                    }
                }
                for (; ; ) {
                    try {
                        startActivityForResult(localIntent, 0);
                    } catch (Exception paramMenuItem) {
                        Toast.makeText(this, getString(2131100914), 0).show();
                    }
                    break;
                    this.uploadTypes[i] = this.achInfo.getUploadType(paramMenuItem[i]);
                    i += 1;
                    break label456;
                    label564:
                    localIntent.setAction("android.intent.action.GET_CONTENT");
                }
                showDialog(9);
            }
        }
    }

    public void onPause() {
        if (this.IS_NEWCONVERSATION) {
            if (this.IS_SAVE_CREATECONVERSATION_DRAFT) {
                saveCreateConvDraft();
            }
        } else {
            if (this.IS_REPLY) {
                if (!this.IS_SAVE_REPLYCONVERSATION_DRAFT) {
                    break label70;
                }
                saveReplyConvDraft();
            }
            label36:
            if (this.IS_QUOTE) {
                if (!this.IS_SAVE_QUOTECONVERSATION_DRAFT) {
                    break label77;
                }
                saveQuoteConvDraft();
            }
        }
        for (; ; ) {
            super.onPause();
            CustomTracker.comScorePause(this);
            return;
            clearCreateConvDraft();
            break;
            label70:
            clearReplyConvDraft();
            break label36;
            label77:
            clearQuoteConvDraft();
        }
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        if ((this.forumStatus != null) && (this.forumStatus.isCan_upload_attachment_conv())) {
            localMenuItem = paramMenu.add(0, 15, 0, getString(2131100700));
            localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_image", this));
            localMenuItem.setShowAsAction(0);
        }
        if ((this.forumStatus != null) && ((this.forumStatus.tapatalkForum.isMedia_sharing()) || (this.forumStatus.tapatalkForum.isSupportTkUpload())) && (!getApplication().getResources().getBoolean(2131558401))) {
            localMenuItem = paramMenu.add(0, 3, 0, getString(2131100698));
            localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_image", this));
            localMenuItem.setShowAsAction(0);
        }
        this.simle = paramMenu.add(0, 4, 0, getString(2131100438));
        this.simle.setIcon(ThemeUtil.getMenuIconByPicName("menu_smile", this));
        this.simle.setShowAsAction(0);
        MenuItem localMenuItem = paramMenu.add(0, 5, 0, getContext().getString(2131099972));
        localMenuItem.setIcon(ThemeUtil.getMenuIconByPicName("menu_send_title", this));
        localMenuItem.setShowAsAction(2);
        paramMenu.add(0, 8, 0, getString(2131099773)).setShowAsAction(0);
        paramMenu.add(0, 11, 0, getString(2131100068)).setShowAsAction(0);
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

    public void saveCreateConvDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.putString(this.forumStatus.getForumId() + "|conv_createConv_draft_content", this.msgcontent.getText().toString());
        localEditor.putString(this.forumStatus.getForumId() + "|conv_createConv_draft_subject", this.msgsubject.getText().toString());
        localEditor.putString(this.forumStatus.getForumId() + "|conv_createConv_draft_msgto", this.msgto.getText().toString());
        localEditor.commit();
    }

    public void saveQuoteConvDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.putString(this.forumStatus.getForumId() + "|conv_quoteConv_draft_content", this.msgcontent.getText().toString());
        localEditor.commit();
    }

    public void saveReplyConvDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.putString(this.forumStatus.getForumId() + "|conv_replyConv_draft_content", this.msgcontent.getText().toString());
        localEditor.commit();
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void showProgress() {
    }

    public void showProgress(String paramString) {
    }

    public void tryFailed(String paramString) {
    }

    public void updateAttachNumberText() {
        if (this.mAttachlay.getChildCount() > 0) {
            this.mAttachSectionTitle.setText(getString(2131099965, new Object[]{Integer.valueOf(this.mAttachlay.getChildCount()), Integer.valueOf(this.forumStatus.getMaxAttachments())}));
            if (this.mShouldShowContentClickHandler) {
                this.mContentClickHandler.setVisibility(8);
            }
        }
        do {
            return;
            this.mAttachSectionTitle.setVisibility(4);
        } while (!this.mShouldShowContentClickHandler);
        this.mContentClickHandler.setVisibility(0);
    }

    public void updateDialog(int paramInt) {
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateTitle() {
        getWindow().setFeatureInt(7, 2130903396);
        if (this.IS_NEWCONVERSATION) {
            ((TextView) getContext().findViewById(2131231664)).setText(getContext().getString(2131100164));
        }
        if (this.IS_REPLY) {
            ((TextView) getContext().findViewById(2131231664)).setText(getContext().getString(2131100165));
        }
        if (this.IS_QUOTE) {
            ((TextView) getContext().findViewById(2131231665)).setText(getContext().getString(2131100184));
        }
    }

    public void updateUI(int paramInt, Object paramObject) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateUI(String paramString) {
    }

    public void uploadAttachment() {
        int i = ExifUtil.getExif(this, this.photoUri);
        if ((this.mimeType != null) && (this.mimeType.contains("image/"))) {
            this.mUploadAdapter.setUri(this.photoUri, i);
        }
        for (; ; ) {
            showDialog(42);
            attachImage();
            return;
            this.mUploadAdapter.setUri2(this.photoUri, i);
        }
    }

    public void uploadToForum(ArrayList paramArrayList, Uri paramUri, int paramInt, String paramString) {
        try {
            this.mAttachSectionTitle = ((TextView) findViewById(2131231408));
            this.mAttachlay = ((LinearLayout) findViewById(2131231409));
            this.mContentClickHandler = findViewById(2131231406);
            paramArrayList = addAttachment(paramArrayList, paramUri, paramInt, paramString);
            this.mContentClickHandler.setVisibility(8);
            this.mAttachlay.addView(paramArrayList);
            this.mAttachSectionTitle.setVisibility(4);
            updateAttachNumberText();
            return;
        } catch (Exception paramArrayList) {
            paramArrayList.printStackTrace();
        }
    }

    public void uploadToTk() {
        getContext().removeDialog(42);
        showDialog(42);
        new AsyncTask() {
            protected ArrayList doInBackground(String... paramAnonymousVarArgs) {
                if (CreateOrReplyConversationActivity.this.npAdapter == null) {
                    CreateOrReplyConversationActivity.this.npAdapter = new NewPostAdapter(CreateOrReplyConversationActivity.this.getContext(), CreateOrReplyConversationActivity.this.forumStatus.getUrl());
                }
                paramAnonymousVarArgs = new ArrayList();
                int i = ExifUtil.getExif(CreateOrReplyConversationActivity.this.getContext(), CreateOrReplyConversationActivity.this.photoUri);
                if (CreateOrReplyConversationActivity.this.mUploadAdapter != null) {
                    CreateOrReplyConversationActivity.this.mUploadAdapter.setUri(CreateOrReplyConversationActivity.this.photoUri, i);
                    paramAnonymousVarArgs.add(CreateOrReplyConversationActivity.this.npAdapter.attachImage(CreateOrReplyConversationActivity.this.mUploadAdapter));
                }
                UserBehavior.logUserShareForum(CreateOrReplyConversationActivity.this.getContext());
                return paramAnonymousVarArgs;
            }

            protected void onPostExecute(ArrayList paramAnonymousArrayList) {
                try {
                    CreateOrReplyConversationActivity.this.getContext().dismissDialog(42);
                    Object localObject = UploadAttachmentTool.getUploadImageInfo((String) paramAnonymousArrayList.get(0));
                    if (((UploadImageInfo) localObject).getResult() == 1) {
                        if ((((UploadImageInfo) localObject).getUrl() != null) && (((UploadImageInfo) localObject).getUrl().length() > 0)) {
                            paramAnonymousArrayList = CreateOrReplyConversationActivity.this.msgcontent.getText();
                            localObject = "[IMG]" + ((UploadImageInfo) localObject).getUrl() + "[/IMG]";
                            int i = ((String) localObject).length();
                            paramAnonymousArrayList.insert(CreateOrReplyConversationActivity.this.msgcontent.getSelectionStart(), (CharSequence) localObject, 0, i);
                        }
                    } else if (((UploadImageInfo) localObject).getResult_text() != null) {
                        Toast.makeText(CreateOrReplyConversationActivity.this.getContext(), ((UploadImageInfo) localObject).getResult_text(), 1).show();
                        return;
                    }
                } catch (Exception paramAnonymousArrayList) {
                }
            }
        }.execute(new String[0]);
    }

    public void upload_forum(Uri paramUri, String paramString1, String paramString2) {
        this.npAdapter.attachIds.add(paramString1);
        this.npAdapter.groupId = paramString2;
        this.mSize = this.mUploadAdapter.mSize;
        if ((this.imageName == null) || (this.imageName.length() == 0)) {
            this.imageName = this.mUploadAdapter.imageName;
        }
        if ((this.mimeType == null) || (this.mimeType.length() == 0)) {
            this.mimeType = this.mUploadAdapter.mimeType;
        }
        uploadToForum(this.npAdapter.attachIds, paramUri, this.mSize, this.imageName);
    }

    public void upload_tapa(Intent paramIntent) {
        String str = paramIntent.getStringExtra("url");
        paramIntent = this.msgcontent.getText();
        str = "[IMG]" + str + "[/IMG]";
        int i = str.length();
        paramIntent.insert(this.msgcontent.getSelectionStart(), str, 0, i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/conversation/CreateOrReplyConversationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */