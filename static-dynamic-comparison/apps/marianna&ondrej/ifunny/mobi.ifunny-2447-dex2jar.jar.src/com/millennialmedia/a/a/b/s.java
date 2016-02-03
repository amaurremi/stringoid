package com.millennialmedia.a.a.b;

import com.millennialmedia.a.a.a.c;
import com.millennialmedia.a.a.a.d;
import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.b;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class s
        implements af, Cloneable {
    public static final s a = new s();
    private double b = -1.0D;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<com.millennialmedia.a.a.a> f = Collections.emptyList();
    private List<com.millennialmedia.a.a.a> g = Collections.emptyList();

    private boolean a(c paramc) {
        return (paramc == null) || (paramc.a() <= this.b);
    }

    private boolean a(c paramc, d paramd) {
        return (a(paramc)) && (a(paramd));
    }

    private boolean a(d paramd) {
        return (paramd == null) || (paramd.a() > this.b);
    }

    private boolean a(Class<?> paramClass) {
        return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
    }

    private boolean b(Class<?> paramClass) {
        return (paramClass.isMemberClass()) && (!c(paramClass));
    }

    private boolean c(Class<?> paramClass) {
        return (paramClass.getModifiers() & 0x8) != 0;
    }

    public <T> ae<T> a(j paramj, com.millennialmedia.a.a.c.a<T> parama) {
        Class localClass = parama.a();
        boolean bool1 = a(localClass, true);
        boolean bool2 = a(localClass, false);
        if ((!bool1) && (!bool2)) {
            return null;
        }
        return new t(this, bool2, bool1, paramj, parama);
    }

    protected s a() {
        try {
            s locals = (s) super.clone();
            return locals;
        } catch (CloneNotSupportedException localCloneNotSupportedException) {
            throw new AssertionError();
        }
    }

    public boolean a(Class<?> paramClass, boolean paramBoolean) {
        if ((this.b != -1.0D) && (!a((c) paramClass.getAnnotation(c.class), (d) paramClass.getAnnotation(d.class)))) {
            return true;
        }
        if ((!this.d) && (b(paramClass))) {
            return true;
        }
        if (a(paramClass)) {
            return true;
        }
        if (paramBoolean) {
        }
        for (Object localObject = this.f; ; localObject = this.g) {
            localObject = ((List) localObject).iterator();
            do {
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
            } while (!((com.millennialmedia.a.a.a) ((Iterator) localObject).next()).a(paramClass));
            return true;
        }
        return false;
    }

    public boolean a(Field paramField, boolean paramBoolean) {
        if ((this.c & paramField.getModifiers()) != 0) {
            return true;
        }
        if ((this.b != -1.0D) && (!a((c) paramField.getAnnotation(c.class), (d) paramField.getAnnotation(d.class)))) {
            return true;
        }
        if (paramField.isSynthetic()) {
            return true;
        }
        if (this.e) {
            localObject = (com.millennialmedia.a.a.a.a) paramField.getAnnotation(com.millennialmedia.a.a.a.a.class);
            if (localObject != null) {
                if (!paramBoolean) {
                    break label97;
                }
                if (((com.millennialmedia.a.a.a.a) localObject).a()) {
                    break label106;
                }
            }
            label97:
            while (!((com.millennialmedia.a.a.a.a) localObject).b()) {
                return true;
            }
        }
        label106:
        if ((!this.d) && (b(paramField.getType()))) {
            return true;
        }
        if (a(paramField.getType())) {
            return true;
        }
        if (paramBoolean) {
        }
        for (Object localObject = this.f; !((List) localObject).isEmpty(); localObject = this.g) {
            paramField = new b(paramField);
            localObject = ((List) localObject).iterator();
            do {
                if (!((Iterator) localObject).hasNext()) {
                    break;
                }
            } while (!((com.millennialmedia.a.a.a) ((Iterator) localObject).next()).a(paramField));
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */