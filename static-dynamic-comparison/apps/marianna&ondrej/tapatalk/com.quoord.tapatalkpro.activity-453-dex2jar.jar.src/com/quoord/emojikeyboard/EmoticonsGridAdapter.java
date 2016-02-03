package com.quoord.emojikeyboard;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.quoord.tapatalkpro.ics.slidingMenu.SettingsFragment;

import java.util.ArrayList;

public class EmoticonsGridAdapter
        extends BaseAdapter {
    Context mContext;
    KeyClickListener mListener;
    private int pageNumber;
    private ArrayList<String> paths;

    public EmoticonsGridAdapter(Context paramContext, ArrayList<String> paramArrayList, int paramInt, KeyClickListener paramKeyClickListener) {
        this.mContext = paramContext;
        this.paths = paramArrayList;
        this.pageNumber = paramInt;
        this.mListener = paramKeyClickListener;
    }

    public int getCount() {
        return this.paths.size();
    }

    public String getItem(int paramInt) {
        return (String) this.paths.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup) {
        paramViewGroup = paramView;
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
            paramView = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            if (!SettingsFragment.isLightTheme(this.mContext)) {
                break label115;
            }
        }
        label115:
        for (paramView = paramView.inflate(2130903134, null); ; paramView = paramView.inflate(2130903135, null)) {
            paramViewGroup = (String) this.paths.get(paramInt);
            paramInt = this.mContext.getResources().getIdentifier(paramViewGroup, "drawable", this.mContext.getPackageName());
            ImageView localImageView = (ImageView) paramView.findViewById(2131230998);
            localImageView.setImageDrawable(this.mContext.getResources().getDrawable(paramInt));
            localImageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    EmoticonsGridAdapter.this.mListener.keyClickedIndex(paramViewGroup);
                }
            });
            return paramView;
        }
    }

    public static abstract interface KeyClickListener {
        public abstract void keyClickedIndex(String paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/emojikeyboard/EmoticonsGridAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */