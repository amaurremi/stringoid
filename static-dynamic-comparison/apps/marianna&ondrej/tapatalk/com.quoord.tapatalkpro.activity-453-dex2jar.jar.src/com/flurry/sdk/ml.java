package com.flurry.sdk;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class ml {
    public static final ml a = new ml();

    private Object a(String paramString) {
        try {
            paramString = Class.forName(paramString).newInstance();
            return paramString;
        } catch (Exception paramString) {
            return null;
        } catch (LinkageError paramString) {
            for (; ; ) {
            }
        }
    }

    private boolean a(Class<?> paramClass, String paramString) {
        while (paramClass != null) {
            if (paramClass.getName().equals(paramString)) {
            }
            while (b(paramClass, paramString)) {
                return true;
            }
            paramClass = paramClass.getSuperclass();
        }
        return false;
    }

    private boolean b(Class<?> paramClass, String paramString) {
        paramClass = paramClass.getInterfaces();
        int j = paramClass.length;
        int i = 0;
        while (i < j) {
            if (paramClass[i].getName().equals(paramString)) {
                return true;
            }
            i += 1;
        }
        j = paramClass.length;
        i = 0;
        for (; ; ) {
            if (i >= j) {
                break label69;
            }
            if (b(paramClass[i], paramString)) {
                break;
            }
            i += 1;
        }
        label69:
        return false;
    }

    private boolean c(Class<?> paramClass, String paramString) {
        Object localObject;
        for (Class localClass = paramClass.getSuperclass(); ; localClass = localClass.getSuperclass()) {
            localObject = paramClass;
            if (localClass == null) {
                break;
            }
            if (localClass.getName().startsWith(paramString)) {
                return true;
            }
        }
        do {
            localObject = ((Class) localObject).getSuperclass();
            if (localObject == null) {
                break;
            }
        } while (!d((Class) localObject, paramString));
        return true;
        return false;
    }

    private boolean d(Class<?> paramClass, String paramString) {
        paramClass = paramClass.getInterfaces();
        int j = paramClass.length;
        int i = 0;
        while (i < j) {
            if (paramClass[i].getName().startsWith(paramString)) {
                return true;
            }
            i += 1;
        }
        j = paramClass.length;
        i = 0;
        for (; ; ) {
            if (i >= j) {
                break label69;
            }
            if (d(paramClass[i], paramString)) {
                break;
            }
            i += 1;
        }
        label69:
        return false;
    }

    public jg<?> a(sh paramsh, iy paramiy, jc paramjc) {
        paramiy = paramsh.p();
        paramsh = paramiy.getName();
        if (paramsh.startsWith("org.joda.time.")) {
        }
        for (paramsh = "com.flurry.org.codehaus.jackson.map.ext.JodaDeserializers"; ; paramsh = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLDeserializers") {
            paramsh = a(paramsh);
            if (paramsh != null) {
                break label101;
            }
            return null;
            if ((!paramsh.startsWith("javax.xml.")) && (!c(paramiy, "javax.xml."))) {
                break;
            }
        }
        if (a(paramiy, "org.w3c.dom.Node")) {
            return (jg) a("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
        }
        if (a(paramiy, "org.w3c.dom.Node")) {
            return (jg) a("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
        }
        return null;
        label101:
        paramsh = ((rg) paramsh).a();
        paramjc = paramsh.iterator();
        while (paramjc.hasNext()) {
            lz locallz = (lz) paramjc.next();
            if (paramiy == locallz.f()) {
                return locallz;
            }
        }
        paramsh = paramsh.iterator();
        while (paramsh.hasNext()) {
            paramjc = (lz) paramsh.next();
            if (paramjc.f().isAssignableFrom(paramiy)) {
                return paramjc;
            }
        }
        return null;
    }

    public jk<?> a(ju paramju, sh paramsh) {
        paramsh = paramsh.p();
        paramju = paramsh.getName();
        if (paramju.startsWith("org.joda.time.")) {
        }
        for (paramju = "com.flurry.org.codehaus.jackson.map.ext.JodaSerializers"; ; paramju = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLSerializers") {
            paramju = a(paramju);
            if (paramju != null) {
                break label81;
            }
            return null;
            if ((!paramju.startsWith("javax.xml.")) && (!c(paramsh, "javax.xml."))) {
                break;
            }
        }
        if (a(paramsh, "org.w3c.dom.Node")) {
            return (jk) a("com.flurry.org.codehaus.jackson.map.ext.DOMSerializer");
        }
        return null;
        label81:
        paramju = ((rg) paramju).a();
        Object localObject = paramju.iterator();
        while (((Iterator) localObject).hasNext()) {
            Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
            if (paramsh == localEntry.getKey()) {
                return (jk) localEntry.getValue();
            }
        }
        paramju = paramju.iterator();
        while (paramju.hasNext()) {
            localObject = (Map.Entry) paramju.next();
            if (((Class) ((Map.Entry) localObject).getKey()).isAssignableFrom(paramsh)) {
                return (jk) ((Map.Entry) localObject).getValue();
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */