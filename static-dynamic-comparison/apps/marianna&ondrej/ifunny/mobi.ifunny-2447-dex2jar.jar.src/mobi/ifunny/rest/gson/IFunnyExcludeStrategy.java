package mobi.ifunny.rest.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class IFunnyExcludeStrategy
        implements ExclusionStrategy {
    private final Class<?>[] clazzes;

    public IFunnyExcludeStrategy(Class<?>... paramVarArgs) {
        this.clazzes = paramVarArgs;
    }

    public boolean shouldSkipClass(Class<?> paramClass) {
        boolean bool2 = false;
        Class[] arrayOfClass = this.clazzes;
        int j = arrayOfClass.length;
        int i = 0;
        for (; ; ) {
            boolean bool1 = bool2;
            if (i < j) {
                if (paramClass.equals(arrayOfClass[i])) {
                    bool1 = true;
                }
            } else {
                return bool1;
            }
            i += 1;
        }
    }

    public boolean shouldSkipField(FieldAttributes paramFieldAttributes) {
        return paramFieldAttributes.getAnnotation(Exclude.class) != null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/gson/IFunnyExcludeStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */