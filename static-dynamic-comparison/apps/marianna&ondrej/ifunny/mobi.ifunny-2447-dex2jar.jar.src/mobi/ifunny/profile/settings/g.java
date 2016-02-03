package mobi.ifunny.profile.settings;

import android.text.TextUtils;
import android.widget.Toast;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class g
        extends SimpleRestHttpHandler<Void, e> {
    private String a;
    private String b;

    private g(String paramString1, String paramString2) {
        this.a = paramString1;
        this.b = paramString2;
    }

    public void a(e parame) {
        parame.l();
        super.onFinishCallback(parame);
    }

    public void a(e parame, Void paramVoid) {
        parame.a(true, this.a, this.b);
    }

    public void a(e parame, RestError paramRestError) {
        if (TextUtils.equals(paramRestError.error, "social_register_duplicate")) {
            Toast.makeText(parame.getActivity(), 2131689922, 1).show();
            return;
        }
        super.onFailureCallback(parame, paramRestError);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/profile/settings/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */