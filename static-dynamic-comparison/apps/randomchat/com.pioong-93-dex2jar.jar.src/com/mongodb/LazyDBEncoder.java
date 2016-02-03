package com.mongodb;

import java.io.IOException;
import org.bson.BSONObject;
import org.bson.io.OutputBuffer;

public class LazyDBEncoder
  implements DBEncoder
{
  public int writeObject(OutputBuffer paramOutputBuffer, BSONObject paramBSONObject)
  {
    if (!(paramBSONObject instanceof LazyDBObject)) {
      throw new IllegalArgumentException("LazyDBEncoder can only encode BSONObject instances of type LazyDBObject");
    }
    paramBSONObject = (LazyDBObject)paramBSONObject;
    try
    {
      paramBSONObject.pipe(paramOutputBuffer);
      return paramBSONObject.getBSONSize();
    }
    catch (IOException paramOutputBuffer)
    {
      throw new MongoException("Exception serializing a LazyDBObject", paramOutputBuffer);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/LazyDBEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */