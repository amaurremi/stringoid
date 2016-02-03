package com.jaysquared.games.whereishd.overlays;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.overlay.Overlay;

public class ScoreOverlay
  extends Overlay
{
  private final String distance;
  private float heightCorrection;
  private String name;
  private final IGeoPoint point;
  private Typeface typeface;
  private float widthCorrection;
  
  public ScoreOverlay(Context paramContext)
  {
    super(paramContext);
    this.point = null;
    this.name = "";
    this.distance = "";
    this.typeface = null;
  }
  
  public ScoreOverlay(ResourceProxy paramResourceProxy, IGeoPoint paramIGeoPoint, String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    super(paramResourceProxy);
    this.point = paramIGeoPoint;
    this.name = paramString1;
    if (this.name.length() > 10) {
      this.name = (this.name.substring(0, 10) + "...");
    }
    this.distance = paramString2;
    this.typeface = null;
    this.widthCorrection = paramFloat1;
    this.heightCorrection = paramFloat2;
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    Object localObject = paramMapView.getProjection();
    paramMapView = new Point();
    ((MapView.Projection)localObject).toPixels(this.point, paramMapView);
    localObject = new Paint();
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setColor(-16777216);
    ((Paint)localObject).setAlpha(70);
    paramMapView.x = ((int)(paramMapView.x - (75.0F - this.widthCorrection)));
    paramMapView.y = ((int)(paramMapView.y - (80.0F + this.heightCorrection)));
    paramCanvas.drawRoundRect(new RectF(paramMapView.x, paramMapView.y, paramMapView.x + 150.0F, paramMapView.y + 80.0F), 10.0F, 10.0F, (Paint)localObject);
    localObject = new Paint();
    if (this.typeface != null) {
      ((Paint)localObject).setTypeface(this.typeface);
    }
    ((Paint)localObject).setColor(-1);
    ((Paint)localObject).setTextSize(22.0F);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setFakeBoldText(true);
    ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(this.name, paramMapView.x + 75.0F, paramMapView.y + 30.0F, (Paint)localObject);
    paramCanvas.drawText(this.distance, paramMapView.x + 75.0F, paramMapView.y + 70.0F, (Paint)localObject);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.typeface = paramTypeface;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/overlays/ScoreOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */