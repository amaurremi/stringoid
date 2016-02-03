package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.data.DataHolder;
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

public class hs
  extends dw<hr>
  implements GooglePlayServicesClient
{
  private Person DK;
  private hu DL;
  
  @Deprecated
  public hs(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, hu paramhu)
  {
    this(paramContext, new dw.c(paramConnectionCallbacks), new dw.g(paramOnConnectionFailedListener), paramhu);
  }
  
  public hs(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, hu paramhu)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramhu.eR());
    this.DL = paramhu;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.DK = ig.g(paramBundle.getByteArray("loaded_person"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(a.c<People.LoadPeopleResult> paramc, int paramInt, String paramString)
  {
    bP();
    paramc = new c(paramc);
    try
    {
      ((hr)bQ()).a(paramc, 1, paramInt, -1, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramc.a(DataHolder.empty(8), null);
    }
  }
  
  public void a(a.c<Moments.LoadMomentsResult> paramc, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    bP();
    if (paramc != null) {}
    for (paramc = new a(paramc);; paramc = null) {
      try
      {
        ((hr)bQ()).a(paramc, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramc.a(DataHolder.empty(8), null, null);
      }
    }
  }
  
  public void a(a.c<People.LoadPeopleResult> paramc, Collection<String> paramCollection)
  {
    bP();
    paramc = new c(paramc);
    try
    {
      ((hr)bQ()).a(paramc, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException paramCollection)
    {
      paramc.a(DataHolder.empty(8), null);
    }
  }
  
  public void a(a.c<People.LoadPeopleResult> paramc, String[] paramArrayOfString)
  {
    a(paramc, Arrays.asList(paramArrayOfString));
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("request_visible_actions", this.DL.eS());
    paramec.a(parame, 4242000, this.DL.eV(), this.DL.eU(), bO(), this.DL.getAccountName(), localBundle);
  }
  
  protected String am()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  protected hr ay(IBinder paramIBinder)
  {
    return hr.a.ax(paramIBinder);
  }
  
  public boolean az(String paramString)
  {
    return Arrays.asList(bO()).contains(paramString);
  }
  
  public void clearDefaultAccount()
  {
    bP();
    try
    {
      this.DK = null;
      ((hr)bQ()).clearDefaultAccount();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public String getAccountName()
  {
    bP();
    try
    {
      String str = ((hr)bQ()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person getCurrentPerson()
  {
    bP();
    return this.DK;
  }
  
  public void i(a.c<People.LoadPeopleResult> paramc, String paramString)
  {
    a(paramc, 0, paramString);
  }
  
  public void j(a.c<Moments.LoadMomentsResult> paramc)
  {
    a(paramc, 20, null, null, null, "me");
  }
  
  public void k(a.c<People.LoadPeopleResult> paramc)
  {
    bP();
    paramc = new c(paramc);
    try
    {
      ((hr)bQ()).a(paramc, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramc.a(DataHolder.empty(8), null);
    }
  }
  
  public void l(a.c<Status> paramc)
  {
    bP();
    clearDefaultAccount();
    paramc = new e(paramc);
    try
    {
      ((hr)bQ()).b(paramc);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramc.b(8, null);
    }
  }
  
  public void removeMoment(String paramString)
  {
    bP();
    try
    {
      ((hr)bQ()).removeMoment(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public void writeMoment(Moment paramMoment)
  {
    bP();
    try
    {
      paramMoment = ey.a((id)paramMoment);
      ((hr)bQ()).a(paramMoment);
      return;
    }
    catch (RemoteException paramMoment)
    {
      throw new IllegalStateException(paramMoment);
    }
  }
  
  final class a
    extends hn
  {
    private final a.c<Moments.LoadMomentsResult> Dp;
    
    public a()
    {
      a.c localc;
      this.Dp = localc;
    }
    
    public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      if (paramDataHolder.getMetadata() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.getMetadata().getParcelable("pendingIntent");; localObject = null)
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
          hs.this.a(new hs.b(hs.this, this.Dp, (Status)localObject, paramDataHolder, paramString1, paramString2));
          return;
        }
      }
    }
  }
  
  final class b
    extends dw<hr>.d<a.c<Moments.LoadMomentsResult>>
    implements Moments.LoadMomentsResult
  {
    private final String DN;
    private MomentBuffer DO;
    private final Status jY;
    private final String qT;
    
    public b(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      super(paramStatus, paramString1);
      this.jY = paramDataHolder;
      this.qT = paramString2;
      String str;
      this.DN = str;
    }
    
    protected void a(a.c<Moments.LoadMomentsResult> paramc, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (paramDataHolder = new MomentBuffer(paramDataHolder);; paramDataHolder = null)
      {
        this.DO = paramDataHolder;
        paramc.a(this);
        return;
      }
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.DO;
    }
    
    public String getNextPageToken()
    {
      return this.qT;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
    
    public String getUpdated()
    {
      return this.DN;
    }
    
    public void release()
    {
      if (this.DO != null) {
        this.DO.close();
      }
    }
  }
  
  final class c
    extends hn
  {
    private final a.c<People.LoadPeopleResult> Dp;
    
    public c()
    {
      a.c localc;
      this.Dp = localc;
    }
    
    public void a(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.getMetadata() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.getMetadata().getParcelable("pendingIntent");; localObject = null)
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
          hs.this.a(new hs.d(hs.this, this.Dp, (Status)localObject, paramDataHolder, paramString));
          return;
        }
      }
    }
  }
  
  final class d
    extends dw<hr>.d<a.c<People.LoadPeopleResult>>
    implements People.LoadPeopleResult
  {
    private PersonBuffer DP;
    private final Status jY;
    private final String qT;
    
    public d(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      super(paramStatus, paramString);
      this.jY = paramDataHolder;
      String str;
      this.qT = str;
    }
    
    protected void a(a.c<People.LoadPeopleResult> paramc, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (paramDataHolder = new PersonBuffer(paramDataHolder);; paramDataHolder = null)
      {
        this.DP = paramDataHolder;
        paramc.a(this);
        return;
      }
    }
    
    public String getNextPageToken()
    {
      return this.qT;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.DP;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
    
    public void release()
    {
      if (this.DP != null) {
        this.DP.close();
      }
    }
  }
  
  final class e
    extends hn
  {
    private final a.c<Status> Dp;
    
    public e()
    {
      a.c localc;
      this.Dp = localc;
    }
    
    public void b(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt, null, paramBundle);
        hs.this.a(new hs.f(hs.this, this.Dp, paramBundle));
        return;
      }
    }
  }
  
  final class f
    extends dw<hr>.b<a.c<Status>>
  {
    private final Status jY;
    
    public f(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.jY = localStatus;
    }
    
    protected void aL() {}
    
    protected void c(a.c<Status> paramc)
    {
      hs.this.disconnect();
      if (paramc != null) {
        paramc.a(this.jY);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */