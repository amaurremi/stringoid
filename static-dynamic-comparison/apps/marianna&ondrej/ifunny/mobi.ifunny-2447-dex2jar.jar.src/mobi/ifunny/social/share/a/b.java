package mobi.ifunny.social.share.a;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.widget.WebDialog.OnCompleteListener;

class b
        implements WebDialog.OnCompleteListener {
    b(a parama) {
    }

    public void onComplete(Bundle paramBundle, FacebookException paramFacebookException) {
        if (paramFacebookException != null) {
            if ((paramFacebookException instanceof FacebookOperationCanceledException)) {
                a.a(this.a);
                return;
            }
            a.a(this.a, paramFacebookException);
            return;
        }
        a.b(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */