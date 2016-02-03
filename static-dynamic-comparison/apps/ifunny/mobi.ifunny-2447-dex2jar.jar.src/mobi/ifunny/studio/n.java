package mobi.ifunny.studio;

import android.app.Activity;

import java.util.HashMap;

import mobi.ifunny.studio.caption.CaptionEditorActivity;
import mobi.ifunny.studio.comics.RageEditorActivity;
import mobi.ifunny.studio.gif.GifCaptionActivity;
import mobi.ifunny.studio.gif.UploadGifActivity;
import mobi.ifunny.studio.image.UploadImageActivity;
import mobi.ifunny.studio.meme.MemeEditorActivity;
import mobi.ifunny.studio.video.UploadVideoActivity;

final class n
        extends HashMap<String, Class<? extends Activity>> {
    n() {
        put("gif_caption", GifCaptionActivity.class);
        put("caption", CaptionEditorActivity.class);
        put("rage_comics", RageEditorActivity.class);
        put("meme", MemeEditorActivity.class);
        put("upload_gif", UploadGifActivity.class);
        put("upload_image", UploadImageActivity.class);
        put("upload_video", UploadVideoActivity.class);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */