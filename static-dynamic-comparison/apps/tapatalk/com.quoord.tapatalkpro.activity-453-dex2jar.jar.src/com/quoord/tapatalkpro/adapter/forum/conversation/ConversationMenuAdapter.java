package com.quoord.tapatalkpro.adapter.forum.conversation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ConversationMenuAdapter
        extends BaseAdapter {
    Activity mContext;
    private ArrayList<String> mDatas = new ArrayList();

    public ConversationMenuAdapter(Activity paramActivity) {
        this.mContext = paramActivity;
        this.mDatas.add(this.mContext.getString(2131100170));
    }

    public int getCount() {
        return this.mDatas.size();
    }

    public Object getItem(int paramInt) {
        return this.mDatas.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.mDatas.get(paramInt));
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/adapter/forum/conversation/ConversationMenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */