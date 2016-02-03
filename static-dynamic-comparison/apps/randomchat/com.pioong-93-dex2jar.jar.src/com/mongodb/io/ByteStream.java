package com.mongodb.io;

import java.nio.ByteBuffer;

public abstract interface ByteStream
{
  public abstract boolean hasMore();
  
  public abstract int write(ByteBuffer paramByteBuffer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/io/ByteStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */