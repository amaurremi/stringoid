package android.support.v4.app;

import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class FragmentTransaction
{
  public static final int TRANSIT_ENTER_MASK = 4096;
  public static final int TRANSIT_EXIT_MASK = 8192;
  public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
  public static final int TRANSIT_FRAGMENT_FADE = 4099;
  public static final int TRANSIT_FRAGMENT_OPEN = 4097;
  public static final int TRANSIT_NONE = 0;
  public static final int TRANSIT_UNSET = -1;
  
  public abstract FragmentTransaction add(int paramInt, Fragment paramFragment);
  
  public abstract FragmentTransaction add(int paramInt, Fragment paramFragment, @Nullable String paramString);
  
  public abstract FragmentTransaction add(Fragment paramFragment, String paramString);
  
  public abstract FragmentTransaction addToBackStack(@Nullable String paramString);
  
  public abstract FragmentTransaction attach(Fragment paramFragment);
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract FragmentTransaction detach(Fragment paramFragment);
  
  public abstract FragmentTransaction disallowAddToBackStack();
  
  public abstract FragmentTransaction hide(Fragment paramFragment);
  
  public abstract boolean isAddToBackStackAllowed();
  
  public abstract boolean isEmpty();
  
  public abstract FragmentTransaction remove(Fragment paramFragment);
  
  public abstract FragmentTransaction replace(int paramInt, Fragment paramFragment);
  
  public abstract FragmentTransaction replace(int paramInt, Fragment paramFragment, @Nullable String paramString);
  
  public abstract FragmentTransaction setBreadCrumbShortTitle(int paramInt);
  
  public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence);
  
  public abstract FragmentTransaction setBreadCrumbTitle(int paramInt);
  
  public abstract FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence);
  
  public abstract FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2);
  
  public abstract FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract FragmentTransaction setTransition(int paramInt);
  
  public abstract FragmentTransaction setTransitionStyle(int paramInt);
  
  public abstract FragmentTransaction show(Fragment paramFragment);
  
  @Retention(RetentionPolicy.SOURCE)
  @IntDef({0L, 4097L, 8194L})
  private static @interface Transit {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/android/support/v4/app/FragmentTransaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */