package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.everimaging.fotorsdk.R.drawable;
import com.everimaging.fotorsdk.uil.core.assist.g;
import com.everimaging.fotorsdk.uil.core.c;
import com.everimaging.fotorsdk.uil.core.c.a;
import com.everimaging.fotorsdk.uil.core.d;
import com.everimaging.fotorsdk.utils.DeviceUtils;

public class FotorExternalPkgButton
        extends FotorNavigationButton {
    private BitmapDrawable F;
    private BitmapDrawable G;
    private int H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private c L;
    private Drawable a;
    private String b;
    private String c;

    public FotorExternalPkgButton(Context paramContext) {
        super(paramContext);
        e();
    }

    public FotorExternalPkgButton(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        e();
    }

    public FotorExternalPkgButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        e();
    }

    private void d() {
        if ((this.F != null) && (this.G != null)) {
            if ((this.F.getBitmap() == null) || (this.G.getBitmap() == null)) {
                setImageDrawable(this.a);
            }
        } else {
            return;
        }
        StateListDrawable localStateListDrawable = new StateListDrawable();
        BitmapDrawable localBitmapDrawable = this.G;
        localStateListDrawable.addState(new int[]{16842919}, localBitmapDrawable);
        localBitmapDrawable = this.F;
        localStateListDrawable.addState(new int[0], localBitmapDrawable);
        setImageDrawable(localStateListDrawable);
    }

    private void e() {
        this.H = 0;
        this.a = getResources().getDrawable(R.drawable.fotor_external_recommend_pkg_default_bg);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = true;
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inDither = false;
        localOptions.inJustDecodeBounds = false;
        localOptions.inPurgeable = false;
        localOptions.inInputShareable = false;
        localOptions.inTempStorage = new byte['䀀'];
        localOptions.inDensity = 320;
        localOptions.inTargetDensity = DeviceUtils.getDensity();
        this.L = new c.a().a(R.drawable.fotor_external_recommend_pkg_default_bg).b(R.drawable.fotor_external_recommend_pkg_default_bg).c(R.drawable.fotor_external_recommend_pkg_default_bg).a(true).b(true).a(localOptions).a();
        this.I = getResources().getDrawable(R.drawable.fotor_external_btn_new_indicator);
        this.J = getResources().getDrawable(R.drawable.fotor_external_btn_recommend_indicator);
        this.K = getResources().getDrawable(R.drawable.fotor_external_btn_download_indicator);
    }

    public void a(String paramString1, String paramString2) {
        this.b = paramString1;
        this.c = paramString2;
        setImageDrawable(this.a);
        this.F = null;
        this.G = null;
        paramString1 = d.a();
        paramString1.a(this.b, this.L, new g() {
            public void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap) {
                FotorExternalPkgButton.a(FotorExternalPkgButton.this, new BitmapDrawable(FotorExternalPkgButton.this.getResources(), paramAnonymousBitmap));
                FotorExternalPkgButton.a(FotorExternalPkgButton.this);
            }
        });
        paramString1.a(this.c, this.L, new g() {
            public void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap) {
                FotorExternalPkgButton.b(FotorExternalPkgButton.this, new BitmapDrawable(FotorExternalPkgButton.this.getResources(), paramAnonymousBitmap));
                FotorExternalPkgButton.a(FotorExternalPkgButton.this);
            }
        });
    }

    public boolean c() {
        return this.H == 1;
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        Object localObject = getDrawable();
        if ((localObject != null) && (localObject != this.a) && (this.H != 0) && (!this.x)) {
            if (this.H != 1) {
                break label160;
            }
            float f1 = this.g.right;
            float f2 = this.g.top;
            i = this.I.getIntrinsicWidth();
            j = this.I.getIntrinsicHeight();
            localObject = new Rect();
            ((Rect) localObject).left = ((int) (f1 - i / 2.0F));
            ((Rect) localObject).top = ((int) (f2 - j / 2.0F));
            ((Rect) localObject).right = (((Rect) localObject).left + i);
            ((Rect) localObject).bottom = (((Rect) localObject).top + j);
            this.I.setBounds((Rect) localObject);
            this.I.draw(paramCanvas);
        }
        label160:
        do {
            return;
            if (this.H == 3) {
                i = this.J.getIntrinsicWidth();
                j = this.J.getIntrinsicHeight();
                localObject = new Rect();
                ((Rect) localObject).left = (getWidth() - i);
                ((Rect) localObject).top = 0;
                ((Rect) localObject).right = getWidth();
                ((Rect) localObject).bottom = j;
                this.J.setBounds((Rect) localObject);
                this.J.draw(paramCanvas);
                return;
            }
        } while (this.H != 2);
        int i = this.K.getIntrinsicWidth();
        int j = this.K.getIntrinsicHeight();
        localObject = new Rect();
        ((Rect) localObject).left = (getWidth() - i);
        ((Rect) localObject).top = 0;
        ((Rect) localObject).right = getWidth();
        ((Rect) localObject).bottom = j;
        this.K.setBounds((Rect) localObject);
        this.K.draw(paramCanvas);
    }

    public void setShowIndicator(int paramInt) {
        this.H = paramInt;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorExternalPkgButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */