package com.quoord.DialogUtil;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AccountDialogAdapter
        extends BaseAdapter {
    private ArrayList<String> list;
    private Context mContext;

    public AccountDialogAdapter(Context paramContext, String paramString) {
        this.mContext = paramContext;
        this.list = new ArrayList();
        if (paramString != null) {
            this.list.add(paramContext.getResources().getString(2131100370));
        }
        this.list.add(paramContext.getResources().getString(2131100369));
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

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.list.get(paramInt));
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/AccountDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */