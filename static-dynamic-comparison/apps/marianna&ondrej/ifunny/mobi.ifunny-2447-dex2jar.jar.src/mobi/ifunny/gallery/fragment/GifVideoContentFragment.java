package mobi.ifunny.gallery.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.d;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.LoadingHelper;
import mobi.ifunny.rest.content.LoadingHelper.LoadSource;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.video.c;
import mobi.ifunny.view.PinchImageView;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.q;
import mobi.ifunny.view.v;

public class GifVideoContentFragment
        extends o
        implements View.OnClickListener {
    private static final String b = GifVideoContentFragment.class.getSimpleName();
    private View c;
    private c d;
    @InjectView(2131493120)
    PinchImageView img;
    @InjectView(2131493119)
    ProgressBar progressBar;
    @InjectView(2131493121)
    ViewStub reloadStub;

    private void a(c paramc) {
        if (this.d != null) {
            this.d.d();
        }
        if (paramc == null) {
            d();
        }
        do {
            return;
            this.d = paramc;
            this.d.a(true);
            this.img.setImageDrawable(paramc);
            this.progressBar.setVisibility(8);
            this.img.setVisibility(0);
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        } while (!A());
        this.d.start();
    }

    private void c() {
        LoadingHelper localLoadingHelper = n().loadingHelper;
        String str = localLoadingHelper.loadTag();
        if (f(str)) {
            d.a(b, "Load already running");
            return;
        }
        this.progressBar.setVisibility(0);
        this.img.setVisibility(4);
        if (this.c != null) {
            this.c.setVisibility(4);
        }
        if (localLoadingHelper.getDefaultLoadSource() == LoadingHelper.LoadSource.WEBM) {
        }
        for (boolean bool = true; ; bool = false) {
            new e(this, str, bool).execute(new String[]{localLoadingHelper.getLoadUrl(localLoadingHelper.getDefaultLoadSource())});
            return;
        }
    }

    private void d() {
        if (this.c == null) {
            this.c = this.reloadStub.inflate();
            this.c.findViewById(2131493123).setOnClickListener(this);
        }
        this.c.setVisibility(0);
        this.img.setVisibility(4);
        this.progressBar.setVisibility(4);
    }

    public void a(int paramInt) {
        if (paramInt == 0) {
            if ((A()) && (this.d != null)) {
                this.d.start();
            }
        }
        do {
            do {
                do {
                    return;
                } while (paramInt != 1);
                if (!A()) {
                    break;
                }
            } while (this.d == null);
            this.d.b();
            return;
        } while (this.d == null);
        this.img.invalidate();
    }

    protected void a(m<c> paramm) {
        paramm = (c) paramm.a;
        if (paramm == null) {
            d();
            return;
        }
        a(paramm);
    }

    protected void a(boolean paramBoolean) {
        super.a(paramBoolean);
        if (paramBoolean) {
            if (this.d != null) {
                this.progressBar.setVisibility(8);
                this.img.setVisibility(0);
                this.d.start();
            }
        }
        while (this.d == null) {
            return;
        }
        this.d.c();
        this.d.stop();
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
        super.a(paramBoolean1, paramBoolean2);
        if (this.img != null) {
            this.img.a(paramBoolean1, paramBoolean2);
        }
    }

    public void b() {
        super.b();
        this.img.a();
    }

    protected void b(int paramInt) {
        this.progressBar.setPercent(paramInt);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        c();
    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                return;
        }
        c();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903115, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.progressBar.setMode(v.a);
        paramViewGroup = e().k();
        this.img.setTapListener(paramViewGroup);
        this.img.setZoomable(false);
        this.img.setOverscroll(true);
        this.img.setFitPolicy(q.b);
        a(paramViewGroup.u(), paramViewGroup.v());
        return paramLayoutInflater;
    }

    public void onDestroy() {
        if (this.d != null) {
            Log.d("plasma", "clear " + this.d);
            this.d.d();
            this.d = null;
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        this.c = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/GifVideoContentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */