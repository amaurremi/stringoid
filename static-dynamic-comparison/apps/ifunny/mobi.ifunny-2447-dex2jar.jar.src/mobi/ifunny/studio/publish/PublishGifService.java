package mobi.ifunny.studio.publish;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.app.aw;
import android.support.v4.app.bv;

import java.io.File;

import mobi.ifunny.d;
import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestResponse;
import mobi.ifunny.util.af;
import mobi.ifunny.util.p;
import retrofit.mime.TypedFile;

public class PublishGifService
        extends IntentService {
    public static final String a = PublishGifService.class.getSimpleName();
    private int b;
    private aw c;
    private bv d;

    public PublishGifService() {
        super(PublishGifService.class.getSimpleName());
    }

    private void a(int paramInt) {
        if (paramInt < 0) {
            this.c.a(0, 0, true);
        }
        for (; ; ) {
            this.d.a(this.b, this.c.b());
            return;
            this.c.a(100, paramInt, false);
        }
    }

    private void a(int paramInt, String paramString) {
        af.a(this, paramInt, false, paramString);
    }

    protected void onHandleIntent(Intent paramIntent) {
        Object localObject3 = paramIntent.getStringExtra("INTENT_FILENAME");
        String str = paramIntent.getStringExtra("INTENT_OUTPUT_FILENAME");
        Object localObject2 = paramIntent.getStringExtra("INTENT_DESCRIPTION");
        Rect localRect = (Rect) paramIntent.getParcelableExtra("INTENT_CROP");
        this.b = af.a();
        this.c = af.b(this);
        this.d = bv.a(this);
        a(0);
        File localFile = new File((String) localObject3);
        if ((localRect == null) || ((localRect.left == 0) && (localRect.right == 0) && (localRect.top == 0) && (localRect.bottom == 0))) {
            d.b(a, "Crop is skipped, just copy file");
            a(-1);
            paramIntent = localFile;
        }
        for (; ; ) {
            try {
                localObject2 = IFunnyRestRequest.Content.addImageSync("gif", (String) localObject2, new TypedFile("image/gif", paramIntent), null);
                if ((localObject2 != null) && (((RestResponse) localObject2).status < 400) && (((RestResponse) localObject2).data != null) && (((TaskInfo) ((RestResponse) localObject2).data).id != null)) {
                    continue;
                }
                a(this.b, null);
            } catch (Exception localException) {
                int i;
                a(this.b, null);
                if (paramIntent == null) {
                    continue;
                }
                paramIntent.delete();
                continue;
            } finally {
                if (paramIntent == null) {
                    continue;
                }
                paramIntent.delete();
            }
            localFile.delete();
            return;
            paramIntent = new File(str);
            i = p.a((String) localObject3, str, localRect, new i(this));
            if (i > 0) {
                paramIntent.delete();
                paramIntent = getResources().getString(i);
                a(this.b, paramIntent);
                return;
            }
            a(90);
            continue;
            a(-1);
            localObject3 = new Intent(this, PublishService.class);
            ((Intent) localObject3).putExtra("arg.info", (Parcelable) ((RestResponse) localObject2).data);
            ((Intent) localObject3).putExtra("arg.notification.id", this.b);
            startService((Intent) localObject3);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishGifService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */