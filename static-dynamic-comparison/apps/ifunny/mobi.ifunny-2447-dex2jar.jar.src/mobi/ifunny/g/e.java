package mobi.ifunny.g;

import android.content.DialogInterface.OnClickListener;
import mobi.ifunny.comments.h;
import mobi.ifunny.rest.content.MyCommented.CommentedContent;

public final class e
        extends h
        implements DialogInterface.OnClickListener {
    public static e a(MyCommented.CommentedContent paramCommentedContent, String paramString) {
        e locale = new e();
        locale.a(paramCommentedContent, paramString);
        return locale;
    }

    public void e() {
        b.a(g(), (MyCommented.CommentedContent) d());
    }

    public b g() {
        return (b) getParentFragment();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */