package retrofit;

enum RequestInterceptorTape$Command$3 {
    RequestInterceptorTape$Command$3() {
        super(paramString,paramInt,null);
    }

    public void intercept(RequestInterceptor.RequestFacade paramRequestFacade, String paramString1, String paramString2) {
        paramRequestFacade.addEncodedPathParam(paramString1, paramString2);
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RequestInterceptorTape$Command$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */