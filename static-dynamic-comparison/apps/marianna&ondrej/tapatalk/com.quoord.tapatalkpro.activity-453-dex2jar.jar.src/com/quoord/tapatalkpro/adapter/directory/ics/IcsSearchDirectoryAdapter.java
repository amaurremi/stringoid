package com.quoord.tapatalkpro.adapter.directory.ics;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.onboarding.action.SearchForumAction;
import com.quoord.onboarding.action.SearchForumAction.SearchForumActionBack;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.TapatalkAccountAction;
import com.quoord.tapatalkpro.adapter.CallBackInterface;
import com.quoord.tapatalkpro.bean.EngineResponse;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ForumOnClick;
import com.quoord.tapatalkpro.util.TapatalkJsonEngine;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tools.tracking.GoogleAnalyticsTools;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IcsSearchDirectoryAdapter
        extends BaseAdapter
        implements CallBackInterface {
    private LinearLayout bottomProgressLay;
    private ArrayList<TapatalkForum> cloudAccounts;
    public String cloudCachePath;
    private int currentPage = 1;
    private TapatalkJsonEngine engine = null;
    ViewHolder holder;
    public boolean isFootNeeded = true;
    private boolean isLoding = false;
    private boolean isOpCancel = false;
    private boolean loadFinished = false;
    private Activity mContext;
    public ArrayList<Object> mDatas = new ArrayList();
    private LinearLayout noLay;
    private int perpage = 20;
    private LinearLayout progressLay;
    private String queryString;
    private ListView resultGridView;
    private SearchForumAction searchForumAction;

    public IcsSearchDirectoryAdapter(Activity paramActivity, String paramString, ListView paramListView, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {
        this.mContext = paramActivity;
        this.searchForumAction = new SearchForumAction(paramActivity, false);
        this.resultGridView = paramListView;
        this.progressLay = paramLinearLayout1;
        this.bottomProgressLay = paramLinearLayout2;
        this.noLay = paramLinearLayout3;
        this.queryString = paramString;
        this.resultGridView.setAdapter(this);
        this.engine = new TapatalkJsonEngine(this.mContext, this);
        getSearchForum(this.queryString, true);
        GoogleAnalyticsTools.trackPageView(this.mContext, "tap_search");
        this.resultGridView.setOnItemClickListener(new OnItemClickListener2());
        this.resultGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
                paramAnonymousInt1 += paramAnonymousInt2;
                if ((paramAnonymousInt1 != 0) && (paramAnonymousInt1 == paramAnonymousInt3) && (!IcsSearchDirectoryAdapter.this.isLoding) && (!IcsSearchDirectoryAdapter.this.loadFinished)) {
                    IcsSearchDirectoryAdapter.this.getSearchForum(IcsSearchDirectoryAdapter.this.queryString, false);
                }
            }

            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            }
        });
    }

    private void formatResponseData(JSONArray paramJSONArray) {
        int i = 0;
        for (; ; ) {
            if (i >= paramJSONArray.length()) {
                notifyDataSetChanged();
                return;
            }
            try {
                JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                this.mDatas.add(TapatalkForum.getForum(localJSONObject, null, null, null));
                i += 1;
            } catch (JSONException localJSONException) {
                for (; ; ) {
                    localJSONException.printStackTrace();
                }
            }
        }
    }

    public void callBack(EngineResponse paramEngineResponse) {
        this.isLoding = false;
        if (this.progressLay.getVisibility() == 0) {
            this.progressLay.setVisibility(8);
        }
        this.bottomProgressLay.setVisibility(8);
        if (paramEngineResponse != null) {
            try {
                boolean bool = Boolean.valueOf(paramEngineResponse.isSuccess()).booleanValue();
                if (bool) {
                    try {
                        String str = paramEngineResponse.getMethod();
                        int i = str.indexOf("page");
                        i = Integer.valueOf(str.substring(i + 5, i + 6)).intValue();
                        paramEngineResponse = (JSONArray) paramEngineResponse.getResponse();
                        if ((i == this.currentPage) && (paramEngineResponse.length() > 0)) {
                            this.currentPage += 1;
                            formatResponseData(paramEngineResponse);
                            return;
                        }
                        this.loadFinished = true;
                        if (this.currentPage == 1) {
                            this.noLay.setVisibility(0);
                            return;
                        }
                    } catch (Exception paramEngineResponse) {
                        paramEngineResponse.printStackTrace();
                        paramEngineResponse = this.mContext.getResources().getString(2131100069);
                        Toast.makeText(this.mContext, paramEngineResponse, 1).show();
                        return;
                    }
                }
                return;
            } catch (Exception paramEngineResponse) {
            }
        }
    }

    public void cancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        try {
            Object localObject = this.mDatas.get(paramInt);
            return localObject;
        } catch (Exception localException) {
        }
        return null;
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public void getSearchForum(String paramString, boolean paramBoolean) {
        if (paramBoolean) {
            this.mDatas.clear();
            notifyDataSetChanged();
            this.loadFinished = false;
            this.currentPage = 1;
            this.queryString = paramString;
        }
        this.noLay.setVisibility(8);
        if (this.currentPage != 1) {
            this.isLoding = true;
            this.bottomProgressLay.setVisibility(0);
        }
        for (; ; ) {
            if ((this.queryString != null) && (!this.queryString.equals(""))) {
                v2SearchForums();
            }
            return;
            this.progressLay.setVisibility(0);
            this.bottomProgressLay.setVisibility(8);
        }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (paramView == null) {
            this.holder = new ViewHolder(null);
            paramView = this.mContext.getLayoutInflater().inflate(2130903211, null);
            this.holder.forumIcon = ((ImageView) paramView.findViewById(2131231177));
            this.holder.forumName = ((TextView) paramView.findViewById(2131231178));
            this.holder.description = ((TextView) paramView.findViewById(2131231251));
            this.holder.proboard = ((ImageView) paramView.findViewById(2131231014));
            this.holder.forumIcon.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("avator_background", this.mContext));
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                this.holder.forumName.setTextColor(this.mContext.getResources().getColor(2131165213));
            }
            paramView.setTag(this.holder);
            if (paramInt % 2 != 1) {
                break label422;
            }
            paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item1_color", this.mContext));
            label181:
            if ((((TapatalkForum) getItem(paramInt)).getType() == null) || (!((TapatalkForum) getItem(paramInt)).getType().equals("proboards"))) {
                break label439;
            }
            this.holder.proboard.setVisibility(0);
            label226:
            int i = this.mContext.getResources().getDimensionPixelOffset(2131427407);
            paramView.setPadding(0, i, 0, i);
            this.holder.forumName.setText(((TapatalkForum) getItem(paramInt)).getName());
            this.holder.description.setText(((TapatalkForum) getItem(paramInt)).getDescription());
            this.holder.selectedicon = ((ImageView) paramView.findViewById(2131231252));
            this.holder.selected = ((LinearLayout) paramView.findViewById(2131231040));
            if (!isFavoriate(paramInt, this.mContext, ((TapatalkForum) getItem(paramInt)).getId().intValue())) {
                break label454;
            }
            this.holder.selectedicon.setImageResource(2130837513);
            this.holder.selected.setClickable(false);
        }
        for (; ; ) {
            AvatarTool.showLogo(this.mContext, this.holder.forumIcon, ((TapatalkForum) this.mDatas.get(paramInt)).getIconUrl(), 5);
            return paramView;
            this.holder = ((ViewHolder) paramView.getTag());
            break;
            label422:
            paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item2_color", this.mContext));
            break label181;
            label439:
            this.holder.proboard.setVisibility(8);
            break label226;
            label454:
            this.holder.selectedicon.setImageResource(2130837512);
            this.holder.selected.setOnClickListener(new ForumOnClick(((TapatalkForum) getItem(paramInt)).getId().intValue(), (TapatalkForum) this.mDatas.get(paramInt), this.mContext, this.holder.selectedicon, this.holder.selected, "search"));
        }
    }

    public boolean isEnabled(int paramInt) {
        return true;
    }

    public boolean isFavoriate(int paramInt1, Context paramContext, int paramInt2) {
        paramContext = TapatalkAccountAction.getCurrnentAllAccount(this.mContext);
        paramInt1 = 0;
        for (; ; ) {
            if (paramInt1 >= paramContext.size()) {
                return false;
            }
            if (paramInt2 == ((TapatalkForum) paramContext.get(paramInt1)).getId().intValue()) {
                return true;
            }
            paramInt1 += 1;
        }
    }

    public boolean isOpCancel() {
        return this.isOpCancel;
    }

    public void saveFavoriate(int paramInt, Context paramContext) {
        paramContext = (TapatalkForum) this.mDatas.get(paramInt);
        FavoriateSqlHelper localFavoriateSqlHelper = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        TapatalkForum localTapatalkForum = localFavoriateSqlHelper.getFavrivateById(paramContext.getId());
        if ((localTapatalkForum == null) || (localTapatalkForum.getId().intValue() != paramContext.getId().intValue())) {
            localFavoriateSqlHelper.saveFavoriate(paramContext);
        }
    }

    public void setOpCancel(boolean paramBoolean) {
        this.isOpCancel = paramBoolean;
    }

    public void updateSubclassDialog(int paramInt) {
    }

    public void v2SearchForums() {
        this.searchForumAction.v2SearchForums(this.queryString, this.currentPage, new SearchForumAction.SearchForumActionBack() {
            public void SearchActionBack(ArrayList<Object> paramAnonymousArrayList) {
                IcsSearchDirectoryAdapter.this.isLoding = false;
                if (IcsSearchDirectoryAdapter.this.progressLay.getVisibility() == 0) {
                    IcsSearchDirectoryAdapter.this.progressLay.setVisibility(8);
                }
                IcsSearchDirectoryAdapter.this.bottomProgressLay.setVisibility(8);
                if (paramAnonymousArrayList != null) {
                }
                try {
                    if (paramAnonymousArrayList.size() != 0) {
                        IcsSearchDirectoryAdapter localIcsSearchDirectoryAdapter = IcsSearchDirectoryAdapter.this;
                        localIcsSearchDirectoryAdapter.currentPage += 1;
                        IcsSearchDirectoryAdapter.this.mDatas.addAll(paramAnonymousArrayList);
                    }
                    for (; ; ) {
                        IcsSearchDirectoryAdapter.this.notifyDataSetChanged();
                        return;
                        IcsSearchDirectoryAdapter.this.loadFinished = true;
                        if (IcsSearchDirectoryAdapter.this.currentPage == 1) {
                            IcsSearchDirectoryAdapter.this.noLay.setVisibility(0);
                        }
                    }
                } catch (Exception paramAnonymousArrayList) {
                    for (; ; ) {
                        paramAnonymousArrayList.printStackTrace();
                        paramAnonymousArrayList = IcsSearchDirectoryAdapter.this.mContext.getResources().getString(2131100069);
                        Toast.makeText(IcsSearchDirectoryAdapter.this.mContext, paramAnonymousArrayList, 1).show();
                    }
                }
            }
        }, false, true);
    }

    class OnItemClickListener2
            implements AdapterView.OnItemClickListener {
        OnItemClickListener2() {
        }

        public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
            if ((IcsSearchDirectoryAdapter.this.getItem(paramInt) instanceof TapatalkForum)) {
                paramAdapterView = (TapatalkForum) IcsSearchDirectoryAdapter.this.getItem(paramInt);
                IcsSearchDirectoryAdapter.this.saveFavoriate(paramInt, IcsSearchDirectoryAdapter.this.mContext);
                paramAdapterView.openTapatalkForum(IcsSearchDirectoryAdapter.this.mContext, false);
            }
        }
    }

    private static class ViewHolder {
        TextView description;
        ImageView forumIcon;
        TextView forumName;
        View forum_layout;
        ImageView proboard;
        LinearLayout selected;
        ImageView selectedicon;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/IcsSearchDirectoryAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */