package com.quoord.tapatalkpro.ics.advancesearch;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import com.quoord.tapatalkpro.activity.forum.DrawerLayoutStatus;
import com.quoord.tapatalkpro.activity.forum.ForumActivityStatus;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.RebrandingConfig;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.ics.slidingMenu.TabItem;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;
import com.quoord.tools.TwoPanelController;

import java.util.ArrayList;

public class AdvanceSearchHistoryFragment
        extends QuoordFragment
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, TwoPanelController {
    public static boolean isFromResultFragment = false;
    public AdvanceSearchHistoryAdapter adapter = null;
    private ActionBar bar;
    private String forumId;
    private String forumName;
    private ForumStatus forumStatus = null;
    int i = 0;
    private ListView listView = null;
    private Activity mActivity;
    private SearchView mSearchView;
    private int menuId;
    private TextView searchDescribe1;
    private TextView searchDescribe2 = null;
    private ImageView searchImage = null;
    private String threadid;
    private String title;
    private View view;

    private void initActionBar() {
        this.bar.setNavigationMode(16);
        if ((this.title != null) && (!this.title.equals(""))) {
            this.bar.setTitle(this.title);
        }
        for (; ; ) {
            this.bar.setSubtitle(null);
            return;
            this.bar.setTitle(2131100129);
        }
    }

    public static AdvanceSearchHistoryFragment newInstance(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt) {
        paramActivity = new AdvanceSearchHistoryFragment();
        paramActivity.threadid = paramString1;
        paramActivity.forumId = paramString2;
        paramActivity.forumName = paramString3;
        paramActivity.menuId = paramInt;
        return paramActivity;
    }

    private void setkeyboard() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) AdvanceSearchHistoryFragment.this.getActivity().getSystemService("input_method")).toggleSoftInput(0, 2);
            }
        }, 300L);
    }

    private void setupSearchView() {
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
    }

    public BaseAdapter getAdapter() {
        return null;
    }

    public void hideKeyBoard() {
        try {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
            return;
        } catch (Exception localException) {
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        this.mActivity = getActivity();
        this.bar = getActivity().getActionBar();
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.forumStatus = ((ForumActivityStatus) getActivity()).getForumStatus();
        if (this.forumStatus != null) {
            this.adapter = new AdvanceSearchHistoryAdapter(getActivity(), this.forumStatus, this.listView, this.searchImage, this.searchDescribe1, this.searchDescribe2);
        }
        int j;
        if ((this.mActivity.getResources().getBoolean(2131558401)) && (this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null)) {
            paramBundle = this.forumStatus.getRebrandingConfig().getOrder();
            if ((this.forumStatus != null) && (this.forumStatus.getRebrandingConfig() != null) && (paramBundle != null) && (paramBundle.size() > 0)) {
                j = 0;
            }
        }
        for (; ; ) {
            if (j >= paramBundle.size()) {
                initActionBar();
                setkeyboard();
                return;
            }
            if (((TabItem) paramBundle.get(j)).getMenuid() == this.menuId) {
                this.title = ((TabItem) paramBundle.get(j)).getDisplay_name();
            }
            j += 1;
        }
    }

    public boolean onClose() {
        return false;
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        this.i += 1;
        paramMenuInflater.inflate(2131623936, paramMenu);
        paramMenu = paramMenu.findItem(2131231753);
        if (this.i == 1) {
            this.mSearchView = ((SearchView) paramMenu.getActionView());
            this.mSearchView.requestFocus();
        }
        try {
            int j = getResources().getIdentifier("android:id/search_mag_icon", null, null);
            ((ImageView) this.mSearchView.findViewById(j)).setImageResource(2130838902);
            setupSearchView();
            j = getResources().getIdentifier("android:id/search_plate", null, null);
            ((ViewGroup) this.mSearchView.findViewById(j)).setBackgroundResource(2130839292);
            this.i = 0;
            return;
        } catch (Exception paramMenu) {
            for (; ; ) {
            }
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        this.view = paramLayoutInflater.inflate(2130903056, null);
        this.searchImage = ((ImageView) this.view.findViewById(2131230804));
        this.searchImage.setBackgroundResource(ThemeUtil.getDrawableIdByPicNameDark("message_search", getActivity()));
        this.searchDescribe1 = ((TextView) this.view.findViewById(2131230805));
        this.searchDescribe2 = ((TextView) this.view.findViewById(2131230806));
        paramLayoutInflater = Typeface.createFromAsset(getActivity().getAssets(), "font/Roboto_Condensed.ttf");
        this.searchDescribe1.setTypeface(paramLayoutInflater);
        this.searchDescribe2.setTypeface(paramLayoutInflater);
        this.listView = ((ListView) this.view.findViewById(2131230803));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        return this.view;
    }

    public void onHiddenChanged(boolean paramBoolean) {
        if ((!paramBoolean) && (!isFromResultFragment)) {
            setkeyboard();
            initActionBar();
        }
        isFromResultFragment = false;
        super.onHiddenChanged(paramBoolean);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return true;
        }
        Util.hideSoftKeyb(getActivity(), this.mSearchView);
        return true;
    }

    public void onPrepareOptionsMenu(Menu paramMenu) {
        super.onPrepareOptionsMenu(paramMenu);
        if (((getActivity() instanceof DrawerLayoutStatus)) && (((DrawerLayoutStatus) getActivity()).isDrawMenuOpen())) {
        }
    }

    public boolean onQueryTextChange(String paramString) {
        return false;
    }

    public boolean onQueryTextSubmit(String paramString) {
        queryResult(paramString);
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
        this.mSearchView.clearFocus();
        return true;
    }

    public void queryResult(String paramString) {
        Object localObject1 = new AdvancesearchContrast();
        Object localObject2 = new AdvancesearchContrast();
        ((AdvancesearchContrast) localObject1).KEYWORD = paramString.trim();
        ((AdvancesearchContrast) localObject2).KEYWORD = paramString.trim();
        if ((this.forumId != null) && (!this.forumId.equals(""))) {
            ((AdvancesearchContrast) localObject1).FORUMID = this.forumId;
            ((AdvancesearchContrast) localObject2).FORUMID = this.forumId;
            ((AdvancesearchContrast) localObject1).FORUMNAME = this.forumName;
            ((AdvancesearchContrast) localObject2).FORUMNAME = this.forumName;
        }
        if ((this.threadid != null) && (!this.threadid.equals(""))) {
            ((AdvancesearchContrast) localObject1).THREADID = this.threadid;
            ((AdvancesearchContrast) localObject2).THREADID = this.threadid;
            ((AdvancesearchContrast) localObject1).SHOWPOSTS = true;
            ((AdvancesearchContrast) localObject2).SHOWPOSTS = true;
            ((AdvancesearchContrast) localObject1).TITLEONLY = false;
            ((AdvancesearchContrast) localObject2).TITLEONLY = false;
            paramString = AdvanceSearchResultFragment.newInstance(this.forumStatus, (AdvancesearchContrast) localObject1);
            if (!(getActivity() instanceof SlidingMenuActivity)) {
                break label194;
            }
            localObject1 = (SlidingMenuActivity) getActivity();
            localObject2 = (SlidingMenuActivity) getActivity();
            ((SlidingMenuActivity) localObject1).addFragmentToStack(paramString, "advance_fragment_stack_tag", true);
        }
        label194:
        while (!(getActivity() instanceof AdvanceSearchActivity)) {
            return;
            this.adapter.addSearchHistory((AdvancesearchContrast) localObject2);
            break;
        }
        localObject1 = (AdvanceSearchActivity) getActivity();
        localObject2 = (AdvanceSearchActivity) getActivity();
        ((AdvanceSearchActivity) localObject1).addFragmentToStack(paramString, "advance_fragment_stack_tag", true);
    }

    public void setActionBar(Activity paramActivity) {
        initActionBar();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/advancesearch/AdvanceSearchHistoryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */