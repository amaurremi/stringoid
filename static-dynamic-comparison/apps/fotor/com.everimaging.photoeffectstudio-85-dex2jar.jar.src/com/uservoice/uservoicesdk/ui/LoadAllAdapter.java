package com.uservoice.uservoicesdk.ui;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public abstract class LoadAllAdapter<T>
        extends ModelAdapter<T> {
    public LoadAllAdapter(Context paramContext, int paramInt, List<T> paramList) {
        super(paramContext, paramInt, paramList);
        loadAll();
    }

    private void loadAll() {
        this.loading = true;
        notifyDataSetChanged();
        loadPage(1, new DefaultCallback(this.context) {
            public void onModel(List<T> paramAnonymousList) {
                LoadAllAdapter.this.objects.addAll(paramAnonymousList);
                LoadAllAdapter.this.loading = false;
                LoadAllAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void reload() {
        if (this.loading) {
            return;
        }
        this.objects = new ArrayList();
        loadAll();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/LoadAllAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */