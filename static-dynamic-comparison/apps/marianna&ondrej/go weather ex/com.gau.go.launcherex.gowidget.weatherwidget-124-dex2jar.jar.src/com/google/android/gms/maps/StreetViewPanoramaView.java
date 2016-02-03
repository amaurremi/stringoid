package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama Sj;
  private final a Ss;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.Ss = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Ss = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.Ss = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.Ss = new a(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  public final StreetViewPanorama getStreetViewPanorama()
  {
    if (this.Sj != null) {
      return this.Sj;
    }
    this.Ss.ip();
    if (this.Ss.fW() == null) {
      return null;
    }
    try
    {
      this.Sj = new StreetViewPanorama(((b)this.Ss.fW()).iw().getStreetViewPanorama());
      return this.Sj;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.Ss.onCreate(paramBundle);
    if (this.Ss.fW() == null)
    {
      paramBundle = this.Ss;
      a.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.Ss.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.Ss.onLowMemory();
  }
  
  public final void onPause()
  {
    this.Ss.onPause();
  }
  
  public final void onResume()
  {
    this.Ss.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.Ss.onSaveInstanceState(paramBundle);
  }
  
  static class a
    extends a<StreetViewPanoramaView.b>
  {
    protected f<StreetViewPanoramaView.b> RV;
    private final ViewGroup Sa;
    private final StreetViewPanoramaOptions St;
    private final Context mContext;
    
    a(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.Sa = paramViewGroup;
      this.mContext = paramContext;
      this.St = paramStreetViewPanoramaOptions;
    }
    
    protected void a(f<StreetViewPanoramaView.b> paramf)
    {
      this.RV = paramf;
      ip();
    }
    
    public void ip()
    {
      if ((this.RV != null) && (fW() == null)) {}
      try
      {
        IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = u.A(this.mContext).a(e.h(this.mContext), this.St);
        this.RV.a(new StreetViewPanoramaView.b(this.Sa, localIStreetViewPanoramaViewDelegate));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
  
  static class b
    implements LifecycleDelegate
  {
    private final ViewGroup RX;
    private final IStreetViewPanoramaViewDelegate Su;
    private View Sv;
    
    public b(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.Su = ((IStreetViewPanoramaViewDelegate)fq.f(paramIStreetViewPanoramaViewDelegate));
      this.RX = ((ViewGroup)fq.f(paramViewGroup));
    }
    
    public IStreetViewPanoramaViewDelegate iw()
    {
      return this.Su;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.Su.onCreate(paramBundle);
        this.Sv = ((View)e.d(this.Su.getView()));
        this.RX.removeAllViews();
        this.RX.addView(this.Sv);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.Su.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.Su.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onPause()
    {
      try
      {
        this.Su.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.Su.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.Su.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */