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
import com.google.android.gms.common.d;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class b<T extends a>
{
  private T uM;
  private Bundle uN;
  private LinkedList<a> uO;
  private final f<T> uP = new f()
  {
    public void a(T paramAnonymousT)
    {
      b.a(b.this, paramAnonymousT);
      paramAnonymousT = b.a(b.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((b.a)paramAnonymousT.next()).b(b.b(b.this));
      }
      b.a(b.this).clear();
      b.a(b.this, null);
    }
  };
  
  private void a(Bundle paramBundle, a parama)
  {
    if (this.uM != null)
    {
      parama.b(this.uM);
      return;
    }
    if (this.uO == null) {
      this.uO = new LinkedList();
    }
    this.uO.add(parama);
    if (paramBundle != null)
    {
      if (this.uN != null) {
        break label76;
      }
      this.uN = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      a(this.uP);
      return;
      label76:
      this.uN.putAll(paramBundle);
    }
  }
  
  public static void b(FrameLayout paramFrameLayout)
  {
    Context localContext = paramFrameLayout.getContext();
    final int i = d.w(localContext);
    String str2 = d.b(localContext, i, -1);
    String str1 = d.a(localContext, i);
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
          this.uX.startActivity(d.a(this.uX, i, -1));
        }
      });
    }
  }
  
  private void ce(int paramInt)
  {
    while ((!this.uO.isEmpty()) && (((a)this.uO.getLast()).getState() >= paramInt)) {
      this.uO.removeLast();
    }
  }
  
  public void a(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    a(paramBundle2, new a()
    {
      public void b(a paramAnonymousa)
      {
        b.b(b.this).a(paramActivity, paramBundle1, paramBundle2);
      }
      
      public int getState()
      {
        return 0;
      }
    });
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    b(paramFrameLayout);
  }
  
  protected abstract void a(f<T> paramf);
  
  public T ny()
  {
    return this.uM;
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    a(paramBundle, new a()
    {
      public void b(a paramAnonymousa)
      {
        b.b(b.this).onCreate(paramBundle);
      }
      
      public int getState()
      {
        return 1;
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    a(paramBundle, new a()
    {
      public void b(a paramAnonymousa)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(b.b(b.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
      
      public int getState()
      {
        return 2;
      }
    });
    if (this.uM == null) {
      a(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.uM != null)
    {
      this.uM.onDestroy();
      return;
    }
    ce(1);
  }
  
  public void onDestroyView()
  {
    if (this.uM != null)
    {
      this.uM.onDestroyView();
      return;
    }
    ce(2);
  }
  
  public void onLowMemory()
  {
    if (this.uM != null) {
      this.uM.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.uM != null)
    {
      this.uM.onPause();
      return;
    }
    ce(5);
  }
  
  public void onResume()
  {
    a(null, new a()
    {
      public void b(a paramAnonymousa)
      {
        b.b(b.this).onResume();
      }
      
      public int getState()
      {
        return 5;
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.uM != null) {
      this.uM.onSaveInstanceState(paramBundle);
    }
    while (this.uN == null) {
      return;
    }
    paramBundle.putAll(this.uN);
  }
  
  private static abstract interface a
  {
    public abstract void b(a parama);
    
    public abstract int getState();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/dynamic/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */