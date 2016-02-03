package mobi.ifunny.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.h;
import mobi.ifunny.view.ProgressBar;

public class ImagePreviewFragment
        extends android.support.v4.app.g
        implements ag<d> {
    @InjectView(2131493150)
    protected ImageView image;
    private Uri j;
    private AnimatorSet k;
    private AnimatorSet l;
    @InjectView(2131493149)
    protected ProgressBar progress;

    public static ImagePreviewFragment a(Uri paramUri) {
        ImagePreviewFragment localImagePreviewFragment = new ImagePreviewFragment();
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("args.uri", paramUri);
        localImagePreviewFragment.setArguments(localBundle);
        return localImagePreviewFragment;
    }

    public Dialog a(Bundle paramBundle) {
        paramBundle = new Dialog(getActivity(), 2131755186);
        Object localObject = paramBundle.getWindow().getAttributes();
        ((WindowManager.LayoutParams) localObject).width = -1;
        ((WindowManager.LayoutParams) localObject).height = -1;
        ((WindowManager.LayoutParams) localObject).gravity = 17;
        localObject = LayoutInflater.from(getActivity()).inflate(2130903124, null, false);
        ButterKnife.inject(this, (View) localObject);
        paramBundle.setContentView((View) localObject, new ViewGroup.LayoutParams(-1, -1));
        b(false);
        paramBundle.setCanceledOnTouchOutside(false);
        paramBundle.setOnKeyListener(new f(this));
        return paramBundle;
    }

    public void a(android.support.v4.a.l<d> paraml, d paramd) {
        if (paramd == null) {
            return;
        }
        this.image.setImageDrawable(new mobi.ifunny.view.drawable.f(paramd));
        this.image.setVisibility(0);
        this.progress.setVisibility(8);
        this.k.start();
    }

    public void d() {
        if ((this.l.isRunning()) || (this.l.isStarted())) {
            return;
        }
        this.l.start();
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        getLoaderManager().a(100, null, this);
        this.k = ((AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034112));
        this.k.setTarget(this.image);
        this.l = ((AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), 2131034113));
        this.l.setTarget(this.image);
        this.l.addListener(new g(this));
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.j = ((Uri) getArguments().getParcelable("args.uri"));
        if (this.j == null) {
            throw new IllegalArgumentException();
        }
    }

    public android.support.v4.a.l<d> onCreateLoader(int paramInt, Bundle paramBundle) {
        paramBundle = new a(h.a(getActivity()), false);
        return new mobi.ifunny.e.l(getActivity(), true, this.j, paramBundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.k.cancel();
        this.k.removeAllListeners();
        this.l.cancel();
        this.l.removeAllListeners();
        ButterKnife.reset(this);
    }

    @OnClick({2131493148})
    protected void onDialogClicked(View paramView) {
        d();
    }

    public void onLoaderReset(android.support.v4.a.l<d> paraml) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/fragment/ImagePreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */