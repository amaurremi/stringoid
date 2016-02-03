package mobi.ifunny.studio.crop.fixed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.k;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import mobi.ifunny.util.a.a;
import mobi.ifunny.util.an;
import mobi.ifunny.util.i;
import mobi.ifunny.util.j;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.drawable.f;
import mobi.ifunny.view.q;

public class FixedCropImageFragment
        extends Fragment
        implements ag<mobi.ifunny.util.a.d> {
    private static final String a = FixedCropImageFragment.class.getSimpleName();
    private int b;
    private Uri c;
    private int d;
    private int e;
    private int f;
    private String g;
    @InjectView(2131492972)
    protected FixedCropImageView image;
    @InjectView(2131493083)
    protected ProgressBar progress;

    private File a(Bitmap paramBitmap) {
        if (paramBitmap == null) {
            throw new IllegalArgumentException();
        }
        Object localObject2 = b(paramBitmap);
        try {
            j localj = i.a(this.b);
            if ((localj == null) || ((localj.a == null) && (localj.b == null))) {
                break label212;
            }
            paramBitmap = new Matrix();
            if (localj.a != null) {
                paramBitmap.postRotate(localj.a.intValue());
            }
            localObject1 = paramBitmap;
            if (localj.b != null) {
                paramBitmap.postScale(localj.b.intValue(), 1.0F);
                localObject1 = paramBitmap;
            }
        } catch (Exception paramBitmap) {
            for (; ; ) {
                paramBitmap = (Bitmap) localObject2;
                continue;
                localObject1 = null;
            }
        }
        paramBitmap = (Bitmap) localObject2;
        if (localObject1 != null) {
            paramBitmap = Bitmap.createBitmap((Bitmap) localObject2, 0, 0, ((Bitmap) localObject2).getWidth(), ((Bitmap) localObject2).getHeight(), (Matrix) localObject1, false);
        }
        localObject1 = getActivity();
        try {
            localObject2 = new File(((Context) localObject1).getCacheDir(), this.g);
        } catch (IOException paramBitmap) {
            mobi.ifunny.d.c(a, "saveToTemporary", paramBitmap);
            return null;
        }
        for (; ; ) {
            try {
                localObject1 = new FileOutputStream((File) localObject2);
            } finally {
                localObject1 = null;
                break;
            }
            try {
                paramBitmap.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream) localObject1);
                if (localObject1 == null) {
                    continue;
                }
                ((FileOutputStream) localObject1).close();
            } finally {
                break;
            }
        }
        if (localObject1 != null) {
            ((FileOutputStream) localObject1).close();
        }
        throw paramBitmap;
        label212:
        return (File) localObject2;
    }

    public static FixedCropImageFragment a(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString) {
        if (paramUri == null) {
            throw new IllegalArgumentException();
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("arg.uri", paramUri);
        localBundle.putInt("arg.crop_shape", paramInt1);
        localBundle.putInt("arg.crop_max_w", paramInt2);
        localBundle.putInt("arg.crop_max_h", paramInt3);
        localBundle.putString("arg.crop_filename", paramString);
        paramUri = new FixedCropImageFragment();
        paramUri.setArguments(localBundle);
        return paramUri;
    }

    private Bitmap b(Bitmap paramBitmap) {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        if ((this.e == 0) || (this.f == 0)) {
        }
        while ((i < this.e) && (j < this.f)) {
            return paramBitmap;
        }
        float f1 = Math.max(i / this.e, j / this.f);
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f1, f1);
        return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    }

    public void a(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml, mobi.ifunny.util.a.d paramd) {
        if (paramd == null) {
            paraml = getActivity();
            Toast.makeText(paraml, 2131690008, 0).show();
            paraml.setResult(0);
            paraml.finish();
            return;
        }
        this.progress.setVisibility(4);
        this.image.setImageDrawable(new f(paramd));
        paraml = i.a(this.b);
        if (paraml != null) {
            if (paraml.a != null) {
                this.image.setRotation(paraml.a.intValue());
            }
            if (paraml.b != null) {
                this.image.setScaleX(paraml.b.intValue());
            }
        }
        this.image.setVisibility(0);
    }

    public void onActivityCreated(Bundle paramBundle) {
        super.onActivityCreated(paramBundle);
        getLoaderManager().a(0, null, this);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setHasOptionsMenu(true);
        paramBundle = getArguments();
        this.c = ((Uri) paramBundle.getParcelable("arg.uri"));
        this.d = paramBundle.getInt("arg.crop_shape");
        int i = paramBundle.getInt("arg.crop_max_w");
        int j = paramBundle.getInt("arg.crop_max_h");
        this.g = paramBundle.getString("arg.crop_filename");
        if ((i > 0) && (j > 0)) {
            this.e = i;
            this.f = j;
        }
        this.b = 1;
    }

    public android.support.v4.a.l<mobi.ifunny.util.a.d> onCreateLoader(int paramInt, Bundle paramBundle) {
        try {
            this.b = new ExifInterface(an.b(this.c)).getAttributeInt("Orientation", 1);
            return new mobi.ifunny.e.l(getActivity(), true, this.c, new a(null, false));
        } catch (Exception paramBundle) {
            for (; ; ) {
            }
        }
    }

    public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {
        super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
        paramMenuInflater.inflate(2131820550, paramMenu);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        int i = 0;
        paramLayoutInflater = paramLayoutInflater.inflate(2130903101, paramViewGroup, false);
        ButterKnife.inject(this, paramLayoutInflater);
        switch (this.d) {
        }
        for (; ; ) {
            if (i != 0) {
                this.image.setCropDrawable(getResources().getDrawable(i));
            }
            return paramLayoutInflater;
            this.image.setFitPolicy(q.e);
            this.image.setFitWidthToHeightRatio(2.0F);
            i = 2130837723;
            continue;
            this.image.setFitPolicy(q.d);
            i = 2130837722;
        }
    }

    public void onDestroyView() {
        this.image = null;
        this.progress = null;
        super.onDestroyView();
    }

    public void onLoaderReset(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        paramMenuItem = null;
        Object localObject = this.image.getFitBitmap();
        if (localObject != null) {
            paramMenuItem = a((Bitmap) localObject);
        }
        localObject = getActivity();
        if (paramMenuItem == null) {
            ((Activity) localObject).setResult(0);
        }
        for (; ; ) {
            ((Activity) localObject).finish();
            return true;
            Intent localIntent = new Intent();
            localIntent.setData(Uri.fromFile(paramMenuItem));
            ((Activity) localObject).setResult(-1, localIntent);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/fixed/FixedCropImageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */