package mobi.ifunny.gallery.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.k;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.util.ArrayList;
import java.util.List;

import mobi.ifunny.d;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.k.h;
import mobi.ifunny.rest.content.Counters;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunny.Source;
import mobi.ifunny.rest.content.RepublishersFeed;
import mobi.ifunny.rest.content.SmilersFeed;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserFeed;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.r;
import mobi.ifunny.view.ImageViewEx;

public class IFunnyWorkInfoFragment
        extends p
        implements View.OnClickListener, uk.co.a.a.b.a.b {
    private static final String b = IFunnyWorkInfoFragment.class.getSimpleName();
    private static final RestHttpHandler<SmilersFeed, IFunnyWorkInfoFragment> m = new u();
    private static final RestHttpHandler<RepublishersFeed, IFunnyWorkInfoFragment> n = new v();
    private String c;
    @InjectView(2131493378)
    protected ImageView creatorAvatar;
    @InjectView(2131493377)
    protected ImageView creatorAvatarBackground;
    @InjectView(2131493376)
    protected View creatorAvatarHolder;
    @InjectView(2131493368)
    protected TextView creatorNick;
    private String d;
    @InjectView(2131493370)
    protected TextView dateTextView;
    private int e;
    private int f;
    private SmilersFeed g;
    private RepublishersFeed h;
    private h i;
    private ArrayList<ImageViewEx> j;
    private ArrayList<ImageViewEx> k;
    private Handler l;
    private Runnable o = new w(this);
    @InjectView(2131493369)
    protected TextView republisherNick;
    @InjectView(2131493375)
    protected LinearLayout republishersAvatars;
    @InjectView(2131493374)
    protected TextView republishesTextView;
    @InjectView(2131493373)
    protected LinearLayout smilersAvatars;
    @InjectView(2131493372)
    protected TextView smilesTextView;
    @InjectView(2131493366)
    protected TextView titleTextView;
    @InjectView(2131493371)
    protected TextView viewsTextView;

    public static IFunnyWorkInfoFragment a(Bundle paramBundle) {
        IFunnyWorkInfoFragment localIFunnyWorkInfoFragment = new IFunnyWorkInfoFragment();
        localIFunnyWorkInfoFragment.setArguments(paramBundle);
        return localIFunnyWorkInfoFragment;
    }

    private void a(Drawable paramDrawable) {
        int i1 = getResources().getInteger(17694720);
        mobi.ifunny.util.b.a(this.creatorAvatar, paramDrawable, i1);
        this.l.postDelayed(this.o, i1);
    }

    private void a(String paramString) {
        if (f("task.avatar")) {
            d.d(b, String.format("Interrupting avatar loading. New url: %s", new Object[]{paramString}));
            a(new String[]{"task.avatar"});
        }
        if (TextUtils.isEmpty(paramString)) {
            a(mobi.ifunny.util.f.a(getResources().getDrawable(2130837607)));
            return;
        }
        int i1 = getResources().getDimensionPixelSize(2131427468);
        new x(this, "task.avatar", mobi.ifunny.util.cache.f.b(new a(new Point(i1, i1), false))).execute(new String[]{paramString});
    }

    private void a(RepublishersFeed paramRepublishersFeed) {
        this.h = paramRepublishersFeed;
        a(paramRepublishersFeed, this.republishersAvatars, this.k, n().num.republished, 2131492877);
    }

    private void a(SmilersFeed paramSmilersFeed) {
        this.g = paramSmilersFeed;
        if (g()) {
            return;
        }
        a(paramSmilersFeed, this.smilersAvatars, this.j, n().num.smiles, 2131492878);
    }

    private void a(UserFeed paramUserFeed, ViewGroup paramViewGroup, ArrayList<ImageViewEx> paramArrayList, int paramInt1, int paramInt2) {
        if ((paramUserFeed == null) || (paramUserFeed.getList().size() == 0)) {
            h();
        }
        int i1;
        label68:
        label75:
        Object localObject;
        Resources localResources;
        label103:
        label214:
        label223:
        label230:
        do {
            return;
            paramViewGroup.setVisibility(0);
            paramViewGroup.removeAllViews();
            int i2 = paramUserFeed.getList().size();
            ImageViewEx localImageViewEx;
            User localUser;
            if (paramInt1 > this.f - 1) {
                i1 = 1;
                if (i1 == 0) {
                    break label214;
                }
                paramInt1 = this.f - 1;
                if (i2 <= paramInt1) {
                    break label223;
                }
                localObject = getActivity();
                localResources = getResources();
                localObject = LayoutInflater.from((Context) localObject);
                List localList = paramUserFeed.getList();
                i2 = 0;
                if (i2 >= paramInt1) {
                    continue;
                }
                localImageViewEx = (ImageViewEx) ((LayoutInflater) localObject).inflate(2130903188, paramViewGroup, false);
                paramArrayList.add(localImageViewEx);
                paramViewGroup.addView(localImageViewEx);
                localUser = (User) localList.get(i2);
                localImageViewEx.setTag(localUser);
                localImageViewEx.setOnClickListener(this);
                if (!localUser.is_banned) {
                    break label230;
                }
            }
            for (paramUserFeed = null; ; paramUserFeed = localUser.getPhotoThumbSmallUrl()) {
                paramUserFeed = new mobi.ifunny.comments.g(localImageViewEx, localImageViewEx, paramUserFeed, localUser);
                this.i.a(paramUserFeed);
                i2 += 1;
                break label103;
                i1 = 0;
                break;
                paramInt1 = this.f;
                break label68;
                paramInt1 = i2;
                break label75;
            }
        } while (i1 == 0);
        paramUserFeed = (ImageViewEx) ((LayoutInflater) localObject).inflate(2130903187, paramViewGroup, false);
        paramUserFeed.setId(paramInt2);
        paramUserFeed.setOnClickListener(this);
        paramUserFeed.setImageDrawable((com.makeramen.c) com.makeramen.c.a(localResources.getDrawable(2130837876)));
        paramViewGroup.addView(paramUserFeed);
    }

    private void b(IFunny paramIFunny) {
        paramIFunny = paramIFunny.getOriginalAuthor();
        if (paramIFunny == null) {
            i();
        }
        do {
            return;
            if (paramIFunny.is_banned) {
                j();
                return;
            }
        } while (this.creatorAvatar.getDrawable() != null);
        a(paramIFunny.getPhotoThumbLargeUrl());
    }

    private void d() {
        String str = null;
        Resources localResources = getResources();
        IFunny localIFunny = n();
        this.titleTextView.setText(localIFunny.title);
        float f1 = localResources.getDimension(2131427420);
        float f2 = localResources.getDimension(2131427422);
        float f3 = (f1 - f2) / 70.0F;
        float f4 = localIFunny.title.length();
        this.titleTextView.setTextSize(0, Math.max(f1, f2 + f3 * f4));
        Object localObject = r.a(localIFunny.getDateInMillis(), getActivity().getApplicationContext());
        this.dateTextView.setText((CharSequence) localObject);
        this.viewsTextView.setText(r.b(localResources, 2131623952, 2131690188, localIFunny.num.views));
        localObject = localIFunny.getOriginalAuthor();
        if (localObject == null) {
            this.creatorNick.setText(getString(2131689661));
            if (!localIFunny.hasSource()) {
                break label436;
            }
            this.republisherNick.setText(localIFunny.creator.nick);
            this.republisherNick.setVisibility(0);
            if (localIFunny.source.creator != null) {
                str = localIFunny.source.creator.id;
            }
            this.c = str;
            this.d = localIFunny.creator.id;
            if (!g()) {
                break label474;
            }
            str = localResources.getString(2131690184);
            localObject = localResources.getString(2131690185);
            localObject = new SpannableString(str + " " + (String) localObject);
            ((SpannableString) localObject).setSpan(new ForegroundColorSpan(localResources.getColor(2131361835)), 0, str.length(), 0);
            ((SpannableString) localObject).setSpan(new ForegroundColorSpan(localResources.getColor(2131361796)), str.length() + 1, ((SpannableString) localObject).length(), 0);
            this.smilesTextView.setText((CharSequence) localObject);
        }
        for (; ; ) {
            this.republishesTextView.setText(r.b(localResources, 2131623950, 2131690183, localIFunny.num.republished));
            if (localIFunny.num.republished == 0) {
                this.republishesTextView.setTextColor(localResources.getColor(2131361796));
            }
            h();
            return;
            this.creatorNick.setText(((User) localObject).nick);
            break;
            label436:
            if (localIFunny.creator != null) {
            }
            for (str = localIFunny.creator.id; ; str = null) {
                this.c = str;
                this.d = null;
                break;
            }
            label474:
            this.smilesTextView.setText(r.b(localResources, 2131623951, 2131690186, localIFunny.num.smiles));
            if (localIFunny.num.smiles == 0) {
                this.smilesTextView.setTextColor(localResources.getColor(2131361796));
            }
        }
    }

    private boolean g() {
        GalleryFragment localGalleryFragment = f();
        IFunny localIFunny = n();
        return (localGalleryFragment != null) && (localGalleryFragment.g()) && (!localIFunny.isRated());
    }

    private void h() {
        if ((g()) || (n().num.smiles == 0)) {
            this.smilersAvatars.setVisibility(8);
        }
        while (n().num.republished == 0) {
            this.republishersAvatars.setVisibility(8);
            return;
            if (this.g == null) {
                this.smilersAvatars.setVisibility(4);
            } else {
                this.smilersAvatars.setVisibility(0);
            }
        }
        if (this.h == null) {
            this.republishersAvatars.setVisibility(4);
            return;
        }
        this.republishersAvatars.setVisibility(0);
    }

    private void i() {
        com.makeramen.c localc = new com.makeramen.c(mobi.ifunny.util.f.a(getResources().getDrawable(2130837607)));
        localc.a(true);
        a(localc);
        this.creatorAvatar.setTag("silhouette");
    }

    private void j() {
        com.makeramen.c localc = new com.makeramen.c(mobi.ifunny.util.f.a(getResources().getDrawable(2130837611)));
        localc.a(true);
        a(localc);
        this.creatorAvatar.setTag("banned");
    }

    private void k() {
        if (g()) {
        }
        IFunny localIFunny;
        do {
            return;
            localIFunny = n();
        } while (f("task.smilers"));
        String str = localIFunny.getOriginalCid();
        if (localIFunny.num.smiles < this.e) {
        }
        for (int i1 = localIFunny.num.smiles; ; i1 = this.e) {
            IFunnyRestRequest.Content.getSmilers(this, "task.smilers", str, i1, null, null, m);
            return;
        }
    }

    private void l() {
        IFunny localIFunny = n();
        String str;
        if (!f("task.republishers")) {
            str = localIFunny.getOriginalCid();
            if (localIFunny.num.republished >= this.e) {
                break label57;
            }
        }
        label57:
        for (int i1 = localIFunny.num.republished; ; i1 = this.e) {
            IFunnyRestRequest.Content.getRepublishers(this, "task.republishers", str, i1, null, null, n);
            return;
        }
    }

    protected void a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            paramBitmap = new com.makeramen.c(paramBitmap);
            paramBitmap.a(true);
            a(paramBitmap);
        }
    }

    public void a(IFunny paramIFunny) {
        n().setCounters(paramIFunny.num);
        d();
        this.g = null;
        k();
        this.h = null;
        l();
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if (paramBoolean) {
            b(n());
            if (this.h == null) {
                l();
            }
            if (this.g == null) {
                k();
            }
            mobi.ifunny.b.g.b(getActivity(), "WorkInfo");
        }
        while (!f("rest.getContent")) {
            return;
        }
        c();
    }

    public void b() {
        f().a(this);
    }

    public void b(boolean paramBoolean) {
        this.g = null;
        this.h = null;
        this.i.a();
        if (!f("rest.getContent")) {
            d.c(b, "refresh " + this);
            IFunnyRestRequest.Content.getContent(this, "rest.getContent", n().id, new y(paramBoolean));
        }
        h();
    }

    public void c() {
        f().b(this);
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
            case 2131493368:
            case 2131493376:
            case 2131493369:
            case 2131492878:
            case 2131493372:
            case 2131492877:
            case 2131493374:
                do {
                    do {
                        return;
                        mobi.ifunny.util.v.a(getActivity(), this.c);
                        return;
                        mobi.ifunny.util.v.a(getActivity(), this.d);
                        return;
                        paramView = n();
                    } while ((g()) || (paramView.num.smiles == 0));
                    mobi.ifunny.util.v.a(getActivity(), paramView);
                    return;
                    paramView = n();
                } while (paramView.num.republished == 0);
                mobi.ifunny.util.v.b(getActivity(), paramView);
                return;
        }
        paramView = ((User) paramView.getTag()).id;
        mobi.ifunny.util.v.a(getActivity(), paramView);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new Handler();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903185, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.creatorAvatarHolder.setOnClickListener(this);
        this.creatorNick.setOnClickListener(this);
        this.republisherNick.setOnClickListener(this);
        this.smilesTextView.setOnClickListener(this);
        this.republishesTextView.setOnClickListener(this);
        this.creatorAvatarBackground.setImageLevel(r.b(1, 6));
        this.creatorAvatarBackground.setVisibility(0);
        paramViewGroup = getResources();
        paramBundle = getActivity().getWindowManager().getDefaultDisplay();
        Point localPoint = new Point();
        paramBundle.getSize(localPoint);
        int i2 = localPoint.x;
        int i4 = localPoint.y;
        int i3;
        if (paramViewGroup.getConfiguration().orientation == 2) {
            i1 = 1;
            i3 = Math.min(i2, i4);
            float f1 = paramViewGroup.getDimensionPixelSize(2131427514) * 2;
            float f2 = i3;
            int i5 = paramViewGroup.getDimensionPixelSize(2131427515);
            int i6 = paramViewGroup.getDimensionPixelSize(2131427510);
            i3 = Math.min(16, (int) Math.floor((f2 - f1 + i6) / (i5 + i6)));
            if (!paramViewGroup.getBoolean(2131296266)) {
                break label342;
            }
            i2 = Math.max(i2, i4) / 2;
            label230:
            i2 = Math.min(16, (int) Math.floor((i2 - f1 + i6) / (i5 + i6)));
            this.e = Math.max(i3, i2);
            if (i1 == 0) {
                break label354;
            }
        }
        label342:
        label354:
        for (int i1 = i2; ; i1 = i3) {
            this.f = i1;
            this.i = new h(new z(getActivity(), new mobi.ifunny.util.c(getActivity()), null), new mobi.ifunny.k.g(), 4, 10000);
            d();
            return paramLayoutInflater;
            i1 = 0;
            break;
            i2 = Math.max(i2, i4);
            break label230;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.l.removeCallbacks(this.o);
        this.i.b();
    }

    public void onRefreshStarted(View paramView) {
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("STATE_SMILERS", this.g);
        paramBundle.putParcelable("STATE_REPUBLISHERS", this.h);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            SmilersFeed localSmilersFeed = (SmilersFeed) paramBundle.getParcelable("STATE_SMILERS");
            paramBundle = (RepublishersFeed) paramBundle.getParcelable("STATE_REPUBLISHERS");
            a(localSmilersFeed);
            a(paramBundle);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/IFunnyWorkInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */