package mobi.ifunny.studio.comics;

import java.io.IOException;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.d;
import mobi.ifunny.util.aa;
import mobi.ifunny.util.l;

public class y
        extends mobi.ifunny.l.b<FrameEditorActivity, Void, Void, Void> {
    private final mobi.ifunny.studio.a.b.b a;

    public y(FrameEditorActivity paramFrameEditorActivity, String paramString, mobi.ifunny.studio.a.b.b paramb) {
        super(paramFrameEditorActivity, paramString);
        this.a = paramb;
    }

    protected Void a(Void... paramVarArgs) {
        try {
            paramVarArgs = aa.a(this.a);
            l.a(IFunnyApplication.a, "comics.frame.msgpack", paramVarArgs);
            return null;
        } catch (IOException paramVarArgs) {
            for (; ; ) {
                d.c(FrameEditorActivity.w(), "Failed to serialize frame into comics.frame.msgpack", paramVarArgs);
            }
        }
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity) {
        super.onStarted(paramFrameEditorActivity);
        FrameEditorActivity.b(paramFrameEditorActivity, FrameEditorActivity.v());
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity, Void paramVoid) {
        paramFrameEditorActivity.r();
    }

    protected void b(FrameEditorActivity paramFrameEditorActivity, Void paramVoid) {
        super.onCancelled(paramFrameEditorActivity, paramVoid);
        if (paramFrameEditorActivity != null) {
            FrameEditorActivity.c(paramFrameEditorActivity);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */