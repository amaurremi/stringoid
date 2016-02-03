package com.quoord.tapatalkpro.activity.directory.ics;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.adapter.directory.ics.RebrandAdapter;
import com.quoord.tapatalkpro.bean.ForumItemBean;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.cache.AppCacheManager;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.ui.ButtomProgress;
import com.quoord.tapatalkpro.ui.ics.QuoordFragment;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class YukuSearchFragment
        extends QuoordFragment {
    private YukuSearchAdapter adapter = null;
    private ActionBar bar;
    private LinearLayout footLay;
    private FavoriateSqlHelper helper;
    private ListView listView;
    private Activity mActivity = null;
    public ArrayList<Object> mDatas = new ArrayList();
    private String query;
    private YukuForum yukuForum;

    public static YukuSearchFragment newInstance(String paramString) {
        YukuSearchFragment localYukuSearchFragment = new YukuSearchFragment();
        localYukuSearchFragment.query = paramString;
        return localYukuSearchFragment;
    }

    public void YukuForum() {
        this.mDatas = this.yukuForum.AddYukuForum();
        this.bar.setTitle(this.query + " - " + this.mDatas.size() + " " + this.mActivity.getResources().getString(2131099826));
        this.adapter.notifyDataSetChanged();
    }

    public YukuForum getYukuForum() {
        return this.yukuForum;
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        ThemeUtil.setTheme(getActivity());
        super.onCreate(paramBundle);
        this.mActivity = getActivity();
        this.bar = this.mActivity.getActionBar();
        this.bar.setDisplayShowTitleEnabled(true);
        this.bar.setDisplayHomeAsUpEnabled(true);
        this.bar.setTitle(this.query + this.mActivity.getResources().getString(2131099826));
        this.helper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        this.adapter = new YukuSearchAdapter();
        this.footLay = ButtomProgress.get(this.mActivity);
        setLoadingMoreEnabled(true);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                paramAnonymousAdapterView = (ForumItemBean) YukuSearchFragment.this.mDatas.get(paramAnonymousInt);
                paramAnonymousView = YukuSearchFragment.this.helper.getFavrivateById(paramAnonymousAdapterView.getForumId());
                if (paramAnonymousView != null) {
                    paramAnonymousView.openTapatalkForum(YukuSearchFragment.this.mActivity, false);
                }
                do {
                    return;
                    paramAnonymousView = new TapatalkForum();
                    paramAnonymousView.setId(Integer.valueOf(paramAnonymousAdapterView.getForumId()));
                    paramAnonymousView.setIconUrl(paramAnonymousAdapterView.getIconUrl());
                    paramAnonymousView.setName(paramAnonymousAdapterView.getForumName());
                    paramAnonymousView.setUrl(paramAnonymousAdapterView.getForumUrl());
                    paramAnonymousView.openTapatalkForum(YukuSearchFragment.this.mActivity, false);
                } while (!(YukuSearchFragment.this.mActivity instanceof IcsRebrandingEntryActivity));
                paramAnonymousView = ((IcsRebrandingEntryActivity) YukuSearchFragment.this.mActivity).allInOneFragment.adapter;
                if (!paramAnonymousView.forumItemId.contains(Integer.valueOf(paramAnonymousAdapterView.getForumId()))) {
                    paramAnonymousView.mDatas.add(paramAnonymousAdapterView);
                    paramAnonymousView.forumItemId.add(Integer.valueOf(paramAnonymousAdapterView.getForumId()));
                }
                AppCacheManager.cacheData(paramAnonymousView.cacheFile, paramAnonymousView.mDatas);
            }
        });
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903337, null);
        this.listView = ((ListView) paramLayoutInflater.findViewById(2131231395));
        this.listView.setDivider(null);
        this.listView.setSelector(2131165212);
        return paramLayoutInflater;
    }

    public void setLoadingMoreEnabled(boolean paramBoolean) {
        if ((paramBoolean) && (this.listView.getFooterViewsCount() == 0)) {
            this.listView.addFooterView(this.footLay);
        }
        while ((paramBoolean) || (this.listView.getFooterViewsCount() <= 0)) {
            return;
        }
        this.listView.removeFooterView(this.footLay);
    }

    public void setYukuForum(YukuForum paramYukuForum) {
        this.yukuForum = paramYukuForum;
    }

    public static class NoSearchResult {
        public static View getView(Context paramContext) {
            View localView = LayoutInflater.from(paramContext).inflate(2130903292, null);
            ((ImageView) localView.findViewById(2131230762)).setBackgroundResource(ThemeUtil.getDrawableIdByPicName("message_search", paramContext));
            ((TextView) localView.findViewById(2131230763)).setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "font/Roboto_Condensed.ttf"));
            return localView;
        }
    }

    public static abstract interface YukuForum {
        public abstract ArrayList<Object> AddYukuForum();
    }

    public class YukuSearchAdapter
            extends BaseAdapter {
        private Typeface tf = Typeface.createFromAsset(YukuSearchFragment.this.mActivity.getAssets(), "font/Roboto-Light.ttf");

        public YukuSearchAdapter() {
        }

        private void setSection(LinearLayout paramLinearLayout, String paramString) {
            TextView localTextView = new TextView(YukuSearchFragment.this.mActivity);
            paramLinearLayout.setBackgroundColor(-5588020);
            localTextView.setTextColor(-1);
            localTextView.setText(paramString.substring(0, 1).toUpperCase());
            localTextView.setTextSize(20.0F);
            localTextView.setPadding(5, 0, 0, 0);
            localTextView.setGravity(16);
            paramLinearLayout.addView(localTextView);
        }

        public int getCount() {
            return YukuSearchFragment.this.mDatas.size();
        }

        public Object getItem(int paramInt) {
            return YukuSearchFragment.this.mDatas.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public int getItemViewType(int paramInt) {
            if ((YukuSearchFragment.this.mDatas.get(paramInt) instanceof String)) {
                return 0;
            }
            return 1;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            if ((getItem(paramInt) instanceof String)) {
                new YukuSearchFragment.NoSearchResult();
                return YukuSearchFragment.NoSearchResult.getView(YukuSearchFragment.this.mActivity);
            }
            Object localObject = (ForumItemBean) YukuSearchFragment.this.mDatas.get(paramInt);
            label220:
            label243:
            int i;
            if (paramView == null) {
                paramView = YukuSearchFragment.this.mActivity.getLayoutInflater().inflate(2130903279, null);
                paramViewGroup = new ViewHolder(null);
                paramViewGroup.icon = ((ImageView) paramView.findViewById(2131230992));
                paramViewGroup.text = ((TextView) paramView.findViewById(2131230904));
                paramViewGroup.description = ((TextView) paramView.findViewById(2131230993));
                paramViewGroup.header = ((LinearLayout) paramView.findViewById(2131231398));
                paramViewGroup.textView = ((TextView) paramView.findViewById(2131230838));
                paramViewGroup.icon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", YukuSearchFragment.this.mActivity));
                paramView.setTag(paramViewGroup);
                if ((((ForumItemBean) localObject).getIconUrl() == null) || (((ForumItemBean) localObject).getIconUrl().equals("")) || (((ForumItemBean) localObject).getIconUrl().equals("null"))) {
                    break label380;
                }
                AvatarTool.showLogo(YukuSearchFragment.this.mActivity, paramViewGroup.icon, ((ForumItemBean) localObject).getIconUrl(), 5);
                if (paramInt % 2 != 1) {
                    break label405;
                }
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item1_color", YukuSearchFragment.this.mActivity));
                paramViewGroup.description.setTypeface(this.tf);
                paramViewGroup.description.setText(((ForumItemBean) localObject).getForumName());
                paramViewGroup.text.setText(((ForumItemBean) localObject).getForumUrl().replaceAll("https://", "").replaceAll("http://", "").replaceAll("/", ""));
                localObject = ((ForumItemBean) YukuSearchFragment.this.mDatas.get(paramInt)).getForumName();
                if ((localObject != null) && (!((String) localObject).equals(""))) {
                    i = ((String) localObject).toUpperCase().charAt(0);
                    if (paramInt != 0) {
                        break label424;
                    }
                    setSection(paramViewGroup.header, (String) localObject);
                }
            }
            for (; ; ) {
                paramViewGroup.textView.setText((CharSequence) localObject);
                return paramView;
                paramViewGroup = (ViewHolder) paramView.getTag();
                break;
                label380:
                paramViewGroup.icon.setImageDrawable(YukuSearchFragment.this.mActivity.getResources().getDrawable(2130837853));
                break label220;
                label405:
                paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item2_color", YukuSearchFragment.this.mActivity));
                break label243;
                label424:
                String str = ((ForumItemBean) YukuSearchFragment.this.mDatas.get(paramInt - 1)).getForumName();
                if ((str != null) && (!str.equals(""))) {
                    if (i != str.toUpperCase().charAt(0)) {
                        setSection(paramViewGroup.header, (String) localObject);
                        paramViewGroup.header.setVisibility(0);
                    } else {
                        paramViewGroup.header.setVisibility(8);
                    }
                }
            }
        }

        public int getViewTypeCount() {
            return 2;
        }

        private class ViewHolder {
            TextView description;
            LinearLayout header;
            ImageView icon;
            TextView text;
            TextView textView;

            private ViewHolder() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/activity/directory/ics/YukuSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */