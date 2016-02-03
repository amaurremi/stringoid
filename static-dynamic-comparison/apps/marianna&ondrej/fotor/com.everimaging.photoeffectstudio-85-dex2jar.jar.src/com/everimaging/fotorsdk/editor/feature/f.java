package com.everimaging.fotorsdk.editor.feature;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.everimaging.fotorsdk.algorithms.filter.params.BaseParams;
import com.everimaging.fotorsdk.editor.FotorFeaturesFactory.FeatureType;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.editor.R.id;
import com.everimaging.fotorsdk.editor.R.layout;
import com.everimaging.fotorsdk.editor.R.string;
import com.everimaging.fotorsdk.editor.c;
import com.everimaging.fotorsdk.editor.filter.d;
import com.everimaging.fotorsdk.editor.filter.params.EnhanceParams;
import com.everimaging.fotorsdk.editor.filter.params.EnhanceParams.EnhanceLevel;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.widget.FotorImageView;
import com.everimaging.fotorsdk.widget.FotorImageView.c;
import com.everimaging.fotorsdk.widget.FotorNavigationButton;

public class f
        extends a
        implements View.OnClickListener, FotorImageView.c {
    private static final String l = f.class.getSimpleName();
    private static final FotorLoggerFactory.c m = FotorLoggerFactory.a(l, FotorLoggerFactory.LoggerType.CONSOLE);
    private LinearLayout n;
    private ImageButton o;
    private FotorImageView p;
    private Bitmap q;
    private EnhanceParams r;
    private d s;
    private boolean t = false;
    private boolean u = false;

    public f(c paramc) {
        super(paramc);
    }

    private void a(EnhanceParams.EnhanceLevel paramEnhanceLevel) {
        this.r.setEnhanceLevel(paramEnhanceLevel);
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
            if (this.r.getEnhanceLevel() != null) {
                str1 = this.r.getEnhanceLevel().name();
            }
        }
        com.everimaging.fotorsdk.a.a("EDIT_ENHANCE_APPLY", "Enhance_Type", str1);
    }

    public void a(FotorImageView paramFotorImageView) {
    }

    public void b(FotorImageView paramFotorImageView) {
    }

    public View c(LayoutInflater paramLayoutInflater) {
        return paramLayoutInflater.inflate(R.layout.fotor_feature_enhance_operation_panel, null);
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
    }

    protected void m() {
        super.m();
        this.q = BitmapUtils.createBitmap(this.d);
        this.p.setImageBitmap(this.q);
        this.r = new EnhanceParams();
        this.s = new d(this, this.d, this.q, this.r);
    }

    public void onClick(View paramView) {
        if ((this.o == paramView) || (!G())) {
            return;
        }
        a((EnhanceParams.EnhanceLevel) paramView.getTag());
        this.o.setSelected(false);
        this.o = ((ImageButton) paramView);
        this.o.setSelected(true);
        String str = "Unknow";
        paramView = str;
        if (this.r != null) {
            paramView = str;
            if (this.r.getEnhanceLevel() != null) {
                paramView = this.r.getEnhanceLevel().name();
            }
        }
        com.everimaging.fotorsdk.a.a("EDIT_ENHANCE_ITEM_TAP", "Enhance_Type", paramView);
    }

    protected void p() {
        super.p();
    }

    protected void q() {
        super.q();
        this.p.setImageBitmap(null);
    }

    protected void t() {
    }

    protected void u() {
        this.n = ((LinearLayout) v());
        int[] arrayOfInt = new int[4];
        arrayOfInt[0] = R.string.fotor_original;
        arrayOfInt[1] = R.string.fotor_enhance_low;
        arrayOfInt[2] = R.string.fotor_enhance_medium;
        arrayOfInt[3] = R.string.fotor_enhance_high;
        int j = R.drawable.fotor_scenes_original;
        int k = R.drawable.fotor_enhance_low;
        int i1 = R.drawable.fotor_enhance_medium;
        int i2 = R.drawable.fotor_enhance_high;
        EnhanceParams.EnhanceLevel localEnhanceLevel1 = EnhanceParams.EnhanceLevel.ORIGINAL;
        EnhanceParams.EnhanceLevel localEnhanceLevel2 = EnhanceParams.EnhanceLevel.LOW;
        EnhanceParams.EnhanceLevel localEnhanceLevel3 = EnhanceParams.EnhanceLevel.MEDUIM;
        EnhanceParams.EnhanceLevel localEnhanceLevel4 = EnhanceParams.EnhanceLevel.HIGH;
        int i = 0;
        while (i < arrayOfInt.length) {
            FotorNavigationButton localFotorNavigationButton = new FotorNavigationButton(this.h);
            localFotorNavigationButton.setButtonName(this.h.getResources().getString(arrayOfInt[i]));
            localFotorNavigationButton.setId(i);
            localFotorNavigationButton.setTag(new EnhanceParams.EnhanceLevel[]{localEnhanceLevel1, localEnhanceLevel2, localEnhanceLevel3, localEnhanceLevel4}[i]);
            localFotorNavigationButton.setImageDrawable(this.h.getResources().getDrawable(new int[]{j, k, i1, i2}[i]));
            this.n.addView(localFotorNavigationButton, new ViewGroup.LayoutParams(-2, -1));
            localFotorNavigationButton.setOnClickListener(this);
            if (i == 0) {
                this.o = localFotorNavigationButton;
                localFotorNavigationButton.setSelected(true);
            }
            i += 1;
        }
        this.p = ((FotorImageView) w().findViewById(R.id.fotor_zoom_imageview));
        this.p.setFotorImageViewListener(this);
    }

    public FotorFeaturesFactory.FeatureType x() {
        return FotorFeaturesFactory.FeatureType.ENHANCE;
    }

    public String y() {
        return this.h.getString(R.string.fotor_feature_enhance);
    }

    private class a
            extends AsyncTask<Void, Void, Void> {
        private a() {
        }

        protected Void a(Void... paramVarArgs) {
            try {
                if ((f.a(f.this) != null) && (f.this.G())) {
                    f.a(f.this).a();
                }
                publishProgress(new Void[0]);
                if (f.b(f.this)) {
                    f.a(f.this, false);
                    f.a().c(new Object[]{"Do again"});
                    a(new Void[0]);
                } else {
                    f.b(f.this, false);
                    f.a().c(new Object[]{"Task done"});
                }
            } catch (Exception paramVarArgs) {
                paramVarArgs.printStackTrace();
            }
            return null;
        }

        protected void b(Void... paramVarArgs) {
            f.d(f.this).setImageBitmap(f.c(f.this));
            if ((f.e(f.this).getEnhanceLevel() != null) && (f.e(f.this).getEnhanceLevel() != EnhanceParams.EnhanceLevel.ORIGINAL)) {
                f.this.i = true;
                return;
            }
            f.this.i = false;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/feature/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */