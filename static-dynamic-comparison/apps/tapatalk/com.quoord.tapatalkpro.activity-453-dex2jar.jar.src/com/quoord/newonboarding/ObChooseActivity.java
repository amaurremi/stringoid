package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.TapatalkCategory;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.HeaderGridView;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;

public class ObChooseActivity
        extends Activity {
    private RelativeLayout bottomLay;
    private ObChooseCategoryAdapter categoryAdatper;
    private HeaderGridView categoryGrid;
    public Button next;
    private ProgressBar progress;
    private EditText search;
    private TextView t1;
    private TextView t2;
    private LinearLayout tipsView;

    private void initTextFont() {
        try {
            Typeface localTypeface = Typeface.createFromAsset(getAssets(), "font/GothamRnd-Light.ttf");
            this.t1.setTypeface(localTypeface);
            this.t2.setTypeface(localTypeface);
            return;
        } catch (Exception localException) {
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968617, 2130968616);
    }

    protected void onCreate(Bundle paramBundle) {
        Util.setPortrait(this);
        super.onCreate(paramBundle);
        setContentView(2130903297);
        GoogleAnalyticsTools.trackPageView(this, "ob_category_view");
        UserBehavior.logNOBSearchCategories(this);
        ObActivitiesStackManager.getInstance().addActivity(this);
        getActionBar().hide();
        this.t1 = ((TextView) findViewById(2131231326));
        this.t2 = ((TextView) findViewById(2131231327));
        initTextFont();
        this.search = ((EditText) findViewById(2131231471));
        this.categoryGrid = ((HeaderGridView) findViewById(2131231477));
        this.progress = ((ProgressBar) findViewById(2131230891));
        this.tipsView = ((LinearLayout) LayoutInflater.from(this).inflate(2130903296, null));
        this.categoryGrid.addHeaderView(this.tipsView, null, false);
        if (Util.isHDDevice(this)) {
            this.bottomLay = ((RelativeLayout) findViewById(2131231475));
            this.next = ((Button) findViewById(2131231476));
            this.bottomLay.setVisibility(0);
        }
        for (; ; ) {
            this.bottomLay.bringToFront();
            this.categoryAdatper = new ObChooseCategoryAdapter(this, this.categoryGrid, this.progress);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.search.getWindowToken(), 0);
            this.search.setInputType(0);
            this.search.clearFocus();
            this.search.setHint(Html.fromHtml("<small>" + getResources().getString(2131100872) + "</small>"));
            this.search.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    paramAnonymousView = new Intent(ObChooseActivity.this, ObSearchActivity.class);
                    ObChooseActivity.this.startActivity(paramAnonymousView);
                }
            });
            this.next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    Object localObject = ObChooseActivity.this.categoryAdatper.getSelectedCategoryList();
                    int i;
                    if (((ArrayList) localObject).size() > 0) {
                        paramAnonymousView = new ArrayList();
                        i = 0;
                    }
                    for (; ; ) {
                        if (i >= ((ArrayList) localObject).size()) {
                            localObject = new Intent(ObChooseActivity.this, ObForumListActivity.class);
                            ((Intent) localObject).putExtra("selectedCategories", paramAnonymousView);
                            ObChooseActivity.this.startActivity((Intent) localObject);
                            ObChooseActivity.this.overridePendingTransition(2130968615, 2130968618);
                            return;
                        }
                        paramAnonymousView.add(((TapatalkCategory) ((ArrayList) localObject).get(i)).getId());
                        i += 1;
                    }
                }
            });
            return;
            this.bottomLay = ((RelativeLayout) findViewById(2131231474));
            this.next = ((Button) findViewById(2131230977));
            this.bottomLay.setVisibility(0);
        }
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */