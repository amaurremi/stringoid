package mobi.ifunny.studio.publish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;

import java.io.File;

import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.an;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.drawable.f;
import retrofit.mime.TypedFile;

public class PublishImageActivity
        extends a
        implements ag<mobi.ifunny.util.a.d> {
    private static final String v = PublishImageActivity.class.getSimpleName();
    private Uri w;

    public void a(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml, mobi.ifunny.util.a.d paramd) {
        if (paramd == null) {
            mobi.ifunny.d.d(v, "LOADER_IMAGE bitmap == null");
            return;
        }
        this.s.setVisibility(4);
        this.o.setVisibility(0);
        this.o.setImageDrawable(new f(paramd));
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<TaskInfo, a> paramRestHttpHandler) {
        IFunnyRestRequest.Content.addImage(this, paramString1, "pic", paramString2, new TypedFile("image/jpeg", new File(an.b(this.w))), null, paramRestHttpHandler);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.w = getIntent().getData();
        if (this.w == null) {
            throw new IllegalStateException();
        }
        paramBundle = new Bundle();
        paramBundle.putParcelable("loader.image.uri", this.w);
        g().a(0, paramBundle, this);
    }

    public android.support.v4.a.l<mobi.ifunny.util.a.d> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new mobi.ifunny.e.l(this, true, (Uri) paramBundle.getParcelable("loader.image.uri"), new mobi.ifunny.util.a.a(null, false));
    }

    public void onLoaderReset(android.support.v4.a.l<mobi.ifunny.util.a.d> paraml) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */