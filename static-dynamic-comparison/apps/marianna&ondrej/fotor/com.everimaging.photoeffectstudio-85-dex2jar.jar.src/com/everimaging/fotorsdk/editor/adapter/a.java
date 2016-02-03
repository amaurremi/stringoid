package com.everimaging.fotorsdk.editor.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.entity.BorderInfo;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.EffectThumbLoader;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.BitmapLoadListener;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.EffectThumbProcessor;
import com.everimaging.fotorsdk.widget.FotorEffectSelectorView;
import com.everimaging.fotorsdk.widget.FotorTextView;

import java.util.ArrayList;
import java.util.List;

public class a
        extends BaseAdapter {
    protected static final String a = a.class.getSimpleName();
    protected static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    protected Context c;
    protected List<EffectInfo> d;
    protected LayoutInflater e;
    protected SparseBooleanArray f;
    protected EffectThumbLoader g;

    public a(Context paramContext, List<EffectInfo> paramList, EffectThumbLoader.EffectThumbProcessor paramEffectThumbProcessor, Bitmap paramBitmap) {
        this.c = paramContext;
        this.d = paramList;
        if (paramList == null) {
            this.d = new ArrayList();
        }
        this.e = LayoutInflater.from(this.c);
        this.f = new SparseBooleanArray();
        this.g = new EffectThumbLoader(paramContext, paramEffectThumbProcessor, paramBitmap);
    }

    public int a() {
        int i = 0;
        while (i < this.f.size()) {
            int j = this.f.keyAt(i);
            if (this.f.get(j)) {
                return j;
            }
            i += 1;
        }
        return -1;
    }

    public EffectInfo a(int paramInt) {
        return (EffectInfo) this.d.get(paramInt);
    }

    public void a(Bitmap paramBitmap) {
        b.c(new Object[]{"reloadItemDatas"});
        this.g.clearMemory();
        this.g.setSourceBitmap(paramBitmap);
        notifyDataSetChanged();
    }

    public void a(EffectEntity paramEffectEntity) {
        if (paramEffectEntity == null) {
            return;
        }
        b(b(paramEffectEntity));
    }

    public int b(EffectEntity paramEffectEntity) {
        int i = 0;
        while (i < this.d.size()) {
            EffectInfo localEffectInfo = (EffectInfo) this.d.get(i);
            if (paramEffectEntity.getID() == localEffectInfo.effectEntity.getID()) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    public void b(int paramInt) {
        this.f.clear();
        if (paramInt >= 0) {
            this.f.put(paramInt, true);
        }
        notifyDataSetChanged();
    }

    public boolean c(int paramInt) {
        return this.f.get(paramInt);
    }

    public int getCount() {
        return this.d.size();
    }

    public long getItemId(int paramInt) {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        Object localObject = (EffectInfo) this.d.get(paramInt);
        if (paramView == null) {
            paramView = this.e.inflate(R.layout.fotor_feature_fx_effect_effects_listview_item, null);
            paramViewGroup = new a(null);
            paramViewGroup.b = ((ImageView) paramView.findViewById(R.id.fotor_fx_effect_effects_listview_item_imageview));
            paramViewGroup.c = ((FotorTextView) paramView.findViewById(R.id.fotor_fx_effect_effects_listview_item_textview));
            paramViewGroup.a = ((ProgressBar) paramView.findViewById(R.id.fotor_fx_effect_effects_listview_item_progressbar));
            paramViewGroup.d = ((FotorEffectSelectorView) paramView.findViewById(R.id.fotor_fx_effect_effects_listview_item_selector));
            paramView.setTag(paramViewGroup);
            final ProgressBar localProgressBar = paramViewGroup.a;
            this.g.displayImage(paramViewGroup.b, (EffectInfo) localObject, 0, new EffectThumbLoader.BitmapLoadListener() {
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
            if (!(localObject instanceof BorderInfo)) {
                break label197;
            }
            paramViewGroup.c.setVisibility(8);
            label149:
            localObject = paramViewGroup.d;
            if (!c(paramInt)) {
                break label212;
            }
        }
        label197:
        label212:
        for (int i = 0; ; i = 8) {
            ((FotorEffectSelectorView) localObject).setVisibility(i);
            paramViewGroup.b.setTag(Integer.valueOf(paramInt));
            return paramView;
            paramViewGroup = (a) paramView.getTag();
            break;
            paramViewGroup.c.setText(((EffectInfo) localObject).title);
            break label149;
        }
    }

    private class a {
        ProgressBar a;
        ImageView b;
        FotorTextView c;
        FotorEffectSelectorView d;

        private a() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */