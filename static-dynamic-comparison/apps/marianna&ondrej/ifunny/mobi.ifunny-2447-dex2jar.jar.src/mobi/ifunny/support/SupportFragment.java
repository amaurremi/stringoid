package mobi.ifunny.support;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ax;
import android.support.v4.view.cg;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;

import java.util.Arrays;
import java.util.List;

import mobi.ifunny.main.i;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.App;
import mobi.ifunny.social.share.ShareActivity;
import mobi.ifunny.social.share.SharingContent;
import mobi.ifunny.util.ai;
import mobi.ifunny.util.r;

public class SupportFragment
        extends i {
    public static final String a = SupportFragment.class.getSimpleName();
    private Animation.AnimationListener b = new n(this);
    private cg c = new o(this);
    @InjectView(2131493326)
    @Optional
    protected LinearLayout carouselDots;
    @InjectView(2131493327)
    protected TextView copyrightText;
    @InjectView(2131493312)
    protected ViewFlipper flipper;
    @InjectView(2131493324)
    protected View sharePage1;
    @InjectView(2131493325)
    protected View sharePage2;
    @InjectView(2131493323)
    @Optional
    protected ViewPager viewPager;
    @InjectView(2131493334)
    protected WebView webView;
    @InjectView(2131493335)
    protected View webViewLoader;

    private void a(String paramString1, String paramString2) {
        a(paramString1, paramString2, true);
    }

    private void a(String paramString1, String paramString2, boolean paramBoolean) {
        c();
        this.webView.loadUrl(paramString1);
        a().a(paramString2);
        if (paramBoolean) {
            this.flipper.setInAnimation(a.a());
            this.flipper.setOutAnimation(a.b());
        }
        this.flipper.showNext();
    }

    private void a(List<View> paramList) {
        this.viewPager.setAdapter(new p(this, paramList));
        e();
    }

    private void e() {
        this.carouselDots.removeAllViews();
        int k = this.viewPager.getAdapter().getCount();
        if (k > 1) {
            int m = this.viewPager.getCurrentItem();
            int i = 0;
            if (i <= k - 1) {
                ImageView localImageView = new ImageView(getActivity());
                label63:
                LinearLayout.LayoutParams localLayoutParams;
                if (i == m) {
                    j = 2130837622;
                    localImageView.setImageResource(j);
                    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i <= 0) {
                        break label131;
                    }
                }
                label131:
                for (int j = getResources().getDimensionPixelOffset(2131427359); ; j = 0) {
                    localLayoutParams.leftMargin = j;
                    localImageView.setLayoutParams(localLayoutParams);
                    this.carouselDots.addView(localImageView);
                    i += 1;
                    break;
                    j = 2130837623;
                    break label63;
                }
            }
        }
    }

    public void b() {
        Animation localAnimation = a.d();
        localAnimation.setAnimationListener(this.b);
        this.flipper.setInAnimation(a.c());
        this.flipper.setOutAnimation(localAnimation);
        this.flipper.showPrevious();
    }

    protected void c() {
        this.webView.setVisibility(4);
        this.webViewLoader.setVisibility(0);
    }

    protected void d() {
        this.webViewLoader.setVisibility(8);
        this.webView.setVisibility(0);
    }

    public boolean i() {
        return false;
    }

    @OnClick({2131493320})
    public void onClickComments() {
        a("http://m.ifunny.mobi/docs/guidelines-for-comments/?android", getResources().getString(2131690151));
    }

    @OnClick({2131493318})
    public void onClickFAQ() {
        a("http://m.ifunny.mobi/docs/faq/?android", getResources().getString(2131690149));
    }

    @OnClick({2131493322})
    public void onClickFeedback() {
        r.a(getActivity());
    }

    @OnClick({2131493328})
    public void onClickShareFacebook() {
        Resources localResources = getResources();
        Intent localIntent = new Intent(getActivity(), ShareActivity.class);
        localIntent.putExtra("INTENT_SHARE_TYPE", 1);
        localIntent.putExtra("INTENT_SHARE_CONTENT", new SharingContent(localResources.getString(2131690164), null, "http://img.ifcdn.com/assets/logos/iFunny4_Icon_Android.png", null));
        IFunnyRestRequest.App.post(this, "post.shares", null, "fb");
        startActivity(localIntent);
    }

    @OnClick({2131493330})
    public void onClickShareGPlus() {
        Resources localResources = getResources();
        ai.a(getActivity(), null, String.format("%s %s", new Object[]{localResources.getString(2131690162), localResources.getString(2131690164)}), localResources.getString(2131690162), localResources.getString(2131690164));
        IFunnyRestRequest.App.post(this, "post.shares", null, "gplus");
    }

    @OnClick({2131493329})
    public void onClickShareTwitter() {
        Resources localResources = getResources();
        ai.a(getActivity(), null, String.format("%s %s", new Object[]{localResources.getString(2131690162), localResources.getString(2131690164)}));
        IFunnyRestRequest.App.post(this, "post.shares", null, "tw");
    }

    @OnClick({2131493332})
    public void onClickShareWithEmail() {
        Resources localResources = getResources();
        Intent localIntent = com.b.a.a.a.a.a("", localResources.getString(2131690162), String.format("%s %s", new Object[]{localResources.getString(2131690162), localResources.getString(2131690164)}));
        if (localIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(localIntent);
            return;
        }
        Toast.makeText(getActivity(), localResources.getString(2131689637), 0).show();
    }

    @OnClick({2131493331})
    public void onClickShareWithMessage() {
        Resources localResources = getResources();
        Intent localIntent = com.b.a.a.a.a.b("", String.format("%s %s", new Object[]{localResources.getString(2131690162), localResources.getString(2131690164)}));
        if (localIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(localIntent);
            return;
        }
        Toast.makeText(getActivity(), localResources.getString(2131689638), 0).show();
    }

    @OnClick({2131493333})
    public void onClickShareWithWhatsapp() {
        Resources localResources = getResources();
        try {
            getActivity().getPackageManager().getPackageInfo("com.whatsapp", 128);
            Intent localIntent = new Intent("android.intent.action.SEND");
            localIntent.setType("text/plain");
            localIntent.putExtra("android.intent.extra.TEXT", String.format("%s %s", new Object[]{localResources.getString(2131690162), localResources.getString(2131690164)}));
            localIntent.setPackage("com.whatsapp");
            startActivity(localIntent);
            return;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            Toast.makeText(getActivity(), localResources.getString(2131689639), 0).show();
        }
    }

    @OnClick({2131493321})
    public void onClickTerms() {
        a("http://m.ifunny.mobi/docs/TOS/", getResources().getString(2131690153));
    }

    @OnClick({2131493319})
    public void onClickUploads() {
        a("http://m.ifunny.mobi/terms.html?android", getResources().getString(2131690152));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903166, paramViewGroup, false);
        paramViewGroup = getResources();
        ButterKnife.inject(this, paramLayoutInflater);
        this.copyrightText.setText(paramViewGroup.getString(2131690156, new Object[]{"4.0", Integer.valueOf(2447)}) + "\nwww.ifunny.co");
        this.copyrightText.setLineSpacing(0.0F, 1.2F);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setBackgroundColor(-16777216);
        paramViewGroup = getActivity();
        this.webView.setWebViewClient(new m(this, paramViewGroup));
        if (this.viewPager != null) {
            a(Arrays.asList(new View[]{this.sharePage1, this.sharePage2}));
            if (this.carouselDots != null) {
                this.viewPager.setOnPageChangeListener(this.c);
            }
        }
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.webView.setWebViewClient(null);
        ButterKnife.reset(this);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        b();
        return true;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        if (this.flipper.getDisplayedChild() == 0) {
        }
        for (String str = null; ; str = this.webView.getUrl()) {
            paramBundle.putString("state.opened.page", str);
            paramBundle.putString("state.title", (String) a().c());
            return;
        }
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            String str = paramBundle.getString("state.opened.page");
            paramBundle = paramBundle.getString("state.title");
            if (str != null) {
                a(str, paramBundle, false);
            }
        }
    }

    public boolean q() {
        if (this.flipper.getDisplayedChild() > 0) {
            b();
            a().a(getString(2131690167));
            return true;
        }
        return super.q();
    }

    public boolean y() {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/support/SupportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */