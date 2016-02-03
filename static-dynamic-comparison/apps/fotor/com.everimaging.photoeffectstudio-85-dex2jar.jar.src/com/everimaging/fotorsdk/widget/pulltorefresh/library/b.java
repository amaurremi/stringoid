package com.everimaging.fotorsdk.widget.pulltorefresh.library;

import android.graphics.drawable.Drawable;
import com.everimaging.fotorsdk.widget.pulltorefresh.library.internal.d;

import java.util.HashSet;
import java.util.Iterator;

public class b
        implements a {
    private final HashSet<d> a = new HashSet();

    public void a(d paramd) {
        if (paramd != null) {
            this.a.add(paramd);
        }
    }

    public void setLastUpdatedLabel(CharSequence paramCharSequence) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).setLastUpdatedLabel(paramCharSequence);
        }
    }

    public void setLoadingDrawable(Drawable paramDrawable) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).setLoadingDrawable(paramDrawable);
        }
    }

    public void setPullLabel(CharSequence paramCharSequence) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).setPullLabel(paramCharSequence);
        }
    }

    public void setRefreshingLabel(CharSequence paramCharSequence) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).setRefreshingLabel(paramCharSequence);
        }
    }

    public void setReleaseLabel(CharSequence paramCharSequence) {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
            ((d) localIterator.next()).setReleaseLabel(paramCharSequence);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/pulltorefresh/library/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */