package retrofit;

enum RequestInterceptorTape$Command$4 {
    RequestInterceptorTape$Command$4() {
        super(paramString,paramInt,null);
    }

    public void intercept(RequestInterceptor.RequestFacade paramRequestFacade, String paramString1, String paramString2) {
        paramRequestFacade.addQueryParam(paramString1, paramString2);
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RequestInterceptorTape$Command$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */