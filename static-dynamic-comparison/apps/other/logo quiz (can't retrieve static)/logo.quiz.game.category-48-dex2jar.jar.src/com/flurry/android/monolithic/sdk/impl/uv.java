package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class uv
  extends um<UUID>
{
  public uv()
  {
    super(UUID.class);
  }
  
  protected UUID b(Object paramObject, qm paramqm)
    throws IOException, oz
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      if (paramObject.length != 16) {
        paramqm.b("Can only construct UUIDs from 16 byte arrays; got " + paramObject.length + " bytes");
      }
      paramObject = new DataInputStream(new ByteArrayInputStream((byte[])paramObject));
      return new UUID(((DataInputStream)paramObject).readLong(), ((DataInputStream)paramObject).readLong());
    }
    super.a(paramObject, paramqm);
    return null;
  }
  
  protected UUID b(String paramString, qm paramqm)
    throws IOException, oz
  {
    return UUID.fromString(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/uv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */