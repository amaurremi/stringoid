package com.quoord.tapatalkpro.ics.slidingMenu;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class AboutActivity
        extends Activity
        implements View.OnClickListener {
    private Button contact_us;
    private LinearLayout ll_about;
    private Button tell_friends;
    private TextView version_name;

    public void findView() {
        this.ll_about = ((LinearLayout) findViewById(2131230755));
        this.contact_us = ((Button) findViewById(2131230757));
        this.tell_friends = ((Button) findViewById(2131230758));
        this.version_name = ((TextView) findViewById(2131230756));
    }

    public String getVersion() {
        try {
            String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            if (!getResources().getBoolean(2131558409)) {
                return getString(2131099730) + " " + str;
            }
            str = getString(2131100252) + " " + str;
            return str;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return getString(2131100252);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            case 2131230757:
            default:
                return;
        }
        paramView = new Intent("android.intent.action.SEND");
        paramView.setType("plain/text");
        String str1 = getString(2131100630);
        String str2 = getString(2131100632);
        paramView.putExtra("android.intent.extra.SUBJECT", str1);
        paramView.putExtra("android.intent.extra.TEXT", str2);
        startActivity(paramView);
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        setContentView(2130903040);
        getActionBar().setTitle(2131100626);
        getActionBar().setIcon(2130837525);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        findView();
        if (!SettingsFragment.isLightTheme(this)) {
            this.version_name.setTextColor(getResources().getColor(2131165213));
            this.tell_friends.setTextColor(getResources().getColor(2131165213));
            this.contact_us.setTextColor(getResources().getColor(2131165213));
            this.ll_about.setBackgroundResource(2131165298);
        }
        this.version_name.setText(getVersion());
        this.contact_us.setOnClickListener(this);
        this.tell_friends.setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return false;
        }
        finish();
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/AboutActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */