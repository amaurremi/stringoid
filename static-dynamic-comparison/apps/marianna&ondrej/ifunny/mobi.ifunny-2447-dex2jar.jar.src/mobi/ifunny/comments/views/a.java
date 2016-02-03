package mobi.ifunny.comments.views;

import android.view.View;
import mobi.ifunny.rest.content.Comment;

public abstract interface a<C extends Comment> {
    public abstract boolean a(C paramC, View paramView);

    public abstract void b(C paramC, View paramView);

    public abstract void c(C paramC, View paramView);

    public abstract boolean d(C paramC, View paramView);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/comments/views/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */