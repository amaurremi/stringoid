package com.vungle.publisher.protocol.message;

import com.vungle.publisher.bp;
import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.AdPlay;
import com.vungle.publisher.db.model.AdReport;
import com.vungle.publisher.db.model.AdReportEvent;
import com.vungle.publisher.db.model.AdReportEvent.a;
import com.vungle.publisher.db.model.Video;
import com.vungle.publisher.log.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ReportAd
  extends BaseJsonSerializable
{
  protected Integer a;
  protected Long b;
  protected String c;
  protected String d;
  protected Integer e;
  protected String f;
  protected Boolean g;
  protected Play[] h;
  protected Q i;
  protected String j;
  protected String k;
  
  private List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.h != null) && (this.h.length > 0))
    {
      String str = AdReportEvent.a.k.toString();
      Play[] arrayOfPlay = this.h;
      int i1 = arrayOfPlay.length;
      int m = 0;
      while (m < i1)
      {
        ReportAd.Play.UserAction[] arrayOfUserAction = arrayOfPlay[m].d;
        if (arrayOfUserAction != null)
        {
          int i2 = arrayOfUserAction.length;
          int n = 0;
          while (n < i2)
          {
            ReportAd.Play.UserAction localUserAction = arrayOfUserAction[n];
            if (!str.equals(localUserAction.a)) {
              localArrayList.add(localUserAction.a);
            }
            n += 1;
          }
        }
        m += 1;
      }
    }
    return localArrayList;
  }
  
  public final JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject;
    int m;
    if (this.i == null)
    {
      localJSONObject = super.b();
      localJSONObject.putOpt("ttDownload", this.a);
      localJSONObject.putOpt("adStartTime", this.b);
      localJSONObject.putOpt("app_id", this.c);
      localJSONObject.putOpt("campaign", this.d);
      localJSONObject.putOpt("adDuration", this.e);
      if (Boolean.TRUE.equals(this.g)) {
        localJSONObject.putOpt("name", this.f);
      }
      localObject = this.g;
      if (localObject == null) {
        break label194;
      }
      if (!((Boolean)localObject).booleanValue()) {
        break label189;
      }
      m = 1;
    }
    label109:
    label189:
    label194:
    for (Object localObject = Integer.valueOf(m);; localObject = null)
    {
      localJSONObject.putOpt("incentivized", localObject);
      localJSONObject.putOpt("plays", bp.a(this.h));
      localJSONObject.putOpt("id", this.j);
      localJSONObject.putOpt("clickedThrough", new JSONArray(c()));
      localJSONObject.putOpt("url", this.k);
      return localJSONObject;
      localJSONObject = this.i.b();
      break;
      m = 0;
      break label109;
    }
  }
  
  public static abstract class Factory<Q extends RequestAd<Q>, R extends RequestAdResponse, O extends ReportAd<Q, O>, T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>>
  {
    protected abstract ReportAd.Play.Factory<R, T, P, E, A, V> a();
    
    public O a(T paramT)
    {
      ReportAd localReportAd = null;
      ReportAd.Play[] arrayOfPlay = null;
      int j = 0;
      if (paramT != null)
      {
        Object localObject = paramT.e();
        localReportAd = c();
        localReportAd.b = paramT.j();
        localReportAd.c = ((Ad)localObject).e();
        localReportAd.d = ((Ad)localObject).d();
        localReportAd.e = Integer.valueOf(paramT.i());
        localReportAd.f = paramT.g();
        localReportAd.g = Boolean.valueOf(paramT.f());
        localObject = a();
        AdPlay[] arrayOfAdPlay = paramT.q();
        if (arrayOfAdPlay == null) {}
        for (int i = 0;; i = arrayOfAdPlay.length)
        {
          paramT = arrayOfPlay;
          if (i <= 0) {
            break;
          }
          arrayOfPlay = new ReportAd.Play[i];
          int k = arrayOfAdPlay.length;
          i = 0;
          for (;;)
          {
            paramT = arrayOfPlay;
            if (j >= k) {
              break;
            }
            arrayOfPlay[i] = ((ReportAd.Play.Factory)localObject).a(arrayOfAdPlay[j]);
            j += 1;
            i += 1;
          }
        }
        localReportAd.h = paramT;
        localReportAd.i = b().b();
      }
      return localReportAd;
    }
    
    protected abstract RequestAd.a<Q> b();
    
    protected abstract O c();
  }
  
  public static final class Play
    extends BaseJsonSerializable
  {
    protected Integer a;
    protected Integer b;
    protected Long c;
    protected UserAction[] d;
    
    public final JSONObject b()
      throws JSONException
    {
      JSONObject localJSONObject = super.b();
      localJSONObject.putOpt("userActions", bp.a(this.d));
      localJSONObject.putOpt("videoLength", this.a);
      localJSONObject.putOpt("videoViewed", this.b);
      localJSONObject.putOpt("startTime", this.c);
      return localJSONObject;
    }
    
    public static abstract class Factory<R extends RequestAdResponse, T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>>
    {
      protected abstract ReportAd.Play.UserAction.Factory<R, T, P, E, A, V> a();
      
      final ReportAd.Play a(P paramP)
      {
        ReportAd.Play localPlay = null;
        if (paramP != null)
        {
          localPlay = new ReportAd.Play();
          a();
          localPlay.d = ReportAd.Play.UserAction.Factory.a(paramP.d());
        }
        try
        {
          localPlay.a = paramP.a.h();
          localPlay.c = paramP.c;
          localPlay.b = paramP.b;
          return localPlay;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            Logger.w("VungleProtocol", "null play report parent");
          }
        }
      }
    }
    
    public static final class UserAction
      extends BaseJsonSerializable
    {
      protected String a;
      protected Long b;
      protected String c;
      
      public final JSONObject b()
        throws JSONException
      {
        JSONObject localJSONObject = super.b();
        localJSONObject.putOpt("action", this.a);
        localJSONObject.putOpt("timestamp_millis", this.b);
        localJSONObject.putOpt("value", this.c);
        return localJSONObject;
      }
      
      public static abstract class Factory<R extends RequestAdResponse, T extends AdReport<T, P, E, A, V, R>, P extends AdPlay<T, P, E, A, V, R>, E extends AdReportEvent<T, P, E, A, V, R>, A extends Ad<A, V, R>, V extends Video<A, V, R>>
      {
        protected static ReportAd.Play.UserAction[] a(E[] paramArrayOfE)
        {
          Object localObject = null;
          int i;
          ReportAd.Play.UserAction[] arrayOfUserAction;
          int j;
          if (paramArrayOfE == null)
          {
            i = 0;
            if (i <= 0) {
              break label113;
            }
            arrayOfUserAction = new ReportAd.Play.UserAction[i];
            int k = paramArrayOfE.length;
            j = 0;
            i = 0;
            label26:
            if (j >= k) {
              break label109;
            }
            E ? = paramArrayOfE[j];
            if (? == null) {
              break label116;
            }
            localObject = new ReportAd.Play.UserAction();
            ((ReportAd.Play.UserAction)localObject).a = String.valueOf(?.b);
            ((ReportAd.Play.UserAction)localObject).b = Long.valueOf(?.c);
            ((ReportAd.Play.UserAction)localObject).c = ?.d;
          }
          for (;;)
          {
            arrayOfUserAction[i] = localObject;
            j += 1;
            i += 1;
            break label26;
            i = paramArrayOfE.length;
            break;
            label109:
            localObject = arrayOfUserAction;
            label113:
            return (ReportAd.Play.UserAction[])localObject;
            label116:
            localObject = null;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/protocol/message/ReportAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */