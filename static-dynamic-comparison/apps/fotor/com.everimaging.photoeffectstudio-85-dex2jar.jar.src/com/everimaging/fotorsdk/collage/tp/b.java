package com.everimaging.fotorsdk.collage.tp;

import android.widget.BaseAdapter;

import java.util.List;

public abstract class b
        extends BaseAdapter {
    protected List<com.everimaging.fotorsdk.collage.entity.ui.b> b;

    public b(List<com.everimaging.fotorsdk.collage.entity.ui.b> paramList) {
        this.b = paramList;
    }

    public com.everimaging.fotorsdk.collage.entity.ui.b a(int paramInt) {
        return (com.everimaging.fotorsdk.collage.entity.ui.b) this.b.get(paramInt);
    }

    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */