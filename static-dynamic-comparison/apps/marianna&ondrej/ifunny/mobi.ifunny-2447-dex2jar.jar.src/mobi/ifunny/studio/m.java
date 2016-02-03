package mobi.ifunny.studio;

import android.app.Activity;
import android.util.SparseArray;
import mobi.ifunny.studio.caption.CaptionEditorActivity;
import mobi.ifunny.studio.comics.RageEditorActivity;
import mobi.ifunny.studio.gif.GifCaptionActivity;
import mobi.ifunny.studio.gif.UploadGifActivity;
import mobi.ifunny.studio.image.UploadImageActivity;
import mobi.ifunny.studio.meme.MemeEditorActivity;
import mobi.ifunny.studio.video.UploadVideoActivity;

final class m
        extends SparseArray<Class<? extends Activity>> {
    m() {
        put(2131493304, GifCaptionActivity.class);
        put(2131493305, CaptionEditorActivity.class);
        put(2131493306, RageEditorActivity.class);
        put(2131493307, MemeEditorActivity.class);
        put(2131493310, UploadGifActivity.class);
        put(2131493309, UploadImageActivity.class);
        put(2131493311, UploadVideoActivity.class);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */