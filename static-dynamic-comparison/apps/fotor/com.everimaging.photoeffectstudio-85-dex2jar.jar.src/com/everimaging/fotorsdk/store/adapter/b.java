package com.everimaging.fotorsdk.store.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.store.R.id;
import com.everimaging.fotorsdk.store.R.layout;
import com.everimaging.fotorsdk.utils.EffectThumbLoader;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.BitmapLoadListener;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.EffectThumbProcessor;

import java.util.ArrayList;
import java.util.List;

public class b
        extends BaseAdapter {
    private static final String f = b.class.getSimpleName();
    private static final FotorLoggerFactory.c g = FotorLoggerFactory.a(f, FotorLoggerFactory.LoggerType.CONSOLE);
    protected Context a;
    protected List<EffectInfo> b;
    protected LayoutInflater c;
    protected SparseBooleanArray d;
    protected EffectThumbLoader e;

    public b(Context paramContext, List<EffectInfo> paramList, EffectThumbLoader.EffectThumbProcessor paramEffectThumbProcessor, Bitmap paramBitmap) {
        this.a = paramContext;
        this.b = paramList;
        if (paramList == null) {
            this.b = new ArrayList();
        }
        this.c = LayoutInflater.from(this.a);
        this.d = new SparseBooleanArray();
        this.e = new EffectThumbLoader(paramContext, paramEffectThumbProcessor, paramBitmap);
    }

    public EffectInfo a(int paramInt) {
        return (EffectInfo) this.b.get(paramInt);
    }

    public void b(int paramInt) {
        this.d.clear();
        if (paramInt >= 0) {
            this.d.put(paramInt, true);
        }
        notifyDataSetChanged();
    }

    public boolean c(int paramInt) {
        return this.d.get(paramInt);
    }

    public int getCount() {
        return this.b.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        EffectInfo localEffectInfo = (EffectInfo) this.b.get(paramInt);
        if (paramView == null) {
            paramView = this.c.inflate(R.layout.fotor_store_effect_detail_listview_item, null);
            paramViewGroup = new a(null);
            paramViewGroup.b = ((ImageView) paramView.findViewById(R.id.fotor_store_effect_detail_listview_item_imageview));
            paramViewGroup.a = ((ProgressBar) paramView.findViewById(R.id.fotor_store_effect_detail_listview_item_progressbar));
            paramViewGroup.c = paramView.findViewById(R.id.fotor_store_effect_detail_listview_item_selector);
            paramView.setTag(paramViewGroup);
            final ProgressBar localProgressBar = paramViewGroup.a;
            this.e.displayImage(paramViewGroup.b, localEffectInfo, 0, new EffectThumbLoader.BitmapLoadListener() {
                public void onBitmapLoadCancelled(View paramAnonymousView, EffectInfo paramAnonymousEffectInfo) {
                    localProgressBar.setVisibility(8);
                }

                public void onBitmapLoadCompletion(View paramAnonymousView, EffectInfo paramAnonymousEffectInfo) {
                    localProgressBar.setVisibility(8);
                }

                public void onBitmapLoadStart(View paramAnonymousView, EffectInfo paramAnonymousEffectInfo) {
                    localProgressBar.setVisibility(0);
                }
            });
            paramViewGroup = paramViewGroup.c;
            if (!c(paramInt)) {
                break label148;
            }
        }
        label148:
        for (paramInt = 0; ; paramInt = 8) {
            paramViewGroup.setVisibility(paramInt);
            return paramView;
            paramViewGroup = (a) paramView.getTag();
            break;
        }
    }

    private class a {
        ProgressBar a;
        ImageView b;
        View c;

        private a() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */