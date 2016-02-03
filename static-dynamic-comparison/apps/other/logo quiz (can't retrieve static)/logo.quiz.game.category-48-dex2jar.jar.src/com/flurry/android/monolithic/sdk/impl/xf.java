package com.flurry.android.monolithic.sdk.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class xf
{
  public static final xf a = new xf();
  
  private Object a(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (Exception paramString)
    {
      return null;
    }
    catch (LinkageError paramString)
    {
      for (;;) {}
    }
  }
  
  private boolean a(Class<?> paramClass, String paramString)
  {
    while (paramClass != null)
    {
      if (paramClass.getName().equals(paramString)) {}
      while (b(paramClass, paramString)) {
        return true;
      }
      paramClass = paramClass.getSuperclass();
    }
    return false;
  }
  
  private boolean b(Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      if (paramClass[i].getName().equals(paramString)) {
        return true;
      }
      i += 1;
    }
    j = paramClass.length;
    i = 0;
    for (;;)
    {
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
  
  private boolean c(Class<?> paramClass, String paramString)
  {
    Object localObject;
    for (Class localClass = paramClass.getSuperclass();; localClass = localClass.getSuperclass())
    {
      localObject = paramClass;
      if (localClass == null) {
        break;
      }
      if (localClass.getName().startsWith(paramString)) {
        return true;
      }
    }
    do
    {
      localObject = ((Class)localObject).getSuperclass();
      if (localObject == null) {
        break;
      }
    } while (!d((Class)localObject, paramString));
    return true;
    return false;
  }
  
  private boolean d(Class<?> paramClass, String paramString)
  {
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      if (paramClass[i].getName().startsWith(paramString)) {
        return true;
      }
      i += 1;
    }
    j = paramClass.length;
    i = 0;
    for (;;)
    {
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
  
  public qu<?> a(afm paramafm, qk paramqk, qq paramqq)
  {
    paramqk = paramafm.p();
    paramafm = paramqk.getName();
    if (paramafm.startsWith("org.joda.time.")) {}
    for (paramafm = "com.flurry.org.codehaus.jackson.map.ext.JodaDeserializers";; paramafm = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLDeserializers")
    {
      paramafm = a(paramafm);
      if (paramafm != null) {
        break label101;
      }
      return null;
      if ((!paramafm.startsWith("javax.xml.")) && (!c(paramqk, "javax.xml."))) {
        break;
      }
    }
    if (a(paramqk, "org.w3c.dom.Node")) {
      return (qu)a("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer");
    }
    if (a(paramqk, "org.w3c.dom.Node")) {
      return (qu)a("com.flurry.org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer");
    }
    return null;
    label101:
    paramafm = ((ael)paramafm).a();
    paramqq = paramafm.iterator();
    while (paramqq.hasNext())
    {
      vo localvo = (vo)paramqq.next();
      if (paramqk == localvo.f()) {
        return localvo;
      }
    }
    paramafm = paramafm.iterator();
    while (paramafm.hasNext())
    {
      paramqq = (vo)paramafm.next();
      if (paramqq.f().isAssignableFrom(paramqk)) {
        return paramqq;
      }
    }
    return null;
  }
  
  public ra<?> a(rq paramrq, afm paramafm)
  {
    paramafm = paramafm.p();
    paramrq = paramafm.getName();
    if (paramrq.startsWith("org.joda.time.")) {}
    for (paramrq = "com.flurry.org.codehaus.jackson.map.ext.JodaSerializers";; paramrq = "com.flurry.org.codehaus.jackson.map.ext.CoreXMLSerializers")
    {
      paramrq = a(paramrq);
      if (paramrq != null) {
        break label81;
      }
      return null;
      if ((!paramrq.startsWith("javax.xml.")) && (!c(paramafm, "javax.xml."))) {
        break;
      }
    }
    if (a(paramafm, "org.w3c.dom.Node")) {
      return (ra)a("com.flurry.org.codehaus.jackson.map.ext.DOMSerializer");
    }
    return null;
    label81:
    paramrq = ((ael)paramrq).a();
    Object localObject = paramrq.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (paramafm == localEntry.getKey()) {
        return (ra)localEntry.getValue();
      }
    }
    paramrq = paramrq.iterator();
    while (paramrq.hasNext())
    {
      localObject = (Map.Entry)paramrq.next();
      if (((Class)((Map.Entry)localObject).getKey()).isAssignableFrom(paramafm)) {
        return (ra)((Map.Entry)localObject).getValue();
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */