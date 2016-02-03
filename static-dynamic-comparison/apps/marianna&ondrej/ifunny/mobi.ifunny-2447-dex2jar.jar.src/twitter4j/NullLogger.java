package twitter4j;

final class NullLogger
        extends Logger {
    public void debug(String paramString) {
    }

    public void debug(String paramString1, String paramString2) {
    }

    public void error(String paramString) {
    }

    public void error(String paramString, Throwable paramThrowable) {
    }

    public void info(String paramString) {
    }

    public void info(String paramString1, String paramString2) {
    }

    public boolean isDebugEnabled() {
        return false;
    }

    public boolean isErrorEnabled() {
        return false;
    }

    public boolean isInfoEnabled() {
        return false;
    }

    public boolean isWarnEnabled() {
        return false;
    }

    public void warn(String paramString) {
    }

    public void warn(String paramString1, String paramString2) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/NullLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */