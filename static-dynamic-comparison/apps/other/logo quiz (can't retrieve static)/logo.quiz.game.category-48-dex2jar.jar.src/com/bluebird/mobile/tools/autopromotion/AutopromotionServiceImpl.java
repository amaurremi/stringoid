package com.bluebird.mobile.tools.autopromotion;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.util.Log;
import com.bluebird.mobile.tools.commonutils.ApplicationUtils;
import com.bluebird.mobile.tools.counter.CounterService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class AutopromotionServiceImpl
  implements AutopromotionService
{
  private List<Application> applications;
  private Context context;
  private SharedPreferences preferences;
  private Random random = new Random();
  
  public AutopromotionServiceImpl(List<Application> paramList, Context paramContext)
  {
    this.applications = paramList;
    this.preferences = paramContext.getSharedPreferences("autopromotion", 0);
    this.context = paramContext.getApplicationContext();
  }
  
  public void checkIfNewApplicationsHasBeenInstalledInSeparatedThread(final CounterService paramCounterService, final Callable paramCallable)
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = AutopromotionServiceImpl.this.applications.iterator();
        while (paramAnonymousVarArgs.hasNext())
        {
          Application localApplication = (Application)paramAnonymousVarArgs.next();
          if ((AutopromotionServiceImpl.this.isInstalled(localApplication)) && (AutopromotionServiceImpl.this.hasNotBeenInstalledBefore(localApplication)) && (!localApplication.getAppPackage().equals(AutopromotionServiceImpl.this.context.getPackageName()))) {
            AutopromotionServiceImpl.this.markApplicationAsInstalledAndAddCurrency(localApplication, paramCounterService);
          }
        }
        return null;
      }
      
      protected void onPostExecute(Void paramAnonymousVoid)
      {
        if (paramCallable != null) {}
        try
        {
          paramCallable.call();
          return;
        }
        catch (Exception paramAnonymousVoid)
        {
          Log.e("Autopromotion", "Error in callback", paramAnonymousVoid);
        }
      }
    }.execute(new Void[] { (Void)null });
  }
  
  public List<Application> getInstalledApplications()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.applications.iterator();
    while (localIterator.hasNext())
    {
      Application localApplication = (Application)localIterator.next();
      if (isInstalled(localApplication)) {
        localArrayList.add(localApplication);
      }
    }
    return localArrayList;
  }
  
  public List<Application> getNeverInstalledApplications()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.applications.iterator();
    while (localIterator.hasNext())
    {
      Application localApplication = (Application)localIterator.next();
      if ((!isInstalled(localApplication)) && (hasNotBeenInstalledBefore(localApplication))) {
        localArrayList.add(localApplication);
      }
    }
    return localArrayList;
  }
  
  public Application getRandomNeverInstalledApplication()
  {
    Object localObject = getNeverInstalledApplications();
    if (!((List)localObject).isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Application localApplication = (Application)((Iterator)localObject).next();
        int i = 0;
        while (i < localApplication.getWeight())
        {
          localArrayList.add(localApplication);
          i += 1;
        }
      }
      return (Application)localArrayList.get(Math.abs(this.random.nextInt(localArrayList.size())));
    }
    return null;
  }
  
  public boolean hasNotBeenInstalledBefore(Application paramApplication)
  {
    return this.preferences.getBoolean(paramApplication.getAppPackage(), true);
  }
  
  public boolean isInstalled(Application paramApplication)
  {
    return ApplicationUtils.isInstalled(paramApplication.getAppPackage(), this.context);
  }
  
  public void markApplicationAsInstalledAndAddCurrency(Application paramApplication, CounterService paramCounterService)
  {
    this.preferences.edit().putBoolean(paramApplication.getAppPackage(), false).commit();
    paramCounterService.add(paramApplication.getCurrencyAmount());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/autopromotion/AutopromotionServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */