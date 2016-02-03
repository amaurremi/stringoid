package mobi.ifunny.studio.caption;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.util.a.d;

class e
        extends mobi.ifunny.l.b<CaptionEditorActivity, Void, Void, Object> {
    private final d a;
    private final String b;
    private final float c;
    private final int d;
    private final int e;
    private byte[] f;
    private mobi.ifunny.studio.a.a g;

    public e(CaptionEditorActivity paramCaptionEditorActivity, d paramd, int paramInt1, int paramInt2, String paramString, float paramFloat) {
        super(paramCaptionEditorActivity, CaptionEditorActivity.p());
        this.a = paramd;
        this.b = paramString;
        this.c = paramFloat;
        this.d = paramInt1;
        this.e = paramInt2;
    }

    protected Object a(Void... paramVarArgs) {
        paramVarArgs = this.a.d();
        if ((paramVarArgs == null) || (isCanceled())) {
            return null;
        }
        Object localObject = mobi.ifunny.util.a.b.a(IFunnyApplication.a, this.a, this.d, this.e, this.b, this.c);
        if ((localObject == null) || (isCanceled())) {
            return null;
        }
        this.f = mobi.ifunny.util.a.b.a((Bitmap) localObject, Bitmap.CompressFormat.JPEG, 90);
        if (isCanceled()) {
            return null;
        }
        localObject = new mobi.ifunny.studio.a.a.a();
        ((mobi.ifunny.studio.a.a.a) localObject).a = this.b;
        ((mobi.ifunny.studio.a.a.a) localObject).b = mobi.ifunny.util.a.b.a(paramVarArgs, Bitmap.CompressFormat.JPEG, 90);
        if (isCanceled()) {
            return null;
        }
        paramVarArgs = new mobi.ifunny.studio.a.b();
        paramVarArgs.a = "caption";
        paramVarArgs.b = 1;
        this.g = new mobi.ifunny.studio.a.a();
        this.g.a = paramVarArgs;
        this.g.b = localObject;
        return this;
    }

    protected void a(CaptionEditorActivity paramCaptionEditorActivity) {
        super.onStarted(paramCaptionEditorActivity);
        paramCaptionEditorActivity.n();
    }

    protected void a(CaptionEditorActivity paramCaptionEditorActivity, Object paramObject) {
        if (paramObject == null) {
            return;
        }
        paramCaptionEditorActivity.a(this.f, this.g);
    }

    protected void b(CaptionEditorActivity paramCaptionEditorActivity) {
        super.onFinished(paramCaptionEditorActivity);
        paramCaptionEditorActivity.o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/caption/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */