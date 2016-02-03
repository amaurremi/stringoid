package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a<T extends LifecycleDelegate>
{
  private T LX;
  private Bundle LY;
  private LinkedList<i> LZ;
  private final f<T> Ma = new f()
  {
    public void a(T paramAnonymousT)
    {
      a.a(a.this, paramAnonymousT);
      paramAnonymousT = a.a(a.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((i)paramAnonymousT.next()).a(a.b(a.this));
      }
      a.a(a.this).clear();
      a.a(a.this, null);
    }
  };
  
  private void a(Bundle paramBundle, i parami)
  {
    if (this.LX != null)
    {
      parami.a(this.LX);
      return;
    }
    if (this.LZ == null) {
      this.LZ = new LinkedList();
    }
    this.LZ.add(parami);
    if (paramBundle != null)
    {
      if (this.LY != null) {
        break label76;
      }
      this.LY = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      a(this.Ma);
      return;
      label76:
      this.LY.putAll(paramBundle);
    }
  }
  
  public static void b(FrameLayout paramFrameLayout)
  {
    Context localContext = paramFrameLayout.getContext();
    final int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(localContext);
    String str2 = GooglePlayServicesUtil.d(localContext, i);
    String str1 = GooglePlayServicesUtil.e(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    if (str1 != null)
    {
      paramFrameLayout = new Button(localContext);
      paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramFrameLayout.setText(str1);
      localLinearLayout.addView(paramFrameLayout);
      paramFrameLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          a.this.startActivity(GooglePlayServicesUtil.c(a.this, i));
        }
      });
    }
  }
  
  private void ca(int paramInt)
  {
    while ((!this.LZ.isEmpty()) && (((i)this.LZ.getLast()).a() >= paramInt)) {
      this.LZ.removeLast();
    }
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    b(paramFrameLayout);
  }
  
  protected abstract void a(f<T> paramf);
  
  public T gH()
  {
    return this.LX;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    a(paramBundle, new i()
    {
      public int a()
      {
        return 1;
      }
      
      public void a(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onCreate(paramBundle);
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    a(paramBundle, new i()
    {
      public int a()
      {
        return 2;
      }
      
      public void a(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(a.b(a.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
    });
    if (this.LX == null) {
      a(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.LX != null)
    {
      this.LX.onDestroy();
      return;
    }
    ca(1);
  }
  
  public void onDestroyView()
  {
    if (this.LX != null)
    {
      this.LX.onDestroyView();
      return;
    }
    ca(2);
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    a(paramBundle2, new i()
    {
      public int a()
      {
        return 0;
      }
      
      public void a(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
    });
  }
  
  public void onLowMemory()
  {
    if (this.LX != null) {
      this.LX.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.LX != null)
    {
      this.LX.onPause();
      return;
    }
    ca(5);
  }
  
  public void onResume()
  {
    a(null, new i()
    {
      public int a()
      {
        return 5;
      }
      
      public void a(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.LX != null) {
      this.LX.onSaveInstanceState(paramBundle);
    }
    while (this.LY == null) {
      return;
    }
    paramBundle.putAll(this.LY);
  }
  
  public void onStart()
  {
    a(null, new i()
    {
      public int a()
      {
        return 4;
      }
      
      public void a(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        a.b(a.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (this.LX != null)
    {
      this.LX.onStop();
      return;
    }
    ca(4);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/dynamic/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */