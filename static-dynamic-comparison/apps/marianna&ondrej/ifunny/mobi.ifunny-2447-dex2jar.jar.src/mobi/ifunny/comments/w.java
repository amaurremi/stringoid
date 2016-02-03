package mobi.ifunny.comments;

import android.content.DialogInterface.OnClickListener;

public final class w
        extends h
        implements DialogInterface.OnClickListener {
    public static w a(String paramString) {
        w localw = new w();
        localw.a(null, paramString);
        return localw;
    }

    public void e() {
        CommentsFragment.e(g());
    }

    public void f() {
        CommentsFragment.f(g());
    }

    public CommentsFragment g() {
        return (CommentsFragment) getParentFragment();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */