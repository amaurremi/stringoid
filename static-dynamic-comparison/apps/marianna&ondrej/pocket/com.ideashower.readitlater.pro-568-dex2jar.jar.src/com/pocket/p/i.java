package com.pocket.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.e;
import com.pocket.m.a.l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.apache.a.b.b;
import org.apache.http.util.ByteArrayBuffer;

public class i
{
  private static final String a = "/Android/data/" + g.c().getPackageName() + "/evernote_files/";
  
  public static Intent a(String paramString1, String paramString2, ArrayList paramArrayList, Context paramContext)
  {
    Object localObject = new File(Environment.getExternalStorageDirectory(), a);
    if (!"mounted".equals(Environment.getExternalStorageState())) {}
    for (;;)
    {
      return null;
      paramContext = new File((File)localObject, "file.enex");
      try
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        if (paramContext.exists()) {
          paramContext.delete();
        }
        if (paramContext.createNewFile())
        {
          localObject = new PrintWriter(new FileWriter(paramContext));
          ((PrintWriter)localObject).println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE en-note SYSTEM \"http://xml.evernote.com/pub/enml2.dtd\"><en-note>");
          ((PrintWriter)localObject).println(paramString2);
          ((PrintWriter)localObject).println("</en-note>");
          ((PrintWriter)localObject).close();
          paramString2 = new Intent("com.evernote.action.CREATE_NEW_NOTE");
          paramString2.putExtra("android.intent.extra.TITLE", paramString1);
          paramString2.putExtra("android.intent.extra.STREAM", paramArrayList);
          paramString2.putExtra("EXTRA_ENML", Uri.fromFile(paramContext));
          paramString2.putExtra("QUICK_SEND", true);
          return paramString2;
        }
      }
      catch (IOException paramString1)
      {
        e.a(paramString1);
      }
    }
    return null;
  }
  
  public static j a(com.ideashower.readitlater.e.a parama)
  {
    int i = 0;
    label351:
    for (;;)
    {
      Object localObject3;
      Object localObject1;
      Object localObject4;
      Object localObject2;
      try
      {
        localObject3 = new File(Environment.getExternalStorageDirectory(), a);
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject1 = "";
        localObject4 = parama.a();
        int j = ((String)localObject4).lastIndexOf(".");
        if (j < 0) {
          break label351;
        }
        localObject2 = ((String)localObject4).substring(j + 1);
        localObject1 = localObject2;
        if (!((String)localObject2).contains("?")) {
          break label351;
        }
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("?"));
        localObject2 = com.pocket.m.a.a.a((String)localObject4, 1, l.c());
        if (!((com.pocket.m.a.a)localObject2).j()) {
          return null;
        }
        localObject4 = new File(((com.pocket.m.a.a)localObject2).c());
        localObject2 = new File((File)localObject3, "img_" + parama.b() + "." + (String)localObject1);
        b.a((File)localObject4, (File)localObject2);
        parama = new BufferedInputStream(new FileInputStream((File)localObject4));
        localObject3 = new ByteArrayBuffer(5000);
        j = parama.read();
        if (j != -1)
        {
          ((ByteArrayBuffer)localObject3).append((byte)j);
          continue;
        }
        parama.close();
      }
      catch (IOException parama)
      {
        parama.printStackTrace();
        return null;
      }
      parama = "";
      try
      {
        localObject4 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject4).update(((ByteArrayBuffer)localObject3).toByteArray());
        localObject3 = ((MessageDigest)localObject4).digest();
        while (i < localObject3.length)
        {
          parama = parama + Integer.toString((localObject3[i] & 0xFF) + 256, 16).substring(1);
          i += 1;
        }
        localObject3 = new j();
      }
      catch (NoSuchAlgorithmException parama)
      {
        parama.printStackTrace();
        return null;
      }
      ((j)localObject3).b = ((File)localObject2);
      ((j)localObject3).a = parama;
      ((j)localObject3).c = ((String)localObject1);
      return (j)localObject3;
    }
  }
  
  public static void a()
  {
    try
    {
      File localFile = new File(Environment.getExternalStorageDirectory(), a);
      if ((localFile != null) && (localFile.isDirectory()))
      {
        String[] arrayOfString = localFile.list();
        int i = 0;
        while (i < arrayOfString.length)
        {
          new File(localFile, arrayOfString[i]).delete();
          i += 1;
        }
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      e.a(localException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */