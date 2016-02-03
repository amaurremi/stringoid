package mobi.ifunny.gallery.fragment;

import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;
import mobi.ifunny.video.c;

final class e
        extends n<GifVideoContentFragment, c> {
    public e(GifVideoContentFragment paramGifVideoContentFragment, String paramString, boolean paramBoolean) {
        super(paramGifVideoContentFragment, paramString, f.a(paramBoolean));
    }

    protected void a(GifVideoContentFragment paramGifVideoContentFragment, m<c> paramm) {
        super.onPostExecute(paramGifVideoContentFragment, paramm);
        paramGifVideoContentFragment.a(paramm);
    }

    protected void a(GifVideoContentFragment paramGifVideoContentFragment, Integer... paramVarArgs) {
        super.onProgressUpdate(paramGifVideoContentFragment, paramVarArgs);
        paramGifVideoContentFragment.b(paramVarArgs[0].intValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */