package com.jfeinstein.jazzyviewpager;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.l;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity
  extends Activity
{
  private JazzyViewPager amm;
  
  private void b(JazzyViewPager.TransitionEffect paramTransitionEffect)
  {
    this.amm = ((JazzyViewPager)findViewById(a.c.jazzy_pager));
    this.amm.a(paramTransitionEffect);
    this.amm.a(new a(null));
    this.amm.k(30);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.d.activity_main);
    b(JazzyViewPager.TransitionEffect.alY);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("Toggle Fade");
    String[] arrayOfString = getResources().getStringArray(a.a.jazzy_effects);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramMenu.add(arrayOfString[i]);
      i += 1;
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getTitle().toString().equals("Toggle Fade"))
    {
      paramMenuItem = this.amm;
      if (!this.amm.Cw()) {}
      for (boolean bool = true;; bool = false)
      {
        paramMenuItem.setFadeEnabled(bool);
        return true;
      }
    }
    b(JazzyViewPager.TransitionEffect.valueOf(paramMenuItem.getTitle().toString()));
    return true;
  }
  
  private class a
    extends l
  {
    private a() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView(MainActivity.a(MainActivity.this).fF(paramInt));
    }
    
    public int getCount()
    {
      return 10;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      TextView localTextView = new TextView(MainActivity.this);
      localTextView.setGravity(17);
      localTextView.setTextSize(30.0F);
      localTextView.setTextColor(-1);
      localTextView.setText("Page " + paramInt);
      localTextView.setPadding(30, 30, 30, 30);
      localTextView.setBackgroundColor(Color.rgb((int)Math.floor(Math.random() * 128.0D) + 64, (int)Math.floor(Math.random() * 128.0D) + 64, (int)Math.floor(Math.random() * 128.0D) + 64));
      paramViewGroup.addView(localTextView, -1, -1);
      MainActivity.a(MainActivity.this).f(localTextView, paramInt);
      return localTextView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      if ((paramView instanceof OutlineContainer)) {
        if (((OutlineContainer)paramView).getChildAt(0) != paramObject) {}
      }
      while (paramView == paramObject)
      {
        return true;
        return false;
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/jfeinstein/jazzyviewpager/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */