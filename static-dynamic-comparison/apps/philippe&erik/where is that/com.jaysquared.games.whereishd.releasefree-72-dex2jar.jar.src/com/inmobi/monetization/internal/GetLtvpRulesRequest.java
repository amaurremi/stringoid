package com.inmobi.monetization.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.commons.uid.UIDUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class GetLtvpRulesRequest
{
  private String a;
  private String b;
  private String c;
  private long d;
  private String e;
  private String f;
  private String g;
  
  public GetLtvpRulesRequest()
  {
    try
    {
      this.a = InMobi.getAppId();
      this.b = ("pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion(InMobi.getVersion()) + "-" + "20140131");
      this.d = new Random().nextInt();
      this.c = UIDUtil.getEncryptedUid(Long.toString(this.d));
      this.e = UIDHelper.getRSAKeyVersion();
      this.f = InternalSDKUtil.getContext().getPackageName();
      this.g = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(this.f, 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[Monetization]", "Failed to init Ltvp request", localException);
    }
  }
  
  public String getEncodedRequestParams()
  {
    try
    {
      Object localObject = new LinkedList();
      if ((this.a != null) && (!"".equals(this.a))) {
        ((List)localObject).add(new BasicNameValuePair("mk-siteid", this.a));
      }
      if ((this.b != null) && (!"".equals(this.b))) {
        ((List)localObject).add(new BasicNameValuePair("mk-version", this.b));
      }
      if ((this.c != null) && (!"".equals(this.c))) {
        ((List)localObject).add(new BasicNameValuePair("u-id-map", this.c));
      }
      ((List)localObject).add(new BasicNameValuePair("u-id-key", Long.toString(this.d)));
      if ((this.e != null) && (!"".equals(this.e))) {
        ((List)localObject).add(new BasicNameValuePair("u-key-ver", this.e));
      }
      if ((this.f != null) && (!"".equals(this.f))) {
        ((List)localObject).add(new BasicNameValuePair("u-appbid", this.f));
      }
      if ((this.g != null) && (!"".equals(this.g))) {
        ((List)localObject).add(new BasicNameValuePair("u-appver", this.g));
      }
      String str = InternalSDKUtil.getContext().getResources().getConfiguration().locale.toString();
      if ((str != null) && (!"".equals(str))) {
        ((List)localObject).add(new BasicNameValuePair("d-localization", str));
      }
      ((List)localObject).add(new BasicNameValuePair("ts", Long.toString(System.currentTimeMillis())));
      localObject = URLEncodedUtils.format((List)localObject, "utf-8");
      return (String)localObject;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-[Monetization]", "Exception getting request params for ltvp get rules", localException);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/GetLtvpRulesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */