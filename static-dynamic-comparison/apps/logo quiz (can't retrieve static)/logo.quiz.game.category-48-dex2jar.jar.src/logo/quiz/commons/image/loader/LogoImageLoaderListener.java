package logo.quiz.commons.image.loader;

public abstract interface LogoImageLoaderListener
{
  public abstract void onLogoImageLoadingComplete();
  
  public abstract void onLogoImageLoadingFailed();
  
  public abstract void onLogoImageLoadingStarted();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/logo/quiz/commons/image/loader/LogoImageLoaderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */