package mobi.ifunny.profile.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

import java.util.List;

import mobi.ifunny.fragment.FragmentPage;
import mobi.ifunny.profile.i;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserSocial;
import mobi.ifunny.rest.content.UserSocials;
import mobi.ifunny.rest.content.UserStat;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.util.ai;
import mobi.ifunny.util.v;

public class ProfileInfoFragment
        extends FragmentPage
        implements i {
    @InjectViews({2131493223, 2131493224, 2131493225})
    List<View> a;
    @InjectView(2131493220)
    TextView aboutText;
    private User b;
    @InjectView(2131493221)
    TextView featuredCount;
    @InjectView(2131493226)
    View shareProfile;
    @InjectView(2131493223)
    ImageView socialFacebook;
    @InjectView(2131493225)
    ImageView socialGPlus;
    @InjectView(2131493222)
    ViewGroup socialLayout;
    @InjectView(2131493224)
    ImageView socialTwitter;
    @InjectView(2131493218)
    TextView subscribersCount;
    @InjectView(2131493216)
    TextView subscriptionsCount;

    private void b() {
        this.socialLayout.removeAllViewsInLayout();
        int j = 0;
        int k = 0;
        if (j < this.a.size()) {
            View localView = (View) this.a.get(j);
            if (this.b.social != null) {
            }
            int i;
            switch (localView.getId()) {
                default:
                    i = 0;
                    label82:
                    if (i != 0) {
                        this.socialLayout.addView(localView, k);
                        k += 1;
                    }
                    break;
            }
            for (; ; ) {
                j += 1;
                break;
                if ((this.b.social.fb != null) && (!this.b.social.fb.is_hidden)) {
                    i = 1;
                    break label82;
                }
                i = 0;
                break label82;
                if ((this.b.social.tw != null) && (!this.b.social.tw.is_hidden)) {
                    i = 1;
                    break label82;
                }
                i = 0;
                break label82;
                if ((this.b.social.gplus != null) && (!this.b.social.gplus.is_hidden)) {
                    i = 1;
                    break label82;
                }
                i = 0;
                break label82;
                this.socialLayout.addView(localView);
            }
        }
    }

    private void c() {
        Resources localResources = getActivity().getResources();
        this.subscribersCount.setText(Integer.toString(this.b.num.subscribers));
        this.subscriptionsCount.setText(Integer.toString(this.b.num.subscriptions));
        if (this.b.num.featured > 0) {
            this.featuredCount.setVisibility(0);
            this.featuredCount.setText(Integer.toString(this.b.num.featured) + " " + localResources.getString(2131689833));
            if (!TextUtils.isEmpty(this.b.about)) {
                break label323;
            }
            this.aboutText.setVisibility(8);
            label138:
            if ((this.b.social != null) && (this.b.social.fb != null) && (!this.b.social.fb.is_hidden)) {
                break label348;
            }
            this.socialFacebook.setAlpha(0.2F);
            this.socialFacebook.setClickable(false);
            label194:
            if ((this.b.social != null) && (this.b.social.tw != null) && (!this.b.social.tw.is_hidden)) {
                break label367;
            }
            this.socialTwitter.setAlpha(0.2F);
            this.socialTwitter.setClickable(false);
            label250:
            if ((this.b.social != null) && (this.b.social.gplus != null) && (!this.b.social.gplus.is_hidden)) {
                break label386;
            }
            this.socialGPlus.setAlpha(0.2F);
            this.socialGPlus.setClickable(false);
        }
        for (; ; ) {
            b();
            return;
            this.featuredCount.setVisibility(8);
            break;
            label323:
            this.aboutText.setVisibility(0);
            this.aboutText.setText(this.b.about);
            break label138;
            label348:
            this.socialFacebook.setAlpha(1.0F);
            this.socialFacebook.setClickable(true);
            break label194;
            label367:
            this.socialTwitter.setAlpha(1.0F);
            this.socialTwitter.setClickable(true);
            break label250;
            label386:
            this.socialGPlus.setAlpha(1.0F);
            this.socialGPlus.setClickable(true);
        }
    }

    public void a(User paramUser) {
        this.b = paramUser;
    }

    public void a(User paramUser, boolean paramBoolean) {
        this.b = paramUser;
        c();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903142, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({2131493223})
    public void onFacebookClicked() {
        if ((this.b.social != null) && (this.b.social.fb != null)) {
            startActivity(ai.a(getActivity(), this.b.social.fb.id));
        }
    }

    @OnClick({2131493225})
    public void onGplusClicked() {
        if ((this.b.social != null) && (this.b.social.gplus != null)) {
            startActivity(ai.a(this.b.social.gplus.id));
        }
    }

    @OnClick({2131493226})
    public void onShareProfileClicked() {
        Resources localResources = getResources();
        boolean bool = TextUtils.equals(this.b.id, l.a().d());
        String str = localResources.getString(2131690164) + this.b.nick;
        if (bool) {
            ai.a(getActivity(), localResources.getString(2131689839, new Object[]{str}));
        }
        for (; ; ) {
            IFunnyRestRequest.Users.shareProfile(this, "TASK_SHARE_PROFILE", this.b.id, "unknown", null);
            return;
            ai.a(getActivity(), localResources.getString(2131689836, new Object[]{this.b.nick, str}));
        }
    }

    @OnClick({2131493217})
    public void onSubscribersClicked() {
        v.a(getActivity(), this.b.id, this.b.num.subscribers);
    }

    @OnClick({2131493215})
    public void onSubscriptionsClicked() {
        v.b(getActivity(), this.b.id, this.b.num.subscriptions);
    }

    @OnClick({2131493224})
    public void onTwitterClicked() {
        if ((this.b.social != null) && (this.b.social.tw != null)) {
            startActivity(ai.b(getActivity(), this.b.social.tw.id));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/fragments/ProfileInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */