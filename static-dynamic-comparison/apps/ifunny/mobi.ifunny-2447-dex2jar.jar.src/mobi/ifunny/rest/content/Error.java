package mobi.ifunny.rest.content;

public class Error {
    private int error_code;
    private String error_message;

    public int getError_code() {
        return this.error_code;
    }

    public String getError_message() {
        return this.error_message;
    }

    public void setError_code(int paramInt) {
        this.error_code = paramInt;
    }

    public void setError_message(String paramString) {
        this.error_message = paramString;
    }

    public String toString() {
        return "Error [error_code=" + this.error_code + ", error_message=" + this.error_message + "]";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Error.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */