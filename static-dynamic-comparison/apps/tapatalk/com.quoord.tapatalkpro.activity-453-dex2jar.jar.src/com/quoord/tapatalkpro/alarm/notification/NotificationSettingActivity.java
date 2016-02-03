package com.quoord.tapatalkpro.alarm.notification;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class NotificationSettingActivity
        extends PreferenceActivity {
    public static int fid;
    boolean _selected;
    ArrayList<String> areas;
    private ForumStatus forumStatus;
    ListPreference ledChoices;
    PreferenceCategory ledNotify;
    private TapatalkForum mForum;
    ArrayList<NotificationSettingCheckItemBean> mList1 = new ArrayList();
    ArrayList<NotificationSettingCheckItemBean> mList2 = new ArrayList();
    PreferenceCategory ortherCategory;
    ArrayList<String> paraAreas;
    SharedPreferences prefs;
    PreferenceScreen root;
    SharedPreferences sp;
    PreferenceCategory subscribeCategory;

    private void addLed() {
        this.ledChoices = new ListPreference(this);
        this.ledChoices.setEntries(2131492887);
        this.ledChoices.setEntryValues(2131492888);
        this.ledChoices.setDefaultValue("0");
        this.ledChoices.setDialogTitle(2131100505);
        this.ledChoices.setKey("tapatalk_led|" + fid);
        this.ledChoices.setTitle(2131100505);
        this.ledChoices.setValue(getLedValue());
        this.ledChoices.setSummary(this.ledChoices.getEntry());
        this.ledChoices.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                int i = NotificationSettingActivity.this.ledChoices.findIndexOfValue(paramAnonymousObject.toString());
                paramAnonymousPreference.setSummary(NotificationSettingActivity.this.ledChoices.getEntries()[i]);
                return true;
            }
        });
        this.ledNotify.addPreference(this.ledChoices);
    }

    private void addNotificationCheck() {
        final CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        final String str = this.mForum.getId() + "notification";
        localCheckBoxPreference.setKey(str);
        localCheckBoxPreference.setTitle(getString(2131099759));
        localCheckBoxPreference.setDefaultValue(Boolean.valueOf(this.prefs.getBoolean(str, true)));
        localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                boolean bool = ((Boolean) paramAnonymousObject).booleanValue();
                paramAnonymousPreference = NotificationSettingActivity.this.prefs.edit();
                paramAnonymousPreference.putBoolean(str, bool);
                paramAnonymousPreference.commit();
                NotificationSettingActivity.this.subscribeCategory.setEnabled(bool);
                NotificationSettingActivity.this.ortherCategory.setEnabled(bool);
                NotificationSettingActivity.this.ledNotify.setEnabled(bool);
                if (((Boolean) paramAnonymousObject).booleanValue()) {
                    localCheckBoxPreference.setSummary(2131100545);
                }
                for (; ; ) {
                    return true;
                    localCheckBoxPreference.setSummary(2131100546);
                }
            }
        });
        this.root.addPreference(localCheckBoxPreference);
        if (localCheckBoxPreference.isChecked()) {
            this.subscribeCategory.setEnabled(true);
            this.ortherCategory.setEnabled(true);
            this.ledNotify.setEnabled(true);
            localCheckBoxPreference.setSummary(2131100545);
            return;
        }
        this.subscribeCategory.setEnabled(false);
        this.ortherCategory.setEnabled(false);
        this.ledNotify.setEnabled(false);
        localCheckBoxPreference.setSummary(2131100546);
    }

    private PreferenceScreen createPreferenceHierarchy() {
        this.root = getPreferenceManager().createPreferenceScreen(this);
        this.prefs = getSharedPreferences("notificationsetting", 0);
        this.subscribeCategory = new PreferenceCategory(this);
        this.ortherCategory = new PreferenceCategory(this);
        this.ledNotify = new PreferenceCategory(this);
        this.subscribeCategory.setTitle(getString(2131099757));
        this.ortherCategory.setTitle(getString(2131099758));
        this.ledNotify.setTitle(getString(2131100716));
        initData();
        createScreen();
        String str = this.mForum.getId() + "notification";
        if (!this.sp.getBoolean("notification_flag", true)) {
            this.subscribeCategory.setEnabled(false);
            this.ortherCategory.setEnabled(false);
            this.ledNotify.setEnabled(false);
        }
        for (; ; ) {
            return this.root;
            if (this.prefs.getBoolean(str, true)) {
                this.subscribeCategory.setEnabled(true);
                this.ortherCategory.setEnabled(true);
                this.ledNotify.setEnabled(true);
            } else {
                this.subscribeCategory.setEnabled(false);
                this.ortherCategory.setEnabled(false);
                this.ledNotify.setEnabled(false);
            }
        }
    }

    private void createScreen() {
        this.root.addPreference(this.subscribeCategory);
        int i = 0;
        if (i >= this.mList1.size()) {
            this.root.addPreference(this.ortherCategory);
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mList2.size()) {
                this.root.addPreference(this.ledNotify);
                addLed();
                return;
                localCheckBoxPreference = new CheckBoxPreference(this);
                localNotificationSettingCheckItemBean = (NotificationSettingCheckItemBean) this.mList1.get(i);
                localCheckBoxPreference.setKey(localNotificationSettingCheckItemBean.getSaveKey());
                localCheckBoxPreference.setTitle(localNotificationSettingCheckItemBean.getShowString());
                localCheckBoxPreference.setDefaultValue(Boolean.valueOf(localNotificationSettingCheckItemBean.isChecked()));
                localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                        boolean bool = ((Boolean) paramAnonymousObject).booleanValue();
                        localNotificationSettingCheckItemBean.setChecked(bool);
                        paramAnonymousPreference = NotificationSettingActivity.this.prefs.edit();
                        paramAnonymousPreference.putBoolean(localNotificationSettingCheckItemBean.getSaveKey(), localNotificationSettingCheckItemBean.isChecked());
                        paramAnonymousPreference.commit();
                        return true;
                    }
                });
                this.subscribeCategory.addPreference(localCheckBoxPreference);
                i += 1;
                break;
            }
            CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
            final NotificationSettingCheckItemBean localNotificationSettingCheckItemBean = (NotificationSettingCheckItemBean) this.mList2.get(i);
            localCheckBoxPreference.setKey(localNotificationSettingCheckItemBean.getSaveKey());
            localCheckBoxPreference.setTitle(localNotificationSettingCheckItemBean.getShowString());
            localCheckBoxPreference.setDefaultValue(Boolean.valueOf(localNotificationSettingCheckItemBean.isChecked()));
            localCheckBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    boolean bool = ((Boolean) paramAnonymousObject).booleanValue();
                    localNotificationSettingCheckItemBean.setChecked(bool);
                    paramAnonymousPreference = NotificationSettingActivity.this.prefs.edit();
                    paramAnonymousPreference.putBoolean(localNotificationSettingCheckItemBean.getSaveKey(), localNotificationSettingCheckItemBean.isChecked());
                    paramAnonymousPreference.commit();
                    return true;
                }
            });
            this.ortherCategory.addPreference(localCheckBoxPreference);
            i += 1;
        }
    }

    private int getBooleanInt(boolean paramBoolean) {
        if (paramBoolean) {
            return 1;
        }
        return 0;
    }

    public static int getLEDColor(Context paramContext) {
        paramContext = Prefs.get(paramContext).getString("tapatalk_led|" + fid, "0");
        if (paramContext.equalsIgnoreCase("0")) {
        }
        do {
            return -1;
            if (paramContext.equalsIgnoreCase("1")) {
                return 0;
            }
            if (paramContext.equalsIgnoreCase("2")) {
                return 65280;
            }
            if (paramContext.equalsIgnoreCase("3")) {
                return -16711936;
            }
        } while (paramContext.equalsIgnoreCase("4"));
        return -16776961;
    }

    private String getLedValue() {
        return PreferenceManager.getDefaultSharedPreferences(this).getString("tapatalk_led|" + fid, "0");
    }

    private void initData() {
        this.forumStatus = ((ForumStatus) getIntent().getSerializableExtra("forumStatus"));
        fid = this.forumStatus.tapatalkForum.getId().intValue();
        this.mForum = this.forumStatus.tapatalkForum;
        this.areas = new ArrayList();
        this.paraAreas = new ArrayList();
        if (!this.mForum.isPush()) {
            if (this.mForum.isSupportConve()) {
                this.areas.add(getResources().getString(2131100368));
                this.paraAreas.add("conversation");
                this.areas.add(getResources().getString(2131100356));
                this.paraAreas.add("sub");
            }
        }
        SharedPreferences.Editor localEditor;
        int i;
        for (; ; ) {
            localEditor = this.prefs.edit();
            i = 0;
            if (i < this.areas.size()) {
                break label493;
            }
            localEditor.commit();
            return;
            this.areas.add(getResources().getString(2131100355));
            this.paraAreas.add("pm");
            break;
            if (this.mForum.isPushConv()) {
                this.areas.add(getResources().getString(2131100368));
                this.paraAreas.add("conversation");
            }
            if (this.mForum.isPushPM()) {
                this.areas.add(getResources().getString(2131100355));
                this.paraAreas.add("pm");
            }
            if (this.mForum.isPushSub()) {
                this.areas.add(getResources().getString(2131100356));
                this.paraAreas.add("sub");
            }
            if (this.mForum.isPushNewTopic()) {
                this.areas.add(getResources().getString(2131100359));
                this.paraAreas.add("newtopic");
            }
            if ((this.mForum.isPushLike()) || (this.mForum.isPushThank())) {
                this.areas.add(getResources().getString(2131100357));
                this.paraAreas.add("like");
            }
            if (this.mForum.isPushQuote()) {
                this.areas.add(getResources().getString(2131100358));
                this.paraAreas.add("quote");
            }
            if (this.mForum.isPushTag()) {
                this.areas.add(getResources().getString(2131100360));
                this.paraAreas.add("tag");
            }
        }
        label493:
        NotificationSettingCheckItemBean localNotificationSettingCheckItemBean = new NotificationSettingCheckItemBean((String) this.areas.get(i), (String) this.paraAreas.get(i), this.mForum.getId());
        if (!this.prefs.contains(localNotificationSettingCheckItemBean.getSaveKey())) {
            localEditor.putBoolean(localNotificationSettingCheckItemBean.getSaveKey(), true);
            localNotificationSettingCheckItemBean.setChecked(true);
            label563:
            if ((!localNotificationSettingCheckItemBean.getKeyString().equals("sub")) && (!localNotificationSettingCheckItemBean.getKeyString().equals("newtopic"))) {
                break label626;
            }
            this.mList1.add(localNotificationSettingCheckItemBean);
        }
        for (; ; ) {
            i += 1;
            break;
            localNotificationSettingCheckItemBean.setChecked(this.prefs.getBoolean(localNotificationSettingCheckItemBean.getSaveKey(), true));
            break label563;
            label626:
            this.mList2.add(localNotificationSettingCheckItemBean);
        }
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.sp = getSharedPreferences("notificationsetting", 0);
        paramBundle = getActionBar();
        paramBundle.setTitle(getString(2131100329));
        paramBundle.setDisplayHomeAsUpEnabled(true);
        paramBundle.setIcon(2130837525);
        setPreferenceScreen(createPreferenceHierarchy());
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131623944, paramMenu);
        Switch localSwitch = (Switch) paramMenu.findItem(2131231755).getActionView();
        boolean bool = this.sp.getBoolean("notification_flag", true);
        localSwitch.setChecked(this._selected);
        if (!bool) {
            localSwitch.setChecked(false);
            localSwitch.setEnabled(false);
        }
        for (; ; ) {
            return super.onCreateOptionsMenu(paramMenu);
            final String str = this.mForum.getId() + "notification";
            localSwitch.setChecked(this.prefs.getBoolean(str, true));
            localSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean) {
                    NotificationSettingActivity.this._selected = paramAnonymousBoolean;
                    paramAnonymousCompoundButton = NotificationSettingActivity.this.prefs.edit();
                    paramAnonymousCompoundButton.putBoolean(str, NotificationSettingActivity.this._selected);
                    paramAnonymousCompoundButton.commit();
                    NotificationSettingActivity.this.subscribeCategory.setEnabled(NotificationSettingActivity.this._selected);
                    NotificationSettingActivity.this.ortherCategory.setEnabled(NotificationSettingActivity.this._selected);
                    NotificationSettingActivity.this.ledNotify.setEnabled(NotificationSettingActivity.this._selected);
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        HashMap localHashMap = new HashMap();
        int i = 0;
        if (i >= this.mList1.size()) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.mList2.size()) {
                return;
                localHashMap.put(((NotificationSettingCheckItemBean) this.mList1.get(i)).getKeyString(), Integer.valueOf(getBooleanInt(((NotificationSettingCheckItemBean) this.mList1.get(i)).isChecked())));
                i += 1;
                break;
            }
            localHashMap.put(((NotificationSettingCheckItemBean) this.mList2.get(i)).getKeyString(), Integer.valueOf(getBooleanInt(((NotificationSettingCheckItemBean) this.mList2.get(i)).isChecked())));
            i += 1;
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (16908332 == paramMenuItem.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/notification/NotificationSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */