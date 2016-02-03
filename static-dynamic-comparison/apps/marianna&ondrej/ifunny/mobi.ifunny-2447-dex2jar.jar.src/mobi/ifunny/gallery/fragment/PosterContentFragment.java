package mobi.ifunny.gallery.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.ButterKnife;
import butterknife.InjectView;
import mobi.ifunny.gallery.GalleryFragment;
import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.LoadingHelper;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.view.PinchImageView;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.q;
import mobi.ifunny.view.v;

public class PosterContentFragment
        extends o
        implements View.OnClickListener {
    private static final String c = PosterContentFragment.class.getSimpleName();
    View b;
    @InjectView(2131493124)
    PinchImageView pinchImageView;
    @InjectView(2131493083)
    ProgressBar progressBar;

    private void a(mobi.ifunny.util.a.d paramd) {
        this.progressBar.setVisibility(4);
        if (this.b != null) {
            this.b.setVisibility(4);
        }
        paramd = new mobi.ifunny.view.drawable.f(paramd);
        paramd.b(true);
        this.pinchImageView.setImageDrawable(paramd);
        this.pinchImageView.setVisibility(0);
    }

    private void c() {
        LoadingHelper localLoadingHelper = n().loadingHelper;
        String str = localLoadingHelper.loadTag();
        if (f(str)) {
            mobi.ifunny.d.a(c, "Load already running");
            return;
        }
        this.progressBar.setVisibility(0);
        this.pinchImageView.setVisibility(4);
        if (this.b != null) {
            this.b.setVisibility(4);
        }
        new ae(this, str).execute(new String[]{localLoadingHelper.getLoadUrl(localLoadingHelper.getDefaultLoadSource())});
    }

    private void d() {
        this.progressBar.setVisibility(4);
        if (this.b == null) {
            this.b = ((ViewStub) ButterKnife.findById(getView(), 2131493121)).inflate();
            this.b.findViewById(2131493123).setOnClickListener(this);
        }
        for (; ; ) {
            this.pinchImageView.setVisibility(4);
            return;
            this.b.setVisibility(0);
        }
    }

    protected void a(m<mobi.ifunny.util.a.d> paramm) {
        paramm = (mobi.ifunny.util.a.d) paramm.a;
        if ((paramm == null) || (paramm.b())) {
            d();
            return;
        }
        a(paramm);
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2) {
        super.a(paramBoolean1, paramBoolean2);
        if (this.pinchImageView != null) {
            this.pinchImageView.a(paramBoolean1, paramBoolean2);
        }
    }

    public void b() {
        super.b();
        this.pinchImageView.a();
    }

    protected void b(int paramInt) {
        this.progressBar.setPercent(paramInt);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        c();
    }

    public void onClick(View paramView) {
        if (paramView.getId() == 2131493123) {
            c();
        }
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        boolean bool = false;
        paramLayoutInflater = paramLayoutInflater.inflate(2130903118, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.progressBar.setMode(v.a);
        paramViewGroup = e().k();
        if (!n().isAbused()) {
            bool = true;
        }
        this.pinchImageView.setTapListener(paramViewGroup);
        this.pinchImageView.setOverscroll(bool);
        this.pinchImageView.setZoomable(bool);
        this.pinchImageView.setFitPolicy(q.a);
        a(paramViewGroup.u(), paramViewGroup.v());
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        this.b = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/PosterContentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */