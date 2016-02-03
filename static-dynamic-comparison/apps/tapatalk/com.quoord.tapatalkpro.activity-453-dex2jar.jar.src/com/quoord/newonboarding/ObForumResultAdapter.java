package com.quoord.newonboarding;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView;
import com.quoord.tapatalkpro.adapter.directory.view.IcsSearchForumView.SearchForumTag;
import com.quoord.tapatalkpro.bean.TapatalkForumForSearch;

import java.util.ArrayList;

public class ObForumResultAdapter
        extends BaseAdapter {
    private Activity activity;
    private ArrayList<TapatalkForumForSearch> addDatas = new ArrayList();
    private ArrayList<TapatalkForumForSearch> datas = new ArrayList();

    public ObForumResultAdapter(Activity paramActivity) {
        this.activity = paramActivity;
    }

    public void changeSelected() {
        if (this.addDatas.size() > 0) {
            ((ObForumListActivity) this.activity).done.setBackgroundResource(2130839159);
            ((ObForumListActivity) this.activity).done.setTextColor(this.activity.getResources().getColor(2131165213));
            return;
        }
        ((ObForumListActivity) this.activity).done.setBackgroundResource(2130839160);
        ((ObForumListActivity) this.activity).done.setTextColor(this.activity.getResources().getColor(2131165237));
    }

    public ArrayList<TapatalkForumForSearch> getAddDatas() {
        return this.addDatas;
    }

    public int getCount() {
        return this.datas.size();
    }

    public ArrayList<TapatalkForumForSearch> getDatas() {
        return this.datas;
    }

    public TapatalkForumForSearch getItem(int paramInt) {
        return (TapatalkForumForSearch) this.datas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
        boolean bool2 = false;
        boolean bool1 = false;
        final IcsSearchForumView localIcsSearchForumView = new IcsSearchForumView(this.activity, "", false);
        TapatalkForumForSearch localTapatalkForumForSearch;
        IcsSearchForumView.SearchForumTag localSearchForumTag;
        if (this.addDatas.contains(getItem(paramInt))) {
            localIcsSearchForumView.setAdded(true);
            localTapatalkForumForSearch = getItem(paramInt);
            localSearchForumTag = IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_CHECK;
            if (getCount() - 1 == paramInt) {
                bool1 = true;
            }
        }
        for (paramView = localIcsSearchForumView.getSearchForumView(localTapatalkForumForSearch, localSearchForumTag, paramInt, paramView, paramViewGroup, true, bool1); ; paramView = localIcsSearchForumView.getSearchForumView(localTapatalkForumForSearch, localSearchForumTag, paramInt, paramView, paramViewGroup, true, bool1)) {
            localIcsSearchForumView.setOnAddListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (!localIcsSearchForumView.isAdded()) {
                        localIcsSearchForumView.getAddImg().setImageResource(2130837513);
                        localIcsSearchForumView.setAdded(true);
                        if (!ObForumResultAdapter.this.addDatas.contains(ObForumResultAdapter.this.getItem(paramInt))) {
                            ObForumResultAdapter.this.addDatas.add(ObForumResultAdapter.this.getItem(paramInt));
                        }
                        if ((ObForumResultAdapter.this.activity instanceof ObSearchActivity)) {
                            paramAnonymousView = new Intent(ObForumResultAdapter.this.activity, ObRecommendListActivity.class);
                            paramAnonymousView.putExtra("toAddForums", ObForumResultAdapter.this.addDatas);
                            ObForumResultAdapter.this.activity.startActivity(paramAnonymousView);
                        }
                    }
                    for (; ; ) {
                        if ((ObForumResultAdapter.this.activity instanceof ObForumListActivity)) {
                            ObForumResultAdapter.this.changeSelected();
                        }
                        return;
                        localIcsSearchForumView.getAddImg().setImageResource(2130837512);
                        localIcsSearchForumView.setAdded(false);
                        if (ObForumResultAdapter.this.addDatas.contains(ObForumResultAdapter.this.getItem(paramInt))) {
                            ObForumResultAdapter.this.addDatas.remove(ObForumResultAdapter.this.getItem(paramInt));
                        }
                    }
                }
            });
            return paramView;
            localTapatalkForumForSearch = getItem(paramInt);
            localSearchForumTag = IcsSearchForumView.SearchForumTag.ADD_BTN_SHOW_ADD;
            bool1 = bool2;
            if (getCount() - 1 == paramInt) {
                bool1 = true;
            }
        }
    }

    public void setDatas(ArrayList<TapatalkForumForSearch> paramArrayList) {
        this.datas = paramArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/ObForumResultAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */