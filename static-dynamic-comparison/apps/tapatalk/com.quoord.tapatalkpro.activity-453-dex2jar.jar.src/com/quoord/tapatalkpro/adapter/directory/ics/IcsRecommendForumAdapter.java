package com.quoord.tapatalkpro.adapter.directory.ics;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.action.AddToFavoriate;
import com.quoord.tapatalkpro.activity.directory.ics.IcsRecommendActivity;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView.SearchForumTag;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;

import java.util.ArrayList;

public class IcsRecommendForumAdapter
        extends BaseAdapter {
    private AddToFavoriate addToForums;
    public ArrayList<Object> baseData = new ArrayList();
    public ArrayList<Object> forumList = new ArrayList();
    private ListView listView;
    private Activity mActivity;
    public int page = 1;
    public IcsSearchForumView searchForum;

    public IcsRecommendForumAdapter(Activity paramActivity, ArrayList<Object> paramArrayList, ListView paramListView, AddToFavoriate paramAddToFavoriate) {
        this.mActivity = paramActivity;
        this.baseData = paramArrayList;
        this.listView = paramListView;
        this.addToForums = paramAddToFavoriate;
        int i;
        if ((this.baseData != null) && (this.baseData.size() > 0)) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.baseData.size()) {
                this.mActivity.invalidateOptionsMenu();
                return;
            }
            setItemSelected(i);
            this.forumList.add(this.baseData.get(i));
            i += 1;
        }
    }

    private void setListenerAfterActivityCreated() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                if ((IcsRecommendForumAdapter.this.getItem(paramAnonymousInt) instanceof TapatalkForum)) {
                    ((TapatalkForum) IcsRecommendForumAdapter.this.getItem(paramAnonymousInt)).openTapatalkForum(IcsRecommendForumAdapter.this.mActivity, false, true, "push");
                }
            }
        });
    }

    public int getCount() {
        return this.baseData.size();
    }

    public Object getItem(int paramInt) {
        return this.baseData.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        this.searchForum = new IcsSearchForumView(this.mActivity, "push", true);
        if (this.forumList.contains(getItem(paramInt))) {
        }
        for (paramView = this.searchForum.getSearchForumView((TapatalkForum) getItem(paramInt), IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_CHECK, paramInt, paramView, paramViewGroup, true); ; paramView = this.searchForum.getSearchForumView((TapatalkForum) getItem(paramInt), IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_ADD, paramInt, paramView, paramViewGroup, true)) {
            this.searchForum.setOnAddListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if ((paramInt < 0) || (paramInt >= IcsRecommendForumAdapter.this.baseData.size())) {
                        return;
                    }
                    IcsRecommendForumAdapter.this.setItemSelected(paramInt);
                    if (((TapatalkForumForSearch) IcsRecommendForumAdapter.this.getItem(paramInt)).isSelected()) {
                        IcsRecommendForumAdapter.this.forumList.add((TapatalkForumForSearch) IcsRecommendForumAdapter.this.getItem(paramInt));
                        IcsRecommendForumAdapter.this.searchForum.getAddImg().setImageResource(2130837513);
                        IcsRecommendForumAdapter.this.searchForum.setAdded(false);
                        if (IcsRecommendForumAdapter.this.forumList.size() > 0) {
                            break label248;
                        }
                        IcsRecommendForumAdapter.this.addToForums.layout.setVisibility(8);
                        IcsRecommendForumAdapter.this.addToForums.view1.setPadding(0, 0, 0, 5);
                    }
                    for (; ; ) {
                        IcsRecommendForumAdapter.this.mActivity.invalidateOptionsMenu();
                        IcsRecommendForumAdapter.this.notifyDataSetChanged();
                        return;
                        IcsRecommendForumAdapter.this.searchForum.getAddImg().setImageResource(2130837512);
                        IcsRecommendForumAdapter.this.searchForum.setAdded(true);
                        if (!IcsRecommendForumAdapter.this.forumList.contains(IcsRecommendForumAdapter.this.getItem(paramInt))) {
                            break;
                        }
                        IcsRecommendForumAdapter.this.forumList.remove((TapatalkForumForSearch) IcsRecommendForumAdapter.this.getItem(paramInt));
                        break;
                        label248:
                        IcsRecommendForumAdapter.this.addToForums.layout.setVisibility(0);
                        ((IcsRecommendActivity) IcsRecommendForumAdapter.this.mActivity).add_favoriate = true;
                    }
                }
            });
            return paramView;
        }
    }

    public void saveFavoriate(TapatalkForum paramTapatalkForum) {
        FavoriateSqlHelper localFavoriateSqlHelper = new FavoriateSqlHelper(this.mActivity, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version));
        TapatalkForum localTapatalkForum = localFavoriateSqlHelper.getFavrivateById(paramTapatalkForum.getId());
        if ((localTapatalkForum == null) || (localTapatalkForum.getId().intValue() != paramTapatalkForum.getId().intValue())) {
            localFavoriateSqlHelper.saveFavoriate(paramTapatalkForum);
        }
    }

    public void setItemSelected(int paramInt) {
        TapatalkForum localTapatalkForum = (TapatalkForum) this.baseData.get(paramInt);
        if (localTapatalkForum.isSelected()) {
        }
        for (boolean bool = false; ; bool = true) {
            localTapatalkForum.setSelected(bool);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/ics/IcsRecommendForumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */