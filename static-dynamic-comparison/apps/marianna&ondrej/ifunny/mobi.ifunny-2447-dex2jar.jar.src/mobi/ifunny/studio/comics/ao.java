package mobi.ifunny.studio.comics;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;

import java.io.IOException;
import java.util.List;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.d;
import mobi.ifunny.h;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.studio.comics.a.e;
import mobi.ifunny.studio.comics.a.g;
import mobi.ifunny.util.aa;
import mobi.ifunny.util.l;

class ao
        extends mobi.ifunny.l.b<RageEditorActivity, Void, Void, Throwable> {
    private final ap a;
    private mobi.ifunny.studio.a.b.a b;
    private final int c;
    private final IFunny d;
    private final boolean e;
    private final Context f;
    private SparseArray<Bitmap> g;

    private ao(RageEditorActivity paramRageEditorActivity, ap paramap, mobi.ifunny.studio.a.b.a parama, int paramInt, IFunny paramIFunny, boolean paramBoolean) {
        super(paramRageEditorActivity, RageEditorActivity.r());
        this.a = paramap;
        this.b = parama;
        this.c = paramInt;
        this.d = paramIFunny;
        this.e = paramBoolean;
        this.f = IFunnyApplication.a;
    }

    private SparseArray<Bitmap> a(mobi.ifunny.studio.a.b.a parama, int paramInt) {
        SparseArray localSparseArray = new SparseArray();
        List localList = parama.b;
        int j = localList.size();
        int i = 0;
        while (i < j) {
            if ((paramInt == -1) || (i == paramInt)) {
                parama = (mobi.ifunny.studio.a.b.b) localList.get(i);
                if (parama.a()) {
                    parama = null;
                    localSparseArray.put(i, parama);
                    if (isCanceled()) {
                        return localSparseArray;
                    }
                } else {
                    Context localContext = this.f;
                    g localg = g.c;
                    if (i == j - 1) {
                    }
                    for (boolean bool = true; ; bool = false) {
                        parama = e.a(localContext, parama, localg, bool);
                        break;
                    }
                }
            }
            i += 1;
        }
        return localSparseArray;
    }

    private mobi.ifunny.studio.a.b.a a() {
        mobi.ifunny.studio.a.a locala = aa.a(l.a(this.f, "comics.autosave.msgpack"));
        mobi.ifunny.studio.a.b localb = locala.a;
        if (TextUtils.equals(localb.a, "comics")) {
            switch (localb.b) {
                default:
                    d.e(RageEditorActivity.s(), "autoload() unknown draft version " + localb.b);
            }
        }
        for (; ; ) {
            return null;
            return (mobi.ifunny.studio.a.b.a) locala.b;
            d.e(RageEditorActivity.s(), "autoload() unknown draft type " + localb.a);
        }
    }

    private void a(mobi.ifunny.studio.a.b.a parama) {
        mobi.ifunny.studio.a.b localb = new mobi.ifunny.studio.a.b();
        localb.a = "comics";
        localb.b = 1;
        mobi.ifunny.studio.a.a locala = new mobi.ifunny.studio.a.a();
        locala.a = localb;
        locala.b = parama;
        parama = aa.a(locala);
        l.a(this.f, "comics.autosave.msgpack", parama);
    }

    public static void a(RageEditorActivity paramRageEditorActivity) {
        new ao(paramRageEditorActivity, ap.a, null, -1, null, true).execute(new Void[0]);
    }

    public static void a(RageEditorActivity paramRageEditorActivity, mobi.ifunny.studio.a.b.a parama) {
        new ao(paramRageEditorActivity, ap.b, parama, -1, null, true).execute(new Void[0]);
    }

    public static void a(RageEditorActivity paramRageEditorActivity, mobi.ifunny.studio.a.b.a parama, int paramInt) {
        new ao(paramRageEditorActivity, ap.c, parama, paramInt, null, false).execute(new Void[0]);
    }

    private void b() {
        l.c(this.f, "comics.autosave.msgpack");
    }

    public static void b(RageEditorActivity paramRageEditorActivity, mobi.ifunny.studio.a.b.a parama) {
        new ao(paramRageEditorActivity, ap.c, parama, -2, null, false).execute(new Void[0]);
    }

    protected Throwable a(Void... paramVarArgs) {
        if ((this.a != ap.a) || (this.b == null)) {
        }
        try {
            this.b = a();
            if (isCanceled()) {
            }
            for (; ; ) {
                return null;
                d.d(RageEditorActivity.s(), RageEditorActivity.r() + " do not autoload cause draft already set");
                if (this.c == -2) {
                    d.b(RageEditorActivity.s(), RageEditorActivity.r() + " do not update cause no index range selected");
                }
                for (; ; ) {
                    if ((this.a == ap.b) || (this.a == ap.c)) {
                        if (this.b == null) {
                            paramVarArgs = RageEditorActivity.r() + " do not autosave cause draft is null";
                            d.e(RageEditorActivity.s(), paramVarArgs);
                            return new NullPointerException(paramVarArgs);
                            if (this.b == null) {
                                paramVarArgs = RageEditorActivity.r() + " do not update cause draft is null";
                                d.e(RageEditorActivity.s(), paramVarArgs);
                                return new NullPointerException(paramVarArgs);
                            }
                            this.g = a(this.b, this.c);
                            if (!isCanceled()) {
                                continue;
                            }
                            return null;
                        }
                    }
                }
                try {
                    a(this.b);
                    if ((!isCanceled()) && (this.a == ap.d)) {
                        b();
                        return null;
                    }
                } catch (IOException paramVarArgs) {
                    for (; ; ) {
                    }
                }
            }
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
        }
    }

    protected void a(RageEditorActivity paramRageEditorActivity, Throwable paramThrowable) {
        if (paramThrowable == null) {
            paramRageEditorActivity.a(this.a, this.b, this.g, this.d);
        }
        for (; ; ) {
            h.a().b("pref.rage_editor_autoload_failed", false);
            return;
            paramRageEditorActivity.a(this.a, paramThrowable);
        }
    }

    protected void b(RageEditorActivity paramRageEditorActivity) {
        super.onStarted(paramRageEditorActivity);
        if (this.e) {
            paramRageEditorActivity.n();
        }
    }

    protected void b(RageEditorActivity paramRageEditorActivity, Throwable paramThrowable) {
        super.onCancelled(paramRageEditorActivity, paramThrowable);
        if (paramRageEditorActivity != null) {
            paramRageEditorActivity.a(this.a);
        }
        h.a().b("pref.rage_editor_autoload_failed", false);
    }

    protected void c(RageEditorActivity paramRageEditorActivity) {
        super.onFinished(paramRageEditorActivity);
        if (this.e) {
            paramRageEditorActivity.o();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */