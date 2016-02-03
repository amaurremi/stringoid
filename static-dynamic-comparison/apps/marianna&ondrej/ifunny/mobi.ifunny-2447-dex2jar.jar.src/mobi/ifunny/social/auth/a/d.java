package mobi.ifunny.social.auth.a;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.OpenRequest;
import com.facebook.Session.StatusCallback;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphObject;
import mobi.ifunny.rest.content.AccessToken;
import mobi.ifunny.social.auth.l;
import mobi.ifunny.social.auth.n;
import mobi.ifunny.social.auth.t;
import mobi.ifunny.util.ai;
import org.json.JSONException;
import org.json.JSONObject;

public class d
        extends t {
    protected final int f = 3;
    protected final int g = 4;
    private UiLifecycleHelper h;
    private Session.StatusCallback i = new e(this);
    private final String j = "TASK_GET_ME_FACEBOOK";

    private void a(Response paramResponse) {
        try {
            Object localObject = paramResponse.getGraphObject().getInnerJSONObject();
            n localn = new n();
            localObject = ((JSONObject) localObject).getString("id");
            String str = ai.a((String) localObject, Session.getActiveSession().getAccessToken());
            localn.a = ((String) localObject);
            localn.c = str;
            a(paramResponse, localn);
            b(localn);
            return;
        } catch (JSONException paramResponse) {
            a(a(paramResponse, 2131689937));
        }
    }

    private void o() {
        Bundle localBundle = new Bundle();
        a(localBundle);
        a(localBundle, new f(this), 4);
    }

    protected void a(Bundle paramBundle) {
        paramBundle.putString("fields", "id,name");
    }

    protected void a(Bundle paramBundle, h paramh, int paramInt) {
        if (this.b != 0) {
        }
        do {
            return;
            this.b = paramInt;
        } while (f("TASK_GET_ME_FACEBOOK"));
        paramBundle = new Request(Session.getActiveSession(), "me", paramBundle, HttpMethod.GET);
        new g(this, "TASK_GET_ME_FACEBOOK", paramh, null).execute(new Request[]{paramBundle});
    }

    protected void a(Response paramResponse, n paramn) {
        try {
            JSONObject localJSONObject = paramResponse.getGraphObject().getInnerJSONObject();
            paramResponse = null;
            if (localJSONObject.has("name")) {
                paramResponse = localJSONObject.getString("name");
            }
            paramn.b = paramResponse;
            return;
        } catch (JSONException paramResponse) {
            a(a(paramResponse, 2131689938));
        }
    }

    protected void a(String paramString1, String paramString2, n paramn) {
        switch (this.b) {
        }
        for (; ; ) {
            super.a(paramString1, paramString2, paramn);
            this.b = 0;
            paramString1 = Session.getActiveSession();
            if ((paramString1 != null) && (paramString1.isOpened())) {
                paramString1.close();
            }
            Session.setActiveSession(null);
            return;
            a(paramString1, paramString2);
            continue;
            a(paramString1, paramString2);
        }
    }

    protected void a(AccessToken paramAccessToken) {
        l.a().a(getActivity(), paramAccessToken, 0);
    }

    protected void b() {
        switch (this.b) {
        }
        for (; ; ) {
            super.b();
            return;
            n();
            continue;
            a(new String[]{"TASK_GET_ME_FACEBOOK"});
            continue;
            a(new String[]{"TASK_GET_ME_FACEBOOK"});
            n();
        }
    }

    protected void b(n paramn) {
        this.b = 0;
        a(paramn);
    }

    public void b(boolean paramBoolean) {
        if (this.b != 0) {
            b();
            return;
        }
        Object localObject2 = Session.getActiveSession();
        Object localObject1;
        if (localObject2 != null) {
            localObject1 = localObject2;
            if (!((Session) localObject2).isClosed()) {
            }
        } else {
            localObject1 = new Session(getActivity());
        }
        localObject2 = localObject1;
        if (!paramBoolean) {
            ((Session) localObject1).closeAndClearTokenInformation();
            localObject2 = new Session(getActivity());
        }
        this.b = 1;
        Session.setActiveSession((Session) localObject2);
        if (((Session) localObject2).isOpened()) {
            this.b = 0;
            o();
            return;
        }
        ((Session) localObject2).openForRead(new Session.OpenRequest(this));
    }

    protected int f() {
        return 2131689931;
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        this.h.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        this.h = new UiLifecycleHelper(getActivity(), this.i);
        this.h.onCreate(paramBundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.h.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.h.onPause();
    }

    public void onResume() {
        super.onResume();
        this.h.onResume();
    }

    public void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        this.h.onSaveInstanceState(paramBundle);
    }

    public void onStop() {
        super.onStop();
        this.h.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/social/auth/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */