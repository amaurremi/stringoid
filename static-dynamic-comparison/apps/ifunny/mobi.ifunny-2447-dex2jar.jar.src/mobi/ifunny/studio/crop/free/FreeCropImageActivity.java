package mobi.ifunny.studio.crop.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.f;

public class FreeCropImageActivity
        extends f {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        Object localObject = getIntent();
        boolean bool = ((Intent) localObject).getBooleanExtra("INTENT_CROP_GIFS", false);
        if (paramBundle == null) {
            paramBundle = ((Intent) localObject).getData();
            if (paramBundle == null) {
                throw new IllegalArgumentException();
            }
            localObject = f().a();
            if (!bool) {
                break label78;
            }
        }
        label78:
        for (paramBundle = FreeCropGifFragment.a(paramBundle); ; paramBundle = FreeCropImageFragment.a(paramBundle)) {
            ((ab) localObject).a(2131493009, paramBundle, "fragment");
            ((ab) localObject).b();
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/free/FreeCropImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */