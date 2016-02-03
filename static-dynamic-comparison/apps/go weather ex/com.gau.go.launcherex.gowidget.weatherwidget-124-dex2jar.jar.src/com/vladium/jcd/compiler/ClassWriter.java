package com.vladium.jcd.compiler;

import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.lib.UDataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class ClassWriter
{
  public static void writeClassTable(ClassDef paramClassDef, OutputStream paramOutputStream)
    throws IOException
  {
    paramClassDef.writeInClassFormat(new UDataOutputStream(paramOutputStream));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/jcd/compiler/ClassWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */