package logo.quiz.commons;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

public class ProgressBarOutline
  extends View
{
  private Paint paint = new Paint();
  
  public ProgressBarOutline(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.paint.setColor(-16777216);
    this.paint.setStrokeWidth(2.0F);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setARGB(35, 0, 0, 0);
    paramCanvas.drawRoundRect(new RectF(1.0F, 1.0F, getWidth() - 1, getHeight() - 1), getHeight() / 2, getHeight() / 2, this.paint);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/ProgressBarOutline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */