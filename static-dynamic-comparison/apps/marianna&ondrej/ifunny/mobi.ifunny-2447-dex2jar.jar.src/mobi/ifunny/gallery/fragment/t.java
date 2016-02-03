package mobi.ifunny.gallery.fragment;

import android.os.Bundle;
import mobi.ifunny.d;

public class t
        extends f {
    private static final String c = t.class.getSimpleName();

    protected o a(Bundle paramBundle) {
        YoutubeVideoContentFragment localYoutubeVideoContentFragment = new YoutubeVideoContentFragment();
        localYoutubeVideoContentFragment.setArguments(paramBundle);
        return localYoutubeVideoContentFragment;
    }

    public void i() {
        d.e(c, "Save is not supported by VideoFragment");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */