package mobi.ifunny.studio.publish;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.a.d;
import mobi.ifunny.util.an;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.drawable.f;

public class PublishGifActivity
        extends a
        implements ag<d> {
    private Uri v;
    private Rect w;

    public void a(android.support.v4.a.l<d> paraml, d paramd) {
        if (paramd != null) {
            this.s.setVisibility(4);
            this.o.setVisibility(0);
            paraml = new f(paramd);
            if (this.w != null) {
                paraml.a(this.w);
            }
            this.o.setImageDrawable(paraml);
            this.q.setVisibility(0);
        }
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<TaskInfo, a> paramRestHttpHandler) {
        paramString1 = an.b(this.v);
        paramRestHttpHandler = new Random();
        paramRestHttpHandler = new File(getCacheDir(), Long.toHexString(paramRestHttpHandler.nextLong()) + ".gif");
        paramRestHttpHandler.mkdirs();
        paramRestHttpHandler.delete();
        paramRestHttpHandler = paramRestHttpHandler.getAbsolutePath();
        Intent localIntent = new Intent(this, PublishGifService.class);
        localIntent.putExtra("INTENT_FILENAME", paramString1);
        localIntent.putExtra("INTENT_OUTPUT_FILENAME", paramRestHttpHandler);
        localIntent.putExtra("INTENT_CROP", this.w);
        localIntent.putExtra("INTENT_DESCRIPTION", paramString2);
        Toast.makeText(this, 2131690089, 1).show();
        startService(localIntent);
        setResult(-1);
        finish();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        paramBundle = getIntent();
        this.v = paramBundle.getData();
        if (this.v == null) {
            throw new IllegalStateException();
        }
        this.w = ((Rect) paramBundle.getParcelableExtra("INTENT_EXTRA_CROP"));
        paramBundle = new Bundle();
        paramBundle.putParcelable("loader.image.uri", this.v);
        g().a(0, paramBundle, this);
    }

    public android.support.v4.a.l<d> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new mobi.ifunny.e.l(this, true, (Uri) paramBundle.getParcelable("loader.image.uri"), new mobi.ifunny.util.a.a(null, false));
    }

    public void onLoaderReset(android.support.v4.a.l<d> paraml) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishGifActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */