package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v8.renderscript.RenderScript;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.collage.R.attr;
import com.everimaging.fotorsdk.collage.R.dimen;
import com.everimaging.fotorsdk.collage.R.id;
import com.everimaging.fotorsdk.collage.R.layout;
import com.everimaging.fotorsdk.collage.R.string;
import com.everimaging.fotorsdk.collage.R.style;
import com.everimaging.fotorsdk.collage.R.styleable;
import com.everimaging.fotorsdk.collage.c;
import com.everimaging.fotorsdk.collage.f;
import com.everimaging.fotorsdk.entity.EffectConfig;
import com.everimaging.fotorsdk.entity.EffectConfig.EffectItem;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.filter.FxEffectFilter;
import com.everimaging.fotorsdk.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.plugins.FeatureBindPack;
import com.everimaging.fotorsdk.plugins.b;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils.ResizeMode;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.EffectThumbLoader.EffectThumbProcessor;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.widget.lib.hlist.AbsHListView.f;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView;
import com.everimaging.fotorsdk.widget.lib.hlist.AdapterView.c;
import com.everimaging.fotorsdk.widget.lib.hlist.HListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class a
        implements PopupWindow.OnDismissListener, com.everimaging.fotorsdk.filter.a.a, AdapterView.c {
    private static final String a = a.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private f c;
    private Context d;
    private PopupWindow e;
    private View f;
    private int g;
    private com.everimaging.fotorsdk.collage.adapter.a h;
    private HListView i;
    private List<EffectInfo> j;
    private b k;
    private Bitmap l;
    private a m;

    public a(f paramf) {
        this.c = paramf;
        this.d = paramf.getBaseContext();
        b();
    }

    private Bitmap a(EffectInfo paramEffectInfo, Bitmap paramBitmap) {
        EffectsParams localEffectsParams = new EffectsParams();
        localEffectsParams.setEffectEntity(paramEffectInfo.effectEntity);
        paramEffectInfo = new FxEffectFilter(this, paramBitmap, null, localEffectsParams, FxEffectFilter.Level.SMALL);
        paramEffectInfo.a(this.k);
        paramBitmap = paramEffectInfo.c();
        paramEffectInfo.a();
        return paramBitmap;
    }

    private void b() {
        Object localObject1 = LayoutInflater.from(this.d);
        Object localObject2 = new TypedValue();
        this.d.getTheme().resolveAttribute(R.attr.fotorCollagePopupMenuStyle, (TypedValue) localObject2, true);
        localObject2 = this.d.obtainStyledAttributes(((TypedValue) localObject2).data, R.styleable.FotorCollagePopupMenu);
        this.f = ((LayoutInflater) localObject1).inflate(R.layout.fotor_collage_fx_tools_panel, null);
        this.i = ((HListView) this.f.findViewById(R.id.fotor_collage_fx_listview));
        int n = this.d.getResources().getDimensionPixelSize(R.dimen.fotor_collage_fx_tools_item_spacing);
        new AbsHListView.f(n, -2);
        this.i.setChoiceMode(1);
        this.i.setOnItemClickListener(this);
        this.i.setDivider(new ColorDrawable(0));
        this.i.setDividerWidth(n);
        n = (int) (DeviceUtils.getScreenWidth() * 0.85F);
        int i1 = this.d.getResources().getDimensionPixelSize(R.dimen.fotor_collage_fx_tools_panel_height);
        this.e = new PopupWindow(this.f, n, i1);
        this.e.setFocusable(true);
        this.e.setOutsideTouchable(true);
        this.e.setOnDismissListener(this);
        this.e.setBackgroundDrawable(new ColorDrawable(0));
        localObject1 = ((TypedArray) localObject2).getDrawable(0);
        this.f.setBackgroundDrawable((Drawable) localObject1);
        this.e.setAnimationStyle(R.style.FotorCollagePopupAnim);
        c();
        ((TypedArray) localObject2).recycle();
    }

    private void c() {
        Object localObject1 = new FeatureBindPack(this.d.getPackageName(), "Collage_Effect", 0, 0, 2);
        this.k = new b(this.d, (FeatureBindPack) localObject1);
        Object localObject2 = this.k.b();
        if (localObject2 == null) {
            throw new IllegalStateException("can't find collage effect config!");
        }
        localObject1 = (EffectConfig) new GsonBuilder().create().fromJson(new InputStreamReader((InputStream) localObject2), EffectConfig.class);
        FotorIOUtils.closeSilently((Closeable) localObject2);
        if ((localObject1 == null) || (((EffectConfig) localObject1).classes == null) || (((EffectConfig) localObject1).classes.size() == 0)) {
            throw new IllegalStateException("open collage effect failed!");
        }
        this.j = new ArrayList();
        localObject2 = new com.everimaging.fotorsdk.algorithms.xml.d();
        int n = 0;
        if (n < ((EffectConfig) localObject1).classes.size()) {
            EffectInfo localEffectInfo = new EffectInfo();
            EffectConfig.EffectItem localEffectItem = (EffectConfig.EffectItem) ((EffectConfig) localObject1).classes.get(n);
            InputStream localInputStream = this.k.a(localEffectItem.algorithm_file);
            if (localInputStream == null) {
            }
            for (; ; ) {
                n += 1;
                break;
                ((com.everimaging.fotorsdk.algorithms.xml.d) localObject2).a(localInputStream);
                FotorIOUtils.closeSilently(localInputStream);
                localEffectInfo.effectEntity = ((com.everimaging.fotorsdk.algorithms.xml.d) localObject2).a();
                localEffectInfo.title = localEffectItem.title;
                this.j.add(localEffectInfo);
            }
        }
        if (this.j.size() > 0) {
            localObject1 = new EffectInfo();
            ((EffectInfo) localObject1).effectEntity = new EffectEntity();
            ((EffectInfo) localObject1).title = this.d.getString(R.string.fotor_original);
            this.j.add(0, localObject1);
        }
    }

    public void a(int paramInt) {
        this.g = paramInt;
    }

    public void a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            int n = (int) this.d.getResources().getDimension(R.dimen.fotor_collage_fx_tools_item_min_width);
            this.l = BitmapUtils.resizeBitmap(paramBitmap, n, n, BitmapUtils.ResizeMode.CENTER_CROP);
            this.h = new com.everimaging.fotorsdk.collage.adapter.a(this.d, this.j, new EffectThumbLoader.EffectThumbProcessor() {
                public Bitmap processBitmap(EffectInfo paramAnonymousEffectInfo, Bitmap paramAnonymousBitmap) {
                    if (paramAnonymousBitmap == null) {
                        a.a().e(new Object[]{"process thumbnail source is null"});
                        return null;
                    }
                    return a.a(a.this, paramAnonymousEffectInfo, paramAnonymousBitmap);
                }
            }, this.l);
            this.i.setAdapter(this.h);
        }
    }

    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        if (!this.e.isShowing()) {
            this.e.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
        }
    }

    public void a(EffectEntity paramEffectEntity) {
        int n = 0;
        if (paramEffectEntity == null) {
            this.h.b(0);
        }
        for (; ; ) {
            this.i.setSelection(n);
            return;
            this.h.a(paramEffectEntity);
            n = this.h.b(paramEffectEntity);
        }
    }

    public void a(a parama) {
        this.m = parama;
    }

    public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        int n = paramInt - this.i.getHeaderViewsCount();
        if ((n >= 0) && (n < this.h.getCount())) {
            paramAdapterView = this.h.a(n);
            if (!this.h.c(n)) {
            }
        } else {
            return;
        }
        paramInt = this.i.getFirstVisiblePosition();
        int i1 = this.i.getLastVisiblePosition();
        if (Math.abs(n - paramInt) > Math.abs(n - i1)) {
            paramInt = 1;
            label88:
            if (paramInt == 0) {
                break label172;
            }
            if (n >= this.h.getCount() - 1) {
                break label160;
            }
            this.i.c(n + 1);
        }
        for (; ; ) {
            this.h.b(n);
            if (this.m == null) {
                break;
            }
            this.m.a(this.g, paramAdapterView.effectEntity, this.k);
            return;
            paramInt = 0;
            break label88;
            label160:
            this.i.c(n);
            continue;
            label172:
            if (n > 0) {
                this.i.c(n - 1);
            } else {
                this.i.c(n);
            }
        }
    }

    public Context getContext() {
        return this.d;
    }

    public RenderScript getRenderScript() {
        return this.c.f().i();
    }

    public com.everimaging.fotorsdk.algorithms.filter.d getScript_BaseFilter() {
        return this.c.f().j();
    }

    public void onDismiss() {
        if (this.m != null) {
            this.m.a(this.g);
        }
    }

    public static abstract interface a {
        public abstract void a(int paramInt);

        public abstract void a(int paramInt, EffectEntity paramEffectEntity, b paramb);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */