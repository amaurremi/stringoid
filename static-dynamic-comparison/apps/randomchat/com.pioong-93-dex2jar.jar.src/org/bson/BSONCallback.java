package org.bson;

import org.bson.types.ObjectId;

public abstract interface BSONCallback
{
  public abstract Object arrayDone();
  
  public abstract void arrayStart();
  
  public abstract void arrayStart(String paramString);
  
  public abstract BSONCallback createBSONCallback();
  
  public abstract Object get();
  
  public abstract void gotBinary(String paramString, byte paramByte, byte[] paramArrayOfByte);
  
  @Deprecated
  public abstract void gotBinaryArray(String paramString, byte[] paramArrayOfByte);
  
  public abstract void gotBoolean(String paramString, boolean paramBoolean);
  
  public abstract void gotCode(String paramString1, String paramString2);
  
  public abstract void gotCodeWScope(String paramString1, String paramString2, Object paramObject);
  
  public abstract void gotDBRef(String paramString1, String paramString2, ObjectId paramObjectId);
  
  public abstract void gotDate(String paramString, long paramLong);
  
  public abstract void gotDouble(String paramString, double paramDouble);
  
  public abstract void gotInt(String paramString, int paramInt);
  
  public abstract void gotLong(String paramString, long paramLong);
  
  public abstract void gotMaxKey(String paramString);
  
  public abstract void gotMinKey(String paramString);
  
  public abstract void gotNull(String paramString);
  
  public abstract void gotObjectId(String paramString, ObjectId paramObjectId);
  
  public abstract void gotRegex(String paramString1, String paramString2, String paramString3);
  
  public abstract void gotString(String paramString1, String paramString2);
  
  public abstract void gotSymbol(String paramString1, String paramString2);
  
  public abstract void gotTimestamp(String paramString, int paramInt1, int paramInt2);
  
  public abstract void gotUUID(String paramString, long paramLong1, long paramLong2);
  
  public abstract void gotUndefined(String paramString);
  
  public abstract Object objectDone();
  
  public abstract void objectStart();
  
  public abstract void objectStart(String paramString);
  
  public abstract void objectStart(boolean paramBoolean);
  
  public abstract void reset();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BSONCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */