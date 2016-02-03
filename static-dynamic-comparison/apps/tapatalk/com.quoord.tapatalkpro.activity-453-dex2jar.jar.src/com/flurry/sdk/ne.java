package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import com.flurry.org.codehaus.jackson.annotate.JsonMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public abstract interface ne<T extends ne<T>> {
    public abstract T a(JsonAutoDetect.Visibility paramVisibility);

    public abstract T a(JsonAutoDetect paramJsonAutoDetect);

    public abstract boolean a(mp parammp);

    public abstract boolean a(mq parammq);

    public abstract boolean a(mr parammr);

    public abstract T b(JsonAutoDetect.Visibility paramVisibility);

    public abstract boolean b(mr parammr);

    public abstract T c(JsonAutoDetect.Visibility paramVisibility);

    public abstract boolean c(mr parammr);

    public abstract T d(JsonAutoDetect.Visibility paramVisibility);

    public abstract T e(JsonAutoDetect.Visibility paramVisibility);

    @JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, isGetterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility = JsonAutoDetect.Visibility.ANY)
    public static class a
            implements ne<a> {
        protected static final a a = new a((JsonAutoDetect) a.class.getAnnotation(JsonAutoDetect.class));
        protected final JsonAutoDetect.Visibility b;
        protected final JsonAutoDetect.Visibility c;
        protected final JsonAutoDetect.Visibility d;
        protected final JsonAutoDetect.Visibility e;
        protected final JsonAutoDetect.Visibility f;

        public a(JsonAutoDetect.Visibility paramVisibility1, JsonAutoDetect.Visibility paramVisibility2, JsonAutoDetect.Visibility paramVisibility3, JsonAutoDetect.Visibility paramVisibility4, JsonAutoDetect.Visibility paramVisibility5) {
            this.b = paramVisibility1;
            this.c = paramVisibility2;
            this.d = paramVisibility3;
            this.e = paramVisibility4;
            this.f = paramVisibility5;
        }

        public a(JsonAutoDetect paramJsonAutoDetect) {
            JsonMethod[] arrayOfJsonMethod = paramJsonAutoDetect.value();
            JsonAutoDetect.Visibility localVisibility;
            if (a(arrayOfJsonMethod, JsonMethod.GETTER)) {
                localVisibility = paramJsonAutoDetect.getterVisibility();
                this.b = localVisibility;
                if (!a(arrayOfJsonMethod, JsonMethod.IS_GETTER)) {
                    break label129;
                }
                localVisibility = paramJsonAutoDetect.isGetterVisibility();
                label50:
                this.c = localVisibility;
                if (!a(arrayOfJsonMethod, JsonMethod.SETTER)) {
                    break label136;
                }
                localVisibility = paramJsonAutoDetect.setterVisibility();
                label72:
                this.d = localVisibility;
                if (!a(arrayOfJsonMethod, JsonMethod.CREATOR)) {
                    break label143;
                }
                localVisibility = paramJsonAutoDetect.creatorVisibility();
                label94:
                this.e = localVisibility;
                if (!a(arrayOfJsonMethod, JsonMethod.FIELD)) {
                    break label150;
                }
            }
            label129:
            label136:
            label143:
            label150:
            for (paramJsonAutoDetect = paramJsonAutoDetect.fieldVisibility(); ; paramJsonAutoDetect = JsonAutoDetect.Visibility.NONE) {
                this.f = paramJsonAutoDetect;
                return;
                localVisibility = JsonAutoDetect.Visibility.NONE;
                break;
                localVisibility = JsonAutoDetect.Visibility.NONE;
                break label50;
                localVisibility = JsonAutoDetect.Visibility.NONE;
                break label72;
                localVisibility = JsonAutoDetect.Visibility.NONE;
                break label94;
            }
        }

        public static a a() {
            return a;
        }

        private static boolean a(JsonMethod[] paramArrayOfJsonMethod, JsonMethod paramJsonMethod) {
            boolean bool2 = false;
            int j = paramArrayOfJsonMethod.length;
            int i = 0;
            for (; ; ) {
                boolean bool1 = bool2;
                if (i < j) {
                    JsonMethod localJsonMethod = paramArrayOfJsonMethod[i];
                    if ((localJsonMethod == paramJsonMethod) || (localJsonMethod == JsonMethod.ALL)) {
                        bool1 = true;
                    }
                } else {
                    return bool1;
                }
                i += 1;
            }
        }

        public boolean a(mp parammp) {
            return a(parammp.e());
        }

        public boolean a(mq parammq) {
            return a(parammq.i());
        }

        public boolean a(mr parammr) {
            return a(parammr.e());
        }

        public boolean a(Field paramField) {
            return this.f.isVisible(paramField);
        }

        public boolean a(Member paramMember) {
            return this.e.isVisible(paramMember);
        }

        public boolean a(Method paramMethod) {
            return this.b.isVisible(paramMethod);
        }

        public a b(JsonAutoDetect paramJsonAutoDetect) {
            if (paramJsonAutoDetect == null) {
                return this;
            }
            JsonMethod[] arrayOfJsonMethod = paramJsonAutoDetect.value();
            Object localObject;
            if (a(arrayOfJsonMethod, JsonMethod.GETTER)) {
                localObject = paramJsonAutoDetect.getterVisibility();
                a locala = f((JsonAutoDetect.Visibility) localObject);
                if (!a(arrayOfJsonMethod, JsonMethod.IS_GETTER)) {
                    break label141;
                }
                localObject = paramJsonAutoDetect.isGetterVisibility();
                label54:
                locala = locala.g((JsonAutoDetect.Visibility) localObject);
                if (!a(arrayOfJsonMethod, JsonMethod.SETTER)) {
                    break label148;
                }
                localObject = paramJsonAutoDetect.setterVisibility();
                label79:
                locala = locala.h((JsonAutoDetect.Visibility) localObject);
                if (!a(arrayOfJsonMethod, JsonMethod.CREATOR)) {
                    break label155;
                }
                localObject = paramJsonAutoDetect.creatorVisibility();
                label104:
                localObject = locala.i((JsonAutoDetect.Visibility) localObject);
                if (!a(arrayOfJsonMethod, JsonMethod.FIELD)) {
                    break label162;
                }
            }
            label141:
            label148:
            label155:
            label162:
            for (paramJsonAutoDetect = paramJsonAutoDetect.fieldVisibility(); ; paramJsonAutoDetect = JsonAutoDetect.Visibility.NONE) {
                return ((a) localObject).j(paramJsonAutoDetect);
                localObject = JsonAutoDetect.Visibility.NONE;
                break;
                localObject = JsonAutoDetect.Visibility.NONE;
                break label54;
                localObject = JsonAutoDetect.Visibility.NONE;
                break label79;
                localObject = JsonAutoDetect.Visibility.NONE;
                break label104;
            }
        }

        public boolean b(mr parammr) {
            return b(parammr.e());
        }

        public boolean b(Method paramMethod) {
            return this.c.isVisible(paramMethod);
        }

        public boolean c(mr parammr) {
            return c(parammr.e());
        }

        public boolean c(Method paramMethod) {
            return this.d.isVisible(paramMethod);
        }

        public a f(JsonAutoDetect.Visibility paramVisibility) {
            if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
                paramVisibility = a.b;
            }
            for (; ; ) {
                if (this.b == paramVisibility) {
                    return this;
                }
                return new a(paramVisibility, this.c, this.d, this.e, this.f);
            }
        }

        public a g(JsonAutoDetect.Visibility paramVisibility) {
            if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
                paramVisibility = a.c;
            }
            for (; ; ) {
                if (this.c == paramVisibility) {
                    return this;
                }
                return new a(this.b, paramVisibility, this.d, this.e, this.f);
            }
        }

        public a h(JsonAutoDetect.Visibility paramVisibility) {
            if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
                paramVisibility = a.d;
            }
            for (; ; ) {
                if (this.d == paramVisibility) {
                    return this;
                }
                return new a(this.b, this.c, paramVisibility, this.e, this.f);
            }
        }

        public a i(JsonAutoDetect.Visibility paramVisibility) {
            if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
                paramVisibility = a.e;
            }
            for (; ; ) {
                if (this.e == paramVisibility) {
                    return this;
                }
                return new a(this.b, this.c, this.d, paramVisibility, this.f);
            }
        }

        public a j(JsonAutoDetect.Visibility paramVisibility) {
            if (paramVisibility == JsonAutoDetect.Visibility.DEFAULT) {
                paramVisibility = a.f;
            }
            for (; ; ) {
                if (this.f == paramVisibility) {
                    return this;
                }
                return new a(this.b, this.c, this.d, this.e, paramVisibility);
            }
        }

        public String toString() {
            return "[Visibility:" + " getter: " + this.b + ", isGetter: " + this.c + ", setter: " + this.d + ", creator: " + this.e + ", field: " + this.f + "]";
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */