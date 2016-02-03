package com.flurry.sdk;

import java.util.HashMap;

public final class ox {
    private HashMap<a, jk<Object>> a = new HashMap(64);
    private ow b = null;

    public jk<Object> a(sh paramsh) {
        try {
            paramsh = (jk) this.a.get(new a(paramsh, false));
            return paramsh;
        } finally {
        }
    }

    public jk<Object> a(Class<?> paramClass) {
        try {
            paramClass = (jk) this.a.get(new a(paramClass, false));
            return paramClass;
        } finally {
        }
    }

    public ow a() {
        try {
            ow localow2 = this.b;
            ow localow1 = localow2;
            if (localow2 == null) {
                localow1 = ow.a(this.a);
                this.b = localow1;
            }
            return localow1.a();
        } finally {
        }
    }

    public void a(sh paramsh, jk<Object> paramjk) {
        try {
            if (this.a.put(new a(paramsh, true), paramjk) == null) {
                this.b = null;
            }
            return;
        } finally {
        }
    }

    public void a(sh paramsh, jk<Object> paramjk, jw paramjw)
            throws jh {
        try {
            if (this.a.put(new a(paramsh, false), paramjk) == null) {
                this.b = null;
            }
            if ((paramjk instanceof jt)) {
                ((jt) paramjk).a(paramjw);
            }
            return;
        } finally {
        }
    }

    public void a(Class<?> paramClass, jk<Object> paramjk) {
        try {
            if (this.a.put(new a(paramClass, true), paramjk) == null) {
                this.b = null;
            }
            return;
        } finally {
        }
    }

    public void a(Class<?> paramClass, jk<Object> paramjk, jw paramjw)
            throws jh {
        try {
            if (this.a.put(new a(paramClass, false), paramjk) == null) {
                this.b = null;
            }
            if ((paramjk instanceof jt)) {
                ((jt) paramjk).a(paramjw);
            }
            return;
        } finally {
        }
    }

    public jk<Object> b(sh paramsh) {
        try {
            paramsh = (jk) this.a.get(new a(paramsh, true));
            return paramsh;
        } finally {
        }
    }

    public jk<Object> b(Class<?> paramClass) {
        try {
            paramClass = (jk) this.a.get(new a(paramClass, true));
            return paramClass;
        } finally {
        }
    }

    public static final class a {
        protected int a;
        protected Class<?> b;
        protected sh c;
        protected boolean d;

        public a(sh paramsh, boolean paramBoolean) {
            this.c = paramsh;
            this.b = null;
            this.d = paramBoolean;
            this.a = a(paramsh, paramBoolean);
        }

        public a(Class<?> paramClass, boolean paramBoolean) {
            this.b = paramClass;
            this.c = null;
            this.d = paramBoolean;
            this.a = a(paramClass, paramBoolean);
        }

        private static final int a(sh paramsh, boolean paramBoolean) {
            int j = paramsh.hashCode() - 1;
            int i = j;
            if (paramBoolean) {
                i = j - 1;
            }
            return i;
        }

        private static final int a(Class<?> paramClass, boolean paramBoolean) {
            int j = paramClass.getName().hashCode();
            int i = j;
            if (paramBoolean) {
                i = j + 1;
            }
            return i;
        }

        public void a(sh paramsh) {
            this.c = paramsh;
            this.b = null;
            this.d = true;
            this.a = a(paramsh, true);
        }

        public void a(Class<?> paramClass) {
            this.c = null;
            this.b = paramClass;
            this.d = true;
            this.a = a(paramClass, true);
        }

        public void b(sh paramsh) {
            this.c = paramsh;
            this.b = null;
            this.d = false;
            this.a = a(paramsh, false);
        }

        public void b(Class<?> paramClass) {
            this.c = null;
            this.b = paramClass;
            this.d = false;
            this.a = a(paramClass, false);
        }

        public final boolean equals(Object paramObject) {
            if (paramObject == this) {
            }
            do {
                return true;
                paramObject = (a) paramObject;
                if (((a) paramObject).d != this.d) {
                    break label55;
                }
                if (this.b == null) {
                    break;
                }
            } while (((a) paramObject).b == this.b);
            return false;
            return this.c.equals(((a) paramObject).c);
            label55:
            return false;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            if (this.b != null) {
                return "{class: " + this.b.getName() + ", typed? " + this.d + "}";
            }
            return "{type: " + this.c + ", typed? " + this.d + "}";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */