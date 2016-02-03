package mobi.ifunny.gallery;

import android.view.MenuItem;
import android.widget.PopupMenu.OnMenuItemClickListener;
import mobi.ifunny.d;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunny.Source;
import mobi.ifunny.rest.content.User;

class m
        implements PopupMenu.OnMenuItemClickListener {
    m(GalleryFragment paramGalleryFragment) {
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem) {
        boolean bool = true;
        IFunny localIFunny = this.a.x();
        if ((localIFunny == null) || (localIFunny.creator == null)) {
            d.d(GalleryFragment.z(), "Invalid current content");
            bool = false;
        }
        do {
            return bool;
            switch (paramMenuItem.getItemId()) {
                default:
                    return false;
                case 2131493395:
                    paramMenuItem = localIFunny.source.creator;
            }
        } while (paramMenuItem == null);
        GalleryFragment.a(this.a, paramMenuItem.id);
        return true;
        GalleryFragment.a(this.a, localIFunny.creator.id);
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */