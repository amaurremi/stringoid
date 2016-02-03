package mobi.ifunny.rest.retrofit;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.Map;
import java.util.Random;
import javax.net.ssl.SSLHandshakeException;

import mobi.ifunny.IFunnyApplication;
import mobi.ifunny.e;
import mobi.ifunny.hockeyapp.b;
import mobi.ifunny.rest.content.RestError;
import mobi.ifunny.social.auth.AuthActivity;
import mobi.ifunny.social.auth.l;

public abstract class SimpleRestHttpHandler<Result, Target>
        implements RestHttpHandler<Result, Target> {
    private static final Random random = new Random();
    private static Map<String, Integer> typicalErrors = new SimpleRestHttpHandler
    .1();

    private static String getRandomServerIsDownMessage(Resources paramResources) {
        String[] arrayOfString = paramResources.getString(2131689589).split(",");
        return paramResources.getString(2131689588, new Object[]{arrayOfString[random.nextInt(arrayOfString.length)]});
    }

    private static String getRestErrorMessage(Resources paramResources, RestError paramRestError) {
        if (typicalErrors.containsKey(paramRestError.error)) {
            return paramResources.getString(((Integer) typicalErrors.get(paramRestError.error)).intValue());
        }
        return getRandomServerIsDownMessage(paramResources);
    }

    public void onCancelCallback(Target paramTarget) {
    }

    public void onExceptionCallback(Target paramTarget, Throwable paramThrowable) {
        paramTarget = IFunnyApplication.a;
        if ((paramThrowable instanceof SSLHandshakeException)) {
        }
        for (int i = 2131689590; ; i = 2131689601) {
            if (TextUtils.equals("signed", "signed")) {
                b.a(paramThrowable);
            }
            Toast.makeText(paramTarget, i, 0).show();
            return;
        }
    }

    protected boolean onFailureAuthorization(Target paramTarget, RestError paramRestError) {
        if ((paramTarget instanceof Fragment)) {
            paramTarget = ((Fragment) paramTarget).getActivity();
        }
        for (; ; ) {
            if (paramTarget != null) {
                paramTarget.startActivity(new Intent(paramTarget, AuthActivity.class));
                return true;
                if ((paramTarget instanceof k)) {
                    paramTarget = (k) paramTarget;
                }
            } else {
                return false;
            }
            paramTarget = null;
        }
    }

    public void onFailureCallback(Target paramTarget, RestError paramRestError) {
        if (paramRestError.status == 401) {
            l.a().b(IFunnyApplication.a);
            if (onFailureAuthorization(paramTarget, paramRestError)) {
                return;
            }
        }
        onFailureCommon(paramTarget, paramRestError);
    }

    protected void onFailureCommon(Target paramTarget, RestError paramRestError) {
        paramTarget = getRestErrorMessage(IFunnyApplication.a.getResources(), paramRestError);
        Toast.makeText(IFunnyApplication.a, paramTarget, 0).show();
    }

    public void onFinishCallback(Target paramTarget) {
    }

    public void onProgressCallback(Target paramTarget, int paramInt) {
    }

    public void onStartCallback(Target paramTarget) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/SimpleRestHttpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */