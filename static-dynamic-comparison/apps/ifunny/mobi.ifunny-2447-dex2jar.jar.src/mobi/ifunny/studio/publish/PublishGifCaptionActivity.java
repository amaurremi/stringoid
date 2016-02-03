package mobi.ifunny.studio.publish;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.support.v4.app.q;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

import mobi.ifunny.fragment.h;
import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.an;
import mobi.ifunny.util.r;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;

public class PublishGifCaptionActivity
        extends a
        implements ag<d> {
    public static Bitmap v;
    private int A;
    private Uri w;
    private String x;
    private float y;
    private Rect z;

    private void a(String paramString1, String paramString2, String paramString3) {
        Object localObject = new Random();
        localObject = new File(getCacheDir(), Long.toHexString(((Random) localObject).nextLong()) + ".gif");
        ((File) localObject).mkdirs();
        ((File) localObject).delete();
        localObject = ((File) localObject).getAbsolutePath();
        Intent localIntent = new Intent(this, PublishGifCaptionService.class);
        localIntent.putExtra("INTENT_FILENAME", paramString3);
        localIntent.putExtra("INTENT_CAPTION_FILENAME", paramString2);
        localIntent.putExtra("INTENT_OUTPUT_FILENAME", (String) localObject);
        localIntent.putExtra("INTENT_TIMESCALE", this.y);
        localIntent.putExtra("INTENT_TEXT", this.x);
        localIntent.putExtra("INTENT_CROP", this.z);
        localIntent.putExtra("INTENT_DESCRIPTION", paramString1);
        v = null;
        Toast.makeText(this, 2131690089, 1).show();
        startService(localIntent);
        setResult(-1);
        finish();
    }

    public void a(android.support.v4.a.l<d> paraml, d paramd) {
        if (paramd != null) {
            this.s.setVisibility(4);
            this.p.setUpscaleRatioLimit(this.A);
            this.p.setVisibility(0);
            this.o.setUpscaleRatioLimit(this.A);
            this.o.setVisibility(0);
            paraml = new mobi.ifunny.view.drawable.f(paramd);
            if (this.z != null) {
                paraml.a(this.z);
            }
            this.o.setImageDrawable(paraml);
            this.q.setVisibility(0);
        }
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<TaskInfo, a> paramRestHttpHandler) {
        paramString1 = an.b(this.w);
        new f(this, "TASK_PREPARE", getCacheDir(), paramString1, paramString2, null).execute(new Void[0]);
    }

    protected void c(String paramString) {
        h.a(this, false, new String[]{paramString}).a(f(), "dialog.loading");
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getIntent();
        this.w = paramBundle.getData();
        if (this.w == null) {
            throw new IllegalStateException();
        }
        this.x = r.a(paramBundle.getStringExtra("INTENT_EXTRA_CAPTION_TEXT"), getResources().getInteger(2131558422));
        this.y = paramBundle.getFloatExtra("INTENT_EXTRA_SCALE", 1.0F);
        this.z = ((Rect) paramBundle.getParcelableExtra("INTENT_EXTRA_CROP"));
        this.p.setImageDrawable(new BitmapDrawable(getResources(), v));
        this.t.setText(this.x);
        this.t.setSelection(this.t.length());
        this.A = getResources().getInteger(2131558412);
        paramBundle = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
        float f = this.A;
        this.A = ((int) (paramBundle.density * 0.75F * f));
        paramBundle = new Bundle();
        paramBundle.putParcelable("loader.image.uri", this.w);
        g().a(0, paramBundle, this);
    }

    public android.support.v4.a.l<d> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new mobi.ifunny.e.l(this, true, (Uri) paramBundle.getParcelable("loader.image.uri"), new mobi.ifunny.util.a.a(null, false));
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131820564, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    protected void onDestroy() {
        if (isFinishing()) {
            v = null;
        }
        super.onDestroy();
    }

    public void onLoaderReset(android.support.v4.a.l<d> paraml) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        if (!e("task.save")) {
            new g(this, "task.save", this.y, this.z, this.w).execute(new Void[0]);
        }
        return true;
    }

    protected void t() {
        android.support.v4.app.g localg = (android.support.v4.app.g) f().a("dialog.loading");
        if (localg != null) {
            localg.b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishGifCaptionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */