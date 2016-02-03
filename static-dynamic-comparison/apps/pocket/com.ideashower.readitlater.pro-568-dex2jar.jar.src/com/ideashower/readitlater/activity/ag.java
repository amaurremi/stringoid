package com.ideashower.readitlater.activity;

import android.app.AlertDialog.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.b.c.c;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a.o;
import com.ideashower.readitlater.g.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.views.AvatarEditorView;
import com.ideashower.readitlater.views.toolbars.SaveCancelToolbar;
import com.ideashower.readitlater.views.toolbars.a;
import com.pocket.p.k;
import java.io.File;
import java.io.IOException;
import org.apache.a.b.b;

public class ag
  extends f
{
  protected Uri Y;
  private SaveCancelToolbar Z;
  private AvatarEditorView aa;
  private View ab;
  private com.ideashower.readitlater.activity.a.l ac;
  private String ad;
  private int ae;
  
  public static com.pocket.p.l Y()
  {
    if (j.g()) {
      return com.pocket.p.l.a;
    }
    return com.pocket.p.l.b;
  }
  
  private void Z()
  {
    Bitmap localBitmap = this.aa.getCroppedBitmap();
    if (localBitmap == null)
    {
      a(null, false);
      return;
    }
    this.ac = com.ideashower.readitlater.activity.a.l.a(2131493142, null, false);
    this.ac.a(m());
    this.ac.a(new com.ideashower.readitlater.activity.a.p()
    {
      public void a(o paramAnonymouso)
      {
        ag.a(ag.this, null);
      }
      
      public void b(o paramAnonymouso)
      {
        ag.a(ag.this, null);
      }
    });
    new ah(this, localBitmap, null).h();
  }
  
  public static ag a(int paramInt, String paramString)
  {
    ag localag = new ag();
    Bundle localBundle = new Bundle();
    localBundle.putInt("requestType", paramInt);
    localBundle.putString("tempPath", paramString);
    localag.g(localBundle);
    return localag;
  }
  
  private void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.ac != null)
    {
      this.ac.a();
      this.ac = null;
    }
    paramBitmap.recycle();
    if (paramBoolean)
    {
      P();
      return;
    }
    new AlertDialog.Builder(m()).setTitle(2131493090).setMessage(2131493134).setPositiveButton(2131492924, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ag.this.P();
      }
    });
  }
  
  private void a(final Uri paramUri)
  {
    if (paramUri == null)
    {
      e(-2);
      return;
    }
    final Object localObject = b(paramUri);
    if (localObject == null)
    {
      localObject = m().getContentResolver();
      new m()
      {
        /* Error */
        protected void a()
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore 4
          //   3: aload_0
          //   4: getfield 22	com/ideashower/readitlater/activity/ag$4:a	Ljava/lang/String;
          //   7: invokestatic 35	com/pocket/m/d/d:a	(Ljava/lang/String;)Ljava/io/File;
          //   10: pop
          //   11: aload_0
          //   12: getfield 24	com/ideashower/readitlater/activity/ag$4:b	Landroid/content/ContentResolver;
          //   15: aload_0
          //   16: getfield 26	com/ideashower/readitlater/activity/ag$4:c	Landroid/net/Uri;
          //   19: invokevirtual 41	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
          //   22: astore_2
          //   23: new 43	java/io/BufferedOutputStream
          //   26: dup
          //   27: new 45	java/io/FileOutputStream
          //   30: dup
          //   31: aload_0
          //   32: getfield 22	com/ideashower/readitlater/activity/ag$4:a	Ljava/lang/String;
          //   35: invokespecial 48	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
          //   38: invokespecial 51	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
          //   41: astore_3
          //   42: sipush 2048
          //   45: newarray <illegal type>
          //   47: astore 4
          //   49: aload_2
          //   50: aload 4
          //   52: invokevirtual 57	java/io/InputStream:read	([B)I
          //   55: istore_1
          //   56: iload_1
          //   57: ifle +33 -> 90
          //   60: aload_3
          //   61: aload 4
          //   63: iconst_0
          //   64: iload_1
          //   65: invokevirtual 61	java/io/BufferedOutputStream:write	([BII)V
          //   68: goto -19 -> 49
          //   71: astore 5
          //   73: aload_2
          //   74: astore 4
          //   76: aload 5
          //   78: astore_2
          //   79: aload 4
          //   81: invokestatic 66	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
          //   84: aload_3
          //   85: invokestatic 68	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
          //   88: aload_2
          //   89: athrow
          //   90: aload_2
          //   91: invokestatic 66	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
          //   94: aload_3
          //   95: invokestatic 68	org/apache/a/b/d:a	(Ljava/io/OutputStream;)V
          //   98: return
          //   99: astore_2
          //   100: aconst_null
          //   101: astore_3
          //   102: goto -23 -> 79
          //   105: astore 5
          //   107: aconst_null
          //   108: astore_3
          //   109: aload_2
          //   110: astore 4
          //   112: aload 5
          //   114: astore_2
          //   115: goto -36 -> 79
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	118	0	this	4
          //   55	10	1	i	int
          //   22	69	2	localObject1	Object
          //   99	11	2	localObject2	Object
          //   114	1	2	localObject3	Object
          //   41	68	3	localBufferedOutputStream	java.io.BufferedOutputStream
          //   1	110	4	localObject4	Object
          //   71	6	5	localObject5	Object
          //   105	8	5	localObject6	Object
          // Exception table:
          //   from	to	target	type
          //   42	49	71	finally
          //   49	56	71	finally
          //   60	68	71	finally
          //   3	23	99	finally
          //   23	42	105	finally
        }
        
        protected void a(boolean paramAnonymousBoolean, Throwable paramAnonymousThrowable)
        {
          if (paramAnonymousBoolean)
          {
            ag.a(ag.this, this.a);
            return;
          }
          ag.a(ag.this, -2);
        }
      }.h();
      return;
    }
    a((String)localObject);
  }
  
  public static void a(android.support.v4.app.f paramf, int paramInt, String paramString)
  {
    if (Y() == com.pocket.p.l.a)
    {
      k.a(a(paramInt, paramString), paramf);
      return;
    }
    PhotoEditorActivity.b(paramf, paramInt, paramString);
  }
  
  private void a(String paramString)
  {
    if (this.aa.a(paramString))
    {
      this.ab.setClickable(false);
      c.a(this.ab).k(0.0F).a(333L);
      return;
    }
    e(-2);
  }
  
  private void aa()
  {
    b.c(new File(this.ad));
  }
  
  private void ab()
  {
    Object localObject = null;
    this.ae = l().getInt("requestType");
    Intent localIntent;
    switch (this.ae)
    {
    default: 
      localIntent = null;
    }
    for (;;)
    {
      if (localIntent != null) {
        a(Intent.createChooser(localIntent, (CharSequence)localObject), this.ae);
      }
      return;
      localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      this.Y = ac();
      if (this.Y != null)
      {
        localObject = new File(this.ad.substring(0, this.ad.lastIndexOf(File.separator)));
        if (!((File)localObject).exists()) {}
        try
        {
          b.g((File)localObject);
          localIntent.putExtra("output", this.Y);
          localObject = a(2131492955);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            e.a(localIOException);
          }
        }
      }
      else
      {
        new AlertDialog.Builder(m()).setTitle(2131493150).setMessage(2131493058).show();
        continue;
        localIntent = new Intent("android.intent.action.PICK");
        localIntent.setType("image/*");
        String str = a(2131492897);
      }
    }
  }
  
  private Uri ac()
  {
    return Uri.fromFile(new File(this.ad));
  }
  
  private static String b(Uri paramUri)
  {
    Object localObject2 = null;
    String str = paramUri.toString();
    if (str.startsWith("file://")) {
      localObject1 = str.substring(7);
    }
    do
    {
      return (String)localObject1;
      localObject1 = str;
    } while (str.startsWith("/"));
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "_data";
    Object localObject1 = g.c().getContentResolver().query(paramUri, arrayOfString, null, null, null);
    if (((Cursor)localObject1).moveToFirst()) {}
    for (paramUri = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex(arrayOfString[0]));; paramUri = str)
    {
      ((Cursor)localObject1).close();
      if ((paramUri != null) && (!paramUri.startsWith("/")))
      {
        localObject1 = localObject2;
        if (!paramUri.toLowerCase().startsWith("file://")) {
          break;
        }
      }
      return paramUri;
    }
  }
  
  private void e(int paramInt)
  {
    p.e(paramInt);
    P();
  }
  
  public String K()
  {
    return "edit_avatar_photo";
  }
  
  public boolean W()
  {
    aa();
    return super.W();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (paramInt2 == -1) {
        a(this.Y);
      }
    }
    while (paramInt1 != 2)
    {
      return;
      if (paramInt2 == 0)
      {
        e(-1);
        return;
      }
      e(-2);
      return;
    }
    if (paramInt2 == -1)
    {
      a(paramIntent.getData());
      return;
    }
    if (paramInt2 == 0)
    {
      e(-1);
      return;
    }
    e(-2);
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903045, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.ad = l().getString("tempPath");
    this.Z = ((SaveCancelToolbar)c(2131230742));
    this.aa = ((AvatarEditorView)c(2131230730));
    this.ab = c(2131230757);
    this.Z.setIsRainbowified(true);
    this.Z.setOnActionTakenListener(new a()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          ag.a(ag.this);
          return;
        }
        ag.b(ag.this);
        ag.this.P();
      }
    });
    if (paramBundle == null) {
      ab();
    }
  }
  
  public void y()
  {
    this.aa.c();
    super.y();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */