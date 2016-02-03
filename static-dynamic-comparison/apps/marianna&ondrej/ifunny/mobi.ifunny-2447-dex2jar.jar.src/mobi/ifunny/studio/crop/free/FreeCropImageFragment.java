package mobi.ifunny.studio.crop.free;

import android.content.Intent;
import android.content.res.Resources;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

import java.io.File;

import mobi.ifunny.fragment.h;
import mobi.ifunny.l.e;
import mobi.ifunny.util.a.a;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.an;
import mobi.ifunny.util.i;
import mobi.ifunny.util.j;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.drawable.f;

public class FreeCropImageFragment
        extends e
        implements ag<d> {
    private static final String a = FreeCropImageFragment.class.getSimpleName();
    private Uri b;
    private int c;
    private int d;
    private int e;
    @InjectView(2131492972)
    FreeCropImageView imageView;
    @InjectView(2131493083)
    ProgressBar progress;

    public static FreeCropImageFragment a(Uri paramUri) {
        if (paramUri == null) {
            throw new IllegalArgumentException();
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.uri", paramUri);
        paramUri = new FreeCropImageFragment();
        paramUri.setArguments(localBundle);
        return paramUri;
    }

    private void e() {
        Toast.makeText(getActivity(), 2131689605, 0).show();
    }

    public void a(android.support.v4.a.l<d> paraml, d paramd) {
        paraml = getActivity();
        if (paramd == null) {
            Toast.makeText(paraml, 2131690008, 0).show();
            paraml.setResult(0);
            paraml.finish();
            return;
        }
        if ((paramd.a < this.c) || (paramd.b < this.d)) {
            Toast.makeText(paraml, 2131690022, 0).show();
            paraml.setResult(0);
            paraml.finish();
            return;
        }
        this.progress.setVisibility(4);
        this.imageView.setImageDrawable(new f(paramd));
        paraml = i.a(this.e);
        if (paraml != null) {
            if (paraml.a != null) {
                this.imageView.setRotation(paraml.a.intValue());
            }
            if (paraml.b != null) {
                this.imageView.setScaleX(paraml.b.intValue());
            }
        }
        this.imageView.setVisibility(0);
    }

    protected void b() {
        q localq = getFragmentManager();
        if ((g) localq.a("dialog.progress") == null) {
            h.a(this, new String[]{"task.process"}).a(localq, "dialog.progress");
        }
    }

    protected void b(Uri paramUri) {
        FreeCropImageActivity localFreeCropImageActivity = (FreeCropImageActivity) getActivity();
        if (paramUri == null) {
            Toast.makeText(localFreeCropImageActivity, 2131689606, 0).show();
            c();
            return;
        }
        Intent localIntent = new Intent();
        localIntent.setData(paramUri);
        localFreeCropImageActivity.setResult(-1, localIntent);
        localFreeCropImageActivity.finish();
    }

    protected void c() {
        g localg = (g) getFragmentManager().a("dialog.progress");
        if (localg != null) {
            localg.a();
        }
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        getLoaderManager().a(0, null, this);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        this.b = ((Uri) getArguments().getParcelable("arg.uri"));
        paramBundle = getResources();
        this.c = paramBundle.getDimensionPixelSize(2131427497);
        this.d = paramBundle.getDimensionPixelSize(2131427497);
        this.e = 1;
    }

    public android.support.v4.a.l<d> onCreateLoader(int paramInt, Bundle paramBundle) {
        try {
            this.e = new ExifInterface(an.b(this.b)).getAttributeInt("Orientation", 1);
            return new mobi.ifunny.e.l(getActivity(), true, this.b, new a(null, false));
        } catch (Exception paramBundle) {
            for (; ; ) {
            }
        }
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820560, paramMenu);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        paramLayoutInflater = paramLayoutInflater.inflate(2130903102, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        this.imageView.setCornerDrawable(getResources().getDrawable(2130837782));
        this.imageView.setVisibility(4);
        this.imageView.setMinCropWidth(this.c);
        this.imageView.setMinCropHeight(this.d);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void onLoaderReset(android.support.v4.a.l<d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        paramMenuItem = (f) this.imageView.getDrawable();
        if (paramMenuItem == null) {
            e();
            return true;
        }
        if ((paramMenuItem.e() == null) || (paramMenuItem.e().b())) {
            e();
            return true;
        }
        paramMenuItem = this.imageView.getReverseCrop();
        new c(this, this.b, paramMenuItem, this.e).execute(new File[]{getActivity().getCacheDir()});
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/FreeCropImageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */