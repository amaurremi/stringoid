package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import org.bson.BSONDecoder;

public abstract interface DBDecoder
  extends BSONDecoder
{
  public abstract DBObject decode(InputStream paramInputStream, DBCollection paramDBCollection)
    throws IOException;
  
  public abstract DBObject decode(byte[] paramArrayOfByte, DBCollection paramDBCollection);
  
  public abstract DBCallback getDBCallback(DBCollection paramDBCollection);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */