package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.hy;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.ia;
import com.google.android.gms.internal.ib;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.internal.h;

import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API;
    public static final Account AccountApi = new hy();
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final a TI = new hz();
    public static final Api.c<e> wx = new Api.c();
    static final Api.b<e, PlusOptions> wy = new Api.b() {
        public e a(Context paramAnonymousContext, Looper paramAnonymousLooper, fc paramAnonymousfc, Plus.PlusOptions paramAnonymousPlusOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener) {
            Object localObject = paramAnonymousPlusOptions;
            if (paramAnonymousPlusOptions == null) {
                localObject = new Plus.PlusOptions(null);
            }
            paramAnonymousPlusOptions = paramAnonymousfc.eC();
            paramAnonymousfc = paramAnonymousfc.eF();
            localObject = (String[]) ((Plus.PlusOptions) localObject).TK.toArray(new String[0]);
            String str1 = paramAnonymousContext.getPackageName();
            String str2 = paramAnonymousContext.getPackageName();
            PlusCommonExtras localPlusCommonExtras = new PlusCommonExtras();
            return new e(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, new h(paramAnonymousPlusOptions, paramAnonymousfc, (String[]) localObject, new String[0], str1, str2, null, localPlusCommonExtras));
        }

        public int getPriority() {
            return 2;
        }
    };

    static {
        API = new Api(wy, wx, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
        SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
        MomentsApi = new ia();
        PeopleApi = new ib();
    }

    public static e a(GoogleApiClient paramGoogleApiClient, Api.c<e> paramc) {
        boolean bool2 = true;
        if (paramGoogleApiClient != null) {
            bool1 = true;
            fq.b(bool1, "GoogleApiClient parameter is required.");
            fq.a(paramGoogleApiClient.isConnected(), "GoogleApiClient must be connected.");
            paramGoogleApiClient = (e) paramGoogleApiClient.a(paramc);
            if (paramGoogleApiClient == null) {
                break label55;
            }
        }
        label55:
        for (boolean bool1 = bool2; ; bool1 = false) {
            fq.a(bool1, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
            return paramGoogleApiClient;
            bool1 = false;
            break;
        }
    }

    public static final class PlusOptions
            implements Api.ApiOptions.Optional {
        final String TJ;
        final Set<String> TK;

        private PlusOptions() {
            this.TJ = null;
            this.TK = new HashSet();
        }

        private PlusOptions(Builder paramBuilder) {
            this.TJ = paramBuilder.TJ;
            this.TK = paramBuilder.TK;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static final class Builder {
            String TJ;
            final Set<String> TK = new HashSet();

            public Builder addActivityTypes(String... paramVarArgs) {
                fq.b(paramVarArgs, "activityTypes may not be null.");
                int i = 0;
                while (i < paramVarArgs.length) {
                    this.TK.add(paramVarArgs[i]);
                    i += 1;
                }
                return this;
            }

            public Plus.PlusOptions build() {
                return new Plus.PlusOptions(this, null);
            }

            public Builder setServerClientId(String paramString) {
                this.TJ = paramString;
                return this;
            }
        }
    }

    public static abstract class a<R extends Result>
            extends a.b<R, e> {
        public a() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/Plus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */