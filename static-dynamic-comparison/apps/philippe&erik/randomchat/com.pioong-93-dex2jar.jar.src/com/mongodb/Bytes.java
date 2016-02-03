package com.mongodb;

import java.nio.ByteOrder;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.bson.BSON;
import org.bson.types.BSONTimestamp;
import org.bson.types.Code;
import org.bson.types.CodeWScope;
import org.bson.types.ObjectId;

public class Bytes
  extends BSON
{
  static final int BATCH_INSERT_SIZE = 8388608;
  static final ObjectId COLLECTION_REF_ID;
  static final int CONNECTIONS_PER_HOST;
  static final boolean D;
  static final Logger LOGGER = Logger.getLogger("com.mongodb");
  static final int MAX_OBJECT_SIZE = 4194304;
  public static final ByteOrder ORDER;
  public static final int QUERYOPTION_AWAITDATA = 32;
  public static final int QUERYOPTION_EXHAUST = 64;
  public static final int QUERYOPTION_NOTIMEOUT = 16;
  public static final int QUERYOPTION_OPLOGREPLAY = 8;
  public static final int QUERYOPTION_PARTIAL = 128;
  public static final int QUERYOPTION_SLAVEOK = 4;
  public static final int QUERYOPTION_TAILABLE = 2;
  public static final int RESULTFLAG_AWAITCAPABLE = 8;
  public static final int RESULTFLAG_CURSORNOTFOUND = 1;
  public static final int RESULTFLAG_ERRSET = 2;
  public static final int RESULTFLAG_SHARDCONFIGSTALE = 4;
  
  static
  {
    D = Boolean.getBoolean("DEBUG.MONGO");
    if (LOGGER.getLevel() == null)
    {
      if (!D) {
        break label73;
      }
      LOGGER.setLevel(Level.ALL);
    }
    for (;;)
    {
      ORDER = ByteOrder.LITTLE_ENDIAN;
      CONNECTIONS_PER_HOST = Integer.parseInt(System.getProperty("MONGO.POOLSIZE", "10"));
      COLLECTION_REF_ID = new ObjectId(-1, -1, -1);
      return;
      label73:
      LOGGER.setLevel(Level.WARNING);
    }
  }
  
  public static byte getType(Object paramObject)
  {
    if (paramObject == null) {
      return 10;
    }
    if ((paramObject instanceof DBPointer)) {
      return 12;
    }
    if (((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)) || ((paramObject instanceof AtomicInteger))) {
      return 16;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof AtomicLong))) {
      return 18;
    }
    if ((paramObject instanceof Number)) {
      return 1;
    }
    if ((paramObject instanceof String)) {
      return 2;
    }
    if ((paramObject instanceof List)) {
      return 4;
    }
    if ((paramObject instanceof byte[])) {
      return 5;
    }
    if ((paramObject instanceof ObjectId)) {
      return 7;
    }
    if ((paramObject instanceof Boolean)) {
      return 8;
    }
    if ((paramObject instanceof Date)) {
      return 9;
    }
    if ((paramObject instanceof BSONTimestamp)) {
      return 17;
    }
    if ((paramObject instanceof Pattern)) {
      return 11;
    }
    if (((paramObject instanceof DBObject)) || ((paramObject instanceof DBRefBase))) {
      return 3;
    }
    if ((paramObject instanceof Code)) {
      return 13;
    }
    if ((paramObject instanceof CodeWScope)) {
      return 15;
    }
    return -1;
  }
  
  static class OptionHolder
  {
    boolean _hasOptions = false;
    int _options = 0;
    final OptionHolder _parent;
    
    OptionHolder(OptionHolder paramOptionHolder)
    {
      this._parent = paramOptionHolder;
    }
    
    void add(int paramInt)
    {
      set(get() | paramInt);
    }
    
    int get()
    {
      if (this._hasOptions) {
        return this._options;
      }
      if (this._parent == null) {
        return 0;
      }
      return this._parent.get();
    }
    
    void reset()
    {
      this._hasOptions = false;
    }
    
    void set(int paramInt)
    {
      this._options = paramInt;
      this._hasOptions = true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/Bytes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */