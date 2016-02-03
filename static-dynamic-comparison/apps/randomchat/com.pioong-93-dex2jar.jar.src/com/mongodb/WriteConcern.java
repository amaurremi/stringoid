package com.mongodb;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class WriteConcern
  implements Serializable
{
  public static final WriteConcern ACKNOWLEDGED;
  public static final WriteConcern ERRORS_IGNORED = new WriteConcern(-1);
  public static final WriteConcern FSYNCED;
  public static final WriteConcern FSYNC_SAFE = new WriteConcern(true);
  public static final WriteConcern JOURNALED;
  public static final WriteConcern JOURNAL_SAFE = new WriteConcern(1, 0, false, true);
  public static final WriteConcern MAJORITY;
  public static final WriteConcern NONE;
  public static final WriteConcern NORMAL;
  public static final WriteConcern REPLICAS_SAFE = new WriteConcern(2);
  public static final WriteConcern REPLICA_ACKNOWLEDGED;
  public static final WriteConcern SAFE;
  public static final WriteConcern UNACKNOWLEDGED;
  private static Map<String, WriteConcern> _namedConcerns = null;
  private static final long serialVersionUID = 1884671104750417011L;
  boolean _continueOnErrorForInsert = false;
  boolean _fsync = false;
  boolean _j = false;
  Object _w = Integer.valueOf(0);
  int _wtimeout = 0;
  
  static
  {
    ACKNOWLEDGED = new WriteConcern(1);
    UNACKNOWLEDGED = new WriteConcern(0);
    FSYNCED = new WriteConcern(true);
    JOURNALED = new WriteConcern(1, 0, false, true);
    REPLICA_ACKNOWLEDGED = new WriteConcern(2);
    NONE = new WriteConcern(-1);
    NORMAL = new WriteConcern(0);
    SAFE = new WriteConcern(1);
    MAJORITY = new Majority();
  }
  
  public WriteConcern()
  {
    this(0);
  }
  
  public WriteConcern(int paramInt)
  {
    this(paramInt, 0, false);
  }
  
  public WriteConcern(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, false);
  }
  
  public WriteConcern(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramBoolean, false);
  }
  
  public WriteConcern(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramInt1, paramInt2, paramBoolean1, paramBoolean2, false);
  }
  
  public WriteConcern(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this._w = Integer.valueOf(paramInt1);
    this._wtimeout = paramInt2;
    this._fsync = paramBoolean1;
    this._j = paramBoolean2;
    this._continueOnErrorForInsert = paramBoolean3;
  }
  
  public WriteConcern(String paramString)
  {
    this(paramString, 0, false, false);
  }
  
  public WriteConcern(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, false);
  }
  
  public WriteConcern(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("w can not be null");
    }
    this._w = paramString;
    this._wtimeout = paramInt;
    this._fsync = paramBoolean1;
    this._j = paramBoolean2;
    this._continueOnErrorForInsert = paramBoolean3;
  }
  
  public WriteConcern(boolean paramBoolean)
  {
    this(1, 0, paramBoolean);
  }
  
  public static Majority majorityWriteConcern(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new Majority(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public static WriteConcern valueOf(String paramString)
  {
    if (_namedConcerns == null)
    {
      HashMap localHashMap = new HashMap(8, 1.0F);
      Field[] arrayOfField = WriteConcern.class.getFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if ((Modifier.isStatic(localField.getModifiers())) && (localField.getType().equals(WriteConcern.class))) {}
        try
        {
          localHashMap.put(localField.getName().toLowerCase(), (WriteConcern)localField.get(null));
          i += 1;
        }
        catch (Exception paramString)
        {
          throw new RuntimeException(paramString);
        }
      }
      _namedConcerns = localHashMap;
    }
    return (WriteConcern)_namedConcerns.get(paramString.toLowerCase());
  }
  
  public boolean callGetLastError()
  {
    boolean bool = true;
    if ((this._w instanceof Integer)) {
      return ((Integer)this._w).intValue() > 0;
    }
    if (this._w != null) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public WriteConcern continueOnErrorForInsert(boolean paramBoolean)
  {
    if ((this._w instanceof Integer)) {
      return new WriteConcern(((Integer)this._w).intValue(), this._wtimeout, this._fsync, this._j, paramBoolean);
    }
    if ((this._w instanceof String)) {
      return new WriteConcern((String)this._w, this._wtimeout, this._fsync, this._j, paramBoolean);
    }
    throw new IllegalStateException("The w parameter must be an int or a String");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (WriteConcern)paramObject;
      if (this._continueOnErrorForInsert != ((WriteConcern)paramObject)._continueOnErrorForInsert) {
        return false;
      }
      if (this._fsync != ((WriteConcern)paramObject)._fsync) {
        return false;
      }
      if (this._j != ((WriteConcern)paramObject)._j) {
        return false;
      }
      if (this._wtimeout != ((WriteConcern)paramObject)._wtimeout) {
        return false;
      }
    } while (this._w.equals(((WriteConcern)paramObject)._w));
    return false;
  }
  
  public boolean fsync()
  {
    return this._fsync;
  }
  
  public BasicDBObject getCommand()
  {
    BasicDBObject localBasicDBObject = new BasicDBObject("getlasterror", Integer.valueOf(1));
    if ((((this._w instanceof Integer)) && (((Integer)this._w).intValue() > 1)) || ((this._w instanceof String))) {
      localBasicDBObject.put("w", this._w);
    }
    if (this._wtimeout > 0) {
      localBasicDBObject.put("wtimeout", Integer.valueOf(this._wtimeout));
    }
    if (this._fsync) {
      localBasicDBObject.put("fsync", Boolean.valueOf(true));
    }
    if (this._j) {
      localBasicDBObject.put("j", Boolean.valueOf(true));
    }
    return localBasicDBObject;
  }
  
  public boolean getContinueOnErrorForInsert()
  {
    return this._continueOnErrorForInsert;
  }
  
  public boolean getFsync()
  {
    return this._fsync;
  }
  
  public boolean getJ()
  {
    return this._j;
  }
  
  public int getW()
  {
    return ((Integer)this._w).intValue();
  }
  
  public Object getWObject()
  {
    return this._w;
  }
  
  public String getWString()
  {
    return this._w.toString();
  }
  
  public int getWtimeout()
  {
    return this._wtimeout;
  }
  
  public int hashCode()
  {
    int k = 1;
    int m = this._w.hashCode();
    int n = this._wtimeout;
    int i;
    int j;
    if (this._fsync)
    {
      i = 1;
      if (!this._j) {
        break label71;
      }
      j = 1;
      label35:
      if (!this._continueOnErrorForInsert) {
        break label76;
      }
    }
    for (;;)
    {
      return (((m * 31 + n) * 31 + i) * 31 + j) * 31 + k;
      i = 0;
      break;
      label71:
      j = 0;
      break label35;
      label76:
      k = 0;
    }
  }
  
  public boolean raiseNetworkErrors()
  {
    boolean bool = true;
    if ((this._w instanceof Integer)) {
      return ((Integer)this._w).intValue() >= 0;
    }
    if (this._w != null) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void setWObject(Object paramObject)
  {
    if ((!(paramObject instanceof Integer)) && (!(paramObject instanceof String))) {
      throw new IllegalArgumentException("The w parameter must be an int or a String");
    }
    this._w = paramObject;
  }
  
  public String toString()
  {
    return "WriteConcern " + getCommand() + " / (Continue Inserting on Errors? " + getContinueOnErrorForInsert() + ")";
  }
  
  public static class Majority
    extends WriteConcern
  {
    private static final long serialVersionUID = -4128295115883875212L;
    
    public Majority()
    {
      super(0, false, false);
    }
    
    public Majority(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramInt, paramBoolean1, paramBoolean2);
    }
    
    public String toString()
    {
      return "[Majority] WriteConcern " + getCommand();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/WriteConcern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */