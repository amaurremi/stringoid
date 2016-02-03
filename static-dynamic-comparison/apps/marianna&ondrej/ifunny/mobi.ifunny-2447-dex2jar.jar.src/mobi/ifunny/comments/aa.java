package mobi.ifunny.comments;

import android.graphics.Bitmap;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.cache.f;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.util.cache.n;

public class aa
        extends n<CommentsFragment, Bitmap> {
    private final a a;

    public aa(CommentsFragment paramCommentsFragment, String paramString, a parama) {
        super(paramCommentsFragment, paramString, f.b(parama));
        this.a = parama;
    }

    protected void a(CommentsFragment paramCommentsFragment, m<Bitmap> paramm) {
        super.onPostExecute(paramCommentsFragment, paramm);
        if (paramm.a != null) {
            CommentsFragment.a(paramCommentsFragment, (Bitmap) paramm.a, this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */