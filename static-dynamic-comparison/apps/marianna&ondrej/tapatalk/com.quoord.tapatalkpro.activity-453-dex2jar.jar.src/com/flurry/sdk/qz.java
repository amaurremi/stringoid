package com.flurry.sdk;

import java.lang.reflect.Array;

public class qz {
    public static Object a(Object paramObject) {
        new Object() {
            public boolean equals(Object paramAnonymousObject) {
                boolean bool2 = false;
                boolean bool1;
                if (paramAnonymousObject == this) {
                    bool1 = true;
                }
                do {
                    do {
                        do {
                            return bool1;
                            bool1 = bool2;
                        } while (paramAnonymousObject == null);
                        bool1 = bool2;
                    } while (paramAnonymousObject.getClass() != this.a.getClass());
                    bool1 = bool2;
                } while (Array.getLength(paramAnonymousObject) != this.b);
                int i = 0;
                if (i < this.b) {
                    Object localObject1 = Array.get(this.a, i);
                    Object localObject2 = Array.get(paramAnonymousObject, i);
                    if (localObject1 == localObject2) {
                    }
                    while ((localObject1 == null) || (localObject1.equals(localObject2))) {
                        i += 1;
                        break;
                    }
                    return false;
                }
                return true;
            }
        };
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/qz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */