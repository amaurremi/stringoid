package com.appflood.mraid;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.widget.Toast;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.c;
import com.appflood.e.j;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

final class k
  extends d
{
  k(Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView)
  {
    super(paramMap, paramAFBannerWebView);
  }
  
  static boolean a(Bitmap paramBitmap, String paramString)
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "MraidImage");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    String str = "jpg";
    int i = paramString.lastIndexOf("/");
    Date localDate;
    if (i >= 0)
    {
      paramString = paramString.substring(i + 1);
      if (paramString.contains("."))
      {
        paramString = paramString.split(".");
        if (paramString.length > 0)
        {
          localDate = paramString[0];
          if (j.a(paramString[(paramString.length - 1)]))
          {
            paramString = str;
            str = paramString;
          }
        }
      }
    }
    for (paramString = localDate;; paramString = "")
    {
      j.c(" name " + paramString + " suffix " + str);
      localDate = new Date(System.currentTimeMillis());
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
      paramString = new File(localFile, paramString + localSimpleDateFormat.format(localDate) + "." + str);
      try
      {
        paramString.createNewFile();
        paramString = new FileOutputStream(paramString);
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 50, paramString);
        paramString.flush();
        paramString.close();
        return true;
      }
      catch (FileNotFoundException paramBitmap)
      {
        paramBitmap.printStackTrace();
        return false;
      }
      catch (IOException paramBitmap)
      {
        for (;;)
        {
          paramBitmap.printStackTrace();
        }
      }
      paramString = paramString[(paramString.length - 1)];
      break;
      str = "jpg";
    }
  }
  
  public final void a()
  {
    final String str = b("uri");
    new AlertDialog.Builder(this.b.getContext()).setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new b(str, (byte)0);
        paramAnonymousDialogInterface.a(new b.a()
        {
          public final void a(b paramAnonymous2b)
          {
            Bitmap localBitmap = paramAnonymous2b.d();
            String str2 = MediaStore.Images.Media.insertImage(k.this.b.getContext().getContentResolver(), localBitmap, "appflood", "cpm");
            new StringBuilder("finish url ").append(str2).toString();
            j.a();
            String str1 = "Download complete!";
            paramAnonymous2b = str1;
            if (j.a(str2)) {
              if (c.i)
              {
                paramAnonymous2b = k.this;
                paramAnonymous2b = str1;
                if (k.a(localBitmap, k.1.this.a)) {}
              }
              else
              {
                paramAnonymous2b = "Download failed!";
              }
            }
            Toast.makeText(k.this.b.getContext(), paramAnonymous2b, 0).show();
          }
          
          public final void a(b paramAnonymous2b, int paramAnonymous2Int)
          {
            Toast.makeText(k.this.b.getContext(), "Download failed!", 0).show();
          }
        });
        paramAnonymousDialogInterface.f();
      }
    }).setNegativeButton("Cancel", null).setTitle("Add photo").setMessage("Sure you want to download?").show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */