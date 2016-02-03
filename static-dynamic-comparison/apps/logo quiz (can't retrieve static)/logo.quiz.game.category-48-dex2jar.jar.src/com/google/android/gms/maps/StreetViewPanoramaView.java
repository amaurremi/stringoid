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
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama aiW;
  private final a ajf;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.ajf = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ajf = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ajf = new a(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.ajf = new a(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  public final StreetViewPanorama getStreetViewPanorama()
  {
    if (this.aiW != null) {
      return this.aiW;
    }
    this.ajf.my();
    if (this.ajf.it() == null) {
      return null;
    }
    try
    {
      this.aiW = new StreetViewPanorama(((b)this.ajf.it()).mF().getStreetViewPanorama());
      return this.aiW;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.ajf.onCreate(paramBundle);
    if (this.ajf.it() == null)
    {
      paramBundle = this.ajf;
      a.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.ajf.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.ajf.onLowMemory();
  }
  
  public final void onPause()
  {
    this.ajf.onPause();
  }
  
  public final void onResume()
  {
    this.ajf.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.ajf.onSaveInstanceState(paramBundle);
  }
  
  static class a
    extends a<StreetViewPanoramaView.b>
  {
    protected f<StreetViewPanoramaView.b> aiI;
    private final ViewGroup aiN;
    private final StreetViewPanoramaOptions ajg;
    private final Context mContext;
    
    a(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.aiN = paramViewGroup;
      this.mContext = paramContext;
      this.ajg = paramStreetViewPanoramaOptions;
    }
    
    protected void a(f<StreetViewPanoramaView.b> paramf)
    {
      this.aiI = paramf;
      my();
    }
    
    public void my()
    {
      if ((this.aiI != null) && (it() == null)) {}
      try
      {
        IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = u.R(this.mContext).a(e.k(this.mContext), this.ajg);
        this.aiI.a(new StreetViewPanoramaView.b(this.aiN, localIStreetViewPanoramaViewDelegate));
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
    private final ViewGroup aiK;
    private final IStreetViewPanoramaViewDelegate ajh;
    private View aji;
    
    public b(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.ajh = ((IStreetViewPanoramaViewDelegate)n.i(paramIStreetViewPanoramaViewDelegate));
      this.aiK = ((ViewGroup)n.i(paramViewGroup));
    }
    
    public IStreetViewPanoramaViewDelegate mF()
    {
      return this.ajh;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.ajh.onCreate(paramBundle);
        this.aji = ((View)e.f(this.ajh.getView()));
        this.aiK.removeAllViews();
        this.aiK.addView(this.aji);
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
        this.ajh.onDestroy();
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
        this.ajh.onLowMemory();
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
        this.ajh.onPause();
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
        this.ajh.onResume();
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
        this.ajh.onSaveInstanceState(paramBundle);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */