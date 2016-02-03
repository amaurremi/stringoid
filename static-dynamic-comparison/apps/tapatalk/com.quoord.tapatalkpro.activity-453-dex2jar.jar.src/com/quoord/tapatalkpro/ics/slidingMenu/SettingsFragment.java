package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.provider.SearchRecentSuggestions;
import android.text.Editable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.quoord.DialogUtil.AccountDialog;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRebrandingEntryActivity;
import com.quoord.tapatalkpro.activity.directory.ics.TapatalkIdWebviewActivity;
import com.quoord.tapatalkpro.adapter.forum.ConfigAdapter;
import com.quoord.tapatalkpro.alarm.NotificationSetting;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.ui.ics.IQuoordInterface;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.io.File;
import java.util.ArrayList;

public class SettingsFragment
        extends PreferenceFragment
        implements Preference.OnPreferenceClickListener, IQuoordInterface {
    public static final String ABOUT = "prefernece.about";
    public static final String AVATAR = "prefernece.avatar";
    public static final String AVATAR_WITH_SLOWCONN = "prefernece.avatar.withslowconn";
    public static final String BBCODE = "preference.bbcode";
    public static final int CHANGE_ADVANCE_SAVE_FILE = 6;
    public static final int CHANGE_COLOR_MODE_DIALOG = 5;
    public static final int CHANGE_LANGUAGE_CONFIRM_DIALOG = 3;
    public static final int CHANGE_THEME_CONFIRM_DIALOG = 2;
    public static final String CLEANCACHE = "prefernece.cleancache";
    public static final String CLEANSEARCHHISTORY = "prefernece.cleansearchhistory";
    public static final int CLEAR_SHORTCUTS_CONFIRM_DIALOG = 1;
    public static final String COLORSTYLE = "prefernece.color_style";
    public static final String COLOR_IN_USE = "prefernece.color_in_use";
    public static final String CUSTOMERSIGNPREFENCE = "prefernece.customersignature";
    public static final String DOWNLOADLOCATION = "prefernece.download";
    private static String DOWNLOAD_LOCATION = "download";
    public static final String EXTSDCARD = "prefernece.extsd";
    public static final String FONTSIZE = "preference.fontsize";
    public static final String JUMPUNREAD = "prefernece.jumpunread";
    public static final String JUMP_NEWEST = "2";
    public static final String JUMP_OLDEST = "0";
    public static final String JUMP_UNREAD = "1";
    public static final String LICENSE = "prefernece.license";
    public static final String NOTIFICATION = "prefernece.notification";
    public static final String NOTIFICATIONS_SETTING = "prefernece.notification_setting";
    public static final String NOTIFICATION_FLAG = "notification_flag";
    public static final String NOTIFICATION_PHOTO_AND_ATTACHMENT = "notification_upload_image";
    public static final String NOTIFICATION_PHOTO_AND_ATTACHMENT_TITLE = "notification_upload_image_title";
    public static final String NOTIFICATION_RECOMMEND_FORUM = "notification_recommend_flag";
    public static final String NOTIFICATION_RECOMMEND_TOPIC = "notification_recommend_topic";
    public static final String PHOTO = "prefernece.photo";
    public static final String PHOTO_WITH_SLOWCONN = "prefernece.photo.withslowconn";
    public static final String POLICY = "prefernece.policy";
    public static final String POSTCOUNTPREF = "prefernece.postcount";
    public static final String POSTRELEASE_VISTOR = "prefernece.nativeads_vistorid";
    public static final String POSTRELEASE_VISTOR_STORED_TIME = "prefernece.nativeads_vistorid_stored_time";
    public static final int POST_PER_PAGE_CHOICE_1 = 10;
    public static final int POST_PER_PAGE_CHOICE_2 = 20;
    public static final int POST_PER_PAGE_CHOICE_3 = 30;
    public static final int POST_PER_PAGE_CHOICE_4 = 40;
    public static final int POST_PER_PAGE_CHOICE_5 = 50;
    public static final String PREFIX = "prefernece.prefix";
    public static final int RESET_CACHE_DIALOG = 7;
    public static final String RESOTRE_TIME = "prefernece.resotre_time";
    public static final String SELECT_BACKGROUND_COLOR_STYLE = "prefernece.colorstyle_select";
    public static final String SHOWQUICKREPLAY = "prefernece.show_quickreplay";
    public static final String SHOWQUICKREPLAYTITLE = "prefernece.show_quickreplay_title";
    public static final String SIGNOUT_TAPATALK_ID = "preference.signout_tapatalk_id";
    public static final String SIGNPREFENCE = "prefernece.signature_140624";
    public static final int SMART_TIME = 1;
    public static final int STANDARD_TIME = 0;
    public static final String STICK = "prefernece.stick";
    public static final String TABPREF = "prefernece.tab";
    public static final String TABPREF_TITLE = "prefernece.tab_title";
    public static final String TAB_BEHAVIOUR = "preference.tab_behaviour";
    public static final String THREADTHEME = "prefernece.threadtheme";
    public static final String TIMECHOICE = "prefernece.timechoice";
    public static final String TIMEFORMAT = "prefernece.timeformat";
    public static final String TIMEFORMATDEFAULT = "prefernece.default";
    public static final String TOPIC = "prefernece.topic";
    public static final String TOPIC_IMG = "prefernece.topic_img";
    public static final String TOPIC_IMG_WITH_SLOWCONN = "prefernece.topic_img.withslowconn";
    private ActionBar bar;
    private Boolean colorValue = Boolean.valueOf(false);
    EditTextPreference custmoerSign;
    private ForumStatus forumStatus;
    private boolean isOuter = true;
    private ListPreference ledChoices;
    private ListView lv;
    private Activity mActivity;
    private int menuId;
    SharedPreferences prefs;
    CheckBoxPreference recommendForumNotification;
    CheckBoxPreference recommendTopicNotification;
    PreferenceScreen root;
    private boolean showQuick_replay = false;
    private String title;
    private boolean uploadImage = false;

    private void addAbout() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100623);
        this.root.addPreference(localPreferenceCategory);
        Preference localPreference = new Preference(this.mActivity);
        localPreference.setTitle(2131100624);
        localPreference.setKey("prefernece.policy");
        localPreference.setOnPreferenceClickListener(this);
        localPreferenceCategory.addPreference(localPreference);
        localPreference = new Preference(this.mActivity);
        localPreference.setTitle(2131100625);
        localPreference.setKey("prefernece.license");
        localPreference.setOnPreferenceClickListener(this);
        localPreferenceCategory.addPreference(localPreference);
        localPreference = new Preference(this.mActivity);
        localPreference.setTitle(2131100626);
        localPreference.setKey("prefernece.about");
        localPreference.setOnPreferenceClickListener(this);
        localPreferenceCategory.addPreference(localPreference);
    }

    private void addAdvance() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100222);
        this.root.addPreference(localPreferenceCategory);
        if (Util.getExternalSDCard() != null) {
            localObject = new Preference(this.mActivity);
            ((Preference) localObject).setKey("prefernece.extsd");
            ((Preference) localObject).setDefaultValue("tapatalk");
            ((Preference) localObject).setSummary(this.prefs.getString("prefernece.download", ""));
            ((Preference) localObject).setTitle(2131100082);
            ((Preference) localObject).setOnPreferenceClickListener(this);
            localPreferenceCategory.addPreference((Preference) localObject);
            return;
        }
        Object localObject = new EditTextPreference(this.mActivity);
        ((EditTextPreference) localObject).setDefaultValue(DOWNLOAD_LOCATION);
        ((EditTextPreference) localObject).setKey("prefernece.download");
        ((EditTextPreference) localObject).setTitle(2131100081);
        ((EditTextPreference) localObject).setDialogTitle(2131100081);
        ((EditTextPreference) localObject).setSummary(getDownloadFolder(this.mActivity));
        ((EditTextPreference) localObject).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                paramAnonymousPreference.setSummary(paramAnonymousObject.toString());
                new Handler().post(new Runnable() {
                    public void run() {
                        ((InputMethodManager) SettingsFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SettingsFragment.this.getActivity().getCurrentFocus().getWindowToken(), 0);
                    }
                });
                return true;
            }
        });
        localPreferenceCategory.addPreference((Preference) localObject);
    }

    private void addImageLoad() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(this.mActivity.getString(2131099709));
        this.root.addPreference(localPreferenceCategory);
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.avatar");
        localCheckBoxPreference.setTitle(this.mActivity.getString(2131099718));
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
        localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.photo");
        localCheckBoxPreference.setTitle(this.mActivity.getString(2131099712));
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
        localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.topic_img");
        localCheckBoxPreference.setTitle(2131099715);
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                SettingsFragment.this.colorValue = ((Boolean) paramAnonymousObject);
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
    }

    private void addImageLoadWithSlowConnection() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(this.mActivity.getString(2131099710));
        localPreferenceCategory.setDefaultValue(this.mActivity.getString(2131099711));
        this.root.addPreference(localPreferenceCategory);
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.avatar.withslowconn");
        localCheckBoxPreference.setTitle(this.mActivity.getString(2131099718));
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
        localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.photo.withslowconn");
        localCheckBoxPreference.setTitle(this.mActivity.getString(2131099712));
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
        localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.topic_img.withslowconn");
        localCheckBoxPreference.setTitle(2131099715);
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
    }

    private void addSignature() {
        this.custmoerSign = new EditTextPreference(this.mActivity);
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(getText(2131100221).toString());
        this.root.addPreference(localPreferenceCategory);
        final NoneFormatSummaryListPreference localNoneFormatSummaryListPreference = new NoneFormatSummaryListPreference(this.mActivity);
        if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (TapatalkApp.signatureType == 0)) {
            localNoneFormatSummaryListPreference.setDefaultValue("0");
            localNoneFormatSummaryListPreference.setKey("prefernece.signature_140624");
            if (!getResources().getBoolean(2131558401)) {
                break label335;
            }
            localNoneFormatSummaryListPreference.setTitle("Signature");
            label120:
            localNoneFormatSummaryListPreference.setDialogTitle(2131099761);
            if ((this.forumStatus == null) || (this.forumStatus.getRebrandingConfig() == null) || (TapatalkApp.signatureType != 0)) {
                break label345;
            }
            localNoneFormatSummaryListPreference.setSummary(getSingature(this.mActivity, 0, this.forumStatus));
            label166:
            localNoneFormatSummaryListPreference.setEntries(getSingatureList(this.forumStatus));
            localNoneFormatSummaryListPreference.setEntryValues(2131492869);
            localNoneFormatSummaryListPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    if ((SettingsFragment.this.forumStatus != null) && (SettingsFragment.this.forumStatus.getRebrandingConfig() != null) && (TapatalkApp.signatureType == 0)) {
                        paramAnonymousPreference.setSummary(SettingsFragment.getSingature(SettingsFragment.this.mActivity, (String) paramAnonymousObject, 0, SettingsFragment.this.forumStatus));
                    }
                    while (!SettingsFragment.this.mActivity.getResources().getBoolean(2131558401)) {
                        if (!paramAnonymousObject.equals("3")) {
                            SettingsFragment.this.custmoerSign.setEnabled(false);
                            return true;
                            paramAnonymousPreference.setSummary(SettingsFragment.getSingature(SettingsFragment.this.mActivity, (String) paramAnonymousObject, 0, SettingsFragment.this.forumStatus));
                        } else {
                            SettingsFragment.this.custmoerSign.setEnabled(true);
                            return true;
                        }
                    }
                    if (!paramAnonymousObject.equals("2")) {
                        SettingsFragment.this.custmoerSign.setEnabled(false);
                        return true;
                    }
                    SettingsFragment.this.custmoerSign.setEnabled(true);
                    return true;
                }
            });
            localPreferenceCategory.addPreference(localNoneFormatSummaryListPreference);
            if (this.mActivity.getResources().getBoolean(2131558401)) {
                break label375;
            }
            if (this.prefs.getString("prefernece.signature_140624", "").equals("3")) {
                break label364;
            }
            this.custmoerSign.setEnabled(false);
        }
        for (; ; ) {
            this.custmoerSign.setKey("prefernece.customersignature");
            this.custmoerSign.setTitle(2131099762);
            this.custmoerSign.setDialogTitle(2131099762);
            this.custmoerSign.setSummary(this.prefs.getString("prefernece.customersignature", ""));
            this.custmoerSign.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    paramAnonymousPreference.setSummary(paramAnonymousObject.toString());
                    localNoneFormatSummaryListPreference.setSummary(paramAnonymousObject.toString());
                    new Handler().post(new Runnable() {
                        public void run() {
                            ((InputMethodManager) SettingsFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SettingsFragment.this.getActivity().getCurrentFocus().getWindowToken(), 0);
                        }
                    });
                    return true;
                }
            });
            localPreferenceCategory.addPreference(this.custmoerSign);
            return;
            localNoneFormatSummaryListPreference.setDefaultValue("0");
            break;
            label335:
            localNoneFormatSummaryListPreference.setTitle(2131099761);
            break label120;
            label345:
            localNoneFormatSummaryListPreference.setSummary(getSingature(this.mActivity, 1, this.forumStatus));
            break label166;
            label364:
            this.custmoerSign.setEnabled(true);
            continue;
            label375:
            if (!this.prefs.getString("prefernece.signature_140624", "").equals("2")) {
                this.custmoerSign.setEnabled(false);
            } else {
                this.custmoerSign.setEnabled(true);
            }
        }
    }

    private void addSignout() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100627);
        this.root.addPreference(localPreferenceCategory);
        Object localObject1 = "";
        TapatalkId localTapatalkId = TapatalkIdFactory.getTapatalkId(this.mActivity);
        Object localObject2;
        if (localTapatalkId != null) {
            localObject2 = localTapatalkId.getUsername();
            localObject1 = localObject2;
            if (Util.isEmpty((String) localObject2)) {
                localObject1 = localTapatalkId.getTapatalkIdEmail();
            }
            if (localObject1 == null) {
                break label166;
            }
        }
        label166:
        for (localObject1 = "(" + (String) localObject1 + ")"; ; localObject1 = "") {
            localObject2 = new Preference(this.mActivity);
            ((Preference) localObject2).setTitle(this.mActivity.getString(2131100297) + " " + (String) localObject1);
            ((Preference) localObject2).setKey("preference.signout_tapatalk_id");
            ((Preference) localObject2).setOnPreferenceClickListener(this);
            localPreferenceCategory.addPreference((Preference) localObject2);
            return;
        }
    }

    private void addTopicAndPost() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100220);
        this.root.addPreference(localPreferenceCategory);
        final Object localObject1 = new ListPreference(this.mActivity);
        ((ListPreference) localObject1).setEntries(2131492870);
        ((ListPreference) localObject1).setEntryValues(2131492871);
        ((ListPreference) localObject1).setDefaultValue("2");
        ((ListPreference) localObject1).setValue(getPrefix(this.mActivity));
        ((ListPreference) localObject1).setDialogTitle(2131100241);
        ((ListPreference) localObject1).setKey("prefernece.prefix");
        ((ListPreference) localObject1).setTitle(2131100241);
        ((ListPreference) localObject1).setSummary(((ListPreference) localObject1).getEntry());
        ((ListPreference) localObject1).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                int i = localObject1.findIndexOfValue(paramAnonymousObject.toString());
                paramAnonymousPreference.setSummary(localObject1.getEntries()[i]);
                return true;
            }
        });
        final Object localObject2 = new CheckBoxPreference(this.mActivity);
        ((CheckBoxPreference) localObject2).setKey("prefernece.timeformat");
        ((CheckBoxPreference) localObject2).setTitle(2131100072);
        if (is24TimeFormat(this.mActivity)) {
            ((CheckBoxPreference) localObject2).setSummary(this.mActivity.getString(2131100073));
            if (!DateFormat.is24HourFormat(this.mActivity)) {
                break label691;
            }
            ((CheckBoxPreference) localObject2).setDefaultValue(Boolean.valueOf(true));
            label179:
            ((CheckBoxPreference) localObject2).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(SettingsFragment.this.mActivity).edit();
                    localEditor.putBoolean("prefernece.default", true);
                    localEditor.commit();
                    if (((Boolean) paramAnonymousObject).booleanValue()) {
                        paramAnonymousPreference.setSummary(SettingsFragment.this.mActivity.getString(2131100073));
                        return true;
                    }
                    paramAnonymousPreference.setSummary(SettingsFragment.this.mActivity.getString(2131100074));
                    return true;
                }
            });
            localPreferenceCategory.addPreference((Preference) localObject2);
            if (this.isOuter) {
                localObject2 = new ListPreference(this.mActivity);
                ((ListPreference) localObject2).setTitle(2131100223);
                ((ListPreference) localObject2).setDialogTitle(2131100223);
                ((ListPreference) localObject2).setEntries(2131492864);
                ((ListPreference) localObject2).setEntryValues(2131492865);
                ((ListPreference) localObject2).setDefaultValue("1");
                ((ListPreference) localObject2).setKey("prefernece.timechoice");
                ((ListPreference) localObject2).setValue(getTimeString(this.mActivity));
                ((ListPreference) localObject2).setSummary(((ListPreference) localObject2).getEntry());
                ((ListPreference) localObject2).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                        int i = localObject2.findIndexOfValue(paramAnonymousObject.toString());
                        paramAnonymousPreference.setSummary(localObject2.getEntries()[i]);
                        return true;
                    }
                });
                localPreferenceCategory.addPreference((Preference) localObject2);
            }
            localObject2 = new ListPreference(this.mActivity);
            ((ListPreference) localObject2).setDefaultValue(getString(2131100227));
            ((ListPreference) localObject2).setEntries(2131492867);
            ((ListPreference) localObject2).setEntryValues(2131492867);
            ((ListPreference) localObject2).setDialogTitle(2131100226);
            ((ListPreference) localObject2).setKey("prefernece.postcount");
            ((ListPreference) localObject2).setTitle(2131100226);
            ((ListPreference) localObject2).setSummary(this.prefs.getString("prefernece.postcount", this.mActivity.getString(2131100227)) + " " + this.mActivity.getString(2131100232));
            ((ListPreference) localObject2).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    paramAnonymousPreference.setSummary(paramAnonymousObject.toString() + " " + SettingsFragment.this.mActivity.getString(2131100232));
                    return true;
                }
            });
            localPreferenceCategory.addPreference((Preference) localObject2);
            localObject2 = new ListPreference(this.mActivity);
            if (this.mActivity.getResources().getBoolean(2131558402)) {
                break label702;
            }
            ((ListPreference) localObject2).setDefaultValue(getString(2131100091));
            label465:
            ((ListPreference) localObject2).setKey("prefernece.jumpunread");
            ((ListPreference) localObject2).setTitle(2131100052);
            ((ListPreference) localObject2).setDialogTitle(2131100052);
            if (getResources().getBoolean(2131558402)) {
                break label716;
            }
            ((ListPreference) localObject2).setEntries(2131492879);
            ((ListPreference) localObject2).setEntryValues(2131492880);
            label512:
            ((ListPreference) localObject2).setDefaultValue("1");
            ((ListPreference) localObject2).setValue(getJump(this.mActivity));
            ((ListPreference) localObject2).setSummary(((ListPreference) localObject2).getEntry());
            ((ListPreference) localObject2).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    int i = localObject2.findIndexOfValue(paramAnonymousObject.toString());
                    paramAnonymousPreference.setSummary(localObject2.getEntries()[i]);
                    return true;
                }
            });
            localPreferenceCategory.addPreference((Preference) localObject2);
            localPreferenceCategory.addPreference((Preference) localObject1);
            localObject1 = new Preference(this.mActivity);
            ((Preference) localObject1).setTitle(2131100563);
            ((Preference) localObject1).setKey("prefernece.topic");
            ((Preference) localObject1).setOnPreferenceClickListener(this);
            localPreferenceCategory.addPreference((Preference) localObject1);
            localObject1 = new CheckBoxPreference(this.mActivity);
            ((CheckBoxPreference) localObject1).setKey("prefernece.stick");
            ((CheckBoxPreference) localObject1).setTitle(2131100325);
            ((CheckBoxPreference) localObject1).setDefaultValue(Boolean.valueOf(true));
            if (!isShowUnreadStick(this.mActivity)) {
                break label733;
            }
            ((CheckBoxPreference) localObject1).setSummary(this.mActivity.getString(2131100326));
        }
        for (; ; ) {
            ((CheckBoxPreference) localObject1).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    SettingsFragment.this.colorValue = ((Boolean) paramAnonymousObject);
                    if (SettingsFragment.this.colorValue.booleanValue()) {
                        paramAnonymousPreference.setSummary(SettingsFragment.this.mActivity.getString(2131100326));
                    }
                    for (; ; ) {
                        return true;
                        paramAnonymousPreference.setSummary(SettingsFragment.this.mActivity.getString(2131100327));
                    }
                }
            });
            localPreferenceCategory.addPreference((Preference) localObject1);
            return;
            ((CheckBoxPreference) localObject2).setSummary(this.mActivity.getString(2131100074));
            break;
            label691:
            ((CheckBoxPreference) localObject2).setDefaultValue(Boolean.valueOf(false));
            break label179;
            label702:
            ((ListPreference) localObject2).setDefaultValue(getString(2131100093));
            break label465;
            label716:
            ((ListPreference) localObject2).setEntries(2131492881);
            ((ListPreference) localObject2).setEntryValues(2131492882);
            break label512;
            label733:
            ((CheckBoxPreference) localObject1).setSummary(this.mActivity.getString(2131100327));
        }
    }

    private PreferenceScreen createPreferenceHierarchy() {
        this.root = getPreferenceManager().createPreferenceScreen(this.mActivity);
        this.prefs = PreferenceManager.getDefaultSharedPreferences(this.mActivity.getBaseContext());
        addLookAndFeel();
        if (this.isOuter) {
            addOuterSyncAndNotification();
        }
        for (; ; ) {
            if (this.isOuter) {
                addImageLoad();
                addImageLoadWithSlowConnection();
            }
            addTopicAndPost();
            addEditorItem();
            addSignature();
            addAdvance();
            if (this.isOuter) {
                addAbout();
                if ((Prefs.get(this.mActivity) != null) && (Prefs.get(this.mActivity).getBoolean("login", false))) {
                    addSignout();
                }
            }
            return this.root;
            addSyncAndNotification();
        }
    }

    public static String customSignature() {
        return "Sent from my " + Build.MODEL + " using " + TapatalkApp.rebranding_name + " mobile app";
    }

    public static String getAccountTabBehaviour(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("preference.tab_behaviour", "1");
    }

    public static String getColorInUse(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.color_in_use", "orange");
    }

    public static Boolean getColorMode(Context paramContext) {
        return Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.colorstyle_select", false));
    }

    public static String getDownloadFolder(Context paramContext) {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        if (!paramContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            return localSharedPreferences.getString("prefernece.download", DOWNLOAD_LOCATION);
        }
        return "download";
    }

    public static String getDownloadLocation(Context paramContext) {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        String str = "download";
        if (!paramContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            str = localSharedPreferences.getString("prefernece.download", DOWNLOAD_LOCATION);
        }
        if ((localSharedPreferences.getBoolean("prefernece.extsd", false)) && (Util.getExternalSDCard() != null)) {
            return Util.getExternalSDCard() + File.separator + str;
        }
        return Environment.getExternalStorageDirectory() + File.separator + str;
    }

    public static String getFont(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("preference.fontsize", "1");
    }

    public static int getFontSize(Context paramContext) {
        String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("preference.fontsize", "");
        if (str.equalsIgnoreCase("1")) {
            return (int) paramContext.getResources().getDimension(2131427387);
        }
        if (str.equalsIgnoreCase("2")) {
            return (int) paramContext.getResources().getDimension(2131427388);
        }
        if (str.equalsIgnoreCase("3")) {
            return (int) paramContext.getResources().getDimension(2131427389);
        }
        if (str.equalsIgnoreCase("0")) {
            return (int) paramContext.getResources().getDimension(2131427386);
        }
        return (int) paramContext.getResources().getDimension(2131427387);
    }

    public static String getInitialTab(Context paramContext, ForumStatus paramForumStatus) {
        paramForumStatus = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.tab|" + paramForumStatus.tapatalkForum.getId(), "");
        if (paramForumStatus.equalsIgnoreCase("0")) {
            return paramContext.getText(2131099822).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("1")) {
            return paramContext.getText(2131099821).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("2")) {
            return paramContext.getText(2131099823).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("3")) {
            return paramContext.getText(2131099981).toString();
        }
        return paramContext.getText(2131099822).toString();
    }

    public static String getInitialTabTitle(Context paramContext, ForumStatus paramForumStatus) {
        paramForumStatus = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.tab_title|" + paramForumStatus.tapatalkForum.getId(), "");
        if (paramForumStatus.equalsIgnoreCase("0")) {
            return paramContext.getText(2131099763).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("1")) {
            return paramContext.getText(2131099827).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("2")) {
            return paramContext.getText(2131099828).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("3")) {
            return paramContext.getText(2131099829).toString();
        }
        if (paramForumStatus.equalsIgnoreCase("4")) {
            return paramContext.getText(2131099830).toString();
        }
        return paramContext.getText(2131099763).toString();
    }

    public static String getJump(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.jumpunread", "1");
    }

    public static String getLandBehavior(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.jumpunread", "1");
    }

    public static int getPostPerPageChoice(Context paramContext) {
        String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.postcount", "");
        if (str.equalsIgnoreCase(paramContext.getResources().getString(2131100227))) {
        }
        do {
            return 10;
            if (str.equalsIgnoreCase(paramContext.getResources().getString(2131100228))) {
                return 20;
            }
            if (str.equalsIgnoreCase(paramContext.getResources().getString(2131100229))) {
                return 30;
            }
            if (str.equalsIgnoreCase(paramContext.getResources().getString(2131100230))) {
                return 40;
            }
        } while (!str.equalsIgnoreCase(paramContext.getResources().getString(2131100231)));
        return 50;
    }

    public static String getPrefix(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.prefix", "2");
    }

    public static long getRestoreTime(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("prefernece.resotre_time", -1L);
    }

    public static String getSingature(Context paramContext, int paramInt, ForumStatus paramForumStatus) {
        if (paramInt == 0) {
            return null;
        }
        return getSingature(paramContext, null, paramInt, paramForumStatus);
    }

    public static String getSingature(Context paramContext, String paramString, int paramInt, ForumStatus paramForumStatus) {
        String[] arrayOfString = paramContext.getResources().getStringArray(2131492868);
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        String str = paramString;
        if (paramString == null) {
            str = localSharedPreferences.getString("prefernece.signature_140624", "0");
        }
        if (str.equalsIgnoreCase("0")) {
            return null;
        }
        if (str.equalsIgnoreCase("1")) {
            if (!paramContext.getApplicationContext().getResources().getBoolean(2131558401)) {
                return String.format(arrayOfString[1], new Object[]{Build.MODEL});
            }
            if ((paramForumStatus != null) && (paramForumStatus.getRebrandingConfig() != null) && (TapatalkApp.singatureString != null) && (TapatalkApp.singatureString.length() > 0)) {
                return TapatalkApp.singatureString;
            }
            return customSignature();
        }
        if (str.equalsIgnoreCase("2")) {
            if (!paramContext.getApplicationContext().getResources().getBoolean(2131558401)) {
                return String.format(arrayOfString[2], new Object[]{Build.MODEL});
            }
            if (paramInt == 2) {
                return String.format(arrayOfString[1], new Object[]{Build.MODEL});
            }
            return localSharedPreferences.getString("prefernece.customersignature", "");
        }
        if (str.equalsIgnoreCase("3")) {
            if (paramInt == 2) {
                return String.format(arrayOfString[1], new Object[]{Build.MODEL});
            }
            return localSharedPreferences.getString("prefernece.customersignature", "");
        }
        if (!paramContext.getApplicationContext().getResources().getBoolean(2131558401)) {
            return String.format(arrayOfString[1], new Object[]{Build.MODEL});
        }
        return localSharedPreferences.getString("prefernece.customersignature", "");
    }

    public static String getTab(Context paramContext, ForumStatus paramForumStatus) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.tab|" + paramForumStatus.tapatalkForum.getId(), "0");
    }

    public static String getTheme(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.threadtheme", "0");
    }

    public static String getThemeSummary(Context paramContext) {
        PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.threadtheme", "0");
        return "";
    }

    public static String getTimeString(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.timechoice", "1");
    }

    public static int getTimeStyle(Context paramContext) {
        if (PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.timechoice", "").equalsIgnoreCase("0")) {
            return 1;
        }
        return 0;
    }

    public static String getVisitor(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.nativeads_vistorid", "");
    }

    public static long getVisitorStoredTime(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("prefernece.nativeads_vistorid_stored_time", 0L);
    }

    private void initActionbar() {
        this.bar.setNavigationMode(0);
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setIcon(2130837525);
        if ((this.title != null) && (!this.title.equals(""))) {
            this.bar.setTitle(this.title);
        }
        for (; ; ) {
            this.bar.setSubtitle(null);
            return;
            this.bar.setTitle(2131100000);
        }
    }

    public static boolean is24TimeFormat(Context paramContext) {
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        if (localSharedPreferences.getBoolean("prefernece.default", false)) {
            return localSharedPreferences.getBoolean("prefernece.timeformat", false);
        }
        return DateFormat.is24HourFormat(paramContext);
    }

    public static boolean isEnableBBCode(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("preference.bbcode", false);
    }

    public static boolean isEnableTopicImg(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.topic_img", true);
    }

    public static boolean isEnableTopicImgWithSlowConn(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.topic_img.withslowconn", false);
    }

    public static boolean isLightTheme(Context paramContext) {
        return !getColorMode(paramContext).booleanValue();
    }

    public static boolean isRebranding(Context paramContext) {
        try {
            boolean bool = paramContext.getResources().getBoolean(2131558401);
            return bool;
        } catch (Exception paramContext) {
        }
        return false;
    }

    public static boolean isShowAvatar(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.avatar", true);
    }

    public static boolean isShowAvatarWithSlowConn(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.avatar.withslowconn", true);
    }

    public static boolean isShowPhotos(Context paramContext) {
        return Prefs.get(paramContext).getBoolean("prefernece.photo", true);
    }

    public static boolean isShowPhotosWithSlowConn(Context paramContext) {
        return Prefs.get(paramContext).getBoolean("prefernece.photo.withslowconn", false);
    }

    public static boolean isShowThreadPrefix(Context paramContext) {
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.prefix", paramContext.getResources().getString(2131099770));
        if (paramContext.equalsIgnoreCase("0")) {
        }
        while (paramContext.equalsIgnoreCase("1")) {
            return false;
        }
        return paramContext.equalsIgnoreCase("2");
    }

    public static boolean isShowTopicPrefix(Context paramContext) {
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("prefernece.prefix", paramContext.getResources().getString(2131099770));
        if (paramContext.equalsIgnoreCase("0")) {
        }
        do {
            return false;
            if (paramContext.equalsIgnoreCase("1")) {
                return true;
            }
        } while (paramContext.equalsIgnoreCase("2"));
        return true;
    }

    public static boolean isShowUnreadStick(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.stick", true);
    }

    public static boolean isUseExternalSD(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.extsd", false);
    }

    public static SettingsFragment newInstance() {
        SettingsFragment localSettingsFragment = new SettingsFragment();
        localSettingsFragment.menuId = 0;
        localSettingsFragment.isOuter = true;
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isOuter", true);
        localSettingsFragment.setArguments(localBundle);
        return localSettingsFragment;
    }

    public static SettingsFragment newInstance(int paramInt, ForumStatus paramForumStatus) {
        SettingsFragment localSettingsFragment = new SettingsFragment();
        localSettingsFragment.menuId = paramInt;
        localSettingsFragment.isOuter = false;
        localSettingsFragment.forumStatus = paramForumStatus;
        Bundle localBundle = new Bundle();
        localBundle.putInt("menuId", paramInt);
        localBundle.putBoolean("isOuter", false);
        localBundle.putSerializable("forumStatus", paramForumStatus);
        localSettingsFragment.setArguments(localBundle);
        paramForumStatus.tapatalkForum.getId().intValue();
        return localSettingsFragment;
    }

    public static void setColorMode(Context paramContext, boolean paramBoolean) {
        PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean("prefernece.colorstyle_select", paramBoolean).commit();
    }

    public static void setLandBehavior(Context paramContext, String paramString) {
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        paramContext.putString("prefernece.jumpunread", paramString);
        paramContext.commit();
    }

    public static void setupAlarm(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("notificationsetting", 0);
        if (paramContext.getBoolean("notification_flag", true)) {
        }
        for (boolean bool = false; ; bool = true) {
            paramContext = paramContext.edit();
            paramContext.putBoolean("notification_flag", bool);
            paramContext.commit();
            return;
        }
    }

    public static void setupRecommendForumAlarm(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("notificationsetting", 0);
        paramContext.getBoolean("notification_flag", true);
        if (paramContext.getBoolean("notification_recommend_flag", true)) {
        }
        for (boolean bool = false; ; bool = true) {
            paramContext = paramContext.edit();
            paramContext.putBoolean("notification_recommend_flag", bool);
            paramContext.commit();
            return;
        }
    }

    public static void setupRecommendTopicAlarm(Context paramContext) {
        paramContext = paramContext.getSharedPreferences("notificationsetting", 0);
        paramContext.getBoolean("notification_flag", true);
        if (paramContext.getBoolean("notification_recommend_topic", true)) {
        }
        for (boolean bool = false; ; bool = true) {
            paramContext = paramContext.edit();
            paramContext.putBoolean("notification_recommend_topic", bool);
            paramContext.commit();
            return;
        }
    }

    public void addEditorItem() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100218);
        this.root.addPreference(localPreferenceCategory);
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
        final SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("notification_upload_image");
        localCheckBoxPreference.setTitle(2131099760);
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(localSharedPreferences.getBoolean("notification_upload_image", true)));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                SettingsFragment.this.uploadImage = ((Boolean) paramAnonymousObject).booleanValue();
                if (SettingsFragment.this.uploadImage) {
                    localEditor.putString("notification_upload_image_title", SettingsFragment.this.mActivity.getResources().getString(2131100487));
                }
                for (; ; ) {
                    localEditor.putBoolean("photoandattachment", SettingsFragment.this.uploadImage);
                    localEditor.commit();
                    return true;
                    localEditor.putString("notification_upload_image_title", SettingsFragment.this.mActivity.getResources().getString(2131100488));
                }
            }
        });
        if (!this.mActivity.getResources().getBoolean(2131558409)) {
            localPreferenceCategory.addPreference(localCheckBoxPreference);
        }
        localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
        localEditor = localSharedPreferences.edit();
        localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("prefernece.show_quickreplay");
        localCheckBoxPreference.setTitle(2131100281);
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(localSharedPreferences.getBoolean("prefernece.show_quickreplay", true)));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                SettingsFragment.this.showQuick_replay = ((Boolean) paramAnonymousObject).booleanValue();
                if (SettingsFragment.this.showQuick_replay) {
                    localEditor.putString("prefernece.show_quickreplay_title", SettingsFragment.this.mActivity.getResources().getString(2131100487));
                }
                for (; ; ) {
                    localEditor.putBoolean("showQuick_replay", SettingsFragment.this.showQuick_replay);
                    localEditor.commit();
                    return true;
                    localEditor.putString("prefernece.show_quickreplay_title", SettingsFragment.this.mActivity.getResources().getString(2131100488));
                }
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
    }

    public void addLookAndFeel() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100219);
        this.root.addPreference(localPreferenceCategory);
        final Object localObject1 = new Preference(this.mActivity);
        ((Preference) localObject1).setTitle(getString(2131100244));
        ((Preference) localObject1).setSummary(getThemeSummary(this.mActivity));
        ((Preference) localObject1).setOnPreferenceClickListener(this);
        ((Preference) localObject1).setKey("prefernece.threadtheme");
        getResources().getBoolean(2131558401);
        localObject1 = new CheckBoxPreference(this.mActivity);
        ((CheckBoxPreference) localObject1).setKey("prefernece.colorstyle_select");
        ((CheckBoxPreference) localObject1).setTitle(2131100279);
        ((CheckBoxPreference) localObject1).setDefaultValue(Boolean.valueOf(false));
        ((CheckBoxPreference) localObject1).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                SettingsFragment.this.colorValue = ((Boolean) paramAnonymousObject);
                SettingsFragment.this.colorValue.booleanValue();
                SettingsFragment.this.onCreateDialog(5);
                return true;
            }
        });
        localPreferenceCategory.addPreference((Preference) localObject1);
        localObject1 = new ListPreference(this.mActivity);
        ((ListPreference) localObject1).setEntries(2131492877);
        ((ListPreference) localObject1).setEntryValues(2131492878);
        ((ListPreference) localObject1).setDefaultValue("1");
        ((ListPreference) localObject1).setDialogTitle(2131100240);
        ((ListPreference) localObject1).setKey("preference.fontsize");
        ((ListPreference) localObject1).setValue(getFont(this.mActivity));
        ((ListPreference) localObject1).setTitle(2131100240);
        ((ListPreference) localObject1).setSummary(((ListPreference) localObject1).getEntry());
        ((ListPreference) localObject1).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                int i = localObject1.findIndexOfValue(paramAnonymousObject.toString());
                paramAnonymousPreference.setSummary(localObject1.getEntries()[i]);
                return true;
            }
        });
        localPreferenceCategory.addPreference((Preference) localObject1);
        if (!this.isOuter) {
            final Object localObject2 = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
            localObject1 = new ListPreference(this.mActivity);
            localObject2 = ((SharedPreferences) localObject2).edit();
            ((ListPreference) localObject1).setEntries(2131492873);
            ((ListPreference) localObject1).setDefaultValue("0");
            ((ListPreference) localObject1).setEntryValues(2131492874);
            ((ListPreference) localObject1).setDialogTitle(2131100237);
            ((ListPreference) localObject1).setKey("prefernece.tab|" + this.forumStatus.tapatalkForum.getId());
            ((ListPreference) localObject1).setTitle(2131100237);
            ((ListPreference) localObject1).setValue(getTab(this.mActivity, this.forumStatus));
            ((ListPreference) localObject1).setSummary(getInitialTabTitle(this.mActivity, this.forumStatus));
            ((ListPreference) localObject1).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    int i = localObject1.findIndexOfValue(paramAnonymousObject.toString());
                    paramAnonymousPreference.setSummary(localObject1.getEntries()[i]);
                    localObject2.putString("prefernece.tab_title|" + SettingsFragment.this.forumStatus.tapatalkForum.getId(), i);
                    localObject2.commit();
                    return true;
                }
            });
        }
        if (this.isOuter) {
            localObject1 = new ListPreference(this.mActivity);
            ((ListPreference) localObject1).setEntries(2131492892);
            ((ListPreference) localObject1).setEntryValues(2131492893);
            ((ListPreference) localObject1).setDefaultValue("1");
            ((ListPreference) localObject1).setDialogTitle(2131100811);
            ((ListPreference) localObject1).setKey("preference.tab_behaviour");
            ((ListPreference) localObject1).setValue(getAccountTabBehaviour(this.mActivity));
            ((ListPreference) localObject1).setTitle(2131100811);
            ((ListPreference) localObject1).setSummary(((ListPreference) localObject1).getEntry());
            ((ListPreference) localObject1).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    int i = localObject1.findIndexOfValue(paramAnonymousObject.toString());
                    paramAnonymousPreference.setSummary(localObject1.getEntries()[i]);
                    return true;
                }
            });
            localPreferenceCategory.addPreference((Preference) localObject1);
        }
    }

    public void addOuterSyncAndNotification() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        final Preference localPreference = new Preference(this.mActivity);
        localPreferenceCategory.setTitle(2131100328);
        this.root.addPreference(localPreferenceCategory);
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this.mActivity);
        localCheckBoxPreference.setKey("notification_flag");
        localCheckBoxPreference.setTitle(2131100888);
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
        localCheckBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference paramAnonymousPreference) {
                SettingsFragment.setupAlarm(SettingsFragment.this.mActivity);
                return true;
            }
        });
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                if (((Boolean) paramAnonymousObject).booleanValue()) {
                    localPreference.setEnabled(true);
                    SettingsFragment.this.recommendForumNotification.setEnabled(true);
                    SettingsFragment.this.recommendForumNotification.setChecked(true);
                    SettingsFragment.this.recommendTopicNotification.setEnabled(true);
                    SettingsFragment.this.recommendTopicNotification.setChecked(true);
                    return true;
                }
                localPreference.setEnabled(false);
                SettingsFragment.this.recommendForumNotification.setEnabled(false);
                SettingsFragment.this.recommendForumNotification.setChecked(false);
                SettingsFragment.this.recommendTopicNotification.setEnabled(false);
                SettingsFragment.this.recommendTopicNotification.setChecked(false);
                return true;
            }
        });
        localPreferenceCategory.addPreference(localCheckBoxPreference);
        this.recommendForumNotification = new CheckBoxPreference(this.mActivity);
        if (localCheckBoxPreference.isChecked()) {
            this.recommendForumNotification.setEnabled(true);
            this.recommendForumNotification.setKey("notification_recommend_flag");
            this.recommendForumNotification.setTitle(2131100886);
            this.recommendForumNotification.setDefaultValue(Boolean.valueOf(true));
            this.recommendForumNotification.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference paramAnonymousPreference) {
                    SettingsFragment.setupRecommendForumAlarm(SettingsFragment.this.mActivity);
                    return true;
                }
            });
            localPreferenceCategory.addPreference(this.recommendForumNotification);
            this.recommendTopicNotification = new CheckBoxPreference(this.mActivity);
            if (!localCheckBoxPreference.isChecked()) {
                break label320;
            }
            this.recommendTopicNotification.setEnabled(true);
        }
        for (; ; ) {
            this.recommendTopicNotification.setKey("notification_recommend_topic");
            this.recommendTopicNotification.setTitle(2131100887);
            this.recommendTopicNotification.setDefaultValue(Boolean.valueOf(true));
            this.recommendTopicNotification.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference paramAnonymousPreference) {
                    SettingsFragment.setupRecommendTopicAlarm(SettingsFragment.this.mActivity);
                    return true;
                }
            });
            localPreferenceCategory.addPreference(this.recommendTopicNotification);
            localPreference.setTitle(2131100490);
            localPreference.setKey("prefernece.notification");
            localPreference.setOnPreferenceClickListener(this);
            localPreferenceCategory.addPreference(localPreference);
            if (!localCheckBoxPreference.isChecked()) {
                break label331;
            }
            localPreference.setEnabled(true);
            return;
            this.recommendForumNotification.setEnabled(false);
            break;
            label320:
            this.recommendTopicNotification.setEnabled(false);
        }
        label331:
        localPreference.setEnabled(false);
    }

    public void addSyncAndNotification() {
        PreferenceCategory localPreferenceCategory = new PreferenceCategory(this.mActivity);
        localPreferenceCategory.setTitle(2131100328);
        this.root.addPreference(localPreferenceCategory);
        Preference localPreference = new Preference(this.mActivity);
        localPreference.setTitle(2131100329);
        localPreference.setSummary(2131100373);
        localPreference.setOnPreferenceClickListener(this);
        localPreference.setKey("prefernece.notification_setting");
        if (PreferenceManager.getDefaultSharedPreferences(this.mActivity).getBoolean("notification_flag", true)) {
            localPreference.setEnabled(true);
        }
        for (; ; ) {
            localPreferenceCategory.addPreference(localPreference);
            return;
            localPreference.setEnabled(false);
        }
    }

    public String[] getSingatureList(ForumStatus paramForumStatus) {
        String[] arrayOfString2 = this.mActivity.getResources().getStringArray(2131492868);
        String[] arrayOfString1;
        if (this.mActivity.getResources().getBoolean(2131558401)) {
            arrayOfString1 = new String[3];
            arrayOfString1[0] = arrayOfString2[0];
            if (this.mActivity.getResources().getBoolean(2131558401)) {
                break label143;
            }
            arrayOfString1[1] = String.format(arrayOfString2[1], new Object[]{Build.MODEL});
            label76:
            if (this.mActivity.getResources().getBoolean(2131558401)) {
                break label197;
            }
        }
        for (; ; ) {
            try {
                arrayOfString1[2] = String.format(arrayOfString2[2], new Object[]{Build.MODEL});
                if (!this.mActivity.getResources().getBoolean(2131558401)) {
                    arrayOfString1[3] = arrayOfString2[3];
                }
                return arrayOfString1;
                arrayOfString1 = new String[4];
                break;
                label143:
                if ((paramForumStatus != null) && (paramForumStatus.getRebrandingConfig() != null) && (TapatalkApp.singatureString != null) && (TapatalkApp.singatureString.length() > 0)) {
                    arrayOfString1[1] = TapatalkApp.singatureString;
                    break label76;
                }
                arrayOfString1[1] = customSignature();
            } catch (Exception paramForumStatus) {
                arrayOfString1[2] = "";
                continue;
            }
            label197:
            arrayOfString1[2] = arrayOfString2[3];
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        ThemeUtil.setTheme(getActivity());
        super.onActivityCreated(paramBundle);
        setQuoordBackGround(getActivity());
        this.mActivity = getActivity();
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        int i;
        if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null)) {
            paramBundle = this.forumStatus.getRebrandingConfig().getOrder();
            if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (paramBundle != null) && (paramBundle.size() > 0)) {
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= paramBundle.size()) {
                initActionbar();
                setPreferenceScreen(createPreferenceHierarchy());
                return;
            }
            if (((TabItem) paramBundle.get(i)).getMenuid() == this.menuId) {
                this.title = ((TabItem) paramBundle.get(i)).getDisplay_name();
            }
            i += 1;
        }
    }

    protected void onCreateDialog(int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 1:
                new AlertDialog.Builder(this.mActivity).setTitle(2131099910).setMessage(2131099911).setPositiveButton(2131099914, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        new SearchRecentSuggestions(SettingsFragment.this.mActivity, "com.quoord.tapatalkpro.directory.SearchDirectorySuggestionProvider", 1).clearHistory();
                    }
                }).setNegativeButton(2131099974, null).create().show();
                return;
            case 5:
                localObject2 = PreferenceManager.getDefaultSharedPreferences(this.mActivity).edit();
                localObject3 = new AlertDialog.Builder(this.mActivity);
                StringBuilder localStringBuilder = new StringBuilder(String.valueOf(this.mActivity.getResources().getString(2131100257))).append(" ");
                if (this.mActivity.getResources().getBoolean(2131558401)) {
                }
                for (localObject1 = TapatalkApp.rebranding_name; ; localObject1 = this.mActivity.getTitle()) {
                    ((AlertDialog.Builder) localObject3).setMessage(localObject1).setCancelable(false).setPositiveButton(2131100321, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            paramAnonymousDialogInterface = localObject2;
                            boolean bool;
                            if (SettingsFragment.this.colorValue.booleanValue()) {
                                bool = false;
                                paramAnonymousDialogInterface.putBoolean("prefernece.colorstyle_select", bool);
                                paramAnonymousDialogInterface = new Intent();
                                paramAnonymousDialogInterface.setFlags(268468224);
                                if (SettingsFragment.this.mActivity.getApplicationContext().getResources().getBoolean(2131558401)) {
                                    break label107;
                                }
                                paramAnonymousDialogInterface.setClass(SettingsFragment.this.mActivity, AccountEntryActivity.class);
                            }
                            for (; ; ) {
                                SettingsFragment.this.mActivity.startActivity(paramAnonymousDialogInterface);
                                SettingsFragment.this.mActivity.finish();
                                return;
                                bool = true;
                                break;
                                label107:
                                if (!SettingsFragment.this.mActivity.getResources().getBoolean(2131558406)) {
                                    paramAnonymousDialogInterface.setClass(SettingsFragment.this.mActivity, SlidingMenuActivity.class);
                                } else {
                                    paramAnonymousDialogInterface.setClass(SettingsFragment.this.mActivity, IcsRebrandingEntryActivity.class);
                                    SettingsFragment.this.mActivity.finish();
                                }
                            }
                        }
                    }).create().show();
                    return;
                }
        }
        final Object localObject2 = new AlertDialog.Builder(this.mActivity);
        Object localObject3 = new StringBuilder(String.valueOf(this.mActivity.getResources().getString(2131100259))).append(" ");
        if (this.mActivity.getResources().getBoolean(2131558401)) {
        }
        for (Object localObject1 = TapatalkApp.rebranding_name; ; localObject1 = this.mActivity.getTitle()) {
            ((AlertDialog.Builder) localObject2).setMessage(localObject1).setCancelable(false).setPositiveButton(2131100321, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    paramAnonymousDialogInterface = new Intent();
                    paramAnonymousDialogInterface.setFlags(268468224);
                    if (!SettingsFragment.this.mActivity.getApplicationContext().getResources().getBoolean(2131558401)) {
                        paramAnonymousDialogInterface.setClass(SettingsFragment.this.mActivity, AccountEntryActivity.class);
                    }
                    for (; ; ) {
                        SettingsFragment.this.mActivity.startActivity(paramAnonymousDialogInterface);
                        SettingsFragment.this.mActivity.finish();
                        return;
                        paramAnonymousDialogInterface.setClass(SettingsFragment.this.mActivity, IcsRebrandingEntryActivity.class);
                    }
                }
            }).create().show();
            return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onHiddenChanged(boolean paramBoolean) {
        super.onHiddenChanged(paramBoolean);
        if (!paramBoolean) {
            initActionbar();
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        this.mActivity.finish();
        return true;
    }

    public boolean onPreferenceClick(final Preference paramPreference) {
        Object localObject1 = paramPreference.getKey();
        if (((String) localObject1).equals("prefernece.cleansearchhistory")) {
            onCreateDialog(1);
        }
        for (; ; ) {
            return true;
            if (((String) localObject1).equals("prefernece.notification")) {
                startActivity(new Intent(this.mActivity, NotificationSetting.class));
            } else if (((String) localObject1).equals("prefernece.topic")) {
                startActivityForResult(new Intent(this.mActivity, UnreadTopicSetting.class), 10);
            } else if (!((String) localObject1).equals("prefernece.threadtheme")) {
                if (((String) localObject1).equals("prefernece.extsd")) {
                    localObject1 = PreferenceManager.getDefaultSharedPreferences(this.mActivity);
                    final SharedPreferences.Editor localEditor = ((SharedPreferences) localObject1).edit();
                    LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(2130903318, null);
                    final Object localObject2 = (RadioButton) localLinearLayout.findViewById(2131231518);
                    localObject2 = (RadioButton) localLinearLayout.findViewById(2131231519);
                    localObject2 = (RadioGroup) localLinearLayout.findViewById(2131231517);
                    final EditText localEditText = (EditText) localLinearLayout.findViewById(2131231520);
                    localEditText.setText(((SharedPreferences) localObject1).getString("prefernece.download", DOWNLOAD_LOCATION));
                    new AlertDialog.Builder(this.mActivity).setView(localLinearLayout).setTitle(this.mActivity.getResources().getString(2131100083)).setPositiveButton(this.mActivity.getResources().getString(2131099792), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            paramAnonymousDialogInterface = localEditText.getText().toString();
                            if (localObject2.getCheckedRadioButtonId() == 2131231518) {
                                localEditor.putString("prefernece.download", paramAnonymousDialogInterface);
                                localEditor.putBoolean("prefernece.extsd", false);
                                paramPreference.setSummary(SettingsFragment.this.mActivity.getResources().getString(2131100112) + " : " + paramAnonymousDialogInterface);
                            }
                            for (; ; ) {
                                localEditor.commit();
                                ((InputMethodManager) SettingsFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SettingsFragment.this.getActivity().getCurrentFocus().getWindowToken(), 0);
                                return;
                                if (localObject2.getCheckedRadioButtonId() == 2131231519) {
                                    localEditor.putString("prefernece.download", paramAnonymousDialogInterface);
                                    localEditor.putBoolean("prefernece.extsd", true);
                                    paramPreference.setSummary(SettingsFragment.this.mActivity.getResources().getString(2131100111) + " : " + paramAnonymousDialogInterface);
                                }
                            }
                        }
                    }).setNegativeButton(this.mActivity.getResources().getString(2131099974), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                            ((InputMethodManager) SettingsFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SettingsFragment.this.getActivity().getCurrentFocus().getWindowToken(), 0);
                        }
                    }).create().show();
                } else if (((String) localObject1).equals("prefernece.notification_setting")) {
                    new ConfigAdapter(this.mActivity, this.forumStatus.getUrl());
                    AccountDialog.showPushDialog(this.mActivity, this.forumStatus);
                } else if (!((String) localObject1).equals("prefernece.color_style")) {
                    if (((String) localObject1).equals("prefernece.policy")) {
                        paramPreference = new Intent(this.mActivity, TapatalkIdWebviewActivity.class);
                        paramPreference.putExtra("title", getString(2131100624));
                        paramPreference.putExtra("change_url", "http://tapatalk.com/privacy.php?from=app");
                        startActivity(paramPreference);
                    } else if (((String) localObject1).equals("prefernece.license")) {
                        paramPreference = new Intent(this.mActivity, TapatalkIdWebviewActivity.class);
                        paramPreference.putExtra("title", getString(2131100625));
                        paramPreference.putExtra("change_url", "http://tapatalk.com/license.php?from=app");
                        startActivity(paramPreference);
                    } else if (((String) localObject1).equals("prefernece.about")) {
                        startActivity(new Intent(this.mActivity, AboutActivity.class));
                    } else if (((String) localObject1).equals("preference.signout_tapatalk_id")) {
                        this.mActivity.setResult(62057, null);
                        this.mActivity.finish();
                    }
                }
            }
        }
    }

    public void setQuoordBackGround(Context paramContext) {
        if (isLightTheme(getActivity())) {
            getView().setBackgroundResource(2131165281);
            return;
        }
        getView().setBackgroundResource(2131165282);
    }

    private class NoneFormatSummaryListPreference
            extends ListPreference {
        public NoneFormatSummaryListPreference(Context paramContext) {
            super();
        }

        public CharSequence getSummary() {
            try {
                CharSequence[] arrayOfCharSequence = super.getEntries();
                super.setEntries(null);
                CharSequence localCharSequence = super.getSummary();
                super.setEntries(arrayOfCharSequence);
                return localCharSequence;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            return "";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/SettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */