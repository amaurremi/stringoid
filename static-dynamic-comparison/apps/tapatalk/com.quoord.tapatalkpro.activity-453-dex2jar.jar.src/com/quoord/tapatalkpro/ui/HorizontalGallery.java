package com.quoord.tapatalkpro.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class HorizontalGallery
        extends LinearLayout {
    public static int selectedId = 0;
    private BaseAdapter adapter;
    private Context mContext;
    private AdapterView.OnItemSelectedListener onItemSelectedListener;

    public HorizontalGallery(Context paramContext) {
        super(paramContext);
        this.mContext = paramContext;
        setOrientation(0);
    }

    public HorizontalGallery(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        setOrientation(0);
    }

    public long getItemIdAtPosition(int paramInt) {
        if ((this.adapter == null) || (paramInt < 0)) {
        }
        for (Long localLong = null; ; localLong = Long.valueOf(this.adapter.getItemId(paramInt))) {
            return localLong.longValue();
        }
    }

    public int getSelectedItemPosition() {
        return selectedId;
    }

    public void setAdapter(BaseAdapter paramBaseAdapter) {
        this.adapter = paramBaseAdapter;
        final int i = 0;
        for (; ; ) {
            if (i >= paramBaseAdapter.getCount()) {
                return;
            }
            View localView = paramBaseAdapter.getView(i, null, null);
            localView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
                    if (HorizontalGallery.this.onItemSelectedListener != null) {
                        HorizontalGallery.this.onItemSelectedListener.onItemSelected(null, paramAnonymousView, i, this.val$id);
                    }
                    HorizontalGallery.selectedId = i;
                    return true;
                }
            });
            addView(localView, new LinearLayout.LayoutParams(-1, -1));
            i += 1;
        }
    }

    public void setItemSelected(int paramInt) {
        selectedId = paramInt;
        View localView = this.adapter.getView(paramInt, null, null);
        this.onItemSelectedListener.onItemSelected(null, localView, paramInt, getItemIdAtPosition(paramInt));
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
        this.onItemSelectedListener = paramOnItemSelectedListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/HorizontalGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */