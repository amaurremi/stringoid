package com.uservoice.uservoicesdk.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.uservoice.uservoicesdk.R.string;

import java.util.List;

public class SpinnerAdapter<T>
        extends BaseAdapter {
    private static int NONE = 0;
    private static int OBJECT = 1;
    private int color;
    private LayoutInflater inflater;
    private final List<T> objects;

    public SpinnerAdapter(Activity paramActivity, List<T> paramList) {
        this.objects = paramList;
        this.inflater = paramActivity.getLayoutInflater();
        paramList = new TypedValue();
        paramActivity.getTheme().resolveAttribute(16842806, paramList, true);
        this.color = paramActivity.getResources().getColor(paramList.resourceId);
    }

    public int getCount() {
        return this.objects.size() + 1;
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        if (paramView == null) {
            paramView = this.inflater.inflate(17367043, null);
        }
        for (; ; ) {
            paramViewGroup = (TextView) paramView;
            if (i == OBJECT) {
                paramViewGroup.setTextColor(this.color);
                paramViewGroup.setText(getItem(paramInt).toString());
                return paramView;
            }
            paramViewGroup.setTextColor(-7829368);
            paramViewGroup.setText(R.string.uv_select_none);
            return paramView;
        }
    }

    public Object getItem(int paramInt) {
        if (paramInt == 0) {
            return null;
        }
        return this.objects.get(paramInt - 1);
    }

    public long getItemId(int paramInt) {
        return 0L;
    }

    public int getItemViewType(int paramInt) {
        if (paramInt == 0) {
            return NONE;
        }
        return OBJECT;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        if (paramView == null) {
            paramView = this.inflater.inflate(17367043, null);
        }
        for (; ; ) {
            paramViewGroup = (TextView) paramView;
            if (i == OBJECT) {
                paramViewGroup.setTextColor(this.color);
                paramViewGroup.setText(getItem(paramInt).toString());
                return paramView;
            }
            paramViewGroup.setTextColor(this.color);
            paramViewGroup.setText(R.string.uv_select_one);
            return paramView;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/SpinnerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */