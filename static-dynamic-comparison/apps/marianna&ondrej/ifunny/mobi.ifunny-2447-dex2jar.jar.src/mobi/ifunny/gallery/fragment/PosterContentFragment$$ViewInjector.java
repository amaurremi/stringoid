package mobi.ifunny.gallery.fragment;

import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.PinchImageView;
import mobi.ifunny.view.ProgressBar;

public class PosterContentFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, PosterContentFragment paramPosterContentFragment, Object paramObject) {
        paramPosterContentFragment.progressBar = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493083, "field 'progressBar'"));
        paramPosterContentFragment.pinchImageView = ((PinchImageView) paramFinder.findRequiredView(paramObject, 2131493124, "field 'pinchImageView'"));
    }

    public static void reset(PosterContentFragment paramPosterContentFragment) {
        paramPosterContentFragment.progressBar = null;
        paramPosterContentFragment.pinchImageView = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/PosterContentFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */