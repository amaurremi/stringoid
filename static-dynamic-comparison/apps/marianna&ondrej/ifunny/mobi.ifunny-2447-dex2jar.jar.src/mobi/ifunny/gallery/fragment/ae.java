package mobi.ifunny.gallery.fragment;

import android.graphics.Rect;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

final class ae
        extends n<PosterContentFragment, d> {
    private static Rect a = new Rect(0, 0, 0, 20);
    private static a b = new a(null, false, a);

    public ae(PosterContentFragment paramPosterContentFragment, String paramString) {
        super(paramPosterContentFragment, paramString, f.a(b));
    }

    protected void a(PosterContentFragment paramPosterContentFragment) {
        super.onFinished(paramPosterContentFragment);
    }

    protected void a(PosterContentFragment paramPosterContentFragment, m<d> paramm) {
        super.onPostExecute(paramPosterContentFragment, paramm);
        paramPosterContentFragment.a(paramm);
    }

    protected void a(PosterContentFragment paramPosterContentFragment, Integer... paramVarArgs) {
        super.onProgressUpdate(paramPosterContentFragment, paramVarArgs);
        paramPosterContentFragment.b(paramVarArgs[0].intValue());
    }

    protected void b(PosterContentFragment paramPosterContentFragment, m<d> paramm) {
        super.onCancelled(paramPosterContentFragment, paramm);
        if (paramm != null) {
            paramPosterContentFragment = (d) paramm.a;
            if (paramPosterContentFragment != null) {
                paramPosterContentFragment.a();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */