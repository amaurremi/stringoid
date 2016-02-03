package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import org.bson.BasicBSONDecoder;

public class DefaultDBDecoder
  extends BasicBSONDecoder
  implements DBDecoder
{
  public static DBDecoderFactory FACTORY = new DefaultFactory();
  
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
    return new DefaultDBCallback(paramDBCollection);
  }
  
  public String toString()
  {
    return "DefaultDBDecoder";
  }
  
  static class DefaultFactory
    implements DBDecoderFactory
  {
    public DBDecoder create()
    {
      return new DefaultDBDecoder();
    }
    
    public String toString()
    {
      return "DefaultDBDecoder.DefaultFactory";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DefaultDBDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */