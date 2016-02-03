package com.flurry.sdk;

import java.util.HashMap;

public class od
        extends jx.a {
    protected HashMap<qj, jk<?>> a;
    protected HashMap<qj, jk<?>> b;

    public jk<?> a(ju paramju, qk paramqk, ir paramir, is paramis, jz paramjz, jk<Object> paramjk) {
        return a(paramju, paramqk, paramir, paramis);
    }

    public jk<?> a(ju paramju, ql paramql, ir paramir, is paramis, jz paramjz, jk<Object> paramjk) {
        return a(paramju, paramql, paramir, paramis);
    }

    public jk<?> a(ju paramju, qn paramqn, ir paramir, is paramis, jk<Object> paramjk1, jz paramjz, jk<Object> paramjk2) {
        return a(paramju, paramqn, paramir, paramis);
    }

    public jk<?> a(ju paramju, qo paramqo, ir paramir, is paramis, jk<Object> paramjk1, jz paramjz, jk<Object> paramjk2) {
        return a(paramju, paramqo, paramir, paramis);
    }

    public jk<?> a(ju paramju, sh paramsh, ir paramir, is paramis) {
        paramsh = paramsh.p();
        qj localqj = new qj(paramsh);
        if (paramsh.isInterface()) {
            if (this.b == null) {
                break label116;
            }
            paramju = (jk) this.b.get(localqj);
            if (paramju == null) {
                break label116;
            }
        }
        label116:
        do {
            do {
                return paramju;
                if (this.a == null) {
                    break;
                }
                paramir = (jk) this.a.get(localqj);
                paramju = paramir;
            } while (paramir != null);
            for (paramir = paramsh; ; paramir = paramir.getSuperclass()) {
                if (paramir == null) {
                    break label116;
                }
                localqj.a(paramir);
                paramis = (jk) this.a.get(localqj);
                paramju = paramis;
                if (paramis != null) {
                    break;
                }
            }
            if (this.b == null) {
                break;
            }
            paramir = a(paramsh, localqj);
            paramju = paramir;
        } while (paramir != null);
        if (!paramsh.isInterface()) {
            paramju = paramsh;
            do {
                paramju = paramju.getSuperclass();
                if (paramju == null) {
                    break;
                }
                paramsh = a(paramju, localqj);
            } while (paramsh == null);
            return paramsh;
        }
        return null;
    }

    protected jk<?> a(Class<?> paramClass, qj paramqj) {
        Class[] arrayOfClass = paramClass.getInterfaces();
        int j = arrayOfClass.length;
        int i = 0;
        while (i < j) {
            Object localObject = arrayOfClass[i];
            paramqj.a((Class) localObject);
            paramClass = (jk) this.b.get(paramqj);
            if (paramClass != null) {
            }
            do {
                return paramClass;
                localObject = a((Class) localObject, paramqj);
                paramClass = (Class<?>) localObject;
            } while (localObject != null);
            i += 1;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/od.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */