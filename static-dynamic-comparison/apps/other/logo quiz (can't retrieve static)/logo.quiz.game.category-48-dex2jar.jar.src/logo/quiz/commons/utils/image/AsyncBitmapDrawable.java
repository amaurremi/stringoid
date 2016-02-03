package logo.quiz.commons.utils.image;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import java.lang.ref.WeakReference;

public class AsyncBitmapDrawable
  extends ColorDrawable
{
  private final WeakReference<BitmapDrawableWorkerTask> bitmapWorkerTaskReference;
  
  public AsyncBitmapDrawable(Resources paramResources, int paramInt, BitmapDrawableWorkerTask paramBitmapDrawableWorkerTask)
  {
    super(paramInt);
    this.bitmapWorkerTaskReference = new WeakReference(paramBitmapDrawableWorkerTask);
  }
  
  public BitmapDrawableWorkerTask getBitmapWorkerTask()
  {
    return (BitmapDrawableWorkerTask)this.bitmapWorkerTaskReference.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/utils/image/AsyncBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */