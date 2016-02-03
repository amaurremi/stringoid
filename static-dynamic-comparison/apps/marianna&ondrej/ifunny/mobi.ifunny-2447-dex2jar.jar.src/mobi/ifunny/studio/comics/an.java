package mobi.ifunny.studio.comics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

import java.util.Map;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.studio.comics.a.e;

public class an
        extends mobi.ifunny.l.b<RageEditorActivity, Void, Void, Boolean> {
    private final mobi.ifunny.studio.a.b.a a;
    private final Map<mobi.ifunny.studio.a.b.b, Bitmap> b;
    private byte[] c;
    private mobi.ifunny.studio.a.a d;

    public an(RageEditorActivity paramRageEditorActivity, String paramString, mobi.ifunny.studio.a.b.a parama, Map<mobi.ifunny.studio.a.b.b, Bitmap> paramMap) {
        super(paramRageEditorActivity, paramString);
        this.a = parama;
        this.b = paramMap;
    }

    protected Boolean a(Void... paramVarArgs) {
        paramVarArgs = e.a(IFunnyApplication.a, this.a, this.b);
        if ((paramVarArgs == null) || (isCanceled())) {
            return Boolean.valueOf(false);
        }
        this.c = mobi.ifunny.util.a.b.a(paramVarArgs, Bitmap.CompressFormat.JPEG, 90);
        if ((this.c == null) || (isCanceled())) {
            return Boolean.valueOf(false);
        }
        paramVarArgs = new mobi.ifunny.studio.a.b();
        paramVarArgs.a = "comics";
        paramVarArgs.b = 1;
        this.d = new mobi.ifunny.studio.a.a();
        this.d.a = paramVarArgs;
        this.d.b = this.a;
        return Boolean.valueOf(true);
    }

    protected void a(RageEditorActivity paramRageEditorActivity) {
        super.onStarted(paramRageEditorActivity);
        paramRageEditorActivity.n();
    }

    protected void a(RageEditorActivity paramRageEditorActivity, Boolean paramBoolean) {
        if (paramBoolean.booleanValue()) {
            paramRageEditorActivity.a(this.c, this.d);
        }
    }

    protected void b(RageEditorActivity paramRageEditorActivity) {
        super.onFinished(paramRageEditorActivity);
        paramRageEditorActivity.o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */