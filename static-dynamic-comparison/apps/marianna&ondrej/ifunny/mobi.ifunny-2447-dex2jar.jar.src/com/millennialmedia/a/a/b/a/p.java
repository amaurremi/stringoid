package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.b.ah;
import com.millennialmedia.a.a.b.f;
import com.millennialmedia.a.a.c.a;
import com.millennialmedia.a.a.i;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class p
        implements af {
    private final f a;
    private final i b;
    private final com.millennialmedia.a.a.b.s c;

    public p(f paramf, i parami, com.millennialmedia.a.a.b.s params) {
        this.a = paramf;
        this.b = parami;
        this.c = params;
    }

    private s a(j paramj, Field paramField, String paramString, a<?> parama, boolean paramBoolean1, boolean paramBoolean2) {
        return new q(this, paramString, paramBoolean1, paramBoolean2, paramj, parama, paramField, ah.a(parama.a()));
    }

    private String a(Field paramField) {
        com.millennialmedia.a.a.a.b localb = (com.millennialmedia.a.a.a.b) paramField.getAnnotation(com.millennialmedia.a.a.a.b.class);
        if (localb == null) {
            return this.b.a(paramField);
        }
        return localb.a();
    }

    private Map<String, s> a(j paramj, a<?> parama, Class<?> paramClass) {
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        if (paramClass.isInterface()) {
            return localLinkedHashMap;
        }
        Type localType1 = parama.b();
        while (paramClass != Object.class) {
            Field[] arrayOfField = paramClass.getDeclaredFields();
            int j = arrayOfField.length;
            int i = 0;
            if (i < j) {
                Object localObject = arrayOfField[i];
                boolean bool1 = a((Field) localObject, true);
                boolean bool2 = a((Field) localObject, false);
                if ((!bool1) && (!bool2)) {
                }
                do {
                    i += 1;
                    break;
                    ((Field) localObject).setAccessible(true);
                    Type localType2 = com.millennialmedia.a.a.b.b.a(parama.b(), paramClass, ((Field) localObject).getGenericType());
                    localObject = a(paramj, (Field) localObject, a((Field) localObject), a.a(localType2), bool1, bool2);
                    localObject = (s) localLinkedHashMap.put(((s) localObject).g, localObject);
                } while (localObject == null);
                throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + ((s) localObject).g);
            }
            parama = a.a(com.millennialmedia.a.a.b.b.a(parama.b(), paramClass, paramClass.getGenericSuperclass()));
            paramClass = parama.a();
        }
        return localLinkedHashMap;
    }

    public <T> ae<T> a(j paramj, a<T> parama) {
        Class localClass = parama.a();
        if (!Object.class.isAssignableFrom(localClass)) {
            return null;
        }
        return new r(this.a.a(parama), a(paramj, parama, localClass), null);
    }

    public boolean a(Field paramField, boolean paramBoolean) {
        return (!this.c.a(paramField.getType(), paramBoolean)) && (!this.c.a(paramField, paramBoolean));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */