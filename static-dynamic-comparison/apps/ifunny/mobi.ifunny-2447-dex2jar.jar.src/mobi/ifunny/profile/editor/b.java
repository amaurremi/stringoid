package mobi.ifunny.profile.editor;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import mobi.ifunny.profile.settings.ProfileSettingsActivity;
import mobi.ifunny.rest.content.MemeSource;
import mobi.ifunny.rest.content.NickAvailability;
import mobi.ifunny.rest.content.UploadedCover;
import mobi.ifunny.rest.content.UploadedPhoto;
import mobi.ifunny.rest.content.User;
import mobi.ifunny.rest.content.UserSocial;
import mobi.ifunny.rest.content.UserSocials;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Account;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Users;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.studio.crop.fixed.FixedCropImageActivity;
import mobi.ifunny.util.al;
import mobi.ifunny.util.am;
import mobi.ifunny.util.an;
import mobi.ifunny.view.SettingsItemLayout;
import retrofit.mime.TypedFile;
import uk.co.chrisjenx.paralloid.views.ParallaxScrollView;

public class b
        extends mobi.ifunny.l.e
        implements View.OnClickListener, mobi.ifunny.fragment.k {
    private static final RestHttpHandler<UploadedPhoto, b> G = new k();
    protected static final RestHttpHandler<NickAvailability, b> h;
    protected static final RestHttpHandler<Void, b> i;
    protected static final RestHttpHandler<User, b> j = new l();
    private static final String k = a.class.getSimpleName();
    private static int m;
    private static int n;
    private static int o;
    private static int p;
    private String A;
    private final ViewTreeObserver.OnGlobalLayoutListener B = new c(this);
    private TextWatcher C = new e(this);
    private View.OnFocusChangeListener D = new f(this);
    private TextWatcher E = new h(this);
    private View.OnFocusChangeListener F = new i(this);
    protected User a;
    protected User b;
    protected SettingsItemLayout c;
    protected SettingsItemLayout d;
    protected SettingsItemLayout e;
    protected View f;
    protected View g;
    private p l;
    private boolean q;
    private View r;
    private ImageView s;
    private ImageView t;
    private SettingsItemLayout u;
    private SettingsItemLayout v;
    private EditText w;
    private EditText x;
    private TextView y;
    private ImageView z;

    static {
        h = new g();
        i = new j();
    }

    private boolean D() {
        return (this.a.social != null) && (this.a.social.gplus != null) && (this.a.social.gplus.is_hidden != this.b.social.gplus.is_hidden);
    }

    private boolean E() {
        if (this.a.nick == null) {
            if (this.b.nick == null) {
            }
        }
        while (!this.a.nick.equals(this.b.nick)) {
            return true;
            return false;
        }
        return false;
    }

    private boolean F() {
        if ((this.a.about != null) && (this.b.about == null)) {
            this.b.about = "";
        }
        if (this.a.about == null) {
            if (this.b.about == null) {
            }
        }
        while (!this.a.about.equals(this.b.about)) {
            return true;
            return false;
        }
        return false;
    }

    private void G() {
        Intent localIntent = new Intent();
        localIntent.putExtra("result.profile", this.a);
        getActivity().setResult(-1, localIntent);
    }

    private void H() {
        if (f("task.profile")) {
            mobi.ifunny.d.d(k, "Do not request profile - already running");
            return;
        }
        IFunnyRestRequest.Account.get(this, "task.profile", j);
    }

    private void I() {
        Object localObject = new ArrayList();
        ((ArrayList) localObject).add(Integer.valueOf(0));
        ((ArrayList) localObject).add(Integer.valueOf(5));
        if (this.b.cover_url != null) {
            ((ArrayList) localObject).add(Integer.valueOf(8));
        }
        localObject = mobi.ifunny.fragment.i.a((ArrayList) localObject, 0, 2131689807);
        ((mobi.ifunny.fragment.i) localObject).setTargetFragment(this, 0);
        ((mobi.ifunny.fragment.i) localObject).a(getFragmentManager(), "dialog.pick_cover");
    }

    private void J() {
        Object localObject = new ArrayList();
        ((ArrayList) localObject).add(Integer.valueOf(0));
        ((ArrayList) localObject).add(Integer.valueOf(1));
        ((ArrayList) localObject).add(Integer.valueOf(2));
        if (!mobi.ifunny.util.r.b()) {
            ((ArrayList) localObject).add(Integer.valueOf(3));
        }
        if (this.b.getPhotoThumbLargeUrl() != null) {
            ((ArrayList) localObject).add(Integer.valueOf(7));
        }
        localObject = mobi.ifunny.fragment.i.a((ArrayList) localObject, 1, 2131689825);
        ((mobi.ifunny.fragment.i) localObject).setTargetFragment(this, 0);
        ((mobi.ifunny.fragment.i) localObject).a(getFragmentManager(), "dialog.pick_avatar");
    }

    private void K() {
        this.b.setPhotoThumbLargeUrl(null);
        a(null, 0);
    }

    private void L() {
        boolean bool2 = true;
        this.u.setLeftText(this.b.nick);
        this.v.setLeftText(this.b.about);
        if ((this.b.social == null) || (this.b.social.fb == null)) {
            this.c.getSwitcherView().setVisibility(4);
            if ((this.b.social == null) || (this.b.social.gplus == null)) {
                this.d.getSwitcherView().setVisibility(4);
                if ((this.b.social != null) && (this.b.social.tw != null)) {
                    break label227;
                }
                this.e.getSwitcherView().setVisibility(4);
            }
        } else {
            this.c.getSwitcherView().setVisibility(0);
            localSettingsItemLayout = this.c;
            if (!this.b.social.fb.is_hidden) {
            }
            for (bool1 = true; ; bool1 = false) {
                localSettingsItemLayout.setSwitcherState(bool1);
                break;
            }
        }
        this.d.getSwitcherView().setVisibility(0);
        SettingsItemLayout localSettingsItemLayout = this.d;
        if (!this.b.social.gplus.is_hidden) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            localSettingsItemLayout.setSwitcherState(bool1);
            break;
        }
        label227:
        this.e.getSwitcherView().setVisibility(0);
        localSettingsItemLayout = this.e;
        if (!this.b.social.tw.is_hidden) {
        }
        for (bool1 = bool2; ; bool1 = false) {
            localSettingsItemLayout.setSwitcherState(bool1);
            return;
        }
    }

    public static a a(User paramUser) {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.profile", paramUser);
        paramUser = new a();
        paramUser.setArguments(localBundle);
        return paramUser;
    }

    private void a(int paramInt1, int paramInt2) {
        this.w.setTextColor(paramInt1);
        Drawable localDrawable = this.w.getCompoundDrawables()[2];
        localDrawable.setLevel(paramInt2);
        this.w.invalidateDrawable(localDrawable);
    }

    private void a(Uri paramUri, int paramInt) {
        String str;
        if (f("avatar.load")) {
            str = k;
            if (paramUri != null) {
                break label89;
            }
        }
        label89:
        for (Object localObject = "null"; ; localObject = paramUri.toString()) {
            mobi.ifunny.d.d(str, String.format("Interrupting avatar loading. New url: %s", new Object[]{localObject}));
            a(new String[]{"avatar.load"});
            if (paramUri != null) {
                break;
            }
            paramUri = (com.makeramen.c) com.makeramen.c.a(getResources().getDrawable(2130837607));
            paramUri.a(true);
            a(paramUri);
            return;
        }
        if (paramInt == 0) {
            localObject = getResources().getDrawable(2130837608);
            ((Drawable) localObject).setLevel(mobi.ifunny.util.r.b(1, 6));
            this.t.setBackgroundDrawable((Drawable) localObject);
        }
        for (; ; ) {
            mobi.ifunny.e.d.a(this, "avatar.load", paramUri, new mobi.ifunny.util.a.a(new Point(this.t.getWidth(), this.t.getWidth()), false), new m(null));
            return;
            localObject = new ShapeDrawable(new OvalShape());
            ((ShapeDrawable) localObject).getPaint().setColor(paramInt);
            this.t.setBackgroundDrawable((Drawable) localObject);
        }
    }

    private void a(p paramp) {
        this.l = paramp;
        switch (d.a[paramp.ordinal()]) {
            default:
                return;
            case 1:
            case 2:
                a(m, 1);
                return;
            case 3:
                if (this.q) {
                }
                for (i1 = o; ; i1 = n) {
                    a(i1, 0);
                    return;
                }
        }
        if (this.q) {
        }
        for (int i1 = o; ; i1 = n) {
            a(i1, 1);
            return;
        }
    }

    private void a(mobi.ifunny.util.cache.m<mobi.ifunny.util.a.d> paramm) {
        this.b.cover_url = Uri.fromFile(paramm.b).toString();
        a((mobi.ifunny.util.a.d) paramm.a);
    }

    private void c(User paramUser) {
        Object localObject2 = null;
        Object localObject1;
        if (TextUtils.isEmpty(paramUser.cover_url)) {
            localObject1 = null;
            a((Uri) localObject1, false);
            if (!TextUtils.isEmpty(paramUser.getPhotoThumbLargeUrl())) {
                break label81;
            }
            localObject1 = localObject2;
            label34:
            a((Uri) localObject1, mobi.ifunny.util.r.c(paramUser.getPhotoBgColor()));
            localObject1 = this.z;
            if (!paramUser.is_verified) {
                break label92;
            }
        }
        label81:
        label92:
        for (int i1 = 0; ; i1 = 8) {
            ((ImageView) localObject1).setVisibility(i1);
            L();
            return;
            localObject1 = Uri.parse(paramUser.cover_url);
            break;
            localObject1 = Uri.parse(paramUser.getPhotoThumbLargeUrl());
            break label34;
        }
    }

    private void j() {
        android.support.v4.app.q localq = getChildFragmentManager();
        q localq1 = (q) localq.a("NO_SOCIAL_TAG");
        if (localq1 != null) {
            localq1.b();
            localq.b();
        }
        k().a(localq, "NO_SOCIAL_TAG");
    }

    private q k() {
        Resources localResources = getResources();
        q localq = new q();
        localq.a(localResources.getString(2131689811), localResources.getString(2131689830), localResources.getString(2131689875), localResources.getString(2131689669));
        return localq;
    }

    private void l() {
        Intent localIntent = new Intent(getActivity(), ProfileSettingsActivity.class);
        localIntent.putExtra("intent.profile", this.a);
        startActivityForResult(localIntent, 2);
    }

    private void m() {
        android.support.v4.app.q localq = getChildFragmentManager();
        q localq1 = (q) localq.a("NO_SOCIAL_TAG");
        if (localq1 != null) {
            localq1.b();
            localq.b();
        }
        k().a(localq, "NO_SOCIAL_TAG");
    }

    private void n() {
        android.support.v4.app.q localq = getChildFragmentManager();
        q localq1 = (q) localq.a("NO_SOCIAL_TAG");
        if (localq1 != null) {
            localq1.b();
            localq.b();
        }
        k().a(localq, "NO_SOCIAL_TAG");
    }

    private void o() {
        a(p.d);
        if (f("check.nick.availability")) {
            a(new String[]{"check.nick.availability"});
        }
        String str = this.w.getText().toString().trim();
        this.y.setText(str);
        if (TextUtils.isEmpty(str)) {
            a(p.b);
        }
        do {
            return;
            this.b.nick = str;
            if (TextUtils.equals(this.a.nick, str)) {
                a(p.e);
                return;
            }
        } while (isDetached());
        IFunnyRestRequest.Users.checkNick(this, "check.nick.availability", str, h);
    }

    private void p() {
        a(p.a);
    }

    private void q() {
        a(p.c);
    }

    private void r() {
        String str = null;
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getView().getWindowToken(), 0);
        if (this.l == p.d) {
            Toast.makeText(getActivity(), getResources().getString(2131689812), 0).show();
            return;
        }
        if (this.l == p.a) {
            Toast.makeText(getActivity(), getResources().getString(2131689814), 0).show();
            return;
        }
        if (this.l == p.b) {
            Toast.makeText(getActivity(), getResources().getString(2131689813), 0).show();
            return;
        }
        if (s()) {
            c();
        }
        Object localObject;
        if ((E()) || (F())) {
            RestHttpHandler localRestHttpHandler = i;
            if (E()) {
            }
            for (localObject = this.b.nick; ; localObject = null) {
                if (F()) {
                    str = this.b.about;
                }
                IFunnyRestRequest.Account.put(this, "account.put", localRestHttpHandler, (String) localObject, str);
                this.a.about = this.b.about;
                this.a.nick = this.b.nick;
                return;
            }
        }
        if (w()) {
            this.a.social.fb.is_hidden = this.b.social.fb.is_hidden;
            IFunnyRestRequest.Account.socialsPut(this, "facebook.visibility", i, "fb", null, null, null, this.b.social.fb.is_hidden);
            return;
        }
        if (D()) {
            this.a.social.gplus.is_hidden = this.b.social.gplus.is_hidden;
            IFunnyRestRequest.Account.socialsPut(this, "gplus.visibility", i, "gplus", null, null, null, this.b.social.gplus.is_hidden);
            return;
        }
        if (v()) {
            this.a.social.tw.is_hidden = this.b.social.tw.is_hidden;
            IFunnyRestRequest.Account.socialsPut(this, "twitter.visibility", i, "tw", null, null, null, this.b.social.tw.is_hidden);
            return;
        }
        if (u()) {
            if ((this.a.cover_url != null) && (this.b.cover_url == null)) {
                IFunnyRestRequest.Account.coverDelete(this, "cover.rest", i);
                this.a.cover_url = null;
                return;
            }
            localObject = new File(Uri.parse(this.b.cover_url).getPath());
            IFunnyRestRequest.Account.coverPut(this, "cover.rest", new TypedFile(this.A, (File) localObject), new r((File) localObject, null));
            return;
        }
        if (t()) {
            if ((this.a.getPhotoThumbLargeUrl() != null) && (this.b.getPhotoThumbLargeUrl() == null)) {
                IFunnyRestRequest.Account.photoDelete(this, "cover.rest", i);
                this.a.setPhotoThumbLargeUrl(null);
                this.a.setPhotoUrl(null);
                return;
            }
            localObject = Uri.parse(this.b.getPhotoThumbLargeUrl());
            IFunnyRestRequest.Account.photoPut(this, "avatar.rest", new TypedFile(an.a((Uri) localObject), new File(((Uri) localObject).getPath())), G);
            return;
        }
        G();
        d();
        getActivity().finish();
    }

    private boolean s() {
        return (E()) || (F()) || (w()) || (v()) || (u()) || (t());
    }

    private boolean t() {
        return !TextUtils.equals(this.a.getPhotoThumbLargeUrl(), this.b.getPhotoThumbLargeUrl());
    }

    private boolean u() {
        if (this.a.cover_url == null) {
            if (this.b.cover_url == null) {
            }
        }
        while (!this.a.cover_url.equals(this.b.cover_url)) {
            return true;
            return false;
        }
        return false;
    }

    private boolean v() {
        return (this.a.social != null) && (this.a.social.tw != null) && (this.a.social.tw.is_hidden != this.b.social.tw.is_hidden);
    }

    private boolean w() {
        return (this.a.social != null) && (this.a.social.fb != null) && (this.a.social.fb.is_hidden != this.b.social.fb.is_hidden);
    }

    public void a(int paramInt) {
        switch (paramInt) {
            default:
                return;
            case 0:
                e();
                return;
        }
        K();
    }

    public void a(int paramInt1, int paramInt2, Uri paramUri) {
        switch (paramInt1) {
            default:
                return;
            case 0:
                if (paramInt2 == 5) {
                    b(paramUri);
                    return;
                }
                a(paramUri);
                return;
        }
        c(paramUri);
    }

    public void a(int paramInt, MemeSource paramMemeSource) {
    }

    protected void a(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            paramBitmap = new com.makeramen.c(paramBitmap);
            paramBitmap.a(true);
            a(paramBitmap);
        }
    }

    protected void a(Drawable paramDrawable) {
        this.t.setBackgroundDrawable(null);
        mobi.ifunny.util.b.a(this.t, paramDrawable);
    }

    public void a(Uri paramUri) {
        Intent localIntent = new Intent(getActivity(), FixedCropImageActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("intent.crop_shape", 0);
        localIntent.putExtra("intent.crop_max_w", 800);
        localIntent.putExtra("intent.crop_max_h", 400);
        localIntent.putExtra("intent.crop_filename", "cover_crop_fixed.jpg");
        startActivityForResult(localIntent, 0);
    }

    protected void a(Uri paramUri, boolean paramBoolean) {
        String str2;
        if (f("cover.load")) {
            str2 = k;
            if (paramUri != null) {
                break label67;
            }
        }
        label67:
        for (String str1 = null; ; str1 = paramUri.toString()) {
            mobi.ifunny.d.d(str2, String.format("Interrupting cover loading. New url: %s", new Object[]{str1}));
            a(new String[]{"cover.load"});
            if (paramUri != null) {
                break;
            }
            this.s.setImageDrawable(null);
            return;
        }
        mobi.ifunny.e.d.b(this, "cover.load", paramUri, new mobi.ifunny.util.a.a(new Point(this.s.getWidth(), this.s.getWidth()), false), new o(paramBoolean, null));
    }

    protected void a(UploadedCover paramUploadedCover) {
        this.a.cover_url = paramUploadedCover.url;
        this.b.cover_url = paramUploadedCover.url;
        r();
    }

    protected void a(UploadedPhoto paramUploadedPhoto) {
        this.a.setPhoto(paramUploadedPhoto.photo);
        this.b.setPhoto(paramUploadedPhoto.photo);
        r();
    }

    protected void a(mobi.ifunny.util.a.d paramd) {
        if (paramd != null) {
            paramd = new mobi.ifunny.view.drawable.f(paramd);
            this.s.setImageDrawable(paramd);
        }
    }

    protected void b(Uri paramUri) {
        this.A = an.a(paramUri);
        a(paramUri, true);
    }

    protected void b(User paramUser) {
        this.a = paramUser;
        c(paramUser);
        this.b = new User(paramUser);
    }

    public boolean b() {
        if (!s()) {
            return true;
        }
        android.support.v4.app.q localq = getChildFragmentManager();
        n localn = (n) localq.a("CONFIRM_CHANGES_LOOSE_ALERT_TAG");
        if (localn != null) {
            localn.b();
            localq.b();
        }
        localn = new n();
        localn.a(getActivity(), 0, 2131689832, 2131689800, 2131689676);
        localn.a(localq, "CONFIRM_CHANGES_LOOSE_ALERT_TAG");
        return false;
    }

    protected void c() {
        if ((android.support.v4.app.g) getActivity().f().a("profile.saving.dialog") == null) {
            mobi.ifunny.fragment.h.a(this, false, new String[]{"profile.is.saving"}).a(getActivity().f(), "profile.saving.dialog");
        }
    }

    public void c(Uri paramUri) {
        Intent localIntent = new Intent(getActivity(), FixedCropImageActivity.class);
        localIntent.setData(paramUri);
        localIntent.putExtra("intent.crop_shape", 1);
        localIntent.putExtra("intent.crop_max_w", 600);
        localIntent.putExtra("intent.crop_max_h", 600);
        localIntent.putExtra("intent.crop_filename", "avatar_crop_fixed.jpg");
        startActivityForResult(localIntent, 1);
    }

    protected void d() {
        android.support.v4.app.g localg = (android.support.v4.app.g) getActivity().f().a("profile.saving.dialog");
        if (localg != null) {
            localg.b();
        }
    }

    public void e() {
        this.b.cover_url = null;
        a(null, false);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        switch (paramInt1) {
            default:
                super.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
        do {
            do {
                do {
                    return;
                } while (paramInt2 != -1);
                paramIntent = paramIntent.getData();
                this.A = an.a(paramIntent);
                this.b.cover_url = paramIntent.toString();
                a(paramIntent, false);
                return;
            } while (paramInt2 != -1);
            paramIntent = paramIntent.getData();
            this.b.setPhotoThumbLargeUrl(paramIntent.toString());
            a(paramIntent, 0);
            return;
        } while (paramInt2 != -1);
        paramIntent = (User) paramIntent.getParcelableExtra("result.profile");
        if (paramIntent == null) {
            mobi.ifunny.d.e(k, "Profile settings does not return updated profile");
            H();
            return;
        }
        this.a = paramIntent;
        this.b = new User(this.a);
        L();
    }

    public void onClick(View paramView) {
        boolean bool3 = true;
        boolean bool4 = true;
        boolean bool2 = true;
        boolean bool1;
        switch (paramView.getId()) {
            default:
                return;
            case 2131493200:
                I();
                return;
            case 2131493202:
                J();
                return;
            case 2131493211:
                if ((this.a.social == null) || (this.a.social.fb == null)) {
                    j();
                    return;
                }
                paramView = this.b.social.fb;
                if (!this.b.social.fb.is_hidden) {
                    bool1 = true;
                    paramView.is_hidden = bool1;
                    paramView = this.c;
                    if (this.b.social.fb.is_hidden) {
                        break label187;
                    }
                }
                for (bool1 = bool2; ; bool1 = false) {
                    paramView.setSwitcherState(bool1);
                    return;
                    bool1 = false;
                    break;
                }
            case 2131493213:
                if ((this.a.social == null) || (this.a.social.gplus == null)) {
                    m();
                    return;
                }
                paramView = this.b.social.gplus;
                if (!this.b.social.gplus.is_hidden) {
                    bool1 = true;
                    paramView.is_hidden = bool1;
                    paramView = this.d;
                    if (this.b.social.gplus.is_hidden) {
                        break label289;
                    }
                }
                for (bool1 = bool3; ; bool1 = false) {
                    paramView.setSwitcherState(bool1);
                    return;
                    bool1 = false;
                    break;
                }
            case 2131493212:
                if ((this.a.social == null) || (this.a.social.tw == null)) {
                    n();
                    return;
                }
                paramView = this.b.social.tw;
                if (!this.b.social.tw.is_hidden) {
                    bool1 = true;
                    paramView.is_hidden = bool1;
                    paramView = this.e;
                    if (this.b.social.tw.is_hidden) {
                        break label391;
                    }
                }
                for (bool1 = bool4; ; bool1 = false) {
                    paramView.setSwitcherState(bool1);
                    return;
                    bool1 = false;
                    break;
                }
            case 2131493084:
                label187:
                label289:
                label391:
                getActivity().finish();
                return;
        }
        r();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        this.a = ((User) getArguments().getParcelable("arg.profile"));
        this.b = new User(this.a);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramBundle = getResources();
        paramLayoutInflater = paramLayoutInflater.inflate(2130903141, paramViewGroup, false);
        this.r = paramLayoutInflater.findViewById(2131493199);
        paramLayoutInflater.findViewById(2131493200).setOnClickListener(this);
        this.s = ((ImageView) paramLayoutInflater.findViewById(2131493201));
        this.t = ((ImageView) paramLayoutInflater.findViewById(2131493229));
        ((ParallaxScrollView) paramLayoutInflater.findViewById(2131493198)).a(this.r, new uk.co.chrisjenx.paralloid.c.a(), 0.6F);
        ((ViewGroup) paramLayoutInflater.findViewById(2131493202)).setOnClickListener(this);
        this.y = ((TextView) paramLayoutInflater.findViewById(2131493205));
        this.z = ((ImageView) paramLayoutInflater.findViewById(2131493206));
        this.u = ((SettingsItemLayout) paramLayoutInflater.findViewById(2131493208));
        this.w = this.u.getLeftTextEditView();
        this.w.setCompoundDrawablesWithIntrinsicBounds(null, null, paramBundle.getDrawable(2130837820), null);
        this.w.addTextChangedListener(this.C);
        this.w.setSingleLine();
        this.w.setFilters(new InputFilter[]{new am(), new InputFilter.LengthFilter(25)});
        this.w.setOnFocusChangeListener(this.D);
        n = paramBundle.getColor(2131361848);
        m = paramBundle.getColor(2131361861);
        p = paramBundle.getColor(2131361835);
        o = paramBundle.getColor(2131361883);
        this.v = ((SettingsItemLayout) paramLayoutInflater.findViewById(2131493209));
        this.x = this.v.getLeftTextEditView();
        this.x.setInputType(16385);
        this.x.setHorizontallyScrolling(false);
        this.x.setMaxLines(5);
        this.x.addTextChangedListener(this.E);
        this.x.setFilters(new InputFilter[]{new al(), new InputFilter.LengthFilter(150)});
        this.x.setOnFocusChangeListener(this.F);
        this.c = ((SettingsItemLayout) paramLayoutInflater.findViewById(2131493211));
        this.c.setOnClickListener(this);
        this.d = ((SettingsItemLayout) paramLayoutInflater.findViewById(2131493213));
        this.d.setOnClickListener(this);
        this.e = ((SettingsItemLayout) paramLayoutInflater.findViewById(2131493212));
        this.e.setOnClickListener(this);
        this.f = paramLayoutInflater.findViewById(2131493084);
        this.f.setOnClickListener(this);
        this.g = paramLayoutInflater.findViewById(2131493085);
        this.g.setOnClickListener(this);
        paramViewGroup = getResources().getConfiguration();
        switch (paramViewGroup.screenLayout & 0xF) {
        }
        do {
            return paramLayoutInflater;
        } while (paramViewGroup.orientation != 1);
        paramLayoutInflater.getViewTreeObserver().addOnGlobalLayoutListener(this.B);
        return paramLayoutInflater;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putParcelable("saved.profile", this.a);
        paramBundle.putParcelable("saved.changed.profile", this.b);
        paramBundle.putString("saved.cover.mime", this.A);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        User localUser = null;
        if (paramBundle != null) {
            this.a = ((User) paramBundle.getParcelable("saved.profile"));
            localUser = (User) paramBundle.getParcelable("saved.changed.profile");
            this.A = paramBundle.getString("saved.cover.mime");
        }
        if (this.a == null) {
            H();
            return;
        }
        if (localUser != null) {
        }
        for (; ; ) {
            this.b = localUser;
            c(this.b);
            return;
            localUser = new User(this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/editor/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */