package mobi.ifunny.comments;

import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.rest.content.Comment;

public final class q
        extends h
        implements DialogInterface.OnClickListener {
    public static q a(Comment paramComment, String paramString) {
        q localq = new q();
        localq.a(paramComment, paramString);
        return localq;
    }

    public void e() {
        CommentsFragment.b(g(), (Comment) d());
    }

    public CommentsFragment g() {
        return (CommentsFragment) getParentFragment();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */