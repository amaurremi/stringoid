package mobi.ifunny.studio.meme;

import android.widget.AbsListView;
import mobi.ifunny.gallery.a.g;
import mobi.ifunny.k.t;
import mobi.ifunny.k.x;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.rest.content.MemeSourcesFeed;
import mobi.ifunny.view.drawable.f;

public class i
        extends g<f, MemeSource, MemeSourcesFeed> {
    public i(AbsListView paramAbsListView) {
        super(paramAbsListView, 3, 8000);
    }

    protected t<f> d() {
        return new x();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/meme/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */