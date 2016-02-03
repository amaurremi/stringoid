package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.Utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class NativeProtocol {
    static final String ACTION_LOGIN_DIALOG = "com.facebook.platform.action.request.LOGIN_DIALOG";
    static final String ACTION_LOGIN_DIALOG_REPLY = "com.facebook.platform.action.reply.LOGIN_DIALOG";
    static final String AUDIENCE_EVERYONE = "EVERYONE";
    static final String AUDIENCE_FRIENDS = "ALL_FRIENDS";
    static final String AUDIENCE_ME = "SELF";
    private static final String BASIC_INFO = "basic_info";
    static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    static final String ERROR_NETWORK_ERROR = "NetworkError";
    static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    static final String ERROR_USER_CANCELED = "UserCanceled";
    static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    static final String EXTRA_WRITE_PRIVACY = "com.facebook.platform.extra.WRITE_PRIVACY";
    static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    static final String KATANA_PACKAGE = "com.facebook.katana";
    static final String KATANA_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String KATANA_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String KATANA_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    static final String KATANA_SIGNATURE = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
    static final String KATANA_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    static final int PROTOCOL_VERSION_20121101 = 20121101;
    static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";

    static Intent createLoginDialog20121101Intent(Context paramContext, String paramString1, ArrayList<String> paramArrayList, String paramString2) {
        return validateKatanaActivityIntent(paramContext, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").addCategory("android.intent.category.DEFAULT").putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.LOGIN_DIALOG").putExtra("com.facebook.platform.extra.APPLICATION_ID", paramString1).putStringArrayListExtra("com.facebook.platform.extra.PERMISSIONS", ensureDefaultPermissions(paramArrayList)).putExtra("com.facebook.platform.extra.WRITE_PRIVACY", ensureDefaultAudience(paramString2)));
    }

    static Intent createProxyAuthIntent(Context paramContext, String paramString, List<String> paramList) {
        paramString = new Intent().setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth").putExtra("client_id", paramString);
        if (!Utility.isNullOrEmpty(paramList)) {
            paramString.putExtra("scope", TextUtils.join(",", paramList));
        }
        return validateKatanaActivityIntent(paramContext, paramString);
    }

    static Intent createTokenRefreshIntent(Context paramContext) {
        Intent localIntent = new Intent();
        localIntent.setClassName("com.facebook.katana", "com.facebook.katana.platform.TokenRefreshService");
        return validateKatanaServiceIntent(paramContext, localIntent);
    }

    private static String ensureDefaultAudience(String paramString) {
        String str = paramString;
        if (Utility.isNullOrEmpty(paramString)) {
            str = "SELF";
        }
        return str;
    }

    private static ArrayList<String> ensureDefaultPermissions(ArrayList<String> paramArrayList) {
        ArrayList<String> localArrayList;
        if (Utility.isNullOrEmpty(paramArrayList)) {
            paramArrayList = new ArrayList();
            paramArrayList.add("basic_info");
            localArrayList = paramArrayList;
            label24:
            return localArrayList;
        }
        Iterator localIterator = paramArrayList.iterator();
        String str;
        do {
            if (!localIterator.hasNext()) {
                paramArrayList = new ArrayList(paramArrayList);
                break;
            }
            str = (String) localIterator.next();
            localArrayList = paramArrayList;
            if (Session.isPublishPermission(str)) {
                break label24;
            }
        } while (!"basic_info".equals(str));
        return paramArrayList;
    }

    static AccessTokenSource getAccessTokenSourceFromNative(Bundle paramBundle) {
        if (20121101L == paramBundle.getInt("com.facebook.platform.protocol.PROTOCOL_VERSION", 0)) {
            return AccessTokenSource.FACEBOOK_APPLICATION_NATIVE;
        }
        return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    static boolean isServiceDisabledResult20121101(Intent paramIntent) {
        boolean bool2 = false;
        int i = paramIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        paramIntent = paramIntent.getStringExtra("com.facebook.platform.status.ERROR_TYPE");
        boolean bool1 = bool2;
        if (20121101 == i) {
            bool1 = bool2;
            if ("ServiceDisabled".equals(paramIntent)) {
                bool1 = true;
            }
        }
        return bool1;
    }

    static Intent validateKatanaActivityIntent(Context paramContext, Intent paramIntent) {
        if (paramIntent == null) {
            paramIntent = null;
        }
        ResolveInfo localResolveInfo;
        do {
            return paramIntent;
            localResolveInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
            if (localResolveInfo == null) {
                return null;
            }
        } while (validateSignature(paramContext, localResolveInfo.activityInfo.packageName));
        return null;
    }

    static Intent validateKatanaServiceIntent(Context paramContext, Intent paramIntent) {
        if (paramIntent == null) {
            paramIntent = null;
        }
        ResolveInfo localResolveInfo;
        do {
            return paramIntent;
            localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
            if (localResolveInfo == null) {
                return null;
            }
        } while (validateSignature(paramContext, localResolveInfo.serviceInfo.packageName));
        return null;
    }

    static final boolean validateSignature(Context paramContext, String paramString) {
        for (; ; ) {
            int i;
            try {
                paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
                paramContext = paramContext.signatures;
                int j = paramContext.length;
                i = 0;
                if (i >= j) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException paramContext) {
                return false;
            }
            if (paramContext[i].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                return true;
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/NativeProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */