package com.jiubang.ggheart.apps.desks.diy.filter.core;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class FilterParameterBuidler
{
  private static List a;
  private static List b;
  
  protected FilterParameterBuidler(Context paramContext) {}
  
  private void a()
  {
    if (b == null) {}
  }
  
  private void b()
  {
    if (a == null)
    {
      a = new ArrayList();
      FilterParameter localFilterParameter = createFilterParameter(0);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(32768);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(65536);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(16384);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(131072);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(256);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(512);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(1024);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(2);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(4);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(8);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(16);
      a.add(localFilterParameter);
      localFilterParameter = createFilterParameter(32);
      a.add(localFilterParameter);
    }
  }
  
  public static FilterParameter createFilterParameter(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new FilterParameter(0, 2131166321, new int[] { 0, 0 });
    case 0: 
      return new FilterParameter(0, 2131166321, new int[] { 0, 0 });
    case 32768: 
      return new FilterParameter(32768, 2131166324, new int[] { 706, 719 });
    case 65536: 
      return new FilterParameter(65536, 2131166325, new int[] { 707, 720 });
    case 16384: 
      return new FilterParameter(16384, 2131166326, new int[] { 708, 721 });
    case 131072: 
      return new FilterParameter(131072, 2131166327, new int[] { 709, 722 });
    case 256: 
      return new FilterParameter(256, 2131166322, new int[] { 704, 717 });
    case 512: 
      return new FilterParameter(512, 2131166323, new int[] { 705, 718 });
    case 1024: 
      return new FilterParameter(1024, 2131166328, new int[] { 710, 723 });
    case 2: 
      return new FilterParameter(2, 2131166329, new int[] { 711, 724 });
    case 4: 
      localFilterParameter = new FilterParameter(4, 2131166330, new int[] { 712, 725 });
      localFilterParameter.setDiyColor(-88031);
      return localFilterParameter;
    case 8: 
      localFilterParameter = new FilterParameter(8, 2131166331, new int[] { 713, 726 });
      localFilterParameter.setDiyColor(-7660446);
      return localFilterParameter;
    case 16: 
      localFilterParameter = new FilterParameter(16, 2131166332, new int[] { 714, 727 });
      localFilterParameter.setDiyColor(-14774017);
      return localFilterParameter;
    }
    FilterParameter localFilterParameter = new FilterParameter(32, 2131166333, new int[] { 715, 728 });
    localFilterParameter.setDiyColor(-4395416);
    return localFilterParameter;
  }
  
  public static String getStatisticalTypeId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "1";
    case 0: 
      return "1";
    case 32768: 
      return "2";
    case 65536: 
      return "3";
    case 16384: 
      return "4";
    case 131072: 
      return "5";
    case 256: 
      return "6";
    case 512: 
      return "7";
    case 1024: 
      return "8";
    case 2: 
      return "9";
    case 4: 
      return "10";
    case 8: 
      return "11";
    case 16: 
      return "12";
    }
    return "13";
  }
  
  public List buildParameter(int paramInt)
  {
    if (paramInt == 0)
    {
      b();
      return a;
    }
    if (paramInt == 1)
    {
      a();
      return b;
    }
    return null;
  }
  
  public void cleanUp()
  {
    if (a != null)
    {
      a.clear();
      a = null;
    }
    if (b != null)
    {
      b.clear();
      b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/ggheart/apps/desks/diy/filter/core/FilterParameterBuidler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */