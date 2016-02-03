package com.ideashower.readitlater.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class w
{
  public static String a(String paramString)
  {
    if ("UTF-8".equals(paramString)) {
      return new String(new byte[] { -17, -69, -65 }, paramString);
    }
    if ("UTF-16BE".equals(paramString)) {
      return new String(new byte[] { -2, -1 }, paramString);
    }
    if ("UTF-16LE".equals(paramString)) {
      return new String(new byte[] { -1, -2 }, paramString);
    }
    if ("UTF-32BE".equals(paramString)) {
      return new String(new byte[] { 0, 0, -2, -1 }, paramString);
    }
    if ("UTF-32LE".equals(paramString)) {
      return new String(new byte[] { 0, 0, -1, -2 }, paramString);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    x localx = new x(new ByteArrayInputStream(paramArrayOfByte), "ASCII");
    if (a(paramString) != null) {}
    Object localObject2;
    for (int i = 1;; i = 0)
    {
      String str = localx.a();
      localObject2 = a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a(paramString);
      }
      localx.close();
      localObject2 = new ByteArrayOutputStream();
      paramArrayOfByte = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte, localx.c(), paramArrayOfByte.length), str));
      paramString = new BufferedWriter(new OutputStreamWriter((OutputStream)localObject2, paramString));
      if ((localObject1 != null) && (i != 0)) {
        paramString.write((String)localObject1);
      }
      localObject1 = new char['က'];
      for (;;)
      {
        i = paramArrayOfByte.read((char[])localObject1);
        if (i == -1) {
          break;
        }
        paramString.write((char[])localObject1, 0, i);
      }
    }
    paramArrayOfByte.close();
    paramString.close();
    return ((ByteArrayOutputStream)localObject2).toByteArray();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */