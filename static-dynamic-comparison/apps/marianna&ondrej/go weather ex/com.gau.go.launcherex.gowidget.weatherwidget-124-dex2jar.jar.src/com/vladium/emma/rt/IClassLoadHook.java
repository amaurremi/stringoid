package com.vladium.emma.rt;

import com.vladium.util.ByteArrayOStream;
import java.io.IOException;

public abstract interface IClassLoadHook
{
  public abstract boolean processClassDef(String paramString, byte[] paramArrayOfByte, int paramInt, ByteArrayOStream paramByteArrayOStream)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/IClassLoadHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */