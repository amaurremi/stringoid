package mobi.ifunny.studio.publish;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;
import java.nio.IntBuffer;
import java.util.Random;

import mobi.ifunny.e;
import mobi.ifunny.l.b;
import mobi.ifunny.util.an;
import mobi.ifunny.util.k;
import mobi.ifunny.util.l;
import mobi.ifunny.util.p;

final class g
        extends b<PublishGifCaptionActivity, Void, Void, File> {
    private final float a;
    private final Rect b;
    private final Uri c;
    private int d;

    public g(PublishGifCaptionActivity paramPublishGifCaptionActivity, String paramString, float paramFloat, Rect paramRect, Uri paramUri) {
        super(paramPublishGifCaptionActivity, paramString);
        this.a = paramFloat;
        this.c = paramUri;
        this.b = paramRect;
        this.d = -1;
    }

    protected File a(Void... paramVarArgs) {
        paramVarArgs = null;
        Object localObject1 = new Random();
        Object localObject2 = new File(l.a(), Long.toHexString(((Random) localObject1).nextLong()) + ".gif");
        ((File) localObject2).mkdirs();
        ((File) localObject2).delete();
        localObject1 = an.b(this.c);
        localObject2 = ((File) localObject2).getAbsolutePath();
        IntBuffer localIntBuffer = IntBuffer.allocate(PublishGifCaptionActivity.v.getWidth() * PublishGifCaptionActivity.v.getHeight());
        PublishGifCaptionActivity.v.copyPixelsToBuffer(localIntBuffer);
        this.d = p.a((String) localObject1, (String) localObject2, this.a, this.b, localIntBuffer.array(), PublishGifCaptionActivity.v.getHeight(), null);
        if (this.d < 0) {
            paramVarArgs = new File((String) localObject2);
        }
        return paramVarArgs;
    }

    protected void a(PublishGifCaptionActivity paramPublishGifCaptionActivity) {
        super.onStarted(paramPublishGifCaptionActivity);
        paramPublishGifCaptionActivity.c("task.save");
    }

    protected void a(PublishGifCaptionActivity paramPublishGifCaptionActivity, File paramFile) {
        super.onPostExecute(paramPublishGifCaptionActivity, paramFile);
        if (paramFile == null) {
            Toast.makeText(paramPublishGifCaptionActivity, this.d, 0).show();
            return;
        }
        new k(e.a).a(paramFile);
        Toast.makeText(paramPublishGifCaptionActivity, 2131689635, 0).show();
    }

    protected void b(PublishGifCaptionActivity paramPublishGifCaptionActivity) {
        super.onFinished(paramPublishGifCaptionActivity);
        paramPublishGifCaptionActivity.t();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */