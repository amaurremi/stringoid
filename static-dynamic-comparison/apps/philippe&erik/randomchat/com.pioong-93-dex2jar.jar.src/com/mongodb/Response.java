package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.bson.io.Bits;

class Response
{
  private static final int MAX_LENGTH = 33554432;
  long _cursor;
  final int _flags;
  final ServerAddress _host;
  final int _id;
  final int _len;
  final int _num;
  final List<DBObject> _objects;
  final int _operation;
  final int _responseTo;
  final int _startingFrom;
  
  Response(ServerAddress paramServerAddress, DBCollection paramDBCollection, InputStream paramInputStream, DBDecoder paramDBDecoder)
    throws IOException
  {
    this._host = paramServerAddress;
    paramServerAddress = new byte[36];
    Bits.readFully(paramInputStream, paramServerAddress);
    this._len = Bits.readInt(paramServerAddress, 0);
    int i = 0 + 4;
    if (this._len > 33554432) {
      throw new IllegalArgumentException("response too long: " + this._len);
    }
    this._id = Bits.readInt(paramServerAddress, i);
    i += 4;
    this._responseTo = Bits.readInt(paramServerAddress, i);
    i += 4;
    this._operation = Bits.readInt(paramServerAddress, i);
    i += 4;
    this._flags = Bits.readInt(paramServerAddress, i);
    i += 4;
    this._cursor = Bits.readLong(paramServerAddress, i);
    i += 8;
    this._startingFrom = Bits.readInt(paramServerAddress, i);
    i += 4;
    this._num = Bits.readInt(paramServerAddress, i);
    paramServerAddress = new MyInputStream(paramInputStream, this._len - paramServerAddress.length);
    if (this._num < 2)
    {
      this._objects = new LinkedList();
      i = 0;
    }
    for (;;)
    {
      if (i >= this._num) {
        break label315;
      }
      if (paramServerAddress._toGo < 5)
      {
        throw new IOException("should have more objects, but only " + paramServerAddress._toGo + " bytes left");
        this._objects = new ArrayList(this._num);
        break;
      }
      this._objects.add(paramDBDecoder.decode(paramServerAddress, paramDBCollection));
      i += 1;
    }
    label315:
    if (paramServerAddress._toGo != 0) {
      throw new IOException("finished reading objects but still have: " + paramServerAddress._toGo + " bytes to read!' ");
    }
    if (this._num != this._objects.size()) {
      throw new RuntimeException("something is really broken");
    }
  }
  
  public long cursor()
  {
    return this._cursor;
  }
  
  public DBObject get(int paramInt)
  {
    return (DBObject)this._objects.get(paramInt);
  }
  
  public ServerError getError()
  {
    if (this._num != 1) {}
    DBObject localDBObject;
    do
    {
      return null;
      localDBObject = get(0);
    } while (ServerError.getMsg(localDBObject, null) == null);
    return new ServerError(localDBObject);
  }
  
  public boolean hasGetMore(int paramInt)
  {
    if (this._cursor == 0L) {}
    do
    {
      return false;
      if (this._num > 0) {
        return true;
      }
    } while ((paramInt & 0x2) == 0);
    return true;
  }
  
  public Iterator<DBObject> iterator()
  {
    return this._objects.iterator();
  }
  
  public ServerAddress serverUsed()
  {
    return this._host;
  }
  
  public int size()
  {
    return this._num;
  }
  
  public String toString()
  {
    return "flags:" + this._flags + " _cursor:" + this._cursor + " _startingFrom:" + this._startingFrom + " _num:" + this._num;
  }
  
  static class MyInputStream
    extends InputStream
  {
    final InputStream _in;
    private int _toGo;
    
    MyInputStream(InputStream paramInputStream, int paramInt)
    {
      this._in = paramInputStream;
      this._toGo = paramInt;
    }
    
    public int available()
      throws IOException
    {
      return this._in.available();
    }
    
    public void close()
    {
      throw new RuntimeException("can't close thos");
    }
    
    public int read()
      throws IOException
    {
      if (this._toGo <= 0) {
        return -1;
      }
      int i = this._in.read();
      this._toGo -= 1;
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this._toGo <= 0) {
        return -1;
      }
      paramInt1 = this._in.read(paramArrayOfByte, paramInt1, Math.min(this._toGo, paramInt2));
      this._toGo -= paramInt1;
      return paramInt1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */