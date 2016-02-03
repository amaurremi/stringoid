package mobi.ifunny.studio.comics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import android.widget.Toast;

import java.util.ArrayList;

import mobi.ifunny.l.b;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.a.e;
import mobi.ifunny.util.cache.f;

public class w
        extends b<FrameEditorActivity, mobi.ifunny.util.a.a, Void, Pair<d, mobi.ifunny.util.a.a>> {
    public w(FrameEditorActivity paramFrameEditorActivity) {
        super(paramFrameEditorActivity, "RAGEFACE_LOAD_TASK_TAG");
    }

    protected Pair<d, mobi.ifunny.util.a.a> a(mobi.ifunny.util.a.a... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        try {
            Object localObject = (Bitmap) mobi.ifunny.util.cache.a.a(paramVarArgs.c(), f.b(paramVarArgs)).a;
            if (localObject == null) {
                return null;
            }
            int i = ((Bitmap) localObject).getWidth();
            int j = ((Bitmap) localObject).getHeight();
            localObject = new e((Bitmap) localObject, new Rect(0, 0, i, j));
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(0, localObject);
            paramVarArgs = new Pair(new d(i, j, localArrayList), paramVarArgs);
            return paramVarArgs;
        } catch (Exception paramVarArgs) {
        }
        return null;
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity) {
        super.onStarted(paramFrameEditorActivity);
        FrameEditorActivity.b(paramFrameEditorActivity, "RAGEFACE_LOAD_TASK_TAG");
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity, Pair<d, mobi.ifunny.util.a.a> paramPair) {
        if (FrameEditorActivity.e(paramFrameEditorActivity) == m.d) {
            if (paramPair == null) {
                Toast.makeText(paramFrameEditorActivity, 2131690008, 0).show();
            }
        } else {
            return;
        }
        FrameEditorActivity.a(paramFrameEditorActivity, (d) paramPair.first, ((mobi.ifunny.util.a.a) paramPair.second).f(), ((mobi.ifunny.util.a.a) paramPair.second).c());
    }

    protected void b(FrameEditorActivity paramFrameEditorActivity) {
        super.onFinished(paramFrameEditorActivity);
        if (FrameEditorActivity.e(paramFrameEditorActivity) == m.d) {
            FrameEditorActivity.c(paramFrameEditorActivity);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */