package org.b.d.a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.b.d.aj;
import org.b.d.al;

public class j
        extends a {
    private static Logger b = Logger.getLogger(h.class.getName());

    public j(al paramal, ClassLoader paramClassLoader) {
        super(paramal);
    }

    public <T> aj<T> a(Class<T> paramClass, f[] paramArrayOff) {
        if (paramArrayOff == null) {
            throw new NullPointerException("entries is null: " + paramClass);
        }
        return new l(paramClass, a(paramArrayOff));
    }

    protected m[] a(f[] paramArrayOff) {
        int j = paramArrayOff.length;
        int i = 0;
        while (i < j) {
            localObject = ((e) paramArrayOff[i]).a();
            if (!Modifier.isPublic(((Field) localObject).getModifiers())) {
                ((Field) localObject).setAccessible(true);
            }
            i += 1;
        }
        Object localObject = new m[paramArrayOff.length];
        i = 0;
        while (i < paramArrayOff.length) {
            f localf = paramArrayOff[i];
            localObject[i] = new k(localf, this.a.a(localf.d()));
            i += 1;
        }
        return (m[]) localObject;
    }

    public boolean b(Type paramType, boolean paramBoolean) {
        paramType = (Class) paramType;
        paramBoolean = a(paramType, paramBoolean);
        if ((paramBoolean) && (b.isLoggable(Level.FINE))) {
            b.fine("matched type: " + paramType.getName());
        }
        return paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */