package mobi.ifunny.rest.retrofit;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import retrofit.RequestInterceptor;
import retrofit.RequestInterceptor.RequestFacade;

class BaseRestAdapter$BaseParamsInterceptor
        implements RequestInterceptor {
    private BaseRestAdapter$BaseParamsInterceptor(BaseRestAdapter paramBaseRestAdapter) {
    }

    public void intercept(RequestInterceptor.RequestFacade paramRequestFacade) {
        Iterator localIterator = BaseRestAdapter.access$200(this.this$0).entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            paramRequestFacade.addHeader((String) localEntry.getKey(), (String) localEntry.getValue());
        }
        if (BaseRestAdapter.access$300(this.this$0) != null) {
            paramRequestFacade.addHeader("Authorization", BaseRestAdapter.access$300(this.this$0).getAuthString());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/BaseRestAdapter$BaseParamsInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */