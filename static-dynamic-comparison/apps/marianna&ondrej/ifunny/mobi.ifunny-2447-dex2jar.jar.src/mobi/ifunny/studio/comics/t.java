package mobi.ifunny.studio.comics;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

import mobi.ifunny.l.b;
import mobi.ifunny.rest.content.RageCategory;
import mobi.ifunny.rest.content.RageFace;
import mobi.ifunny.studio.comics.view.HorizontalAdapterView;
import mobi.ifunny.util.cache.f;

public class t
        extends b<FrameEditorActivity, q, s, Void> {
    public t(FrameEditorActivity paramFrameEditorActivity) {
        super(paramFrameEditorActivity, "RAGEFACE_CATEGORY_LOAD_TASK_TAG");
    }

    protected Void a(q... paramVarArgs) {
        paramVarArgs = paramVarArgs[0];
        Object localObject = q.a(paramVarArgs);
        int j = q.b(paramVarArgs);
        localObject = ((RageCategory) localObject).sources;
        SparseArray localSparseArray = (SparseArray) FrameEditorActivity.u().get(q.c(paramVarArgs));
        int i = q.d(paramVarArgs);
        if ((i >= ((List) localObject).size()) || (isCanceled())) {
            return null;
        }
        RageFace localRageFace = (RageFace) ((List) localObject).get(i);
        paramVarArgs = new mobi.ifunny.util.a.a(localRageFace.url, new Point(0, j), false);
        paramVarArgs = (Bitmap) mobi.ifunny.util.cache.a.a(paramVarArgs.c(), f.b(paramVarArgs)).a;
        if (!isCanceled()) {
            if (paramVarArgs != null) {
                break label173;
            }
        }
        label173:
        for (paramVarArgs = new Point(j, j); ; paramVarArgs = new Point(paramVarArgs.getWidth(), paramVarArgs.getHeight())) {
            localSparseArray.append(i, paramVarArgs);
            publishProgress(new s[]{new s(localRageFace, paramVarArgs, null)});
            i += 1;
            break;
        }
    }

    protected void a(FrameEditorActivity paramFrameEditorActivity, s... paramVarArgs) {
        if (isCanceled()) {
        }
        RageFace localRageFace;
        do {
            return;
            paramVarArgs = paramVarArgs[0];
            localRageFace = s.a(paramVarArgs);
        } while (FrameEditorActivity.e(paramFrameEditorActivity) != m.d);
        ((u) ((HorizontalAdapterView) FrameEditorActivity.f(paramFrameEditorActivity).findViewById(2131493096)).getAdapter()).a(localRageFace, s.b(paramVarArgs));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */