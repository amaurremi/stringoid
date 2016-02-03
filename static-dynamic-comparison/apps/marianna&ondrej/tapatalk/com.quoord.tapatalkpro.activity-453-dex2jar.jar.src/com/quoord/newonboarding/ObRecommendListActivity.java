package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.RecommendForumsAction;
import com.quoord.tapatalkpro.action.RecommendForumsAction.RecommendActionBack;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.GroupBean;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tapatalkpro.view.SectionTitleListView;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;

public class ObRecommendListActivity
        extends Activity {
    private ArrayList<TapatalkForumForSearch> addDatas = new ArrayList();
    private RelativeLayout bottomLay;
    public Button done;
    private SectionTitleListView groupTreeView;
    private ObActivitiesStackManager obStack;
    private RecommendForumsAction recommendAction;
    private ObRecommendAdapter recommendAdapter;
    private TextView t1;
    private TextView t2;

    private void initTextFont() {
        try {
            Typeface localTypeface = Typeface.createFromAsset(getAssets(), "font/GothamRnd-Light.ttf");
            this.t1.setTypeface(localTypeface);
            this.t2.setTypeface(localTypeface);
            return;
        } catch (Exception localException) {
        }
    }

    protected void onCreate(Bundle paramBundle) {
        Util.setPortrait(this);
        setTheme(2131361806);
        super.onCreate(paramBundle);
        getActionBar().hide();
        setContentView(2130903299);
        GoogleAnalyticsTools.trackPageView(this, "ob_recommend_view");
        UserBehavior.logNOBAddForums(this);
        this.obStack = ObActivitiesStackManager.getInstance();
        this.obStack.addActivity(this);
        this.t1 = ((TextView) findViewById(2131231326));
        this.t2 = ((TextView) findViewById(2131231327));
        initTextFont();
        this.addDatas = ((ArrayList) getIntent().getSerializableExtra("toAddForums"));
        this.groupTreeView = ((SectionTitleListView) findViewById(2131231482));
        label188:
        int i;
        if (Util.isHDDevice(this)) {
            this.bottomLay = ((RelativeLayout) findViewById(2131231475));
            this.done = ((Button) findViewById(2131231481));
            this.bottomLay.setVisibility(0);
            this.bottomLay.bringToFront();
            if (!Util.isHDDevice(this)) {
                break label396;
            }
            this.groupTreeView.setHeaderView(getLayoutInflater().inflate(2130903308, this.groupTreeView, false));
            this.groupTreeView.setGroupIndicator(null);
            this.groupTreeView.setSelector(2131165212);
            this.recommendAdapter = new ObRecommendAdapter(this, this.groupTreeView);
            this.groupTreeView.setAdapter(this.recommendAdapter);
            paramBundle = new GroupBean(getString(2131100725));
            i = 0;
            label248:
            if (i < this.addDatas.size()) {
                break label420;
            }
            this.recommendAdapter.groupList.add(paramBundle);
            i = 0;
            label273:
            if (i < this.recommendAdapter.groupList.size()) {
                break label435;
            }
            this.recommendAdapter.notifyDataSetChanged();
            this.recommendAction = new RecommendForumsAction(this);
            paramBundle = new ArrayList();
            i = 0;
        }
        for (; ; ) {
            if (i >= this.addDatas.size()) {
                this.recommendAction.getRecommendForums(paramBundle, new RecommendForumsAction.RecommendActionBack() {
                    public void recommendActionBack(ArrayList<TapatalkForumForSearch> paramAnonymousArrayList) {
                        GroupBean localGroupBean;
                        int i;
                        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
                            if (ObRecommendListActivity.this.recommendAdapter.groupList.size() == 2) {
                                ObRecommendListActivity.this.recommendAdapter.groupList.remove(1);
                            }
                            localGroupBean = new GroupBean(ObRecommendListActivity.this.getString(2131100727));
                            i = 0;
                            if (i < paramAnonymousArrayList.size()) {
                                break label115;
                            }
                            ObRecommendListActivity.this.recommendAdapter.groupList.add(localGroupBean);
                            i = 0;
                        }
                        for (; ; ) {
                            if (i >= ObRecommendListActivity.this.recommendAdapter.groupList.size()) {
                                ObRecommendListActivity.this.recommendAdapter.notifyDataSetChanged();
                                return;
                                label115:
                                localGroupBean.setChildrenList(paramAnonymousArrayList);
                                if (i < 3) {
                                    ObRecommendListActivity.this.recommendAdapter.getForumsList().add((TapatalkForumForSearch) paramAnonymousArrayList.get(i));
                                }
                                i += 1;
                                break;
                            }
                            ObRecommendListActivity.this.groupTreeView.expandGroup(i);
                            i += 1;
                        }
                    }
                });
                this.done.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        paramAnonymousView = new FavoriateSqlHelper(ObRecommendListActivity.this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
                        ArrayList localArrayList = ObRecommendListActivity.this.recommendAdapter.getForumsList();
                        int i = 0;
                        if (i >= ObRecommendListActivity.this.addDatas.size()) {
                            i = 0;
                        }
                        for (; ; ) {
                            if (i >= localArrayList.size()) {
                                paramAnonymousView = new Intent(ObRecommendListActivity.this, AccountEntryActivity.class);
                                paramAnonymousView.putExtra(AccountEntryActivity.OB_ADDACCOUNTS, true);
                                paramAnonymousView.putExtra("fromOnboarding", true);
                                paramAnonymousView.setFlags(32768);
                                ObRecommendListActivity.this.startActivity(paramAnonymousView);
                                ObRecommendListActivity.this.obStack.finishActivities();
                                UserBehavior.logNOBMainPage(ObRecommendListActivity.this);
                                return;
                                paramAnonymousView.saveFavoriate((TapatalkForum) ObRecommendListActivity.this.addDatas.get(i));
                                i += 1;
                                break;
                            }
                            paramAnonymousView.saveFavoriate((TapatalkForum) localArrayList.get(i));
                            i += 1;
                        }
                    }
                });
                return;
                this.bottomLay = ((RelativeLayout) findViewById(2131231474));
                this.done = ((Button) findViewById(2131231480));
                this.bottomLay.setVisibility(0);
                break;
                label396:
                this.groupTreeView.setHeaderView(getLayoutInflater().inflate(2130903307, this.groupTreeView, false));
                break label188;
                label420:
                paramBundle.setChildrenList(this.addDatas);
                i += 1;
                break label248;
                label435:
                this.groupTreeView.expandGroup(i);
                i += 1;
                break label273;
            }
            paramBundle.add(((TapatalkForumForSearch) this.addDatas.get(i)).getId());
            i += 1;
        }
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            ObActivitiesStackManager.getInstance().finishSearchAndRecommend(this);
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObRecommendListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */