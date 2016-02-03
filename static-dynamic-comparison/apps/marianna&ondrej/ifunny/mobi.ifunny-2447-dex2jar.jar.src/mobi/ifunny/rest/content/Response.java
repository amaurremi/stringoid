package mobi.ifunny.rest.content;

public class Response<R> {
    private Error error;
    private R response;

    public Error getError() {
        return this.error;
    }

    public R getResponse() {
        return (R) this.response;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */