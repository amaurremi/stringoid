package retrofit;

import java.lang.reflect.Type;

import rx.Observable;

final class RestMethodInfo$RxSupport {
    public static Type getObservableType(Type paramType, Class paramClass) {
        return Types.getSupertype(paramType, paramClass, Observable.class);
    }

    public static boolean isObservable(Class paramClass) {
        return paramClass == Observable.class;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/retrofit/RestMethodInfo$RxSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */