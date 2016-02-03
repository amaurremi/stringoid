package mobi.ifunny.rest.retrofit;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import mobi.ifunny.h;

public class RestService
        extends IntentService {
    public static final String ACTION_APP_PUSH = "mobi.ifunny.app.push";
    public static final String APP_PUSH_ID = "app.put_push.id";
    public static final String APP_PUSH_TYPE = "app.put_push.type";
    private static final String TAG = RestService.class.getSimpleName();

    public RestService() {
        super(TAG);
    }

    protected void onHandleIntent(Intent paramIntent) {
        String str;
        if ("mobi.ifunny.app.push".equals(paramIntent.getAction())) {
            str = paramIntent.getStringExtra("app.put_push.id");
            paramIntent = paramIntent.getStringExtra("app.put_push.type");
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent))) {
                break label41;
            }
        }
        label41:
        while (IFunnyRestRequest.App.pushTokenPut(paramIntent, str) == null) {
            return;
        }
        h.a().b("pref.push.registration_id_sent", true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/RestService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */