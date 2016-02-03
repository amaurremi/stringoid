package com.mobisystems.mobiscanner.error;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.util.Xml;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.xmlpull.v1.XmlSerializer;

public class c
{
  private Context ZB;
  private File aHc;
  private File aHd;
  private ZipOutputStream aHe;
  private XmlSerializer aHf;
  
  public c(Context paramContext, File paramFile)
  {
    this.ZB = paramContext;
    paramFile.mkdirs();
    this.aHd = new File(paramFile, "error_report.zip");
    this.aHe = new ZipOutputStream(new FileOutputStream(this.aHd));
    this.aHf = Xml.newSerializer();
    HT();
  }
  
  private void HT()
  {
    Object localObject = new ZipEntry("environment.xml");
    this.aHe.putNextEntry((ZipEntry)localObject);
    this.aHf.setOutput(this.aHe, "UTF-8");
    this.aHf.startDocument("UTF-8", Boolean.valueOf(true));
    this.aHf.startTag("", "environment");
    this.aHf.startTag("", "report");
    this.aHf.attribute("", "version", "1");
    this.aHf.endTag("", "report");
    this.aHf.startTag("", "product");
    localObject = HU();
    this.aHf.attribute("", "package_name", ((PackageInfo)localObject).packageName);
    this.aHf.attribute("", "version_name", ((PackageInfo)localObject).versionName);
    this.aHf.attribute("", "version_code", String.valueOf(((PackageInfo)localObject).versionCode));
    this.aHf.endTag("", "product");
    this.aHf.startTag("", "platform");
    this.aHf.attribute("", "BOARD", Build.BOARD);
    this.aHf.attribute("", "BRAND", Build.BRAND);
    this.aHf.attribute("", "DEVICE", Build.DEVICE);
    this.aHf.attribute("", "FINGERPRINT", Build.FINGERPRINT);
    this.aHf.attribute("", "HOST", Build.HOST);
    this.aHf.attribute("", "ID", Build.ID);
    this.aHf.attribute("", "MODEL", Build.MODEL);
    this.aHf.attribute("", "PRODUCT", Build.PRODUCT);
    this.aHf.attribute("", "TAGS", Build.TAGS);
    this.aHf.attribute("", "TIME", String.valueOf(Build.TIME));
    this.aHf.attribute("", "TYPE", Build.TYPE);
    this.aHf.attribute("", "USER", Build.USER);
    this.aHf.endTag("", "platform");
    this.aHf.endDocument();
    this.aHe.closeEntry();
  }
  
  private PackageInfo HU()
  {
    return this.ZB.getPackageManager().getPackageInfo(this.ZB.getPackageName(), 0);
  }
  
  public void HV()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject5 = new ZipEntry("logcat.txt");
    this.aHe.putNextEntry((ZipEntry)localObject5);
    for (;;)
    {
      try
      {
        localObject5 = new ProcessBuilder(new String[0]).command(new String[] { "logcat", "-d" }).redirectErrorStream(true).start();
        localObject1 = localObject5;
        localObject4 = localObject5;
        InputStream localInputStream = ((Process)localObject5).getInputStream();
        localObject1 = localObject5;
        localObject4 = localObject5;
        byte[] arrayOfByte = new byte[' '];
        localObject1 = localObject5;
        localObject4 = localObject5;
        int i = localInputStream.read(arrayOfByte);
        if (i > 0)
        {
          localObject1 = localObject5;
          localObject4 = localObject5;
          this.aHe.write(arrayOfByte, 0, i);
          continue;
        }
        this.aHe.closeEntry();
      }
      catch (Throwable localThrowable)
      {
        localObject4 = localObject1;
        Log.e("ErrorReport", "Error adding logcat entry", localThrowable);
        return;
      }
      finally
      {
        this.aHe.closeEntry();
        if (localObject4 != null) {
          ((Process)localObject4).destroy();
        }
      }
      if (localThrowable != null) {
        Object localObject3 = localThrowable;
      }
    }
  }
  
  public void close()
  {
    if (this.aHf != null)
    {
      this.aHe.finish();
      this.aHe.close();
      this.aHf = null;
      this.aHe = null;
    }
  }
  
  public void g(Throwable paramThrowable)
  {
    Object localObject = new ZipEntry("fatality.xml");
    this.aHe.putNextEntry((ZipEntry)localObject);
    this.aHf.setOutput(this.aHe, "UTF-8");
    this.aHf.startDocument("UTF-8", Boolean.valueOf(true));
    this.aHf.startTag("", "fatality");
    this.aHf.flush();
    localObject = new PrintWriter(this.aHe);
    paramThrowable.printStackTrace((PrintWriter)localObject);
    ((PrintWriter)localObject).flush();
    this.aHf.endDocument();
    this.aHe.closeEntry();
  }
  
  public void send()
  {
    close();
    Intent localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
    localIntent.setType("application/*");
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(Uri.parse("file://" + this.aHd.getAbsolutePath()));
    if (this.aHc != null) {
      localArrayList.add(Uri.fromFile(this.aHc));
    }
    localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "support_pdfscanner@mobisystems.com" });
    localIntent.putExtra("android.intent.extra.SUBJECT", this.ZB.getResources().getString(2131296327) + " Error Report");
    localIntent = Intent.createChooser(localIntent, this.ZB.getResources().getString(2131296738));
    this.ZB.startActivity(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/error/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */