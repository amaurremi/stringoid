package mobi.ifunny.studio.crop.free;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.k;
import android.util.Pair;
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

import mobi.ifunny.l.e;
import mobi.ifunny.video.a;
import mobi.ifunny.view.ProgressBar;

public class FreeCropGifFragment
        extends e {
    private Uri a;
    private int b;
    private int c;
    private int d;
    private int e;
    private a f;
    private File g;
    @InjectView(2131492972)
    FreeCropImageView imageView;
    @InjectView(2131493083)
    ProgressBar progress;

    public static FreeCropGifFragment a(Uri paramUri) {
        if (paramUri == null) {
            throw new IllegalArgumentException();
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.uri", paramUri);
        paramUri = new FreeCropGifFragment();
        paramUri.setArguments(localBundle);
        return paramUri;
    }

    private void a(int paramInt) {
        k localk = getActivity();
        int i = paramInt;
        if (paramInt == 0) {
            i = 2131690122;
        }
        Toast.makeText(localk, i, 0).show();
        localk.setResult(0);
        localk.finish();
    }

    private void a(Pair<a, File> paramPair) {
        a locala = (a) paramPair.first;
        paramPair = (File) paramPair.second;
        k localk = getActivity();
        if ((locala.getIntrinsicWidth() < this.b) || (locala.getIntrinsicHeight() < this.c)) {
            locala.d();
            Toast.makeText(localk, 2131690022, 0).show();
            localk.setResult(0);
            localk.finish();
            return;
        }
        this.progress.setVisibility(4);
        this.imageView.setImageDrawable(locala);
        this.imageView.setVisibility(0);
        locala.start();
        this.g = paramPair;
        this.f = locala;
    }

    private void a(a parama) {
        if (parama != null) {
            parama.d();
        }
        parama = getActivity();
        Toast.makeText(parama, 2131690008, 0).show();
        parama.setResult(0);
        parama.finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        this.a = ((Uri) getArguments().getParcelable("arg.uri"));
        paramBundle = getResources();
        this.b = paramBundle.getDimensionPixelSize(2131427491);
        this.c = paramBundle.getDimensionPixelSize(2131427491);
        this.d = paramBundle.getDimensionPixelSize(2131427489);
        this.e = paramBundle.getDimensionPixelSize(2131427488);
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
        this.imageView.setMinCropWidth(this.b);
        this.imageView.setMinCropHeight(this.c);
        return paramLayoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f != null) {
            this.f.d();
        }
        ButterKnife.reset(this);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if ((this.f == null) || (this.g == null)) {
            Toast.makeText(getActivity(), 2131689605, 0).show();
            return true;
        }
        paramMenuItem = this.imageView.getCropRect();
        if ((paramMenuItem.width() > this.d) || (paramMenuItem.height() > this.e)) {
            Toast.makeText(getActivity(), 2131690021, 1).show();
            return true;
        }
        Object localObject = this.imageView.getReverseCrop();
        paramMenuItem = new Intent();
        paramMenuItem.setData(Uri.fromFile(this.g));
        paramMenuItem.putExtra("INTENT_CROP_RECT", (Parcelable) localObject);
        this.f.b(false);
        localObject = getActivity();
        ((Activity) localObject).setResult(-1, paramMenuItem);
        ((Activity) localObject).finish();
        return true;
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        paramBundle.putSerializable("STATE_GIF_FILE", this.g);
    }

    public void onViewStateRestored(Bundle paramBundle) {
        super.onViewStateRestored(paramBundle);
        if (paramBundle != null) {
            this.g = ((File) paramBundle.getSerializable("STATE_GIF_FILE"));
        }
        new b(this, "TASK_LOAD_GIF", this.g, null).execute(new Uri[]{this.a});
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/FreeCropGifFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */