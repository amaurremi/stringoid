package mobi.ifunny.intro;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class IntroFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, IntroFragment paramIntroFragment, Object paramObject) {
        paramIntroFragment.introSmile = ((ImageView) paramFinder.findRequiredView(paramObject, 2131493153, "field 'introSmile'"));
        paramIntroFragment.introMainText = ((ViewGroup) paramFinder.findRequiredView(paramObject, 2131493154, "field 'introMainText'"));
        paramIntroFragment.introBottomText = ((TextView) paramFinder.findRequiredView(paramObject, 2131493155, "field 'introBottomText'"));
    }

    public static void reset(IntroFragment paramIntroFragment) {
        paramIntroFragment.introSmile = null;
        paramIntroFragment.introMainText = null;
        paramIntroFragment.introBottomText = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/intro/IntroFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */