package com.google.android.b.a.a;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;

public class bf
  extends Activity
{
  private Activity a;
  
  public bf(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.addContentView(paramView, paramLayoutParams);
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return this.a.bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return this.a.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkCallingOrSelfUriPermission(Uri paramUri, int paramInt)
  {
    return this.a.checkCallingOrSelfUriPermission(paramUri, paramInt);
  }
  
  public int checkCallingPermission(String paramString)
  {
    return this.a.checkCallingPermission(paramString);
  }
  
  public int checkCallingUriPermission(Uri paramUri, int paramInt)
  {
    return this.a.checkCallingUriPermission(paramUri, paramInt);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    return this.a.checkPermission(paramString, paramInt1, paramInt2);
  }
  
  public int checkUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.a.checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
  }
  
  public int checkUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    return this.a.checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public void clearWallpaper()
  {
    this.a.clearWallpaper();
  }
  
  public void closeContextMenu()
  {
    this.a.closeContextMenu();
  }
  
  public void closeOptionsMenu()
  {
    this.a.closeOptionsMenu();
  }
  
  public Context createPackageContext(String paramString, int paramInt)
  {
    return this.a.createPackageContext(paramString, paramInt);
  }
  
  public PendingIntent createPendingResult(int paramInt1, Intent paramIntent, int paramInt2)
  {
    return this.a.createPendingResult(paramInt1, paramIntent, paramInt2);
  }
  
  public String[] databaseList()
  {
    return this.a.databaseList();
  }
  
  public boolean deleteDatabase(String paramString)
  {
    return this.a.deleteDatabase(paramString);
  }
  
  public boolean deleteFile(String paramString)
  {
    return this.a.deleteFile(paramString);
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.a.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.a.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.a.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public void enforceCallingOrSelfPermission(String paramString1, String paramString2)
  {
    this.a.enforceCallingOrSelfPermission(paramString1, paramString2);
  }
  
  public void enforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    this.a.enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforceCallingPermission(String paramString1, String paramString2)
  {
    this.a.enforceCallingPermission(paramString1, paramString2);
  }
  
  public void enforceCallingUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    this.a.enforceCallingUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void enforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.a.enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void enforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.a.enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public String[] fileList()
  {
    return this.a.fileList();
  }
  
  public View findViewById(int paramInt)
  {
    return this.a.findViewById(paramInt);
  }
  
  public void finish()
  {
    this.a.finish();
  }
  
  public void finishActivity(int paramInt)
  {
    this.a.finishActivity(paramInt);
  }
  
  public void finishActivityFromChild(Activity paramActivity, int paramInt)
  {
    this.a.finishActivityFromChild(paramActivity, paramInt);
  }
  
  public void finishAffinity()
  {
    this.a.finishAffinity();
  }
  
  public void finishFromChild(Activity paramActivity)
  {
    this.a.finishFromChild(paramActivity);
  }
  
  public ActionBar getActionBar()
  {
    return this.a.getActionBar();
  }
  
  public Context getApplicationContext()
  {
    return this.a.getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    return this.a.getApplicationInfo();
  }
  
  public AssetManager getAssets()
  {
    return this.a.getAssets();
  }
  
  public Context getBaseContext()
  {
    return this.a.getBaseContext();
  }
  
  public File getCacheDir()
  {
    return this.a.getCacheDir();
  }
  
  public ComponentName getCallingActivity()
  {
    return this.a.getCallingActivity();
  }
  
  public String getCallingPackage()
  {
    return this.a.getCallingPackage();
  }
  
  public int getChangingConfigurations()
  {
    return this.a.getChangingConfigurations();
  }
  
  public ClassLoader getClassLoader()
  {
    return this.a.getClassLoader();
  }
  
  public ComponentName getComponentName()
  {
    return this.a.getComponentName();
  }
  
  public ContentResolver getContentResolver()
  {
    return this.a.getContentResolver();
  }
  
  public View getCurrentFocus()
  {
    return this.a.getCurrentFocus();
  }
  
  public File getDatabasePath(String paramString)
  {
    return this.a.getDatabasePath(paramString);
  }
  
  public File getDir(String paramString, int paramInt)
  {
    return this.a.getDir(paramString, paramInt);
  }
  
  public File getExternalCacheDir()
  {
    return this.a.getExternalCacheDir();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    return this.a.getExternalFilesDir(paramString);
  }
  
  public File getFileStreamPath(String paramString)
  {
    return this.a.getFileStreamPath(paramString);
  }
  
  public File getFilesDir()
  {
    return this.a.getFilesDir();
  }
  
  public FragmentManager getFragmentManager()
  {
    return this.a.getFragmentManager();
  }
  
  public Intent getIntent()
  {
    return this.a.getIntent();
  }
  
  public Object getLastNonConfigurationInstance()
  {
    return this.a.getLastNonConfigurationInstance();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.a.getLayoutInflater();
  }
  
  public LoaderManager getLoaderManager()
  {
    return this.a.getLoaderManager();
  }
  
  public String getLocalClassName()
  {
    return this.a.getLocalClassName();
  }
  
  public Looper getMainLooper()
  {
    return this.a.getMainLooper();
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.a.getMenuInflater();
  }
  
  public File getObbDir()
  {
    return this.a.getObbDir();
  }
  
  public String getPackageCodePath()
  {
    return this.a.getPackageCodePath();
  }
  
  public PackageManager getPackageManager()
  {
    return this.a.getPackageManager();
  }
  
  public String getPackageName()
  {
    return this.a.getPackageName();
  }
  
  public String getPackageResourcePath()
  {
    return this.a.getPackageResourcePath();
  }
  
  public Intent getParentActivityIntent()
  {
    return this.a.getParentActivityIntent();
  }
  
  public SharedPreferences getPreferences(int paramInt)
  {
    return this.a.getPreferences(paramInt);
  }
  
  public int getRequestedOrientation()
  {
    return this.a.getRequestedOrientation();
  }
  
  public Resources getResources()
  {
    return this.a.getResources();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return this.a.getSharedPreferences(paramString, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    return this.a.getSystemService(paramString);
  }
  
  public int getTaskId()
  {
    return this.a.getTaskId();
  }
  
  public Resources.Theme getTheme()
  {
    return this.a.getTheme();
  }
  
  public Drawable getWallpaper()
  {
    return this.a.getWallpaper();
  }
  
  public int getWallpaperDesiredMinimumHeight()
  {
    return this.a.getWallpaperDesiredMinimumHeight();
  }
  
  public int getWallpaperDesiredMinimumWidth()
  {
    return this.a.getWallpaperDesiredMinimumWidth();
  }
  
  public Window getWindow()
  {
    return this.a.getWindow();
  }
  
  public WindowManager getWindowManager()
  {
    return this.a.getWindowManager();
  }
  
  public void grantUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    this.a.grantUriPermission(paramString, paramUri, paramInt);
  }
  
  public boolean hasWindowFocus()
  {
    return this.a.hasWindowFocus();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public void invalidateOptionsMenu()
  {
    this.a.invalidateOptionsMenu();
  }
  
  public boolean isChangingConfigurations()
  {
    return this.a.isChangingConfigurations();
  }
  
  public boolean isFinishing()
  {
    return this.a.isFinishing();
  }
  
  public boolean isRestricted()
  {
    return this.a.isRestricted();
  }
  
  public boolean isTaskRoot()
  {
    return this.a.isTaskRoot();
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    return this.a.moveTaskToBack(paramBoolean);
  }
  
  public boolean navigateUpTo(Intent paramIntent)
  {
    return this.a.navigateUpTo(paramIntent);
  }
  
  public boolean navigateUpToFromChild(Activity paramActivity, Intent paramIntent)
  {
    return this.a.navigateUpToFromChild(paramActivity, paramIntent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.a.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.a.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    this.a.onAttachFragment(paramFragment);
  }
  
  public void onAttachedToWindow()
  {
    this.a.onAttachedToWindow();
  }
  
  public void onBackPressed()
  {
    this.a.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.a.onConfigurationChanged(paramConfiguration);
  }
  
  public void onContentChanged()
  {
    this.a.onContentChanged();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return this.a.onContextItemSelected(paramMenuItem);
  }
  
  public void onContextMenuClosed(Menu paramMenu)
  {
    this.a.onContextMenuClosed(paramMenu);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.a.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public CharSequence onCreateDescription()
  {
    return this.a.onCreateDescription();
  }
  
  public void onCreateNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    this.a.onCreateNavigateUpTaskStack(paramTaskStackBuilder);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return this.a.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.a.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.a.onCreatePanelView(paramInt);
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    return this.a.onCreateThumbnail(paramBitmap, paramCanvas);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onDetachedFromWindow()
  {
    this.a.onDetachedFromWindow();
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyLongPress(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyShortcut(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    this.a.onLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.a.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.a.onMenuOpened(paramInt, paramMenu);
  }
  
  public boolean onNavigateUp()
  {
    return this.a.onNavigateUp();
  }
  
  public boolean onNavigateUpFromChild(Activity paramActivity)
  {
    return this.a.onNavigateUpFromChild(paramActivity);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.a.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onOptionsMenuClosed(Menu paramMenu)
  {
    this.a.onOptionsMenuClosed(paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.a.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPrepareNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    this.a.onPrepareNavigateUpTaskStack(paramTaskStackBuilder);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return this.a.onPrepareOptionsMenu(paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.a.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public Object onRetainNonConfigurationInstance()
  {
    return this.a.onRetainNonConfigurationInstance();
  }
  
  public boolean onSearchRequested()
  {
    return this.a.onSearchRequested();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onTrackballEvent(paramMotionEvent);
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.a.onTrimMemory(paramInt);
  }
  
  public void onUserInteraction()
  {
    this.a.onUserInteraction();
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.a.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.a.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.a.onWindowStartingActionMode(paramCallback);
  }
  
  public void openContextMenu(View paramView)
  {
    this.a.openContextMenu(paramView);
  }
  
  public FileInputStream openFileInput(String paramString)
  {
    return this.a.openFileInput(paramString);
  }
  
  public FileOutputStream openFileOutput(String paramString, int paramInt)
  {
    return this.a.openFileOutput(paramString, paramInt);
  }
  
  public void openOptionsMenu()
  {
    this.a.openOptionsMenu();
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return this.a.openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return this.a.openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    this.a.overridePendingTransition(paramInt1, paramInt2);
  }
  
  public Drawable peekWallpaper()
  {
    return this.a.peekWallpaper();
  }
  
  public void recreate()
  {
    this.a.recreate();
  }
  
  public void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.a.registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public void registerForContextMenu(View paramView)
  {
    this.a.registerForContextMenu(paramView);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return this.a.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    this.a.removeStickyBroadcast(paramIntent);
  }
  
  public void revokeUriPermission(Uri paramUri, int paramInt)
  {
    this.a.revokeUriPermission(paramUri, paramInt);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    this.a.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    this.a.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    this.a.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    this.a.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    this.a.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void setContentView(int paramInt)
  {
    this.a.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    this.a.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.setContentView(paramView, paramLayoutParams);
  }
  
  public void setFinishOnTouchOutside(boolean paramBoolean)
  {
    this.a.setFinishOnTouchOutside(paramBoolean);
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.a.setIntent(paramIntent);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.a.setRequestedOrientation(paramInt);
  }
  
  public void setTheme(int paramInt)
  {
    this.a.setTheme(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    this.a.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.a.setTitle(paramCharSequence);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.a.setTitleColor(paramInt);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.a.setVisible(paramBoolean);
  }
  
  public void setWallpaper(Bitmap paramBitmap)
  {
    this.a.setWallpaper(paramBitmap);
  }
  
  public void setWallpaper(InputStream paramInputStream)
  {
    this.a.setWallpaper(paramInputStream);
  }
  
  public boolean shouldUpRecreateTask(Intent paramIntent)
  {
    return this.a.shouldUpRecreateTask(paramIntent);
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    return this.a.startActionMode(paramCallback);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    this.a.startActivities(paramArrayOfIntent);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    this.a.startActivities(paramArrayOfIntent, paramBundle);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.a.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    this.a.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.a.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.a.startActivityFromChild(paramActivity, paramIntent, paramInt);
  }
  
  public void startActivityFromChild(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.a.startActivityFromChild(paramActivity, paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.a.startActivityFromFragment(paramFragment, paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.a.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public boolean startActivityIfNeeded(Intent paramIntent, int paramInt)
  {
    return this.a.startActivityIfNeeded(paramIntent, paramInt);
  }
  
  public boolean startActivityIfNeeded(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    return this.a.startActivityIfNeeded(paramIntent, paramInt, paramBundle);
  }
  
  public boolean startInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle)
  {
    return this.a.startInstrumentation(paramComponentName, paramString, paramBundle);
  }
  
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
  }
  
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    this.a.startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3, paramBundle);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.a.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.startIntentSenderFromChild(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderFromChild(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.a.startIntentSenderFromChild(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startManagingCursor(Cursor paramCursor)
  {
    this.a.startManagingCursor(paramCursor);
  }
  
  public boolean startNextMatchingActivity(Intent paramIntent)
  {
    return this.a.startNextMatchingActivity(paramIntent);
  }
  
  public boolean startNextMatchingActivity(Intent paramIntent, Bundle paramBundle)
  {
    return this.a.startNextMatchingActivity(paramIntent, paramBundle);
  }
  
  public void startSearch(String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    this.a.startSearch(paramString, paramBoolean1, paramBundle, paramBoolean2);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return this.a.startService(paramIntent);
  }
  
  public void stopManagingCursor(Cursor paramCursor)
  {
    this.a.stopManagingCursor(paramCursor);
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return this.a.stopService(paramIntent);
  }
  
  public void takeKeyEvents(boolean paramBoolean)
  {
    this.a.takeKeyEvents(paramBoolean);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public void triggerSearch(String paramString, Bundle paramBundle)
  {
    this.a.triggerSearch(paramString, paramBundle);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    this.a.unbindService(paramServiceConnection);
  }
  
  public void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks)
  {
    this.a.unregisterComponentCallbacks(paramComponentCallbacks);
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    this.a.unregisterForContextMenu(paramView);
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.a.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */