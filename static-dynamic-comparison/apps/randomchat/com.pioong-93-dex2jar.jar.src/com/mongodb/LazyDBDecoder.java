package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import org.bson.LazyBSONDecoder;

public class LazyDBDecoder
  extends LazyBSONDecoder
  implements DBDecoder
{
  public static DBDecoderFactory FACTORY = new LazyDBDecoderFactory();
  
  public DBObject decode(InputStream paramInputStream, DBCollection paramDBCollection)
    throws IOException
  {
    paramDBCollection = getDBCallback(paramDBCollection);
    paramDBCollection.reset();
    decode(paramInputStream, paramDBCollection);
    return (DBObject)paramDBCollection.get();
  }
  
  public DBObject decode(byte[] paramArrayOfByte, DBCollection paramDBCollection)
  {
    paramDBCollection = getDBCallback(paramDBCollection);
    paramDBCollection.reset();
    decode(paramArrayOfByte, paramDBCollection);
    return (DBObject)paramDBCollection.get();
  }
  
  public DBCallback getDBCallback(DBCollection paramDBCollection)
  {
    return new LazyDBCallback(paramDBCollection);
  }
  
  static class LazyDBDecoderFactory
    implements DBDecoderFactory
  {
    public DBDecoder create()
    {
      return new LazyDBDecoder();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyDBDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */