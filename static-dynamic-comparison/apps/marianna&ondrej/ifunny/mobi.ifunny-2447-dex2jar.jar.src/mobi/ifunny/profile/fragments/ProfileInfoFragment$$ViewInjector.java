package mobi.ifunny.profile.fragments;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class ProfileInfoFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, ProfileInfoFragment paramProfileInfoFragment, Object paramObject) {
        paramProfileInfoFragment.subscriptionsCount = ((TextView) paramFinder.findRequiredView(paramObject, 2131493216, "field 'subscriptionsCount'"));
        paramProfileInfoFragment.subscribersCount = ((TextView) paramFinder.findRequiredView(paramObject, 2131493218, "field 'subscribersCount'"));
        paramProfileInfoFragment.featuredCount = ((TextView) paramFinder.findRequiredView(paramObject, 2131493221, "field 'featuredCount'"));
        paramProfileInfoFragment.aboutText = ((TextView) paramFinder.findRequiredView(paramObject, 2131493220, "field 'aboutText'"));
        View localView = paramFinder.findRequiredView(paramObject, 2131493223, "field 'socialFacebook' and method 'onFacebookClicked'");
        paramProfileInfoFragment.socialFacebook = ((ImageView) localView);
        localView.setOnClickListener(new d(paramProfileInfoFragment));
        localView = paramFinder.findRequiredView(paramObject, 2131493224, "field 'socialTwitter' and method 'onTwitterClicked'");
        paramProfileInfoFragment.socialTwitter = ((ImageView) localView);
        localView.setOnClickListener(new e(paramProfileInfoFragment));
        localView = paramFinder.findRequiredView(paramObject, 2131493225, "field 'socialGPlus' and method 'onGplusClicked'");
        paramProfileInfoFragment.socialGPlus = ((ImageView) localView);
        localView.setOnClickListener(new f(paramProfileInfoFragment));
        localView = paramFinder.findRequiredView(paramObject, 2131493226, "field 'shareProfile' and method 'onShareProfileClicked'");
        paramProfileInfoFragment.shareProfile = localView;
        localView.setOnClickListener(new g(paramProfileInfoFragment));
        paramProfileInfoFragment.socialLayout = ((ViewGroup) paramFinder.findRequiredView(paramObject, 2131493222, "field 'socialLayout'"));
        paramFinder.findRequiredView(paramObject, 2131493217, "method 'onSubscribersClicked'").setOnClickListener(new h(paramProfileInfoFragment));
        paramFinder.findRequiredView(paramObject, 2131493215, "method 'onSubscriptionsClicked'").setOnClickListener(new i(paramProfileInfoFragment));
        paramProfileInfoFragment.a = ButterKnife.Finder.listOf(new View[]{paramFinder.findRequiredView(paramObject, 2131493223, "socialViews"), paramFinder.findRequiredView(paramObject, 2131493224, "socialViews"), paramFinder.findRequiredView(paramObject, 2131493225, "socialViews")});
    }

    public static void reset(ProfileInfoFragment paramProfileInfoFragment) {
        paramProfileInfoFragment.subscriptionsCount = null;
        paramProfileInfoFragment.subscribersCount = null;
        paramProfileInfoFragment.featuredCount = null;
        paramProfileInfoFragment.aboutText = null;
        paramProfileInfoFragment.socialFacebook = null;
        paramProfileInfoFragment.socialTwitter = null;
        paramProfileInfoFragment.socialGPlus = null;
        paramProfileInfoFragment.shareProfile = null;
        paramProfileInfoFragment.socialLayout = null;
        paramProfileInfoFragment.a = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/fragments/ProfileInfoFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */