package mobi.ifunny.social.share.a;

import android.os.Bundle;
import com.facebook.widget.FacebookDialog.Callback;
import com.facebook.widget.FacebookDialog.PendingCall;

class e
        implements FacebookDialog.Callback {
    e(d paramd) {
    }

    public void onComplete(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle) {
        d.a(this.a);
    }

    public void onError(FacebookDialog.PendingCall paramPendingCall, Exception paramException, Bundle paramBundle) {
        d.a(this.a, paramException);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/share/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */