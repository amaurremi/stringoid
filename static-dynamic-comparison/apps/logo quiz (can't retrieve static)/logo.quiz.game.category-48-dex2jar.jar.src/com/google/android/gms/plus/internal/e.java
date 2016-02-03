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
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.d.b;
import com.google.android.gms.common.internal.d.c;
import com.google.android.gms.common.internal.d.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.d.g;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.internal.jp;
import com.google.android.gms.internal.nv;
import com.google.android.gms.internal.ny;
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
  extends com.google.android.gms.common.internal.d<d>
{
  private Person ali;
  private final h alj;
  
  public e(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramh.ne());
    this.alj = paramh;
  }
  
  @Deprecated
  public e(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    this(paramContext, paramContext.getMainLooper(), new d.c(paramConnectionCallbacks), new d.g(paramOnConnectionFailedListener), paramh);
  }
  
  public i a(BaseImplementation.b<People.LoadPeopleResult> paramb, int paramInt, String paramString)
  {
    dK();
    paramb = new e(paramb);
    try
    {
      paramString = ((d)gS()).a(paramb, 1, paramInt, -1, paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramb.a(DataHolder.as(8), null);
    }
    return null;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.ali = ny.i(paramBundle.getByteArray("loaded_person"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(BaseImplementation.b<Moments.LoadMomentsResult> paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    dK();
    if (paramb != null) {}
    for (paramb = new b(paramb);; paramb = null) {
      try
      {
        ((d)gS()).a(paramb, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramb.a(DataHolder.as(8), null, null);
      }
    }
  }
  
  public void a(BaseImplementation.b<Status> paramb, Moment paramMoment)
  {
    dK();
    if (paramb != null) {}
    for (paramb = new a(paramb);; paramb = null) {
      try
      {
        paramMoment = jp.a((nv)paramMoment);
        ((d)gS()).a(paramb, paramMoment);
        return;
      }
      catch (RemoteException paramMoment)
      {
        if (paramb != null) {
          break;
        }
        throw new IllegalStateException(paramMoment);
        paramb.aB(new Status(8, null, null));
      }
    }
  }
  
  public void a(BaseImplementation.b<People.LoadPeopleResult> paramb, Collection<String> paramCollection)
  {
    dK();
    paramb = new e(paramb);
    try
    {
      ((d)gS()).a(paramb, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException paramCollection)
    {
      paramb.a(DataHolder.as(8), null);
    }
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    Bundle localBundle = this.alj.nm();
    localBundle.putStringArray("request_visible_actions", this.alj.nf());
    paramk.a(parame, 6111000, this.alj.ni(), this.alj.nh(), gR(), this.alj.getAccountName(), localBundle);
  }
  
  protected d bH(IBinder paramIBinder)
  {
    return d.a.bG(paramIBinder);
  }
  
  public boolean cd(String paramString)
  {
    return Arrays.asList(gR()).contains(paramString);
  }
  
  public void clearDefaultAccount()
  {
    dK();
    try
    {
      this.ali = null;
      ((d)gS()).clearDefaultAccount();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void d(BaseImplementation.b<People.LoadPeopleResult> paramb, String[] paramArrayOfString)
  {
    a(paramb, Arrays.asList(paramArrayOfString));
  }
  
  public String getAccountName()
  {
    dK();
    try
    {
      String str = ((d)gS()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person getCurrentPerson()
  {
    dK();
    return this.ali;
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  public void k(BaseImplementation.b<Moments.LoadMomentsResult> paramb)
  {
    a(paramb, 20, null, null, null, "me");
  }
  
  public void l(BaseImplementation.b<People.LoadPeopleResult> paramb)
  {
    dK();
    paramb = new e(paramb);
    try
    {
      ((d)gS()).a(paramb, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramb.a(DataHolder.as(8), null);
    }
  }
  
  public void m(BaseImplementation.b<Status> paramb)
  {
    dK();
    clearDefaultAccount();
    paramb = new g(paramb);
    try
    {
      ((d)gS()).b(paramb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      paramb.h(8, null);
    }
  }
  
  public i r(BaseImplementation.b<People.LoadPeopleResult> paramb, String paramString)
  {
    return a(paramb, 0, paramString);
  }
  
  public void removeMoment(String paramString)
  {
    dK();
    try
    {
      ((d)gS()).removeMoment(paramString);
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
    private final BaseImplementation.b<Status> alk;
    
    public a()
    {
      BaseImplementation.b localb;
      this.alk = localb;
    }
    
    public void aB(Status paramStatus)
    {
      e.this.a(new e.d(e.this, this.alk, paramStatus));
    }
  }
  
  final class b
    extends a
  {
    private final BaseImplementation.b<Moments.LoadMomentsResult> alk;
    
    public b()
    {
      BaseImplementation.b localb;
      this.alk = localb;
    }
    
    public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      if (paramDataHolder.gz() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.gz().getParcelable("pendingIntent");; localObject = null)
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
          e.this.a(new e.c(e.this, this.alk, (Status)localObject, paramDataHolder, paramString1, paramString2));
          return;
        }
      }
    }
  }
  
  final class c
    extends com.google.android.gms.common.internal.d<d>.d<BaseImplementation.b<Moments.LoadMomentsResult>>
    implements Moments.LoadMomentsResult
  {
    private final Status CM;
    private final String Ni;
    private final String alm;
    private MomentBuffer aln;
    
    public c(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      super(paramStatus, paramString1);
      this.CM = paramDataHolder;
      this.Ni = paramString2;
      String str;
      this.alm = str;
    }
    
    protected void a(BaseImplementation.b<Moments.LoadMomentsResult> paramb, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (paramDataHolder = new MomentBuffer(paramDataHolder);; paramDataHolder = null)
      {
        this.aln = paramDataHolder;
        paramb.b(this);
        return;
      }
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.aln;
    }
    
    public String getNextPageToken()
    {
      return this.Ni;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
    
    public String getUpdated()
    {
      return this.alm;
    }
    
    public void release()
    {
      if (this.aln != null) {
        this.aln.close();
      }
    }
  }
  
  final class d
    extends com.google.android.gms.common.internal.d<d>.b<BaseImplementation.b<Status>>
  {
    private final Status CM;
    
    public d(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.CM = localStatus;
    }
    
    protected void gT() {}
    
    protected void n(BaseImplementation.b<Status> paramb)
    {
      if (paramb != null) {
        paramb.b(this.CM);
      }
    }
  }
  
  final class e
    extends a
  {
    private final BaseImplementation.b<People.LoadPeopleResult> alk;
    
    public e()
    {
      BaseImplementation.b localb;
      this.alk = localb;
    }
    
    public void a(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.gz() != null) {}
      for (Object localObject = (PendingIntent)paramDataHolder.gz().getParcelable("pendingIntent");; localObject = null)
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
          e.this.a(new e.f(e.this, this.alk, (Status)localObject, paramDataHolder, paramString));
          return;
        }
      }
    }
  }
  
  final class f
    extends com.google.android.gms.common.internal.d<d>.d<BaseImplementation.b<People.LoadPeopleResult>>
    implements People.LoadPeopleResult
  {
    private final Status CM;
    private final String Ni;
    private PersonBuffer alo;
    
    public f(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      super(paramStatus, paramString);
      this.CM = paramDataHolder;
      String str;
      this.Ni = str;
    }
    
    protected void a(BaseImplementation.b<People.LoadPeopleResult> paramb, DataHolder paramDataHolder)
    {
      if (paramDataHolder != null) {}
      for (paramDataHolder = new PersonBuffer(paramDataHolder);; paramDataHolder = null)
      {
        this.alo = paramDataHolder;
        paramb.b(this);
        return;
      }
    }
    
    public String getNextPageToken()
    {
      return this.Ni;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.alo;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
    
    public void release()
    {
      if (this.alo != null) {
        this.alo.close();
      }
    }
  }
  
  final class g
    extends a
  {
    private final BaseImplementation.b<Status> alk;
    
    public g()
    {
      BaseImplementation.b localb;
      this.alk = localb;
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt, null, paramBundle);
        e.this.a(new e.h(e.this, this.alk, paramBundle));
        return;
      }
    }
  }
  
  final class h
    extends com.google.android.gms.common.internal.d<d>.b<BaseImplementation.b<Status>>
  {
    private final Status CM;
    
    public h(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.CM = localStatus;
    }
    
    protected void gT() {}
    
    protected void n(BaseImplementation.b<Status> paramb)
    {
      e.this.disconnect();
      if (paramb != null) {
        paramb.b(this.CM);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */