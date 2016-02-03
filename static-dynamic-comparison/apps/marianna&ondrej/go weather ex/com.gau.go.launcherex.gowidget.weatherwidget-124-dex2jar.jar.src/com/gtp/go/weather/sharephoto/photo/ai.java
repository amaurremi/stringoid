package com.gtp.go.weather.sharephoto.photo;

import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import com.gtp.a.a.b.c;
import com.gtp.go.weather.sharephoto.a.f;
import com.gtp.go.weather.sharephoto.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class ai
  extends AsyncTask
{
  private int b = -1;
  private int c;
  private int d;
  private String e;
  
  public ai(ad paramad, int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString;
  }
  
  protected ArrayList a(ArrayList... paramVarArgs)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject4;
    Object localObject5;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs != null) && (!paramVarArgs.isEmpty()))
      {
        localObject4 = paramVarArgs.iterator();
        paramVarArgs = (ArrayList[])localObject3;
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject4).next();
          if (localObject5 != null)
          {
            switch (((com.gtp.go.weather.sharephoto.b.g)localObject5).g())
            {
            default: 
              localObject3 = localObject1;
              localObject1 = paramVarArgs;
              paramVarArgs = (ArrayList[])localObject3;
            }
            for (;;)
            {
              localObject3 = localObject1;
              localObject1 = paramVarArgs;
              paramVarArgs = (ArrayList[])localObject3;
              break;
              localObject3 = paramVarArgs;
              if (paramVarArgs == null) {
                localObject3 = new ArrayList();
              }
              ((ArrayList)localObject3).add(localObject5);
              paramVarArgs = (ArrayList[])localObject1;
              localObject1 = localObject3;
              continue;
              localObject3 = localObject1;
              if (localObject1 == null) {
                localObject3 = new ArrayList();
              }
              ((ArrayList)localObject3).add(localObject5);
              localObject1 = paramVarArgs;
              paramVarArgs = (ArrayList[])localObject3;
            }
          }
        }
      }
    }
    for (localObject3 = paramVarArgs;; localObject3 = null)
    {
      c.a("photo", "================= 开始获取图片 ================= 图片类型 => " + this.d);
      if (this.d == 2) {
        c.a("photo", "mCityId --> " + this.e);
      }
      paramVarArgs = f.a(ad.b(this.a));
      if (paramVarArgs != null) {}
      for (localObject4 = paramVarArgs.toString();; localObject4 = "")
      {
        c.a("photo", "phead --> " + (String)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break;
        }
        return null;
      }
      localObject5 = com.gtp.go.weather.sharephoto.a.g.a(ad.b(this.a)).b().a();
      c.a("photo", "userId --> " + (String)localObject5);
      paramVarArgs = "";
      long l;
      int m;
      int k;
      int i;
      switch (this.d)
      {
      default: 
        c.a("photo", "url --> " + paramVarArgs);
        if (this.c < 0) {
          this.c = 0;
        }
        c.a("photo", "mDataPage --> " + this.c);
        l = System.currentTimeMillis();
        localObject4 = ac.a(ad.b(this.a), paramVarArgs, (String)localObject4, (String)localObject5, this.e, this.c);
        m = (int)(System.currentTimeMillis() - l);
        c.a("time_photo", "本次服务器获取图片数据共用了 " + m + " 毫秒！");
        c.a("photo", "【result】 --> " + (String)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          k = 0;
        }
        break;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          try
          {
            paramVarArgs = new JSONObject((String)localObject4);
            if (paramVarArgs == null) {
              continue;
            }
            paramVarArgs = paramVarArgs.optJSONObject("head");
            if (paramVarArgs == null) {
              continue;
            }
            i = paramVarArgs.optInt("result", -1);
            j = k;
            if (i == 1) {
              j = 1;
            }
          }
          catch (JSONException paramVarArgs)
          {
            int j = k;
            if (!c.a()) {
              continue;
            }
            paramVarArgs.printStackTrace();
            j = k;
            continue;
            paramVarArgs = new ArrayList();
            localObject5 = new ArrayList();
            this.b = ad.a(this.a, this.c, (String)localObject4, this.d, paramVarArgs, (ArrayList)localObject5);
            localObject4 = new ArrayList();
            if (this.c != 0) {
              continue;
            }
            if (!ad.c(this.a)) {
              continue;
            }
            ad.a(this.a, false);
            ad.b(this.a, true);
            ad.d(this.a);
            c.a("delete_photos", "clearAllPhotodata");
            ad.a(this.a, (ArrayList)localObject5, (ArrayList)localObject1);
            ad.a(this.a, (ArrayList)localObject4, this.d, this.e, (ArrayList)localObject5);
            if (!ad.e(this.a)) {
              continue;
            }
            ad.a(this.a, paramVarArgs, (ArrayList)localObject3);
            ad.a(this.a, (ArrayList)localObject4, this.d, this.e, paramVarArgs, null);
            if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
              continue;
            }
            bool2 = false;
            try
            {
              ad.b(this.a).getContentResolver().applyBatch("com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", (ArrayList)localObject4);
              bool1 = true;
            }
            catch (RemoteException localRemoteException)
            {
              bool1 = bool2;
              if (!c.a()) {
                continue;
              }
              localRemoteException.printStackTrace();
              bool1 = bool2;
              continue;
            }
            catch (OperationApplicationException localOperationApplicationException)
            {
              boolean bool1 = bool2;
              if (!c.a()) {
                continue;
              }
              localOperationApplicationException.printStackTrace();
              bool1 = bool2;
              continue;
              if ((!ad.e(this.a)) || (!ad.f(this.a))) {
                break label1036;
              }
              ad.a(this.a, paramVarArgs);
              i = (int)(System.currentTimeMillis() - l + m);
              c.a("time_photo", "本次解析以及数据库保存共用了 " + i + " 毫秒！");
              return paramVarArgs;
            }
            c.a("photo", "类型是" + this.d + "的图片保存及更新是否成功:" + bool1);
            if (this.c != 0) {
              break label1008;
            }
            localObject1 = ((ArrayList)localObject5).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label1008;
            }
            paramVarArgs.add((com.gtp.go.weather.sharephoto.b.g)((Iterator)localObject1).next());
            continue;
            ad.a(this.a, (ArrayList)localObject4, this.d, this.e, paramVarArgs, (ArrayList)localObject3);
            continue;
          }
          if (j != 0) {
            continue;
          }
          return null;
          paramVarArgs = "http://gows.goforandroid.com/goweatherexSns/image/choiceImageIssued";
          break;
          paramVarArgs = "http://gows.goforandroid.com/goweatherexSns/image/cityImageIssued";
          break;
          paramVarArgs = "http://gows.goforandroid.com/goweatherexSns/image/userImageIssued";
          break;
          paramVarArgs = null;
          continue;
          i = -1;
        }
      }
      boolean bool2;
      label1008:
      label1036:
      return null;
      Object localObject2 = null;
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if (ad.a(this.a) != null)
    {
      if (this.c != 0) {
        break label72;
      }
      ad.a(this.a).a(this.d, this.e, this.b, paramArrayList, ad.e(this.a));
      ad.b(this.a, false);
    }
    for (;;)
    {
      ad.b(this.a, paramArrayList);
      return;
      label72:
      ad.a(this.a).a(this.d, this.e, this.c, paramArrayList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */