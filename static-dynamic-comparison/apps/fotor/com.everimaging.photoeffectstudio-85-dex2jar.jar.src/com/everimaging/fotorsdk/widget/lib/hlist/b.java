package com.everimaging.fotorsdk.widget.lib.hlist;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

import java.util.ArrayList;
import java.util.Iterator;

public class b
        implements Filterable, WrapperListAdapter {
    static final ArrayList<HListView.b> c = new ArrayList();
    ArrayList<HListView.b> a;
    ArrayList<HListView.b> b;
    boolean d;
    private final ListAdapter e;
    private final boolean f;

    public b(ArrayList<HListView.b> paramArrayList1, ArrayList<HListView.b> paramArrayList2, ListAdapter paramListAdapter) {
        this.e = paramListAdapter;
        this.f = (paramListAdapter instanceof Filterable);
        if (paramArrayList1 == null) {
            this.a = c;
            if (paramArrayList2 != null) {
                break label79;
            }
            this.b = c;
            label39:
            if ((!a(this.a)) || (!a(this.b))) {
                break label87;
            }
        }
        label79:
        label87:
        for (boolean bool = true; ; bool = false) {
            this.d = bool;
            return;
            this.a = paramArrayList1;
            break;
            this.b = paramArrayList2;
            break label39;
        }
    }

    private boolean a(ArrayList<HListView.b> paramArrayList) {
        if (paramArrayList != null) {
            paramArrayList = paramArrayList.iterator();
            while (paramArrayList.hasNext()) {
                if (!((HListView.b) paramArrayList.next()).c) {
                    return false;
                }
            }
        }
        return true;
    }

    public int a() {
        return this.a.size();
    }

    public boolean areAllItemsEnabled() {
        return (this.e == null) || ((this.d) && (this.e.areAllItemsEnabled()));
    }

    public int b() {
        return this.b.size();
    }

    public int getCount() {
        if (this.e != null) {
            return b() + a() + this.e.getCount();
        }
        return b() + a();
    }

    public Filter getFilter() {
        if (this.f) {
            return ((Filterable) this.e).getFilter();
        }
        return null;
    }

    public Object getItem(int paramInt) {
        int i = a();
        if (paramInt < i) {
            return ((HListView.b) this.a.get(paramInt)).b;
        }
        int j = paramInt - i;
        paramInt = 0;
        if (this.e != null) {
            i = this.e.getCount();
            paramInt = i;
            if (j < i) {
                return this.e.getItem(j);
            }
        }
        return ((HListView.b) this.b.get(j - paramInt)).b;
    }

    public long getItemId(int paramInt) {
        int i = a();
        if ((this.e != null) && (paramInt >= i)) {
            paramInt -= i;
            if (paramInt < this.e.getCount()) {
                return this.e.getItemId(paramInt);
            }
        }
        return -1L;
    }

    public int getItemViewType(int paramInt) {
        int i = a();
        if ((this.e != null) && (paramInt >= i)) {
            paramInt -= i;
            if (paramInt < this.e.getCount()) {
                return this.e.getItemViewType(paramInt);
            }
        }
        return -2;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int i = a();
        if (paramInt < i) {
            return ((HListView.b) this.a.get(paramInt)).a;
        }
        int j = paramInt - i;
        paramInt = 0;
        if (this.e != null) {
            i = this.e.getCount();
            paramInt = i;
            if (j < i) {
                return this.e.getView(j, paramView, paramViewGroup);
            }
        }
        return ((HListView.b) this.b.get(j - paramInt)).a;
    }

    public int getViewTypeCount() {
        if (this.e != null) {
            return this.e.getViewTypeCount();
        }
        return 1;
    }

    public ListAdapter getWrappedAdapter() {
        return this.e;
    }

    public boolean hasStableIds() {
        if (this.e != null) {
            return this.e.hasStableIds();
        }
        return false;
    }

    public boolean isEmpty() {
        return (this.e == null) || (this.e.isEmpty());
    }

    public boolean isEnabled(int paramInt) {
        int i = a();
        if (paramInt < i) {
            return ((HListView.b) this.a.get(paramInt)).c;
        }
        int j = paramInt - i;
        paramInt = 0;
        if (this.e != null) {
            i = this.e.getCount();
            paramInt = i;
            if (j < i) {
                return this.e.isEnabled(j);
            }
        }
        return ((HListView.b) this.b.get(j - paramInt)).c;
    }

    public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
        if (this.e != null) {
            this.e.registerDataSetObserver(paramDataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
        if (this.e != null) {
            this.e.unregisterDataSetObserver(paramDataSetObserver);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */