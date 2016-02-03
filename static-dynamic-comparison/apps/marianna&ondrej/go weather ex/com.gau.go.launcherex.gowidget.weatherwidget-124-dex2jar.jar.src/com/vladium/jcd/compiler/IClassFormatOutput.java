package com.vladium.jcd.compiler;

import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;

public abstract interface IClassFormatOutput
{
  public abstract void writeInClassFormat(UDataOutputStream paramUDataOutputStream)
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/compiler/IClassFormatOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */