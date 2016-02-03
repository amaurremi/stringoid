package mobi.ifunny.studio.meme;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.util.a.d;

class e
        extends mobi.ifunny.l.b<MemeEditorActivity, Void, Void, Object> {
    private final d a;
    private final String b;
    private final float c;
    private final String d;
    private final float e;
    private final String f;
    private final String g;
    private final int h;
    private final int i;
    private byte[] j;
    private mobi.ifunny.studio.a.a k;

    public e(MemeEditorActivity paramMemeEditorActivity, String paramString1, d paramd, int paramInt1, int paramInt2, String paramString2, float paramFloat1, String paramString3, float paramFloat2, String paramString4, String paramString5) {
        super(paramMemeEditorActivity, paramString1);
        this.a = paramd;
        this.b = paramString2;
        this.c = paramFloat1;
        this.d = paramString3;
        this.e = paramFloat2;
        this.f = paramString4;
        this.g = paramString5;
        this.h = paramInt1;
        this.i = paramInt2;
    }

    protected Object a(Void... paramVarArgs) {
        float f2 = 20.0F;
        paramVarArgs = mobi.ifunny.util.a.b.a(IFunnyApplication.a, this.a, this.h, this.i, this.b, this.c, this.d, this.e);
        if (isCanceled()) {
            return null;
        }
        this.j = mobi.ifunny.util.a.b.a(paramVarArgs, Bitmap.CompressFormat.JPEG, 90);
        paramVarArgs.recycle();
        if (isCanceled()) {
            return null;
        }
        paramVarArgs = new mobi.ifunny.studio.a.c.a();
        paramVarArgs.a = this.b;
        float f3 = this.c;
        float f1;
        if (f3 < 20.0F) {
            f1 = 20.0F;
            paramVarArgs.b = f1;
            paramVarArgs.c = this.d;
            f1 = this.e;
            if (f1 >= 20.0F) {
                break label180;
            }
            f1 = f2;
        }
        for (; ; ) {
            paramVarArgs.d = f1;
            if (this.f != null) {
                break label219;
            }
            localObject = this.a.d();
            if (!isCanceled()) {
                break label196;
            }
            return null;
            f1 = f3;
            if (f3 <= 70.0F) {
                break;
            }
            f1 = 70.0F;
            break;
            label180:
            if (f1 > 70.0F) {
                f1 = 70.0F;
            }
        }
        label196:
        paramVarArgs.g = mobi.ifunny.util.a.b.a((Bitmap) localObject, Bitmap.CompressFormat.JPEG, 90);
        if (isCanceled()) {
            return null;
            label219:
            paramVarArgs.e = this.f;
            paramVarArgs.f = this.g;
        }
        Object localObject = new mobi.ifunny.studio.a.b();
        ((mobi.ifunny.studio.a.b) localObject).a = "mem";
        ((mobi.ifunny.studio.a.b) localObject).b = 1;
        this.k = new mobi.ifunny.studio.a.a();
        this.k.a = ((mobi.ifunny.studio.a.b) localObject);
        this.k.b = paramVarArgs;
        return this;
    }

    protected void a(MemeEditorActivity paramMemeEditorActivity) {
        super.onStarted(paramMemeEditorActivity);
        paramMemeEditorActivity.n();
    }

    protected void a(MemeEditorActivity paramMemeEditorActivity, Object paramObject) {
        if (paramObject == null) {
            return;
        }
        paramMemeEditorActivity.a(this.j, this.k);
    }

    protected void b(MemeEditorActivity paramMemeEditorActivity) {
        super.onFinished(paramMemeEditorActivity);
        paramMemeEditorActivity.o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */