package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.b;
import com.google.android.gms.internal.hc.c;
import com.google.android.gms.internal.hc.d;
import com.google.android.gms.internal.hc.e;
import com.google.android.gms.internal.hc.g;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.if;
import com.google.android.gms.internal.kq;
import com.google.android.gms.internal.kt;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class e
  extends hc<d>
{
  private Person abG;
  private final h abH;
  
  public e(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramh.jU());
    this.abH = paramh;
  }
  
  @Deprecated
  public e(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    this(paramContext, paramContext.getMainLooper(), new hc.c(paramConnectionCallbacks), new hc.g(paramOnConnectionFailedListener), paramh);
  }
  
  public hh a(a.d<People.LoadPeopleResult> paramd, int paramInt, String paramString)
  {
    ci();
    paramd = new e(paramd);
    try
    {
      paramString = ((d)fo()).a(paramd, 1, paramInt, -1, paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramd.a(DataHolder.af(8), null);
    }
    return null;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.abG = kt.i(paramBundle.getByteArray("loaded_person"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(a.d<Moments.LoadMomentsResult> paramd, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    ci();
    if (paramd != null) {}
    for (paramd = new b(paramd);; paramd = null) {
      try
      {
        ((d)fo()).a(paramd, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramd.a(DataHolder.af(8), null, null);
      }
    }
  }
  
  public void a(a.d<Status> paramd, Moment paramMoment)
  {
    ci();
    if (paramd != null) {}
    for (paramd = new a(paramd);; paramd = null) {
      try
      {
        paramMoment = if.a((kq)paramMoment);
        ((d)fo()).a(paramd, paramMoment);
        return;
      }
      catch (RemoteException paramMoment)
      {
        if (paramd != null) {
          break;
        }
        throw new IllegalStateException(paramMoment);
        paramd.am(new Status(8, null, null));
      }
    }
  }
  
  public void a(a.d<People.LoadPeopleResult> paramd, Collection<String> paramCollection)
  {
    ci();
    paramd = new e(paramd);
    try
    {
      ((d)fo()).a(paramd, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException paramCollection)
    {
      paramd.a(DataHolder.af(8), null);
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = this.abH.kc();
    localBundle.putStringArray("request_visible_actions", this.abH.jV());
    paramhj.a(parame, 5077000, this.abH.jY(), this.abH.jX(), fn(), this.abH.getAccountName(), localBundle);
  }
  
  protected d bn(IBinder paramIBinder)
  {
    return d.a.bm(paramIBinder);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  public boolean by(String paramString)
  {
    return Arrays.asList(fn()).contains(paramString);
  }
  
  public void clearDefaultAccount()
  {
    ci();
    try
    {
      this.abG = null;
      ((d)fo()).clearDefaultAccount();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void d(a.d<People.LoadPeopleResult> paramd, String[] paramArrayOfString)
  {
    a(paramd, Arrays.asList(paramArrayOfString));
  }
  
  public String getAccountName()
  {
    ci();
    try
    {
      String str = ((d)fo()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person getCurrentPerson()
  {
    ci();
    return this.abG;
  }
  
  public void k(a.d<Moments.LoadMomentsResult> paramd)
  {
    a(paramd, 20, null, null, null, "me");
  }
  
  public void l(a.d<People.LoadPeopleResult> paramd)
  {
    ci();
    paramd = new e(paramd);
    try
    {
      ((d)fo()).a(paramd, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramd.a(DataHolder.af(8), null);
    }
  }
  
  public void m(a.d<Status> paramd)
  {
    ci();
    clearDefaultAccount();
    paramd = new g(paramd);
    try
    {
      ((d)fo()).b(paramd);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramd.h(8, null);
    }
  }
  
  public hh r(a.d<People.LoadPeopleResult> paramd, String paramString)
  {
    return a(paramd, 0, paramString);
  }
  
  public void removeMoment(String paramString)
  {
    ci();
    try
    {
      ((d)fo()).removeMoment(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  final class a
    extends a
  {
    private final a.d<Status> abI;
    
    public a()
    {
      a.d locald;
      this.abI = locald;
    }
    
    public void am(Status paramStatus)
    {
      e.this.a(new e.d(e.this, this.abI, paramStatus));
    }
  }
  
  final class b
    extends a
  {
    private final a.d<Moments.LoadMomentsResult> abI;
    
    public b()
    {
      a.d locald;
      this.abI = locald;
    }
    
    public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      if (paramDataHolder.eP() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.eP().getParcelable("pendingIntent");; localObject = null)
      {
        localObject = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
        if ((!((Status)localObject).isSuccess()) && (paramDataHolder != null))
        {
          if (!paramDataHolder.isClosed()) {
            paramDataHolder.close();
          }
          paramDataHolder = null;
        }
        for (;;)
        {
          e.this.a(new e.c(e.this, this.abI, (Status)localObject, paramDataHolder, paramString1, paramString2));
          return;
        }
      }
    }
  }
  
  final class c
    extends hc<d>.d<a.d<Moments.LoadMomentsResult>>
    implements Moments.LoadMomentsResult
  {
    private final String HP;
    private final String abK;
    private MomentBuffer abL;
    private final Status yw;
    
    public c(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      super(paramStatus, paramString1);
      this.yw = paramDataHolder;
      this.HP = paramString2;
      String str;
      this.abK = str;
    }
    
    protected void a(a.d<Moments.LoadMomentsResult> paramd, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (paramDataHolder = new MomentBuffer(paramDataHolder);; paramDataHolder = null)
      {
        this.abL = paramDataHolder;
        paramd.a(this);
        return;
      }
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.abL;
    }
    
    public String getNextPageToken()
    {
      return this.HP;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public String getUpdated()
    {
      return this.abK;
    }
    
    public void release()
    {
      if (this.abL != null) {
        this.abL.close();
      }
    }
  }
  
  final class d
    extends hc<d>.b<a.d<Status>>
  {
    private final Status yw;
    
    public d(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.yw = localStatus;
    }
    
    protected void fp() {}
    
    protected void n(a.d<Status> paramd)
    {
      if (paramd != null) {
        paramd.a(this.yw);
      }
    }
  }
  
  final class e
    extends a
  {
    private final a.d<People.LoadPeopleResult> abI;
    
    public e()
    {
      a.d locald;
      this.abI = locald;
    }
    
    public void a(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.eP() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.eP().getParcelable("pendingIntent");; localObject = null)
      {
        localObject = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
        if ((!((Status)localObject).isSuccess()) && (paramDataHolder != null))
        {
          if (!paramDataHolder.isClosed()) {
            paramDataHolder.close();
          }
          paramDataHolder = null;
        }
        for (;;)
        {
          e.this.a(new e.f(e.this, this.abI, (Status)localObject, paramDataHolder, paramString));
          return;
        }
      }
    }
  }
  
  final class f
    extends hc<d>.d<a.d<People.LoadPeopleResult>>
    implements People.LoadPeopleResult
  {
    private final String HP;
    private PersonBuffer abM;
    private final Status yw;
    
    public f(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      super(paramStatus, paramString);
      this.yw = paramDataHolder;
      String str;
      this.HP = str;
    }
    
    protected void a(a.d<People.LoadPeopleResult> paramd, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (paramDataHolder = new PersonBuffer(paramDataHolder);; paramDataHolder = null)
      {
        this.abM = paramDataHolder;
        paramd.a(this);
        return;
      }
    }
    
    public String getNextPageToken()
    {
      return this.HP;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.abM;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public void release()
    {
      if (this.abM != null) {
        this.abM.close();
      }
    }
  }
  
  final class g
    extends a
  {
    private final a.d<Status> abI;
    
    public g()
    {
      a.d locald;
      this.abI = locald;
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt, null, paramBundle);
        e.this.a(new e.h(e.this, this.abI, paramBundle));
        return;
      }
    }
  }
  
  final class h
    extends hc<d>.b<a.d<Status>>
  {
    private final Status yw;
    
    public h(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.yw = localStatus;
    }
    
    protected void fp() {}
    
    protected void n(a.d<Status> paramd)
    {
      e.this.disconnect();
      if (paramd != null) {
        paramd.a(this.yw);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */