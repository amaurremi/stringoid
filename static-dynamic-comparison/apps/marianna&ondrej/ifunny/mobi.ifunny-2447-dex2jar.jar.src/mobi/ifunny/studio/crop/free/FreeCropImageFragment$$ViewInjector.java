package mobi.ifunny.studio.crop.free;

import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.ProgressBar;

public class FreeCropImageFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, FreeCropImageFragment paramFreeCropImageFragment, Object paramObject) {
        paramFreeCropImageFragment.imageView = ((FreeCropImageView) paramFinder.findRequiredView(paramObject, 2131492972, "field 'imageView'"));
        paramFreeCropImageFragment.progress = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493083, "field 'progress'"));
    }

    public static void reset(FreeCropImageFragment paramFreeCropImageFragment) {
        paramFreeCropImageFragment.imageView = null;
        paramFreeCropImageFragment.progress = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/FreeCropImageFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */