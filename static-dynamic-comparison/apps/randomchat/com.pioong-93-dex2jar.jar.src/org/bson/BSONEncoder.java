package org.bson;

import org.bson.io.OutputBuffer;

public abstract interface BSONEncoder
{
  public abstract void done();
  
  public abstract byte[] encode(BSONObject paramBSONObject);
  
  public abstract int putObject(BSONObject paramBSONObject);
  
  public abstract void set(OutputBuffer paramOutputBuffer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BSONEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */