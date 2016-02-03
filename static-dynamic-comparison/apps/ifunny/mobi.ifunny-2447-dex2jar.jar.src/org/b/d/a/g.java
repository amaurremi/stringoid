package org.b.d.a;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.b.d.ae;
import org.b.d.aj;
import org.b.d.al;

public class g
        extends a {
    private static final Logger b = Logger.getLogger(g.class.getName());

    public g(al paramal) {
        super(paramal);
    }

    public <T> aj<T> a(Class<T> paramClass, f[] paramArrayOff) {
        throw new UnsupportedOperationException("fatal error: " + paramClass.getName());
    }

    public <T> aj<T> a(Type paramType) {
        paramType = (Class) paramType;
        c(paramType);
        return new ae(paramType);
    }

    public boolean b(Type paramType, boolean paramBoolean) {
        paramType = (Class) paramType;
        paramBoolean = c(paramType, paramBoolean);
        if ((paramBoolean) && (b.isLoggable(Level.FINE))) {
            b.fine("matched type: " + paramType.getName());
        }
        return paramBoolean;
    }

    protected void c(Class<?> paramClass) {
        if (!paramClass.isEnum()) {
            throw new n("tried to build ordinal enum template of non-enum class: " + paramClass.getName());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */