package com.quoord.tapatalkpro.adapter.directory;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quoord.tapatalkpro.TapatalkApp;
import com.quoord.tapatalkpro.bean.TapatalkForum;
import com.quoord.tapatalkpro.sqlhelper.FavoriateSqlHelper;
import com.quoord.tapatalkpro.util.AvatarTool;
import com.quoord.tapatalkpro.util.ThemeUtil;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;

public class WidgetSelectorAdapter
        extends BaseAdapter {
    private Activity mContext;
    private ArrayList<TapatalkForum> mDatas = new ArrayList();
    private boolean needPassWord;
    private Typeface tf;

    public WidgetSelectorAdapter(Activity paramActivity, boolean paramBoolean) {
        this.mContext = paramActivity;
        this.needPassWord = paramBoolean;
        getFavoriateForum();
        this.tf = Typeface.createFromAsset(this.mContext.getAssets(), "font/Roboto-Light.ttf");
    }

    public void addItem(TapatalkForum paramTapatalkForum) {
        this.mDatas.add(paramTapatalkForum);
    }

    public void clearAll() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    public void deleteFavoriateForum(int paramInt) {
        TapatalkForum localTapatalkForum = (TapatalkForum) this.mDatas.get(paramInt);
        new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).deleteFavoriate(localTapatalkForum);
        refresh();
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public void getFavoriateForum() {
        this.mDatas.clear();
        ArrayList localArrayList = new FavoriateSqlHelper(this.mContext, TapatalkApp.database_name, null, Integer.parseInt(TapatalkApp.database_version)).getFavrivate();
        int i;
        if (this.needPassWord) {
            i = 0;
            if (i < localArrayList.size()) {
            }
        }
        for (; ; ) {
            notifyDataSetChanged();
            if (this.mDatas.size() == 0) {
                if (!this.mContext.getResources().getBoolean(2131558401)) {
                    Toast.makeText(this.mContext, this.mContext.getString(2131099906), 1).show();
                }
            } else {
                return;
                if (Util.isLoginedUser(this.mContext, (TapatalkForum) localArrayList.get(i))) {
                    this.mDatas.add((TapatalkForum) localArrayList.get(i));
                }
                i += 1;
                break;
                i = 0;
                while (i < localArrayList.size()) {
                    this.mDatas.add((TapatalkForum) localArrayList.get(i));
                    i += 1;
                }
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(2131099907), 1).show();
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if (!(this.mDatas.get(paramInt) instanceof TapatalkForum)) {
            return 2;
        }
        if (((TapatalkForum) this.mDatas.get(paramInt)).getUserName() != null) {
            return 0;
        }
        return 1;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = (TapatalkForum) this.mDatas.get(paramInt);
        if (paramView == null) {
            paramView = this.mContext.getLayoutInflater().inflate(2130903144, null);
            paramViewGroup = new ViewHolder(null);
            paramViewGroup.icon = ((ImageView) paramView.findViewById(2131230992));
            paramViewGroup.text = ((TextView) paramView.findViewById(2131230904));
            paramViewGroup.description = ((TextView) paramView.findViewById(2131230993));
            paramViewGroup.slidView = ((ImageView) paramView.findViewById(2131231013));
            paramViewGroup.slidlay = ((RelativeLayout) paramView.findViewById(2131231012));
            paramView.setTag(paramViewGroup);
            if (paramInt % 2 != 1) {
                break label289;
            }
            paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item1_color", this.mContext));
        }
        for (; ; ) {
            TapatalkForum localTapatalkForum = (TapatalkForum) getItem(paramInt);
            paramViewGroup.slidlay.setVisibility(8);
            paramViewGroup.slidView.setVisibility(8);
            AvatarTool.showLogo(this.mContext, paramViewGroup.icon, ((TapatalkForum) this.mDatas.get(paramInt)).getIconUrl(), 5);
            paramViewGroup.description.setTypeface(this.tf);
            paramViewGroup.description.setText(((TapatalkForum) this.mDatas.get(paramInt)).getName());
            if ((((TapatalkForum) this.mDatas.get(paramInt)).getUserName() == null) || (this.mContext.getResources().getBoolean(2131558402))) {
                break label305;
            }
            paramViewGroup.text.setVisibility(0);
            paramViewGroup.text.setText(((TapatalkForum) this.mDatas.get(paramInt)).getUserName());
            return paramView;
            paramViewGroup = (ViewHolder) paramView.getTag();
            break;
            label289:
            paramView.setBackgroundDrawable(ThemeUtil.getDrawableByPicName("favforum_item2_color", this.mContext));
        }
        label305:
        paramViewGroup.text.setVisibility(8);
        return paramView;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public boolean isEnabled(int paramInt) {
        return true;
    }

    public void refresh() {
        getFavoriateForum();
    }

    private static class ViewHolder {
        TextView description;
        ImageView icon;
        ImageView slidView;
        RelativeLayout slidlay;
        TextView text;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/directory/WidgetSelectorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */