package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class UnreadTopicSetting
        extends PreferenceActivity {
    public static final String key_boldtitle = "boldtitle";
    public static final String key_titlegray = "titlegrayed";
    public static final String key_unreadboldtitle = "unreadboldtitle";
    public static final String key_unreadstripe = "unreadstripe";
    private SharedPreferences defaultSp;
    private SharedPreferences sp;

    private void setValue(String paramString, boolean paramBoolean) {
        SharedPreferences.Editor localEditor = this.defaultSp.edit();
        localEditor.putBoolean(paramString, paramBoolean);
        localEditor.commit();
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        addPreferencesFromResource(2131034118);
        this.sp = PreferenceManager.getDefaultSharedPreferences(this);
        this.defaultSp = Prefs.get(this);
        paramBundle = getActionBar();
        paramBundle.setTitle(getResources().getString(2131100563));
        paramBundle.setIcon(2130837525);
        paramBundle.setDisplayHomeAsUpEnabled(true);
        this.sp.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString) {
                if (paramAnonymousString.equals("unreadstripe")) {
                    UnreadTopicSetting.this.setValue(paramAnonymousString, paramAnonymousSharedPreferences.getBoolean(paramAnonymousString, false));
                }
                do {
                    return;
                    if (paramAnonymousString.equals("unreadboldtitle")) {
                        UnreadTopicSetting.this.setValue(paramAnonymousString, paramAnonymousSharedPreferences.getBoolean(paramAnonymousString, false));
                        return;
                    }
                    if (paramAnonymousString.equals("titlegrayed")) {
                        UnreadTopicSetting.this.setValue(paramAnonymousString, paramAnonymousSharedPreferences.getBoolean(paramAnonymousString, false));
                        return;
                    }
                } while (!paramAnonymousString.equals("boldtitle"));
                UnreadTopicSetting.this.setValue(paramAnonymousString, paramAnonymousSharedPreferences.getBoolean(paramAnonymousString, false));
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        finish();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/UnreadTopicSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */