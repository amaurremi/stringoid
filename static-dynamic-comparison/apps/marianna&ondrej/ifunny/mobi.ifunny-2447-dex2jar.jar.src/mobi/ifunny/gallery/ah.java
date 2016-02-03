package mobi.ifunny.gallery;

import mobi.ifunny.gallery.fragment.f;
import mobi.ifunny.gallery.fragment.m;
import mobi.ifunny.rest.content.IFunnyFeed;

public abstract class ah<T extends IFunnyFeed>
        extends GalleryFragment<T> {
    public boolean q() {
        f localf = w();
        if (localf != null) {
            if (localf.c() == m.b) {
                localf.g();
                t();
                return true;
            }
            if (localf.c() == m.c) {
                localf.e();
                t();
                return true;
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */