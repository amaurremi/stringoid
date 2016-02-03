package logo.quiz.commons.utils.image;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class BitmapUtils
{
  public static Bitmap resizeBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
    throws OutOfMemoryError
  {
    return resizeBitmap(paramBitmap, paramInt1, paramInt2, 0);
  }
  
  public static Bitmap resizeBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
    throws OutOfMemoryError
  {
    int i = paramInt1;
    int j = paramInt2;
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      i = paramInt2;
      j = paramInt1;
    }
    paramInt1 = 0;
    float f;
    Object localObject;
    if ((k > i) || (m > j))
    {
      paramInt1 = 1;
      if ((k > m) && (k > i))
      {
        f = i / k;
        j = (int)(m * f);
        if (paramInt1 == 0)
        {
          localObject = paramBitmap;
          if (paramInt3 == 0) {}
        }
        else
        {
          if (paramInt3 != 0) {
            break label150;
          }
        }
      }
    }
    for (paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);; paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, k, m, (Matrix)localObject, true))
    {
      localObject = paramBitmap;
      return (Bitmap)localObject;
      f = j / m;
      i = (int)(k * f);
      break;
      i = k;
      j = m;
      break;
      label150:
      localObject = new Matrix();
      ((Matrix)localObject).postScale(i / k, j / m);
      ((Matrix)localObject).postRotate(paramInt3);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */