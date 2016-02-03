package mobi.ifunny.view.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import mobi.ifunny.util.a.d;

public class FadingCropDrawable
        extends f {
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private FadingCropDrawable.CropState i;
    private e j;
    private boolean k;
    private Paint l;

    public FadingCropDrawable(d paramd) {
        this(paramd, null, false);
    }

    public FadingCropDrawable(d paramd, FadingCropDrawable.CropState paramCropState, boolean paramBoolean) {
        super(paramd, paramBoolean);
        a(paramCropState);
        this.l = new Paint();
        this.l.setColor(-1605349296);
        a(true);
    }

    private void i() {
        this.i.b(this.i.b() / getBounds().height());
        this.i.a(this.i.a() / getBounds().width());
    }

    private void j() {
        int i1 = getIntrinsicWidth();
        int i2 = getIntrinsicHeight();
        int m = (int) (this.i.c(0) * i1);
        int n = (int) (this.i.c(2) * i2);
        int i4 = (int) (i1 - this.i.c(1) * i1);
        int i3 = (int) (i2 - this.i.c(3) * i2);
        Rect localRect = this.g;
        if (m >= 0) {
            if (n < 0) {
                break label161;
            }
            label94:
            if (i4 > i1) {
                break label167;
            }
            i1 = i4;
            label105:
            if (i3 > i2) {
                break label170;
            }
            i2 = i3;
            label116:
            localRect.set(m, n, i1, i2);
            localRect = getBounds();
            if ((localRect != null) && (localRect.width() != 0) && (localRect.height() != 0)) {
                break label173;
            }
        }
        label161:
        label167:
        label170:
        label173:
        do {
            return;
            m = 0;
            break;
            n = 0;
            break label94;
            break label105;
            break label116;
            i3 = localRect.width();
            m = localRect.height();
            i4 = localRect.left;
            n = localRect.top;
            localRect = this.h;
            float f1 = i4;
            i1 = (int) (this.i.c(0) * i3 + f1);
            i2 = (int) (n + this.i.c(2) * m);
            f1 = i4 + i3;
            float f2 = this.i.c(1);
            i3 = (int) (f1 - i3 * f2);
            f1 = n + m;
            f2 = this.i.c(3);
            localRect.set(i1, i2, i3, (int) (f1 - m * f2));
        } while (this.j == null);
        this.j.a(this);
    }

    public void a(FadingCropDrawable.CropState paramCropState) {
        if (paramCropState == null) {
            this.i = new FadingCropDrawable.CropState();
            int m = 0;
            while (m < 4) {
                this.i.a(m, 0.0F);
                m += 1;
            }
        }
        this.i = paramCropState;
        j();
    }

    public final void a(boolean paramBoolean) {
        this.k = paramBoolean;
    }

    public final boolean a() {
        return this.k;
    }

    public void b() {
        int m = g();
        int n = h();
        a(this.g.left, m - this.g.right, this.g.top, n - this.g.bottom);
    }

    public Bitmap c() {
        b();
        boolean bool = a();
        a(false);
        Bitmap localBitmap = super.c();
        a(0, 0, 0, 0);
        a(bool);
        return localBitmap;
    }

    public Bitmap d() {
        boolean bool = a();
        a(false);
        Bitmap localBitmap = super.d();
        a(bool);
        return localBitmap;
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        if (!this.k) {
            return;
        }
        Rect localRect1 = getBounds();
        Rect localRect2 = this.h;
        paramCanvas.drawRect(localRect1.left, localRect1.top, localRect2.left, localRect1.bottom, this.l);
        paramCanvas.drawRect(localRect2.right, localRect1.top, localRect1.right, localRect1.bottom, this.l);
        paramCanvas.drawRect(localRect2.left, localRect2.bottom, localRect2.right, localRect1.bottom, this.l);
        paramCanvas.drawRect(localRect2.left, localRect1.top, localRect2.right, localRect2.top, this.l);
    }

    public Drawable mutate() {
        FadingCropDrawable localFadingCropDrawable = new FadingCropDrawable(e());
        try {
            localFadingCropDrawable.a((FadingCropDrawable.CropState) this.i.clone());
            return localFadingCropDrawable;
        } catch (CloneNotSupportedException localCloneNotSupportedException) {
        }
        return localFadingCropDrawable;
    }

    protected void onBoundsChange(Rect paramRect) {
        super.onBoundsChange(paramRect);
        i();
        j();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/drawable/FadingCropDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */