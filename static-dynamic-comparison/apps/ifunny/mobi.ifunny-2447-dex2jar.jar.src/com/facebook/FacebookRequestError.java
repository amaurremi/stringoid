package com.facebook;

import com.facebook.android.R.string;
import com.facebook.internal.Utility;

import java.net.HttpURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int EC_APP_NOT_INSTALLED = 458;
    private static final int EC_APP_TOO_MANY_CALLS = 4;
    private static final int EC_EXPIRED = 463;
    private static final int EC_INVALID_SESSION = 102;
    private static final int EC_INVALID_TOKEN = 190;
    private static final int EC_PASSWORD_CHANGED = 460;
    private static final int EC_PERMISSION_DENIED = 10;
    private static final FacebookRequestError.Range EC_RANGE_PERMISSION = new FacebookRequestError.Range(200, 299, null);
    private static final int EC_SERVICE_UNAVAILABLE = 2;
    private static final int EC_UNCONFIRMED_USER = 464;
    private static final int EC_UNKNOWN_ERROR = 1;
    private static final int EC_USER_CHECKPOINTED = 459;
    private static final int EC_USER_TOO_MANY_CALLS = 17;
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    private static final FacebookRequestError.Range HTTP_RANGE_CLIENT_ERROR = new FacebookRequestError.Range(400, 499, null);
    private static final FacebookRequestError.Range HTTP_RANGE_SERVER_ERROR = new FacebookRequestError.Range(500, 599, null);
    private static final FacebookRequestError.Range HTTP_RANGE_SUCCESS = new FacebookRequestError.Range(200, 299, null);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private static final int INVALID_MESSAGE_ID = 0;
    private final Object batchRequestResult;
    private final FacebookRequestError.Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final boolean errorIsTransient;
    private final String errorMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final boolean shouldNotifyUser;
    private final int subErrorCode;
    private final int userActionMessageId;

    private FacebookRequestError(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, JSONObject paramJSONObject1, JSONObject paramJSONObject2, Object paramObject, HttpURLConnection paramHttpURLConnection) {
        this(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramJSONObject1, paramJSONObject2, paramObject, paramHttpURLConnection, null);
    }

    private FacebookRequestError(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, JSONObject paramJSONObject1, JSONObject paramJSONObject2, Object paramObject, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException) {
        this.requestStatusCode = paramInt1;
        this.errorCode = paramInt2;
        this.subErrorCode = paramInt3;
        this.errorType = paramString1;
        this.errorMessage = paramString2;
        this.requestResultBody = paramJSONObject1;
        this.requestResult = paramJSONObject2;
        this.batchRequestResult = paramObject;
        this.connection = paramHttpURLConnection;
        this.errorUserTitle = paramString3;
        this.errorUserMessage = paramString4;
        this.errorIsTransient = paramBoolean;
        int i;
        int j;
        if (paramFacebookException != null) {
            this.exception = paramFacebookException;
            i = 1;
            paramString1 = null;
            j = 0;
            if (i == 0) {
                break label159;
            }
            paramString1 = FacebookRequestError.Category.CLIENT;
            paramInt1 = 0;
        }
        for (; ; ) {
            label105:
            if ((paramString4 != null) && (paramString4.length() > 0)) {
            }
            for (paramBoolean = true; ; paramBoolean = false) {
                this.category = paramString1;
                this.userActionMessageId = paramInt1;
                this.shouldNotifyUser = paramBoolean;
                return;
                this.exception = new FacebookServiceException(this, paramString2);
                i = 0;
                break;
                label159:
                if ((paramInt2 == 1) || (paramInt2 == 2)) {
                    paramString1 = FacebookRequestError.Category.SERVER;
                    i = j;
                }
                for (; ; ) {
                    if (paramString1 != null) {
                        break label388;
                    }
                    if (!HTTP_RANGE_CLIENT_ERROR.contains(paramInt1)) {
                        break label350;
                    }
                    paramString1 = FacebookRequestError.Category.BAD_REQUEST;
                    paramInt1 = i;
                    break;
                    if ((paramInt2 == 4) || (paramInt2 == 17)) {
                        paramString1 = FacebookRequestError.Category.THROTTLING;
                        i = j;
                    } else if ((paramInt2 == 10) || (EC_RANGE_PERMISSION.contains(paramInt2))) {
                        paramString1 = FacebookRequestError.Category.PERMISSION;
                        i = R.string.com_facebook_requesterror_permissions;
                    } else if (paramInt2 != 102) {
                        i = j;
                        if (paramInt2 != 190) {
                        }
                    } else if ((paramInt3 == 459) || (paramInt3 == 464)) {
                        paramString1 = FacebookRequestError.Category.AUTHENTICATION_RETRY;
                        i = R.string.com_facebook_requesterror_web_login;
                    } else {
                        paramString1 = FacebookRequestError.Category.AUTHENTICATION_REOPEN_SESSION;
                        if ((paramInt3 == 458) || (paramInt3 == 463)) {
                            i = R.string.com_facebook_requesterror_relogin;
                        } else if (paramInt3 == 460) {
                            i = R.string.com_facebook_requesterror_password_changed;
                        } else {
                            i = R.string.com_facebook_requesterror_reconnect;
                        }
                    }
                }
                label350:
                if (HTTP_RANGE_SERVER_ERROR.contains(paramInt1)) {
                    paramString1 = FacebookRequestError.Category.SERVER;
                    paramInt1 = i;
                    break label105;
                }
                paramString1 = FacebookRequestError.Category.OTHER;
                paramInt1 = i;
                break label105;
            }
            label388:
            paramInt1 = i;
        }
    }

    public FacebookRequestError(int paramInt, String paramString1, String paramString2) {
        this(-1, paramInt, -1, paramString1, paramString2, null, null, false, null, null, null, null, null);
    }

    FacebookRequestError(HttpURLConnection paramHttpURLConnection, Exception paramException) {
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject paramJSONObject, Object paramObject, HttpURLConnection paramHttpURLConnection) {
        for (; ; ) {
            try {
                if (paramJSONObject.has("code")) {
                    int m = paramJSONObject.getInt("code");
                    localObject1 = Utility.getStringPropertyAsJSON(paramJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                    if ((localObject1 != null) && ((localObject1 instanceof JSONObject))) {
                        JSONObject localJSONObject2 = (JSONObject) localObject1;
                        localObject1 = null;
                        String str = null;
                        JSONObject localJSONObject1 = null;
                        Object localObject4 = null;
                        boolean bool2 = false;
                        int j = -1;
                        int k = -1;
                        int i = 0;
                        Object localObject2;
                        Object localObject3;
                        boolean bool1;
                        if (localJSONObject2.has("error")) {
                            localJSONObject1 = (JSONObject) Utility.getStringPropertyAsJSON(localJSONObject2, "error", null);
                            localObject1 = localJSONObject1.optString("type", null);
                            str = localJSONObject1.optString("message", null);
                            j = localJSONObject1.optInt("code", -1);
                            k = localJSONObject1.optInt("error_subcode", -1);
                            localObject2 = localJSONObject1.optString("error_user_msg", null);
                            localObject3 = localJSONObject1.optString("error_user_title", null);
                            bool1 = localJSONObject1.optBoolean("is_transient", false);
                            i = 1;
                            if (i != 0) {
                                return new FacebookRequestError(m, j, k, (String) localObject1, str, (String) localObject3, (String) localObject2, bool1, localJSONObject2, paramJSONObject, paramObject, paramHttpURLConnection);
                            }
                        } else {
                            if ((!localJSONObject2.has("error_code")) && (!localJSONObject2.has("error_msg"))) {
                                localObject3 = localObject4;
                                localObject2 = localJSONObject1;
                                bool1 = bool2;
                                if (!localJSONObject2.has("error_reason")) {
                                    continue;
                                }
                            }
                            localObject1 = localJSONObject2.optString("error_reason", null);
                            str = localJSONObject2.optString("error_msg", null);
                            j = localJSONObject2.optInt("error_code", -1);
                            k = localJSONObject2.optInt("error_subcode", -1);
                            i = 1;
                            localObject3 = localObject4;
                            localObject2 = localJSONObject1;
                            bool1 = bool2;
                            continue;
                        }
                    }
                    if (!HTTP_RANGE_SUCCESS.contains(m)) {
                        if (!paramJSONObject.has("body")) {
                            break label357;
                        }
                        localObject1 = (JSONObject) Utility.getStringPropertyAsJSON(paramJSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                        paramJSONObject = new FacebookRequestError(m, -1, -1, null, null, null, null, false, (JSONObject) localObject1, paramJSONObject, paramObject, paramHttpURLConnection);
                        return paramJSONObject;
                    }
                }
            } catch (JSONException paramJSONObject) {
            }
            return null;
            label357:
            Object localObject1 = null;
        }
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public FacebookRequestError.Category getCategory() {
        return this.category;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean getErrorIsTransient() {
        return this.errorIsTransient;
    }

    public String getErrorMessage() {
        if (this.errorMessage != null) {
            return this.errorMessage;
        }
        return this.exception.getLocalizedMessage();
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public int getUserActionMessageId() {
        return this.userActionMessageId;
    }

    public boolean shouldNotifyUser() {
        return this.shouldNotifyUser;
    }

    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookRequestError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */