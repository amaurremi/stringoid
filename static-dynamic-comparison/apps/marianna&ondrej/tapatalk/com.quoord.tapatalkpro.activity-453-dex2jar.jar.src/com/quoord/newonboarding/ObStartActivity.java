package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

public class ObStartActivity
        extends Activity {
    private TextView contentT1;
    private TextView contentT2;
    private TextView contentT3;
    private TextView next;
    private TextView t1;
    private TextView t2;

    private void initTextFont() {
        try {
            Typeface localTypeface = Typeface.createFromAsset(getAssets(), "font/GothamRnd-Light.ttf");
            this.t1.setTypeface(localTypeface);
            this.t2.setTypeface(localTypeface);
            localTypeface = Typeface.createFromAsset(getAssets(), "font/KlinicSlabBoldIt.ttf");
            this.contentT1.setTypeface(localTypeface);
            this.contentT2.setTypeface(localTypeface);
            this.contentT3.setTypeface(localTypeface);
            localTypeface = Typeface.createFromAsset(getAssets(), "font/Roboto-Light.ttf");
            this.next.setTypeface(localTypeface);
            return;
        } catch (Exception localException) {
        }
    }

    protected void onCreate(Bundle paramBundle) {
        Util.setPortrait(this);
        super.onCreate(paramBundle);
        setContentView(2130903302);
        GoogleAnalyticsTools.trackPageView(this, "ob_start_view");
        UserBehavior.logNOBLetsStarted(this);
        ObActivitiesStackManager.getInstance().addActivity(this);
        getActionBar().hide();
        this.next = ((TextView) findViewById(2131230977));
        this.t1 = ((TextView) findViewById(2131231326));
        this.t2 = ((TextView) findViewById(2131231327));
        this.contentT1 = ((TextView) findViewById(2131231485));
        this.contentT2 = ((TextView) findViewById(2131231486));
        this.contentT3 = ((TextView) findViewById(2131231487));
        initTextFont();
        this.next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                paramAnonymousView = new Intent(ObStartActivity.this, ObChooseActivity.class);
                ObStartActivity.this.startActivity(paramAnonymousView);
                ObStartActivity.this.overridePendingTransition(2130968615, 2130968618);
            }
        });
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObStartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */