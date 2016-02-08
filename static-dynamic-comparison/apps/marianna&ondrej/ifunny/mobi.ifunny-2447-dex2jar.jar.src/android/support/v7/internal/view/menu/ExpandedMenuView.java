package android.support.v7.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView
        extends ListView
        implements ai, s, AdapterView.OnItemClickListener {
    private q a;
    private int b;

    public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setOnItemClickListener(this);
    }

    public void a(q paramq) {
        this.a = paramq;
    }

    public boolean a(u paramu) {
        return this.a.a(paramu, 0);
    }

    public int getWindowAnimations() {
        return this.b;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {
        a((u) getAdapter().getItem(paramInt));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/ExpandedMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */