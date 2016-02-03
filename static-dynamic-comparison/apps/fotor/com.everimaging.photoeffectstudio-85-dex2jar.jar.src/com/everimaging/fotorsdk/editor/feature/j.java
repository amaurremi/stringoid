package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.algorithms.xml.d;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter;
import com.everimaging.fotorsdk.editor.filter.FxEffectFilter.Level;
import com.everimaging.fotorsdk.editor.filter.params.EffectsParams;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorImageView.c;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
        extends a
        implements View.OnClickListener, FotorImageView.c {
    private static final String l = j.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    private LinearLayout n;
    private ImageButton o;
    private FotorImageView p;
    private Bitmap q;
    private EffectsParams r;
    private FxEffectFilter s;
    private boolean t = false;
    private boolean u = false;
    private List<EffectEntity> v;
    private d w;

    public j(c paramc) {
        super(paramc);
    }

    private EffectEntity a(String paramString) {
        try {
            paramString = this.h.getAssets().open("scenes/" + paramString);
            this.w.a(paramString);
            paramString = this.w.a();
            return paramString;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    private void a(int paramInt) {
        this.r.setEffectEntity((EffectEntity) this.v.get(paramInt));
        d();
    }

    private void a(boolean paramBoolean) {
        try {
            this.u = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private void b(boolean paramBoolean) {
        try {
            this.t = paramBoolean;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private boolean b() {
        try {
            boolean bool = this.u;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private boolean c() {
        try {
            boolean bool = this.t;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private void d() {
        if (c()) {
            a(true);
            return;
        }
        b(true);
        new a(null).execute(new Void[0]);
    }

    public void A() {
        if (this.b != null) {
            this.b.a(this, this.q, new BaseParams[]{this.r});
        }
    }

    protected void E() {
        String str2 = "Unknow";
        String str1 = str2;
        if (this.r != null) {
            str1 = str2;
            if (this.r.getEffectEntity() != null) {
                str1 = "" + this.r.getEffectEntity().getID();
            }
        }
        com.everimaging.fotorsdk.a.a("EDIT_SCENE_APPLY", "Scene_Type", str1);
    }

    public void a(FotorImageView paramFotorImageView) {
    }

    public void b(FotorImageView paramFotorImageView) {
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_scenes_operation_panel, null);
    }

    public void c(FotorImageView paramFotorImageView) {
        this.p.setImageBitmap(this.d);
    }

    public View d(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_zoom_draw_panel, null);
    }

    public void d(FotorImageView paramFotorImageView) {
        this.p.setImageBitmap(this.q);
    }

    public void f() {
        super.f();
        if (this.s != null) {
            this.s.b();
        }
        Iterator localIterator = this.v.iterator();
        while (localIterator.hasNext()) {
            EffectEntity localEffectEntity = (EffectEntity) localIterator.next();
            if (localEffectEntity != null) {
                localEffectEntity.dispose();
            }
        }
    }

    protected void m() {
        super.m();
        this.p.setImageBitmap(this.q);
        this.r = new EffectsParams();
        this.s = new FxEffectFilter(this, this.d, this.q, this.r, FxEffectFilter.Level.MEDIUM);
    }

    public void onClick(View paramView) {
        if ((this.o == paramView) || (!G())) {
            return;
        }
        a(((Integer) paramView.getTag()).intValue());
        if (this.o != null) {
            this.o.setSelected(false);
        }
        this.o = ((ImageButton) paramView);
        this.o.setSelected(true);
        String str = "Unknow";
        paramView = str;
        if (this.r != null) {
            paramView = str;
            if (this.r.getEffectEntity() != null) {
                paramView = "" + this.r.getEffectEntity().getID();
            }
        }
        com.everimaging.fotorsdk.a.a("EDIT_SCENE_ITEM_TAP", "Scene_Type", paramView);
    }

    protected void p() {
        super.p();
    }

    protected void q() {
        super.q();
        this.p.setImageBitmap(null);
    }

    protected void t() {
        this.w = new d();
    }

    protected void u() {
        int i = 0;
        LayoutInflater localLayoutInflater = (LayoutInflater) this.h.getSystemService("layout_inflater");
        this.n = ((LinearLayout) v().findViewById(R.id.fotor_scenes_pan_container));
        int[] arrayOfInt = new int[14];
        arrayOfInt[0] = R.string.fotor_scenes_original;
        arrayOfInt[1] = R.string.fotor_scenes_backlit;
        arrayOfInt[2] = R.string.fotor_scenes_darken;
        arrayOfInt[3] = R.string.fotor_scenes_cloudy;
        arrayOfInt[4] = R.string.fotor_scenes_shade;
        arrayOfInt[5] = R.string.fotor_scenes_sunset;
        arrayOfInt[6] = R.string.fotor_scenes_night;
        arrayOfInt[7] = R.string.fotor_scenes_flash;
        arrayOfInt[8] = R.string.fotor_scenes_fluorescent;
        arrayOfInt[9] = R.string.fotor_scenes_portrait;
        arrayOfInt[10] = R.string.fotor_scenes_sand_snow;
        arrayOfInt[11] = R.string.fotor_scenes_landscape;
        arrayOfInt[12] = R.string.fotor_scenes_theatre;
        arrayOfInt[13] = R.string.fotor_scenes_food;
        int j = R.drawable.fotor_scenes_original;
        int k = R.drawable.fotor_scenes_backlit;
        int i1 = R.drawable.fotor_scenes_darken;
        int i2 = R.drawable.fotor_scenes_cloudy;
        int i3 = R.drawable.fotor_scenes_shade;
        int i4 = R.drawable.fotor_scenes_sunset;
        int i5 = R.drawable.fotor_scenes_night;
        int i6 = R.drawable.fotor_scenes_flash;
        int i7 = R.drawable.fotor_scenes_fluorescent;
        int i8 = R.drawable.fotor_scenes_portrait;
        int i9 = R.drawable.fotor_scenes_sand_snow;
        int i10 = R.drawable.fotor_scenes_landscape;
        int i11 = R.drawable.fotor_scenes_theatre;
        int i12 = R.drawable.fotor_scenes_food;
        this.v = new ArrayList();
        if (i < arrayOfInt.length) {
            View localView = localLayoutInflater.inflate(R.layout.fotor_main_footer_item, null);
            FotorNavigationButton localFotorNavigationButton = (FotorNavigationButton) localView.findViewById(R.id.fotor_navigation_button);
            localFotorNavigationButton.setButtonName(this.h.getResources().getString(arrayOfInt[i]));
            localFotorNavigationButton.setTag(Integer.valueOf(i));
            localFotorNavigationButton.setImageDrawable(this.h.getResources().getDrawable(new int[]{j, k, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12}[i]));
            this.n.addView(localView, new ViewGroup.LayoutParams(-2, -1));
            localFotorNavigationButton.setOnClickListener(this);
            if (i == 0) {
                this.o = localFotorNavigationButton;
                localFotorNavigationButton.setSelected(true);
                this.v.add(new EffectEntity());
            }
            for (; ; ) {
                i += 1;
                break;
                this.v.add(a(new String[]{"169.xml", "168.xml", "167.xml", "166.xml", "164.xml", "162.xml", "170.xml", "165.xml", "173.xml", "161.xml", "163.xml", "171.xml", "160.xml"}[(i - 1)]));
            }
        }
        this.p = ((FotorImageView) w().findViewById(R.id.fotor_zoom_imageview));
        this.p.setFotorImageViewListener(this);
        this.q = BitmapUtils.copy(this.d, this.d.getConfig());
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.SCENES;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_scenes);
    }

    private class a
            extends FotorAsyncTask<Void, Void, Void> {
        private a() {
        }

        protected Void a(Void... paramVarArgs) {
            try {
                j.a(j.this).a();
                publishProgress(new Void[0]);
                if (j.b(j.this)) {
                    j.a(j.this, false);
                    j.a().c(new Object[]{"Do again"});
                    a(new Void[0]);
                } else {
                    j.b(j.this, false);
                    j.a().c(new Object[]{"Task done"});
                }
            } catch (Exception paramVarArgs) {
                paramVarArgs.printStackTrace();
            }
            return null;
        }

        protected void b(Void... paramVarArgs) {
            j.d(j.this).setImageBitmap(j.c(j.this));
            if ((j.e(j.this).getEffectEntity() != null) && (j.e(j.this).getEffectEntity().getID() != -1)) {
                j.this.i = true;
                return;
            }
            j.this.i = false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */