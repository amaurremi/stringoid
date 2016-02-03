package mobi.ifunny.studio.video;

import android.widget.Toast;
import com.google.gson.Gson;
import mobi.ifunny.d;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.content.YoutubeVideoResult;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class b
        extends SimpleRestHttpHandler<String, UploadVideoActivity> {
    public void a(UploadVideoActivity paramUploadVideoActivity) {
        super.onStartCallback(paramUploadVideoActivity);
        paramUploadVideoActivity.n();
    }

    public void a(UploadVideoActivity paramUploadVideoActivity, String paramString) {
        d.b(UploadVideoActivity.p(), "Youtube response:\n" + paramString);
        paramString = (YoutubeVideoResult) new Gson().fromJson(paramString, YoutubeVideoResult.class);
        if (paramString == null) {
            Toast.makeText(paramUploadVideoActivity, 2131690137, 0).show();
            return;
        }
        paramUploadVideoActivity.a(paramString.getData());
    }

    public void a(UploadVideoActivity paramUploadVideoActivity, RestError paramRestError) {
        Toast.makeText(paramUploadVideoActivity, 2131690137, 0).show();
    }

    public void b(UploadVideoActivity paramUploadVideoActivity) {
        super.onFinishCallback(paramUploadVideoActivity);
        paramUploadVideoActivity.o();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/video/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */