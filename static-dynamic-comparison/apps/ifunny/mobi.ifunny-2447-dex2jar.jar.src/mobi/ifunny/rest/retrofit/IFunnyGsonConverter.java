package mobi.ifunny.rest.retrofit;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import retrofit.converter.GsonConverter;
import retrofit.mime.TypedInput;

public class IFunnyGsonConverter
        extends GsonConverter {
    public IFunnyGsonConverter(Gson paramGson) {
        super(paramGson);
    }

    public Object fromBody(TypedInput paramTypedInput, Type paramType) {
        paramTypedInput = super.fromBody(paramTypedInput, paramType);
        if ((paramTypedInput instanceof RestResponse)) {
            paramType = ((RestResponse) paramTypedInput).data;
            if ((paramType instanceof IFunnyGsonConverter.OnCreatedByGsonListener)) {
                ((IFunnyGsonConverter.OnCreatedByGsonListener) paramType).onCreatedByGson();
            }
        }
        return paramTypedInput;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/IFunnyGsonConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */