package com.everimaging.fotorsdk.collage.tp;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class f
        extends PagerAdapter {
    protected SparseArray<e> c = new SparseArray();

    public abstract e a(int paramInt);

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        paramObject = (e) this.c.get(paramInt);
        if (paramObject != null) {
            paramViewGroup.removeView(((e) paramObject).n());
            ((e) paramObject).e();
        }
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
        e locale2 = (e) this.c.get(paramInt);
        e locale1 = locale2;
        if (locale2 == null) {
            locale1 = a(paramInt);
            this.c.put(paramInt, locale1);
        }
        paramViewGroup.addView(locale1.n());
        locale1.b();
        return locale1;
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return ((e) paramObject).n() == paramView;
    }

    public void startUpdate(ViewGroup paramViewGroup) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/tp/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */