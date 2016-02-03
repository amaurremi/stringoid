package twitter4j.internal.org.json;

public class JSONException
        extends Exception {
    private static final long serialVersionUID = 0L;
    private Throwable cause;

    public JSONException(String paramString) {
        super(paramString);
    }

    public JSONException(Throwable paramThrowable) {
        super(paramThrowable.getMessage());
        this.cause = paramThrowable;
    }

    public Throwable getCause() {
        return this.cause;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/org/json/JSONException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */