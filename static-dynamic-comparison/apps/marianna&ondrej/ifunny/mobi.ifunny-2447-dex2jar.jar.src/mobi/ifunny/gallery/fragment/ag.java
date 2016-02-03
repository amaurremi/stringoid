package mobi.ifunny.gallery.fragment;

import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

final class ag
        extends n<YoutubeVideoContentFragment, d> {
    public ag(YoutubeVideoContentFragment paramYoutubeVideoContentFragment, String paramString) {
        super(paramYoutubeVideoContentFragment, paramString, f.a(a.a()));
    }

    protected void a(YoutubeVideoContentFragment paramYoutubeVideoContentFragment) {
        super.onFinished(paramYoutubeVideoContentFragment);
    }

    protected void a(YoutubeVideoContentFragment paramYoutubeVideoContentFragment, m<d> paramm) {
        super.onPostExecute(paramYoutubeVideoContentFragment, paramm);
        paramYoutubeVideoContentFragment.a(paramm);
    }

    protected void a(YoutubeVideoContentFragment paramYoutubeVideoContentFragment, Integer... paramVarArgs) {
        super.onProgressUpdate(paramYoutubeVideoContentFragment, paramVarArgs);
        paramYoutubeVideoContentFragment.b(paramVarArgs[0].intValue());
    }

    protected void b(YoutubeVideoContentFragment paramYoutubeVideoContentFragment, m<d> paramm) {
        super.onCancelled(paramYoutubeVideoContentFragment, paramm);
        if (paramm != null) {
            paramYoutubeVideoContentFragment = (d) paramm.a;
            if (paramYoutubeVideoContentFragment != null) {
                paramYoutubeVideoContentFragment.a();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */