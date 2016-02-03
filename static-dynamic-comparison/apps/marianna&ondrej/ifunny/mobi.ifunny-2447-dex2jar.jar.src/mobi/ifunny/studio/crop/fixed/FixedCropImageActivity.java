package mobi.ifunny.studio.crop.fixed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ab;
import android.support.v4.app.q;
import mobi.ifunny.f;

public class FixedCropImageActivity
        extends f {
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903111);
        if (paramBundle == null) {
            paramBundle = getIntent();
            Uri localUri = paramBundle.getData();
            if (localUri == null) {
                throw new IllegalArgumentException();
            }
            int i = paramBundle.getIntExtra("intent.crop_shape", 0);
            int j = paramBundle.getIntExtra("intent.crop_max_w", 0);
            int k = paramBundle.getIntExtra("intent.crop_max_h", 0);
            Object localObject = paramBundle.getStringExtra("intent.crop_filename");
            paramBundle = (Bundle) localObject;
            if (localObject == null) {
                paramBundle = "crop_fixed.jpg";
            }
            localObject = f().a();
            ((ab) localObject).a(2131493009, FixedCropImageFragment.a(localUri, i, j, k, paramBundle), "fragment");
            ((ab) localObject).b();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/crop/fixed/FixedCropImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */