package mobi.ifunny.studio.comics;

import android.graphics.Point;
import android.net.Uri;
import android.util.Pair;

import java.io.File;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.e.l;
import mobi.ifunny.l.b;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;

public class n
        extends b<FrameEditorActivity, Pair<Uri, Point>, Void, d> {
    public n(FrameEditorActivity paramFrameEditorActivity) {
        super(paramFrameEditorActivity, "IMAGE_FILE_LOAD_TASK_TAG");
    }

    @SafeVarargs
    protected final d a(Pair<Uri, Point>... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        a locala = new a((Point) paramVarArgs.second, false);
        return l.a(IFunnyApplication.a, (Uri) paramVarArgs.first, locala);
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity) {
        super.onStarted(paramFrameEditorActivity);
        FrameEditorActivity.b(paramFrameEditorActivity, "IMAGE_FILE_LOAD_TASK_TAG");
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity, d paramd) {
        FrameEditorActivity.a(paramFrameEditorActivity, paramd, null, null);
        if (FrameEditorActivity.d(paramFrameEditorActivity) != null) {
            new File(FrameEditorActivity.d(paramFrameEditorActivity).getPath()).delete();
        }
        FrameEditorActivity.a(paramFrameEditorActivity, null);
    }

    protected void b(FrameEditorActivity paramFrameEditorActivity) {
        super.onFinished(paramFrameEditorActivity);
        FrameEditorActivity.c(paramFrameEditorActivity);
    }

    protected void b(FrameEditorActivity paramFrameEditorActivity, d paramd) {
        super.onCancelled(paramFrameEditorActivity, paramd);
        if (paramFrameEditorActivity != null) {
            if (FrameEditorActivity.d(paramFrameEditorActivity) != null) {
                new File(FrameEditorActivity.d(paramFrameEditorActivity).getPath()).delete();
            }
            FrameEditorActivity.a(paramFrameEditorActivity, null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */