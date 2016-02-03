package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl
  extends FragmentManager
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  ArrayList<Fragment> mActive;
  FragmentActivity mActivity;
  ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<Integer> mAvailIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new Runnable()
  {
    public void run()
    {
      FragmentManagerImpl.this.execPendingActions();
    }
  };
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<Runnable> mPendingActions;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    HONEYCOMB = bool;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void checkStateLoss()
  {
    if (this.mStateSaved) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return paramContext;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return paramContext;
  }
  
  public static int reverseTransit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (this.mActivity != null) {}
    for (;;)
    {
      try
      {
        this.mActivity.dump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 8194: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    }
    if (paramBoolean) {
      return 5;
    }
    return 6;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mAdded == null) {
      this.mAdded = new ArrayList();
    }
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
    {
      if (this.mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + paramBackStackRecord);
        }
        this.mBackStackIndices.add(paramBackStackRecord);
        return i;
      }
      int i = ((Integer)this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + i + " with " + paramBackStackRecord);
      }
      this.mBackStackIndices.set(i, paramBackStackRecord);
      return i;
    }
    finally {}
  }
  
  public void attachActivity(FragmentActivity paramFragmentActivity, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (this.mActivity != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mActivity = paramFragmentActivity;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
  }
  
  public void attachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded == null) {
          this.mAdded = new ArrayList();
        }
        if (this.mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment, this.mCurState, paramInt1, paramInt2, false);
      }
    }
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public void detachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (this.mAdded != null)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        moveToState(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    moveToState(2, false);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mAdded.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mAdded.size()) {
        return false;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
      i += 1;
    }
  }
  
  public void dispatchCreate()
  {
    this.mStateSaved = false;
    moveToState(1, false);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject1 = null;
    Object localObject2 = null;
    int i;
    if (this.mAdded != null)
    {
      i = 0;
      bool1 = bool2;
      localObject1 = localObject2;
      if (i < this.mAdded.size()) {}
    }
    else if (this.mCreatedMenus != null)
    {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mCreatedMenus.size())
      {
        this.mCreatedMenus = ((ArrayList)localObject1);
        return bool1;
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
        i += 1;
        localObject1 = localObject2;
        bool1 = bool2;
        break;
      }
      paramMenu = (Fragment)this.mCreatedMenus.get(i);
      if ((localObject1 == null) || (!((ArrayList)localObject1).contains(paramMenu))) {
        paramMenu.onDestroyOptionsMenu();
      }
      i += 1;
    }
  }
  
  public void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    moveToState(0, false);
    this.mActivity = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView()
  {
    moveToState(1, false);
  }
  
  public void dispatchLowMemory()
  {
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mAdded.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
      i += 1;
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mAdded.size()) {
        return false;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
      i += 1;
    }
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mAdded.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
      i += 1;
    }
  }
  
  public void dispatchPause()
  {
    moveToState(4, false);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i;
    if (this.mAdded != null) {
      i = 0;
    }
    for (bool1 = bool2;; bool1 = bool2)
    {
      if (i >= this.mAdded.size()) {
        return bool1;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.performPrepareOptionsMenu(paramMenu)) {
          bool2 = true;
        }
      }
      i += 1;
    }
  }
  
  public void dispatchReallyStop()
  {
    moveToState(2, false);
  }
  
  public void dispatchResume()
  {
    this.mStateSaved = false;
    moveToState(5, false);
  }
  
  public void dispatchStart()
  {
    this.mStateSaved = false;
    moveToState(4, false);
  }
  
  public void dispatchStop()
  {
    this.mStateSaved = true;
    moveToState(3, false);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString + "    ";
    int j;
    int i;
    if (this.mActive != null)
    {
      j = this.mActive.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        if (i < j) {
          break label568;
        }
      }
    }
    if (this.mAdded != null)
    {
      j = this.mAdded.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i = 0;
        label119:
        if (i < j) {
          break label638;
        }
      }
    }
    if (this.mCreatedMenus != null)
    {
      j = this.mCreatedMenus.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        label162:
        if (i < j) {
          break label695;
        }
      }
    }
    if (this.mBackStack != null)
    {
      j = this.mBackStack.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        label205:
        if (i < j) {
          break label752;
        }
      }
    }
    for (;;)
    {
      label568:
      label638:
      label695:
      label752:
      try
      {
        if (this.mBackStackIndices != null)
        {
          j = this.mBackStackIndices.size();
          if (j > 0)
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("Back Stack Indices:");
            i = 0;
            break label929;
          }
        }
        if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("mAvailBackStackIndices: ");
          paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
        }
        if (this.mPendingActions != null)
        {
          j = this.mPendingActions.size();
          if (j > 0)
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("Pending Actions:");
            i = 0;
            if (i < j) {
              break label877;
            }
          }
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("FragmentManager misc state:");
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mActivity=");
        paramPrintWriter.println(this.mActivity);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mContainer=");
        paramPrintWriter.println(this.mContainer);
        if (this.mParent != null)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  mParent=");
          paramPrintWriter.println(this.mParent);
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mCurState=");
        paramPrintWriter.print(this.mCurState);
        paramPrintWriter.print(" mStateSaved=");
        paramPrintWriter.print(this.mStateSaved);
        paramPrintWriter.print(" mDestroyed=");
        paramPrintWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  mNeedMenuInvalidate=");
          paramPrintWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  mNoTransactionsBecause=");
          paramPrintWriter.println(this.mNoTransactionsBecause);
        }
        if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0))
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  mAvailIndices: ");
          paramPrintWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
        }
        return;
      }
      finally {}
      Object localObject = (Fragment)this.mActive.get(i);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(i);
      paramPrintWriter.print(": ");
      paramPrintWriter.println(localObject);
      if (localObject != null) {
        ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      i += 1;
      break;
      localObject = (Fragment)this.mAdded.get(i);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(i);
      paramPrintWriter.print(": ");
      paramPrintWriter.println(((Fragment)localObject).toString());
      i += 1;
      break label119;
      localObject = (Fragment)this.mCreatedMenus.get(i);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(i);
      paramPrintWriter.print(": ");
      paramPrintWriter.println(((Fragment)localObject).toString());
      i += 1;
      break label162;
      localObject = (BackStackRecord)this.mBackStack.get(i);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(i);
      paramPrintWriter.print(": ");
      paramPrintWriter.println(((BackStackRecord)localObject).toString());
      ((BackStackRecord)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
      break label205;
      paramFileDescriptor = (BackStackRecord)this.mBackStackIndices.get(i);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(i);
      paramPrintWriter.print(": ");
      paramPrintWriter.println(paramFileDescriptor);
      i += 1;
      break label929;
      label877:
      paramFileDescriptor = (Runnable)this.mPendingActions.get(i);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  #");
      paramPrintWriter.print(i);
      paramPrintWriter.print(": ");
      paramPrintWriter.println(paramFileDescriptor);
      i += 1;
      continue;
      label929:
      if (i < j) {}
    }
  }
  
  public void enqueueAction(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((this.mDestroyed) || (this.mActivity == null)) {
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally
    {
      throw paramRunnable;
      if (this.mPendingActions == null) {
        this.mPendingActions = new ArrayList();
      }
      this.mPendingActions.add(paramRunnable);
      if (this.mPendingActions.size() == 1) {
        this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
      }
    }
  }
  
  public boolean execPendingActions()
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    boolean bool = false;
    for (;;)
    {
      int i;
      try
      {
        if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0))
        {
          if (this.mHavePendingDeferredStart)
          {
            j = 0;
            i = 0;
            if (i < this.mActive.size()) {
              break label229;
            }
            if (j == 0)
            {
              this.mHavePendingDeferredStart = false;
              startPendingDeferredFragments();
            }
          }
          return bool;
        }
        j = this.mPendingActions.size();
        if ((this.mTmpActions == null) || (this.mTmpActions.length < j)) {
          this.mTmpActions = new Runnable[j];
        }
        this.mPendingActions.toArray(this.mTmpActions);
        this.mPendingActions.clear();
        this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
        this.mExecutingActions = true;
        i = 0;
        if (i >= j)
        {
          this.mExecutingActions = false;
          bool = true;
          break;
        }
      }
      finally {}
      this.mTmpActions[i].run();
      this.mTmpActions[i] = null;
      i += 1;
      continue;
      label229:
      Fragment localFragment = (Fragment)this.mActive.get(i);
      int k = j;
      int m;
      if (localFragment != null)
      {
        k = j;
        if (localFragment.mLoaderManager != null) {
          m = j | localFragment.mLoaderManager.hasRunningLoaders();
        }
      }
      i += 1;
      int j = m;
    }
  }
  
  public boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    int i;
    if (this.mAdded != null)
    {
      i = this.mAdded.size() - 1;
      if (i >= 0) {}
    }
    else if (this.mActive != null)
    {
      i = this.mActive.size() - 1;
    }
    for (;;)
    {
      Object localObject;
      if (i < 0) {
        localObject = null;
      }
      Fragment localFragment;
      do
      {
        do
        {
          return (Fragment)localObject;
          localFragment = (Fragment)this.mAdded.get(i);
          if (localFragment == null) {
            break;
          }
          localObject = localFragment;
        } while (localFragment.mFragmentId == paramInt);
        i -= 1;
        break;
        localFragment = (Fragment)this.mActive.get(i);
        if (localFragment == null) {
          break label113;
        }
        localObject = localFragment;
      } while (localFragment.mFragmentId == paramInt);
      label113:
      i -= 1;
    }
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    int i;
    if ((this.mAdded != null) && (paramString != null))
    {
      i = this.mAdded.size() - 1;
      if (i >= 0) {}
    }
    else if ((this.mActive != null) && (paramString != null))
    {
      i = this.mActive.size() - 1;
    }
    for (;;)
    {
      Object localObject;
      if (i < 0) {
        localObject = null;
      }
      Fragment localFragment;
      do
      {
        do
        {
          return (Fragment)localObject;
          localFragment = (Fragment)this.mAdded.get(i);
          if (localFragment == null) {
            break;
          }
          localObject = localFragment;
        } while (paramString.equals(localFragment.mTag));
        i -= 1;
        break;
        localFragment = (Fragment)this.mActive.get(i);
        if (localFragment == null) {
          break label127;
        }
        localObject = localFragment;
      } while (paramString.equals(localFragment.mTag));
      label127:
      i -= 1;
    }
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    int i;
    if ((this.mActive != null) && (paramString != null)) {
      i = this.mActive.size() - 1;
    }
    for (;;)
    {
      Object localObject;
      if (i < 0) {
        localObject = null;
      }
      Fragment localFragment;
      do
      {
        return (Fragment)localObject;
        localObject = (Fragment)this.mActive.get(i);
        if (localObject == null) {
          break;
        }
        localFragment = ((Fragment)localObject).findFragmentByWho(paramString);
        localObject = localFragment;
      } while (localFragment != null);
      i -= 1;
    }
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      if (DEBUG) {
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {
      return this.mBackStack.size();
    }
    return 0;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i >= this.mActive.size()) {
        throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)this.mActive.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public List<Fragment> getFragments()
  {
    return this.mActive;
  }
  
  public void hideFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.mNextAnim);
    if (localAnimation != null) {
      return localAnimation;
    }
    if (paramFragment.mNextAnim != 0)
    {
      paramFragment = AnimationUtils.loadAnimation(this.mActivity, paramFragment.mNextAnim);
      if (paramFragment != null) {
        return paramFragment;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.mActivity.getWindow() != null) {
          paramInt1 = this.mActivity.getWindow().getAttributes().windowAnimations;
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
    case 6: 
      return makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
    }
    return null;
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    for (;;)
    {
      return;
      if ((this.mAvailIndices == null) || (this.mAvailIndices.size() <= 0))
      {
        if (this.mActive == null) {
          this.mActive = new ArrayList();
        }
        paramFragment.setIndex(this.mActive.size(), this.mParent);
        this.mActive.add(paramFragment);
      }
      while (DEBUG)
      {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        return;
        paramFragment.setIndex(((Integer)this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
        this.mActive.set(paramFragment.mIndex, paramFragment);
      }
    }
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      return;
    }
    if (DEBUG) {
      Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
    }
    this.mActive.set(paramFragment.mIndex, null);
    if (this.mAvailIndices == null) {
      this.mAvailIndices = new ArrayList();
    }
    this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
    this.mActivity.invalidateSupportFragment(paramFragment.mWho);
    paramFragment.initState();
  }
  
  void moveToState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.mActivity == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (this.mCurState == paramInt1)) {}
    do
    {
      return;
      this.mCurState = paramInt1;
    } while (this.mActive == null);
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      if (i >= this.mActive.size())
      {
        if (!bool1) {
          startPendingDeferredFragments();
        }
        if ((!this.mNeedMenuInvalidate) || (this.mActivity == null) || (this.mCurState != 5)) {
          break;
        }
        this.mActivity.supportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
        return;
      }
      Fragment localFragment = (Fragment)this.mActive.get(i);
      boolean bool2 = bool1;
      if (localFragment != null)
      {
        moveToState(localFragment, paramInt1, paramInt2, paramInt3, false);
        bool2 = bool1;
        if (localFragment.mLoaderManager != null) {
          bool2 = bool1 | localFragment.mLoaderManager.hasRunningLoaders();
        }
      }
      i += 1;
      bool1 = bool2;
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    moveToState(paramInt, 0, 0, paramBoolean);
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    if (paramFragment.mAdded)
    {
      i = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    int j = i;
    if (paramFragment.mRemoving)
    {
      j = i;
      if (i > paramFragment.mState) {
        j = paramFragment.mState;
      }
    }
    paramInt1 = j;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = j;
      if (paramFragment.mState < 4)
      {
        paramInt1 = j;
        if (j > 3) {
          paramInt1 = 3;
        }
      }
    }
    int k;
    if (paramFragment.mState < paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {
        return;
      }
      if (paramFragment.mAnimatingAway != null)
      {
        paramFragment.mAnimatingAway = null;
        moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, true);
      }
      i = paramInt1;
      k = paramInt1;
      j = paramInt1;
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
      }
    }
    for (;;)
    {
      paramFragment.mState = i;
      return;
      if (DEBUG) {
        Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
      }
      j = paramInt1;
      if (paramFragment.mSavedFragmentState != null)
      {
        paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
        if (paramFragment.mTarget != null) {
          paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        j = paramInt1;
        if (!paramFragment.mUserVisibleHint)
        {
          paramFragment.mDeferStart = true;
          j = paramInt1;
          if (paramInt1 > 3) {
            j = 3;
          }
        }
      }
      paramFragment.mActivity = this.mActivity;
      paramFragment.mParentFragment = this.mParent;
      if (this.mParent != null) {}
      for (Object localObject1 = this.mParent.mChildFragmentManager;; localObject1 = this.mActivity.mFragments)
      {
        paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject1);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mActivity);
        if (paramFragment.mCalled) {
          break;
        }
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      if (paramFragment.mParentFragment == null) {
        this.mActivity.onAttachFragment(paramFragment);
      }
      if (!paramFragment.mRetaining) {
        paramFragment.performCreate(paramFragment.mSavedFragmentState);
      }
      paramFragment.mRetaining = false;
      i = j;
      label536:
      Object localObject2;
      if (paramFragment.mFromLayout)
      {
        paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null)
        {
          paramFragment.mInnerView = paramFragment.mView;
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          i = j;
        }
      }
      else
      {
        k = i;
        if (i > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            localObject1 = null;
            if (paramFragment.mContainerId != 0)
            {
              localObject2 = (ViewGroup)this.mContainer.findViewById(paramFragment.mContainerId);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = localObject2;
                if (!paramFragment.mRestored)
                {
                  throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + paramFragment.getResources().getResourceName(paramFragment.mContainerId) + ") for fragment " + paramFragment));
                  localObject1 = localObject2;
                }
              }
            }
            paramFragment.mContainer = ((ViewGroup)localObject1);
            paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
            if (paramFragment.mView == null) {
              break label964;
            }
            paramFragment.mInnerView = paramFragment.mView;
            if (localObject1 != null)
            {
              localObject2 = loadAnimation(paramFragment, paramInt2, true, paramInt3);
              if (localObject2 != null) {
                paramFragment.mView.startAnimation((Animation)localObject2);
              }
              ((ViewGroup)localObject1).addView(paramFragment.mView);
            }
            if (paramFragment.mHidden) {
              paramFragment.mView.setVisibility(8);
            }
            paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          }
        }
      }
      for (;;)
      {
        paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null) {
          paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
        }
        paramFragment.mSavedFragmentState = null;
        k = i;
        j = k;
        if (k > 3)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          }
          paramFragment.performStart();
          j = k;
        }
        i = j;
        if (j <= 4) {
          break;
        }
        if (DEBUG) {
          Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
        }
        paramFragment.mResumed = true;
        paramFragment.performResume();
        paramFragment.mSavedFragmentState = null;
        paramFragment.mSavedViewState = null;
        i = j;
        break;
        paramFragment.mInnerView = null;
        i = j;
        break label536;
        label964:
        paramFragment.mInnerView = null;
      }
      i = paramInt1;
      if (paramFragment.mState > paramInt1) {
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
          break;
        case 1: 
        case 5: 
        case 4: 
        case 3: 
        case 2: 
          for (;;)
          {
            i = paramInt1;
            if (paramInt1 >= 1) {
              break;
            }
            if ((this.mDestroyed) && (paramFragment.mAnimatingAway != null))
            {
              localObject1 = paramFragment.mAnimatingAway;
              paramFragment.mAnimatingAway = null;
              ((View)localObject1).clearAnimation();
            }
            if (paramFragment.mAnimatingAway == null) {
              break label1388;
            }
            paramFragment.mStateAfterAnimating = paramInt1;
            i = 1;
            break;
            if (paramInt1 < 5)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
              }
              paramFragment.performPause();
              paramFragment.mResumed = false;
            }
            if (paramInt1 < 4)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
              }
              paramFragment.performStop();
            }
            if (paramInt1 < 3)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
              }
              paramFragment.performReallyStop();
            }
            if (paramInt1 < 2)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
              }
              if ((paramFragment.mView != null) && (!this.mActivity.isFinishing()) && (paramFragment.mSavedViewState == null)) {
                saveFragmentViewState(paramFragment);
              }
              paramFragment.performDestroyView();
              if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
              {
                localObject2 = null;
                localObject1 = localObject2;
                if (this.mCurState > 0)
                {
                  localObject1 = localObject2;
                  if (!this.mDestroyed) {
                    localObject1 = loadAnimation(paramFragment, paramInt2, false, paramInt3);
                  }
                }
                if (localObject1 != null)
                {
                  paramFragment.mAnimatingAway = paramFragment.mView;
                  paramFragment.mStateAfterAnimating = paramInt1;
                  ((Animation)localObject1).setAnimationListener(new Animation.AnimationListener()
                  {
                    public void onAnimationEnd(Animation paramAnonymousAnimation)
                    {
                      if (paramFragment.mAnimatingAway != null)
                      {
                        paramFragment.mAnimatingAway = null;
                        FragmentManagerImpl.this.moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, false);
                      }
                    }
                    
                    public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
                    
                    public void onAnimationStart(Animation paramAnonymousAnimation) {}
                  });
                  paramFragment.mView.startAnimation((Animation)localObject1);
                }
                paramFragment.mContainer.removeView(paramFragment.mView);
              }
              paramFragment.mContainer = null;
              paramFragment.mView = null;
              paramFragment.mInnerView = null;
            }
          }
          label1388:
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!paramFragment.mRetaining) {
            paramFragment.performDestroy();
          }
          paramFragment.mCalled = false;
          paramFragment.onDetach();
          if (!paramFragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          i = paramInt1;
          if (!paramBoolean) {
            if (!paramFragment.mRetaining)
            {
              makeInactive(paramFragment);
              i = paramInt1;
            }
            else
            {
              paramFragment.mActivity = null;
              paramFragment.mFragmentManager = null;
              i = paramInt1;
            }
          }
          break;
        }
      }
    }
  }
  
  public void noteStateNotSaved()
  {
    this.mStateSaved = false;
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  public void popBackStack()
  {
    enqueueAction(new Runnable()
    {
      public void run()
      {
        FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, null, -1, 0);
      }
    }, false);
  }
  
  public void popBackStack(final int paramInt1, final int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new Runnable()
    {
      public void run()
      {
        FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, null, paramInt1, paramInt2);
      }
    }, false);
  }
  
  public void popBackStack(final String paramString, final int paramInt)
  {
    enqueueAction(new Runnable()
    {
      public void run()
      {
        FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, paramString, -1, paramInt);
      }
    }, false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    executePendingTransactions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackState(this.mActivity.mHandler, null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, paramString, -1, paramInt);
  }
  
  boolean popBackStackState(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    if (this.mBackStack == null) {
      break label117;
    }
    label57:
    int i;
    int j;
    label81:
    label108:
    label117:
    while (i == this.mBackStack.size() - 1)
    {
      do
      {
        do
        {
          return false;
          if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
            break;
          }
          paramInt1 = this.mBackStack.size() - 1;
        } while (paramInt1 < 0);
        ((BackStackRecord)this.mBackStack.remove(paramInt1)).popFromBackStack(true);
        reportBackStackChanged();
        return true;
        i = -1;
        if ((paramString == null) && (paramInt1 < 0)) {
          break;
        }
        j = this.mBackStack.size() - 1;
        if (j >= 0) {
          break label178;
        }
      } while (j < 0);
      i = j;
      if ((paramInt2 & 0x1) != 0)
      {
        paramInt2 = j - 1;
        if (paramInt2 >= 0) {
          break label227;
        }
        i = paramInt2;
      }
    }
    paramHandler = new ArrayList();
    paramInt1 = this.mBackStack.size() - 1;
    for (;;)
    {
      if (paramInt1 <= i)
      {
        paramInt2 = paramHandler.size() - 1;
        paramInt1 = 0;
        if (paramInt1 <= paramInt2) {
          break label307;
        }
        reportBackStackChanged();
        break label57;
        label178:
        paramHandler = (BackStackRecord)this.mBackStack.get(j);
        if (((paramString != null) && (paramString.equals(paramHandler.getName()))) || ((paramInt1 >= 0) && (paramInt1 == paramHandler.mIndex))) {
          break;
        }
        j -= 1;
        break label81;
        label227:
        paramHandler = (BackStackRecord)this.mBackStack.get(paramInt2);
        if ((paramString == null) || (!paramString.equals(paramHandler.getName())))
        {
          i = paramInt2;
          if (paramInt1 < 0) {
            break;
          }
          i = paramInt2;
          if (paramInt1 != paramHandler.mIndex) {
            break;
          }
        }
        paramInt2 -= 1;
        break label108;
      }
      paramHandler.add((BackStackRecord)this.mBackStack.remove(paramInt1));
      paramInt1 -= 1;
    }
    label307:
    if (DEBUG) {
      Log.v("FragmentManager", "Popping back stack state: " + paramHandler.get(paramInt1));
    }
    paramString = (BackStackRecord)paramHandler.get(paramInt1);
    if (paramInt1 == paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.popFromBackStack(bool);
      paramInt1 += 1;
      break;
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void removeFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting);
    }
    if (paramFragment.isInBackStack())
    {
      i = 0;
      if ((!paramFragment.mDetached) || (i != 0))
      {
        if (this.mAdded != null) {
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        if (i == 0) {
          break label134;
        }
      }
    }
    label134:
    for (int i = 0;; i = 1)
    {
      moveToState(paramFragment, i, paramInt1, paramInt2, false);
      return;
      i = 1;
      break;
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void reportBackStackChanged()
  {
    int i;
    if (this.mBackStackChangeListeners != null) {
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mBackStackChangeListeners.size()) {
        return;
      }
      ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
      i += 1;
    }
  }
  
  void restoreAllState(Parcelable paramParcelable, ArrayList<Fragment> paramArrayList)
  {
    if (paramParcelable == null) {}
    do
    {
      return;
      paramParcelable = (FragmentManagerState)paramParcelable;
    } while (paramParcelable.mActive == null);
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      label23:
      if (i < paramArrayList.size()) {}
    }
    else
    {
      this.mActive = new ArrayList(paramParcelable.mActive.length);
      if (this.mAvailIndices != null) {
        this.mAvailIndices.clear();
      }
      i = 0;
      if (i < paramParcelable.mActive.length) {
        break label406;
      }
      if (paramArrayList != null)
      {
        i = 0;
        if (i < paramArrayList.size()) {
          break label568;
        }
      }
      if (paramParcelable.mAdded == null) {
        break label811;
      }
      this.mAdded = new ArrayList(paramParcelable.mAdded.length);
      i = 0;
      label111:
      if (i < paramParcelable.mAdded.length) {
        break label675;
      }
    }
    for (;;)
    {
      if (paramParcelable.mBackStack == null) {
        break label819;
      }
      this.mBackStack = new ArrayList(paramParcelable.mBackStack.length);
      i = 0;
      while (i < paramParcelable.mBackStack.length)
      {
        paramArrayList = paramParcelable.mBackStack[i].instantiate(this);
        if (DEBUG)
        {
          Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + paramArrayList.mIndex + "): " + paramArrayList);
          paramArrayList.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
        }
        this.mBackStack.add(paramArrayList);
        if (paramArrayList.mIndex >= 0) {
          setBackStackIndex(paramArrayList.mIndex, paramArrayList);
        }
        i += 1;
      }
      break;
      Object localObject1 = (Fragment)paramArrayList.get(i);
      if (DEBUG) {
        Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject1);
      }
      Object localObject2 = paramParcelable.mActive[localObject1.mIndex];
      ((FragmentState)localObject2).mInstance = ((Fragment)localObject1);
      ((Fragment)localObject1).mSavedViewState = null;
      ((Fragment)localObject1).mBackStackNesting = 0;
      ((Fragment)localObject1).mInLayout = false;
      ((Fragment)localObject1).mAdded = false;
      ((Fragment)localObject1).mTarget = null;
      if (((FragmentState)localObject2).mSavedFragmentState != null)
      {
        ((FragmentState)localObject2).mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
        ((Fragment)localObject1).mSavedViewState = ((FragmentState)localObject2).mSavedFragmentState.getSparseParcelableArray("android:view_state");
      }
      i += 1;
      break label23;
      label406:
      localObject1 = paramParcelable.mActive[i];
      if (localObject1 != null)
      {
        localObject2 = ((FragmentState)localObject1).instantiate(this.mActivity, this.mParent);
        if (DEBUG) {
          Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject2);
        }
        this.mActive.add(localObject2);
        ((FragmentState)localObject1).mInstance = null;
      }
      for (;;)
      {
        i += 1;
        break;
        this.mActive.add(null);
        if (this.mAvailIndices == null) {
          this.mAvailIndices = new ArrayList();
        }
        if (DEBUG) {
          Log.v("FragmentManager", "restoreAllState: avail #" + i);
        }
        this.mAvailIndices.add(Integer.valueOf(i));
      }
      label568:
      localObject1 = (Fragment)paramArrayList.get(i);
      if (((Fragment)localObject1).mTargetIndex >= 0) {
        if (((Fragment)localObject1).mTargetIndex >= this.mActive.size()) {
          break label628;
        }
      }
      for (((Fragment)localObject1).mTarget = ((Fragment)this.mActive.get(((Fragment)localObject1).mTargetIndex));; ((Fragment)localObject1).mTarget = null)
      {
        i += 1;
        break;
        label628:
        Log.w("FragmentManager", "Re-attaching retained fragment " + localObject1 + " target no longer exists: " + ((Fragment)localObject1).mTargetIndex);
      }
      label675:
      paramArrayList = (Fragment)this.mActive.get(paramParcelable.mAdded[i]);
      if (paramArrayList == null) {
        throwException(new IllegalStateException("No instantiated fragment for index #" + paramParcelable.mAdded[i]));
      }
      paramArrayList.mAdded = true;
      if (DEBUG) {
        Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramArrayList);
      }
      if (this.mAdded.contains(paramArrayList)) {
        throw new IllegalStateException("Already added!");
      }
      this.mAdded.add(paramArrayList);
      i += 1;
      break label111;
      label811:
      this.mAdded = null;
    }
    label819:
    this.mBackStack = null;
  }
  
  ArrayList<Fragment> retainNonConfig()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i;
    if (this.mActive != null)
    {
      i = 0;
      localObject1 = localObject2;
      if (i < this.mActive.size()) {}
    }
    else
    {
      return (ArrayList<Fragment>)localObject1;
    }
    Fragment localFragment = (Fragment)this.mActive.get(i);
    Object localObject3 = localObject1;
    if (localFragment != null)
    {
      localObject3 = localObject1;
      if (localFragment.mRetainInstance)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        localFragment.mRetaining = true;
        if (localFragment.mTarget == null) {
          break label163;
        }
      }
    }
    label163:
    for (int j = localFragment.mTarget.mIndex;; j = -1)
    {
      localFragment.mTargetIndex = j;
      localObject3 = localObject2;
      if (DEBUG)
      {
        Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
        localObject3 = localObject2;
      }
      i += 1;
      localObject1 = localObject3;
      break;
    }
  }
  
  Parcelable saveAllState()
  {
    execPendingActions();
    if (HONEYCOMB) {
      this.mStateSaved = true;
    }
    if ((this.mActive == null) || (this.mActive.size() <= 0)) {}
    FragmentState[] arrayOfFragmentState;
    int j;
    int i;
    do
    {
      return null;
      int m = this.mActive.size();
      arrayOfFragmentState = new FragmentState[m];
      j = 0;
      i = 0;
      if (i < m) {
        break;
      }
      if (j != 0) {
        break label386;
      }
    } while (!DEBUG);
    Log.v("FragmentManager", "saveAllState: no fragments!");
    return null;
    Object localObject1 = (Fragment)this.mActive.get(i);
    int k;
    if (localObject1 != null)
    {
      if (((Fragment)localObject1).mIndex < 0) {
        throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      k = 1;
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[i] = localObject2;
      if ((((Fragment)localObject1).mState <= 0) || (((FragmentState)localObject2).mSavedFragmentState != null)) {
        break label373;
      }
      ((FragmentState)localObject2).mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
      if (((Fragment)localObject1).mTarget != null)
      {
        if (((Fragment)localObject1).mTarget.mIndex < 0) {
          throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
        }
        if (((FragmentState)localObject2).mSavedFragmentState == null) {
          ((FragmentState)localObject2).mSavedFragmentState = new Bundle();
        }
        putFragment(((FragmentState)localObject2).mSavedFragmentState, "android:target_state", ((Fragment)localObject1).mTarget);
        if (((Fragment)localObject1).mTargetRequestCode != 0) {
          ((FragmentState)localObject2).mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
        }
      }
    }
    for (;;)
    {
      j = k;
      if (DEBUG)
      {
        Log.v("FragmentManager", "Saved state of " + localObject1 + ": " + ((FragmentState)localObject2).mSavedFragmentState);
        j = k;
      }
      i += 1;
      break;
      label373:
      ((FragmentState)localObject2).mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
    }
    label386:
    Object localObject2 = (int[])null;
    Object localObject3 = (BackStackState[])null;
    localObject1 = localObject2;
    if (this.mAdded != null)
    {
      j = this.mAdded.size();
      localObject1 = localObject2;
      if (j > 0)
      {
        localObject1 = new int[j];
        i = 0;
        if (i < j) {
          break label510;
        }
      }
    }
    localObject2 = localObject3;
    if (this.mBackStack != null)
    {
      j = this.mBackStack.size();
      localObject2 = localObject3;
      if (j > 0)
      {
        localObject2 = new BackStackState[j];
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        localObject3 = new FragmentManagerState();
        ((FragmentManagerState)localObject3).mActive = arrayOfFragmentState;
        ((FragmentManagerState)localObject3).mAdded = ((int[])localObject1);
        ((FragmentManagerState)localObject3).mBackStack = ((BackStackState[])localObject2);
        return (Parcelable)localObject3;
        label510:
        localObject1[i] = ((Fragment)this.mAdded.get(i)).mIndex;
        if (localObject1[i] < 0) {
          throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i) + " has cleared index: " + localObject1[i]));
        }
        if (DEBUG) {
          Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.mAdded.get(i));
        }
        i += 1;
        break;
      }
      localObject2[i] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(i));
      if (DEBUG) {
        Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i));
      }
      i += 1;
    }
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    if (!this.mStateBundle.isEmpty())
    {
      localObject2 = this.mStateBundle;
      this.mStateBundle = null;
    }
    if (paramFragment.mView != null) {
      saveFragmentViewState(paramFragment);
    }
    Object localObject1 = localObject2;
    if (paramFragment.mSavedViewState != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
    }
    localObject2 = localObject1;
    if (!paramFragment.mUserVisibleHint)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
    }
    return (Bundle)localObject2;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return (Fragment.SavedState)localObject1;
  }
  
  void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
      return;
      this.mStateArray.clear();
    }
  }
  
  /* Error */
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 313	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 249	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 250	java/util/ArrayList:<init>	()V
    //   17: putfield 313	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 313	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 311	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +127 -> 162
    //   38: getstatic 95	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   41: ifeq +36 -> 77
    //   44: ldc 42
    //   46: new 149	java/lang/StringBuilder
    //   49: dup
    //   50: ldc_w 315
    //   53: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: iload_1
    //   57: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 320
    //   63: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_2
    //   67: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 269	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_0
    //   78: getfield 313	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   81: iload_1
    //   82: aload_2
    //   83: invokevirtual 337	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: aload_0
    //   91: getfield 313	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   94: aconst_null
    //   95: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   98: pop
    //   99: aload_0
    //   100: getfield 307	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   103: ifnonnull +14 -> 117
    //   106: aload_0
    //   107: new 249	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 250	java/util/ArrayList:<init>	()V
    //   114: putfield 307	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   117: getstatic 95	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   120: ifeq +26 -> 146
    //   123: ldc 42
    //   125: new 149	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1130
    //   132: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: iload_3
    //   136: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 269	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aload_0
    //   147: getfield 307	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   150: iload_3
    //   151: invokestatic 601	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: iload_3
    //   159: iconst_1
    //   160: iadd
    //   161: istore_3
    //   162: iload_3
    //   163: iload_1
    //   164: if_icmplt -74 -> 90
    //   167: getstatic 95	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   170: ifeq +36 -> 206
    //   173: ldc 42
    //   175: new 149	java/lang/StringBuilder
    //   178: dup
    //   179: ldc_w 331
    //   182: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: iload_1
    //   186: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc_w 333
    //   192: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 269	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   205: pop
    //   206: aload_0
    //   207: getfield 313	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   210: aload_2
    //   211: invokevirtual 254	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -128 -> 87
    //   218: astore_2
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_2
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	FragmentManagerImpl
    //   0	223	1	paramInt	int
    //   0	223	2	paramBackStackRecord	BackStackRecord
    //   31	134	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	218	finally
    //   20	29	218	finally
    //   38	77	218	finally
    //   77	87	218	finally
    //   87	89	218	finally
    //   90	117	218	finally
    //   117	146	218	finally
    //   146	158	218	finally
    //   167	206	218	finally
    //   206	215	218	finally
    //   219	221	218	finally
  }
  
  public void showFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  void startPendingDeferredFragments()
  {
    if (this.mActive == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v4/app/FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */