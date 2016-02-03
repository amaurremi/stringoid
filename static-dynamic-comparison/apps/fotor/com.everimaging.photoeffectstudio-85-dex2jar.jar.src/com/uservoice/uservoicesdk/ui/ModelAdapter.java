package com.uservoice.uservoicesdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.rest.Callback;

import java.util.List;

public abstract class ModelAdapter<T>
        extends SearchAdapter<T> {
    protected static final int LOADING = 1;
    protected static final int MODEL = 0;
    protected int addedObjects = 0;
    protected LayoutInflater inflater;
    protected final int layoutId;
    protected List<T> objects;

    public ModelAdapter(Context paramContext, int paramInt, List<T> paramList) {
        this.context = paramContext;
        this.layoutId = paramInt;
        this.objects = paramList;
        this.inflater = ((LayoutInflater) paramContext.getSystemService("layout_inflater"));
    }

    public void add(int paramInt, T paramT) {
        this.objects.add(paramInt, paramT);
        this.addedObjects += 1;
        notifyDataSetChanged();
    }

    protected abstract void customizeLayout(View paramView, T paramT);

    public int getCount() {
        int j = getObjects().size();
        if (this.loading) {
        }
        for (int i = 1; ; i = 0) {
            return i + j;
        }
    }

    public Object getItem(int paramInt) {
        if (paramInt < getObjects().size()) {
            return getObjects().get(paramInt);
        }
        return null;
    }

    public long getItemId(int paramInt) {
        if (getItemViewType(paramInt) == 1) {
            return -1L;
        }
        return paramInt;
    }

    public int getItemViewType(int paramInt) {
        if (paramInt == getObjects().size()) {
            return 1;
        }
        return 0;
    }

    protected List<T> getObjects() {
        return this.objects;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        int j = getItemViewType(paramInt);
        paramViewGroup = paramView;
        if (paramView == null) {
            paramView = this.inflater;
            if (j != 1) {
                break label54;
            }
        }
        label54:
        for (int i = R.layout.uv_loading_item; ; i = this.layoutId) {
            paramViewGroup = paramView.inflate(i, null);
            if (j == 0) {
                customizeLayout(paramViewGroup, getItem(paramInt));
            }
            return paramViewGroup;
        }
    }

    public int getViewTypeCount() {
        return 2;
    }

    public boolean isEnabled(int paramInt) {
        return getItemViewType(paramInt) == 0;
    }

    protected abstract void loadPage(int paramInt, Callback<List<T>> paramCallback);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/ModelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */