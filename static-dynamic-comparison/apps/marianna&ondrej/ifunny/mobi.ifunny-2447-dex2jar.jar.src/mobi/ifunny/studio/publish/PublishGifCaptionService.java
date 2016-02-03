package mobi.ifunny.studio.publish;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.app.aw;
import android.support.v4.app.bv;

import java.io.File;
import java.nio.IntBuffer;

import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestResponse;
import mobi.ifunny.util.af;
import mobi.ifunny.util.p;
import retrofit.mime.TypedFile;

public class PublishGifCaptionService
        extends IntentService {
    public PublishGifCaptionService() {
        super(PublishGifCaptionService.class.getSimpleName());
    }

    private String a(RestResponse<TaskInfo> paramRestResponse) {
        if ((paramRestResponse != null) && (paramRestResponse.status == 400)) {
            return getResources().getString(2131690093);
        }
        return null;
    }

    private void a(int paramInt, String paramString) {
        af.a(this, paramInt, false, paramString);
    }

    protected void onHandleIntent(Intent paramIntent) {
        str1 = paramIntent.getStringExtra("INTENT_FILENAME");
        str2 = paramIntent.getStringExtra("INTENT_CAPTION_FILENAME");
        Object localObject1 = paramIntent.getStringExtra("INTENT_OUTPUT_FILENAME");
        float f = paramIntent.getFloatExtra("INTENT_TIMESCALE", 1.0F);
        Object localObject3 = paramIntent.getStringExtra("INTENT_TEXT");
        String str3 = paramIntent.getStringExtra("INTENT_DESCRIPTION");
        Rect localRect = (Rect) paramIntent.getParcelableExtra("INTENT_CROP");
        i = af.a();
        aw localaw = af.b(this);
        localaw.a(100, 0, false);
        bv localbv = bv.a(this);
        localbv.a(i, localaw.b());
        paramIntent = new File((String) localObject1);
        for (; ; ) {
            try {
                Object localObject4 = new BitmapFactory.Options();
                ((BitmapFactory.Options) localObject4).inPreferredConfig = Bitmap.Config.ARGB_8888;
                ((BitmapFactory.Options) localObject4).inDither = false;
                localObject4 = BitmapFactory.decodeFile(str2, (BitmapFactory.Options) localObject4);
                if (localObject4 == null) {
                    a(i, null);
                    return;
                }
                localaw.a(100, 5, false);
                localbv.a(i, localaw.b());
                int j = ((Bitmap) localObject4).getHeight();
                IntBuffer localIntBuffer = IntBuffer.allocate(((Bitmap) localObject4).getWidth() * j);
                ((Bitmap) localObject4).copyPixelsToBuffer(localIntBuffer);
                ((Bitmap) localObject4).recycle();
                j = p.a(str1, (String) localObject1, f, localRect, localIntBuffer.array(), j, new h(this, localaw, localbv, i));
                if (j > 0) {
                    a(i, getResources().getString(j));
                    return;
                }
                localaw.a(100, 90, false);
                localbv.a(i, localaw.b());
                try {
                    localObject1 = IFunnyRestRequest.Content.addGifCaptionSync("gif_caption", str3, new TypedFile("image/gif", paramIntent), (String) localObject3);
                    if ((localObject1 != null) && (((RestResponse) localObject1).status < 400) && (((RestResponse) localObject1).data != null) && (((TaskInfo) ((RestResponse) localObject1).data).id != null)) {
                        continue;
                    }
                    a(i, a((RestResponse) localObject1));
                } catch (Exception localException) {
                    a(i, null);
                    continue;
                }
                return;
            } finally {
                paramIntent.delete();
                new File(str1).delete();
                new File(str2).delete();
            }
            localaw.a(0, 0, true);
            localbv.a(i, localaw.b());
            localObject3 = new Intent(this, PublishService.class);
            ((Intent) localObject3).putExtra("arg.info", (Parcelable) ((RestResponse) localObject1).data);
            ((Intent) localObject3).putExtra("arg.notification.id", i);
            startService((Intent) localObject3);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishGifCaptionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */