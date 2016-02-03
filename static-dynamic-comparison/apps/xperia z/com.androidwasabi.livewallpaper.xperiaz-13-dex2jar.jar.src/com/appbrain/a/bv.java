package com.appbrain.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import cmn.aj;
import java.util.Random;

public final class bv
{
  public static final by[] a = { new by(-12303292, -15658735, -1118482, -12207149, -12736838, -1, -1, -10967038), new by(-1, -1118482, -13421773, -12207149, -12736838, -1, -1, -10967038), new by(-2565928, -2565928, -13421773, -10967038, -10967038, -1, -1, -10967038), new by(-13224394, -13224394, -1, -16738603, -16738603, 0, -1, -37373), new by(-16738603, -16738603, -1, -2796288, -2796288, -1, -1, -10967038), new by(-1, -1, -16777216, -10967038, -10967038, -1, -1, -37373), new by(-34304, -2135038, -1, -2031540, -2031540, -1, -1, 51712), new by(-5869824, -4223184, -1, 43520, 43520, -1, -1, 53363), new by(-5895168, -4244944, -1, -60672, -60672, -1, -1, -4105646), new by(-16744682, -14314952, -1, -15897058, -15897058, -1, -1, -13049514), new by(-15252318, -13876104, -1, -16308633, -16308633, -1, -1, -10057779), new by(-12384921, -10868616, -1, -9695070, -9695070, -1, -1, -6004531), new by(-1710619, -3618873, -12435134, -1, -1, -1, -12435134, -3223858), new by(-1, -1, -12435134, -856091, -856091, -4609383, -12435134, -1645868) };
  public static bx[] b = { new ca(), new cb(), new bw(), new bz() };
  private static final Random c = new Random();
  private static final int[] d = { 3 };
  
  public static ShapeDrawable a(int paramInt)
  {
    Object localObject = new Path();
    RectF localRectF = new RectF();
    ((Path)localObject).moveTo(0.0F, 24.0F);
    localRectF.set(22.0F, 2.0F, 66.0F, 46.0F);
    ((Path)localObject).arcTo(localRectF, 180.0F, 180.0F);
    ((Path)localObject).moveTo(88.0F, 24.0F);
    localRectF.set(78.0F, 78.0F, 88.0F, 88.0F);
    ((Path)localObject).arcTo(localRectF, 0.0F, 90.0F);
    localRectF.set(0.0F, 78.0F, 10.0F, 88.0F);
    ((Path)localObject).arcTo(localRectF, 90.0F, 90.0F);
    ((Path)localObject).lineTo(0.0F, 24.0F);
    ((Path)localObject).close();
    localRectF.set(30.0F, 10.0F, 58.0F, 38.0F);
    ((Path)localObject).arcTo(localRectF, 0.0F, -180.0F);
    ((Path)localObject).close();
    ((Path)localObject).moveTo(32.0F, 40.0F);
    ((Path)localObject).lineTo(32.0F, 73.0F);
    ((Path)localObject).lineTo(61.0F, 56.5F);
    ((Path)localObject).close();
    localObject = new ShapeDrawable(new PathShape((Path)localObject, 88.0F, 88.0F));
    ((ShapeDrawable)localObject).setIntrinsicHeight(aj.b(44.0F));
    ((ShapeDrawable)localObject).setIntrinsicWidth(aj.b(44.0F));
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
    return (ShapeDrawable)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */