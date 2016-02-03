package com.venticake.retrica;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.venticake.retrica.setting.a;

public class h
{
  private MainActivity a;
  private f b;
  private float[] c = { 0.0F, 0.0F, 1.0F, 1.0F };
  private int d = 0;
  private int e = 0;
  
  public h()
  {
    this.a = null;
    this.b = null;
  }
  
  public h(MainActivity paramMainActivity)
  {
    this.a = paramMainActivity;
    this.b = new f(this.a);
    h();
    ((ImageButton)this.a.findViewById(2131296471)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(0);
      }
    });
    ((ImageButton)this.a.findViewById(2131296472)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(2);
      }
    });
    ((ImageButton)this.a.findViewById(2131296473)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(1);
      }
    });
    ((ImageButton)this.a.findViewById(2131296474)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(4);
      }
    });
    ((ImageButton)this.a.findViewById(2131296475)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(3);
      }
    });
    ((ImageButton)this.a.findViewById(2131296476)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(5);
      }
    });
    ((ImageButton)this.a.findViewById(2131296477)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(6);
      }
    });
    ((ImageButton)this.a.findViewById(2131296478)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(8);
      }
    });
    ((ImageButton)this.a.findViewById(2131296479)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(7);
      }
    });
    ((ImageButton)this.a.findViewById(2131296481)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(10);
      }
    });
    ((ImageButton)this.a.findViewById(2131296482)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(12);
      }
    });
    ((ImageButton)this.a.findViewById(2131296483)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(11);
      }
    });
    ((ImageButton)this.a.findViewById(2131296484)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(14);
      }
    });
    ((ImageButton)this.a.findViewById(2131296485)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(13);
      }
    });
    ((ImageButton)this.a.findViewById(2131296486)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(15);
      }
    });
    ((ImageButton)this.a.findViewById(2131296487)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(16);
      }
    });
    ((ImageButton)this.a.findViewById(2131296488)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(18);
      }
    });
    ((ImageButton)this.a.findViewById(2131296489)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(17);
      }
    });
    ((ImageButton)this.a.findViewById(2131296491)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(20);
      }
    });
    ((ImageButton)this.a.findViewById(2131296492)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(21);
      }
    });
    ((ImageButton)this.a.findViewById(2131296493)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(22);
      }
    });
    ((ImageButton)this.a.findViewById(2131296494)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(23);
      }
    });
    ((ImageButton)this.a.findViewById(2131296495)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(24);
      }
    });
    ((ImageButton)this.a.findViewById(2131296496)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(25);
      }
    });
    ((ImageButton)this.a.findViewById(2131296497)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(26);
      }
    });
    ((ImageButton)this.a.findViewById(2131296498)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(27);
      }
    });
    ((ImageButton)this.a.findViewById(2131296499)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        h.this.a(28);
      }
    });
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f3 = 1.0F / paramInt1 / (1.0F / paramInt2);
    float f1;
    float f2;
    if (paramInt3 / paramInt4 > f3)
    {
      f1 = paramInt4;
      f2 = f1 * f3;
    }
    for (;;)
    {
      f3 = (paramInt3 - f2) / paramInt3 / 2.0F;
      float f4 = (paramInt4 - f1) / paramInt4 / 2.0F;
      this.c = new float[] { f3, f4, 1.0F - f3, 1.0F - f4 };
      this.d = ((int)f2);
      this.e = ((int)f1);
      Log.d("retrica", "cropSize: " + f2 + ", " + f1 + " (" + paramInt3 + ", " + paramInt4 + ")");
      return;
      f2 = paramInt3;
      f1 = f2 / f3;
    }
  }
  
  private void g()
  {
    int i = this.a.x();
    FrameLayout localFrameLayout = (FrameLayout)this.a.findViewById(2131296378);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
    localFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  private void h()
  {
    final LinearLayout localLinearLayout1 = (LinearLayout)this.a.findViewById(2131296470);
    final LinearLayout localLinearLayout2 = (LinearLayout)this.a.findViewById(2131296480);
    final LinearLayout localLinearLayout3 = (LinearLayout)this.a.findViewById(2131296490);
    final ImageButton localImageButton1 = (ImageButton)this.a.findViewById(2131296375);
    final ImageButton localImageButton2 = (ImageButton)this.a.findViewById(2131296376);
    final ImageButton localImageButton3 = (ImageButton)this.a.findViewById(2131296377);
    localImageButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (localLinearLayout2.getVisibility() == 0)
        {
          localImageButton2.setBackgroundColor(-1);
          localLinearLayout2.setVisibility(4);
        }
        for (;;)
        {
          localImageButton1.setBackgroundColor(Color.rgb(224, 224, 224));
          localLinearLayout1.setVisibility(0);
          return;
          if (localLinearLayout3.getVisibility() == 0)
          {
            localImageButton3.setBackgroundColor(-1);
            localLinearLayout3.setVisibility(4);
          }
        }
      }
    });
    localImageButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (localLinearLayout1.getVisibility() == 0)
        {
          localImageButton1.setBackgroundColor(-1);
          localLinearLayout1.setVisibility(4);
        }
        for (;;)
        {
          localImageButton2.setBackgroundColor(Color.rgb(224, 224, 224));
          localLinearLayout2.setVisibility(0);
          return;
          if (localLinearLayout3.getVisibility() == 0)
          {
            localImageButton3.setBackgroundColor(-1);
            localLinearLayout3.setVisibility(4);
          }
        }
      }
    });
    localImageButton3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (localLinearLayout1.getVisibility() == 0)
        {
          localImageButton1.setBackgroundColor(-1);
          localLinearLayout1.setVisibility(4);
        }
        for (;;)
        {
          localImageButton3.setBackgroundColor(Color.rgb(224, 224, 224));
          localLinearLayout3.setVisibility(0);
          return;
          if (localLinearLayout2.getVisibility() == 0)
          {
            localImageButton2.setBackgroundColor(-1);
            localLinearLayout2.setVisibility(4);
          }
        }
      }
    });
  }
  
  public void a(int paramInt)
  {
    this.a.d(paramInt);
    a.a().d(this.a.f);
    ImageButton localImageButton = (ImageButton)this.a.findViewById(2131296359);
    this.b.a(localImageButton, this.a.f);
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    case 19: 
    default: 
      this.c = new float[] { 0.0F, 0.0F, 1.0F, 1.0F };
      this.d = paramInt2;
      this.e = paramInt3;
    }
    for (;;)
    {
      Log.d("retrica", "CropInfo: " + this.d + ", " + this.e);
      Log.d("retrica", "CropRegion: " + this.c[0] + ", " + this.c[1] + ", " + this.c[2] + ", " + this.c[3]);
      return;
      paramInt1 = Math.min(paramInt2, paramInt3);
      float f1 = (paramInt2 - paramInt1) / paramInt2 / 2.0F;
      float f2 = (paramInt3 - paramInt1) / paramInt3 / 2.0F;
      this.c = new float[] { f1, f2, 1.0F - f1, 1.0F - f2 };
      this.d = paramInt1;
      this.e = paramInt1;
      continue;
      a(2, 1, paramInt2, paramInt3);
      continue;
      a(3, 1, paramInt2, paramInt3);
      continue;
      a(4, 1, paramInt2, paramInt3);
      continue;
      a(1, 2, paramInt2, paramInt3);
      continue;
      a(1, 3, paramInt2, paramInt3);
      continue;
      a(1, 4, paramInt2, paramInt3);
    }
  }
  
  public void a(ImageButton paramImageButton)
  {
    paramImageButton = (LinearLayout)this.a.findViewById(2131296374);
    FrameLayout localFrameLayout = (FrameLayout)this.a.findViewById(2131296378);
    LinearLayout localLinearLayout1 = (LinearLayout)this.a.findViewById(2131296470);
    LinearLayout localLinearLayout2 = (LinearLayout)this.a.findViewById(2131296480);
    LinearLayout localLinearLayout3 = (LinearLayout)this.a.findViewById(2131296490);
    ImageButton localImageButton1 = (ImageButton)this.a.findViewById(2131296375);
    ImageButton localImageButton2 = (ImageButton)this.a.findViewById(2131296376);
    ImageButton localImageButton3 = (ImageButton)this.a.findViewById(2131296377);
    if (a())
    {
      b();
      return;
    }
    g();
    paramImageButton.setVisibility(0);
    localFrameLayout.setVisibility(0);
    switch (c())
    {
    case 9: 
    case 19: 
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      localLinearLayout1.setVisibility(0);
      localImageButton1.setBackgroundColor(Color.rgb(224, 224, 224));
      return;
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
      localLinearLayout2.setVisibility(0);
      localImageButton2.setBackgroundColor(Color.rgb(224, 224, 224));
      return;
    }
    localLinearLayout3.setVisibility(0);
    localImageButton3.setBackgroundColor(Color.rgb(224, 224, 224));
  }
  
  public boolean a()
  {
    return ((LinearLayout)this.a.findViewById(2131296374)).getVisibility() == 0;
  }
  
  public void b()
  {
    Object localObject1 = (LinearLayout)this.a.findViewById(2131296374);
    Object localObject2 = (FrameLayout)this.a.findViewById(2131296378);
    Object localObject3 = (LinearLayout)this.a.findViewById(2131296470);
    LinearLayout localLinearLayout1 = (LinearLayout)this.a.findViewById(2131296480);
    LinearLayout localLinearLayout2 = (LinearLayout)this.a.findViewById(2131296490);
    ((LinearLayout)localObject1).setVisibility(4);
    ((FrameLayout)localObject2).setVisibility(4);
    ((LinearLayout)localObject3).setVisibility(4);
    localLinearLayout1.setVisibility(4);
    localLinearLayout2.setVisibility(4);
    localObject1 = (ImageButton)this.a.findViewById(2131296375);
    localObject2 = (ImageButton)this.a.findViewById(2131296376);
    localObject3 = (ImageButton)this.a.findViewById(2131296377);
    ((ImageButton)localObject1).setBackgroundColor(-1);
    ((ImageButton)localObject2).setBackgroundColor(-1);
    ((ImageButton)localObject3).setBackgroundColor(-1);
  }
  
  public int c()
  {
    return a.a().n();
  }
  
  public float[] d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */