package org.b.d.a.a;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TooManyListenersException;

class n
        extends m {
    private static p m = new p(null);
    b[] a = null;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private b e = null;
    private c[] f = null;
    private h[] g = null;
    private k[] h = null;
    private a i = null;
    private Class<?> j;
    private int k = -1;
    private int l = -1;
    private boolean n;
    private boolean o;

    n(Class<?> paramClass1, b paramb, Class<?> paramClass2) {
        this.j = paramClass1;
        if (paramb != null) {
            this.e = paramb;
            this.f = paramb.c();
            this.g = paramb.b();
            this.h = paramb.a();
            this.k = paramb.g();
            if ((this.k < 0) || (this.k >= this.f.length)) {
                this.k = -1;
            }
            this.l = paramb.f();
            if ((this.l < 0) || (this.l >= this.h.length)) {
                this.l = -1;
            }
            this.a = paramb.d();
            if (this.f != null) {
                this.d = true;
            }
            if (this.g != null) {
                this.b = true;
            }
            if (this.h != null) {
                this.c = true;
            }
        }
        if (this.g == null) {
            this.g = i();
        }
        if (this.h == null) {
            this.h = a(paramClass2);
        }
        if (this.f == null) {
            this.f = j();
        }
    }

    private String a(String paramString) {
        String str;
        if (paramString == null) {
            str = null;
        }
        do {
            do {
                return str;
                str = paramString;
            } while (paramString.length() == 0);
            if (paramString.length() <= 1) {
                break;
            }
            str = paramString;
        } while (Character.isUpperCase(paramString.charAt(1)));
        paramString = paramString.toCharArray();
        paramString[0] = Character.toUpperCase(paramString[0]);
        return new String(paramString);
    }

    private static String a(Method paramMethod) {
        String str = paramMethod.getName();
        Class[] arrayOfClass = paramMethod.getParameterTypes();
        Object localObject = str;
        if (arrayOfClass != null) {
            int i1 = 0;
            paramMethod = str;
            for (; ; ) {
                localObject = paramMethod;
                if (i1 >= arrayOfClass.length) {
                    break;
                }
                paramMethod = paramMethod + "_" + arrayOfClass[i1].getName();
                i1 += 1;
            }
        }
        return (String) localObject;
    }

    private static HashMap<String, c> a(c[] paramArrayOfc) {
        HashMap localHashMap = new HashMap();
        int i1 = 0;
        while (i1 < paramArrayOfc.length) {
            localHashMap.put(paramArrayOfc[i1].b(), paramArrayOfc[i1]);
            i1 += 1;
        }
        return localHashMap;
    }

    private static HashMap<String, k> a(k[] paramArrayOfk) {
        HashMap localHashMap = new HashMap();
        int i1 = 0;
        while (i1 < paramArrayOfk.length) {
            localHashMap.put(paramArrayOfk[i1].b(), paramArrayOfk[i1]);
            i1 += 1;
        }
        return localHashMap;
    }

    private static void a(String paramString, Method paramMethod, HashMap<String, HashMap> paramHashMap) {
        int i1 = 0;
        Object localObject1 = paramMethod.getName();
        if (localObject1 == null) {
        }
        label13:
        String str;
        Class localClass;
        do {
            do {
                do {
                    break label13;
                    do {
                        return;
                    }
                    while ((!((String) localObject1).startsWith(paramString)) || (!((String) localObject1).endsWith("Listener")));
                    localObject1 = ((String) localObject1).substring(paramString.length());
                    str = ((String) localObject1).substring(0, ((String) localObject1).lastIndexOf("Listener"));
                } while ((str == null) || (str.length() == 0));
                localObject2 = paramMethod.getParameterTypes();
            } while ((localObject2 == null) || (localObject2.length != 1));
            localClass = localObject2[0];
        }
        while ((!EventListener.class.isAssignableFrom(localClass)) || (!localClass.getName().endsWith((String) localObject1)));
        Object localObject2 = (HashMap) paramHashMap.get(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new HashMap();
        }
        if (((HashMap) localObject1).get("listenerType") == null) {
            ((HashMap) localObject1).put("listenerType", localClass);
            ((HashMap) localObject1).put("listenerMethods", b(localClass));
        }
        ((HashMap) localObject1).put(paramString, paramMethod);
        if (paramString.equals("add")) {
            paramString = paramMethod.getExceptionTypes();
            if (paramString == null) {
            }
        }
        for (; ; ) {
            if (i1 < paramString.length) {
                if (paramString[i1].getName().equals(TooManyListenersException.class.getName())) {
                    ((HashMap) localObject1).put("isUnicast", "true");
                }
            } else {
                paramHashMap.put(str, localObject1);
                return;
            }
            i1 += 1;
        }
    }

    private static void a(Method paramMethod, HashMap<String, HashMap> paramHashMap) {
        Object localObject1 = paramMethod.getName();
        if (localObject1 == null) {
            return;
        }
        if (((String) localObject1).startsWith("get")) {
        }
        for (int i1 = "get".length(); ; i1 = 0) {
            if (((String) localObject1).startsWith("is")) {
                i1 = "is".length();
            }
            if (i1 == 0) {
                break;
            }
            Object localObject2 = g.a(((String) localObject1).substring(i1));
            if (!b((String) localObject2)) {
                break;
            }
            localObject1 = paramMethod.getReturnType();
            if ((localObject1 == null) || (localObject1 == Void.TYPE) || ((i1 == 2) && (localObject1 != Boolean.TYPE))) {
                break;
            }
            localObject1 = paramMethod.getParameterTypes();
            if ((localObject1.length > 1) || ((localObject1.length == 1) && (localObject1[0] != Integer.TYPE))) {
                break;
            }
            localObject1 = (HashMap) paramHashMap.get(localObject2);
            if (localObject1 == null) {
                localObject1 = new HashMap();
                paramHashMap.put(localObject2, localObject1);
            }
            for (paramHashMap = (HashMap<String, HashMap>) localObject1; ; paramHashMap = (HashMap<String, HashMap>) localObject1) {
                localObject2 = (ArrayList) paramHashMap.get("getters");
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = new ArrayList();
                    paramHashMap.put("getters", localObject1);
                }
                ((ArrayList) localObject1).add(paramMethod);
                return;
            }
        }
    }

    private void a(HashMap<String, HashMap> paramHashMap) {
        if (paramHashMap == null) {
            return;
        }
        Iterator localIterator1 = paramHashMap.entrySet().iterator();
        label16:
        HashMap localHashMap;
        Object localObject2;
        Object localObject1;
        Object localObject3;
        label108:
        Object localObject5;
        Object localObject4;
        if (localIterator1.hasNext()) {
            localHashMap = (HashMap) ((Map.Entry) localIterator1.next()).getValue();
            localObject2 = (ArrayList) localHashMap.get("getters");
            localObject1 = (ArrayList) localHashMap.get("setters");
            paramHashMap = (HashMap<String, HashMap>) localObject2;
            if (localObject2 == null) {
                paramHashMap = new ArrayList();
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new ArrayList();
            }
            Iterator localIterator2 = paramHashMap.iterator();
            localObject1 = null;
            localObject3 = null;
            if (localIterator2.hasNext()) {
                localObject5 = (Method) localIterator2.next();
                paramHashMap = ((Method) localObject5).getParameterTypes();
                String str = ((Method) localObject5).getName();
                if (paramHashMap != null) {
                    localObject4 = localObject3;
                    if (paramHashMap.length != 0) {
                    }
                } else if (localObject3 != null) {
                    localObject4 = localObject3;
                    if (!str.startsWith("is")) {
                    }
                } else {
                    localObject4 = localObject5;
                }
                if ((paramHashMap == null) || (paramHashMap.length != 1) || (paramHashMap[0] != Integer.TYPE)) {
                    break label1849;
                }
                paramHashMap = (HashMap<String, HashMap>) localObject5;
                if (localObject1 != null) {
                    paramHashMap = (HashMap<String, HashMap>) localObject5;
                    if (!str.startsWith("get")) {
                        if ((!str.startsWith("is")) || (((Method) localObject1).getName().startsWith("get"))) {
                            break label1849;
                        }
                    }
                }
            }
        }
        label386:
        label389:
        label400:
        label409:
        label499:
        label545:
        label608:
        label624:
        label1835:
        label1838:
        label1849:
        for (paramHashMap = (HashMap<String, HashMap>) localObject5; ; paramHashMap = (HashMap<String, HashMap>) localObject1) {
            localObject1 = paramHashMap;
            localObject3 = localObject4;
            break label108;
            if (localObject3 != null) {
                localObject4 = ((Method) localObject3).getReturnType();
                localObject5 = ((ArrayList) localObject2).iterator();
                do {
                    if (!((Iterator) localObject5).hasNext()) {
                        break;
                    }
                    paramHashMap = (Method) ((Iterator) localObject5).next();
                }
                while ((paramHashMap.getParameterTypes().length != 1) || (!localObject4.equals(paramHashMap.getParameterTypes()[0])));
            }
            for (; ; ) {
                for (localObject4 = paramHashMap; ; localObject4 = paramHashMap) {
                    if (localObject1 != null) {
                        localObject5 = ((Method) localObject1).getReturnType();
                        localObject2 = ((ArrayList) localObject2).iterator();
                        for (; ; ) {
                            if (((Iterator) localObject2).hasNext()) {
                                paramHashMap = (Method) ((Iterator) localObject2).next();
                                if ((paramHashMap.getParameterTypes().length == 2) && (paramHashMap.getParameterTypes()[0] == Integer.TYPE) && (localObject5.equals(paramHashMap.getParameterTypes()[1]))) {
                                    localObject5 = paramHashMap;
                                    if (localObject3 != null) {
                                        paramHashMap = ((Method) localObject3).getReturnType();
                                        if (localObject1 == null) {
                                            break label608;
                                        }
                                        localObject2 = ((Method) localObject1).getReturnType();
                                        if (((localObject3 != null) && (((Method) localObject3).getReturnType().isArray())) && ((localObject3 == null) || (localObject4 == null) || ((localObject1 != null) && (localObject5 != null)))) {
                                            break label624;
                                        }
                                        localHashMap.put("normal", "valid");
                                        localHashMap.put("normalget", localObject3);
                                        localHashMap.put("normalset", localObject4);
                                        localHashMap.put("normalPropertyType", paramHashMap);
                                        break;
                                        localObject5 = ((ArrayList) localObject2).iterator();
                                        paramHashMap = null;
                                        if (!((Iterator) localObject5).hasNext()) {
                                            break label1838;
                                        }
                                        localObject4 = (Method) ((Iterator) localObject5).next();
                                        if (((Method) localObject4).getParameterTypes().length != 1) {
                                            break label1835;
                                        }
                                        paramHashMap = (HashMap<String, HashMap>) localObject4;
                                    }
                                }
                            }
                        }
                    }
                    for (; ; ) {
                        break label499;
                        localObject5 = ((ArrayList) localObject2).iterator();
                        paramHashMap = null;
                        if (((Iterator) localObject5).hasNext()) {
                            localObject2 = (Method) ((Iterator) localObject5).next();
                            if ((((Method) localObject2).getParameterTypes().length == 2) && (localObject2.getParameterTypes()[0] == Integer.TYPE)) {
                                paramHashMap = (HashMap<String, HashMap>) localObject2;
                            }
                            for (; ; ) {
                                break label545;
                                if (localObject4 != null) {
                                    paramHashMap = localObject4.getParameterTypes()[0];
                                    break label400;
                                    if (localObject5 != null) {
                                        localObject2 = localObject5.getParameterTypes()[1];
                                        break label409;
                                        if (((localObject3 != null) || (localObject4 != null)) && (localObject1 == null) && (localObject5 == null)) {
                                            localHashMap.put("normal", "valid");
                                            localHashMap.put("normalget", localObject3);
                                            localHashMap.put("normalset", localObject4);
                                            localHashMap.put("normalPropertyType", paramHashMap);
                                            break label16;
                                        }
                                        if (((localObject3 != null) || (localObject4 != null)) && ((localObject1 != null) || (localObject5 != null))) {
                                            if ((localObject3 != null) && (localObject4 != null) && (localObject1 != null) && (localObject5 != null)) {
                                                if (((Method) localObject1).getName().startsWith("get")) {
                                                    localHashMap.put("normal", "valid");
                                                    localHashMap.put("normalget", localObject3);
                                                    localHashMap.put("normalset", localObject4);
                                                    localHashMap.put("normalPropertyType", paramHashMap);
                                                    localHashMap.put("indexed", "valid");
                                                    localHashMap.put("indexedget", localObject1);
                                                    localHashMap.put("indexedset", localObject5);
                                                    localHashMap.put("indexedPropertyType", localObject2);
                                                    break label16;
                                                }
                                                if ((paramHashMap != Boolean.TYPE) && (((Method) localObject3).getName().startsWith("is"))) {
                                                    localHashMap.put("indexed", "valid");
                                                    localHashMap.put("indexedset", localObject5);
                                                    localHashMap.put("indexedPropertyType", localObject2);
                                                    break label16;
                                                }
                                                localHashMap.put("normal", "valid");
                                                localHashMap.put("normalget", localObject3);
                                                localHashMap.put("normalset", localObject4);
                                                localHashMap.put("normalPropertyType", paramHashMap);
                                                break label16;
                                            }
                                            if ((localObject3 != null) && (localObject4 == null) && (localObject1 != null) && (localObject5 != null)) {
                                                localHashMap.put("normal", "valid");
                                                localHashMap.put("normalget", localObject3);
                                                localHashMap.put("normalset", localObject4);
                                                localHashMap.put("normalPropertyType", paramHashMap);
                                                localHashMap.put("indexed", "valid");
                                                if (((Method) localObject1).getName().startsWith("get")) {
                                                    localHashMap.put("indexedget", localObject1);
                                                }
                                                localHashMap.put("indexedset", localObject5);
                                                localHashMap.put("indexedPropertyType", localObject2);
                                                break label16;
                                            }
                                            if ((localObject3 == null) && (localObject4 != null) && (localObject1 != null) && (localObject5 != null)) {
                                                localHashMap.put("indexed", "valid");
                                                if (((Method) localObject1).getName().startsWith("get")) {
                                                    localHashMap.put("indexedget", localObject1);
                                                }
                                                localHashMap.put("indexedset", localObject5);
                                                localHashMap.put("indexedPropertyType", localObject2);
                                                break label16;
                                            }
                                            if ((localObject3 != null) && (localObject4 == null) && (localObject1 != null) && (localObject5 == null)) {
                                                if (((Method) localObject1).getName().startsWith("get")) {
                                                    localHashMap.put("normal", "valid");
                                                    localHashMap.put("normalget", localObject3);
                                                    localHashMap.put("normalset", localObject4);
                                                    localHashMap.put("normalPropertyType", paramHashMap);
                                                    localHashMap.put("indexed", "valid");
                                                    localHashMap.put("indexedget", localObject1);
                                                    localHashMap.put("indexedset", localObject5);
                                                    localHashMap.put("indexedPropertyType", localObject2);
                                                    break label16;
                                                }
                                                localHashMap.put("normal", "valid");
                                                localHashMap.put("normalget", localObject3);
                                                localHashMap.put("normalset", localObject4);
                                                localHashMap.put("normalPropertyType", paramHashMap);
                                                break label16;
                                            }
                                            if ((localObject3 == null) && (localObject4 != null) && (localObject1 != null) && (localObject5 == null)) {
                                                if (((Method) localObject1).getName().startsWith("get")) {
                                                    localHashMap.put("normal", "valid");
                                                    localHashMap.put("normalget", localObject3);
                                                    localHashMap.put("normalset", localObject4);
                                                    localHashMap.put("normalPropertyType", paramHashMap);
                                                    localHashMap.put("indexed", "valid");
                                                    localHashMap.put("indexedget", localObject1);
                                                    localHashMap.put("indexedset", localObject5);
                                                    localHashMap.put("indexedPropertyType", localObject2);
                                                    break label16;
                                                }
                                                localHashMap.put("normal", "valid");
                                                localHashMap.put("normalget", localObject3);
                                                localHashMap.put("normalset", localObject4);
                                                localHashMap.put("normalPropertyType", paramHashMap);
                                                break label16;
                                            }
                                            if ((localObject3 != null) && (localObject4 == null) && (localObject1 == null) && (localObject5 != null)) {
                                                localHashMap.put("indexed", "valid");
                                                localHashMap.put("indexedget", localObject1);
                                                localHashMap.put("indexedset", localObject5);
                                                localHashMap.put("indexedPropertyType", localObject2);
                                                break label16;
                                            }
                                            if ((localObject3 == null) && (localObject4 != null) && (localObject1 == null) && (localObject5 != null)) {
                                                localHashMap.put("indexed", "valid");
                                                localHashMap.put("indexedget", localObject1);
                                                localHashMap.put("indexedset", localObject5);
                                                localHashMap.put("indexedPropertyType", localObject2);
                                                break label16;
                                            }
                                        }
                                        if ((localObject4 == null) && (localObject3 == null) && ((localObject1 != null) || (localObject5 != null))) {
                                            if ((localObject1 != null) && (((Method) localObject1).getName().startsWith("is"))) {
                                                if (localObject5 == null) {
                                                    break label16;
                                                }
                                                localHashMap.put("indexed", "valid");
                                                localHashMap.put("indexedset", localObject5);
                                                localHashMap.put("indexedPropertyType", localObject2);
                                                break label16;
                                            }
                                            localHashMap.put("indexed", "valid");
                                            localHashMap.put("indexedget", localObject1);
                                            localHashMap.put("indexedset", localObject5);
                                            localHashMap.put("indexedPropertyType", localObject2);
                                            break label16;
                                        }
                                        if (((localObject4 != null) || (localObject3 != null)) && (localObject1 != null) && (localObject5 != null)) {
                                            localHashMap.put("indexed", "valid");
                                            localHashMap.put("indexedget", localObject1);
                                            localHashMap.put("indexedset", localObject5);
                                            localHashMap.put("indexedPropertyType", localObject2);
                                            break label16;
                                        }
                                        localHashMap.put("normal", "invalid");
                                        localHashMap.put("indexed", "invalid");
                                        break label16;
                                        break;
                                    }
                                    localObject2 = null;
                                    break label409;
                                }
                                paramHashMap = null;
                                break label400;
                            }
                        }
                        localObject5 = paramHashMap;
                        break label389;
                        paramHashMap = null;
                        break label386;
                    }
                }
                paramHashMap = null;
            }
        }
    }

    private static void a(k paramk1, k paramk2) {
        paramk1.b |= paramk2.b;
        paramk1.c |= paramk2.c;
        paramk1.a |= paramk2.a;
        paramk1.i |= paramk2.i;
        paramk1.h |= paramk2.h;
        paramk1.e = paramk2.e;
        if ((paramk1.d == null) && (paramk2.d != null)) {
            paramk1.d = paramk2.d;
        }
        if ((paramk1.f == null) && (paramk2.f != null)) {
            paramk1.f = paramk2.f;
        }
    }

    private boolean a(h paramh, h[] paramArrayOfh) {
        boolean bool2 = false;
        int i2 = paramArrayOfh.length;
        int i1 = 0;
        for (; ; ) {
            boolean bool1 = bool2;
            if (i1 < i2) {
                h localh = paramArrayOfh[i1];
                if (paramh.a().equals(localh.a())) {
                    bool1 = true;
                }
            } else {
                return bool1;
            }
            i1 += 1;
        }
    }

    private c[] a(c[] paramArrayOfc, int paramInt) {
        HashMap localHashMap = a(this.f);
        String str1;
        if ((this.k >= 0) && (this.k < this.f.length)) {
            str1 = this.f[this.k].b();
        }
        for (; ; ) {
            int i1 = paramArrayOfc.length;
            paramInt = 0;
            label47:
            if (paramInt < i1) {
                c localc1 = paramArrayOfc[paramInt];
                String str2 = localc1.b();
                c localc2 = (c) localHashMap.get(str2);
                if (localc2 == null) {
                    localHashMap.put(str2, localc1);
                }
                for (; ; ) {
                    paramInt += 1;
                    break label47;
                    if ((paramInt < 0) || (paramInt >= paramArrayOfc.length)) {
                        break label198;
                    }
                    str1 = paramArrayOfc[paramInt].b();
                    break;
                    localc2.a(localc1);
                }
            }
            paramArrayOfc = new c[localHashMap.size()];
            localHashMap.values().toArray(paramArrayOfc);
            if ((str1 != null) && (!this.d)) {
                paramInt = 0;
            }
            for (; ; ) {
                if (paramInt < paramArrayOfc.length) {
                    if (str1.equals(paramArrayOfc[paramInt].b())) {
                        this.k = paramInt;
                    }
                } else {
                    return paramArrayOfc;
                }
                paramInt += 1;
            }
            label198:
            str1 = null;
        }
    }

    private h[] a(boolean paramBoolean) {
        return a(paramBoolean, this.j);
    }

    private h[] a(boolean paramBoolean, Class<?> paramClass) {
        if (paramBoolean) {
        }
        for (paramClass = paramClass.getMethods(); (paramClass == null) || (paramClass.length == 0); paramClass = paramClass.getDeclaredMethods()) {
            return null;
        }
        ArrayList localArrayList = new ArrayList(paramClass.length);
        int i1 = 0;
        while (i1 < paramClass.length) {
            if (Modifier.isPublic(paramClass[i1].getModifiers())) {
                localArrayList.add(new h(paramClass[i1]));
            }
            i1 += 1;
        }
        i1 = localArrayList.size();
        if (i1 > 0) {
            return (h[]) localArrayList.toArray(new h[i1]);
        }
        return null;
    }

    private h[] a(h[] paramArrayOfh) {
        HashMap localHashMap = b(this.g);
        int i2 = paramArrayOfh.length;
        int i1 = 0;
        if (i1 < i2) {
            h localh1 = paramArrayOfh[i1];
            String str = a(localh1.a());
            h localh2 = (h) localHashMap.get(str);
            if (localh2 == null) {
                localHashMap.put(str, localh1);
            }
            for (; ; ) {
                i1 += 1;
                break;
                localh2.a(localh1);
            }
        }
        paramArrayOfh = new h[localHashMap.size()];
        localHashMap.values().toArray(paramArrayOfh);
        return paramArrayOfh;
    }

    private k[] a(Class<?> paramClass) {
        Object localObject1 = i();
        if (localObject1 == null) {
            return null;
        }
        Object localObject2 = new ArrayList();
        int i1 = 0;
        while (i1 < localObject1.length) {
            if (!Modifier.isStatic(localObject1[i1].a().getModifiers())) {
                ((ArrayList) localObject2).add(localObject1[i1]);
            }
            i1 += 1;
        }
        i1 = ((ArrayList) localObject2).size();
        if (i1 > 0) {
        }
        for (localObject1 = (h[]) ((ArrayList) localObject2).toArray(new h[i1]); ; localObject1 = null) {
            if (localObject1 == null) {
                return null;
            }
            HashMap localHashMap = new HashMap(localObject1.length);
            i1 = 0;
            while (i1 < localObject1.length) {
                a(localObject1[i1].a(), localHashMap);
                b(localObject1[i1].a(), localHashMap);
                i1 += 1;
            }
            a(localHashMap);
            localObject2 = a(true);
            localObject1 = localObject2;
            Object localObject3;
            if (paramClass != null) {
                paramClass = a(true, paramClass);
                localObject1 = localObject2;
                if (paramClass != null) {
                    localObject1 = new ArrayList();
                    int i2 = localObject2.length;
                    i1 = 0;
                    while (i1 < i2) {
                        localObject3 = localObject2[i1];
                        if (!a((h) localObject3, paramClass)) {
                            ((ArrayList) localObject1).add(localObject3);
                        }
                        i1 += 1;
                    }
                    localObject1 = (h[]) ((ArrayList) localObject1).toArray(new h[0]);
                }
            }
            i1 = 0;
            while (i1 < localObject1.length) {
                b(localObject1[i1].a());
                i1 += 1;
            }
            localObject1 = new ArrayList();
            localObject2 = localHashMap.entrySet().iterator();
            while (((Iterator) localObject2).hasNext()) {
                paramClass = (Map.Entry) ((Iterator) localObject2).next();
                localObject3 = (String) paramClass.getKey();
                localHashMap = (HashMap) paramClass.getValue();
                if (localHashMap != null) {
                    Object localObject4 = (String) localHashMap.get("normal");
                    paramClass = (String) localHashMap.get("indexed");
                    if ((localObject4 != null) || (paramClass != null)) {
                        Method localMethod2 = (Method) localHashMap.get("normalget");
                        Method localMethod3 = (Method) localHashMap.get("normalset");
                        localObject4 = (Method) localHashMap.get("indexedget");
                        Method localMethod1 = (Method) localHashMap.get("indexedset");
                        if (paramClass == null) {
                            paramClass = new k((String) localObject3, localMethod2, localMethod3);
                            label448:
                            if ((!this.n) || (!this.o)) {
                                break label537;
                            }
                            paramClass.b(true);
                        }
                        for (; ; ) {
                            if (localHashMap.get("isConstrained") == Boolean.TRUE) {
                                paramClass.a(true);
                            }
                            ((ArrayList) localObject1).add(paramClass);
                            break;
                            try {
                                paramClass = new e((String) localObject3, localMethod2, localMethod3, (Method) localObject4, localMethod1);
                            } catch (f paramClass) {
                                paramClass = new e((String) localObject3, null, null, (Method) localObject4, localMethod1);
                            }
                            break label448;
                            label537:
                            paramClass.b(false);
                        }
                    }
                }
            }
            paramClass = new k[((ArrayList) localObject1).size()];
            ((ArrayList) localObject1).toArray(paramClass);
            return paramClass;
        }
    }

    private k[] a(k[] paramArrayOfk, int paramInt) {
        HashMap localHashMap = a(this.h);
        String str1;
        if ((this.l >= 0) && (this.l < this.h.length)) {
            str1 = this.h[this.l].b();
        }
        for (; ; ) {
            paramInt = 0;
            k localk;
            String str2;
            Object localObject6;
            Method localMethod3;
            Object localObject4;
            Method localMethod4;
            Method localMethod5;
            Class localClass2;
            Class localClass1;
            for (; ; ) {
                if (paramInt < paramArrayOfk.length) {
                    localk = paramArrayOfk[paramInt];
                    str2 = localk.b();
                    if (!localHashMap.containsKey(str2)) {
                        localHashMap.put(str2, localk);
                        paramInt += 1;
                        continue;
                        if ((paramInt < 0) || (paramInt >= paramArrayOfk.length)) {
                            break label1276;
                        }
                        str1 = paramArrayOfk[paramInt].b();
                        break;
                    }
                    localObject6 = localHashMap.get(str2);
                    localMethod3 = ((k) localObject6).g();
                    localObject4 = ((k) localObject6).f();
                    localMethod4 = localk.g();
                    localMethod5 = localk.f();
                    localClass2 = localk.h();
                    localClass1 = ((k) localObject6).h();
                    if (!(localObject6 instanceof e)) {
                        break label1270;
                    }
                }
            }
            label369:
            label939:
            label981:
            label1270:
            for (Object localObject3 = ((e) localObject6).e(); ; localObject3 = null) {
                if ((localk instanceof e)) {
                }
                e locale;
                for (Object localObject1 = ((e) localk).e(); ; locale = null) {
                    Object localObject5;
                    if (localObject1 == null) {
                        localObject5 = (k) localObject6;
                        if (localObject3 == null) {
                            if ((localClass1 != null) && (localClass2 != null) && (localClass1.getName() != null) && (localClass1.getName().equals(localClass2.getName()))) {
                                if ((localMethod4 != null) && ((localMethod3 == null) || (localMethod4.equals(localMethod3)))) {
                                    ((k) localObject5).d(localMethod4);
                                }
                                if ((localMethod5 != null) && ((localObject4 == null) || (localMethod5.equals(localObject4)))) {
                                    ((k) localObject5).c(localMethod5);
                                }
                                localObject1 = localObject5;
                                if (localClass1 == Boolean.TYPE) {
                                    localObject1 = localObject5;
                                    if (localMethod3 != null) {
                                        localObject1 = localObject5;
                                        if (localMethod4 != null) {
                                            localObject1 = localObject5;
                                            if (localMethod4.getName().startsWith("is")) {
                                                ((k) localObject5).d(localMethod4);
                                                localObject1 = localObject5;
                                            }
                                        }
                                    }
                                }
                                localHashMap.put(str2, localObject1);
                            }
                        }
                    }
                    for (; ; ) {
                        a((k) localObject6, localk);
                        break;
                        if (localMethod3 != null) {
                            localObject1 = localObject5;
                            if (localObject4 != null) {
                                break label369;
                            }
                        }
                        localObject1 = localObject5;
                        if (localMethod4 == null) {
                            break label369;
                        }
                        localObject3 = new k(str2, localMethod4, localMethod5);
                        localObject1 = localObject3;
                        if (localMethod3 == null) {
                            break label369;
                        }
                        localObject4 = localMethod3.getName();
                        localObject5 = i();
                        int i2 = localObject5.length;
                        int i1 = 0;
                        for (; ; ) {
                            localObject1 = localObject3;
                            if (i1 >= i2) {
                                break;
                            }
                            localObject1 = localObject5[i1].a();
                            if ((localObject1 != localMethod3) && (((String) localObject4).equals(((Method) localObject1).getName())) && (((Method) localObject1).getParameterTypes().length == 0) && (((Method) localObject1).getReturnType() == localClass2)) {
                                ((k) localObject3).d((Method) localObject1);
                                localObject1 = localObject3;
                                break;
                            }
                            i1 += 1;
                        }
                        if ((localClass2 != null) && (localClass2.isArray()) && (localClass2.getComponentType().getName().equals(((Class) localObject3).getName()))) {
                            if ((localMethod3 == null) && (localMethod4 != null)) {
                                ((k) localObject5).d(localMethod4);
                            }
                            if ((localObject4 == null) && (localMethod5 != null)) {
                                ((k) localObject5).c(localMethod5);
                            }
                        }
                        localObject1 = localObject5;
                        if (localObject3 != Boolean.TYPE) {
                            break label369;
                        }
                        localObject1 = localObject5;
                        if (localClass2 != Boolean.TYPE) {
                            break label369;
                        }
                        localObject3 = ((e) localObject5).a();
                        localObject1 = localObject5;
                        if (localMethod3 != null) {
                            break label369;
                        }
                        localObject1 = localObject5;
                        if (localObject4 != null) {
                            break label369;
                        }
                        localObject1 = localObject5;
                        if (localObject3 == null) {
                            break label369;
                        }
                        localObject1 = localObject5;
                        if (localMethod4 == null) {
                            break label369;
                        }
                        try {
                            localObject3 = this.j.getDeclaredMethod(((Method) localObject3).getName(), new Class[]{Boolean.TYPE});
                            localObject1 = localObject5;
                            if (localObject3 == null) {
                                break label369;
                            }
                            localObject1 = new k(str2, localMethod4, (Method) localObject3);
                        } catch (Exception localException1) {
                            for (; ; ) {
                                localObject3 = localObject4;
                            }
                        }
                        if (localObject3 == null) {
                            if ((localClass1 != null) && (localClass1.isArray()) && (localClass1.getComponentType().getName().equals(localException1.getName()))) {
                                if (localMethod3 != null) {
                                    localk.d(localMethod3);
                                }
                                if (localObject4 != null) {
                                    localk.c((Method) localObject4);
                                }
                                localHashMap.put(str2, localk);
                            } else {
                                Object localObject2;
                                if ((localMethod3 == null) || (localObject4 == null)) {
                                    localObject2 = this.j.getSuperclass();
                                    localObject3 = a(str2);
                                    if (localMethod3 != null) {
                                        break label981;
                                    }
                                    if (localClass1 != Boolean.TYPE) {
                                        break label939;
                                    }
                                }
                                for (; ; ) {
                                    Method localMethod1;
                                    try {
                                        localObject2 = ((Class) localObject2).getDeclaredMethod("is" + (String) localObject3, new Class[0]);
                                        if ((localObject2 != null) && (!Modifier.isStatic(((Method) localObject2).getModifiers())) && (((Method) localObject2).getReturnType() == localClass1)) {
                                            ((k) localObject6).d((Method) localObject2);
                                        }
                                        localHashMap.put(str2, (k) localObject6);
                                    } catch (Exception localException2) {
                                        localMethod1 = null;
                                        continue;
                                    }
                                    Method localMethod2;
                                    try {
                                        localMethod1 = localMethod1.getDeclaredMethod("get" + (String) localObject3, new Class[0]);
                                    } catch (Exception localException3) {
                                        localMethod2 = null;
                                    }
                                    continue;
                                    try {
                                        localMethod2 = localMethod2.getDeclaredMethod("set" + (String) localObject3, new Class[]{localClass1});
                                        if ((localMethod2 != null) && (!Modifier.isStatic(localMethod2.getModifiers())) && (localMethod2.getReturnType() == Void.TYPE)) {
                                            ((k) localObject6).c(localMethod2);
                                        }
                                    } catch (Exception localException4) {
                                        for (; ; ) {
                                            locale = null;
                                        }
                                    }
                                }
                            }
                        } else if (((Class) localObject3).getName().equals(locale.getName())) {
                            locale = (e) localObject6;
                            if ((localMethod3 == null) && (localMethod4 != null)) {
                                locale.d(localMethod4);
                            }
                            if ((localObject4 == null) && (localMethod5 != null)) {
                                locale.c(localMethod5);
                            }
                            localObject3 = (e) localk;
                            if ((locale.d() == null) && (((e) localObject3).d() != null)) {
                                locale.a(((e) localObject3).d());
                            }
                            if ((locale.a() == null) && (((e) localObject3).a() != null)) {
                                locale.b(((e) localObject3).a());
                            }
                            localHashMap.put(str2, locale);
                        }
                    }
                    paramArrayOfk = new k[localHashMap.size()];
                    localHashMap.values().toArray(paramArrayOfk);
                    if ((str1 != null) && (!this.c)) {
                        paramInt = 0;
                    }
                    for (; ; ) {
                        if (paramInt < paramArrayOfk.length) {
                            if (str1.equals(paramArrayOfk[paramInt].b())) {
                                this.l = paramInt;
                            }
                        } else {
                            return paramArrayOfk;
                        }
                        paramInt += 1;
                    }
                }
            }
            label1276:
            str1 = null;
        }
    }

    private static HashMap<String, h> b(h[] paramArrayOfh) {
        HashMap localHashMap = new HashMap();
        int i1 = 0;
        while (i1 < paramArrayOfh.length) {
            localHashMap.put(a(paramArrayOfh[i1].a()), paramArrayOfh[i1]);
            i1 += 1;
        }
        return localHashMap;
    }

    private void b(Method paramMethod) {
        String str = paramMethod.getName();
        paramMethod = paramMethod.getParameterTypes();
        if (paramMethod.length != 1) {
        }
        do {
            return;
            if ((str.equals("addPropertyChangeListener")) && (paramMethod[0].equals(j.class))) {
                this.n = true;
            }
        } while ((!str.equals("removePropertyChangeListener")) || (!paramMethod[0].equals(j.class)));
        this.o = true;
    }

    private static void b(Method paramMethod, HashMap<String, HashMap> paramHashMap) {
        int i1 = 0;
        Object localObject1 = paramMethod.getName();
        if (localObject1 == null) {
        }
        Object localObject2;
        do {
            do {
                do {
                    return;
                }
                while ((paramMethod.getReturnType() != Void.TYPE) || (localObject1 == null) || (!((String) localObject1).startsWith("set")));
                localObject2 = g.a(((String) localObject1).substring("set".length()));
            } while (!b((String) localObject2));
            localObject1 = paramMethod.getParameterTypes();
        }
        while ((localObject1.length == 0) || (localObject1.length > 2) || ((localObject1.length == 2) && (localObject1[0] != Integer.TYPE)));
        localObject1 = (HashMap) paramHashMap.get(localObject2);
        if (localObject1 == null) {
            localObject1 = new HashMap();
            paramHashMap.put(localObject2, localObject1);
        }
        for (paramHashMap = (HashMap<String, HashMap>) localObject1; ; paramHashMap = (HashMap<String, HashMap>) localObject1) {
            localObject2 = (ArrayList) paramHashMap.get("setters");
            localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = new ArrayList();
                paramHashMap.put("setters", localObject1);
            }
            localObject2 = paramMethod.getExceptionTypes();
            int i2 = localObject2.length;
            while (i1 < i2) {
                if (localObject2[i1].equals(l.class)) {
                    paramHashMap.put("isConstrained", Boolean.TRUE);
                }
                i1 += 1;
            }
            ((ArrayList) localObject1).add(paramMethod);
            return;
        }
    }

    private static boolean b(String paramString) {
        return (paramString != null) && (paramString.length() != 0);
    }

    private static Method[] b(Class<?> paramClass) {
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        paramClass = new ArrayList();
        int i1 = 0;
        if (i1 < arrayOfMethod.length) {
            Class[] arrayOfClass = arrayOfMethod[i1].getParameterTypes();
            if (arrayOfClass.length != 1) {
            }
            for (; ; ) {
                i1 += 1;
                break;
                if (EventObject.class.isAssignableFrom(arrayOfClass[0])) {
                    paramClass.add(arrayOfMethod[i1]);
                }
            }
        }
        arrayOfMethod = new Method[paramClass.size()];
        paramClass.toArray(arrayOfMethod);
        return arrayOfMethod;
    }

    private static void c(Method paramMethod, HashMap<String, HashMap> paramHashMap) {
        Object localObject1 = paramMethod.getName();
        if (localObject1 == null) {
        }
        label9:
        String str;
        do {
            do {
                do {
                    break label9;
                    do {
                        return;
                    }
                    while ((!((String) localObject1).startsWith("get")) || (!((String) localObject1).endsWith("Listeners")));
                    localObject1 = ((String) localObject1).substring("get".length(), ((String) localObject1).length() - 1);
                    str = ((String) localObject1).substring(0, ((String) localObject1).lastIndexOf("Listener"));
                } while ((str == null) || (str.length() == 0));
                localObject2 = paramMethod.getParameterTypes();
            } while ((localObject2 == null) || (localObject2.length != 0));
            localObject2 = paramMethod.getReturnType();
        }
        while ((((Class) localObject2).getComponentType() == null) || (!((Class) localObject2).getComponentType().getName().endsWith((String) localObject1)));
        Object localObject2 = (HashMap) paramHashMap.get(str);
        localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = new HashMap();
        }
        ((HashMap) localObject1).put("get", paramMethod);
        paramHashMap.put(str, localObject1);
    }

    private h[] i() {
        return a(false, this.j);
    }

    private c[] j() {
        Object localObject1 = i();
        if (localObject1 == null) {
            return null;
        }
        Object localObject2 = new HashMap(localObject1.length);
        int i1 = 0;
        while (i1 < localObject1.length) {
            a("add", localObject1[i1].a(), (HashMap) localObject2);
            a("remove", localObject1[i1].a(), (HashMap) localObject2);
            c(localObject1[i1].a(), (HashMap) localObject2);
            i1 += 1;
        }
        localObject1 = new ArrayList();
        localObject2 = ((HashMap) localObject2).entrySet().iterator();
        while (((Iterator) localObject2).hasNext()) {
            Object localObject3 = (Map.Entry) ((Iterator) localObject2).next();
            HashMap localHashMap = (HashMap) ((Map.Entry) localObject3).getValue();
            Method localMethod1 = (Method) localHashMap.get("add");
            Method localMethod2 = (Method) localHashMap.get("remove");
            if ((localMethod1 != null) && (localMethod2 != null)) {
                Method localMethod3 = (Method) localHashMap.get("get");
                Class localClass = (Class) localHashMap.get("listenerType");
                Method[] arrayOfMethod = (Method[]) localHashMap.get("listenerMethods");
                localObject3 = new c(g.a((String) ((Map.Entry) localObject3).getKey()), localClass, arrayOfMethod, localMethod1, localMethod2, localMethod3);
                if (localHashMap.get("isUnicast") != null) {
                }
                for (boolean bool = true; ; bool = false) {
                    ((c) localObject3).a(bool);
                    ((ArrayList) localObject1).add(localObject3);
                    break;
                }
            }
        }
        localObject2 = new c[((ArrayList) localObject1).size()];
        ((ArrayList) localObject1).toArray((Object[]) localObject2);
        return (c[]) localObject2;
    }

    void a(b paramb, boolean paramBoolean) {
        Object localObject;
        if ((paramBoolean) || (!this.c)) {
            localObject = paramb.a();
            if (localObject != null) {
                if (a() == null) {
                    break label127;
                }
                this.h = a((k[]) localObject, paramb.f());
            }
        }
        if ((paramBoolean) || (!this.b)) {
            localObject = paramb.b();
            if (localObject != null) {
                if (this.g == null) {
                    break label145;
                }
            }
        }
        label127:
        label145:
        for (this.g = a((h[]) localObject); ; this.g = ((h[]) localObject)) {
            if ((paramBoolean) || (!this.d)) {
                localObject = paramb.c();
                if (localObject != null) {
                    if (this.f == null) {
                        break label153;
                    }
                    this.f = a((c[]) localObject, paramb.g());
                }
            }
            return;
            this.h = ((k[]) localObject);
            this.l = paramb.f();
            break;
        }
        label153:
        this.f = ((c[]) localObject);
        this.k = paramb.g();
    }

    public k[] a() {
        return this.h;
    }

    public h[] b() {
        return this.g;
    }

    public c[] c() {
        return this.f;
    }

    public b[] d() {
        return null;
    }

    public a e() {
        if (this.i == null) {
            if (this.e != null) {
                this.i = this.e.e();
            }
            if (this.i == null) {
                this.i = new a(this.j);
            }
        }
        return this.i;
    }

    public int f() {
        return this.l;
    }

    public int g() {
        return this.k;
    }

    void h() {
        int i1 = 0;
        if (this.f == null) {
            this.f = new c[0];
        }
        if (this.h == null) {
            this.h = new k[0];
        }
        String str;
        if (this.h != null) {
            if (this.l == -1) {
                break label105;
            }
            str = this.h[this.l].b();
            Arrays.sort(this.h, m);
            if (str == null) {
            }
        }
        for (; ; ) {
            if (i1 < this.h.length) {
                if (str.equals(this.h[i1].b())) {
                    this.l = i1;
                }
            } else {
                return;
                label105:
                str = null;
                break;
            }
            i1 += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */