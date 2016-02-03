package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.quoord.newonboarding.ObEntryActivity;
import com.quoord.newonboarding.ObStartActivity;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkId;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.tapatalkid.TapatalkIdFactory;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.ThemeUtil;

public class IcsEntryActivity
        extends FragmentActivity {
    public static final String VIEW_FROM_OUT_URL = "VIEW_FROM_OUT_URL";
    private ActionBar bar;
    private FavoriateSqlHelper helper;
    private String intentAction;
    private String intentDatas;
    private TapatalkId tapatalkId;

    private void checkHelper() {
        if (this.helper == null) {
            this.helper = new FavoriateSqlHelper(this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        }
    }

    protected void onCreate(Bundle paramBundle) {
        ThemeUtil.setTheme(this);
        super.onCreate(paramBundle);
        this.bar = getActionBar();
        this.bar.hide();
        this.tapatalkId = TapatalkIdFactory.getTapatalkId(this);
        paramBundle = getIntent();
        if ((paramBundle != null) && (paramBundle.getAction() != null) && (paramBundle.getAction().equalsIgnoreCase("android.intent.action.VIEW")) && (paramBundle.getData() != null) && (paramBundle.getData().toString().length() > 0)) {
            getWindow().setFlags(1024, 1024);
            this.intentAction = paramBundle.getAction();
            this.intentDatas = paramBundle.getData().toString();
            this.bar.hide();
            if (this.intentDatas.contains("tapatalk-account:")) {
                paramBundle = new Intent(this, AccountEntryActivity.class);
                paramBundle.putExtra("scheme_intentAction", this.intentAction);
                paramBundle.putExtra("scheme_intentDatas", this.intentDatas);
                startActivity(paramBundle);
                finish();
                return;
            }
            paramBundle.setClass(this, SlidingMenuActivity.class);
            paramBundle.putExtra("VIEW_FROM_OUT_URL", true);
            paramBundle.setFlags(67108864);
            startActivity(paramBundle);
            finish();
            return;
        }
        if (!this.tapatalkId.isHasAccounts()) {
            if (this.tapatalkId.isTapatalkIdLogin()) {
                paramBundle = new Intent();
                paramBundle.setClass(this, ObStartActivity.class);
                startActivity(paramBundle);
                finish();
                return;
            }
            paramBundle = new Intent();
            paramBundle.setClass(this, ObEntryActivity.class);
            startActivity(paramBundle);
            finish();
            return;
        }
        startActivity(new Intent(this, AccountEntryActivity.class));
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/IcsEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */