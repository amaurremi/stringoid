package mobi.ifunny.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import mobi.ifunny.d;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunny.Source;
import mobi.ifunny.rest.content.User;

class n
        implements View.OnClickListener {
    n(GalleryFragment paramGalleryFragment) {
    }

    public void onClick(View paramView) {
        IFunny localIFunny = this.a.x();
        if ((localIFunny == null) || (localIFunny.creator == null)) {
            d.d(GalleryFragment.z(), "Invalid current content");
        }
        do {
            return;
            switch (paramView.getId()) {
                default:
                    return;
                case 2131493071:
                    if (!localIFunny.hasSource()) {
                        break label121;
                    }
                    paramView = localIFunny.source.creator;
            }
        } while (paramView == null);
        GalleryFragment.a(this.a, paramView.id);
        return;
        if (localIFunny.hasSource()) {
            GalleryFragment.c(this.a).show();
            return;
        }
        GalleryFragment.a(this.a, localIFunny.creator.id);
        return;
        label121:
        GalleryFragment.a(this.a, localIFunny.creator.id);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */