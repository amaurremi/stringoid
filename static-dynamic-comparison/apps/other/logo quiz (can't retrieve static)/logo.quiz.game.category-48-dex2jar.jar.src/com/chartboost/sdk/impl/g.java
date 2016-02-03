package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.c.a;
import com.chartboost.sdk.c.b;
import com.chartboost.sdk.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends com.chartboost.sdk.c
{
  private static int h = 50;
  private static int i = 50;
  private static int j = 30;
  private List<JSONObject> k = new ArrayList();
  private com.chartboost.sdk.Libraries.g l = new com.chartboost.sdk.Libraries.g(this);
  private com.chartboost.sdk.Libraries.g m = new com.chartboost.sdk.Libraries.g(this);
  private com.chartboost.sdk.Libraries.g n = new com.chartboost.sdk.Libraries.g(this);
  private Map<String, com.chartboost.sdk.Libraries.g> o;
  
  public g(a parama)
  {
    super(parama);
    this.e = 3;
  }
  
  protected c.b a(Context paramContext)
  {
    return new a(paramContext, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("cells");
    if (paramJSONObject == null)
    {
      this.g.a(CBError.CBImpressionError.INTERNAL);
      return;
    }
    this.o = new HashMap();
    int i1 = 0;
    if (i1 < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i1);
      this.k.add(localJSONObject);
      Object localObject = localJSONObject.optString("type", "");
      if (((String)localObject).equals("regular"))
      {
        localJSONObject = localJSONObject.optJSONObject("assets");
        if (localJSONObject != null)
        {
          this.e += 1;
          localObject = new com.chartboost.sdk.Libraries.g(this);
          this.o.put("" + i1, localObject);
          ((com.chartboost.sdk.Libraries.g)localObject).a(localJSONObject, "icon", new Bundle());
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (((String)localObject).equals("featured"))
        {
          localJSONObject = localJSONObject.optJSONObject("assets");
          if (localJSONObject != null)
          {
            this.e += 1;
            localObject = new com.chartboost.sdk.Libraries.g(this);
            this.o.put(String.format(Locale.US, "%d-%s", new Object[] { Integer.valueOf(i1), "portrait" }), localObject);
            ((com.chartboost.sdk.Libraries.g)localObject).a(localJSONObject, "portrait", new Bundle());
            this.e += 1;
            localObject = new com.chartboost.sdk.Libraries.g(this);
            this.o.put(String.format(Locale.US, "%d-%s", new Object[] { Integer.valueOf(i1), "landscape" }), localObject);
            ((com.chartboost.sdk.Libraries.g)localObject).a(localJSONObject, "landscape", new Bundle());
          }
        }
        else if (!((String)localObject).equals("webview")) {}
      }
    }
    this.l.a("close");
    this.m.a("header-center");
    this.n.a("header-tile");
  }
  
  public void d()
  {
    super.d();
    this.k = null;
    Iterator localIterator = this.o.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((com.chartboost.sdk.Libraries.g)((Map.Entry)localIterator.next()).getValue()).c();
    }
    this.o.clear();
    this.l.c();
    this.m.c();
    this.n.c();
    this.l = null;
    this.n = null;
    this.m = null;
  }
  
  public class a
    extends c.b
  {
    private ImageView d;
    private ImageView e;
    private FrameLayout f;
    private r g;
    private u h;
    private u i;
    private a j;
    
    private a(Context paramContext)
    {
      super(paramContext);
      setBackgroundColor(-1842205);
      this.f = new FrameLayout(paramContext);
      this.e = new ImageView(paramContext);
      this.d = new ImageView(paramContext);
      if (CBPreferences.getInstance().getForcedOrientationDifference().isOdd()) {}
      for (int k = 0;; k = 1)
      {
        this.g = new r(paramContext, k);
        this.g.b().setBackgroundColor(-1842205);
        this.f.setFocusable(false);
        this.e.setFocusable(false);
        this.d.setFocusable(false);
        this.d.setClickable(true);
        this.h = new u(paramContext, this.d);
        this.i = new u(paramContext, this.f);
        addView(this.i);
        this.f.addView(this.e);
        addView(this.h);
        a(this.e);
        a(this.f);
        a(this.d);
        a(this.i);
        a(this.h);
        this.d.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (g.this.a != null) {
              g.this.a.a();
            }
          }
        });
        this.j = new a(paramContext);
        return;
      }
    }
    
    private void a(View paramView)
    {
      int k = 200;
      if (200 == getId()) {
        k = 201;
      }
      for (View localView = findViewById(k); localView != null; localView = findViewById(k)) {
        k += 1;
      }
      paramView.setId(k);
      paramView.setSaveEnabled(false);
    }
    
    protected void a(int paramInt1, int paramInt2)
    {
      if (this.g.a() != null) {
        removeView(this.g.a());
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      final CBOrientation.Difference localDifference = CBPreferences.getInstance().getForcedOrientationDifference();
      if (localDifference.isOdd())
      {
        paramInt1 = CBUtility.a(g.h(), getContext());
        localLayoutParams1.width = paramInt1;
        if (!localDifference.isOdd()) {
          break label621;
        }
        paramInt1 = -1;
        label117:
        localLayoutParams1.height = paramInt1;
        switch (g.1.a[localDifference.ordinal()])
        {
        default: 
          label156:
          Object localObject = new BitmapDrawable(g.a(g.this).e());
          ((BitmapDrawable)localObject).setTileModeX(Shader.TileMode.REPEAT);
          ((BitmapDrawable)localObject).setTileModeY(Shader.TileMode.CLAMP);
          this.f.setBackgroundDrawable((Drawable)localObject);
          if (g.b(g.this) != null)
          {
            this.e.setImageBitmap(g.b(g.this).e());
            localLayoutParams.width = CBUtility.a(g.b(g.this).a(), getContext());
            localLayoutParams.height = CBUtility.a(Math.min(g.h(), g.b(g.this).b()), getContext());
          }
          this.d.setImageBitmap(g.c(g.this).e());
          if (localDifference.isOdd())
          {
            paramInt1 = g.i();
            label304:
            localLayoutParams2.width = CBUtility.a(paramInt1, getContext());
            if (!localDifference.isOdd()) {
              break label662;
            }
            paramInt1 = g.j();
            label329:
            localLayoutParams2.height = CBUtility.a(paramInt1, getContext());
            switch (g.1.a[localDifference.ordinal()])
            {
            default: 
              localLayoutParams2.rightMargin = CBUtility.a(10, getContext());
              localLayoutParams2.topMargin = CBUtility.a((g.h() - g.i()) / 2, getContext());
              localLayoutParams2.addRule(11);
              label418:
              localLayoutParams3.width = -1;
              localLayoutParams3.height = -1;
              switch (g.1.a[localDifference.ordinal()])
              {
              default: 
                localLayoutParams3.addRule(3, this.i.getId());
                label477:
                localObject = this.g;
                if (localDifference.isOdd())
                {
                  paramInt1 = 0;
                  label493:
                  ((r)localObject).a(paramInt1);
                  a(this.g.a());
                  this.g.a(this.j);
                  addView(this.g.a(), localLayoutParams3);
                  if (localDifference != CBOrientation.Difference.ANGLE_180) {
                    break label857;
                  }
                  this.g.b().setGravity(80);
                }
                break;
              }
              break;
            }
          }
          break;
        }
      }
      for (;;)
      {
        this.i.setLayoutParams(localLayoutParams1);
        this.e.setLayoutParams(localLayoutParams);
        this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.h.setLayoutParams(localLayoutParams2);
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        post(new Runnable()
        {
          public void run()
          {
            if (g.a.a(g.a.this) == null) {}
            do
            {
              return;
              g.a.a(g.a.this, true);
              g.a.this.requestLayout();
              g.a.a(g.a.this).a().requestLayout();
              g.a.a(g.a.this).b().requestLayout();
              g.a.b(g.a.this, false);
            } while ((localDifference != CBOrientation.Difference.ANGLE_180) && (localDifference != CBOrientation.Difference.ANGLE_90));
            g.a.a(g.a.this).c();
          }
        });
        return;
        paramInt1 = -1;
        break;
        label621:
        paramInt1 = CBUtility.a(g.h(), getContext());
        break label117;
        localLayoutParams1.addRule(11);
        break label156;
        localLayoutParams1.addRule(12);
        break label156;
        paramInt1 = g.j();
        break label304;
        label662:
        paramInt1 = g.i();
        break label329;
        localLayoutParams2.bottomMargin = CBUtility.a(10, getContext());
        localLayoutParams2.rightMargin = CBUtility.a((g.h() - g.i()) / 2, getContext());
        localLayoutParams2.addRule(11);
        localLayoutParams2.addRule(12);
        break label418;
        localLayoutParams2.leftMargin = CBUtility.a(10, getContext());
        localLayoutParams2.bottomMargin = CBUtility.a((g.h() - g.i()) / 2, getContext());
        localLayoutParams2.addRule(12);
        break label418;
        localLayoutParams2.topMargin = CBUtility.a(10, getContext());
        localLayoutParams2.leftMargin = CBUtility.a((g.h() - g.i()) / 2, getContext());
        break label418;
        localLayoutParams3.addRule(0, this.i.getId());
        break label477;
        localLayoutParams3.addRule(2, this.i.getId());
        break label477;
        localLayoutParams3.addRule(1, this.i.getId());
        break label477;
        paramInt1 = 1;
        break label493;
        label857:
        if (localDifference == CBOrientation.Difference.ANGLE_90) {
          this.g.b().setGravity(5);
        } else {
          this.g.b().setGravity(0);
        }
      }
    }
    
    public void c()
    {
      super.c();
      this.d = null;
      this.e = null;
      this.g = null;
    }
    
    public class a
      extends ArrayAdapter<JSONObject>
    {
      private Context b;
      
      public a(Context paramContext)
      {
        super(0, g.d(g.this));
        this.b = paramContext;
      }
      
      public JSONObject a(int paramInt)
      {
        return (JSONObject)g.d(g.this).get(paramInt);
      }
      
      public int getCount()
      {
        return g.d(g.this).size();
      }
      
      public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        Object localObject1 = CBPreferences.getInstance().getForcedOrientationDifference();
        int i = paramInt;
        if (((CBOrientation.Difference)localObject1).isReverse()) {
          i = getCount() - 1 - paramInt;
        }
        final JSONObject localJSONObject = a(i);
        Object localObject2 = localJSONObject.optString("type", "");
        paramViewGroup = null;
        if (paramView == null) {
          if (((String)localObject2).equals("featured"))
          {
            paramView = new c(this.b);
            paramViewGroup = new u(this.b, (View)paramView);
            label92:
            paramView.a(localJSONObject, i);
            localObject2 = (b)paramView;
            if (!((CBOrientation.Difference)localObject1).isOdd()) {
              break label249;
            }
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(paramView.a(), -1));
          }
        }
        for (;;)
        {
          localObject1 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              String str = localJSONObject.optString("deep-link");
              if (str != null)
              {
                paramAnonymousView = str;
                if (!str.equals("")) {}
              }
              else
              {
                paramAnonymousView = localJSONObject.optString("link");
              }
              if (g.this.b != null) {
                g.this.b.a(g.e(g.this), paramAnonymousView, localJSONObject);
              }
            }
          };
          ((b)localObject2).a = ((View.OnClickListener)localObject1);
          ((b)localObject2).setOnClickListener((View.OnClickListener)localObject1);
          if ((paramView instanceof d)) {
            ((d)paramView).b.setOnClickListener((View.OnClickListener)localObject1);
          }
          return paramViewGroup;
          if (((String)localObject2).equals("regular"))
          {
            paramView = new d(this.b);
            break;
          }
          paramView = paramViewGroup;
          if (!((String)localObject2).equals("webview")) {
            break;
          }
          paramView = new h(this.b);
          break;
          paramViewGroup = (u)paramView;
          paramView = (g.b)paramViewGroup.a();
          break label92;
          label249:
          paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, paramView.a()));
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract int a();
    
    public abstract void a(JSONObject paramJSONObject, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */