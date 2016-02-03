package com.quoord.newonboarding;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import com.quoord.tapatalkpro.action.GetHotTermsAction;
import com.quoord.tapatalkpro.action.GetHotTermsAction.ActionBack;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction;
import com.quoord.tapatalkpro.ics.action.IcsSearchForumAction.IcsSearchForumActionBack;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.SearchKeyWordsLayout;
import com.quoord.tapatalkpro.util.CustomTracker;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.UserBehavior;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;

public class ObSearchActivity
        extends Activity {
    private static final int PER_PAGE = 20;
    private SearchKeyWordsLayout contacts;
    private RelativeLayout contentView;
    private ArrayList<TapatalkForumForSearch> datas = new ArrayList();
    private GetHotTermsAction getHotTermsAction;
    private ScrollView hotTermLayout;
    private boolean isFinished = false;
    private boolean isHot = false;
    private boolean isloading = false;
    private String keyword = "";
    private ListView listview;
    private View mBottomProcessView = null;
    private TextView noDataView;
    private int page = 1;
    private ProgressBar progress;
    private IcsSearchForumAction searchForumAction;
    private MenuItem searchMenuItem;
    private ObForumResultAdapter searchResultAdapter;
    private SearchView searchView;

    private void addKeyWordView(ArrayList<String> paramArrayList) {
        this.contacts.removeAllViewsInLayout();
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayList.size()) {
                return;
            }
            View localView = LayoutInflater.from(this).inflate(2130903237, null);
            TextView localTextView = (TextView) localView.findViewById(2131231300);
            localTextView.setPadding(20, 10, 20, 10);
            final String str = (String) paramArrayList.get(i);
            localTextView.setText(str);
            localTextView.setLines(1);
            localTextView.setTextColor(getResources().getColor(2131165571));
            localTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    ObSearchActivity.this.showProgress(true);
                    ObSearchActivity.this.isHot = true;
                    ObSearchActivity.this.searchView.setQuery(str, false);
                    ObSearchActivity.this.noDataView.setVisibility(8);
                    ObSearchActivity.this.searchForum(str);
                    Util.hideSoftKeyb(ObSearchActivity.this, ObSearchActivity.this.searchView);
                }
            });
            this.contacts.addView(localView);
            i += 1;
        }
    }

    private void createSearchMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131623939, paramMenu);
        this.searchMenuItem = paramMenu.findItem(2131231471);
        SearchManager localSearchManager = (SearchManager) getSystemService("search");
        this.searchView = ((SearchView) paramMenu.findItem(2131231471).getActionView());
        try {
            int i = getResources().getIdentifier("android:id/search_mag_icon", null, null);
            ((ImageView) this.searchView.findViewById(i)).setImageResource(2130838902);
            this.searchView.setFocusable(false);
            this.searchView.setQuery(this.keyword, false);
            this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean onQueryTextChange(String paramAnonymousString) {
                    return true;
                }

                public boolean onQueryTextSubmit(String paramAnonymousString) {
                    ObSearchActivity.this.showProgress(true);
                    ObSearchActivity.this.page = 1;
                    ObSearchActivity.this.datas.clear();
                    ObSearchActivity.this.isHot = false;
                    ObSearchActivity.this.noDataView.setVisibility(8);
                    ObSearchActivity.this.searchForum(paramAnonymousString);
                    ObSearchActivity.this.searchView.setQuery(paramAnonymousString, false);
                    Util.hideSoftKeyb(ObSearchActivity.this, ObSearchActivity.this.searchView);
                    return true;
                }
            });
            return;
        } catch (Exception paramMenu) {
            for (; ; ) {
            }
        }
    }

    private static void hideSearchIcon(View paramView) {
        if ((paramView instanceof ViewGroup)) {
            paramView = (ViewGroup) paramView;
            i = 0;
            if (i < paramView.getChildCount()) {
            }
        }
        while (!(paramView instanceof ImageView)) {
            for (; ; ) {
                int i;
                return;
                hideSearchIcon(paramView.getChildAt(i));
                i += 1;
            }
        }
        paramView.setVisibility(8);
    }

    private void showProgress(boolean paramBoolean) {
        if (paramBoolean) {
            this.progress.setVisibility(0);
            this.listview.setVisibility(8);
            return;
        }
        this.progress.setVisibility(8);
        this.listview.setVisibility(0);
    }

    protected void onCreate(Bundle paramBundle) {
        Util.setPortrait(this);
        setTheme(2131361806);
        super.onCreate(paramBundle);
        setContentView(2130903301);
        GoogleAnalyticsTools.trackPageView(this, "ob_search_view");
        UserBehavior.logNOBSearchReslut(this);
        ObActivitiesStackManager.getInstance().addActivity(this);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (Util.isHDDevice(this)) {
            getActionBar().setIcon(2130839532);
        }
        for (; ; ) {
            getActionBar().setTitle("");
            this.contentView = ((RelativeLayout) findViewById(2131231472));
            this.listview = ((ListView) findViewById(2131231482));
            this.progress = ((ProgressBar) findViewById(2131230891));
            this.hotTermLayout = ((ScrollView) findViewById(2131231483));
            this.contacts = ((SearchKeyWordsLayout) findViewById(2131231323));
            this.noDataView = ((TextView) findViewById(2131231478));
            this.mBottomProcessView = ButtomProgress.get(this);
            this.searchResultAdapter = new ObForumResultAdapter(this);
            this.listview.addFooterView(this.mBottomProcessView);
            this.listview.setAdapter(this.searchResultAdapter);
            this.searchForumAction = new IcsSearchForumAction(this);
            this.getHotTermsAction = new GetHotTermsAction(this);
            this.getHotTermsAction.getHotTerms(new GetHotTermsAction.ActionBack() {
                public void getActionBack(ArrayList<String> paramAnonymousArrayList) {
                    ObSearchActivity.this.hotTermLayout.setVisibility(0);
                    ObSearchActivity.this.addKeyWordView(paramAnonymousArrayList);
                }
            });
            this.listview.setOnScrollListener(new AbsListView.OnScrollListener() {
                public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                    paramAnonymousInt1 += paramAnonymousInt2;
                    if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (!ObSearchActivity.this.isloading) && (!ObSearchActivity.this.isFinished)) {
                        ObSearchActivity.this.searchForum(ObSearchActivity.this.keyword);
                    }
                }

                public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
                }
            });
            return;
            getActionBar().setIcon(2130839531);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public boolean onPrepareOptionsMenu(Menu paramMenu) {
        createSearchMenu(paramMenu);
        return super.onPrepareOptionsMenu(paramMenu);
    }

    public void onStart() {
        super.onStart();
        CustomTracker.start(this);
    }

    public void onStop() {
        super.onStop();
        CustomTracker.stop(this);
    }

    public void searchForum(String paramString) {
        if (this.page == 1) {
            if (this.listview.getFooterViewsCount() > 0) {
                this.listview.removeFooterView(this.mBottomProcessView);
            }
        }
        for (; ; ) {
            this.isloading = true;
            this.keyword = paramString;
            this.hotTermLayout.setVisibility(8);
            this.contentView.setVisibility(0);
            this.searchForumAction.icsSearchForum(paramString, this.page, 20, this.isHot, new IcsSearchForumAction.IcsSearchForumActionBack() {
                public void searchForumActionBack(ArrayList<TapatalkForumForSearch> paramAnonymousArrayList) {
                    ObSearchActivity.this.hotTermLayout.setVisibility(8);
                    ObSearchActivity.this.showProgress(false);
                    ObSearchActivity.this.isloading = false;
                    if (ObSearchActivity.this.listview.getFooterViewsCount() > 0) {
                        ObSearchActivity.this.listview.removeFooterView(ObSearchActivity.this.mBottomProcessView);
                    }
                    if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
                        localObSearchActivity = ObSearchActivity.this;
                        localObSearchActivity.page += 1;
                        if (paramAnonymousArrayList.size() < 20) {
                            ObSearchActivity.this.isFinished = true;
                        }
                        ObSearchActivity.this.datas.addAll(paramAnonymousArrayList);
                        ObSearchActivity.this.searchResultAdapter.setDatas(ObSearchActivity.this.datas);
                        ObSearchActivity.this.searchResultAdapter.notifyDataSetChanged();
                    }
                    while (ObSearchActivity.this.page != 1) {
                        ObSearchActivity localObSearchActivity;
                        return;
                    }
                    ObSearchActivity.this.noDataView.setVisibility(0);
                }
            });
            return;
            if (this.listview.getFooterViewsCount() == 0) {
                this.listview.addFooterView(this.mBottomProcessView);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */