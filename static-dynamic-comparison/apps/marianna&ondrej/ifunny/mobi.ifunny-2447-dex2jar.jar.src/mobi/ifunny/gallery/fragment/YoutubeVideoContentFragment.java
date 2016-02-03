package mobi.ifunny.gallery.fragment;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.b.a.a.a.a;

import java.text.SimpleDateFormat;
import java.util.Date;

import mobi.ifunny.rest.content.IFunny;
import mobi.ifunny.rest.content.IFunny.VideoParams;
import mobi.ifunny.rest.content.LoadingHelper;
import mobi.ifunny.util.cache.m;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.v;

public class YoutubeVideoContentFragment
        extends o {
    private static final String b = YoutubeVideoContentFragment.class.getSimpleName();
    private ObjectAnimator c;
    @InjectView(2131493129)
    ProgressBar progressBar;
    @InjectView(2131493126)
    ImageViewEx video;
    @InjectView(2131493128)
    ImageView videoPlayAnim;
    @InjectView(2131493127)
    View videoPlayView;

    private void a(mobi.ifunny.util.a.d paramd) {
        paramd = new mobi.ifunny.view.drawable.f(paramd);
        int i = paramd.getIntrinsicWidth();
        int j = paramd.getIntrinsicHeight();
        if (i / j < 1.6F) {
            float f = i / 1.77F;
            i = (int) ((j - f) / 2.0F);
            paramd.a(new Rect(0, i, 0, i));
        }
        this.video.setImageDrawable(paramd);
        this.video.setVisibility(0);
        this.videoPlayView.setVisibility(0);
        this.progressBar.setVisibility(4);
    }

    private void c() {
        LoadingHelper localLoadingHelper = n().loadingHelper;
        String str = localLoadingHelper.loadTag();
        if (f(str)) {
            mobi.ifunny.d.a(b, "Load already running");
            return;
        }
        this.progressBar.setVisibility(0);
        this.video.setVisibility(4);
        this.videoPlayView.setVisibility(4);
        new ag(this, str).execute(new String[]{localLoadingHelper.getLoadUrl(localLoadingHelper.getDefaultLoadSource())});
    }

    private void d() {
        this.video.setImageDrawable(null);
        this.video.setVisibility(4);
        this.videoPlayView.setVisibility(0);
        this.progressBar.setVisibility(4);
    }

    protected void a(m<mobi.ifunny.util.a.d> paramm) {
        paramm = (mobi.ifunny.util.a.d) paramm.a;
        if ((paramm == null) || (paramm.b())) {
            d();
            return;
        }
        a(paramm);
    }

    protected void b(int paramInt) {
        this.progressBar.setPercent(paramInt);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        c();
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramBundle = paramLayoutInflater.inflate(2130903119, paramViewGroup, false);
        ButterKnife.inject(this, paramBundle);
        this.progressBar.setMode(v.a);
        this.video.setFixedUpscaleRatio(getResources().getDisplayMetrics().density);
        this.video.setTapListener(e().k());
        this.c = ((ObjectAnimator) AnimatorInflater.loadAnimator(paramViewGroup.getContext(), 2131034121));
        this.c.setTarget(this.videoPlayAnim);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(2);
        this.c.start();
        ((TextView) paramBundle.findViewById(2131493130)).setText(n().title);
        paramViewGroup = (TextView) paramBundle.findViewById(2131493131);
        paramLayoutInflater = new SimpleDateFormat("mm:ss");
        if (n().video != null) {
        }
        for (paramLayoutInflater = paramLayoutInflater.format(new Date(n().video.length * 1000L)); ; paramLayoutInflater = "?") {
            paramViewGroup.setText(paramLayoutInflater);
            ButterKnife.inject(this, paramBundle);
            return paramBundle;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.c.removeAllListeners();
        this.c.cancel();
        this.c = null;
        ButterKnife.reset(this);
    }

    @OnClick({2131493128})
    public void startVideo() {
        Object localObject = n();
        k localk = getActivity();
        if ((localk != null) && (((IFunny) localObject).video != null) && (!TextUtils.isEmpty(((IFunny) localObject).video.url))) {
            localObject = new Intent("android.intent.action.VIEW", Uri.parse(n().video.url));
            if (!a.a(localk, (Intent) localObject)) {
                Toast.makeText(localk, 2131689663, 0).show();
                return;
            }
            try {
                startActivity((Intent) localObject);
                return;
            } catch (ActivityNotFoundException localActivityNotFoundException) {
                Toast.makeText(localk, 2131689663, 0).show();
                return;
            }
        }
        Toast.makeText(localk, 2131690135, 0).show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/gallery/fragment/YoutubeVideoContentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */