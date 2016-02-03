package mobi.ifunny.social.auth;

import mobi.ifunny.rest.content.NickAvailability;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.rest.retrofit.SimpleRestHttpHandler;

final class al
        extends SimpleRestHttpHandler<NickAvailability, RegisterActivityMain> {
    public void a(RegisterActivityMain paramRegisterActivityMain) {
    }

    public void a(RegisterActivityMain paramRegisterActivityMain, Throwable paramThrowable) {
        RegisterActivityMain.f(paramRegisterActivityMain);
    }

    public void a(RegisterActivityMain paramRegisterActivityMain, NickAvailability paramNickAvailability) {
        if (paramNickAvailability.available) {
            RegisterActivityMain.e(paramRegisterActivityMain);
            return;
        }
        RegisterActivityMain.f(paramRegisterActivityMain);
    }

    public void a(RegisterActivityMain paramRegisterActivityMain, RestError paramRestError) {
        RegisterActivityMain.f(paramRegisterActivityMain);
    }

    public void b(RegisterActivityMain paramRegisterActivityMain) {
        RegisterActivityMain.b(paramRegisterActivityMain);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */