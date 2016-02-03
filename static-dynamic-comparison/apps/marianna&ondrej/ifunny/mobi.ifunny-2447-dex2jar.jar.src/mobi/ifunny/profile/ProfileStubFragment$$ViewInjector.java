package mobi.ifunny.profile;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ProfileStubFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, ProfileStubFragment paramProfileStubFragment, Object paramObject) {
        paramProfileStubFragment.mainPart = paramFinder.findRequiredView(paramObject, 2131493250, "field 'mainPart'");
        paramFinder.findRequiredView(paramObject, 2131493251, "method 'onAuthClick'").setOnClickListener(new h(paramProfileStubFragment));
    }

    public static void reset(ProfileStubFragment paramProfileStubFragment) {
        paramProfileStubFragment.mainPart = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/ProfileStubFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */