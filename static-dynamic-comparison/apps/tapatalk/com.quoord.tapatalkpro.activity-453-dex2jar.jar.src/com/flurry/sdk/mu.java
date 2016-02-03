package com.flurry.sdk;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class mu
        extends mq {
    protected final mv[] d;

    protected mu(mv parammv, mv[] paramArrayOfmv) {
        super(parammv);
        this.d = paramArrayOfmv;
    }

    protected mt a(int paramInt, mv parammv) {
        this.d[paramInt] = parammv;
        return c(paramInt);
    }

    protected sh a(qr paramqr, TypeVariable<?>[] paramArrayOfTypeVariable) {
        Object localObject = paramqr;
        if (paramArrayOfTypeVariable != null) {
            localObject = paramqr;
            if (paramArrayOfTypeVariable.length > 0) {
                qr localqr = paramqr.a();
                int j = paramArrayOfTypeVariable.length;
                int i = 0;
                localObject = localqr;
                if (i < j) {
                    localObject = paramArrayOfTypeVariable[i];
                    localqr.b(((TypeVariable) localObject).getName());
                    paramqr = localObject.getBounds()[0];
                    if (paramqr == null) {
                    }
                    for (paramqr = qs.b(); ; paramqr = localqr.a(paramqr)) {
                        localqr.a(((TypeVariable) localObject).getName(), paramqr);
                        i += 1;
                        break;
                    }
                }
            }
        }
        return ((qr) localObject).a(c());
    }

    public abstract Object a(Object paramObject)
            throws Exception;

    public abstract Object a(Object[] paramArrayOfObject)
            throws Exception;

    public final <A extends Annotation> A a(Class<A> paramClass) {
        return this.b.a(paramClass);
    }

    public final void a(int paramInt, Annotation paramAnnotation) {
        mv localmv2 = this.d[paramInt];
        mv localmv1 = localmv2;
        if (localmv2 == null) {
            localmv1 = new mv();
            this.d[paramInt] = localmv1;
        }
        localmv1.b(paramAnnotation);
    }

    public final void a(Annotation paramAnnotation) {
        this.b.b(paramAnnotation);
    }

    public abstract Type b(int paramInt);

    public final void b(Annotation paramAnnotation) {
        this.b.a(paramAnnotation);
    }

    public final mt c(int paramInt) {
        return new mt(this, b(paramInt), this.d[paramInt], paramInt);
    }

    public abstract Object g()
            throws Exception;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/mu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */