package com.gtp.go.weather.sharephoto.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.a.g;
import com.gtp.go.weather.sharephoto.award.k;
import com.gtp.go.weather.sharephoto.b.l;
import com.gtp.go.weather.sharephoto.b.o;
import com.gtp.go.weather.sharephoto.takephoto.ab;
import com.gtp.go.weather.sharephoto.takephoto.ao;
import com.gtp.go.weather.sharephoto.takephoto.s;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameter;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameterBuidler;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterService;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.gau.go.launcherex.gowidget.weather.service.a.a
{
  private String a;
  private String b;
  private String c;
  private Location d;
  private HashMap e;
  private s f;
  private com.jiubang.goweather.b.f g;
  private l h;
  private com.gtp.go.weather.sharephoto.b.e i;
  private Context j;
  private Bitmap k;
  
  public b(Context paramContext)
  {
    this.j = paramContext.getApplicationContext();
    this.i = new com.gtp.go.weather.sharephoto.b.e();
    this.g = new com.jiubang.goweather.b.f();
    this.e = new HashMap();
  }
  
  private File a(File paramFile, Bitmap paramBitmap, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Bitmap.CompressFormat localCompressFormat = ab.a(paramFile);
    File localFile = new File(paramFile.getAbsolutePath() + ".tmp");
    if (ab.a(paramBitmap, localFile, localCompressFormat, paramInt))
    {
      paramFile.delete();
      localFile.renameTo(paramFile);
    }
    long l2 = System.currentTimeMillis();
    com.gtp.a.a.b.c.a("PublishPhotoTask", "overrideSaveImage: " + (l2 - l1));
    return paramFile;
  }
  
  private void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      long l2 = System.currentTimeMillis();
      Object localObject = ab.a(paramFile);
      long l3 = paramFile.length();
      com.gtp.a.a.b.c.a("PublishPhotoTask", "checkBigImageFile ==> quality: 100, size: " + l3 / 1024L + "kb");
      if (Bitmap.CompressFormat.PNG.equals(localObject)) {}
      for (long l1 = 819200L; l3 >= l1; l1 = 286720L)
      {
        float f1;
        if (Bitmap.CompressFormat.PNG.equals(localObject))
        {
          com.gtp.a.a.b.c.a("PublishPhotoTask", "透明图, 通过缩小图片减小文件体积");
          f1 = 1.0F * (float)l1 / (float)l3;
          if (this.k == null)
          {
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
            this.k = ab.a(paramFile.getAbsolutePath(), (int)(((BitmapFactory.Options)localObject).outWidth * f1), (int)(f1 * ((BitmapFactory.Options)localObject).outHeight));
            localObject = paramFile;
            if (this.k != null)
            {
              localObject = a(paramFile, this.k, 100);
              com.gtp.a.a.b.c.a("PublishPhotoTask", "H: " + this.k.getHeight() + ", w: " + this.k.getWidth());
            }
          }
        }
        for (;;)
        {
          l1 = System.currentTimeMillis();
          com.gtp.a.a.b.c.a("PublishPhotoTask", "checkBigImageFile ==> costTime: " + (l1 - l2));
          com.gtp.a.a.b.c.a("PublishPhotoTask", "checkBigImageFile ==> after size: " + ((File)localObject).length() / 1024L + "kb");
          return;
          localObject = ab.a(this.k, (int)(this.k.getWidth() * f1), (int)(f1 * this.k.getHeight()));
          if ((localObject == null) || (localObject == this.k)) {
            break;
          }
          this.k.recycle();
          this.k = ((Bitmap)localObject);
          break;
          com.gtp.a.a.b.c.a("PublishPhotoTask", "非透明图, 通过降低图片质量减小文件体积");
          if (this.k == null)
          {
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inPurgeable = true;
            this.k = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
          }
          localObject = paramFile;
          if (this.k != null)
          {
            int m = 90;
            localObject = paramFile;
            do
            {
              paramFile = a((File)localObject, this.k, m);
              l3 = paramFile.length();
              com.gtp.a.a.b.c.a("PublishPhotoTask", "checkBigImageFile ==> quality: " + m + ", size: " + l3 / 1024L + "kb");
              m -= 10;
              localObject = paramFile;
              if (m < 10) {
                break;
              }
              localObject = paramFile;
            } while (l3 > l1);
            localObject = paramFile;
          }
        }
      }
    }
  }
  
  private void b(File paramFile)
  {
    Object localObject;
    int i2;
    int i1;
    if (this.k == null)
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
      i2 = ((BitmapFactory.Options)localObject).outHeight;
      i1 = ((BitmapFactory.Options)localObject).outWidth;
      if ((i2 < 720) || (i1 < 720)) {
        break label84;
      }
    }
    label84:
    do
    {
      do
      {
        do
        {
          return;
          i2 = this.k.getHeight();
          i1 = this.k.getWidth();
          break;
        } while ((i2 >= this.f.b()) && (i1 >= this.f.c()));
        if (this.k == null)
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          this.k = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject);
        }
      } while (this.k == null);
      localObject = this.j.getResources().getDisplayMetrics();
      int n = Math.max(((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).widthPixels);
      int m = Math.min(((DisplayMetrics)localObject).heightPixels, ((DisplayMetrics)localObject).widthPixels);
      int i5 = Math.min(n * 2, 1600);
      int i6 = Math.min(m * 2, 1200);
      m = this.f.c();
      int i3 = Math.max(m, this.f.b());
      int i4 = Math.min(m, i3);
      if (i4 <= i6)
      {
        m = i3;
        n = i4;
        if (i3 <= i5) {}
      }
      else
      {
        float f1 = Math.min(i5 * 1.0F / i3, i6 * 1.0F / i4);
        n = (int)(i4 * f1);
        m = (int)(i3 * f1);
      }
      if (i2 < i1) {
        n = m;
      }
      localObject = ab.a(this.k, n, m);
    } while ((localObject == null) || (localObject == this.k));
    a(paramFile, (Bitmap)localObject, 100);
    this.k.recycle();
    this.k = ((Bitmap)localObject);
  }
  
  private File c(File paramFile)
  {
    long l1 = System.currentTimeMillis();
    if ((paramFile == null) || (!paramFile.exists())) {
      return paramFile;
    }
    com.gtp.a.a.b.c.a("PublishPhotoTask", "optimizeImage ==>before size: " + paramFile.length() / 1024L + "kb");
    DisplayMetrics localDisplayMetrics = this.j.getResources().getDisplayMetrics();
    int m = Math.max(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
    int n = Math.min(localDisplayMetrics.heightPixels, localDisplayMetrics.widthPixels);
    m = Math.min(m * 2, 1600);
    n = Math.min(n * 2, 1200);
    com.gtp.a.a.b.c.a("PublishPhotoTask", "maxH: " + m + ", maxW: " + n);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    com.gtp.a.a.b.c.a("PublishPhotoTask", "inTargetDensity: " + localOptions.inTargetDensity + ", inDensity: " + localOptions.inDensity);
    int i3 = Math.max(localOptions.outHeight, localOptions.outWidth);
    int i1 = Math.min(localOptions.outHeight, localOptions.outWidth);
    com.gtp.a.a.b.c.a("PublishPhotoTask", "imgH: " + i3 + ", imgW: " + i1);
    com.gtp.a.a.b.c.a("PublishPhotoTask", "outMimeType: " + localOptions.outMimeType);
    localOptions.inSampleSize = 1;
    if ((i3 > m) || (i1 > n))
    {
      while ((i3 / localOptions.inSampleSize > m) || (i1 / localOptions.inSampleSize > n)) {
        localOptions.inSampleSize *= 2;
      }
      com.gtp.a.a.b.c.a("PublishPhotoTask", "inSampleSize: " + localOptions.inSampleSize);
      int i2 = (int)Math.pow(2.0D, localOptions.inSampleSize / 2);
      com.gtp.a.a.b.c.a("PublishPhotoTask", "finalSample: " + i2);
      i3 /= i2;
      i1 /= i2;
      com.gtp.a.a.b.c.a("PublishPhotoTask", "sampleH: " + i3 + ", sampleW: " + i1);
      if ((i3 < m) || (i1 < n))
      {
        float f1 = Math.min(Math.max(m * 1.0F / i3, n * 1.0F / i1), Math.min(m * 1.0F / i3, n * 1.0F / i1));
        com.gtp.a.a.b.c.a("PublishPhotoTask", "scale: " + f1);
        localOptions.inDensity = localDisplayMetrics.densityDpi;
        localOptions.inTargetDensity = ((int)(localOptions.inDensity * f1));
      }
      localOptions.inJustDecodeBounds = false;
      localOptions.inScaled = true;
      localOptions.inPurgeable = true;
    }
    try
    {
      long l2 = System.currentTimeMillis();
      this.k = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      long l3 = System.currentTimeMillis();
      com.gtp.a.a.b.c.a("PublishPhotoTask", "decodeImageFile time: " + (l3 - l2));
      com.gtp.a.a.b.c.a("PublishPhotoTask", "inTargetDensity: " + localOptions.inTargetDensity + ", inDensity: " + localOptions.inDensity);
      if (this.k != null) {
        com.gtp.a.a.b.c.a("PublishPhotoTask", "imgH: " + this.k.getHeight() + ", imgW: " + this.k.getWidth());
      }
      l2 = System.currentTimeMillis();
      com.gtp.a.a.b.c.a("PublishPhotoTask", "optimizeImage ==>costTime: " + (l2 - l1));
      return paramFile;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
  }
  
  private String f()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.e.entrySet().iterator();
    try
    {
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("lang", localEntry.getKey());
        localJSONObject2.put("address", localEntry.getValue());
        localJSONArray.put(localJSONObject2);
        continue;
        return localJSONObject1.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      if (com.gtp.a.a.b.c.a()) {
        localJSONException.printStackTrace();
      }
    }
    for (;;)
    {
      localJSONObject1.put("latlng", this.d.getLatitude() + "," + this.d.getLongitude());
      localJSONObject1.put("multiLangInfo", localJSONException);
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.a)) {
      this.a = g.b(this.j).a();
    }
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    File localFile1 = new File(com.gtp.a.a.c.c.a(), "sharephoto" + File.separator + "publish_photo_original.jpg");
    localFile1.delete();
    Object localObject2 = c(new File(this.f.d()));
    int i1 = this.f.e();
    int m;
    int n;
    label136:
    Object localObject1;
    float f3;
    if (i1 != 0)
    {
      m = 1;
      if (this.f.a() == 0) {
        break label322;
      }
      n = 1;
      if ((m == 0) && (n == 0)) {
        break label1812;
      }
      if (this.k != null) {
        break label328;
      }
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(((File)localObject2).getAbsolutePath(), (BitmapFactory.Options)localObject1);
      f3 = ((BitmapFactory.Options)localObject1).outHeight / 0.9F;
      f2 = ((BitmapFactory.Options)localObject1).outWidth / 0.9F;
      label201:
      label290:
      do
      {
        f1 = Math.min(f3, 0.9F * f3);
        f2 = Math.min(f2, 0.9F * f2);
        com.gtp.a.a.b.c.a("PublishPhotoTask", "loadBitmap...tryHeight: " + f1 + ", tryWidth: " + f2);
        if (this.k == null) {
          this.k = ab.a(((File)localObject2).getAbsolutePath(), Math.round(f2), Math.round(f1));
        }
        if (this.k != null) {
          break;
        }
        f3 = f1;
      } while (f1 > 100.0F);
    }
    for (;;)
    {
      if (this.k != null) {
        break label521;
      }
      com.gtp.a.a.b.c.a("PublishPhotoTask", "after 旋转...originalBitmap == null");
      return;
      m = 0;
      break;
      label322:
      n = 0;
      break label136;
      label328:
      f3 = this.k.getHeight() / 0.9F;
      f2 = this.k.getWidth() / 0.9F;
      break label201;
      f3 = Math.min(this.k.getHeight(), f1);
      float f4 = Math.min(this.k.getWidth(), f2);
      f2 = f4;
      f1 = f3;
      if (n != 0)
      {
        com.gtp.a.a.b.c.a("PublishPhotoTask", "旋转...tryHeight: " + f3 + ", tryWidth: " + f4);
        localObject1 = ab.a(this.k, this.f.a());
        if ((localObject1 == null) || (localObject1 == this.k))
        {
          this.k.recycle();
          this.k = null;
          f2 = f4;
          f1 = f3;
          break label290;
        }
        this.k.recycle();
        this.k = ((Bitmap)localObject1);
        f1 = this.k.getHeight();
        f2 = this.k.getWidth();
      }
      if (this.k == null) {
        break label290;
      }
    }
    label521:
    float f2 = this.k.getHeight();
    float f1 = this.k.getWidth();
    Object localObject3;
    if (m != 0)
    {
      localObject3 = FilterParameterBuidler.createFilterParameter(this.f.e());
      ((FilterParameter)localObject3).mSrcBitmap = this.k;
    }
    label846:
    label885:
    label994:
    label1067:
    label1072:
    label1812:
    label1873:
    label1894:
    label1962:
    label1965:
    label1968:
    label1969:
    label1971:
    for (;;)
    {
      long l2;
      long l3;
      File localFile2;
      if (f2 > 100.0F)
      {
        localObject1 = null;
        try
        {
          if (((FilterParameter)localObject3).mSrcBitmap != null)
          {
            com.gtp.a.a.b.c.a("PublishPhotoTask", "滤镜处理...tryHeight: " + f2 + ", tryWidth: " + f1);
            l2 = System.currentTimeMillis();
            localObject1 = FilterService.getService(this.j).render((FilterParameter)localObject3);
            l3 = System.currentTimeMillis();
            com.gtp.a.a.b.c.a("PublishPhotoTask", "滤镜处理时间: " + (l3 - l2));
          }
          if ((localObject1 == null) || (localObject1 == this.k))
          {
            f1 = 0.8F * f1;
            f2 = 0.8F * f2;
            ((FilterParameter)localObject3).mSrcBitmap = ab.a(this.k, (int)f1, (int)f2);
            if (((FilterParameter)localObject3).mSrcBitmap == this.k) {
              ((FilterParameter)localObject3).mSrcBitmap = null;
            }
            if (((FilterParameter)localObject3).mSrcBitmap == null) {
              break label1971;
            }
            this.k.recycle();
            this.k = ((FilterParameter)localObject3).mSrcBitmap;
            f2 = this.k.getHeight();
            f1 = this.k.getWidth();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (com.gtp.a.a.b.c.a()) {
              localOutOfMemoryError.printStackTrace();
            }
            localFile2 = null;
          }
          this.k.recycle();
          this.k = localFile2;
          f1 = this.k.getHeight();
          f1 = this.k.getWidth();
        }
      }
      else
      {
        if (ab.a(this.k, localFile1, ab.a((File)localObject2), 100)) {}
        for (;;)
        {
          if ((localFile1 == null) || (!localFile1.exists())) {
            break label1969;
          }
          a(localFile1);
          int i2 = this.f.f().a();
          boolean bool;
          if (i2 != 0)
          {
            bool = true;
            localFile2 = new File(com.gtp.a.a.c.c.a(), "sharephoto" + File.separator + "publish_photo_watermark.png");
            localFile2.delete();
            if (!bool) {
              break label1965;
            }
            l2 = System.currentTimeMillis();
            b(localFile1);
            if (this.k != null) {
              break label1873;
            }
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
            BitmapFactory.decodeFile(localFile1.getAbsolutePath(), (BitmapFactory.Options)localObject2);
            n = ((BitmapFactory.Options)localObject2).outHeight;
            m = ((BitmapFactory.Options)localObject2).outWidth;
            com.gtp.a.a.b.c.a("PublishPhotoTask", "水印处理...photoH: " + n + ", photoW: " + m);
            localObject2 = this.f.f().a(m, n);
            if (localObject2 == null) {
              break label1962;
            }
            if (!ab.a((Bitmap)localObject2, localFile2, Bitmap.CompressFormat.PNG, 100)) {
              break label1894;
            }
            ((Bitmap)localObject2).recycle();
            l3 = System.currentTimeMillis();
            com.gtp.a.a.b.c.a("PublishPhotoTask", "\t水印处理: costTime:" + (l3 - l2));
          }
          for (;;)
          {
            if (this.k != null) {
              this.k.recycle();
            }
            if ((localFile1 == null) || (!localFile1.exists()) || ((bool) && ((localFile2 == null) || (!localFile2.exists())))) {
              break;
            }
            com.jiubang.goweather.b.e locale = new com.jiubang.goweather.b.e("http://gows.goforandroid.com/goweatherexSns/image/messageUpload", 10000, 10000);
            locale.a("rd", y.c());
            locale.a("POST");
            ArrayList localArrayList = new ArrayList();
            localObject2 = com.gtp.go.weather.sharephoto.a.f.a(this.j);
            if (localObject2 == null) {
              break;
            }
            localArrayList.add(new BasicNameValuePair("phead", ((JSONObject)localObject2).toString()));
            localArrayList.add(new BasicNameValuePair("userId", this.a + ""));
            localArrayList.add(new BasicNameValuePair("cityId", this.b));
            localArrayList.add(new BasicNameValuePair("desc", this.c));
            com.jiubang.goweather.b.c localc;
            if (this.d != null)
            {
              localArrayList.add(new BasicNameValuePair("addr", f()));
              locale.a(localArrayList);
              localc = com.jiubang.goweather.b.d.a(true);
              localObject3 = null;
            }
            try
            {
              localObject2 = locale.i();
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              com.gtp.a.a.b.c.a("PublishPhotoTask", "completeURL: " + (String)localObject2);
              com.gtp.a.a.b.c.a("PublishPhotoTask", "postParams: " + localArrayList.toString());
              l2 = System.currentTimeMillis();
              localObject2 = localc.b((String)localObject2, locale, this.g);
              l3 = System.currentTimeMillis();
              com.gtp.a.a.b.c.a("PublishPhotoTask", "发布: costTime: " + (l3 - l2));
              this.g.b((String)localObject2);
              com.gtp.a.a.b.c.a("PublishPhotoTask", "resultText: " + (String)localObject2);
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              try
              {
                localObject2 = new JSONObject((String)localObject2);
                this.h = l.a(((JSONObject)localObject2).getJSONObject("head"));
                if ((this.h.a == 1) || (this.h.a == 2))
                {
                  l2 = ((JSONObject)localObject2).optLong("imageId", -1L);
                  this.i.a(l2);
                }
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  if (com.gtp.a.a.b.c.a()) {
                    localJSONException.printStackTrace();
                  }
                }
              }
              if (-1L != this.i.f())
              {
                localObject2 = ab.a(this.i.f());
                localObject3 = new File((File)localObject2, "publish_photo_original.jpg");
                com.jiubang.goweather.e.a.a(localFile1, (File)localObject3, Boolean.valueOf(true));
                this.i.d(((File)localObject3).getAbsolutePath());
                this.i.a(bool);
                if (bool)
                {
                  localFile1 = new File((File)localObject2, "publish_photo_watermark.png");
                  com.jiubang.goweather.e.a.a(localFile2, localFile1, Boolean.valueOf(true));
                  this.i.e(localFile1.getAbsolutePath());
                }
                com.gtp.go.weather.sharephoto.b.a.d.a(this.j, this.i);
                if (this.h.a == 2)
                {
                  com.gtp.a.a.b.c.a("PublishPhotoTask", "获奖了!");
                  k.b(this.j);
                }
                com.gau.go.launcherex.gowidget.weather.service.a.b.a(new c(this, i1, i2));
              }
              l2 = System.currentTimeMillis();
              com.gtp.a.a.b.c.a("PublishPhotoTask", "doTime: " + (l2 - l1));
              return;
              localFile1 = null;
              break label846;
              if (this.k == null)
              {
                if (com.jiubang.goweather.e.a.a((File)localObject2, localFile1, Boolean.valueOf(true))) {
                  break label1968;
                }
                localFile1 = null;
                break label846;
              }
              if (ab.a(this.k, localFile1, ab.a((File)localObject2), 100)) {
                break label846;
              }
              for (;;)
              {
                localFile1 = null;
              }
              bool = false;
              break label885;
              n = this.k.getHeight();
              m = this.k.getWidth();
              break label994;
              localFile2 = null;
              break label1067;
              localArrayList.add(new BasicNameValuePair("addr", null));
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              for (;;)
              {
                localObject2 = localObject3;
                if (com.gtp.a.a.b.c.a())
                {
                  localUnsupportedEncodingException.printStackTrace();
                  localObject2 = localObject3;
                }
              }
            }
            break label1072;
          }
        }
        break;
      }
    }
  }
  
  public void a(Location paramLocation)
  {
    this.d = paramLocation;
  }
  
  public void a(s params)
  {
    this.f = params;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
  }
  
  public void a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {}
    for (;;)
    {
      return;
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
    this.i.b(paramString);
  }
  
  public com.gtp.go.weather.sharephoto.b.e c()
  {
    return this.i;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
    this.i.a(paramString);
  }
  
  public String d()
  {
    return this.b;
  }
  
  public com.jiubang.goweather.b.f e()
  {
    return this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */