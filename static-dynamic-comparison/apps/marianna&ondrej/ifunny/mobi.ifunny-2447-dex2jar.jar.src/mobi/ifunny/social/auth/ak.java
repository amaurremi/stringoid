package mobi.ifunny.social.auth;

import android.widget.Toast;
import mobi.ifunny.rest.content.NickAvailability;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class ak
        extends SimpleRestHttpHandler<NickAvailability, RegisterActivityMain> {
    public void a(RegisterActivityMain paramRegisterActivityMain) {
        paramRegisterActivityMain.b("CHECK_NICK_TAG");
    }

    public void a(RegisterActivityMain paramRegisterActivityMain, Throwable paramThrowable) {
        paramRegisterActivityMain.q();
    }

    public void a(RegisterActivityMain paramRegisterActivityMain, NickAvailability paramNickAvailability) {
        paramRegisterActivityMain.q();
        RegisterActivityMain.g(paramRegisterActivityMain);
        if (!paramNickAvailability.available) {
            RegisterActivityMain.f(paramRegisterActivityMain);
        }
    }

    public void a(RegisterActivityMain paramRegisterActivityMain, RestError paramRestError) {
        paramRegisterActivityMain.q();
        Toast.makeText(paramRegisterActivityMain, paramRestError.errorMessage, 0).show();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */