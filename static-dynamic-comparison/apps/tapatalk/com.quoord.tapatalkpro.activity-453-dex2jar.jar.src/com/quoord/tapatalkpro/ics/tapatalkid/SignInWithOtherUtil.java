package com.quoord.tapatalkpro.ics.tapatalkid;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.google.android.gcm.GCMRegistrar;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.tapatalkHD.MainActivity;
import com.quoord.tapatalkHD.TwiterOauthActivity;
import com.quoord.tapatalkpro.activity.directory.migration.MigrationActivity;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.TagUtil;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.Util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class SignInWithOtherUtil {
    public static final String CLOSEPROGRESS = "closepress";
    public static final int INNER_MSG_FALSE = 0;
    public static final int INNER_MSG_OK = 1;
    public static final int SHOWTOAST = 25;
    public static final int STARTCALLGOOGLE = 24;
    public static final String TAG_Handle = "handle";
    public static final String TAG_NAMETOBE = "nametobe";
    public static final String TAG_OauthData = "oauthdata";
    public static final String TAG_OauthEmail = "oauthemail";
    public static final String TAG_OauthName = "oauthname";
    public static final String TAG_OauthPassword = "oauthpassword";
    public static final String TAG_OauthToken = "oauthtoken";
    public static final String TAG_OauthTwitterSecret = "oauthtwittersecret";
    public static final String TAG_UPDATEUSERNAME = "showupdate";
    public static final String TAG_usernamekey = "trueusername";
    public static final String amazonType = "com.amazon.pim.account.google";
    public static String email_expression = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static final int facebookRequestCode = 100;
    public static String facebookString;
    public static String googleString;
    public static final String googleType = "com.google";
    public static String tapatalkIdString;
    public static final String twitterKey = "42no4eGBDGWOsNTd0COhGA";
    public static final int twitterRequestCode = 99;
    public static final String twitterSecret = "JSYMh6ng51DY4Q5mccn4ePVwi6bQD6KDuSJt7qh6B0";
    public static String twitterString = "Twitter";
    public static String unknow;
    String GOOGLE_AUTH_TOKEN_TYPE = "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";
    String GOOGLE_INSERT_YOUR_API_KEY = "AIzaSyArO2dMARBAzLH1WsXLn8x9C843qc77aj0";
    boolean hasEmail = false;
    boolean hasPass = false;
    AccountManager mAccountManager;
    public Activity mActivity;
    public String mData;
    EditText mEdit;
    public String mEmailString;
    public TapatalkJsonEngine mEngine = null;
    Account mGoogleEmailAccount;
    EditText mPass;
    public String mPassString;
    public Twitter mTwitter;
    EditText mUsername;
    public ProgressDialog mypDialog;
    public SharedPreferences prefs = null;
    public String screenName;
    public String token;
    public String token_secret;
    public RequestToken twitterRequestToken;
    private Handler uiHandler;
    public String username_expression = "[A-Za-z0-9_\\.\\s]{3,32}$";

    static {
        facebookString = "Facebook";
        googleString = "Google";
        unknow = "unkown";
        tapatalkIdString = "tapatalkId";
    }

    public SignInWithOtherUtil(Activity paramActivity) {
        this.mActivity = paramActivity;
        this.mAccountManager = AccountManager.get(this.mActivity);
    }

    public SignInWithOtherUtil(Activity paramActivity, TapatalkJsonEngine paramTapatalkJsonEngine, Handler paramHandler) {
        this.mActivity = paramActivity;
        this.mEngine = paramTapatalkJsonEngine;
        this.mAccountManager = AccountManager.get(this.mActivity);
        this.uiHandler = paramHandler;
    }

    public static boolean checkEmailFormat(String paramString) {
        return Pattern.compile(paramString).matcher(paramString).matches();
    }

    public static String createDefaultPassWord(int paramInt) {
        Random localRandom = null;
        char[] arrayOfChar4 = null;
        char[] arrayOfChar1 = null;
        char[] arrayOfChar2 = null;
        char[] arrayOfChar3 = null;
        if (paramInt < 4) {
            return null;
        }
        if (0 == 0) {
            localRandom = new Random();
            arrayOfChar4 = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            arrayOfChar1 = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            arrayOfChar2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            arrayOfChar3 = "0123456789".toCharArray();
        }
        char[] arrayOfChar5 = new char[paramInt];
        paramInt = 0;
        if (paramInt >= arrayOfChar5.length) {
            return new String(arrayOfChar5);
        }
        if (paramInt + 3 == arrayOfChar5.length) {
            arrayOfChar5[paramInt] = arrayOfChar1[localRandom.nextInt(25)];
        }
        for (; ; ) {
            paramInt += 1;
            break;
            if (paramInt + 2 == arrayOfChar5.length) {
                arrayOfChar5[paramInt] = arrayOfChar2[localRandom.nextInt(25)];
            } else if (paramInt + 1 == arrayOfChar5.length) {
                arrayOfChar5[paramInt] = arrayOfChar3[localRandom.nextInt(9)];
            } else {
                arrayOfChar5[paramInt] = arrayOfChar4[localRandom.nextInt(71)];
            }
        }
    }

    private String encodePara(String paramString) {
        return URLEncoder.encode(paramString);
    }

    public static String getUsernameToBe(Activity paramActivity) {
        paramActivity = Prefs.get(paramActivity);
        String str = paramActivity.getString("handle", "");
        if (!"".equals(str)) {
            return paramActivity.getString(str + "nametobe", "");
        }
        return "";
    }

    private void handleError(JSONObject paramJSONObject) {
        try {
            if (paramJSONObject.has("result_text")) {
                paramJSONObject = paramJSONObject.getString("result_text");
                Util.showToastForLong(this.mActivity, paramJSONObject);
            }
            return;
        } catch (Exception paramJSONObject) {
            paramJSONObject.printStackTrace();
        }
    }

    public static boolean hasUsername(Activity paramActivity) {
        return true;
    }

    public static String readStream(InputStream paramInputStream)
            throws Exception {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte['Ѐ'];
        for (; ; ) {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
                localByteArrayOutputStream.close();
                paramInputStream.close();
                return localByteArrayOutputStream.toString();
            }
            localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
    }

    private void saveOauthData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this.prefs = Prefs.get(this.mActivity);
        paramString1 = this.prefs.edit();
        paramString1.putString("oauthname", this.screenName);
        paramString1.putString("oauthemail", paramString5);
        paramString1.putString("oauthtoken", paramString3);
        paramString1.putString("oauthtwittersecret", paramString4);
        paramString1.putString("oauthpassword", paramString6);
        paramString1.putString("oauthdata", paramString7);
        paramString1.commit();
    }

    private void setHasEmailAndHasPass(JSONObject paramJSONObject) {
        try {
            if (paramJSONObject.has("request_email")) {
            }
            for (this.hasEmail = paramJSONObject.getBoolean("request_email"); paramJSONObject.has("request_tapatalk_id_password"); this.hasEmail = false) {
                this.hasPass = paramJSONObject.getBoolean("request_tapatalk_id_password");
                return;
            }
            this.hasPass = false;
        } catch (Exception paramJSONObject) {
            paramJSONObject.printStackTrace();
            return;
        }
    }

    private void setUsernameToBe(String paramString) {
        Object localObject = Prefs.get(this.mActivity);
        String str = ((SharedPreferences) localObject).getString("handle", "");
        if (!"".equals(str)) {
            localObject = ((SharedPreferences) localObject).edit();
            ((SharedPreferences.Editor) localObject).putString(str + "nametobe", paramString);
            ((SharedPreferences.Editor) localObject).commit();
        }
    }

    private void showEmailDialog() {
        closeProgress();
        this.mPassString = null;
        this.mPass = null;
        Object localObject = new AlertDialog.Builder(this.mActivity);
        if ((this.hasEmail) && (this.hasPass)) {
            ((AlertDialog.Builder) localObject).setTitle(this.mActivity.getResources().getString(2131100471));
            ((AlertDialog.Builder) localObject).setMessage(this.mActivity.getResources().getString(2131100472));
        }
        for (; ; ) {
            LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
            localLinearLayout.setPadding(30, 10, 30, 10);
            localLinearLayout.setOrientation(1);
            if (this.hasEmail) {
                this.mEdit = new EditText(this.mActivity);
                this.mEdit.setInputType(32);
                this.mEdit.setHint("name@example.com");
                this.mEdit.requestFocus();
                localLinearLayout.addView(this.mEdit, localLayoutParams);
            }
            if (this.hasPass) {
                this.mPass = new EditText(this.mActivity);
                this.mPass.setInputType(224);
                this.mPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                if (this.hasEmail) {
                    this.mEdit.setText(this.mEmailString);
                    this.mEdit.setEnabled(false);
                    this.mPass.requestFocus();
                }
                localLinearLayout.addView(this.mPass, localLayoutParams);
            }
            ((AlertDialog.Builder) localObject).setView(localLinearLayout);
            ((AlertDialog.Builder) localObject).setPositiveButton(this.mActivity.getString(2131100459), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    if (SignInWithOtherUtil.this.mEdit != null) {
                        SignInWithOtherUtil.this.mEmailString = SignInWithOtherUtil.this.mEdit.getText().toString();
                    }
                    if (SignInWithOtherUtil.this.mPass != null) {
                        SignInWithOtherUtil.this.mPassString = SignInWithOtherUtil.this.mPass.getText().toString();
                    }
                    if ((SignInWithOtherUtil.this.hasEmail) && (SignInWithOtherUtil.this.hasPass)) {
                        if ((SignInWithOtherUtil.this.mEmailString != null) && (!"".equals(SignInWithOtherUtil.this.mEmailString)) && (SignInWithOtherUtil.this.stringFormat(SignInWithOtherUtil.this.mEmailString, SignInWithOtherUtil.email_expression)) && (SignInWithOtherUtil.this.mPassString != null) && (!"".equals(SignInWithOtherUtil.this.mPassString))) {
                            SignInWithOtherUtil.this.callLoginfromEmailEdit();
                        }
                    }
                    do {
                        return;
                        SignInWithOtherUtil.this.showEmailDialog();
                        return;
                        if (SignInWithOtherUtil.this.hasEmail) {
                            if ((SignInWithOtherUtil.this.mEmailString != null) && (!"".equals(SignInWithOtherUtil.this.mEmailString)) && (SignInWithOtherUtil.this.stringFormat(SignInWithOtherUtil.this.mEmailString, SignInWithOtherUtil.email_expression))) {
                                SignInWithOtherUtil.this.callLoginfromEmailEdit();
                                return;
                            }
                            SignInWithOtherUtil.this.showEmailDialog();
                            return;
                        }
                    } while (!SignInWithOtherUtil.this.hasPass);
                    if ((SignInWithOtherUtil.this.mPassString != null) && (!"".equals(SignInWithOtherUtil.this.mPassString))) {
                        SignInWithOtherUtil.this.callLoginfromEmailEdit();
                        return;
                    }
                    SignInWithOtherUtil.this.showEmailDialog();
                }
            });
            ((AlertDialog.Builder) localObject).setNegativeButton(this.mActivity.getString(2131100460), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    SignInWithOtherUtil.this.closeProgress();
                }
            });
            localObject = ((AlertDialog.Builder) localObject).create();
            ((AlertDialog) localObject).setCanceledOnTouchOutside(false);
            ((AlertDialog) localObject).show();
            return;
            if (this.hasEmail) {
                ((AlertDialog.Builder) localObject).setTitle(this.mActivity.getResources().getString(2131100473));
                ((AlertDialog.Builder) localObject).setMessage(this.mActivity.getResources().getString(2131100474));
            } else if (this.hasPass) {
                ((AlertDialog.Builder) localObject).setTitle(this.mActivity.getResources().getString(2131100479));
            }
        }
    }

    private void writeToPres(ArrayList paramArrayList) {
        writeToPres((JSONObject) paramArrayList.get(1));
    }

    public void callFacebookVerify() {
        Intent localIntent = new Intent();
        localIntent.setClass(this.mActivity, MainActivity.class);
        this.mActivity.startActivityForResult(localIntent, 100);
    }

    public void callFacebookVerify(Fragment paramFragment) {
        Intent localIntent = new Intent();
        localIntent.setClass(paramFragment.getActivity(), MainActivity.class);
        paramFragment.startActivityForResult(localIntent, 100);
    }

    public void callLoginfromEmailEdit() {
        showProgress();
        if (twitterString.equals(this.prefs.getString("handle", ""))) {
            callSignInTapatalkIDWithTwitter(this.screenName, this.token, this.token_secret, this.mEmailString, this.mPassString, this.mData);
        }
        do {
            return;
            if (facebookString.equals(this.prefs.getString("handle", ""))) {
                callSignInTapatalkIDWithFacebook(this.token, this.mEmailString, this.mPassString, this.screenName, this.mData);
                return;
            }
        } while (!googleString.equals(this.prefs.getString("handle", "")));
        callSignInTapatalkIDnWithGoogle(this.token, this.mEmailString, this.mPassString, this.screenName, this.mData);
    }

    public void callRetryLogin(ForumStatus paramForumStatus, TapatalkJsonEngine paramTapatalkJsonEngine) {
        this.prefs = Prefs.get(this.mActivity);
        paramForumStatus = this.prefs.getString("handle", "");
        String str1 = this.prefs.getString("oauthname", "");
        String str2 = this.prefs.getString("oauthtoken", "");
        String str3 = this.prefs.getString("oauthtwittersecret", "");
        String str4 = this.prefs.getString("oauthemail", "");
        String str5 = this.prefs.getString("oauthpassword", "");
        String str6 = this.prefs.getString("oauthdata", "");
        if (twitterString.equals(paramForumStatus)) {
            callSignInTapatalkIDWithTwitter(str1, str2, str3, str4, str5, str6);
        }
        do {
            return;
            if (googleString.equals(paramForumStatus)) {
                callSignInTapatalkIDnWithGoogle(str2, str4, str5, str1, str6);
                return;
            }
            if (facebookString.equals(paramForumStatus)) {
                callSignInTapatalkIDWithFacebook(str2, str4, str5, str1, str6);
                return;
            }
        } while (paramTapatalkJsonEngine == null);
        callSignIn(str1, str4, str5, paramTapatalkJsonEngine);
    }

    public void callSignIn(String paramString1, String paramString2, String paramString3, TapatalkJsonEngine paramTapatalkJsonEngine) {
        this.prefs = Prefs.get(this.mActivity);
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString("oauthpassword", paramString3);
        String str = TapatalkJsonEngine.SIGNIN + "?password=" + Util.getMD5(paramString3);
        paramString3 = str;
        if (Util.checkString(paramString2)) {
            localEditor.putString("oauthemail", paramString2);
            paramString3 = str + "&email=" + URLEncoder.encode(paramString2);
        }
        str = paramString3;
        if (Util.checkString(paramString1)) {
            localEditor.putString("oauthname", paramString1);
            str = paramString3 + "&username=" + URLEncoder.encode(paramString1);
        }
        paramString3 = str;
        if (Util.checkString(paramString2)) {
            paramString3 = str;
            if (Util.checkString(paramString1)) {
                paramString3 = str + "&reg_verify=1";
            }
        }
        paramString1 = paramString3 + "&language=" + Util.getDeviceLanguage(this.mActivity);
        localEditor.commit();
        if (paramTapatalkJsonEngine != null) {
            paramTapatalkJsonEngine.call(paramString1);
        }
        for (; ; ) {
            showProgress();
            return;
            this.mEngine.call(paramString1);
        }
    }

    public void callSignInTapatalkIDWithFacebook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        String str = TapatalkJsonEngine.SIGNINWITHFACEBOOK + "?" + "oauth_token=" + encodePara(paramString1) + "&" + "handle=" + encodePara(paramString4) + "&language=" + Util.getDeviceLanguage(this.mActivity) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
        saveOauthData(facebookString, paramString4, paramString1, null, paramString2, paramString3, paramString5);
        Util.checkString(paramString5);
        paramString1 = str;
        if (Util.checkString(paramString2)) {
            paramString1 = str + "&email=" + encodePara(paramString2);
        }
        paramString2 = paramString1;
        if (Util.checkString(paramString3)) {
            paramString2 = paramString1 + "&password=" + encodePara(paramString3);
        }
        paramString3 = GCMRegistrar.getRegistrationId(this.mActivity);
        paramString1 = paramString2;
        if (!paramString3.equals("")) {
            paramString1 = new StringBuilder(String.valueOf(paramString2)).append("&push_token=").append(paramString3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&device_type=" + Util.getDeviceName();
        }
        this.mEngine.call(paramString1);
    }

    public void callSignInTapatalkIDWithFacebookForTwitterMigration(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        String str = TapatalkJsonEngine.SIGNINWITHFACEBOOK + "?" + "oauth_token=" + encodePara(paramString1) + "&" + "handle=" + encodePara(paramString4) + "&language=" + Util.getDeviceLanguage(this.mActivity) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
        saveOauthData(facebookString, paramString4, paramString1, null, paramString2, paramString3, paramString5);
        paramString1 = str;
        if (Util.checkString(paramString2)) {
            paramString1 = str + "&email=" + encodePara(paramString2);
        }
        paramString2 = paramString1;
        if (Util.checkString(paramString3)) {
            paramString2 = paramString1 + "&password=" + encodePara(paramString3);
        }
        paramString3 = GCMRegistrar.getRegistrationId(this.mActivity);
        paramString1 = paramString2;
        if (!paramString3.equals("")) {
            paramString1 = new StringBuilder(String.valueOf(paramString2)).append("&push_token=").append(paramString3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&device_type=" + Util.getDeviceName();
        }
        paramString2 = TapatalkIdFactory.getTapatalkId(this.mActivity);
        paramString1 = paramString1 + "&from_twitter=1&au_id=" + paramString2.getAuid() + "&token=" + paramString2.getToken();
        this.mEngine.call(paramString1);
    }

    public void callSignInTapatalkIDWithTwitter(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        String str = TapatalkJsonEngine.SIGNINWITHTWITTER + "?" + "handle=" + encodePara(paramString1) + "&" + "oauth_token=" + encodePara(paramString2) + "&oauth_token_secret=" + encodePara(paramString3) + "&language=" + Util.getDeviceLanguage(this.mActivity) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
        saveOauthData(twitterString, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
        Util.checkString(paramString6);
        paramString1 = str;
        if (Util.checkString(paramString4)) {
            paramString1 = str + "&email=" + encodePara(paramString4);
        }
        paramString2 = paramString1;
        if (Util.checkString(paramString5)) {
            paramString2 = paramString1 + "&password=" + encodePara(paramString5);
        }
        paramString3 = GCMRegistrar.getRegistrationId(this.mActivity);
        paramString1 = paramString2;
        if (!paramString3.equals("")) {
            paramString1 = new StringBuilder(String.valueOf(paramString2)).append("&push_token=").append(paramString3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&device_type=" + Util.getDeviceName();
        }
        this.mEngine.call(paramString1);
    }

    public void callSignInTapatalkIDnWithGoogle(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        String str = TapatalkJsonEngine.SIGNINWITHGOOGLE + "?" + "oauth_token=" + encodePara(paramString1) + "&" + "handle=" + encodePara(paramString4) + "&language=" + Util.getDeviceLanguage(this.mActivity) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
        saveOauthData(googleString, paramString4, paramString1, null, paramString2, paramString3, paramString5);
        paramString1 = str;
        if (Util.checkString(paramString2)) {
            paramString1 = str + "&email=" + encodePara(paramString2);
        }
        paramString2 = paramString1;
        if (Util.checkString(paramString3)) {
            paramString2 = paramString1 + "&password=" + encodePara(paramString3);
        }
        paramString2 = paramString2 + "&is_plus=1";
        paramString3 = GCMRegistrar.getRegistrationId(this.mActivity);
        paramString1 = paramString2;
        if (!paramString3.equals("")) {
            paramString1 = new StringBuilder(String.valueOf(paramString2)).append("&push_token=").append(paramString3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&device_type=" + Util.getDeviceName();
        }
        TagUtil.logFor("google url是" + paramString1);
        this.mEngine.call(paramString1);
    }

    public void callSignInTapatalkIDnWithGoogleForTwitterMigration(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
        String str = TapatalkJsonEngine.SIGNINWITHGOOGLE + "?" + "oauth_token=" + encodePara(paramString1) + "&" + "handle=" + encodePara(paramString4) + "&language=" + Util.getDeviceLanguage(this.mActivity) + "&timezone=" + TimeZone.getDefault().getRawOffset() / 1000;
        saveOauthData(googleString, paramString4, paramString1, null, paramString2, paramString3, paramString5);
        paramString1 = str;
        if (Util.checkString(paramString2)) {
            paramString1 = str + "&email=" + encodePara(paramString2);
        }
        paramString2 = paramString1;
        if (Util.checkString(paramString3)) {
            paramString2 = paramString1 + "&password=" + encodePara(paramString3);
        }
        paramString2 = paramString2 + "&is_plus=1";
        paramString3 = GCMRegistrar.getRegistrationId(this.mActivity);
        paramString1 = paramString2;
        if (!paramString3.equals("")) {
            paramString1 = new StringBuilder(String.valueOf(paramString2)).append("&push_token=").append(paramString3).toString() + "&device_id=" + Util.getMD5(Util.getMacAddress(this.mActivity)) + "&device_type=" + Util.getDeviceName();
        }
        paramString2 = TapatalkIdFactory.getTapatalkId(this.mActivity);
        paramString1 = paramString1 + "&from_twitter=1&au_id=" + paramString2.getAuid() + "&token=" + paramString2.getToken();
        TagUtil.logFor("google url是" + paramString1);
        this.mEngine.call(paramString1);
    }

    public void callTwitterVerify() {
        try {
            showProgress();
            ConfigurationBuilder localConfigurationBuilder = new ConfigurationBuilder();
            localConfigurationBuilder.setOAuthConsumerKey("42no4eGBDGWOsNTd0COhGA");
            localConfigurationBuilder.setOAuthConsumerSecret("JSYMh6ng51DY4Q5mccn4ePVwi6bQD6KDuSJt7qh6B0");
            this.mTwitter = new TwitterFactory(localConfigurationBuilder.build()).getInstance();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        SignInWithOtherUtil.this.twitterRequestToken = SignInWithOtherUtil.this.mTwitter.getOAuthRequestToken("http://tapatalk.com");
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (SignInWithOtherUtil.this.twitterRequestToken != null) {
                                    Intent localIntent = new Intent(SignInWithOtherUtil.this.mActivity, TwiterOauthActivity.class);
                                    localIntent.putExtra("url", SignInWithOtherUtil.this.twitterRequestToken.getAuthenticationURL());
                                    localIntent.putExtra("token", SignInWithOtherUtil.this.twitterRequestToken);
                                    SignInWithOtherUtil.this.mActivity.startActivityForResult(localIntent, 99);
                                }
                            }
                        });
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }).start();
            return;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public void callTwitterVerify(final Fragment paramFragment) {
        try {
            showProgress();
            ConfigurationBuilder localConfigurationBuilder = new ConfigurationBuilder();
            localConfigurationBuilder.setOAuthConsumerKey("42no4eGBDGWOsNTd0COhGA");
            localConfigurationBuilder.setOAuthConsumerSecret("JSYMh6ng51DY4Q5mccn4ePVwi6bQD6KDuSJt7qh6B0");
            this.mTwitter = new TwitterFactory(localConfigurationBuilder.build()).getInstance();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        SignInWithOtherUtil.this.twitterRequestToken = SignInWithOtherUtil.this.mTwitter.getOAuthRequestToken("http://tapatalk.com");
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                if (SignInWithOtherUtil.this.twitterRequestToken != null) {
                                    Intent localIntent = new Intent(SignInWithOtherUtil.this.mActivity, TwiterOauthActivity.class);
                                    localIntent.putExtra("url", SignInWithOtherUtil.this.twitterRequestToken.getAuthenticationURL());
                                    localIntent.putExtra("token", SignInWithOtherUtil.this.twitterRequestToken);
                                    this.val$frag.startActivityForResult(localIntent, 99);
                                }
                            }
                        });
                        return;
                    } catch (Exception localException) {
                        localException.printStackTrace();
                    }
                }
            }).start();
            return;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public void callUpdateUsername(String paramString) {
        this.prefs = Prefs.get(this.mActivity);
        paramString = "https://directory.tapatalk.com/au_update_profile.php?username=" + encodePara(paramString.trim()) + "&" + "token=" + encodePara(this.prefs.getString("token", "")) + "&" + "au_id=" + encodePara(new StringBuilder(String.valueOf(this.prefs.getInt("tapatalk_auid", 0))).toString());
        this.mEngine.call(paramString);
    }

    public boolean canHandleResult(ArrayList paramArrayList) {
        if (!paramArrayList.get(0).toString().startsWith("https")) {
        }
        do {
            return false;
            paramArrayList = (JSONObject) paramArrayList.get(1);
        } while ((!paramArrayList.has("vip")) || (!paramArrayList.has("has_accounts")));
        return true;
    }

    public void closeProgress() {
        if ((this.mypDialog != null) && (this.mypDialog.isShowing())) {
            this.mypDialog.cancel();
        }
    }

    public void getFacebookInfo(Intent paramIntent) {
        this.token = paramIntent.getStringExtra("token");
        this.mEmailString = paramIntent.getStringExtra("email");
        this.screenName = paramIntent.getStringExtra("name");
        setUsernameToBe(this.screenName);
        this.mData = paramIntent.getStringExtra("data");
    }

    public ProgressDialog getMypDialog() {
        return this.mypDialog;
    }

    public void getTwitterInfo(final String paramString, final Handler paramHandler, final RequestToken paramRequestToken) {
        new Thread() {
            public void run() {
                try {
                    Object localObject;
                    if (SignInWithOtherUtil.this.mTwitter == null) {
                        localObject = new ConfigurationBuilder();
                        ((ConfigurationBuilder) localObject).setOAuthConsumerKey("42no4eGBDGWOsNTd0COhGA");
                        ((ConfigurationBuilder) localObject).setOAuthConsumerSecret("JSYMh6ng51DY4Q5mccn4ePVwi6bQD6KDuSJt7qh6B0");
                        localObject = new TwitterFactory(((ConfigurationBuilder) localObject).build());
                        SignInWithOtherUtil.this.mTwitter = ((TwitterFactory) localObject).getInstance();
                    }
                    if ((Util.checkString(paramString)) && (paramRequestToken != null)) {
                        localObject = SignInWithOtherUtil.this.mTwitter.getOAuthAccessToken(paramRequestToken, paramString);
                        if (localObject != null) {
                            SignInWithOtherUtil.this.mTwitter.setOAuthAccessToken((AccessToken) localObject);
                            SignInWithOtherUtil.this.mTwitter.getUserTimeline();
                            User localUser = SignInWithOtherUtil.this.mTwitter.showUser(((AccessToken) localObject).getUserId());
                            SignInWithOtherUtil.this.mTwitter.getAuthorization();
                            SignInWithOtherUtil.this.mData = localUser.toString().replaceFirst("UserJSONImpl", "");
                            SignInWithOtherUtil.this.screenName = localUser.getScreenName();
                            SignInWithOtherUtil.this.setUsernameToBe(SignInWithOtherUtil.this.screenName);
                            SignInWithOtherUtil.this.token = ((AccessToken) localObject).getToken();
                            SignInWithOtherUtil.this.token_secret = ((AccessToken) localObject).getTokenSecret();
                            localObject = paramHandler.obtainMessage();
                            ((Message) localObject).what = 1;
                            paramHandler.dispatchMessage((Message) localObject);
                            return;
                        }
                        localObject = paramHandler.obtainMessage();
                        ((Message) localObject).what = 0;
                        paramHandler.dispatchMessage((Message) localObject);
                        return;
                    }
                } catch (TwitterException localTwitterException) {
                    Message localMessage = paramHandler.obtainMessage();
                    localMessage.what = 0;
                    paramHandler.dispatchMessage(localMessage);
                }
            }
        }.start();
    }

    public void handleFacebookLogin(EngineResponse paramEngineResponse) {
        writeHandle(facebookString);
        try {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            if (paramEngineResponse.getBoolean("result")) {
                setHasEmailAndHasPass(paramEngineResponse);
                if ((this.hasEmail) || (this.hasPass)) {
                    showEmailDialog();
                    return;
                }
                this.mEmailString = paramEngineResponse.getString("email");
                this.screenName = paramEngineResponse.getString("username");
                writeToPres(paramEngineResponse);
                paramEngineResponse = paramEngineResponse.getString("result_text");
                Util.showToastForLong(this.mActivity, paramEngineResponse);
                return;
            }
        } catch (JSONException paramEngineResponse) {
            paramEngineResponse.printStackTrace();
            return;
        }
        if (paramEngineResponse.has("result_text")) {
            handleError(paramEngineResponse);
        }
    }

    public void handleGoogleLogin(EngineResponse paramEngineResponse) {
        writeHandle(googleString);
        try {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            if (paramEngineResponse.getBoolean("result")) {
                setHasEmailAndHasPass(paramEngineResponse);
                if ((this.hasEmail) || (this.hasPass)) {
                    showEmailDialog();
                    return;
                }
                this.mEmailString = paramEngineResponse.getString("email");
                this.screenName = paramEngineResponse.getString("username");
                writeToPres(paramEngineResponse);
                paramEngineResponse = paramEngineResponse.getString("result_text");
                Util.showToastForLong(this.mActivity, paramEngineResponse);
                return;
            }
        } catch (JSONException paramEngineResponse) {
            paramEngineResponse.printStackTrace();
            return;
        }
        if (paramEngineResponse.has("result_text")) {
            handleError(paramEngineResponse);
        }
    }

    public boolean handleLoginResultRetry(EngineResponse paramEngineResponse) {
        this.prefs = Prefs.get(this.mActivity);
        String str = this.prefs.getString("handle", "");
        JSONObject localJSONObject = (JSONObject) paramEngineResponse.getResponse();
        do {
            try {
                boolean bool = localJSONObject.getBoolean("result");
                if (!bool) {
                    return false;
                }
            } catch (Exception paramEngineResponse) {
                return false;
            }
            if (twitterString.equals(str)) {
                handleTwitterLogin(paramEngineResponse);
                return false;
            }
            if (googleString.equals(str)) {
                handleGoogleLogin(paramEngineResponse);
                return false;
            }
            if (facebookString.equals(str)) {
                handleFacebookLogin(paramEngineResponse);
                return false;
            }
        } while (!tapatalkIdString.equals(str));
        handleSingIn(localJSONObject);
        return false;
    }

    public void handleSingIn(JSONObject paramJSONObject) {
        try {
            if (paramJSONObject.getBoolean("result")) {
                this.screenName = paramJSONObject.getString("username");
                writeToPres(paramJSONObject);
                paramJSONObject = paramJSONObject.getString("result_text");
                Util.showToastForLong(this.mActivity, paramJSONObject);
                return;
            }
            handleError(paramJSONObject);
            return;
        } catch (JSONException paramJSONObject) {
            paramJSONObject.printStackTrace();
        }
    }

    public void handleTwitterLogin(EngineResponse paramEngineResponse) {
        writeHandle(twitterString);
        try {
            paramEngineResponse = (JSONObject) paramEngineResponse.getResponse();
            if (paramEngineResponse.getBoolean("result")) {
                setHasEmailAndHasPass(paramEngineResponse);
                if ((this.hasEmail) || (this.hasPass)) {
                    showEmailDialog();
                    return;
                }
                this.mEmailString = paramEngineResponse.getString("email");
                this.screenName = paramEngineResponse.getString("username");
                writeToPres(paramEngineResponse);
                paramEngineResponse = paramEngineResponse.getString("result_text");
                Util.showToastForLong(this.mActivity, paramEngineResponse);
                return;
            }
        } catch (JSONException paramEngineResponse) {
            paramEngineResponse.printStackTrace();
            return;
        }
        if (paramEngineResponse.has("result_text")) {
            handleError(paramEngineResponse);
        }
        setHasEmailAndHasPass(paramEngineResponse);
        if ((this.hasEmail) || (this.hasPass)) {
            showEmailDialog();
            return;
        }
        this.mEmailString = paramEngineResponse.getString("email");
        this.screenName = paramEngineResponse.getString("username");
        writeToPres(paramEngineResponse);
    }

    public boolean hasTapatalkIdUsername() {
        return Prefs.get(this.mActivity).getString("trueusername", "").length() > 0;
    }

    public void makeUpdateusernameDialogCannotShow() {
        SharedPreferences.Editor localEditor = Prefs.get(this.mActivity).edit();
        localEditor.putBoolean("showupdate", true);
        localEditor.commit();
    }

    public void setMypDialog(ProgressDialog paramProgressDialog) {
        this.mypDialog = paramProgressDialog;
    }

    public void showProgress() {
        try {
            if ((this.mypDialog == null) || (!this.mypDialog.isShowing())) {
                if (this.mypDialog == null) {
                    this.mypDialog = new ProgressDialog(this.mActivity);
                    this.mypDialog.setProgressStyle(0);
                    this.mypDialog.setMessage(this.mActivity.getResources().getString(2131100313));
                }
                if (!this.mActivity.isFinishing()) {
                    this.mypDialog.setIndeterminate(false);
                    this.mypDialog.setCanceledOnTouchOutside(false);
                    this.mypDialog.show();
                }
            }
            return;
        } catch (Exception localException) {
        }
    }

    public void showShouldSignInDialog() {
        Object localObject = new AlertDialog.Builder(this.mActivity);
        ((AlertDialog.Builder) localObject).setTitle(this.mActivity.getString(2131100475));
        ((AlertDialog.Builder) localObject).setMessage(this.mActivity.getString(2131100476));
        ((AlertDialog.Builder) localObject).setPositiveButton(this.mActivity.getString(2131100477), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.setClass(SignInWithOtherUtil.this.mActivity, ObEntryActivity.class);
                paramAnonymousDialogInterface.putExtra("innerLogin", true);
                SignInWithOtherUtil.this.mActivity.startActivity(paramAnonymousDialogInterface);
            }
        });
        ((AlertDialog.Builder) localObject).setNegativeButton(this.mActivity.getString(2131100478), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localObject = ((AlertDialog.Builder) localObject).create();
        ((AlertDialog) localObject).setCanceledOnTouchOutside(false);
        ((AlertDialog) localObject).show();
    }

    public void signinOnResult(int paramInt1, int paramInt2, Intent paramIntent) {
        if (paramInt1 == 99) {
            if (paramInt2 == -1) {
                try {
                    String str = paramIntent.getStringExtra("oauth_verifier");
                    paramIntent = (RequestToken) paramIntent.getSerializableExtra("token");
                    if ((str != null) && (!"".equals(str))) {
                        Handler local4 = new Handler() {
                            public void handleMessage(Message paramAnonymousMessage) {
                                switch (paramAnonymousMessage.what) {
                                    default:
                                        return;
                                    case 1:
                                        SignInWithOtherUtil.this.callSignInTapatalkIDWithTwitter(SignInWithOtherUtil.this.screenName, SignInWithOtherUtil.this.token, SignInWithOtherUtil.this.token_secret, null, null, SignInWithOtherUtil.this.mData);
                                        return;
                                }
                                paramAnonymousMessage = SignInWithOtherUtil.this.uiHandler.obtainMessage();
                                paramAnonymousMessage.what = 25;
                                paramAnonymousMessage.obj = SignInWithOtherUtil.this.mActivity.getResources().getString(2131100508);
                                SignInWithOtherUtil.this.uiHandler.dispatchMessage(paramAnonymousMessage);
                            }
                        };
                        showProgress();
                        getTwitterInfo(str, local4, paramIntent);
                        return;
                    }
                    closeProgress();
                    return;
                } catch (Exception paramIntent) {
                    paramIntent.printStackTrace();
                    return;
                }
            }
            closeProgress();
            return;
        }
        if (paramInt1 == 100) {
            if (paramInt2 == -1) {
                showProgress();
                getFacebookInfo(paramIntent);
                if ((this.mActivity instanceof MigrationActivity)) {
                    callSignInTapatalkIDWithFacebookForTwitterMigration(this.token, this.mEmailString, null, this.screenName, this.mData);
                    return;
                }
                callSignInTapatalkIDWithFacebook(this.token, this.mEmailString, null, this.screenName, this.mData);
                return;
            }
            closeProgress();
            Toast.makeText(this.mActivity, this.mActivity.getResources().getString(2131100508), 1).show();
            return;
        }
        closeProgress();
    }

    public boolean stringFormat(String paramString1, String paramString2) {
        return Pattern.compile(paramString2).matcher(paramString1).matches();
    }

    public void writeHandle(String paramString) {
        this.prefs = Prefs.get(this.mActivity);
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString("handle", paramString);
        localEditor.commit();
    }

    public void writeToPres(JSONObject paramJSONObject) {
        this.prefs = Prefs.get(this.mActivity);
        this.prefs.edit();
        TapatalkIdFactory.getTapatalkId(this.mActivity).saveTapatalkId(paramJSONObject);
    }

    public void writeToPresFromSave(String paramString) {
        this.prefs = Prefs.get(this.mActivity);
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putBoolean("login", this.prefs.getBoolean("login_save", false));
        localEditor.putString("trueusername", paramString);
        localEditor.commit();
    }

    public void writeUsername(String paramString) {
        this.prefs = Prefs.get(this.mActivity);
        SharedPreferences.Editor localEditor = this.prefs.edit();
        localEditor.putString("trueusername", paramString);
        localEditor.commit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/tapatalkid/SignInWithOtherUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */