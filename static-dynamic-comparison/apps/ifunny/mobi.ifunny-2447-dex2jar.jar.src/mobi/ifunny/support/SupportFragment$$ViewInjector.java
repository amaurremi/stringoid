package mobi.ifunny.support;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.ButterKnife.Finder;

public class SupportFragment$$ViewInjector {
    public static void inject(ButterKnife.Finder paramFinder, SupportFragment paramSupportFragment, Object paramObject) {
        paramSupportFragment.flipper = ((ViewFlipper) paramFinder.findRequiredView(paramObject, 2131493312, "field 'flipper'"));
        paramSupportFragment.webView = ((WebView) paramFinder.findRequiredView(paramObject, 2131493334, "field 'webView'"));
        paramSupportFragment.webViewLoader = paramFinder.findRequiredView(paramObject, 2131493335, "field 'webViewLoader'");
        paramSupportFragment.copyrightText = ((TextView) paramFinder.findRequiredView(paramObject, 2131493327, "field 'copyrightText'"));
        paramSupportFragment.viewPager = ((ViewPager) paramFinder.findOptionalView(paramObject, 2131493323));
        paramSupportFragment.carouselDots = ((LinearLayout) paramFinder.findOptionalView(paramObject, 2131493326));
        paramSupportFragment.sharePage1 = paramFinder.findRequiredView(paramObject, 2131493324, "field 'sharePage1'");
        paramSupportFragment.sharePage2 = paramFinder.findRequiredView(paramObject, 2131493325, "field 'sharePage2'");
        paramFinder.findRequiredView(paramObject, 2131493318, "method 'onClickFAQ'").setOnClickListener(new b(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493319, "method 'onClickUploads'").setOnClickListener(new e(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493320, "method 'onClickComments'").setOnClickListener(new f(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493321, "method 'onClickTerms'").setOnClickListener(new g(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493322, "method 'onClickFeedback'").setOnClickListener(new h(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493328, "method 'onClickShareFacebook'").setOnClickListener(new i(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493329, "method 'onClickShareTwitter'").setOnClickListener(new j(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493330, "method 'onClickShareGPlus'").setOnClickListener(new k(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493331, "method 'onClickShareWithMessage'").setOnClickListener(new l(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493332, "method 'onClickShareWithEmail'").setOnClickListener(new c(paramSupportFragment));
        paramFinder.findRequiredView(paramObject, 2131493333, "method 'onClickShareWithWhatsapp'").setOnClickListener(new d(paramSupportFragment));
    }

    public static void reset(SupportFragment paramSupportFragment) {
        paramSupportFragment.flipper = null;
        paramSupportFragment.webView = null;
        paramSupportFragment.webViewLoader = null;
        paramSupportFragment.copyrightText = null;
        paramSupportFragment.viewPager = null;
        paramSupportFragment.carouselDots = null;
        paramSupportFragment.sharePage1 = null;
        paramSupportFragment.sharePage2 = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/support/SupportFragment$$ViewInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */