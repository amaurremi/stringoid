package mobi.ifunny.gallery.fragment;

import mobi.ifunny.b.g;
import mobi.ifunny.gallery.GalleryFragment;

public abstract class o
        extends p {
    public void a(int paramInt) {
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
    }

    public void b() {
    }

    public void setUserVisibleHint(boolean paramBoolean) {
        super.setUserVisibleHint(paramBoolean);
        if (paramBoolean) {
            g.b(getActivity(), f().d());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */