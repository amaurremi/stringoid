package com.quoord.emojikeyboard;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatListAdapter
        extends BaseAdapter {
    private ArrayList<Spanned> comments;
    private Context mContext;

    public ChatListAdapter(Context paramContext, ArrayList<Spanned> paramArrayList) {
        this.mContext = paramContext;
        this.comments = paramArrayList;
    }

    public int getCount() {
        return this.comments.size();
    }

    public Object getItem(int paramInt) {
        return this.comments.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
            paramView = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130903092, null);
        }
        paramViewGroup = (Spanned) this.comments.get(paramInt);
        ((TextView) paramView.findViewById(2131230917)).setText(paramViewGroup);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/emojikeyboard/ChatListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */