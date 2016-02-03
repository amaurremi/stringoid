package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.n;
import java.util.List;

public class d
  extends Fragment
  implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult>
{
  private boolean Ju;
  private int Jv = -1;
  private ConnectionResult Jw;
  private final Handler Jx = new Handler(Looper.getMainLooper());
  private final SparseArray<b> Jy = new SparseArray();
  
  public static d a(FragmentActivity paramFragmentActivity)
  {
    n.aT("Must be called from main thread of process");
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      d locald = (d)localFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
      if (locald != null)
      {
        paramFragmentActivity = locald;
        if (!locald.isRemoving()) {}
      }
      else
      {
        paramFragmentActivity = new d();
        localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsSupportLifecycleFragment").commit();
        localFragmentManager.executePendingTransactions();
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramFragmentActivity);
    }
  }
  
  private void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    if (!this.Ju)
    {
      this.Ju = true;
      this.Jv = paramInt;
      this.Jw = paramConnectionResult;
      this.Jx.post(new c(paramInt, paramConnectionResult));
    }
  }
  
  private void an(int paramInt)
  {
    if (paramInt == this.Jv) {
      gv();
    }
  }
  
  private void b(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (b)this.Jy.get(paramInt);
    if (localObject != null)
    {
      al(paramInt);
      localObject = ((b)localObject).JC;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
    gv();
  }
  
  private void gv()
  {
    int i = 0;
    this.Ju = false;
    this.Jv = -1;
    this.Jw = null;
    LoaderManager localLoaderManager = getLoaderManager();
    while (i < this.Jy.size())
    {
      int j = this.Jy.keyAt(i);
      a locala = am(j);
      if (locala != null) {
        locala.gw();
      }
      localLoaderManager.initLoader(j, null, this);
      i += 1;
    }
  }
  
  public void a(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    n.b(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.Jy.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Already managing a GoogleApiClient with id " + paramInt);
      paramGoogleApiClient = new b(paramGoogleApiClient, paramOnConnectionFailedListener, null);
      this.Jy.put(paramInt, paramGoogleApiClient);
      if (getActivity() != null) {
        getLoaderManager().initLoader(paramInt, null, this);
      }
      return;
    }
  }
  
  public void a(Loader<ConnectionResult> paramLoader, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess())
    {
      an(paramLoader.getId());
      return;
    }
    a(paramLoader.getId(), paramConnectionResult);
  }
  
  public GoogleApiClient ak(int paramInt)
  {
    if (getActivity() != null)
    {
      a locala = am(paramInt);
      if (locala != null) {
        return locala.Jz;
      }
    }
    return null;
  }
  
  public void al(int paramInt)
  {
    getLoaderManager().destroyLoader(paramInt);
    this.Jy.remove(paramInt);
  }
  
  a am(int paramInt)
  {
    try
    {
      a locala = (a)getLoaderManager().getLoader(paramInt);
      return locala;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", localClassCastException);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label66;
      }
      gv();
      return;
      if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
        break;
      }
      paramInt1 = i;
      continue;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = i;
    }
    label66:
    b(this.Jv, this.Jw);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    int i = 0;
    if (i < this.Jy.size())
    {
      int j = this.Jy.keyAt(i);
      paramActivity = am(j);
      if ((paramActivity != null) && (((b)this.Jy.valueAt(i)).Jz != paramActivity.Jz)) {
        getLoaderManager().restartLoader(j, null, this);
      }
      for (;;)
      {
        i += 1;
        break;
        getLoaderManager().initLoader(j, null, this);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    b(this.Jv, this.Jw);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.Ju = paramBundle.getBoolean("resolving_error", false);
      this.Jv = paramBundle.getInt("failed_client_id", -1);
      if (this.Jv >= 0) {
        this.Jw = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public Loader<ConnectionResult> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new a(getActivity(), ((b)this.Jy.get(paramInt)).Jz);
  }
  
  public void onLoaderReset(Loader<ConnectionResult> paramLoader)
  {
    if (paramLoader.getId() == this.Jv) {
      gv();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.Ju);
    if (this.Jv >= 0)
    {
      paramBundle.putInt("failed_client_id", this.Jv);
      paramBundle.putInt("failed_status", this.Jw.getErrorCode());
      paramBundle.putParcelable("failed_resolution", this.Jw.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (!this.Ju)
    {
      int i = 0;
      while (i < this.Jy.size())
      {
        getLoaderManager().initLoader(this.Jy.keyAt(i), null, this);
        i += 1;
      }
    }
  }
  
  static class a
    extends Loader<ConnectionResult>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private boolean JA;
    private ConnectionResult JB;
    public final GoogleApiClient Jz;
    
    public a(Context paramContext, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.Jz = paramGoogleApiClient;
    }
    
    private void a(ConnectionResult paramConnectionResult)
    {
      this.JB = paramConnectionResult;
      if ((isStarted()) && (!isAbandoned())) {
        deliverResult(paramConnectionResult);
      }
    }
    
    public void gw()
    {
      if (this.JA)
      {
        this.JA = false;
        if ((isStarted()) && (!isAbandoned())) {
          this.Jz.connect();
        }
      }
    }
    
    public void onConnected(Bundle paramBundle)
    {
      this.JA = false;
      a(ConnectionResult.HE);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.JA = true;
      a(paramConnectionResult);
    }
    
    public void onConnectionSuspended(int paramInt) {}
    
    protected void onReset()
    {
      this.JB = null;
      this.JA = false;
      this.Jz.unregisterConnectionCallbacks(this);
      this.Jz.unregisterConnectionFailedListener(this);
      this.Jz.disconnect();
    }
    
    protected void onStartLoading()
    {
      super.onStartLoading();
      this.Jz.registerConnectionCallbacks(this);
      this.Jz.registerConnectionFailedListener(this);
      if (this.JB != null) {
        deliverResult(this.JB);
      }
      if ((!this.Jz.isConnected()) && (!this.Jz.isConnecting()) && (!this.JA)) {
        this.Jz.connect();
      }
    }
    
    protected void onStopLoading()
    {
      this.Jz.disconnect();
    }
  }
  
  private static class b
  {
    public final GoogleApiClient.OnConnectionFailedListener JC;
    public final GoogleApiClient Jz;
    
    private b(GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.Jz = paramGoogleApiClient;
      this.JC = paramOnConnectionFailedListener;
    }
  }
  
  private class c
    implements Runnable
  {
    private final int JD;
    private final ConnectionResult JE;
    
    public c(int paramInt, ConnectionResult paramConnectionResult)
    {
      this.JD = paramInt;
      this.JE = paramConnectionResult;
    }
    
    public void run()
    {
      if (this.JE.hasResolution()) {
        try
        {
          int i = d.this.getActivity().getSupportFragmentManager().getFragments().indexOf(d.this);
          this.JE.startResolutionForResult(d.this.getActivity(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          d.a(d.this);
          return;
        }
      }
      if (GooglePlayServicesUtil.isUserRecoverableError(this.JE.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(this.JE.getErrorCode(), d.this.getActivity(), d.this, 2, d.this);
        return;
      }
      d.a(d.this, this.JD, this.JE);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */