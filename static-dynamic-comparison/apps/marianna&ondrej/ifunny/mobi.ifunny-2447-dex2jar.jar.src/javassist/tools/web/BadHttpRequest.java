package javassist.tools.web;

public class BadHttpRequest
        extends Exception {
    private Exception e;

    public BadHttpRequest() {
        this.e = null;
    }

    public BadHttpRequest(Exception paramException) {
        this.e = paramException;
    }

    public String toString() {
        if (this.e == null) {
            return super.toString();
        }
        return this.e.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/tools/web/BadHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */