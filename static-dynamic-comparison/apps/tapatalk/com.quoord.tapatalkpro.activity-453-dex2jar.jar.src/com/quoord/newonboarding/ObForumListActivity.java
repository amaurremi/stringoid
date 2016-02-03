package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.onboarding.action.GetCategoryRecommedForumAction;
import com.quoord.onboarding.action.GetCategoryRecommedForumAction.SubSearchForumActionBack;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.activity.directory.ics.AccountEntryActivity;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;

public class ObForumListActivity
        extends Activity {
    private RelativeLayout bottomLay;
    private ObForumResultAdapter caregoryResultAdapter;
    private ArrayList<String> categoryIds = new ArrayList();
    private RelativeLayout contentLay;
    private int currentPage = 1;
    private ArrayList<TapatalkForumForSearch> datas = new ArrayList();
    public Button done;
    private ListView forumList;
    private GetCategoryRecommedForumAction getRecommendForumAction;
    private boolean isFinished = false;
    private boolean isloading = false;
    private View mBottomProcessView = null;
    private TextView noDataView;
    private ObActivitiesStackManager obStack;
    private ProgressBar progress;
    private TextView t1;
    private TextView t2;

    private void getForums() {
        if (this.currentPage == 1) {
            if (this.forumList.getFooterViewsCount() > 0) {
                this.forumList.removeFooterView(this.mBottomProcessView);
            }
        }
        for (; ; ) {
            this.isloading = true;
            this.getRecommendForumAction.searchForums(this.categoryIds, this.currentPage, new GetCategoryRecommedForumAction.SubSearchForumActionBack() {
                public void getRecommendActionBack(ArrayList<TapatalkForumForSearch> paramAnonymousArrayList) {
                    ObForumListActivity.this.contentLay.setVisibility(0);
                    ObForumListActivity.this.progress.setVisibility(8);
                    ObForumListActivity.this.isloading = false;
                    int i;
                    if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
                        if (ObForumListActivity.this.currentPage == 1) {
                            if (paramAnonymousArrayList.get(0) != null) {
                                ObForumListActivity.this.caregoryResultAdapter.getAddDatas().add((TapatalkForumForSearch) paramAnonymousArrayList.get(0));
                            }
                            if (paramAnonymousArrayList.get(1) != null) {
                                ObForumListActivity.this.caregoryResultAdapter.getAddDatas().add((TapatalkForumForSearch) paramAnonymousArrayList.get(1));
                            }
                            if (paramAnonymousArrayList.get(2) != null) {
                                ObForumListActivity.this.caregoryResultAdapter.getAddDatas().add((TapatalkForumForSearch) paramAnonymousArrayList.get(2));
                            }
                            if (ObForumListActivity.this.categoryIds.size() > 3) {
                                i = 3;
                                if (i < ObForumListActivity.this.categoryIds.size()) {
                                    break label276;
                                }
                            }
                        }
                        if (paramAnonymousArrayList.size() < 20) {
                            ObForumListActivity.this.isFinished = true;
                        }
                        ObForumListActivity localObForumListActivity = ObForumListActivity.this;
                        localObForumListActivity.currentPage += 1;
                        ObForumListActivity.this.datas.addAll(paramAnonymousArrayList);
                        ObForumListActivity.this.caregoryResultAdapter.setDatas(ObForumListActivity.this.datas);
                        ObForumListActivity.this.caregoryResultAdapter.notifyDataSetChanged();
                    }
                    for (; ; ) {
                        if (ObForumListActivity.this.forumList.getFooterViewsCount() > 0) {
                            ObForumListActivity.this.forumList.removeFooterView(ObForumListActivity.this.mBottomProcessView);
                        }
                        return;
                        label276:
                        if (paramAnonymousArrayList.get(i) != null) {
                            ObForumListActivity.this.caregoryResultAdapter.getAddDatas().add((TapatalkForumForSearch) paramAnonymousArrayList.get(i));
                        }
                        i += 1;
                        break;
                        ObForumListActivity.this.isFinished = true;
                        if (ObForumListActivity.this.currentPage == 1) {
                            ObForumListActivity.this.noDataView.setVisibility(0);
                            ObForumListActivity.this.bottomLay.setVisibility(8);
                        }
                    }
                }
            });
            return;
            if (this.forumList.getFooterViewsCount() == 0) {
                this.forumList.addFooterView(this.mBottomProcessView);
            }
        }
    }

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
        setTheme(2131361805);
        super.onCreate(paramBundle);
        setContentView(2130903298);
        GoogleAnalyticsTools.trackPageView(this, "ob_category_result_view");
        UserBehavior.logNOBAddForums(this);
        this.obStack = ObActivitiesStackManager.getInstance();
        this.obStack.addActivity(this);
        getActionBar().hide();
        this.t1 = ((TextView) findViewById(2131231326));
        this.t2 = ((TextView) findViewById(2131231327));
        initTextFont();
        this.forumList = ((ListView) findViewById(2131231482));
        this.progress = ((ProgressBar) findViewById(2131230891));
        this.noDataView = ((TextView) findViewById(2131231478));
        if (Util.isHDDevice(this)) {
            this.bottomLay = ((RelativeLayout) findViewById(2131231475));
            this.done = ((Button) findViewById(2131231481));
            this.bottomLay.setVisibility(0);
        }
        for (; ; ) {
            this.bottomLay.bringToFront();
            this.contentLay = ((RelativeLayout) findViewById(2131231472));
            this.mBottomProcessView = ButtomProgress.get(this);
            this.caregoryResultAdapter = new ObForumResultAdapter(this);
            this.forumList.addFooterView(this.mBottomProcessView);
            this.forumList.setAdapter(this.caregoryResultAdapter);
            this.categoryIds = getIntent().getExtras().getStringArrayList("selectedCategories");
            this.getRecommendForumAction = new GetCategoryRecommedForumAction(this);
            getForums();
            this.forumList.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    paramAnonymousInt1 += paramAnonymousInt2;
                    if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (!ObForumListActivity.this.isloading) && (!ObForumListActivity.this.isFinished)) {
                        ObForumListActivity.this.getForums();
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            this.done.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    ArrayList localArrayList;
                    int i;
                    if (ObForumListActivity.this.caregoryResultAdapter.getAddDatas().size() > 0) {
                        paramAnonymousView = new FavoriateSqlHelper(ObForumListActivity.this, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
                        localArrayList = ObForumListActivity.this.caregoryResultAdapter.getAddDatas();
                        i = 0;
                    }
                    for (; ; ) {
                        if (i >= localArrayList.size()) {
                            paramAnonymousView = new Intent(ObForumListActivity.this, AccountEntryActivity.class);
                            paramAnonymousView.putExtra(AccountEntryActivity.OB_ADDACCOUNTS, true);
                            paramAnonymousView.putExtra("fromOnboarding", true);
                            paramAnonymousView.setFlags(32768);
                            ObForumListActivity.this.startActivity(paramAnonymousView);
                            ObForumListActivity.this.obStack.finishActivities();
                            UserBehavior.logNOBMainPage(ObForumListActivity.this);
                            return;
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
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObForumListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */