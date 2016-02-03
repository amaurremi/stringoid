package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.MenuItem;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class DisablePhotoSetting
        extends PreferenceActivity {
    public static final String DISABLEAVATAR = "prefernece.disableavatar";
    public static final String DISABLEPHOTO = "prefernece.disablephoto";
    PreferenceScreen root;

    private PreferenceScreen createPreferenceScreen() {
        SharedPreferences localSharedPreferences = Prefs.get(this);
        this.root = getPreferenceManager().createPreferenceScreen(this);
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.setKey("prefernece.disableavatar");
        localCheckBoxPreference.setTitle(2131099732);
        localCheckBoxPreference.setChecked(localSharedPreferences.getBoolean("prefernece.disableavatar", false));
        this.root.addPreference(localCheckBoxPreference);
        localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.setKey("prefernece.disablephoto");
        localCheckBoxPreference.setTitle(2131099733);
        localCheckBoxPreference.setChecked(localSharedPreferences.getBoolean("prefernece.disablephoto", false));
        this.root.addPreference(localCheckBoxPreference);
        return this.root;
    }

    public static boolean isDisablePhoto(Context paramContext) {
        return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("prefernece.disablephoto", false);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        paramBundle = getActionBar();
        paramBundle.setTitle(getResources().getString(2131099734));
        paramBundle.setDisplayHomeAsUpEnabled(true);
        setPreferenceScreen(createPreferenceScreen());
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (16908332 == paramMenuItem.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/DisablePhotoSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */