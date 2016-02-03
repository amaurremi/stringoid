package mobi.ifunny.studio.crop.fixed;

import butterknife.ButterKnife.Finder;
import mobi.ifunny.view.ProgressBar;

public class FixedCropImageFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, FixedCropImageFragment paramFixedCropImageFragment, Object paramObject) {
        paramFixedCropImageFragment.image = ((FixedCropImageView) paramFinder.findRequiredView(paramObject, 2131492972, "field 'image'"));
        paramFixedCropImageFragment.progress = ((ProgressBar) paramFinder.findRequiredView(paramObject, 2131493083, "field 'progress'"));
    }

    public static void reset(FixedCropImageFragment paramFixedCropImageFragment) {
        paramFixedCropImageFragment.image = null;
        paramFixedCropImageFragment.progress = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/fixed/FixedCropImageFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */