package com.quoord.tapatalkpro.activity.forum;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.emojikeyboard.EmoticonsGridAdapter.KeyClickListener;
import com.quoord.emojikeyboard.EmoticonsPagerAdapter;
import com.quoord.emojikeyboard.TabPageIndicator;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.CallBackChecker;
import com.quoord.tapatalkpro.action.RemoveAttach;
import com.quoord.tapatalkpro.adapter.TryTwiceCallBackInterface;
import com.quoord.tapatalkpro.adapter.forum.AttachDialogHelperAdapter;
import com.quoord.tapatalkpro.adapter.forum.CreateTopicActionbarAdapter;
import com.quoord.tapatalkpro.adapter.forum.NewPostAdapter;
import com.quoord.tapatalkpro.adapter.forum.UploadAdapter;
import com.quoord.tapatalkpro.bean.AttachmentInfo;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.UploadImageInfo;
import com.quoord.tapatalkpro.dev.DebugModeUtil;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.ics.tapatalkid.SignInWithOtherUtil;
import com.quoord.tapatalkpro.ui.SmileInputBuilder;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.CountdownTool;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.EmojiFilter;
import com.quoord.tapatalkpro.util.ExifUtil;
import com.quoord.tapatalkpro.util.GeoPictureUploader;
import com.quoord.tapatalkpro.util.InsertContent;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Quoter;
import com.quoord.tapatalkpro.util.Quoter.QuoterAnalyser;
import com.quoord.tapatalkpro.util.TapatalkEngine;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.UploadAttachmentTool;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;
import com.quoord.tools.uploadanddownload.UploadImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CreateTopicActivity
        extends Activity
        implements ForumActivityStatus, EmoticonsGridAdapter.KeyClickListener, TryTwiceCallBackInterface {
    public static final int CAMERA = 1;
    public static final int CAMERA_VIDEO = 10;
    public static final int GALLERY = 0;
    public static final int GALLERY_EDIT = 18;
    public static final int SUBMIT = 4;
    public static final int UPLOAD = 7;
    public static final int UPLOADATTACH = 21;
    public static final int UPLOADIMAGE = 20;
    public static final int UPLOAD_FORUM = 6;
    public static final int UPLOAD_TAPA = 5;
    private static ArrayList<String> recentEmoticons = new ArrayList();
    private AttachmentInfo achInfo;
    private String attachId;
    private int attachmentSize = 0;
    private boolean canUpload = false;
    private int countdownNumber;
    private CountdownTool countdownTool;
    private String edit_reason;
    private LinearLayout emoticonsCover;
    protected TapatalkEngine engine = null;
    private String extensions;
    private RelativeLayout footView;
    private TapatalkForum forum;
    private String forumId;
    private ForumStatus forumStatus;
    private String groupId = null;
    public String imageName;
    private boolean isKeyBoardVisible;
    private boolean isShare;
    private boolean isTapa = true;
    private int keyboardHeight;
    private CreateTopicActionbarAdapter mActionbarAdapter = null;
    private CreateTopicActivity mActivity;
    public NewPostAdapter mAdapter;
    private TextView mAttachSectionTitle;
    private LinearLayout mAttachlay;
    private EditText mContent;
    private View mContentClickHandler;
    private int mCurrentPrefixIndex = 0;
    private ImageButton mFooterEmojiBtn;
    private Bitmap mImage;
    private View.OnFocusChangeListener mOnFocusChangeHideEmojiListener;
    private View.OnTouchListener mOnTouchHideEmojiListener;
    private ArrayList<HashMap<String, String>> mPrefixes = null;
    ProgressDialog mProgressDialog = null;
    private EditText mQuoteHeadContent;
    private ArrayList<Quoter> mQuoterArray;
    private EditText mReason;
    private ScrollView mScrollwrap;
    private int mService;
    private boolean mShouldShowContentClickHandler;
    public int mSize;
    private EditText mSubject;
    private Handler mUIhandler;
    private UploadAdapter mUploadAdapter = null;
    private ProgressDialog mUploadProgressDialog = null;
    private LinearLayout main;
    public String mimeType;
    private int modifyType = -1;
    private LinearLayout parentLayout;
    private Uri photoUri;
    private View popUpView;
    private PopupWindow popupWindow;
    public int postStartTime;
    private String postid;
    int previousHeightDiffrence = 0;
    ProgressDialog progress;
    private String quickText = null;
    private int rotate = 0;
    private boolean saveDraft = true;
    private String shareTextTitle;
    private String shareType;
    private boolean show_reason;
    private CheckBox signatureTag;
    private GridView smileView;
    public boolean smileflag = false;
    private String strContent = "";
    String subjectTitle;
    MenuItem submitItem;
    private Uri tempUri;
    private String topicid;
    private boolean upload;
    private UploadAttachmentTool uploadAttachmentTool;
    private String[] uploadTypes = null;
    public int upload_style = 0;
    EditText urlView;
    private int vimeo_from;

    private View addAttachment(ArrayList paramArrayList, Uri paramUri, int paramInt, String paramString) {
        final AttachmentInfo localAttachmentInfo = new AttachmentInfo();
        localAttachmentInfo.size = paramInt;
        localAttachmentInfo.contentType = "image/jepg";
        localAttachmentInfo.name = paramString;
        localAttachmentInfo.attachmentId = paramArrayList.get(paramArrayList.size() - 1).toString();
        final RelativeLayout localRelativeLayout = (RelativeLayout) this.mActivity.getLayoutInflater().inflate(2130903418, this.mAttachlay, false);
        localRelativeLayout.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("attachment_bg", this.mActivity));
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
            paramArrayList.setImageDrawable(ThemeUtil.getDrawableByPicName("upload_attachment", this.mActivity));
            paramArrayList.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    new RemoveAttach(localAttachmentInfo.attachmentId, CreateTopicActivity.this.forumId, CreateTopicActivity.this.mAdapter.groupId, CreateTopicActivity.this.mAdapter.attachIds, CreateTopicActivity.this.mActivity, CreateTopicActivity.this.forumStatus, CreateTopicActivity.this.postid);
                    CreateTopicActivity.this.mAttachlay.removeView(localRelativeLayout);
                    CreateTopicActivity.this.updateAttachNumberText();
                    CreateTopicActivity.this.removeInline(localAttachmentInfo);
                }
            });
            return localRelativeLayout;
            localTextView2.setText(paramUri.toUpperCase());
        }
    }

    private void changeKeyboardHeight(int paramInt) {
        if (paramInt > 100) {
            this.keyboardHeight = paramInt;
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.keyboardHeight);
            this.emoticonsCover.setLayoutParams(localLayoutParams);
        }
    }

    private void checkKeyboardHeight(final View paramView) {
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect localRect = new Rect();
                paramView.getWindowVisibleDisplayFrame(localRect);
                int i = paramView.getRootView().getHeight() - localRect.bottom;
                if (CreateTopicActivity.this.previousHeightDiffrence - i > 50) {
                    CreateTopicActivity.this.popupWindow.dismiss();
                }
                CreateTopicActivity.this.previousHeightDiffrence = i;
                if (i > 100) {
                    CreateTopicActivity.this.isKeyBoardVisible = true;
                    CreateTopicActivity.this.changeKeyboardHeight(i);
                    return;
                }
                CreateTopicActivity.this.isKeyBoardVisible = false;
            }
        });
    }

    private void enablePopUpView() {
        ViewPager localViewPager = (ViewPager) this.popUpView.findViewById(2131231002);
        localViewPager.setOffscreenPageLimit(5);
        localViewPager.setAdapter(new EmoticonsPagerAdapter(this.mActivity, this, this.mService));
        TabPageIndicator localTabPageIndicator = (TabPageIndicator) this.popUpView.findViewById(2131231000);
        localTabPageIndicator.setViewPager(localViewPager);
        localTabPageIndicator.setService(this.mService);
        if (getSharedPreferences("EmojiPrefs", 0).getString("recent_emoticons", null) == null) {
            localTabPageIndicator.onPageSelected(1);
        }
        this.popupWindow = new PopupWindow(this.popUpView, -1, this.keyboardHeight, false);
        ((ImageView) this.popUpView.findViewById(2131231001)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6);
                CreateTopicActivity.this.mContent.dispatchKeyEvent(paramAnonymousView);
            }
        });
    }

    private void expandQuote(Quoter paramQuoter) {
        int i;
        String str;
        final EditText localEditText;
        if (paramQuoter.quoteTailContent == getCurrentFocus()) {
            i = 1;
            ((LinearLayout) findViewById(2131231435)).removeView(paramQuoter.quoteAreaLayout);
            int j = this.mQuoterArray.indexOf(paramQuoter);
            this.mQuoterArray.remove(paramQuoter);
            formatForSubmit(paramQuoter.quoteTailContent);
            str = "\n\n" + paramQuoter.originalString + "\n\n" + paramQuoter.quoteTailContent.getText().toString();
            if (j <= 0) {
                break label197;
            }
            localEditText = ((Quoter) this.mQuoterArray.get(j - 1)).quoteTailContent;
            label121:
            if (i == 0) {
                break label206;
            }
            i = paramQuoter.quoteTailContent.getText().length();
            j = paramQuoter.quoteTailContent.getSelectionStart();
            localEditText.append(str);
            localEditText.setSelection(localEditText.getText().length() - (i - j));
        }
        for (; ; ) {
            localEditText.postDelayed(new Runnable() {
                public void run() {
                    localEditText.requestFocus();
                }
            }, 50L);
            return;
            i = 0;
            break;
            label197:
            localEditText = this.mQuoteHeadContent;
            break label121;
            label206:
            if (localEditText == getCurrentFocus()) {
                i = localEditText.getSelectionStart();
                localEditText.append(str);
                localEditText.setSelection(i);
            } else {
                localEditText.append(str);
            }
        }
    }

    private String filterEmoji(String paramString) {
        return EmojiFilter.filterEmoji(paramString.replaceAll("\\[emoji*\\]", ""));
    }

    private void formatForSubmit(EditText paramEditText) {
        ImageSpan[] arrayOfImageSpan = (ImageSpan[]) paramEditText.getText().getSpans(0, paramEditText.getText().length(), ImageSpan.class);
        int i = 0;
        for (; ; ) {
            if (i >= arrayOfImageSpan.length) {
                return;
            }
            int j = paramEditText.getText().getSpanStart(arrayOfImageSpan[i]);
            int k = paramEditText.getText().getSpanEnd(arrayOfImageSpan[i]);
            String str = "[" + arrayOfImageSpan[i].getSource().substring(0, arrayOfImageSpan[i].getSource().indexOf(".")) + "]";
            paramEditText.getText().replace(j, k, str);
            i += 1;
        }
    }

    private String getAllContent() {
        formatForSubmit(this.mContent);
        formatForSubmit(this.mQuoteHeadContent);
        Iterator localIterator;
        if ((this.mQuoterArray != null) && (this.mQuoterArray.size() > 0)) {
            localIterator = this.mQuoterArray.iterator();
        }
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return (this.mContent.getText().toString() + getAllQuoteString()).replaceAll("\\[IMG\\]\\s(.*)?\\s\\[\\/IMG\\]", "\\[IMG\\]$1\\[\\/IMG\\]");
            }
            formatForSubmit(((Quoter) localIterator.next()).quoteTailContent);
        }
    }

    private String getAllQuoteString() {
        if (this.mQuoterArray == null) {
            return "";
        }
        StringBuffer localStringBuffer = new StringBuffer("");
        localStringBuffer.append(this.mQuoteHeadContent.getText().toString());
        Iterator localIterator = this.mQuoterArray.iterator();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return localStringBuffer.toString();
            }
            Quoter localQuoter = (Quoter) localIterator.next();
            if (localStringBuffer.length() > 0) {
                localStringBuffer.append("\n");
            }
            localStringBuffer.append(localQuoter.openingTagString);
            localStringBuffer.append(localQuoter.quoteContent.getText().toString());
            localStringBuffer.append(localQuoter.closingTagString);
            localStringBuffer.append("\n");
            localStringBuffer.append(localQuoter.quoteTailContent.getText().toString());
        }
    }

    private GridView getEmojiGridView() {
        SmileInputBuilder localSmileInputBuilder = new SmileInputBuilder(this);
        if (this.forumStatus.isIP()) {
            localSmileInputBuilder.setForumType(0);
        }
        for (; ; ) {
            localSmileInputBuilder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    String str = (String) CreateTopicActivity.this.smileView.getAdapter().getItem(paramAnonymousInt);
                    paramAnonymousView = CreateTopicActivity.this.getFocusView();
                    paramAnonymousAdapterView = paramAnonymousView;
                    if (paramAnonymousView == CreateTopicActivity.this.mSubject) {
                        paramAnonymousAdapterView = CreateTopicActivity.this.mContent;
                    }
                    paramAnonymousInt = paramAnonymousAdapterView.getSelectionStart();
                    paramAnonymousAdapterView.getText().insert(paramAnonymousInt, str);
                }
            });
            return localSmileInputBuilder.create();
            if ((this.forumStatus.isKN1()) || (this.forumStatus.isKN2()) || (this.forumStatus.isKN3())) {
                localSmileInputBuilder.setForumType(1);
            } else if (this.forumStatus.isMB()) {
                localSmileInputBuilder.setForumType(2);
            } else if (this.forumStatus.isPB()) {
                localSmileInputBuilder.setForumType(3);
            } else if (this.forumStatus.isSMF1()) {
                localSmileInputBuilder.setForumType(4);
            } else if (this.forumStatus.isSMF2()) {
                localSmileInputBuilder.setForumType(5);
            } else if (this.forumStatus.isXF()) {
                localSmileInputBuilder.setForumType(6);
            } else if (this.forumStatus.isVB3()) {
                localSmileInputBuilder.setForumType(10);
            } else if (this.forumStatus.isVB4()) {
                localSmileInputBuilder.setForumType(11);
            } else if (this.forumStatus.isVB5()) {
                localSmileInputBuilder.setForumType(12);
            } else if (TapatalkApp.rebranding_id.equals("81333")) {
                localSmileInputBuilder.setForumType(7);
            } else {
                localSmileInputBuilder.setForumType(7);
            }
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
            localObject = this.mContent;
        }
        return (EditText) localObject;
    }

    public static String getHost(String paramString) {
        try {
            String str = new URL(paramString).getHost();
            return str;
        } catch (MalformedURLException localMalformedURLException) {
            localMalformedURLException.printStackTrace();
        }
        return paramString;
    }

    private Bitmap getImage(String paramString) {
        int k = getResources().getIdentifier(paramString, "drawable", this.mActivity.getPackageName());
        paramString = new BitmapFactory.Options();
        paramString.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), k, paramString);
        int j = paramString.outWidth;
        int i = 1;
        for (; ; ) {
            if (j / 2 <= 48) {
                float f = 48 / j;
                paramString.inJustDecodeBounds = false;
                paramString.inDither = false;
                paramString.inSampleSize = i;
                paramString.inScaled = false;
                paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
                paramString = BitmapFactory.decodeResource(getResources(), k, paramString);
                Matrix localMatrix = new Matrix();
                localMatrix.postScale(f, f);
                return Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), localMatrix, true);
            }
            j /= 2;
            i *= 2;
        }
    }

    public static ArrayList<String> getRecentEmoticons() {
        return recentEmoticons;
    }

    private void hideEmojiKeyboard(View paramView) {
        if (this.forumStatus.isSupportEmoji()) {
            this.emoticonsCover.setVisibility(8);
            this.popupWindow.dismiss();
        }
        for (; ; ) {
            this.smileflag = false;
            this.mFooterEmojiBtn.setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_smiley", this.mActivity));
            return;
            if (this.footView.getChildAt(0) != null) {
                this.footView.removeView(this.smileView);
            }
        }
    }

    private void initEmojiKey() {
        this.parentLayout = ((LinearLayout) findViewById(2131231432));
        this.emoticonsCover = ((LinearLayout) findViewById(2131230773));
        this.popUpView = getLayoutInflater().inflate(2130903136, null);
        this.mService = 2;
        changeKeyboardHeight((int) getResources().getDimension(2131427340));
        enablePopUpView();
        checkKeyboardHeight(this.parentLayout);
    }

    private void initPrefix() {
        if ((this.mPrefixes == null) || (this.mPrefixes.size() == 0)) {
            return;
        }
        this.mActionbarAdapter = new CreateTopicActionbarAdapter(this.mActivity, this.mPrefixes);
        ActionBar localActionBar = this.mActivity.getActionBar();
        localActionBar.setDisplayShowTitleEnabled(false);
        localActionBar.setNavigationMode(1);
        localActionBar.setListNavigationCallbacks(this.mActionbarAdapter, new ActionBar.OnNavigationListener() {
            public boolean onNavigationItemSelected(int paramAnonymousInt, long paramAnonymousLong) {
                CreateTopicActivity.this.mCurrentPrefixIndex = paramAnonymousInt;
                CreateTopicActivity.this.mActivity.invalidateOptionsMenu();
                return true;
            }
        });
        localActionBar.setSelectedNavigationItem(this.mCurrentPrefixIndex);
    }

    private void initQuote() {
        if (!getIntent().hasExtra("quotecontent")) {
        }
        String str;
        do {
            return;
            str = getIntent().getStringExtra("quotecontent");
            localObject = this.forumStatus.tapatalkForum.getVersion();
        } while ((Util.isEmpty(str)) || (Util.isEmpty((String) localObject)));
        this.mQuoterArray = new Quoter.QuoterAnalyser(str, (String) localObject).quoters;
        Object localObject = (LinearLayout) findViewById(2131231435);
        if (this.mQuoterArray.size() == 0) {
            ((LinearLayout) localObject).setVisibility(8);
            this.mContent.setVisibility(0);
            this.mContent.setText(str);
            try {
                this.mContent.setSelection(str.length());
                return;
            } catch (Exception localException) {
                return;
            }
        }
        this.mShouldShowContentClickHandler = false;
        this.mContent.setVisibility(8);
        ((LinearLayout) localObject).setVisibility(0);
        this.mQuoteHeadContent.setOnTouchListener(this.mOnTouchHideEmojiListener);
        this.mQuoteHeadContent.setOnFocusChangeListener(this.mOnFocusChangeHideEmojiListener);
        this.mQuoteHeadContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                if (paramAnonymousBoolean) {
                    paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 18.0F), paramAnonymousView.getPaddingRight(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 22.0F));
                    localLayoutParams = (LinearLayout.LayoutParams) paramAnonymousView.getLayoutParams();
                    localLayoutParams.height = -2;
                    paramAnonymousView.setLayoutParams(localLayoutParams);
                }
                while (((EditText) paramAnonymousView).getText().length() != 0) {
                    return;
                }
                paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 0.0F), paramAnonymousView.getPaddingRight(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 0.0F));
                LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams) paramAnonymousView.getLayoutParams();
                localLayoutParams.height = Util.getPxFromDip(CreateTopicActivity.this.mActivity, 30.0F);
                paramAnonymousView.setLayoutParams(localLayoutParams);
            }
        });
        int i = 0;
        for (; ; ) {
            if (i >= this.mQuoterArray.size()) {
                if (this.mQuoterArray.size() <= 0) {
                    break;
                }
                final EditText localEditText = ((Quoter) this.mQuoterArray.get(0)).quoteTailContent;
                localEditText.postDelayed(new Runnable() {
                    public void run() {
                        localEditText.requestFocus();
                    }
                }, 50L);
                return;
            }
            setQuoteAreaView(i);
            ((LinearLayout) localObject).addView(((Quoter) this.mQuoterArray.get(i)).quoteAreaLayout);
            i += 1;
        }
    }

    private void initTheme() {
        View localView = findViewById(2131231438);
        if (SettingsFragment.isLightTheme(this)) {
            localView.setBackgroundColor(-328966);
        }
        for (; ; ) {
            ((ImageButton) findViewById(2131231439)).setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footer_videooandphoto", this.mActivity));
            ((ImageButton) findViewById(2131231440)).setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_vimeo", this.mActivity));
            ((ImageButton) findViewById(2131231443)).setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_img", this.mActivity));
            ((ImageButton) findViewById(2131231442)).setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_smiley", this.mActivity));
            ((ImageButton) findViewById(2131231441)).setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_attachment", this.mActivity));
            ((ImageButton) findViewById(2131231444)).setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_url", this.mActivity));
            return;
            localView.setBackgroundColor(-12566206);
        }
    }

    private boolean isContainEmoji(String paramString) {
        if (EmojiFilter.containsEmoji(paramString)) {
        }
        while (paramString.contains("[emoji")) {
            return true;
        }
        return false;
    }

    private boolean removeAttachBBCode(AttachmentInfo paramAttachmentInfo, EditText paramEditText, boolean paramBoolean) {
        if (paramEditText.getVisibility() == 8) {
        }
        for (; ; ) {
            return false;
            if (paramBoolean) {
                formatForSubmit(paramEditText);
            }
            String str2 = paramEditText.getText().toString();
            if (str2.length() != 0) {
                int j = paramEditText.getSelectionStart();
                String str1;
                if (this.forumStatus.isVB()) {
                    str1 = str2.replace("[ATTACH]" + paramAttachmentInfo.attachmentId + "[/ATTACH]", "");
                }
                while (str1.length() != paramEditText.getText().length()) {
                    if (paramBoolean) {
                        paramEditText.setText(str1);
                        int i = j;
                        if (str1.length() < j) {
                            i = str1.length();
                        }
                        paramEditText.setSelection(i);
                    }
                    return true;
                    str1 = str2;
                    if (!this.forumStatus.isPB()) {
                        if (this.forumStatus.isIP()) {
                            str1 = str2.replace("[attachment=" + paramAttachmentInfo.attachmentId + ":" + paramAttachmentInfo.name + "]", "");
                        } else if (this.forumStatus.isXF()) {
                            str1 = str2.replace("[ATTACH]" + paramAttachmentInfo.attachmentId + "[/ATTACH]", "").replace("[ATTACH=full]" + paramAttachmentInfo.attachmentId + "[/ATTACH]", "");
                        } else if (this.forumStatus.isMB()) {
                            str1 = str2.replace("[attachment=" + paramAttachmentInfo.attachmentId + "]", "");
                        } else if (!this.forumStatus.isKN2()) {
                            str1 = str2;
                            if (!this.forumStatus.isKN1()) {
                            }
                        } else {
                            str1 = str2.replace("[attachment=" + paramAttachmentInfo.attachmentId + "]" + paramAttachmentInfo.name + "[/attachment]", "");
                        }
                    }
                }
            }
        }
    }

    private void setEmojiKeyboardLayout() {
        if (getResources().getConfiguration().orientation == 2) {
            this.smileView.setColumnWidth(9);
        }
        for (; ; ) {
            this.smileView.setLayoutParams(new RelativeLayout.LayoutParams(-1, 300));
            return;
            if (getResources().getConfiguration().orientation == 1) {
                this.smileView.setColumnWidth(6);
            }
        }
    }

    private void setQuoteAreaView(int paramInt) {
        Object localObject = (RelativeLayout) this.mActivity.getLayoutInflater().inflate(2130903290, null);
        Quoter localQuoter = (Quoter) this.mQuoterArray.get(paramInt);
        localQuoter.quoteTitle = ((TextView) ((RelativeLayout) localObject).findViewById(2131231448));
        localQuoter.quoteTitle.setText(localQuoter.authorString + ":");
        localQuoter.quoteContent = ((TextView) ((RelativeLayout) localObject).findViewById(2131231447));
        localQuoter.quoteContent.setText(localQuoter.contentString);
        localQuoter.quoteArrow = ((ImageView) ((RelativeLayout) localObject).findViewById(2131231450));
        localQuoter.quoteAreaLayout = ((View) localObject);
        localQuoter.quoteTailContent = ((EditText) ((RelativeLayout) localObject).findViewById(2131231451));
        localObject = new QuoteInitializer(null);
        ((QuoteInitializer) localObject).q = localQuoter;
        new Handler().postDelayed((Runnable) localObject, 50L);
    }

    private void showEmojiKeyboard(View paramView) {
        if (this.forumStatus.isSupportEmoji()) {
            if (!this.popupWindow.isShowing()) {
                this.popupWindow.setHeight(this.keyboardHeight);
                if (!this.isKeyBoardVisible) {
                    break label85;
                }
                this.emoticonsCover.setVisibility(8);
                this.popupWindow.showAtLocation(this.parentLayout, 80, 0, 0);
            }
        }
        for (this.smileflag = true; ; this.smileflag = true) {
            this.mFooterEmojiBtn.setImageDrawable(ThemeUtil.getDrawableByPicName("newtopic_footbar_keyboard", this.mActivity));
            return;
            label85:
            this.emoticonsCover.setVisibility(0);
            break;
            Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
            if (this.footView.getChildAt(0) == null) {
                this.footView.addView(this.smileView);
            }
        }
    }

    public String attachImage(UploadAdapter paramUploadAdapter) {
        return new GeoPictureUploader(this.forumStatus.getForumId(), Util.getMD5(Util.getMacAddress(this.mActivity)), this.mActivity).uploadPicture(paramUploadAdapter, this.forumStatus.tapatalkForum.getUserName(), this.forumStatus.getUserId(), Util.getMD5(Util.getMacAddress(this.mActivity)), this.forumStatus.getForumId());
    }

    public void attachImage() {
        setTryTwice(false);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.forumId);
        localArrayList.add("");
        localArrayList.add(this.mUploadAdapter);
        if (this.groupId != null) {
            localArrayList.add(this.groupId);
        }
        localArrayList.add("post");
        if (this.imageName != null) {
            localArrayList.add(this.imageName);
            localArrayList.add(this.mimeType);
        }
        this.engine.call("upload_attachment_x", localArrayList);
    }

    public String attachImage2() {
        return new GeoPictureUploader(this.forumStatus.getForumId(), Util.getMD5(Util.getMacAddress(this.mActivity)), this.mActivity).uploadPicture(this.mUploadAdapter, this.forumStatus.tapatalkForum.getUserName(), this.forumStatus.getUserId(), Util.getMD5(Util.getMacAddress(this.mActivity)), this.forumStatus.getForumId());
    }

    public void callBack(EngineResponse paramEngineResponse) {
        if ((CallBackChecker.checkCallBack(paramEngineResponse, this.mActivity, this.forumStatus, this.engine, isOpCancel(), this)) && (paramEngineResponse.getMethod().endsWith("upload_attachment_x"))) {
            try {
                this.mUploadAdapter.closeByteStream();
                HashMap localHashMap = (HashMap) paramEngineResponse.getResponse();
                String str1;
                label170:
                boolean bool;
                String str2;
                return;
            } catch (Exception localException1) {
                try {
                    this.mActivity.dismissDialog(42);
                    if (paramEngineResponse.isSuccess()) {
                        if ((!localHashMap.containsKey("result")) || (!((Boolean) localHashMap.get("result")).booleanValue())) {
                            break label170;
                        }
                        str1 = "";
                        if (localHashMap.containsKey("attachment_id")) {
                            str1 = (String) localHashMap.get("attachment_id");
                        }
                        if (localHashMap.containsKey("group_id")) {
                            this.groupId = ((String) localHashMap.get("group_id"));
                        }
                        upload_forum(this.photoUri, str1, this.groupId);
                    }
                    for (; ; ) {
                        this.progress.dismiss();
                        return;
                        str1 = "";
                        bool = localHashMap.containsKey("result_text");
                        if (bool) {
                        }
                        try {
                            str1 = new String((byte[]) localHashMap.get("result_text"), "UTF-8");
                            Toast.makeText(this.mActivity, str1, 1).show();
                            continue;
                            localException1 = localException1;
                            localException1.printStackTrace();
                            if ((paramEngineResponse.getResponse() instanceof String)) {
                                Toast.makeText(this.mActivity, paramEngineResponse.getResponse().toString(), 1).show();
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

    public void clearDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        localEditor.remove(this.forumStatus.getForumId() + "|draft_content");
        localEditor.remove(this.forumStatus.getForumId() + "|draft_subject");
        localEditor.commit();
    }

    public void closeProgress() {
        try {
            this.mActivity.dismissDialog(0);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void getCountDownNumber() {
        int i = 0;
        if (this.forumStatus != null) {
            i = this.forumStatus.getPost_countdown();
        }
        if (i != 0) {
            if (this.countdownTool == null) {
                this.countdownTool = new CountdownTool(this, this.submitItem);
            }
            long l1 = Prefs.get(this).getLong("post_countdown_quite_time|" + this.forumStatus.getForumId(), System.currentTimeMillis());
            long l2 = System.currentTimeMillis();
            i = Prefs.get(this).getInt("post_countdown_number|" + this.forumStatus.getForumId(), 0);
            int j = (int) ((l2 - l1) / 1000L);
            if (j < i) {
                this.countdownNumber = (i - j);
            }
        }
    }

    public Activity getDefaultActivity() {
        return this;
    }

    /* Error */
    public void getFileInfo() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 345	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:photoUri	Landroid/net/Uri;
        //   4: ifnull +83 -> 87
        //   7: aload_0
        //   8: aload_0
        //   9: getfield 345	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:photoUri	Landroid/net/Uri;
        //   12: iconst_3
        //   13: anewarray 467	java/lang/String
        //   16: dup
        //   17: iconst_0
        //   18: ldc_w 1374
        //   21: aastore
        //   22: dup
        //   23: iconst_1
        //   24: ldc_w 1376
        //   27: aastore
        //   28: dup
        //   29: iconst_2
        //   30: ldc_w 1378
        //   33: aastore
        //   34: aconst_null
        //   35: aconst_null
        //   36: aconst_null
        //   37: invokevirtual 1382	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:managedQuery	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   40: astore_2
        //   41: aload_2
        //   42: ifnull +46 -> 88
        //   45: aload_2
        //   46: invokeinterface 1387 1 0
        //   51: ifeq +37 -> 88
        //   54: aload_0
        //   55: aload_2
        //   56: iconst_0
        //   57: invokeinterface 1389 2 0
        //   62: putfield 463	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:mimeType	Ljava/lang/String;
        //   65: aload_0
        //   66: aload_2
        //   67: iconst_1
        //   68: invokeinterface 1389 2 0
        //   73: putfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   76: aload_0
        //   77: aload_2
        //   78: iconst_2
        //   79: invokeinterface 1391 2 0
        //   84: putfield 1393	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:mSize	I
        //   87: return
        //   88: aconst_null
        //   89: astore 5
        //   91: aconst_null
        //   92: astore 6
        //   94: aconst_null
        //   95: astore 4
        //   97: aload 6
        //   99: astore_2
        //   100: aload_0
        //   101: aload_0
        //   102: getfield 345	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:photoUri	Landroid/net/Uri;
        //   105: invokevirtual 1396	android/net/Uri:toString	()Ljava/lang/String;
        //   108: putfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   111: aload 6
        //   113: astore_2
        //   114: aload_0
        //   115: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   118: ldc_w 722
        //   121: invokevirtual 471	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   124: ifeq +44 -> 168
        //   127: aload 6
        //   129: astore_2
        //   130: aload_0
        //   131: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   134: bipush 46
        //   136: invokevirtual 489	java/lang/String:lastIndexOf	(I)I
        //   139: istore_1
        //   140: iload_1
        //   141: iflt +27 -> 168
        //   144: aload 6
        //   146: astore_2
        //   147: aload_0
        //   148: aload_0
        //   149: getfield 308	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:achInfo	Lcom/quoord/tapatalkpro/bean/AttachmentInfo;
        //   152: aload_0
        //   153: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   156: iload_1
        //   157: iconst_1
        //   158: iadd
        //   159: invokevirtual 496	java/lang/String:substring	(I)Ljava/lang/String;
        //   162: invokevirtual 1399	com/quoord/tapatalkpro/bean/AttachmentInfo:getUploadType	(Ljava/lang/String;)Ljava/lang/String;
        //   165: putfield 463	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:mimeType	Ljava/lang/String;
        //   168: aload 6
        //   170: astore_2
        //   171: new 502	java/lang/StringBuilder
        //   174: dup
        //   175: invokespecial 1400	java/lang/StringBuilder:<init>	()V
        //   178: invokestatic 1406	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   181: invokevirtual 1409	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   184: ldc_w 1411
        //   187: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: invokevirtual 525	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   193: astore_3
        //   194: aload 6
        //   196: astore_2
        //   197: aload_0
        //   198: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   201: aload_3
        //   202: invokevirtual 471	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   205: ifeq +130 -> 335
        //   208: aload 6
        //   210: astore_2
        //   211: aload_0
        //   212: aload_0
        //   213: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   216: aload_3
        //   217: invokevirtual 1415	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   220: iconst_1
        //   221: aaload
        //   222: putfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   225: aload 6
        //   227: astore_2
        //   228: new 1417	java/io/File
        //   231: dup
        //   232: new 502	java/lang/StringBuilder
        //   235: dup
        //   236: aload_3
        //   237: invokestatic 512	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   240: invokespecial 515	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   243: aload_0
        //   244: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   247: invokevirtual 521	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   250: invokevirtual 525	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   253: invokespecial 1418	java/io/File:<init>	(Ljava/lang/String;)V
        //   256: astore_3
        //   257: aload 6
        //   259: astore_2
        //   260: aload_0
        //   261: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   264: ldc_w 1411
        //   267: invokevirtual 471	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   270: ifeq +34 -> 304
        //   273: aload 6
        //   275: astore_2
        //   276: aload_0
        //   277: aload_0
        //   278: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   281: ldc_w 1420
        //   284: invokevirtual 1415	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   287: aload_0
        //   288: getfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   291: ldc_w 1420
        //   294: invokevirtual 1415	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   297: arraylength
        //   298: iconst_1
        //   299: isub
        //   300: aaload
        //   301: putfield 1211	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:imageName	Ljava/lang/String;
        //   304: aload 6
        //   306: astore_2
        //   307: new 1422	java/io/FileInputStream
        //   310: dup
        //   311: aload_3
        //   312: invokespecial 1425	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   315: astore_3
        //   316: aload_0
        //   317: aload_3
        //   318: invokevirtual 1428	java/io/FileInputStream:available	()I
        //   321: putfield 1393	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:mSize	I
        //   324: aload_3
        //   325: invokevirtual 1431	java/io/FileInputStream:close	()V
        //   328: return
        //   329: astore_2
        //   330: aload_2
        //   331: invokevirtual 1432	java/io/IOException:printStackTrace	()V
        //   334: return
        //   335: aload 6
        //   337: astore_2
        //   338: new 1417	java/io/File
        //   341: dup
        //   342: aload_0
        //   343: getfield 345	com/quoord/tapatalkpro/activity/forum/CreateTopicActivity:photoUri	Landroid/net/Uri;
        //   346: invokevirtual 1396	android/net/Uri:toString	()Ljava/lang/String;
        //   349: invokespecial 1418	java/io/File:<init>	(Ljava/lang/String;)V
        //   352: astore_3
        //   353: goto -96 -> 257
        //   356: astore_2
        //   357: aload 4
        //   359: astore_3
        //   360: aload_2
        //   361: astore 4
        //   363: aload_3
        //   364: astore_2
        //   365: aload 4
        //   367: invokevirtual 1433	java/io/FileNotFoundException:printStackTrace	()V
        //   370: aload_3
        //   371: invokevirtual 1431	java/io/FileInputStream:close	()V
        //   374: return
        //   375: astore_2
        //   376: aload_2
        //   377: invokevirtual 1432	java/io/IOException:printStackTrace	()V
        //   380: return
        //   381: astore 4
        //   383: aload 5
        //   385: astore_3
        //   386: aload_3
        //   387: astore_2
        //   388: aload 4
        //   390: invokevirtual 1432	java/io/IOException:printStackTrace	()V
        //   393: aload_3
        //   394: invokevirtual 1431	java/io/FileInputStream:close	()V
        //   397: return
        //   398: astore_2
        //   399: aload_2
        //   400: invokevirtual 1432	java/io/IOException:printStackTrace	()V
        //   403: return
        //   404: astore 4
        //   406: aload_2
        //   407: astore_3
        //   408: aload 4
        //   410: astore_2
        //   411: aload_3
        //   412: invokevirtual 1431	java/io/FileInputStream:close	()V
        //   415: aload_2
        //   416: athrow
        //   417: astore_3
        //   418: aload_3
        //   419: invokevirtual 1432	java/io/IOException:printStackTrace	()V
        //   422: goto -7 -> 415
        //   425: astore_2
        //   426: goto -15 -> 411
        //   429: astore 4
        //   431: goto -45 -> 386
        //   434: astore 4
        //   436: goto -73 -> 363
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	439	0	this	CreateTopicActivity
        //   139	20	1	i	int
        //   40	267	2	localObject1	Object
        //   329	2	2	localIOException1	IOException
        //   337	1	2	localObject2	Object
        //   356	5	2	localFileNotFoundException1	FileNotFoundException
        //   364	1	2	localObject3	Object
        //   375	2	2	localIOException2	IOException
        //   387	1	2	localObject4	Object
        //   398	9	2	localIOException3	IOException
        //   410	6	2	localObject5	Object
        //   425	1	2	localObject6	Object
        //   193	219	3	localObject7	Object
        //   417	2	3	localIOException4	IOException
        //   95	271	4	localFileNotFoundException2	FileNotFoundException
        //   381	8	4	localIOException5	IOException
        //   404	5	4	localObject8	Object
        //   429	1	4	localIOException6	IOException
        //   434	1	4	localFileNotFoundException3	FileNotFoundException
        //   89	295	5	localObject9	Object
        //   92	244	6	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   324	328	329	java/io/IOException
        //   100	111	356	java/io/FileNotFoundException
        //   114	127	356	java/io/FileNotFoundException
        //   130	140	356	java/io/FileNotFoundException
        //   147	168	356	java/io/FileNotFoundException
        //   171	194	356	java/io/FileNotFoundException
        //   197	208	356	java/io/FileNotFoundException
        //   211	225	356	java/io/FileNotFoundException
        //   228	257	356	java/io/FileNotFoundException
        //   260	273	356	java/io/FileNotFoundException
        //   276	304	356	java/io/FileNotFoundException
        //   307	316	356	java/io/FileNotFoundException
        //   338	353	356	java/io/FileNotFoundException
        //   370	374	375	java/io/IOException
        //   100	111	381	java/io/IOException
        //   114	127	381	java/io/IOException
        //   130	140	381	java/io/IOException
        //   147	168	381	java/io/IOException
        //   171	194	381	java/io/IOException
        //   197	208	381	java/io/IOException
        //   211	225	381	java/io/IOException
        //   228	257	381	java/io/IOException
        //   260	273	381	java/io/IOException
        //   276	304	381	java/io/IOException
        //   307	316	381	java/io/IOException
        //   338	353	381	java/io/IOException
        //   393	397	398	java/io/IOException
        //   100	111	404	finally
        //   114	127	404	finally
        //   130	140	404	finally
        //   147	168	404	finally
        //   171	194	404	finally
        //   197	208	404	finally
        //   211	225	404	finally
        //   228	257	404	finally
        //   260	273	404	finally
        //   276	304	404	finally
        //   307	316	404	finally
        //   338	353	404	finally
        //   365	370	404	finally
        //   388	393	404	finally
        //   411	415	417	java/io/IOException
        //   316	324	425	finally
        //   316	324	429	java/io/IOException
        //   316	324	434	java/io/FileNotFoundException
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

    public void getImage(int paramInt) {
        if (this.photoUri != null) {
            Cursor localCursor = this.mActivity.managedQuery(this.photoUri, new String[]{"mime_type", "_display_name", "_size"}, null, null, null);
            if ((localCursor != null) && (localCursor.moveToFirst())) {
                this.mimeType = localCursor.getString(0);
                this.imageName = localCursor.getString(1);
                this.mSize = localCursor.getInt(2);
                if ((this.mSize == 0) && (paramInt == 1)) {
                    this.mSize = ((int) new File(UploadImage.SD_CARD_TEMP_DIR).length());
                }
            }
        }
    }

    public boolean getSaxCall() {
        return false;
    }

    public Bitmap getThumbnail(Uri paramUri, int paramInt) {
        localObject1 = null;
        try {
            localObject2 = this.mActivity.getContentResolver().openInputStream(paramUri);
            localObject1 = localObject2;
        } catch (FileNotFoundException localFileNotFoundException) {
            try {
                Object localObject2;
                ((InputStream) localObject1).close();
                try {
                    paramUri = this.mActivity.getContentResolver().openInputStream(paramUri);
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
                    break label112;
                }
                paramInt = i;
                paramUri.inSampleSize = ((int) Math.sqrt(paramInt) + 1);
                this.mImage = BitmapFactory.decodeStream((InputStream) localObject1, null, paramUri);
                paramInt = this.mImage.getWidth();
                i = this.mImage.getHeight();
                paramUri = new Matrix();
                paramUri.postScale(Util.getPxFromDip(this.mActivity, 62.0F) / paramInt, Util.getPxFromDip(this.mActivity, 62.0F) / i);
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
        if (localEditText2 == this.mSubject) {
            localEditText1 = this.mContent;
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

    public void initFooterToolbar() {
        ImageButton localImageButton;
        if (!getResources().getBoolean(2131558401)) {
            if (!this.forumStatus.tapatalkForum.isMedia_sharing()) {
                break label217;
            }
            localImageButton = (ImageButton) findViewById(2131231439);
            localImageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    CreateTopicActivity.this.upload_style = 20;
                    CreateTopicActivity.this.uploadAttachmentTool.getVideoAndPhoto();
                }
            });
            localImageButton.setVisibility(0);
        }
        for (; ; ) {
            if (this.forumStatus.tapatalkForum.isMedia_sharing()) {
                ((ImageButton) findViewById(2131231440)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        paramAnonymousView = new SignInWithOtherUtil(CreateTopicActivity.this.mActivity);
                        if (CreateTopicActivity.this.forumStatus.isTapatalkSignIn(CreateTopicActivity.this.mActivity)) {
                            CreateTopicActivity.this.upload_style = 20;
                            CreateTopicActivity.this.uploadAttachmentTool.getVimeoFile();
                            return;
                        }
                        paramAnonymousView.showShouldSignInDialog();
                    }
                });
            }
            localImageButton = (ImageButton) findViewById(2131231443);
            localImageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    EditText localEditText = CreateTopicActivity.this.getFocusView();
                    paramAnonymousView = localEditText;
                    if (localEditText == CreateTopicActivity.this.mSubject) {
                        paramAnonymousView = CreateTopicActivity.this.mContent;
                    }
                    new InsertContent(paramAnonymousView, 1);
                }
            });
            localImageButton.setVisibility(0);
            if (this.canUpload) {
                localImageButton = (ImageButton) findViewById(2131231441);
                localImageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        int i = CreateTopicActivity.this.forumStatus.getMaxAttachments();
                        CreateTopicActivity.this.extensions = CreateTopicActivity.this.forumStatus.getAllowed_extensions();
                        CreateTopicActivity.this.upload_style = 21;
                        if (CreateTopicActivity.this.extensions != null) {
                            if (CreateTopicActivity.this.mAdapter != null) {
                                if (CreateTopicActivity.this.mAdapter.attachIds.size() >= i) {
                                    Toast.makeText(CreateTopicActivity.this, CreateTopicActivity.this.getString(2131100916), 0).show();
                                }
                            } else {
                                return;
                            }
                            CreateTopicActivity.this.achInfo = new AttachmentInfo();
                            Intent localIntent = new Intent();
                            localIntent.addCategory("android.intent.category.OPENABLE");
                            CreateTopicActivity.this.attachmentSize = CreateTopicActivity.this.forumStatus.getMax_attachment_size();
                            paramAnonymousView = null;
                            new StringBuffer();
                            if (CreateTopicActivity.this.extensions != null) {
                                if (CreateTopicActivity.this.extensions.contains(",")) {
                                    paramAnonymousView = CreateTopicActivity.this.extensions.split(",");
                                }
                                CreateTopicActivity.this.uploadTypes = new String[paramAnonymousView.length];
                                i = 0;
                                if (i < paramAnonymousView.length) {
                                }
                            } else {
                                localIntent.setType("*/*");
                                if ((CreateTopicActivity.this.uploadTypes != null) && (CreateTopicActivity.this.uploadTypes.length != 0)) {
                                    if (Build.VERSION.SDK_INT < 19) {
                                        break label327;
                                    }
                                    localIntent.setAction("android.intent.action.OPEN_DOCUMENT");
                                    localIntent.putExtra("android.intent.extra.MIME_TYPES", CreateTopicActivity.this.uploadTypes);
                                }
                            }
                            for (; ; ) {
                                try {
                                    CreateTopicActivity.this.startActivityForResult(localIntent, 0);
                                    return;
                                } catch (Exception paramAnonymousView) {
                                    Toast.makeText(CreateTopicActivity.this, CreateTopicActivity.this.getString(2131100914), 0).show();
                                    return;
                                }
                                CreateTopicActivity.this.uploadTypes[i] = CreateTopicActivity.this.achInfo.getUploadType(paramAnonymousView[i]);
                                i += 1;
                                break;
                                label327:
                                localIntent.setAction("android.intent.action.GET_CONTENT");
                            }
                        }
                        CreateTopicActivity.this.mActivity.showDialog(9);
                    }
                });
                localImageButton.setVisibility(0);
            }
            this.mFooterEmojiBtn = ((ImageButton) findViewById(2131231442));
            this.mFooterEmojiBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (!CreateTopicActivity.this.smileflag) {
                        CreateTopicActivity.this.showEmojiKeyboard(paramAnonymousView);
                        return;
                    }
                    CreateTopicActivity.this.hideEmojiKeyboard(paramAnonymousView);
                    ((InputMethodManager) CreateTopicActivity.this.getSystemService("input_method")).showSoftInput(CreateTopicActivity.this.getFocusView(), 1);
                }
            });
            this.mFooterEmojiBtn.setVisibility(0);
            localImageButton = (ImageButton) findViewById(2131231444);
            localImageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    new InsertContent(CreateTopicActivity.this.getFocusView(), 0);
                }
            });
            localImageButton.setVisibility(0);
            return;
            label217:
            if (this.forumStatus.tapatalkForum.isSupportTkUpload()) {
                localImageButton = (ImageButton) findViewById(2131231439);
                localImageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        CreateTopicActivity.this.upload_style = 20;
                        CreateTopicActivity.this.mActivity.showDialog(9);
                    }
                });
                localImageButton.setVisibility(0);
            }
        }
    }

    public void initUplodvimeoEditText(String paramString) {
        EditText localEditText2 = getFocusView();
        EditText localEditText1 = localEditText2;
        if (localEditText2 == this.mSubject) {
            localEditText1 = this.mContent;
        }
        paramString = "[URL]https://vimeo.com/" + paramString + "[/URL]";
        localEditText1.getEditableText().insert(localEditText1.getSelectionStart(), paramString);
    }

    public void initialView() {
        setContentView(2130903289);
        this.smileView = getEmojiGridView();
        this.mOnTouchHideEmojiListener = new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                if (!CreateTopicActivity.this.forumStatus.isDefaultSmilies()) {
                }
                while ((paramAnonymousMotionEvent.getAction() != 0) || (!(paramAnonymousView instanceof EditText)) || (!paramAnonymousView.isFocused()) || (!CreateTopicActivity.this.smileflag)) {
                    return false;
                }
                CreateTopicActivity.this.hideEmojiKeyboard(paramAnonymousView);
                ((InputMethodManager) CreateTopicActivity.this.getSystemService("input_method")).showSoftInput(CreateTopicActivity.this.getFocusView(), 1);
                return false;
            }
        };
        this.mOnFocusChangeHideEmojiListener = new View.OnFocusChangeListener() {
            public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                if (!CreateTopicActivity.this.forumStatus.isDefaultSmilies()) {
                }
                while (!(paramAnonymousView instanceof EditText)) {
                    return;
                }
                if (!paramAnonymousBoolean) {
                    CreateTopicActivity.this.hideEmojiKeyboard(paramAnonymousView);
                    return;
                }
                if (!CreateTopicActivity.this.smileflag) {
                    ((InputMethodManager) CreateTopicActivity.this.getSystemService("input_method")).showSoftInput(paramAnonymousView, 1);
                    return;
                }
                Util.hideSoftKeyb(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.getCurrentFocus());
            }
        };
        this.mAttachlay = ((LinearLayout) findViewById(2131231420));
        this.mAttachSectionTitle = ((TextView) findViewById(2131231427));
        this.mContent = ((EditText) findViewById(2131231426));
        this.mSubject = ((EditText) findViewById(2131231425));
        this.mReason = ((EditText) findViewById(2131231433));
        this.mScrollwrap = ((ScrollView) findViewById(2131231423));
        this.footView = ((RelativeLayout) findViewById(2131231428));
        this.signatureTag = ((CheckBox) findViewById(2131231407));
        this.main = ((LinearLayout) findViewById(2131231432));
        this.mQuoteHeadContent = ((EditText) findViewById(2131231436));
        this.mContentClickHandler = findViewById(2131231406);
        this.mContentClickHandler.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                if (CreateTopicActivity.this.mContent.getVisibility() == 8) {
                    return false;
                }
                paramAnonymousView = MotionEvent.obtain(0L, 0L, paramAnonymousMotionEvent.getAction(), CreateTopicActivity.this.mContent.getX(), CreateTopicActivity.this.mContent.getY(), 0);
                CreateTopicActivity.this.mContent.dispatchTouchEvent(paramAnonymousView);
                CreateTopicActivity.this.mContent.setSelection(CreateTopicActivity.this.mContent.getEditableText().length());
                paramAnonymousView.recycle();
                return true;
            }
        });
        this.mShouldShowContentClickHandler = true;
        this.mSubject.setEnabled(true);
        this.mSubject.setSingleLine(true);
        this.show_reason = getIntent().getBooleanExtra("show_reason", false);
        Object localObject;
        if (this.modifyType == 40) {
            this.mSubject.setVisibility(8);
            this.mReason.setVisibility(0);
            localObject = (LinearLayout.LayoutParams) this.mContent.getLayoutParams();
            ((LinearLayout.LayoutParams) localObject).topMargin = Util.getPxFromDip(this.mActivity, 18.0F);
            this.mContent.setLayoutParams((ViewGroup.LayoutParams) localObject);
        }
        for (; ; ) {
            setEmojiKeyboardLayout();
            this.mContent.setOnFocusChangeListener(this.mOnFocusChangeHideEmojiListener);
            this.mContent.setOnTouchListener(this.mOnTouchHideEmojiListener);
            this.mSubject.setOnFocusChangeListener(this.mOnFocusChangeHideEmojiListener);
            this.mSubject.setOnTouchListener(this.mOnTouchHideEmojiListener);
            this.mSubject.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                    int j = 8;
                    paramAnonymousView = CreateTopicActivity.this.findViewById(2131231437);
                    if (paramAnonymousBoolean) {
                        i = 8;
                        paramAnonymousView.setVisibility(i);
                        paramAnonymousView = CreateTopicActivity.this.findViewById(2131231438);
                        if (!paramAnonymousBoolean) {
                            break label54;
                        }
                    }
                    label54:
                    for (int i = j; ; i = 0) {
                        paramAnonymousView.setVisibility(i);
                        return;
                        i = 0;
                        break;
                    }
                }
            });
            this.mReason.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                    int j = 8;
                    paramAnonymousView = CreateTopicActivity.this.findViewById(2131231437);
                    if (paramAnonymousBoolean) {
                        i = 8;
                        paramAnonymousView.setVisibility(i);
                        paramAnonymousView = CreateTopicActivity.this.findViewById(2131231438);
                        if (!paramAnonymousBoolean) {
                            break label54;
                        }
                    }
                    label54:
                    for (int i = j; ; i = 0) {
                        paramAnonymousView.setVisibility(i);
                        return;
                        i = 0;
                        break;
                    }
                }
            });
            if (this.quickText != null) {
                this.strContent += this.quickText;
            }
            if (this.modifyType == 40) {
                this.postid = getIntent().getStringExtra("postid");
                this.subjectTitle = getIntent().getStringExtra("posttitle");
                if (getIntent().hasExtra("postcontent")) {
                    this.strContent = (getIntent().getStringExtra("postcontent") + "\n");
                }
                if (!this.show_reason) {
                    this.mReason.setVisibility(8);
                    this.mSubject.setText(this.subjectTitle);
                    this.mSubject.setEnabled(true);
                    this.mContent.requestFocus();
                    findViewById(2131231434).setVisibility(8);
                    label551:
                    if (!Util.isEmpty(this.strContent)) {
                        this.mContent.setText(this.strContent);
                    }
                }
            }
            try {
                this.mContent.setSelection(this.strContent.length());
                initTheme();
                if ((this.mShouldShowContentClickHandler) && (this.mAttachlay.getChildCount() == 0)) {
                    this.mContentClickHandler.setVisibility(0);
                }
                return;
                if (this.modifyType != 38) {
                    continue;
                }
                this.mSubject.setVisibility(8);
                this.mReason.setVisibility(8);
                findViewById(2131231434).setVisibility(8);
                localObject = (LinearLayout.LayoutParams) this.mContent.getLayoutParams();
                ((LinearLayout.LayoutParams) localObject).topMargin = Util.getPxFromDip(this.mActivity, 18.0F);
                this.mContent.setLayoutParams((ViewGroup.LayoutParams) localObject);
                continue;
                this.mSubject.setText(this.subjectTitle);
                this.mReason.setEnabled(true);
                break label551;
                if (this.modifyType == 38) {
                    this.subjectTitle = getIntent().getStringExtra("posttitle");
                    this.mSubject.setText(this.mActivity.getString(2131099775) + " " + this.subjectTitle);
                    this.mSubject.setEnabled(true);
                    if (getIntent().hasExtra("quotecontent")) {
                        initQuote();
                    }
                }
                localObject = SettingsFragment.getSingature(this.mActivity, this.forumStatus.getSigType(), this.forumStatus);
                if ((!this.forumStatus.isSupportSignature()) || (localObject == null) || (((String) localObject).length() <= 0)) {
                    break label551;
                }
                this.mShouldShowContentClickHandler = false;
                this.signatureTag.setVisibility(0);
                this.signatureTag.setText((CharSequence) localObject);
                this.signatureTag.postDelayed(new Runnable() {
                    public void run() {
                        if (CreateTopicActivity.this.signatureTag.getLineCount() == 1) {
                            CreateTopicActivity.this.signatureTag.setPadding(CreateTopicActivity.this.signatureTag.getPaddingLeft(), CreateTopicActivity.this.signatureTag.getPaddingTop(), CreateTopicActivity.this.signatureTag.getPaddingRight(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 3.0F));
                        }
                        while (CreateTopicActivity.this.signatureTag.getLineCount() != 2) {
                            return;
                        }
                        CreateTopicActivity.this.signatureTag.setPadding(CreateTopicActivity.this.signatureTag.getPaddingLeft(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 14.0F), CreateTopicActivity.this.signatureTag.getPaddingRight(), CreateTopicActivity.this.signatureTag.getPaddingBottom());
                    }
                }, 50L);
            } catch (Exception localException) {
                for (; ; ) {
                }
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

    public void keyClickedIndex(final String paramString) {
        Object localObject = new Html.ImageGetter() {
            public Drawable getDrawable(String paramAnonymousString) {
                paramAnonymousString = new BitmapDrawable(CreateTopicActivity.this.getResources(), CreateTopicActivity.this.getImage(paramString));
                paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
                return paramAnonymousString;
            }
        };
        Spanned localSpanned = Html.fromHtml("<img src ='" + paramString + ".png'/> ", (Html.ImageGetter) localObject, null);
        EditText localEditText = getFocusView();
        localObject = localEditText;
        if (localEditText == this.mSubject) {
            localObject = this.mContent;
        }
        int i = ((EditText) localObject).getSelectionStart();
        ((EditText) localObject).getText().insert(i, localSpanned);
        if (this.mService == 2) {
            if (recentEmoticons.contains(paramString)) {
                recentEmoticons.remove(recentEmoticons.indexOf(paramString));
            }
            recentEmoticons.add(0, paramString);
            if (recentEmoticons.size() > 32) {
                recentEmoticons.remove(recentEmoticons.size() - 1);
            }
        }
        paramString = TextUtils.join("#", recentEmoticons);
        localObject = getSharedPreferences("EmojiPrefs", 0).edit();
        ((SharedPreferences.Editor) localObject).clear();
        ((SharedPreferences.Editor) localObject).putString("recent_emoticons", paramString);
        ((SharedPreferences.Editor) localObject).commit();
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 0) {
            if (paramInt2 == -1) {
                this.photoUri = paramIntent.getData();
                if (this.photoUri != null) {
                    getFileInfo();
                    startUpload(0);
                }
            }
        }
        do {
            do {
                do {
                    do {
                        do {
                            return;
                            if (paramInt2 == 5) {
                                upload_tapa(paramIntent);
                                return;
                            }
                        } while (paramInt2 != 6);
                        upload_forum(paramIntent);
                        return;
                        if (paramInt1 != 1) {
                            break;
                        }
                    } while (paramInt2 != -1);
                    paramIntent = new File(UploadImage.SD_CARD_TEMP_DIR);
                    this.rotate = ExifUtil.getExif(paramIntent);
                    try {
                        this.photoUri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), paramIntent.getAbsolutePath(), null, null));
                        getFileInfo();
                        startUpload(1);
                        return;
                    } catch (FileNotFoundException paramIntent) {
                        for (; ; ) {
                            paramIntent.printStackTrace();
                        }
                    }
                    if (paramInt1 != 7) {
                        break;
                    }
                    if (paramInt2 == 5) {
                        upload_tapa(paramIntent);
                        return;
                    }
                    if (paramInt2 == 6) {
                        upload_forum(paramIntent);
                        return;
                    }
                } while (paramIntent == null);
                upload_tapa(paramIntent.getExtras());
                return;
                if (paramInt1 != UploadAttachmentTool.VIMEO) {
                    break;
                }
            } while (paramInt2 != -1);
            Object localObject = null;
            if (this.vimeo_from == 1) {
                paramIntent = new File(UploadImage.SD_CARD_TEMP_DIR);
                this.rotate = ExifUtil.getExif(paramIntent);
            }
            for (; ; ) {
                try {
                    paramIntent = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), paramIntent.getAbsolutePath(), null, null));
                    if (this.mUploadAdapter == null) {
                        this.mUploadAdapter = new UploadAdapter(this.mActivity);
                    }
                    this.mUploadAdapter.setUri2(paramIntent, 0);
                    this.uploadAttachmentTool.getTicket(this.mUploadAdapter, paramIntent);
                    return;
                } catch (FileNotFoundException paramIntent) {
                    paramIntent.printStackTrace();
                    paramIntent = (Intent) localObject;
                    continue;
                }
                paramIntent = paramIntent.getData();
            }
        } while ((paramInt1 != 10) || (paramInt2 != -1));
        this.photoUri = paramIntent.getData();
        if (this.mUploadAdapter == null) {
            this.mUploadAdapter = new UploadAdapter(this.mActivity);
        }
        this.mUploadAdapter.setUri2(this.photoUri, 0);
        this.uploadAttachmentTool.getTicket(this.mUploadAdapter, this.photoUri);
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        if (this.smileflag) {
            hideEmojiKeyboard(null);
        }
        setEmojiKeyboardLayout();
        paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
        paramConfiguration.setMargins((int) getResources().getDimension(2131427375), 0, (int) getResources().getDimension(2131427375), 0);
        this.main.setLayoutParams(paramConfiguration);
        if (this.mActionbarAdapter != null) {
            invalidateOptionsMenu();
            this.mActionbarAdapter.notifyDataSetChanged();
        }
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        DebugModeUtil.opCrashEmial(this);
        paramBundle = getActionBar();
        paramBundle.setDisplayHomeAsUpEnabled(true);
        this.mActivity = this;
        this.postStartTime = ((int) System.currentTimeMillis());
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        GoogleAnalyticsTools.trackPageView(this, "thread/write", this.forumStatus.getForumId(), this.forumStatus.getUrl());
        SharedPreferences localSharedPreferences = getPreferences(0);
        if ((localSharedPreferences.contains(this.forumStatus.getForumId() + "|draft_content")) || (localSharedPreferences.contains(this.forumStatus.getForumId() + "|draft_subject"))) {
            showDialog(44);
        }
        if (getIntent().hasExtra("forumid")) {
            this.forumId = getIntent().getStringExtra("forumid");
        }
        if (getIntent().hasExtra("topicid")) {
            this.topicid = getIntent().getStringExtra("topicid");
        }
        if (getIntent().hasExtra("postid")) {
            this.postid = getIntent().getStringExtra("postid");
        }
        if (getIntent().hasExtra("modifytype")) {
            this.modifyType = getIntent().getIntExtra("modifytype", -1);
        }
        if (getIntent().hasExtra("prefixes")) {
            this.mPrefixes = ((ArrayList) getIntent().getSerializableExtra("prefixes"));
        }
        if (getIntent().hasExtra("prefixIndex")) {
            this.mCurrentPrefixIndex = getIntent().getIntExtra("prefixIndex", 0);
        }
        if (getIntent().hasExtra("canUpload")) {
            this.canUpload = getIntent().getBooleanExtra("canUpload", false);
        }
        if (getIntent().hasExtra("isShare")) {
            this.isShare = getIntent().getBooleanExtra("isShare", false);
        }
        if (getIntent().hasExtra("forum")) {
            this.forum = ((TapatalkForum) getIntent().getSerializableExtra("forum"));
        }
        if (getIntent().hasExtra("countdown")) {
            this.countdownNumber = (getIntent().getIntExtra("countdown", 0) - 1);
        }
        if (this.countdownNumber <= 0) {
            getCountDownNumber();
        }
        this.quickText = getIntent().getStringExtra("quickText");
        this.mAdapter = new NewPostAdapter(this.mActivity, this.forumStatus.getUrl(), this.forumId);
        this.mUIhandler = new Handler() {
            public void handleMessage(Message paramAnonymousMessage) {
                if (paramAnonymousMessage.what == 12) {
                    if (Boolean.valueOf(((Boolean) ((HashMap) paramAnonymousMessage.obj).get("result")).booleanValue()).booleanValue()) {
                        Toast.makeText(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.mActivity.getString(2131099985), 1).show();
                        CreateTopicActivity.this.mActivity.setResult(-1, CreateTopicActivity.this.mActivity.getIntent());
                        CreateTopicActivity.this.saveDraft = false;
                        CreateTopicActivity.this.finish();
                    }
                }
                for (; ; ) {
                    return;
                    Toast.makeText(CreateTopicActivity.this.mActivity, 2131099973, 1).show();
                    CreateTopicActivity.this.mActivity.closeProgress();
                    return;
                    if (paramAnonymousMessage.what == 19) {
                        paramAnonymousMessage = (HashMap) paramAnonymousMessage.obj;
                    }
                    try {
                        if (((Boolean) paramAnonymousMessage.get("result")).booleanValue()) {
                            if (paramAnonymousMessage.containsKey("post_content")) {
                                Intent localIntent = CreateTopicActivity.this.getIntent();
                                localIntent.putExtra("post", paramAnonymousMessage);
                                CreateTopicActivity.this.setResult(-1, localIntent);
                                if (!paramAnonymousMessage.containsKey("is_reply")) {
                                    break label255;
                                }
                                Toast.makeText(CreateTopicActivity.this, CreateTopicActivity.this.getString(2131100051), 1).show();
                            }
                            for (; ; ) {
                                CreateTopicActivity.this.saveDraft = false;
                                CreateTopicActivity.this.closeProgress();
                                CreateTopicActivity.this.finish();
                                return;
                                CreateTopicActivity.this.setResult(-1);
                                break;
                                label255:
                                Toast.makeText(CreateTopicActivity.this, CreateTopicActivity.this.getString(2131099921), 1).show();
                            }
                        }
                        CreateTopicActivity.this.closeProgress();
                        return;
                    } catch (Exception paramAnonymousMessage) {
                    }
                    if (paramAnonymousMessage.what == 30) {
                        paramAnonymousMessage = (HashMap) paramAnonymousMessage.obj;
                        CreateTopicActivity.this.attachId = ((String) paramAnonymousMessage.get("attachment_id"));
                        Toast.makeText(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.mActivity.getString(2131099895), 0).show();
                        return;
                    }
                    if (13 == paramAnonymousMessage.what) {
                        Toast.makeText(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.mActivity.getString(2131100071), 1).show();
                        return;
                    }
                    int i;
                    if (31 == paramAnonymousMessage.what) {
                        if (CreateTopicActivity.this.mProgressDialog != null) {
                            i = ((Integer) paramAnonymousMessage.obj).intValue();
                            paramAnonymousMessage = "";
                            if (i == 0) {
                                paramAnonymousMessage = CreateTopicActivity.this.mActivity.getString(2131099870);
                            }
                            for (; ; ) {
                                CreateTopicActivity.this.mProgressDialog.setMessage(paramAnonymousMessage);
                                return;
                                if (i == 1) {
                                    paramAnonymousMessage = CreateTopicActivity.this.mActivity.getString(2131099871);
                                } else if (i == 2) {
                                    paramAnonymousMessage = CreateTopicActivity.this.mActivity.getString(2131099872);
                                } else if (i == 3) {
                                    paramAnonymousMessage = CreateTopicActivity.this.mActivity.getString(2131099873);
                                } else if (i == 4) {
                                    paramAnonymousMessage = CreateTopicActivity.this.mActivity.getString(2131099874);
                                }
                            }
                        }
                    } else if (37 == paramAnonymousMessage.what) {
                        i = ((Integer) paramAnonymousMessage.obj).intValue();
                        try {
                            CreateTopicActivity.this.mUploadProgressDialog.setMax(CreateTopicActivity.this.mUploadAdapter.realSize);
                            CreateTopicActivity.this.mUploadProgressDialog.setProgress(i);
                            if (i == CreateTopicActivity.this.mUploadAdapter.realSize) {
                                CreateTopicActivity.this.mUploadProgressDialog.setTitle(CreateTopicActivity.this.mActivity.getString(2131100202));
                                return;
                            }
                        } catch (Exception paramAnonymousMessage) {
                            paramAnonymousMessage.printStackTrace();
                            return;
                        }
                    }
                }
            }
        };
        paramBundle.setIcon(2130837525);
        if (this.modifyType == -1) {
            paramBundle.setTitle(getString(2131099794));
            paramBundle = Prefs.get(this);
            this.upload = paramBundle.getBoolean("photoandattachment", true);
            initialView();
            initPrefix();
            initEmojiKey();
            initFooterToolbar();
            this.shareType = paramBundle.getString("shareType", "");
            this.shareTextTitle = paramBundle.getString("sharedTextTitle", null);
            if (this.isShare) {
                if (!"image/".equals(this.shareType)) {
                    break label696;
                }
                uploadToTk(Uri.parse(paramBundle.getString("imageUri", "")));
            }
        }
        for (; ; ) {
            this.uploadAttachmentTool = new UploadAttachmentTool(this.mActivity, this.forumStatus, this, this.postid, this.topicid);
            return;
            if (this.modifyType == 38) {
                paramBundle.setTitle(getString(2131099797));
                break;
            }
            paramBundle.setTitle(getString(2131100098));
            break;
            label696:
            if ("text/plain".equals(this.shareType)) {
                shareTextToTapatalk(paramBundle.getString("sharedText", ""));
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
            case 44:
                new AlertDialog.Builder(this).setMessage(this.mActivity.getString(2131100148)).setPositiveButton(this.mActivity.getString(2131100149), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        Object localObject = CreateTopicActivity.this.getPreferences(0);
                        paramAnonymousDialogInterface = ((SharedPreferences) localObject).getString(CreateTopicActivity.this.forumStatus.getForumId() + "|draft_subject", "");
                        localObject = ((SharedPreferences) localObject).getString(CreateTopicActivity.this.forumStatus.getForumId() + "|draft_content", "");
                        CreateTopicActivity.this.mSubject.setText(paramAnonymousDialogInterface);
                        if (CreateTopicActivity.this.mContent.getVisibility() == 0) {
                            CreateTopicActivity.access$2(CreateTopicActivity.this).mContent.setText((CharSequence) localObject);
                            CreateTopicActivity.access$2(CreateTopicActivity.this).mContent.requestFocus();
                            return;
                        }
                        CreateTopicActivity.access$2(CreateTopicActivity.this).mQuoteHeadContent.setText((CharSequence) localObject);
                        CreateTopicActivity.access$2(CreateTopicActivity.this).mQuoteHeadContent.requestFocus();
                    }
                }).setNegativeButton(this.mActivity.getString(2131100150), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreateTopicActivity.this.clearDraft();
                    }
                }).create();
            case 9:
                new AlertDialog.Builder(this).setTitle(this.mActivity.getString(2131099804)).setAdapter(new AttachDialogHelperAdapter(this.mActivity, this.forumStatus), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        if (paramAnonymousInt == 0) {
                            if (((CreateTopicActivity.this.forumStatus.getMaxAttachments() > 0) && (CreateTopicActivity.this.forumStatus.isHaveMaxAttachmentKey()) && (CreateTopicActivity.this.canUpload)) || (CreateTopicActivity.this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                                if ((CreateTopicActivity.this.canUpload) && (CreateTopicActivity.this.forumStatus.getMaxAttachments() > 0) && (CreateTopicActivity.this.forumStatus.getMaxAttachments() == CreateTopicActivity.this.mAttachlay.getChildCount())) {
                                    Toast.makeText(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.mActivity.getString(2131099966, new Object[]{Integer.valueOf(CreateTopicActivity.this.forumStatus.getMaxAttachments())}), 1).show();
                                    return;
                                }
                                paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                                paramAnonymousDialogInterface.setType("image/*");
                                CreateTopicActivity.this.startActivityForResult(paramAnonymousDialogInterface, 0);
                                return;
                            }
                            CreateTopicActivity.this.mActivity.showDialog(18);
                            return;
                        }
                        if (((CreateTopicActivity.this.forumStatus.getMaxAttachments() > 0) && (CreateTopicActivity.this.forumStatus.isHaveMaxAttachmentKey()) && (CreateTopicActivity.this.canUpload)) || (CreateTopicActivity.this.forumStatus.tapatalkForum.isSupportTkUpload())) {
                            if ((CreateTopicActivity.this.forumStatus.getMaxAttachments() > 0) && (CreateTopicActivity.this.forumStatus.getMaxAttachments() == CreateTopicActivity.this.mAttachlay.getChildCount())) {
                                Toast.makeText(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.mActivity.getString(2131099966, new Object[]{Integer.valueOf(CreateTopicActivity.this.forumStatus.getMaxAttachments())}), 1).show();
                                return;
                            }
                            paramAnonymousDialogInterface = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
                            Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                            CreateTopicActivity.this.tempUri = Uri.fromFile(new File(paramAnonymousDialogInterface));
                            localIntent.putExtra("output", CreateTopicActivity.this.tempUri);
                            localIntent.putExtra("android.intent.extra.videoQuality", 1);
                            CreateTopicActivity.this.startActivityForResult(localIntent, 1);
                            return;
                        }
                        CreateTopicActivity.this.mActivity.showDialog(18);
                    }
                }).create();
            case 42:
                this.mUploadProgressDialog = new ProgressDialog(this);
                this.mUploadProgressDialog.setIcon(17301640);
                this.mUploadProgressDialog.setTitle(getString(2131100203));
                this.mUploadProgressDialog.setProgressStyle(1);
                this.mUploadProgressDialog.setMax(100);
                this.mUploadProgressDialog.setProgress(0);
                this.mUploadProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface paramAnonymousDialogInterface) {
                    }
                });
                this.mUploadProgressDialog.setCanceledOnTouchOutside(false);
                return this.mUploadProgressDialog;
            case 15:
                new AlertDialog.Builder(this).setMessage(this.mActivity.getString(2131099901)).setPositiveButton(this.mActivity.getString(2131099900), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreateTopicActivity.this.saveDraft = false;
                        CreateTopicActivity.this.uploadAttachmentTool.removeVimeo();
                        CreateTopicActivity.this.clearDraft();
                        Util.hideSoftKeyb(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.getCurrentFocus());
                        CreateTopicActivity.this.mActivity.finish();
                    }
                }).setNegativeButton(this.mActivity.getString(2131099974), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    }
                }).setNeutralButton(this.mActivity.getString(2131099793), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        CreateTopicActivity.this.mActivity.finish();
                    }
                }).create();
        }
        new AlertDialog.Builder(this).setTitle(getString(2131100786)).setMessage(getString(2131100787)).setPositiveButton(this.mActivity.getText(2131099914).toString(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        }).create();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if (paramKeyEvent.getKeyCode() == 4) {
            if (this.smileflag) {
                hideEmojiKeyboard(null);
            }
            for (; ; ) {
                return true;
                showDialog(15);
            }
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        boolean bool = true;
        switch (paramMenuItem.getItemId()) {
            default:
                bool = false;
        }
        do {
            return bool;
            showDialog(15);
            Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
            return true;
            Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
            if (this.countdownTool != null) {
                this.countdownNumber = this.countdownTool.getNumber();
            }
        } while ((this.countdownNumber > 0) && (this.modifyType != 40));
        submit();
        return true;
    }

    public void onPause() {
        if (this.saveDraft) {
            saveDraft();
        }
        for (; ; ) {
            CustomTracker.comScorePause(this);
            super.onPause();
            return;
            clearDraft();
        }
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        paramMenu.removeGroup(0);
        paramMenu = paramMenu.add(0, 4, 0, "");
        if ((this.countdownNumber <= 0) || (this.modifyType == 40)) {
            paramMenu.setTitle(getString(2131099972));
            paramMenu.setIcon(ThemeUtil.getMenuIconByPicName("menu_send_title", this));
        }
        for (; ; ) {
            paramMenu.setShowAsAction(6);
            return true;
            this.countdownTool = new CountdownTool(this, paramMenu);
            this.countdownTool.setNumber(this.countdownNumber);
            this.countdownTool.initView();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.forumStatus.isDefaultSmilies()) {
            hideEmojiKeyboard(null);
        }
        Object localObject = getSharedPreferences("EmojiPrefs", 0).getString("recent_emoticons", null);
        int i;
        if (localObject != null) {
            if (!((String) localObject).contains("#")) {
                break label101;
            }
            localObject = ((String) localObject).split("#");
            i = 0;
            if (i < localObject.length) {
                break label72;
            }
        }
        for (; ; ) {
            CustomTracker.comScoreResume(this);
            return;
            label72:
            if (!recentEmoticons.contains(localObject[i])) {
                recentEmoticons.add(localObject[i]);
            }
            i += 1;
            break;
            label101:
            if (!recentEmoticons.contains(localObject)) {
                recentEmoticons.add(localObject);
            }
        }
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void removeInline(AttachmentInfo paramAttachmentInfo) {
        if (removeAttachBBCode(paramAttachmentInfo, this.mContent, false)) {
            removeAttachBBCode(paramAttachmentInfo, this.mContent, true);
        }
        if (removeAttachBBCode(paramAttachmentInfo, this.mQuoteHeadContent, false)) {
            removeAttachBBCode(paramAttachmentInfo, this.mQuoteHeadContent, true);
        }
        Iterator localIterator;
        if ((this.mQuoterArray != null) && (this.mQuoterArray.size() > 0)) {
            localIterator = this.mQuoterArray.iterator();
        }
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return;
            }
            Quoter localQuoter = (Quoter) localIterator.next();
            if (removeAttachBBCode(paramAttachmentInfo, localQuoter.quoteTailContent, false)) {
                removeAttachBBCode(paramAttachmentInfo, localQuoter.quoteTailContent, true);
            }
        }
    }

    public void saveDraft() {
        SharedPreferences.Editor localEditor = getPreferences(0).edit();
        if (this.mContent.getVisibility() == 0) {
            localEditor.putString(this.forumStatus.getForumId() + "|draft_content", this.mContent.getText().toString());
        }
        for (; ; ) {
            localEditor.putString(this.forumStatus.getForumId() + "|draft_subject", this.mSubject.getText().toString());
            localEditor.commit();
            return;
            localEditor.putString(this.forumStatus.getForumId() + "|draft_content", getAllContent());
        }
    }

    public void setEditTextEditable(EditText paramEditText, boolean paramBoolean) {
        if (paramBoolean) {
            paramEditText.setEnabled(true);
            paramEditText.setFocusable(true);
            paramEditText.setFocusableInTouchMode(true);
            return;
        }
        Util.hideSoftKeyb(this.mActivity, getCurrentFocus());
        paramEditText.setSelection(0);
        paramEditText.setFocusableInTouchMode(false);
        paramEditText.setFocusable(false);
        paramEditText.setEnabled(false);
    }

    public void setOpCancel(boolean paramBoolean) {
    }

    public void setSaxCall(boolean paramBoolean) {
    }

    public void setTryTwice(boolean paramBoolean) {
    }

    public void shareTextToTapatalk(String paramString) {
        if ((paramString != null) && (paramString.length() > 0)) {
            Editable localEditable1 = this.mContent.getText();
            Editable localEditable2 = this.mSubject.getText();
            localEditable1.insert(this.mContent.getSelectionStart(), paramString);
            if (this.shareTextTitle != null) {
                localEditable2.insert(this.mSubject.getSelectionStart(), this.shareTextTitle);
            }
        }
    }

    public void showProgress() {
        try {
            this.mActivity.showDialog(0);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public void showProgress(String paramString) {
    }

    public void startUpload(int paramInt) {
        this.progress = new ProgressDialog(this.mActivity);
        this.progress.setMessage(this.mActivity.getResources().getString(2131100313));
        this.mUploadAdapter = new UploadAdapter(this.mActivity, this.forumStatus.getMaxJpgSize());
        getImage(paramInt);
        this.engine = new TapatalkEngine(this, this.forumStatus, this.mActivity);
        Object localObject = new TapatalkJsonEngine(this.mActivity, this);
        localObject = new SignInWithOtherUtil(this.mActivity, (TapatalkJsonEngine) localObject, new Handler());
        if ((!this.mActivity.getResources().getBoolean(2131558401)) && ((this.forumStatus.tapatalkForum.isMedia_sharing()) || (this.forumStatus.tapatalkForum.isSupportTkUpload())) && (this.upload_style == 20)) {
            if (!this.mActivity.getResources().getBoolean(2131558401)) {
                break label280;
            }
            this.isTapa = true;
            upLoad();
        }
        for (; ; ) {
            if ((this.canUpload) && (this.upload_style == 21)) {
                if (this.extensions == null) {
                    break label377;
                }
                if (!isAllowType()) {
                    break label361;
                }
                if ((this.attachmentSize == 0) && (this.mimeType != null) && (this.mimeType.contains("image/"))) {
                    this.attachmentSize = this.forumStatus.getMaxJpgSize();
                }
                if (this.mSize > this.attachmentSize) {
                    break;
                }
                this.isTapa = false;
                upLoad();
            }
            return;
            label280:
            if (this.forumStatus.isTapatalkSignIn(this.mActivity)) {
                this.isTapa = true;
                upLoad();
            } else {
                ((SignInWithOtherUtil) localObject).showShouldSignInDialog();
            }
        }
        Toast.makeText(this, getString(2131100915, new Object[]{Integer.valueOf(this.mSize / 1024), Integer.valueOf(this.attachmentSize / 1024)}), 0).show();
        return;
        label361:
        Toast.makeText(this, getString(2131100913), 0).show();
        return;
        label377:
        this.isTapa = false;
        upLoad();
    }

    public void submit() {
        if ((this.mSubject.getText().toString().length() == 0) && (this.modifyType == -1)) {
            Toast.makeText(this.mActivity, this.mActivity.getString(2131099781), 1).show();
            this.mSubject.requestFocus();
            return;
        }
        if ((this.mContent.getEditableText().length() == 0) && (this.mContent.getVisibility() != 8)) {
            Toast.makeText(this.mActivity, this.mActivity.getString(2131099780), 1).show();
            this.mContent.requestFocus();
            return;
        }
        Object localObject5 = this.mSubject.getText().toString();
        Object localObject3 = this.mReason.getText().toString();
        if (isContainEmoji(this.mSubject.getText().toString())) {
            Toast.makeText(this.mActivity, this.mActivity.getString(2131099782), 1).show();
            this.mSubject.requestFocus();
            return;
        }
        if (isContainEmoji(this.mReason.getText().toString())) {
            Toast.makeText(this.mActivity, this.mActivity.getString(2131099782), 1).show();
            this.mReason.requestFocus();
            return;
        }
        ArrayList localArrayList = new ArrayList();
        Object localObject6 = null;
        String str = SettingsFragment.getSingature(this.mActivity, this.forumStatus.getSigType(), this.forumStatus);
        Object localObject4 = getAllContent();
        Object localObject1 = localObject4;
        if (this.forumStatus.isSupportEmoji()) {
            localObject1 = BBcodeUtil.parseAllForumPublicSmileToEmojiBBCode((String) localObject4);
        }
        int i;
        if (this.mAdapter != null) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mAdapter.imageIds.size()) {
                i = 0;
                label321:
                if (i < this.mAdapter.videoIds.size()) {
                    break label796;
                }
            }
            try {
                if ((this.forumStatus.isSupportSignature()) && (str != null) && (str.length() > 0) && (this.signatureTag.isChecked()) && (this.modifyType != 40)) {
                    localObject4 = (localObject1 + "\n\n" + str + "\n\n").getBytes("UTF-8");
                    localObject1 = localObject4;
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException3) {
                try {
                    localObject4 = ((String) localObject5).getBytes("UTF-8");
                    localObject5 = localObject3;
                    if (((String) localObject3).equals("")) {
                        localObject5 = getIntent().getStringExtra("edit_reason");
                    }
                    localObject3 = localObject6;
                    if (this.modifyType == 40) {
                        localObject3 = localObject6;
                        if (!this.show_reason) {
                        }
                    }
                } catch (UnsupportedEncodingException localUnsupportedEncodingException3) {
                    try {
                        for (; ; ) {
                            localObject3 = ((String) localObject5).getBytes("UTF-8");
                            localObject6 = null;
                            localObject5 = localObject6;
                            if (this.mPrefixes != null) {
                                localObject5 = localObject6;
                                if (this.mPrefixes.size() > 0) {
                                    localObject5 = localObject6;
                                    if (!((String) ((HashMap) this.mPrefixes.get(this.mCurrentPrefixIndex)).get("prefix_id")).equalsIgnoreCase(this.mActivity.getString(2131099967))) {
                                        localObject5 = (String) ((HashMap) this.mPrefixes.get(this.mCurrentPrefixIndex)).get("prefix_id");
                                    }
                                }
                            }
                            if (this.modifyType != -1) {
                                break label1122;
                            }
                            if (this.forumStatus.getApiLevel() < 3) {
                                break label1014;
                            }
                            localArrayList.add(this.forumId);
                            localArrayList.add(localObject4);
                            localArrayList.add(localObject1);
                            if (localObject5 == null) {
                                break label1003;
                            }
                            localArrayList.add(localObject5);
                            if (this.mAdapter.attachIds.size() != 0) {
                                localArrayList.add(this.mAdapter.attachIds.toArray(new String[this.mAdapter.attachIds.size()]));
                                localArrayList.add(this.mAdapter.groupId);
                            }
                            this.mAdapter.CreateNewTopic(localArrayList, this.mSubject.getText().toString(), this.isShare, this.forum);
                            try {
                                this.mActivity.showDialog(0);
                                return;
                            } catch (Exception localException) {
                                return;
                            }
                            int j = i;
                            if (!localException.contains(((UploadImageInfo) this.mAdapter.imageIds.get(i)).getUrl())) {
                                this.mAdapter.imageIds.remove(this.mAdapter.imageIds.get(i));
                                j = i - 1;
                            }
                            i = j + 1;
                            break;
                            label796:
                            j = i;
                            if (!localException.contains((CharSequence) this.mAdapter.videoIds.get(i))) {
                                this.mAdapter.videoIds.remove(this.mAdapter.videoIds.get(i));
                                this.mAdapter.ids.remove(this.mAdapter.ids.get(i));
                                j = i - 1;
                            }
                            i = j + 1;
                            break label321;
                            localObject4 = localException.getBytes("UTF-8");
                            localObject2 = localObject4;
                            continue;
                            localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                            if ((this.forumStatus.isSupportSignature()) && (str != null) && (str.length() > 0) && (this.signatureTag.isChecked()) && (this.modifyType != 40)) {
                                localObject2 = (localObject2 + "\n\n" + str + "\n\n").getBytes();
                            } else {
                                localObject2 = ((String) localObject2).getBytes();
                            }
                        }
                        localUnsupportedEncodingException3 = localUnsupportedEncodingException3;
                        arrayOfByte2 = ((String) localObject5).getBytes();
                    } catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
                        for (; ; ) {
                            Object localObject2;
                            byte[] arrayOfByte2;
                            byte[] arrayOfByte1 = ((String) localObject5).getBytes();
                            continue;
                            label1003:
                            localArrayList.add("");
                            continue;
                            label1014:
                            localArrayList.add(this.forumId);
                            localArrayList.add(arrayOfByte2);
                            localArrayList.add(new byte[0]);
                            localArrayList.add(localObject2);
                            if (this.attachId != null) {
                                localArrayList.add(this.attachId);
                                if (localObject5 != null) {
                                    localArrayList.add(localObject5);
                                }
                            } else if ((this.mPrefixes != null) && (this.mPrefixes.size() > 0)) {
                                localArrayList.add("");
                                if (localObject5 != null) {
                                    localArrayList.add(localObject5);
                                    continue;
                                    label1122:
                                    if (this.modifyType == 38) {
                                        if (this.forumStatus.getApiLevel() >= 3) {
                                            localArrayList.add(this.forumId);
                                            localArrayList.add(this.topicid);
                                            localArrayList.add(arrayOfByte2);
                                            localArrayList.add(localObject2);
                                            if (this.mAdapter.attachIds.size() != 0) {
                                                localArrayList.add(this.mAdapter.attachIds.toArray(new String[this.mAdapter.attachIds.size()]));
                                                if (this.mAdapter.groupId != null) {
                                                    localArrayList.add(this.mAdapter.groupId);
                                                    label1242:
                                                    if (this.forumStatus.isNoRerefreshPost()) {
                                                        if (!this.forumStatus.isSupprotBBcode()) {
                                                            break label1334;
                                                        }
                                                        localArrayList.add(Boolean.valueOf(true));
                                                    }
                                                }
                                            }
                                        }
                                        for (; ; ) {
                                            this.mAdapter.ReplyTopic(localArrayList, this.topicid, this.subjectTitle);
                                            break;
                                            localArrayList.add("");
                                            break label1242;
                                            if (!this.forumStatus.isNoRerefreshPost()) {
                                                break label1242;
                                            }
                                            localArrayList.add(new String[0]);
                                            localArrayList.add("");
                                            break label1242;
                                            label1334:
                                            localArrayList.add(Boolean.valueOf(false));
                                            continue;
                                            localArrayList.add(this.topicid);
                                            localArrayList.add(new byte[0]);
                                            localArrayList.add(localObject2);
                                            localArrayList.add(arrayOfByte2);
                                            if (this.attachId != null) {
                                                localArrayList.add(this.attachId);
                                            }
                                        }
                                    }
                                    if (this.modifyType == 40) {
                                        localArrayList.add(this.postid);
                                        localArrayList.add(arrayOfByte2);
                                        localArrayList.add(localObject2);
                                        if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0)) {
                                            localArrayList.add(Boolean.valueOf(true));
                                            localArrayList.add(new ArrayList());
                                            localArrayList.add("");
                                            localArrayList.add(arrayOfByte1);
                                        }
                                        this.mAdapter.editPost(localArrayList);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void tryFailed(String paramString) {
    }

    public void upLoad() {
        if (this.isTapa) {
            if (this.mimeType.contains("video/")) {
                this.mUploadAdapter.setUri2(this.photoUri, 0);
                this.uploadAttachmentTool.getTicket(this.mUploadAdapter, this.photoUri);
                return;
            }
            uploadToTk();
            return;
        }
        showDialog(42);
        if ((this.mimeType != null) && (this.mimeType.contains("image/"))) {
            this.mUploadAdapter.setUri(this.photoUri, 0);
        }
        for (; ; ) {
            attachImage();
            return;
            this.mUploadAdapter.setUri2(this.photoUri, 0);
        }
    }

    public void updateAttachNumberText() {
        if (this.mAttachlay.getChildCount() > 0) {
            this.mAttachSectionTitle.setText(this.mActivity.getString(2131099965, new Object[]{Integer.valueOf(this.mAttachlay.getChildCount()), Integer.valueOf(this.forumStatus.getMaxAttachments())}));
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
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = 31;
        localMessage.obj = Integer.valueOf(paramInt);
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void updateUI(int paramInt, Object paramObject) {
        Message localMessage = this.mUIhandler.obtainMessage();
        localMessage.what = paramInt;
        localMessage.obj = paramObject;
        this.mUIhandler.sendMessage(localMessage);
    }

    public void updateUI(String paramString) {
    }

    public void uploadToForum(ArrayList paramArrayList, Uri paramUri, int paramInt, String paramString) {
        try {
            paramArrayList = addAttachment(paramArrayList, paramUri, paramInt, paramString);
            this.mContentClickHandler.setVisibility(8);
            this.mAttachlay.addView(paramArrayList);
            this.mAttachSectionTitle.setVisibility(4);
            updateAttachNumberText();
            this.mScrollwrap.post(new Runnable() {
                public void run() {
                }
            });
            return;
        } catch (Exception paramArrayList) {
            paramArrayList.printStackTrace();
        }
    }

    public void uploadToTk() {
        this.progress.show();
        new AsyncTask() {
            protected ArrayList doInBackground(String... paramAnonymousVarArgs) {
                if (CreateTopicActivity.this.mAdapter == null) {
                    CreateTopicActivity.this.mAdapter = new NewPostAdapter(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.forumStatus.getUrl());
                }
                paramAnonymousVarArgs = new ArrayList();
                int i = ExifUtil.getExif(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.photoUri);
                if (CreateTopicActivity.this.mUploadAdapter != null) {
                    CreateTopicActivity.this.mUploadAdapter.setUri(CreateTopicActivity.this.photoUri, i);
                    paramAnonymousVarArgs.add(CreateTopicActivity.this.attachImage2());
                }
                UserBehavior.logUserShareForum(CreateTopicActivity.this.mActivity);
                return paramAnonymousVarArgs;
            }

            protected void onPostExecute(ArrayList paramAnonymousArrayList) {
                try {
                    CreateTopicActivity.this.engine.getLoginStatus();
                    paramAnonymousArrayList = UploadAttachmentTool.getUploadImageInfo((String) paramAnonymousArrayList.get(0));
                    if (paramAnonymousArrayList.getResult() == 1) {
                        if ((paramAnonymousArrayList.getUrl() != null) && (paramAnonymousArrayList.getUrl().length() > 0)) {
                            if (CreateTopicActivity.this.mAdapter != null) {
                                CreateTopicActivity.this.mAdapter.imageIds.add(paramAnonymousArrayList);
                            }
                            CreateTopicActivity.this.upload_tapa(Uri.parse(paramAnonymousArrayList.getUrl()));
                        }
                    }
                    for (; ; ) {
                        CreateTopicActivity.this.progress.dismiss();
                        return;
                        if (paramAnonymousArrayList.getResult_text() != null) {
                            Toast.makeText(CreateTopicActivity.this.mActivity, paramAnonymousArrayList.getResult_text(), 1).show();
                        }
                    }
                    return;
                } catch (Exception paramAnonymousArrayList) {
                    paramAnonymousArrayList.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }

    public void uploadToTk(final Uri paramUri) {
        final ProgressDialog localProgressDialog = new ProgressDialog(this.mActivity);
        localProgressDialog.setMessage(this.mActivity.getResources().getString(2131100313));
        localProgressDialog.show();
        new AsyncTask() {
            protected ArrayList doInBackground(String... paramAnonymousVarArgs) {
                if (CreateTopicActivity.this.mAdapter == null) {
                    CreateTopicActivity.this.mAdapter = new NewPostAdapter(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.forumStatus.getUrl());
                }
                paramAnonymousVarArgs = new UploadAdapter(CreateTopicActivity.this.mActivity, CreateTopicActivity.this.forumStatus.getMaxJpgSize());
                ArrayList localArrayList = new ArrayList();
                int i = ExifUtil.getExif(CreateTopicActivity.this.mActivity, paramUri);
                paramAnonymousVarArgs.setUri(paramUri, i);
                localArrayList.add(CreateTopicActivity.this.attachImage(paramAnonymousVarArgs));
                return localArrayList;
            }

            protected void onPostExecute(ArrayList paramAnonymousArrayList) {
                try {
                    paramAnonymousArrayList = UploadAttachmentTool.getUploadImageInfo((String) paramAnonymousArrayList.get(0));
                    if (paramAnonymousArrayList.getResult() == 1) {
                        if ((paramAnonymousArrayList.getUrl() != null) && (paramAnonymousArrayList.getUrl().length() > 0)) {
                            if (CreateTopicActivity.this.mAdapter != null) {
                                CreateTopicActivity.this.mAdapter.imageIds.add(paramAnonymousArrayList);
                            }
                            CreateTopicActivity.this.upload_tapa(Uri.parse(paramAnonymousArrayList.getUrl()));
                        }
                    }
                    for (; ; ) {
                        localProgressDialog.dismiss();
                        return;
                        if (paramAnonymousArrayList.getResult_text() != null) {
                            Toast.makeText(CreateTopicActivity.this.mActivity, paramAnonymousArrayList.getResult_text(), 1).show();
                        }
                    }
                    return;
                } catch (Exception paramAnonymousArrayList) {
                    paramAnonymousArrayList.printStackTrace();
                }
            }
        }.execute(new String[0]);
    }

    public void upload_forum(Intent paramIntent) {
        paramIntent = paramIntent.getExtras();
        ArrayList localArrayList = (ArrayList) paramIntent.getSerializable("attachIds");
        this.mAdapter.attachIds.clear();
        this.mAdapter.attachIds.addAll(localArrayList);
        int i = ((Integer) paramIntent.getSerializable("size")).intValue();
        String str = (String) paramIntent.getSerializable("imgName");
        Uri localUri = (Uri) paramIntent.getParcelable("uri");
        this.groupId = ((String) paramIntent.getSerializable("groupId"));
        this.mAdapter.groupId = this.groupId;
        uploadToForum(localArrayList, localUri, i, str);
    }

    public void upload_forum(Uri paramUri, String paramString1, String paramString2) {
        this.mAdapter.attachIds.add(paramString1);
        this.mAdapter.groupId = paramString2;
        if (this.mSize == 0) {
            this.mSize = this.mUploadAdapter.mSize;
        }
        if ((this.imageName == null) || (this.imageName.length() == 0)) {
            this.imageName = this.mUploadAdapter.imageName;
        }
        if ((this.mimeType == null) || (this.mimeType.length() == 0)) {
            this.mimeType = this.mUploadAdapter.mimeType;
        }
        uploadToForum(this.mAdapter.attachIds, paramUri, this.mSize, this.imageName);
    }

    public void upload_tapa(Intent paramIntent) {
        Object localObject2 = paramIntent.getData();
        Object localObject1 = getFocusView();
        paramIntent = (Intent) localObject1;
        if (localObject1 == this.mSubject) {
            paramIntent = this.mContent;
        }
        localObject1 = paramIntent.getText();
        localObject2 = "[IMG]" + ((Uri) localObject2).toString() + "[/IMG]";
        int i = ((String) localObject2).length();
        ((Editable) localObject1).insert(paramIntent.getSelectionStart(), (CharSequence) localObject2, 0, i);
    }

    public void upload_tapa(Uri paramUri) {
        Object localObject2 = getFocusView();
        Object localObject1 = localObject2;
        if (localObject2 == this.mSubject) {
            localObject1 = this.mContent;
        }
        localObject2 = ((EditText) localObject1).getText();
        paramUri = "[IMG]" + paramUri + "[/IMG]";
        int i = paramUri.length();
        ((Editable) localObject2).insert(((EditText) localObject1).getSelectionStart(), paramUri, 0, i);
    }

    public void upload_tapa(Bundle paramBundle) {
        paramBundle = managedQuery((Uri) paramBundle.getParcelable("uri"), new String[]{"_data"}, null, null, null);
        int i = paramBundle.getColumnIndexOrThrow("_data");
        paramBundle.moveToFirst();
        String str = paramBundle.getString(i);
        Object localObject = getFocusView();
        paramBundle = (Bundle) localObject;
        if (localObject == this.mSubject) {
            paramBundle = this.mContent;
        }
        localObject = paramBundle.getText();
        str = "[IMG]" + str + "[/IMG]";
        i = str.length();
        ((Editable) localObject).insert(paramBundle.getSelectionStart(), str, 0, i);
    }

    private class QuoteInitializer
            implements Runnable {
        public Quoter q;

        private QuoteInitializer() {
        }

        private void setQuoteContentArea() {
            this.q.quoteContent.setOnTouchListener(CreateTopicActivity.this.mOnTouchHideEmojiListener);
            this.q.quoteContent.setOnFocusChangeListener(CreateTopicActivity.this.mOnFocusChangeHideEmojiListener);
            this.q.isExpanded = true;
            this.q.quoteArrow.setVisibility(0);
            if (this.q.quoteContent.getLineCount() == 1) {
                ViewGroup.LayoutParams localLayoutParams = this.q.quoteArrow.getLayoutParams();
                localLayoutParams.height += Util.getPxFromDip(CreateTopicActivity.this.mActivity, 5.0F);
                this.q.quoteArrow.setLayoutParams(localLayoutParams);
                this.q.quoteArrow.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("newtopic_quote_edit_signleline", CreateTopicActivity.this.mActivity));
            }
            for (; ; ) {
                this.q.quoteArrow.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        CreateTopicActivity.this.expandQuote(CreateTopicActivity.QuoteInitializer.this.q);
                    }
                });
                return;
                this.q.quoteArrow.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("newtopic_quote_edit", CreateTopicActivity.this.mActivity));
            }
        }

        private void setQuoteTailArea() {
            this.q.quoteTailContent.setOnTouchListener(CreateTopicActivity.this.mOnTouchHideEmojiListener);
            this.q.quoteTailContent.setOnFocusChangeListener(CreateTopicActivity.this.mOnFocusChangeHideEmojiListener);
            this.q.quoteTailContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                    if (paramAnonymousBoolean) {
                        paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 18.0F), paramAnonymousView.getPaddingRight(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 22.0F));
                        localLayoutParams = (RelativeLayout.LayoutParams) paramAnonymousView.getLayoutParams();
                        localLayoutParams.height = -2;
                        paramAnonymousView.setLayoutParams(localLayoutParams);
                    }
                    while (((EditText) paramAnonymousView).getText().length() != 0) {
                        return;
                    }
                    paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 0.0F), paramAnonymousView.getPaddingRight(), Util.getPxFromDip(CreateTopicActivity.this.mActivity, 0.0F));
                    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) paramAnonymousView.getLayoutParams();
                    localLayoutParams.height = Util.getPxFromDip(CreateTopicActivity.this.mActivity, 30.0F);
                    paramAnonymousView.setLayoutParams(localLayoutParams);
                }
            });
        }

        public void run() {
            setQuoteContentArea();
            setQuoteTailArea();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/forum/CreateTopicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */