package mobi.ifunny.view;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

class h
        extends BaseAdapter {
    private final ListAdapter b;
    private boolean c = true;
    private boolean d;
    private DataSetObserver e;

    public h(DynamicStaggeredGridView paramDynamicStaggeredGridView, ListAdapter paramListAdapter) {
        this.b = paramListAdapter;
        this.e = new i(this, paramDynamicStaggeredGridView);
        this.d = false;
        paramListAdapter.registerDataSetObserver(this.e);
    }

    private void a(int paramInt) {
        if ((!this.c) && (DynamicStaggeredGridView.a(this.a) + paramInt >= getCount() - 1)) {
            c();
        }
    }

    private void c() {
        if ((!this.d) && (DynamicStaggeredGridView.b(this.a))) {
            if (DynamicStaggeredGridView.c(this.a) != null) {
                DynamicStaggeredGridView.c(this.a).O();
            }
            this.d = true;
        }
    }

    public void a() {
        this.b.unregisterDataSetObserver(this.e);
    }

    public void a(boolean paramBoolean) {
        if (this.c != paramBoolean) {
            this.d = false;
            this.c = paramBoolean;
        }
    }

    public void b() {
        if (this.d) {
            this.d = false;
        }
    }

    public int getCount() {
        return this.b.getCount();
    }

    public Object getItem(int paramInt) {
        return this.b.getItem(paramInt);
    }

    public long getItemId(int paramInt) {
        return this.b.getItemId(paramInt);
    }

    public int getItemViewType(int paramInt) {
        return this.b.getItemViewType(paramInt);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        a(paramInt);
        return this.b.getView(paramInt, paramView, paramViewGroup);
    }

    public int getViewTypeCount() {
        return this.b.getViewTypeCount();
    }

    public boolean hasStableIds() {
        return this.b.hasStableIds();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */