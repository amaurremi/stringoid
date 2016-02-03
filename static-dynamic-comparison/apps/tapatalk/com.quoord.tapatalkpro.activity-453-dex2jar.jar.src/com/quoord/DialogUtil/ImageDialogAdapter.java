package com.quoord.DialogUtil;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.ThemeUtil;

import java.util.ArrayList;

public class ImageDialogAdapter
        extends BaseAdapter {
    private Activity mContext;
    private ArrayList<String> mImageMenuArray = new ArrayList();

    public ImageDialogAdapter(Activity paramActivity) {
        this.mContext = paramActivity;
        this.mImageMenuArray.add(this.mContext.getString(2131100334));
        this.mImageMenuArray.add(this.mContext.getString(2131100335));
    }

    public int getCount() {
        return this.mImageMenuArray.size();
    }

    public Object getItem(int paramInt) {
        return this.mImageMenuArray.get(paramInt);
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        paramView = (TextView) LayoutInflater.from(this.mContext).inflate(2130903172, null);
        paramView.setText((CharSequence) this.mImageMenuArray.get(paramInt));
        paramView.setCompoundDrawablePadding(5);
        if (((String) this.mImageMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100334))) {
            paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDrawableIdByPicName("bubble_delete", this.mContext), 0, 0, 0);
        }
        while (!((String) this.mImageMenuArray.get(paramInt)).equalsIgnoreCase(this.mContext.getString(2131100335))) {
            return paramView;
        }
        paramView.setCompoundDrawablesWithIntrinsicBounds(ThemeUtil.getDrawableIdByPicName("bubble_copyurl", this.mContext), 0, 0, 0);
        return paramView;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/DialogUtil/ImageDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */