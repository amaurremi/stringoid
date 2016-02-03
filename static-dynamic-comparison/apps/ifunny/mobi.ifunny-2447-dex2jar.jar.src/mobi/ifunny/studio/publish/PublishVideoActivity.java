package mobi.ifunny.studio.publish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.af;
import android.support.v4.app.ag;
import android.view.View;
import android.widget.EditText;
import com.google.gson.Gson;
import mobi.ifunny.rest.content.TaskInfo;
import mobi.ifunny.rest.content.VideoScreenshotInfo;
import mobi.ifunny.rest.content.YoutubeVideo;
import mobi.ifunny.rest.content.YoutubeVideo.YoutubeThumbnail;
import mobi.ifunny.rest.retrofit.IFunnyRestRequest.Content;
import mobi.ifunny.rest.retrofit.RestHttpHandler;
import mobi.ifunny.util.a.d;
import mobi.ifunny.view.ImageViewEx;
import mobi.ifunny.view.ProgressBar;
import mobi.ifunny.view.drawable.f;

public class PublishVideoActivity
        extends a
        implements ag<d> {
    private YoutubeVideo v;

    public void a(android.support.v4.a.l<d> paraml, d paramd) {
        if (paramd != null) {
            this.s.setVisibility(4);
            this.o.setVisibility(0);
            this.o.setImageDrawable(new f(paramd));
            this.r.setVisibility(0);
        }
    }

    protected void a(String paramString1, String paramString2, RestHttpHandler<TaskInfo, a> paramRestHttpHandler) {
        String str = this.v.getId();
        Object localObject = this.v.getThumbnail();
        VideoScreenshotInfo localVideoScreenshotInfo = new VideoScreenshotInfo("big", ((YoutubeVideo.YoutubeThumbnail) localObject).getHqDefault());
        localObject = new VideoScreenshotInfo("small", ((YoutubeVideo.YoutubeThumbnail) localObject).getSqDefault());
        IFunnyRestRequest.Content.addVideo(this, paramString1, "video", paramString2, "youtube", str, new Gson().toJson(new VideoScreenshotInfo[]{localVideoScreenshotInfo, localObject}), Integer.toString(this.v.getDuration()), paramRestHttpHandler);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.v = ((YoutubeVideo) getIntent().getParcelableExtra("intent.video"));
        if (this.v == null) {
            throw new IllegalArgumentException();
        }
        this.t.setText(this.v.getTitle());
        paramBundle = new Bundle();
        paramBundle.putParcelable("loader.image.uri", Uri.parse(this.v.getThumbnail().getBestQuality()));
        g().a(0, paramBundle, this);
    }

    public android.support.v4.a.l<d> onCreateLoader(int paramInt, Bundle paramBundle) {
        return new mobi.ifunny.e.l(this, true, (Uri) paramBundle.getParcelable("loader.image.uri"), new mobi.ifunny.util.a.a(null, false));
    }

    public void onLoaderReset(android.support.v4.a.l<d> paraml) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/publish/PublishVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */