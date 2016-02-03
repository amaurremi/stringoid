package com.quoord.tapatalkpro.alarm;

import android.app.ActionBar;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.view.MenuItem;
import android.widget.TimePicker;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.TimePickerPreference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NotificationSetting
        extends PreferenceActivity {
    public static final int CHECK_CHOICE_1 = 1;
    public static final int CHECK_CHOICE_2 = 2;
    public static final int CHECK_CHOICE_3 = 3;
    public static final int CHECK_CHOICE_4 = 4;
    public static final String ISSILENT = "isslient";
    public static final String NOTIFICATION_FLAG = "notification_flag";
    public static final String NOTIFICATION_RATE = "notification_check_rate";
    public static final String NOTIFICATION_TOPIC_FLAG = "notification_topic_flag";
    public static final String PREFERENCE_END_TIME = "silent_mode_end_time";
    public static final String PREFERENCE_LED = "tapatalk_led";
    public static final String PREFERENCE_RINGTONE = "tapatalk_ringtone";
    public static final String PREFERENCE_SERVICE_LAST_NOTIFICATION_TIME = "tapatalk_service_last_notification_time";
    public static final String PREFERENCE_SERVICE_LAST_PM_ID = "tapatalk_service_last_pm_id";
    public static final String PREFERENCE_SERVICE_LAST_READ_PM_TIME = "tapatalk_service_last_read_pm_time";
    public static final String PREFERENCE_SERVICE_LAST_RUN_TIME = "tapatalk_service_last_run_time";
    public static final String PREFERENCE_SERVICE_LAST_SUB_TOPIC_TIME = "tapatalk_service_last_sub_topic_time";
    public static final String PREFERENCE_SILENT_MODE = "tapatalk_silentmode_2";
    public static final String PREFERENCE_START_TIME = "silent_mode_start_time";
    public static final String PREFERENCE_VIBRATE_WHEN = "tapatalk_vibrate_when";
    public static final String SILENT_BEGIN = "silent_begin";
    public static final String SILENT_END = "silent_end";
    public static final String TIME_SCOPE = "time_scope";
    static String end_time;
    static String start_time;
    static String time_scope;
    ListPreference alertChoices;
    Calendar calendar = Calendar.getInstance();
    Preference endTime;
    int hour = this.calendar.get(11);
    ListPreference ledChoices;
    int minus = this.calendar.get(12);
    PreferenceScreen p;
    RingtonePreference ringtongFlag;
    CheckBoxPreference silentMode;
    Preference startTime;
    ListPreference vibrateFlag;

    private PreferenceScreen createPreferenceHierarchy() {
        new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
        PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        this.alertChoices = new ListPreference(this);
        this.alertChoices.setEntries(2131492883);
        this.alertChoices.setEntryValues(2131492884);
        this.alertChoices.setDefaultValue("2");
        this.alertChoices.setDialogTitle(2131100496);
        this.alertChoices.setKey("notification_check_rate");
        this.alertChoices.setTitle(2131100496);
        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        this.alertChoices.setValue(localSharedPreferences.getString("notification_check_rate", "2"));
        this.alertChoices.setSummary(this.alertChoices.getEntry());
        this.alertChoices.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                paramAnonymousPreference = paramAnonymousObject.toString();
                int i = NotificationSetting.this.alertChoices.findIndexOfValue(paramAnonymousPreference);
                NotificationSetting.this.alertChoices.setSummary(NotificationSetting.this.alertChoices.getEntries()[i]);
                NotificationSetting.this.alertChoices.setValue(paramAnonymousPreference);
                NotificationSetting.setupAlarm(NotificationSetting.this);
                return true;
            }
        });
        localPreferenceScreen.addPreference(this.alertChoices);
        final Object localObject = Prefs.get(this).getString("tapatalk_ringtone", "content://settings/system/notification_sound");
        this.ringtongFlag = new RingtonePreference(this);
        this.ringtongFlag.setKey("tapatalk_ringtone");
        this.ringtongFlag.setRingtoneType(2);
        this.ringtongFlag.setDefaultValue(localObject);
        this.ringtongFlag.setTitle(2131099929);
        localPreferenceScreen.addPreference(this.ringtongFlag);
        localSharedPreferences.getString("tapatalk_vibrate_when", getResources().getString(2131099928));
        this.vibrateFlag = new ListPreference(this);
        this.vibrateFlag.setEntries(2131492875);
        this.vibrateFlag.setEntryValues(2131492876);
        this.vibrateFlag.setDefaultValue("2");
        this.vibrateFlag.setKey("tapatalk_vibrate_when");
        this.vibrateFlag.setTitle(2131099924);
        this.vibrateFlag.setDialogTitle(2131099924);
        this.vibrateFlag.setValue(localSharedPreferences.getString("tapatalk_vibrate_when", "2"));
        this.vibrateFlag.setSummary(this.vibrateFlag.getEntry());
        this.vibrateFlag.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                int i = NotificationSetting.this.vibrateFlag.findIndexOfValue(paramAnonymousObject.toString());
                paramAnonymousPreference.setSummary(NotificationSetting.this.vibrateFlag.getEntries()[i]);
                NotificationSetting.setupAlarm(NotificationSetting.this);
                return true;
            }
        });
        localPreferenceScreen.addPreference(this.vibrateFlag);
        init();
        localObject = PreferenceManager.getDefaultSharedPreferences(this);
        this.silentMode = new CheckBoxPreference(this);
        this.silentMode.setKey("tapatalk_silentmode_2");
        this.silentMode.setDefaultValue(Boolean.valueOf(false));
        this.silentMode.setTitle(2131100117);
        this.silentMode.setSummary(((SharedPreferences) localObject).getString("time_scope", time_scope));
        this.silentMode.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                if (((Boolean) paramAnonymousObject).booleanValue()) {
                    NotificationSetting.this.startTime.setEnabled(true);
                    NotificationSetting.this.endTime.setEnabled(true);
                    return true;
                }
                NotificationSetting.this.startTime.setEnabled(false);
                NotificationSetting.this.endTime.setEnabled(false);
                return true;
            }
        });
        localPreferenceScreen.addPreference(this.silentMode);
        localObject = PreferenceManager.getDefaultSharedPreferences(this);
        this.startTime = new Preference(this);
        this.startTime.setTitle(getString(2131099738));
        this.startTime.setKey("silent_mode_start_time");
        this.startTime.setSummary(((SharedPreferences) localObject).getString("silent_begin", "00:00"));
        this.startTime.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference paramAnonymousPreference) {
                new TimePickerDialog(NotificationSetting.this, new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker paramAnonymous2TimePicker, int paramAnonymous2Int1, int paramAnonymous2Int2) {
                        NotificationSetting.this.calendar.set(11, paramAnonymous2Int1);
                        NotificationSetting.this.calendar.set(12, paramAnonymous2Int2);
                        NotificationSetting.start_time = NotificationSetting.this.timerFormat();
                        NotificationSetting.time_scope = NotificationSetting.start_time + " ~ " + NotificationSetting.end_time;
                        paramAnonymous2TimePicker = this.val$timePreferences.edit();
                        paramAnonymous2TimePicker.putString("silent_begin", NotificationSetting.this.timerFormat());
                        paramAnonymous2TimePicker.putString("time_scope", NotificationSetting.time_scope);
                        paramAnonymous2TimePicker.commit();
                        NotificationSetting.this.startTime.setSummary(this.val$timePreferences.getString("silent_begin", "00:00"));
                        NotificationSetting.this.silentMode.setSummary(NotificationSetting.time_scope);
                    }
                }, NotificationSetting.this.hour, NotificationSetting.this.minus, true).show();
                return true;
            }
        });
        localPreferenceScreen.addPreference(this.startTime);
        this.endTime = new Preference(this);
        this.endTime.setTitle(getString(2131099739));
        this.endTime.setKey("silent_mode_end_time");
        this.endTime.setSummary(((SharedPreferences) localObject).getString("silent_end", "08:00"));
        this.endTime.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference paramAnonymousPreference) {
                new TimePickerDialog(NotificationSetting.this, new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker paramAnonymous2TimePicker, int paramAnonymous2Int1, int paramAnonymous2Int2) {
                        NotificationSetting.this.calendar.set(11, paramAnonymous2Int1);
                        NotificationSetting.this.calendar.set(12, paramAnonymous2Int2);
                        NotificationSetting.end_time = NotificationSetting.this.timerFormat();
                        NotificationSetting.time_scope = NotificationSetting.start_time + " ~ " + NotificationSetting.end_time;
                        paramAnonymous2TimePicker = this.val$timePreferences.edit();
                        paramAnonymous2TimePicker.putString("silent_end", NotificationSetting.this.timerFormat());
                        paramAnonymous2TimePicker.putString("time_scope", NotificationSetting.time_scope);
                        paramAnonymous2TimePicker.commit();
                        NotificationSetting.this.endTime.setSummary(this.val$timePreferences.getString("silent_end", "08:00"));
                        NotificationSetting.this.silentMode.setSummary(NotificationSetting.time_scope);
                    }
                }, NotificationSetting.this.hour, NotificationSetting.this.minus, true).show();
                return true;
            }
        });
        localPreferenceScreen.addPreference(this.endTime);
        if (this.silentMode.isChecked()) {
            this.startTime.setEnabled(true);
            this.endTime.setEnabled(true);
        }
        for (; ; ) {
            this.ledChoices = new ListPreference(this);
            this.ledChoices.setEntries(2131492885);
            this.ledChoices.setEntryValues(2131492886);
            this.ledChoices.setDefaultValue("1");
            this.ledChoices.setDialogTitle(2131100505);
            this.ledChoices.setKey("tapatalk_led");
            this.ledChoices.setTitle(2131100505);
            this.ledChoices.setValue(localSharedPreferences.getString("tapatalk_led", "1"));
            this.ledChoices.setSummary(this.ledChoices.getEntry());
            this.ledChoices.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject) {
                    int i = NotificationSetting.this.ledChoices.findIndexOfValue(paramAnonymousObject.toString());
                    paramAnonymousPreference.setSummary(NotificationSetting.this.ledChoices.getEntries()[i]);
                    return true;
                }
            });
            localPreferenceScreen.addPreference(this.ledChoices);
            return localPreferenceScreen;
            this.startTime.setEnabled(false);
            this.endTime.setEnabled(false);
        }
    }

    public static int getAlertType(Context paramContext) {
        String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("notification_check_rate", "");
        if (str.equalsIgnoreCase(paramContext.getResources().getStringArray(2131492884)[0])) {
            return 0;
        }
        if (str.equalsIgnoreCase(paramContext.getResources().getStringArray(2131492884)[1])) {
            return 1;
        }
        if (str.equalsIgnoreCase(paramContext.getResources().getStringArray(2131492884)[2])) {
            return 2;
        }
        return 2;
    }

    public static int getLEDColor(Context paramContext) {
        paramContext = Prefs.get(paramContext).getString("tapatalk_led", "1");
        if (paramContext.equalsIgnoreCase("0")) {
            return 0;
        }
        if (paramContext.equalsIgnoreCase("1")) {
            return 65280;
        }
        if (paramContext.equalsIgnoreCase("2")) {
            return -16711936;
        }
        if (paramContext.equalsIgnoreCase("3")) {
            return -1;
        }
        return -16776961;
    }

    public static boolean getNotificationFlag(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("notification_flag", true);
    }

    public static boolean getTopicFlag(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("notification_topic_flag", false);
    }

    public static int getVibrateFlag(Context paramContext) {
        String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("tapatalk_vibrate_when", "");
        if (str.equalsIgnoreCase(paramContext.getResources().getStringArray(2131492876)[0])) {
            return 0;
        }
        if (str.equalsIgnoreCase(paramContext.getResources().getStringArray(2131492876)[1])) {
            return 1;
        }
        if (str.equalsIgnoreCase(paramContext.getResources().getStringArray(2131492876)[2])) {
            return 2;
        }
        return 2;
    }

    private void init() {
        if (start_time == null) {
            start_time = "00:00";
        }
        if (end_time == null) {
            end_time = "08:00";
        }
        if (time_scope == null) {
            time_scope = start_time + " ~ " + end_time;
        }
    }

    private void restartNotifications() {
        NotificationAlarmService.cancelPings(this);
        NotificationAlarmService.setupPings(this);
    }

    private void saveVibreate(Context paramContext, String paramString) {
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        paramContext.putString("tapatalk_vibrate_when", paramString);
        paramContext.commit();
    }

    public static void setupAlarm(Context paramContext) {
        NotificationAlarmReceiver.stopAlarm(paramContext);
        if (getNotificationFlag(paramContext)) {
            NotificationAlarmService.setupPings(paramContext);
            return;
        }
        NotificationAlarmService.cancelPings(paramContext);
    }

    public static void setupAlarm(Context paramContext, String paramString) {
        NotificationAlarmReceiver.stopAlarm(paramContext);
        if (getNotificationFlag(paramContext)) {
            NotificationAlarmService.setupPings(paramContext);
            return;
        }
        NotificationAlarmService.cancelPings(paramContext);
    }

    private String timerFormat() {
        Date localDate = this.calendar.getTime();
        return new SimpleDateFormat("HH:mm").format(localDate);
    }

    public String getTimeString(Context paramContext, String paramString1, String paramString2) {
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString2);
        int i = TimePickerPreference.getHour(paramContext.toString());
        int j = TimePickerPreference.getMinute(paramContext.toString());
        return String.format("%02d", new Object[]{Integer.valueOf(i)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(j)});
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        paramBundle = getActionBar();
        paramBundle.setTitle(getString(2131100490));
        paramBundle.setIcon(2130837525);
        paramBundle.setDisplayHomeAsUpEnabled(true);
        this.p = createPreferenceHierarchy();
        setPreferenceScreen(this.p);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (16908332 == paramMenuItem.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void updateSilentSummary() {
        Object localObject = PreferenceManager.getDefaultSharedPreferences(this);
        String str = ((SharedPreferences) localObject).getString("silent_begin", "0:0");
        localObject = ((SharedPreferences) localObject).getString("silent_end", "8:0");
        int i = TimePickerPreference.getHour(str.toString());
        int j = TimePickerPreference.getMinute(str.toString());
        int k = TimePickerPreference.getHour(((String) localObject).toString());
        int m = TimePickerPreference.getMinute(((String) localObject).toString());
        this.silentMode.setSummary(String.format("%02d", new Object[]{Integer.valueOf(i)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(j)}) + " ~ " + String.format("%02d", new Object[]{Integer.valueOf(k)}) + ":" + String.format("%02d", new Object[]{Integer.valueOf(m)}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/alarm/NotificationSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */