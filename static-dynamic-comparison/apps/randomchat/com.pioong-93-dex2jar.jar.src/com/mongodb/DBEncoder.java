package com.mongodb;

import org.bson.BSONObject;
import org.bson.io.OutputBuffer;

public abstract interface DBEncoder
{
  public abstract int writeObject(OutputBuffer paramOutputBuffer, BSONObject paramBSONObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */