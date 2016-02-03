package com.vladium.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public abstract interface IProperties
{
  public abstract IProperties copy();
  
  public abstract String getProperty(String paramString);
  
  public abstract String getProperty(String paramString1, String paramString2);
  
  public abstract boolean isEmpty();
  
  public abstract boolean isOverridden(String paramString);
  
  public abstract void list(PrintStream paramPrintStream);
  
  public abstract void list(PrintWriter paramPrintWriter);
  
  public abstract Iterator properties();
  
  public abstract String setProperty(String paramString1, String paramString2);
  
  public abstract String[] toAppArgsForm(String paramString);
  
  public abstract Properties toProperties();
  
  public static abstract class Factory
  {
    public static IProperties combine(IProperties paramIProperties1, IProperties paramIProperties2)
    {
      if (paramIProperties1 != null) {}
      for (paramIProperties1 = paramIProperties1.copy();; paramIProperties1 = create(null))
      {
        ((PropertiesImpl)paramIProperties1).getLastProperties().setDelegate((PropertiesImpl)paramIProperties2);
        return paramIProperties1;
      }
    }
    
    public static IProperties create(IProperties.IMapper paramIMapper)
    {
      return new PropertiesImpl(null, paramIMapper);
    }
    
    public static IProperties wrap(Properties paramProperties, IProperties.IMapper paramIMapper)
    {
      HashMap localHashMap = new HashMap();
      Enumeration localEnumeration = paramProperties.propertyNames();
      while (localEnumeration.hasMoreElements())
      {
        String str = (String)localEnumeration.nextElement();
        localHashMap.put(str, paramProperties.getProperty(str));
      }
      return new PropertiesImpl(localHashMap, paramIMapper);
    }
    
    private static final class PropertiesImpl
      implements IProperties, Cloneable
    {
      private PropertiesImpl m_delegate;
      private final IProperties.IMapper m_mapper;
      private transient Set m_unmappedKeySet;
      private HashMap m_valueMap;
      
      PropertiesImpl(HashMap paramHashMap, IProperties.IMapper paramIMapper)
      {
        this.m_mapper = paramIMapper;
        if (paramHashMap != null) {}
        for (;;)
        {
          this.m_valueMap = paramHashMap;
          this.m_delegate = null;
          return;
          paramHashMap = new HashMap();
        }
      }
      
      public IProperties copy()
      {
        PropertiesImpl localPropertiesImpl2;
        try
        {
          localPropertiesImpl2 = (PropertiesImpl)super.clone();
          localPropertiesImpl2.m_valueMap = ((HashMap)this.m_valueMap.clone());
          localPropertiesImpl2.m_unmappedKeySet = null;
          localObject = localPropertiesImpl2;
          localPropertiesImpl1 = this.m_delegate;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException1)
        {
          try
          {
            PropertiesImpl localPropertiesImpl3 = (PropertiesImpl)localPropertiesImpl1.clone();
            localPropertiesImpl3.m_valueMap = ((HashMap)localPropertiesImpl1.m_valueMap.clone());
            localPropertiesImpl3.m_unmappedKeySet = null;
            ((PropertiesImpl)localObject).setDelegate(localPropertiesImpl3);
            Object localObject = localPropertiesImpl3;
            PropertiesImpl localPropertiesImpl1 = localPropertiesImpl1.m_delegate;
          }
          catch (CloneNotSupportedException localCloneNotSupportedException2)
          {
            throw new Error(localCloneNotSupportedException2.toString());
          }
          localCloneNotSupportedException1 = localCloneNotSupportedException1;
          throw new Error(localCloneNotSupportedException1.toString());
        }
        if (localPropertiesImpl1 != null) {}
        return localPropertiesImpl2;
      }
      
      PropertiesImpl getLastProperties()
      {
        Object localObject = this;
        for (PropertiesImpl localPropertiesImpl = this.m_delegate; localPropertiesImpl != null; localPropertiesImpl = localPropertiesImpl.m_delegate)
        {
          if (localPropertiesImpl == this) {
            throw new IllegalStateException("cyclic delegation detected");
          }
          localObject = localPropertiesImpl;
        }
        return (PropertiesImpl)localObject;
      }
      
      public String getProperty(String paramString)
      {
        return getProperty(paramString, null);
      }
      
      public String getProperty(String paramString1, String paramString2)
      {
        Object localObject2 = (String)this.m_valueMap.get(paramString1);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.m_mapper != null)
          {
            String str = this.m_mapper.getMappedKey(paramString1);
            localObject1 = localObject2;
            if (str != null) {
              localObject1 = (String)this.m_valueMap.get(str);
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (this.m_delegate != null) {
            localObject2 = this.m_delegate.getProperty(paramString1, null);
          }
        }
        if (localObject2 != null) {
          return (String)localObject2;
        }
        return paramString2;
      }
      
      public boolean isEmpty()
      {
        return (this.m_valueMap.isEmpty()) && ((this.m_delegate == null) || ((this.m_delegate != null) && (this.m_delegate.isEmpty())));
      }
      
      public boolean isOverridden(String paramString)
      {
        return this.m_valueMap.containsKey(paramString);
      }
      
      public void list(PrintStream paramPrintStream)
      {
        if (paramPrintStream != null)
        {
          Iterator localIterator = properties();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = getProperty(str1);
            paramPrintStream.println(str1 + ":\t[" + str2 + "]");
          }
        }
      }
      
      public void list(PrintWriter paramPrintWriter)
      {
        if (paramPrintWriter != null)
        {
          Iterator localIterator = properties();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = getProperty(str1);
            paramPrintWriter.println(str1 + ":\t[" + str2 + "]");
          }
        }
      }
      
      public Iterator properties()
      {
        return unmappedKeySet().iterator();
      }
      
      void setDelegate(PropertiesImpl paramPropertiesImpl)
      {
        this.m_delegate = paramPropertiesImpl;
        this.m_unmappedKeySet = null;
      }
      
      public String setProperty(String paramString1, String paramString2)
      {
        if (paramString2 == null) {
          throw new IllegalArgumentException("null input: value");
        }
        this.m_unmappedKeySet = null;
        return (String)this.m_valueMap.put(paramString1, paramString2);
      }
      
      public String[] toAppArgsForm(String paramString)
      {
        if (isEmpty()) {
          return IConstants.EMPTY_STRING_ARRAY;
        }
        if (paramString == null) {
          throw new IllegalArgumentException("null input: prefix");
        }
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = properties();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = getProperty(str1, "");
          localArrayList.add(paramString.concat(str1).concat("=").concat(str2));
        }
        paramString = new String[localArrayList.size()];
        localArrayList.toArray(paramString);
        return paramString;
      }
      
      public Properties toProperties()
      {
        Properties localProperties = new Properties();
        Iterator localIterator = properties();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localProperties.setProperty(str, getProperty(str));
        }
        return localProperties;
      }
      
      Set unmappedKeySet()
      {
        Object localObject = this.m_unmappedKeySet;
        if (localObject == null)
        {
          localObject = new TreeSet();
          ((Set)localObject).addAll(this.m_valueMap.keySet());
          if (this.m_delegate != null) {
            ((Set)localObject).addAll(this.m_delegate.unmappedKeySet());
          }
          this.m_unmappedKeySet = ((Set)localObject);
          return (Set)localObject;
        }
        return (Set)localObject;
      }
    }
  }
  
  public static abstract interface IMapper
  {
    public abstract String getMappedKey(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */