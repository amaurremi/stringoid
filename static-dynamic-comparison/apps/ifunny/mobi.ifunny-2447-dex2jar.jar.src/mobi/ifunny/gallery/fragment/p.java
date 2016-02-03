package mobi.ifunny.gallery.fragment;

import android.content.Intent;
import android.os.Bundle;
import mobi.ifunny.fragment.FragmentPage;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.rest.content.IFunny;

public abstract class p
        extends FragmentPage {
    protected Bundle a;

    protected final f e() {
        return (f) getParentFragment();
    }

    protected final GalleryFragment f() {
        return e().k();
    }

    public final IFunny n() {
        return e().j();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.a = ((Bundle) getArguments().getParcelable("arg.option.args"));
    }

    public void startActivity(Intent paramIntent) {
        f().startActivity(paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */