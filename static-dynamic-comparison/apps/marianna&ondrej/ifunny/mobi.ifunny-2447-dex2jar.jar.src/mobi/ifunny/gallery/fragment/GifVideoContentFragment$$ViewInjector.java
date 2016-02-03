package mobi.ifunny.gallery.fragment;

import android.view.ViewStub;
import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.PinchImageView;
import mobi.ifunny.view.ProgressBar;

public class GifVideoContentFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, GifVideoContentFragment paramGifVideoContentFragment, Object paramObject) {
        paramGifVideoContentFragment.progressBar = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493119, "field 'progressBar'"));
        paramGifVideoContentFragment.img = ((PinchImageView) paramFinder.findRequiredView(paramObject, 2131493120, "field 'img'"));
        paramGifVideoContentFragment.reloadStub = ((ViewStub) paramFinder.findRequiredView(paramObject, 2131493121, "field 'reloadStub'"));
    }

    public static void reset(GifVideoContentFragment paramGifVideoContentFragment) {
        paramGifVideoContentFragment.progressBar = null;
        paramGifVideoContentFragment.img = null;
        paramGifVideoContentFragment.reloadStub = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/GifVideoContentFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */