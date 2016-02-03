package com.quoord.tapatalkpro.ics.advancesearch;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.bean.ForumStatus;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.ics.slidingMenu.SlidingMenuActivity;
import com.quoord.tapatalkpro.util.AdvancesearchContrast;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;
import java.util.Collections;

public class AdvanceSearchHistoryAdapter
        extends BaseAdapter {
    private String cacheFile;
    public ArrayList<AdvancesearchContrast> cachelist = new ArrayList();
    private LinearLayout clearView;
    private ForumStatus forumStatus = null;
    private boolean isNewHistory = false;
    public ArrayList<AdvancesearchContrast> list = new ArrayList();
    private ListView listView;
    private Activity mActivity;
    private TextView searchDescribe1;
    private TextView searchDescribe2 = null;
    private ImageView searchImage = null;

    public AdvanceSearchHistoryAdapter(Activity paramActivity, ForumStatus paramForumStatus, ListView paramListView, ImageView paramImageView, TextView paramTextView1, TextView paramTextView2) {
        this.mActivity = paramActivity;
        this.forumStatus = paramForumStatus;
        this.listView = paramListView;
        this.searchImage = paramImageView;
        this.searchDescribe1 = paramTextView1;
        this.searchDescribe2 = paramTextView2;
        this.cacheFile = AppCacheManager.getSearchHistoryUrl(paramActivity, paramForumStatus.getUrl(), paramForumStatus.tapatalkForum.getLowerUserName());
        if (AppCacheManager.checkFile(this.cacheFile)) {
            this.cachelist = ((ArrayList) AppCacheManager.getCacheData(this.cacheFile));
            if ((this.cachelist != null) && (this.cachelist.size() > 0)) {
                Collections.reverse(this.cachelist);
                this.list.addAll(this.cachelist);
            }
        }
        new ClearView();
        this.clearView = ClearView.get(this.mActivity);
        if ((this.list != null) && (this.list.size() > 0)) {
            paramActivity = new AdvancesearchContrast();
            this.list.add(paramActivity);
            paramImageView.setVisibility(8);
            paramTextView1.setVisibility(8);
            paramTextView2.setVisibility(8);
        }
        for (; ; ) {
            this.listView.setAdapter(this);
            this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    if (paramAnonymousInt == AdvanceSearchHistoryAdapter.this.getCount() - 1) {
                        AdvanceSearchHistoryAdapter.this.setClearOnclick();
                        return;
                    }
                    paramAnonymousAdapterView = AdvanceSearchResultFragment.newInstance(AdvanceSearchHistoryAdapter.this.forumStatus, (AdvancesearchContrast) AdvanceSearchHistoryAdapter.this.list.get(paramAnonymousInt));
                    if ((AdvanceSearchHistoryAdapter.this.mActivity instanceof SlidingMenuActivity)) {
                        ((SlidingMenuActivity) AdvanceSearchHistoryAdapter.this.mActivity).addFragmentToStack(paramAnonymousAdapterView, "advance_fragment_stack_tag", true);
                    }
                    for (; ; ) {
                        ((InputMethodManager) AdvanceSearchHistoryAdapter.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                        return;
                        if ((AdvanceSearchHistoryAdapter.this.mActivity instanceof AdvanceSearchActivity)) {
                            ((AdvanceSearchActivity) AdvanceSearchHistoryAdapter.this.mActivity).addFragmentToStack(paramAnonymousAdapterView, "advance_fragment_stack_tag", true);
                        }
                    }
                }
            });
            return;
            paramImageView.setVisibility(0);
            paramTextView1.setVisibility(0);
            paramTextView2.setVisibility(0);
        }
    }

    public void addSearchHistory(AdvancesearchContrast paramAdvancesearchContrast) {
        if (AppCacheManager.checkFile(this.cacheFile)) {
            this.cachelist = ((ArrayList) AppCacheManager.getCacheData(this.cacheFile));
        }
        this.searchImage.setVisibility(8);
        this.searchDescribe1.setVisibility(8);
        this.searchDescribe2.setVisibility(8);
        if (this.cachelist == null) {
            this.cachelist = new ArrayList();
        }
        if (this.cachelist.size() <= 0) {
            this.cachelist.add(paramAdvancesearchContrast);
            if (this.cachelist.size() > 20) {
                this.cachelist.remove(0);
            }
            if (AppCacheManager.checkFile(this.cacheFile)) {
                AppCacheManager.del(this.cacheFile);
            }
            cacheSearchHistory();
            this.list.clear();
            Collections.reverse(this.cachelist);
            this.list.addAll(this.cachelist);
            if ((this.list != null) && (this.list.size() > 0)) {
                paramAdvancesearchContrast = new AdvancesearchContrast();
                this.list.add(paramAdvancesearchContrast);
            }
            notifyDataSetChanged();
            return;
        }
        int i = 0;
        for (; ; ) {
            if (i >= this.cachelist.size()) {
                if (!this.isNewHistory) {
                    break;
                }
                this.cachelist.add(paramAdvancesearchContrast);
                break;
            }
            if (((AdvancesearchContrast) this.cachelist.get(i)).equals(paramAdvancesearchContrast)) {
                break label257;
            }
            this.isNewHistory = true;
            i += 1;
        }
        label257:
        this.isNewHistory = false;
    }

    public void cacheSearchHistory() {
        AppCacheManager.cacheData(this.cacheFile, this.cachelist);
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int paramInt) {
        return this.list.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if ((getCount() > 0) && (getCount() - 1 == paramInt)) {
            return 1;
        }
        return 0;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (getItemViewType(paramInt) == 1) {
            paramView = this.clearView;
        }
        View localView1;
        View localView2;
        ImageView localImageView1;
        label202:
        label315:
        label402:
        label544:
        label549:
        label599:
        label609:
        label626:
        label696:
        do {
            return paramView;
            localView1 = LayoutInflater.from(this.mActivity).inflate(2130903058, null);
            localView2 = localView1.findViewById(2131230808);
            ImageView localImageView2 = (ImageView) localView1.findViewById(2131230809);
            localImageView1 = (ImageView) localView1.findViewById(2131230814);
            TextView localTextView1 = (TextView) localView1.findViewById(2131230811);
            TextView localTextView2 = (TextView) localView1.findViewById(2131230812);
            TextView localTextView3 = (TextView) localView1.findViewById(2131230813);
            localImageView1.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_item_diver", this.mActivity));
            if ((((AdvancesearchContrast) this.list.get(paramInt)).KEYWORD != null) && (!((AdvancesearchContrast) this.list.get(paramInt)).KEYWORD.equals(""))) {
                localTextView1.setText(((AdvancesearchContrast) this.list.get(paramInt)).KEYWORD);
                if (!((AdvancesearchContrast) this.list.get(paramInt)).TITLEONLY) {
                    break label544;
                }
                paramView = this.mActivity.getResources().getString(2131100145);
                paramViewGroup = paramView;
                if (((AdvancesearchContrast) this.list.get(paramInt)).USERNAME != null) {
                    paramViewGroup = paramView;
                    if (!((AdvancesearchContrast) this.list.get(paramInt)).USERNAME.equals("")) {
                        if ((paramView == null) || (paramView.equals(""))) {
                            break label549;
                        }
                        paramViewGroup = paramView + ", " + this.mActivity.getResources().getString(2131100146) + ((AdvancesearchContrast) this.list.get(paramInt)).USERNAME.trim();
                    }
                }
                if ((((AdvancesearchContrast) this.list.get(paramInt)).FORUMNAME == null) || (((AdvancesearchContrast) this.list.get(paramInt)).FORUMNAME.equals(""))) {
                    break label599;
                }
                localTextView3.setText(this.mActivity.getResources().getString(2131100147) + ((AdvancesearchContrast) this.list.get(paramInt)).FORUMNAME);
                if (((AdvancesearchContrast) this.list.get(paramInt)).SHOWPOSTS) {
                    break label626;
                }
                if ((paramViewGroup == null) || (paramViewGroup.equals(""))) {
                    break label609;
                }
                paramView = paramViewGroup + ", " + this.mActivity.getResources().getString(2131100143);
            }
            for (; ; ) {
                localTextView2.setText(paramView);
                if (paramInt != 0) {
                    break label696;
                }
                localView2.setBackgroundResource(ThemeUtil.getDialogDrawableId("forum_top_item_bg", this.mActivity));
                localImageView1.setVisibility(0);
                localTextView1.setPadding(0, 13, 0, 0);
                localImageView2.setPadding(0, 13, 0, 0);
                return localView1;
                localTextView1.setText(this.mActivity.getResources().getString(2131100392));
                break;
                paramView = null;
                break label202;
                paramViewGroup = this.mActivity.getResources().getString(2131100146) + ((AdvancesearchContrast) this.list.get(paramInt)).USERNAME.trim();
                break label315;
                localTextView3.setVisibility(8);
                break label402;
                paramView = this.mActivity.getResources().getString(2131100143);
                continue;
                if ((paramViewGroup != null) && (!paramViewGroup.equals(""))) {
                    paramView = paramViewGroup + ", " + this.mActivity.getResources().getString(2131100144);
                } else {
                    paramView = this.mActivity.getResources().getString(2131100144);
                }
            }
            paramView = localView1;
        } while (paramInt == getCount() - 1);
        localView2.setBackgroundResource(ThemeUtil.getDialogDrawableId("forum_mid_item_bg", this.mActivity));
        localImageView1.setVisibility(0);
        return localView1;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void setClearOnclick() {
        this.list.clear();
        this.cachelist.clear();
        AppCacheManager.del(this.cacheFile);
        this.listView.removeFooterView(this.clearView);
        this.searchImage.setVisibility(0);
        this.searchDescribe1.setVisibility(0);
        this.searchDescribe2.setVisibility(0);
        notifyDataSetChanged();
    }

    static class ClearView {
        public static LinearLayout get(Activity paramActivity) {
            LinearLayout localLinearLayout = (LinearLayout) LayoutInflater.from(paramActivity).inflate(2130903055, null);
            ((TextView) localLinearLayout.findViewById(2131230802)).setBackgroundDrawable(ThemeUtil.getDrawableByPicName("forum_bottom_item_bg", paramActivity));
            return localLinearLayout;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/advancesearch/AdvanceSearchHistoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */