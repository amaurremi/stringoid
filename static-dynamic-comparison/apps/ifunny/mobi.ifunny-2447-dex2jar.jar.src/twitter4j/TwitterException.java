package twitter4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TwitterException
        extends Exception
        implements HttpResponseCode, TwitterResponse {
    private static final String[] FILTER = {"twitter4j"};
    private static final long serialVersionUID = 6006561839051121336L;
    private int errorCode = -1;
    private String errorMessage = null;
    private ExceptionDiagnosis exceptionDiagnosis = null;
    private boolean nested = false;
    private HttpResponse response;
    private int statusCode = -1;

    public TwitterException(Exception paramException) {
        this(paramException.getMessage(), paramException);
        if ((paramException instanceof TwitterException)) {
            ((TwitterException) paramException).setNested();
        }
    }

    public TwitterException(String paramString) {
        this(paramString, (Throwable) null);
    }

    public TwitterException(String paramString, Exception paramException, int paramInt) {
        this(paramString, paramException);
    }

    public TwitterException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
        decode(paramString);
    }

    public TwitterException(String paramString, HttpResponse paramHttpResponse) {
        this(paramString);
        this.response = paramHttpResponse;
    }

    private void decode(String paramString) {
        if ((paramString != null) && (paramString.startsWith("{"))) {
        }
        try {
            paramString = new JSONObject(paramString);
            if (!paramString.isNull("errors")) {
                paramString = paramString.getJSONArray("errors").getJSONObject(0);
                this.errorMessage = paramString.getString("message");
                this.errorCode = ParseUtil.getInt("code", paramString);
            }
            return;
        } catch (JSONException paramString) {
        }
    }

    private static String getCause(int paramInt) {
        String str;
        switch (paramInt) {
            default:
                str = "";
        }
        for (; ; ) {
            return paramInt + ":" + str;
            str = "There was no new data to return.";
            continue;
            str = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response.";
            continue;
            str = "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.";
            continue;
            str = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
            continue;
            str = "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.";
            continue;
            str = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
            continue;
            str = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
            continue;
            str = "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed.";
            continue;
            str = "Returned in API v1.1 when a request cannot be served due to the application's rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)";
            continue;
            str = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
            continue;
            str = "Twitter is down or being upgraded.";
            continue;
            str = "The Twitter servers are up, but overloaded with requests. Try again later.";
            continue;
            str = "The Twitter servers are up, but the request couldn't be serviced due to some failure within our stack. Try again later.";
        }
    }

    private ExceptionDiagnosis getExceptionDiagnosis() {
        if (this.exceptionDiagnosis == null) {
            this.exceptionDiagnosis = new ExceptionDiagnosis(this, FILTER);
        }
        return this.exceptionDiagnosis;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (TwitterException) paramObject;
            if (this.errorCode != ((TwitterException) paramObject).errorCode) {
                return false;
            }
            if (this.nested != ((TwitterException) paramObject).nested) {
                return false;
            }
            if (this.statusCode != ((TwitterException) paramObject).statusCode) {
                return false;
            }
            if (this.errorMessage != null) {
                if (this.errorMessage.equals(((TwitterException) paramObject).errorMessage)) {
                }
            } else {
                while (((TwitterException) paramObject).errorMessage != null) {
                    return false;
                }
            }
            if (this.exceptionDiagnosis != null) {
                if (this.exceptionDiagnosis.equals(((TwitterException) paramObject).exceptionDiagnosis)) {
                }
            } else {
                while (((TwitterException) paramObject).exceptionDiagnosis != null) {
                    return false;
                }
            }
            if (this.response == null) {
                break;
            }
        } while (this.response.equals(((TwitterException) paramObject).response));
        for (; ; ) {
            return false;
            if (((TwitterException) paramObject).response == null) {
                break;
            }
        }
    }

    public boolean exceededRateLimitation() {
        return ((this.statusCode == 400) && (getRateLimitStatus() != null)) || (this.statusCode == 420) || (this.statusCode == 429);
    }

    public int getAccessLevel() {
        return ParseUtil.toAccessLevel(this.response);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getExceptionCode() {
        return getExceptionDiagnosis().asHexString();
    }

    public String getMessage() {
        StringBuilder localStringBuilder = new StringBuilder();
        if ((this.errorMessage != null) && (this.errorCode != -1)) {
            localStringBuilder.append("message - ").append(this.errorMessage).append("\n");
            localStringBuilder.append("code - ").append(this.errorCode).append("\n");
        }
        while (this.statusCode != -1) {
            return getCause(this.statusCode) + "\n" + localStringBuilder.toString();
            localStringBuilder.append(super.getMessage());
        }
        return localStringBuilder.toString();
    }

    public RateLimitStatus getRateLimitStatus() {
        if (this.response == null) {
            return null;
        }
        return JSONImplFactory.createRateLimitStatusFromResponseHeader(this.response);
    }

    public String getResponseHeader(String paramString) {
        if (this.response != null) {
            paramString = (List) this.response.getResponseHeaderFields().get(paramString);
            if (paramString.size() > 0) {
                return (String) paramString.get(0);
            }
        }
        return null;
    }

    public int getRetryAfter() {
        int j = -1;
        Object localObject;
        int i;
        if (this.statusCode == 400) {
            localObject = getRateLimitStatus();
            i = j;
            if (localObject != null) {
                i = ((RateLimitStatus) localObject).getSecondsUntilReset();
            }
        }
        for (; ; ) {
            return i;
            i = j;
            if (this.statusCode == 420) {
                try {
                    localObject = this.response.getResponseHeader("Retry-After");
                    i = j;
                    if (localObject != null) {
                        i = Integer.valueOf((String) localObject).intValue();
                        return i;
                    }
                } catch (NumberFormatException localNumberFormatException) {
                }
            }
        }
        return -1;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        int m = 0;
        int n = this.statusCode;
        int i1 = this.errorCode;
        int i;
        int j;
        if (this.exceptionDiagnosis != null) {
            i = this.exceptionDiagnosis.hashCode();
            if (this.response == null) {
                break label105;
            }
            j = this.response.hashCode();
            label45:
            if (this.errorMessage == null) {
                break label110;
            }
        }
        label105:
        label110:
        for (int k = this.errorMessage.hashCode(); ; k = 0) {
            if (this.nested) {
                m = 1;
            }
            return (k + (j + (i + (n * 31 + i1) * 31) * 31) * 31) * 31 + m;
            i = 0;
            break;
            j = 0;
            break label45;
        }
    }

    public boolean isCausedByNetworkIssue() {
        return getCause() instanceof IOException;
    }

    public boolean isErrorMessageAvailable() {
        return this.errorMessage != null;
    }

    public boolean resourceNotFound() {
        return this.statusCode == 404;
    }

    void setNested() {
        this.nested = true;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder().append(getMessage());
        if (this.nested) {
            str = "";
            localStringBuilder = localStringBuilder.append(str).append("\nTwitterException{");
            if (!this.nested) {
                break label184;
            }
        }
        label184:
        for (String str = ""; ; str = "exceptionCode=[" + getExceptionCode() + "], ") {
            return str + "statusCode=" + this.statusCode + ", message=" + this.errorMessage + ", code=" + this.errorCode + ", retryAfter=" + getRetryAfter() + ", rateLimitStatus=" + getRateLimitStatus() + ", version=" + Version.getVersion() + '}';
            str = "\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q=" + getExceptionDiagnosis().getStackLineHashAsHex() + " or\n\thttp://www.google.co.jp/search?q=" + getExceptionDiagnosis().getLineNumberHashAsHex();
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */