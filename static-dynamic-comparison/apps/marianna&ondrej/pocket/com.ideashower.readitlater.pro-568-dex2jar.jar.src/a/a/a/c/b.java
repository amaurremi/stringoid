package a.a.a.c;

import a.a.a.a.a;
import a.a.a.g;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class b
  extends AsyncTask
{
  private Context a;
  private a b;
  private String c;
  private String d;
  private String e;
  private ProgressDialog f;
  
  public b(Context paramContext, String paramString, a parama)
  {
    this.a = paramContext;
    this.c = paramString;
    this.d = (UUID.randomUUID() + ".apk");
    this.e = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    this.b = parama;
  }
  
  private String b()
  {
    return this.c + "&type=apk";
  }
  
  protected Boolean a(String... paramVarArgs)
  {
    int i;
    try
    {
      paramVarArgs = a(new URL(b()));
      paramVarArgs.connect();
      i = paramVarArgs.getContentLength();
      localObject = new File(this.e);
      if ((!((File)localObject).mkdirs()) && (!((File)localObject).exists())) {
        throw new IOException("Could not create the dir(s):" + ((File)localObject).getAbsolutePath());
      }
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      return Boolean.valueOf(false);
    }
    Object localObject = new File((File)localObject, this.d);
    paramVarArgs = new BufferedInputStream(paramVarArgs.getInputStream());
    localObject = new FileOutputStream((File)localObject);
    byte[] arrayOfByte = new byte['Ѐ'];
    long l = 0L;
    for (;;)
    {
      int j = paramVarArgs.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      l += j;
      publishProgress(new Integer[] { Integer.valueOf((int)(100L * l / i)) });
      ((OutputStream)localObject).write(arrayOfByte, 0, j);
    }
    ((OutputStream)localObject).flush();
    ((OutputStream)localObject).close();
    paramVarArgs.close();
    if (l > 0L) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  protected URLConnection a(URL paramURL)
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.addRequestProperty("User-Agent", "HockeySDK/Android");
    paramURL.setInstanceFollowRedirects(true);
    if (Build.VERSION.SDK_INT <= 9) {
      paramURL.setRequestProperty("connection", "close");
    }
    return paramURL;
  }
  
  public void a()
  {
    this.a = null;
    this.f = null;
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (this.f != null) {}
    try
    {
      this.f.dismiss();
      if (paramBoolean.booleanValue())
      {
        this.b.a(this);
        paramBoolean = new Intent("android.intent.action.VIEW");
        paramBoolean.setDataAndType(Uri.fromFile(new File(this.e, this.d)), "application/vnd.android.package-archive");
        paramBoolean.setFlags(268435456);
        this.a.startActivity(paramBoolean);
        return;
      }
      try
      {
        paramBoolean = new AlertDialog.Builder(this.a);
        paramBoolean.setTitle(g.a(this.b, 4));
        paramBoolean.setMessage(g.a(this.b, 5));
        paramBoolean.setNegativeButton(g.a(this.b, 6), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            b.a(b.this).a(b.this, Boolean.valueOf(false));
          }
        });
        paramBoolean.setPositiveButton(g.a(this.b, 7), new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            b.a(b.this).a(b.this, Boolean.valueOf(true));
          }
        });
        paramBoolean.create().show();
        return;
      }
      catch (Exception paramBoolean) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void a(Integer... paramVarArgs)
  {
    try
    {
      if (this.f == null)
      {
        this.f = new ProgressDialog(this.a);
        this.f.setProgressStyle(1);
        this.f.setMessage("Loading...");
        this.f.setCancelable(false);
        this.f.show();
      }
      this.f.setProgress(paramVarArgs[0].intValue());
      return;
    }
    catch (Exception paramVarArgs) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */