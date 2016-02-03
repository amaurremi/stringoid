package mobi.ifunny.comments;

import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.rest.content.Comment;

public final class z
        extends h
        implements DialogInterface.OnClickListener {
    public static z a(Comment paramComment, String paramString) {
        z localz = new z();
        localz.a(paramComment, paramString);
        return localz;
    }

    public void e() {
        CommentsFragment.a(g(), (Comment) d());
    }

    public CommentsFragment g() {
        return (CommentsFragment) getParentFragment();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */