package com.quoord.tapatalkpro.bean;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide.ContextRequest;
import com.bumptech.glide.Glide.Request;
import com.bumptech.glide.presenter.target.ImageViewTarget;
import com.quoord.tapatalkpro.action.UploadAvatarAction;
import com.quoord.tapatalkpro.action.UploadAvatarAction.OnUploadProcessListener;
import com.quoord.tapatalkpro.adapter.forum.AttachDialogHelperAdapter;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.WebActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.util.BBcodeUtil;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.ImageTools;
import com.quoord.tools.directoryurl.DirectoryUrlUtil;
import com.quoord.tools.net.JSONUtil;
import com.quoord.tools.net.PrefsUtil;
import com.quoord.tools.net.TapatalkAjaxAction;
import com.quoord.tools.net.TapatalkAjaxAction.ActionCallBack;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.JSONObject;

public class Profile
        implements UploadAvatarAction.OnUploadProcessListener {
    private static final String SD_CARD_TEMP_DIR = Environment.getExternalStorageDirectory() + File.separator + "tmpPhoto.jpg";
    public static final int TAG_UPLOAD_AVATAR_CAMERA = 42716;
    public static final int TAG_UPLOAD_AVATAR_GALLERY = 9667;
    private static final int TAG_UPLOAD_DONE = 24889;
    private static final int TAG_UPLOAD_INIT = 46458;
    private static final int TAG_UPLOAD_PROCESS = 50856;
    private int auId = 0;
    private String avatar = null;
    private String avatarUrl = null;
    private String birthday = null;
    private String cover = null;
    private String description = null;
    private String firstName = null;
    private String gender = null;
    private Handler handler = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                case 50856:
                default:
                    return;
            }
            if (paramAnonymousMessage.arg1 == 1) {
                paramAnonymousMessage = (String) paramAnonymousMessage.obj;
                paramAnonymousMessage = paramAnonymousMessage.substring(paramAnonymousMessage.indexOf("http"));
                Profile.this.updateAvatar(paramAnonymousMessage);
                return;
            }
            Toast.makeText(Profile.this.mActivity, Profile.this.mActivity.getResources().getString(2131100912) + " - " + paramAnonymousMessage.obj, 1).show();
        }
    };
    private String language = null;
    private long lastActivity = 0L;
    private String lastActivityElapsed = null;
    private String lastName = null;
    private String link = null;
    private String locale = null;
    private String location = null;
    private Activity mActivity;
    private UploadAvatarCallback mCallback;
    private EditText mDescriptionEt = null;
    private boolean mDescriptionFocusChanged = false;
    private boolean mDescriptionHasChanged = false;
    private String name = null;
    private long register = 0L;
    private String signature = null;
    private String statusMessage = null;

    public Profile(Activity paramActivity) {
        this.mActivity = paramActivity;
    }

    public static void clearProfile(Activity paramActivity) {
        paramActivity = Prefs.get(paramActivity).edit();
        paramActivity.putInt("tapatalk_au_id", 0);
        paramActivity.putString("tapatalk_cover", "");
        paramActivity.putString("tapatalk_avatar", "");
        paramActivity.putString("tapatalk_avatar_url", "");
        paramActivity.putString("tapatalk_gender", "");
        paramActivity.putString("tapatalk_link", "");
        paramActivity.putString("tapatalk_first_name", "");
        paramActivity.putString("tapatalk_last_name", "");
        paramActivity.putString("tapatalk_name", "");
        paramActivity.putString("tapatalk_birthday", "");
        paramActivity.putString("tapatalk_location", "");
        paramActivity.putString("tapatalk_locale", "");
        paramActivity.putString("tapatalk_description", "");
        paramActivity.putString("tapatalk_signature", "");
        paramActivity.putString("tapatalk_status_message", "");
        paramActivity.putString("tapatalk_language", "");
        paramActivity.putLong("tapatalk_register", 0L);
        paramActivity.putLong("tapatalk_last_activity", 0L);
        paramActivity.commit();
    }

    private void editProfile() {
        Intent localIntent = new Intent(this.mActivity, WebActivity.class);
        localIntent.putExtra("url", DirectoryUrlUtil.getManageAccountUrl(this.mActivity));
        localIntent.putExtra("title", this.mActivity.getString(2131100904));
        this.mActivity.startActivity(localIntent);
    }

    public static AlertDialog getUploadSelectorDialog(Activity paramActivity) {
        new AlertDialog.Builder(paramActivity).setTitle(paramActivity.getString(2131099804)).setAdapter(new AttachDialogHelperAdapter(paramActivity), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (paramAnonymousInt == 0) {
                    paramAnonymousDialogInterface = new Intent("android.intent.action.PICK");
                    paramAnonymousDialogInterface.setType("image/*");
                    Profile.this.startActivityForResult(paramAnonymousDialogInterface, 9667);
                    return;
                }
                paramAnonymousDialogInterface = new Intent("android.media.action.IMAGE_CAPTURE");
                paramAnonymousDialogInterface.putExtra("output", Uri.fromFile(new File(Profile.SD_CARD_TEMP_DIR)));
                paramAnonymousDialogInterface.putExtra("android.intent.extra.videoQuality", 1);
                Profile.this.startActivityForResult(paramAnonymousDialogInterface, 42716);
            }
        }).create();
    }

    private void initViewHolder(ProfileViewHolder paramProfileViewHolder) {
        paramProfileViewHolder.avatarImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Profile.getUploadSelectorDialog(Profile.this.mActivity).show();
                Profile.this.uploadDescription();
            }
        });
        paramProfileViewHolder.editBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Profile.this.uploadDescription();
                Profile.this.editProfile();
            }
        });
        this.mDescriptionEt = paramProfileViewHolder.descriptionEt;
        this.mDescriptionEt.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
                switch (paramAnonymousMotionEvent.getAction() & 0xFF) {
                    default:
                        return false;
                }
                paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        this.mDescriptionEt.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable paramAnonymousEditable) {
                if (Profile.this.mDescriptionFocusChanged) {
                    Profile.this.mDescriptionHasChanged = true;
                }
            }

            public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
            }

            public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
            }
        });
        this.mDescriptionEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                Profile.this.mDescriptionFocusChanged = paramAnonymousBoolean;
                if (!paramAnonymousBoolean) {
                    Profile.this.uploadDescription();
                }
            }
        });
    }

    private void setAvatar(ProfileViewHolder paramProfileViewHolder) {
        final Object localObject2 = getAvatar();
        Object localObject1 = localObject2;
        if (Util.isEmpty((String) localObject2)) {
            localObject1 = getAvatarUrl();
        }
        localObject2 = localObject1;
        if (Util.isEmpty((String) localObject1)) {
            localObject2 = "";
        }
        try {
            Glide.load((String) localObject2).placeholder(ThemeUtil.getDrawableIDByPicName("default_avatar_profile", this.mActivity)).into(new ImageViewTarget(paramProfileViewHolder.avatarImg) {
                public void onImageReady(Bitmap paramAnonymousBitmap) {
                    super.onImageReady(paramAnonymousBitmap);
                    ImageTools.saveBitmpaToCache(paramAnonymousBitmap, AppCacheManager.getLongtermCacheDir(Profile.this.mActivity) + localObject2.hashCode());
                }
            }).with(this.mActivity);
            return;
        } catch (Exception paramProfileViewHolder) {
        }
    }

    private void setDescriptionView(ProfileViewHolder paramProfileViewHolder) {
        paramProfileViewHolder = getDescription();
        if (!Util.isEmpty(paramProfileViewHolder)) {
            paramProfileViewHolder = paramProfileViewHolder.replaceAll("&quot;", "\"").replaceAll("\n", "<br />");
            GetEmojiImage localGetEmojiImage = new GetEmojiImage(this.mActivity);
            localGetEmojiImage.view = this.mDescriptionEt;
            paramProfileViewHolder = Html.fromHtml(BBcodeUtil.parseAllEmoji(paramProfileViewHolder), localGetEmojiImage, new MyTagHandler());
            this.mDescriptionEt.setText(paramProfileViewHolder);
            return;
        }
        this.mDescriptionEt.setText("");
    }

    private void setMoreData(final ProfileViewHolder paramProfileViewHolder) {
        String str1 = null;
        String str2 = null;
        if (!Util.isEmpty(getRegister())) {
            str1 = this.mActivity.getString(2131100905) + " : " + Util.getSmartTime(this.mActivity, (int) getRegister());
        }
        if (!Util.isEmpty(getLastActivity())) {
            str2 = this.mActivity.getString(2131100906) + " : " + getLastActivityElapsed();
        }
        paramProfileViewHolder.moreInfoTv.setVisibility(0);
        if ((Util.isEmpty(str1)) && (Util.isEmpty(str2))) {
            paramProfileViewHolder.moreInfoTv.setVisibility(8);
            return;
        }
        if (Util.isEmpty(str1)) {
            paramProfileViewHolder.moreInfoTv.setText(str2);
            return;
        }
        if (Util.isEmpty(str2)) {
            paramProfileViewHolder.moreInfoTv.setText(str1);
            return;
        }
        final String str3 = str1 + "\n" + str2;
        if ((!Util.isHDDevice(this.mActivity)) && (this.mActivity.getResources().getConfiguration().orientation == 1)) {
            paramProfileViewHolder.moreInfoTv.setText(str3);
            return;
        }
        paramProfileViewHolder.moreInfoTv.setText(str1 + "     " + str2);
        paramProfileViewHolder = paramProfileViewHolder.moreInfoTv;
        new Handler().post(new Runnable() {
            public void run() {
                if (paramProfileViewHolder.getLineCount() > 1) {
                    paramProfileViewHolder.setText(str3);
                }
            }
        });
    }

    private void setName(ProfileViewHolder paramProfileViewHolder) {
        Object localObject1 = null;
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(this.mActivity);
        Object localObject2 = localObject1;
        if (localTapatalkId != null) {
            if (!Util.isEmpty(localTapatalkId.getUsername())) {
                localObject2 = localTapatalkId.getUsername();
            }
        } else {
            localObject1 = localObject2;
            if (Util.isEmpty((String) localObject2)) {
                localObject2 = getName();
                localObject1 = localObject2;
                if (Util.isEmpty((String) localObject2)) {
                    if ((Util.isEmpty(getFirstName())) || (Util.isEmpty(getLastName()))) {
                        break label148;
                    }
                    localObject1 = getFirstName() + " " + getLastName();
                }
            }
        }
        for (; ; ) {
            paramProfileViewHolder.nameTv.setText((CharSequence) localObject1);
            return;
            localObject2 = localObject1;
            if (Util.isEmpty(localTapatalkId.getTapatalkIdEmail())) {
                break;
            }
            localObject2 = localTapatalkId.getTapatalkIdEmail();
            break;
            label148:
            if ((!Util.isEmpty(getFirstName())) && (Util.isEmpty(getLastName()))) {
                localObject1 = getFirstName();
            } else if ((Util.isEmpty(getFirstName())) && (!Util.isEmpty(getLastName()))) {
                localObject1 = getLastName();
            } else {
                localObject1 = "";
            }
        }
    }

    private void updateAvatar(String paramString) {
        setAvatarWithPref(paramString);
        setAvatarUrlWithPref(paramString);
        this.mCallback.callback();
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        localEditor.putString("tapatalk_avatar", paramString);
        localEditor.putString("tapatalk_avatar_url", paramString);
        localEditor.commit();
    }

    private void uploadAvatar(Uri paramUri) {
        if (Util.isEmpty(paramUri)) {
            return;
        }
        try {
            Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100910), 0).show();
            UploadAvatarAction localUploadAvatarAction = UploadAvatarAction.getInstance(this.mActivity);
            localUploadAvatarAction.setOnUploadProcessListener(this);
            localUploadAvatarAction.uploadAvatarToTapatalk(paramUri);
            return;
        } catch (Exception paramUri) {
        }
    }

    public static void uploadAvator(int paramInt) {
    }

    public int getAuId() {
        return this.auId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getLastActivity() {
        return this.lastActivity;
    }

    public String getLastActivityElapsed() {
        return this.lastActivityElapsed;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLink() {
        return this.link;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public View getProfileView(View paramView, Activity paramActivity, ViewGroup paramViewGroup, UploadAvatarCallback paramUploadAvatarCallback) {
        this.mCallback = paramUploadAvatarCallback;
        if ((paramView == null) || (!(paramView.getTag() instanceof ProfileViewHolder))) {
            paramView = paramActivity.getLayoutInflater().inflate(2130903320, null);
            paramActivity = new ProfileViewHolder(null);
            paramActivity.mainArea = paramView.findViewById(2131231523);
            paramActivity.avatarImg = ((ImageView) paramView.findViewById(2131231524));
            paramActivity.nameTv = ((TextView) paramView.findViewById(2131231525));
            paramActivity.moreInfoTv = ((TextView) paramView.findViewById(2131231526));
            paramActivity.editBtn = ((Button) paramView.findViewById(2131231527));
            paramActivity.dividerView = paramView.findViewById(2131231528);
            paramActivity.descriptionEt = ((EditText) paramView.findViewById(2131231529));
            initViewHolder(paramActivity);
            paramView.setTag(paramActivity);
            paramView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                    Profile.this.uploadDescription();
                    return false;
                }
            });
        }
        for (; ; ) {
            setAvatar(paramActivity);
            setName(paramActivity);
            setMoreData(paramActivity);
            setDescriptionView(paramActivity);
            return paramView;
            paramActivity = (ProfileViewHolder) paramView.getTag();
        }
    }

    public long getRegister() {
        return this.register;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void initUpload(int paramInt) {
        Message localMessage = Message.obtain();
        localMessage.what = 46458;
        localMessage.obj = Integer.valueOf(paramInt);
        this.handler.sendMessage(localMessage);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt2 != -1) {
        }
        do {
            return;
            if (paramInt1 == 9667) {
                uploadAvatar(paramIntent.getData());
                return;
            }
        } while (paramInt1 != 42716);
        uploadAvatar(Uri.fromFile(new File(SD_CARD_TEMP_DIR)));
    }

    public void onUploadDone(int paramInt, String paramString) {
        Message localMessage = Message.obtain();
        localMessage.what = 24889;
        localMessage.obj = paramString;
        localMessage.arg1 = paramInt;
        this.handler.sendMessage(localMessage);
    }

    public void onUploadProcess(int paramInt) {
        Message localMessage = Message.obtain();
        localMessage.what = 50856;
        localMessage.obj = Integer.valueOf(paramInt);
        this.handler.sendMessage(localMessage);
    }

    public void setAuId(int paramInt) {
        this.auId = paramInt;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setAvatarUrl(String paramString) {
        this.avatarUrl = paramString;
    }

    public void setAvatarUrlWithPref(String paramString) {
        this.avatarUrl = paramString;
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        localEditor.putString("tapatalk_avatar_url", paramString);
        localEditor.commit();
    }

    public void setAvatarWithPref(String paramString) {
        this.avatar = paramString;
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        localEditor.putString("tapatalk_avatar", paramString);
        localEditor.commit();
    }

    public void setBirthday(String paramString) {
        this.birthday = paramString;
    }

    public void setCover(String paramString) {
        this.cover = paramString;
    }

    public void setDescription(String paramString) {
        this.description = paramString;
    }

    public void setDescriptionWithPref(String paramString) {
        this.description = paramString;
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        localEditor.putString("tapatalk_description", paramString);
        localEditor.commit();
    }

    public void setFirstName(String paramString) {
        this.firstName = paramString;
    }

    public void setGender(String paramString) {
        this.gender = paramString;
    }

    public void setLanguage(String paramString) {
        this.language = paramString;
    }

    public void setLastActivity(long paramLong) {
        this.lastActivity = paramLong;
    }

    public void setLastActivityElapsed(String paramString) {
        this.lastActivityElapsed = paramString;
    }

    public void setLastName(String paramString) {
        this.lastName = paramString;
    }

    public void setLink(String paramString) {
        this.link = paramString;
    }

    public void setLocale(String paramString) {
        this.locale = paramString;
    }

    public void setLocation(String paramString) {
        this.location = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setRegister(long paramLong) {
        this.register = paramLong;
    }

    public void setSignature(String paramString) {
        this.signature = paramString;
    }

    public void setStatusMessage(String paramString) {
        this.statusMessage = paramString;
    }

    public void updateProfile() {
        PrefsUtil localPrefsUtil = new PrefsUtil(Prefs.get(this.mActivity));
        setAuId(localPrefsUtil.getInt("tapatalk_au_id", 0));
        setCover(localPrefsUtil.getString("tapatalk_cover", ""));
        setAvatar(localPrefsUtil.getString("tapatalk_avatar", ""));
        setAvatarUrl(localPrefsUtil.getString("tapatalk_avatar_url", ""));
        setGender(localPrefsUtil.getString("tapatalk_gender", ""));
        setLink(localPrefsUtil.getString("tapatalk_link", ""));
        setFirstName(localPrefsUtil.getString("tapatalk_first_name", ""));
        setLastName(localPrefsUtil.getString("tapatalk_last_name", ""));
        setName(localPrefsUtil.getString("tapatalk_name", ""));
        setBirthday(localPrefsUtil.getString("tapatalk_birthday", ""));
        setLocation(localPrefsUtil.getString("tapatalk_location", ""));
        setLocale(localPrefsUtil.getString("tapatalk_locale", ""));
        setDescription(localPrefsUtil.getString("tapatalk_description", ""));
        setSignature(localPrefsUtil.getString("tapatalk_signature", ""));
        setStatusMessage(localPrefsUtil.getString("tapatalk_status_message", ""));
        setLanguage(localPrefsUtil.getString("tapatalk_language", ""));
        setRegister(localPrefsUtil.getLong("tapatalk_register", 0L));
        setLastActivity(localPrefsUtil.getLong("tapatalk_last_activity", 0L));
        setLastActivityElapsed(Util.getTimeString(this.mActivity, (int) getLastActivity()));
    }

    public void updateProfile(JSONObject paramJSONObject) {
    }

    public boolean uploadDescription() {
        if (this.mDescriptionEt == null) {
        }
        while (!this.mDescriptionHasChanged) {
            return false;
        }
        this.mDescriptionHasChanged = false;
        Util.hideSoftKeyb(this.mActivity, this.mDescriptionEt);
        this.mDescriptionEt.clearFocus();
        Object localObject1 = this.mDescriptionEt.getText();
        Object localObject2 = (ImageSpan[]) ((Editable) localObject1).getSpans(0, ((Editable) localObject1).length(), ImageSpan.class);
        int i = 0;
        for (; ; ) {
            final String str;
            if (i >= localObject2.length) {
                localObject1 = ((Editable) localObject1).toString().replaceAll("<br />", "\n");
                str = getDescription();
                setDescriptionWithPref((String) localObject1);
            }
            try {
                localObject2 = URLEncoder.encode((String) localObject1, "UTF-8");
                localObject1 = localObject2;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                }
            }
            localObject2 = new HashMap();
            ((HashMap) localObject2).put("description", localObject1);
            localObject1 = DirectoryUrlUtil.getUploadProfileUrl(this.mActivity, (HashMap) localObject2);
            new TapatalkAjaxAction(this.mActivity).getJsonObjectAction((String) localObject1, new TapatalkAjaxAction.ActionCallBack() {
                private void uploadFailed() {
                    Toast.makeText(Profile.this.mActivity, Profile.this.mActivity.getString(2131100908), 1).show();
                    Profile.this.setDescriptionWithPref(str);
                }

                public void actionCallBack(Object paramAnonymousObject) {
                    if (paramAnonymousObject == null) {
                        uploadFailed();
                    }
                    while (new JSONUtil((JSONObject) paramAnonymousObject).optBoolean("result", Boolean.valueOf(false)).booleanValue()) {
                        return;
                    }
                    uploadFailed();
                }
            });
            return true;
            ((Editable) localObject1).replace(((Editable) localObject1).getSpanStart(localObject2[i]), ((Editable) localObject1).getSpanEnd(localObject2[i]), "[" + localObject2[i].getSource() + "]");
            i += 1;
        }
    }

    private static class ProfileViewHolder {
        ImageView avatarImg;
        EditText descriptionEt;
        View dividerView;
        Button editBtn;
        View mainArea;
        TextView moreInfoTv;
        TextView nameTv;
    }

    public static abstract interface UploadAvatarCallback {
        public abstract void callback();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/bean/Profile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */