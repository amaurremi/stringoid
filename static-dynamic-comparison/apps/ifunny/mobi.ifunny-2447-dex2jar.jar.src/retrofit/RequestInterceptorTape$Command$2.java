package retrofit;

enum RequestInterceptorTape$Command$2 {
    RequestInterceptorTape$Command$2() {
        super(paramString,paramInt,null);
    }

    public void intercept(RequestInterceptor.RequestFacade paramRequestFacade, String paramString1, String paramString2) {
        paramRequestFacade.addPathParam(paramString1, paramString2);
    }
    }


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RequestInterceptorTape$Command$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */