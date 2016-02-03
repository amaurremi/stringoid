package com.bluebird.mobile.tools.autopromotion;

import com.bluebird.mobile.tools.counter.CounterService;
import java.util.List;
import java.util.concurrent.Callable;

public abstract interface AutopromotionService
{
  public abstract void checkIfNewApplicationsHasBeenInstalledInSeparatedThread(CounterService paramCounterService, Callable paramCallable);
  
  public abstract List<Application> getInstalledApplications();
  
  public abstract List<Application> getNeverInstalledApplications();
  
  public abstract Application getRandomNeverInstalledApplication();
  
  public abstract boolean hasNotBeenInstalledBefore(Application paramApplication);
  
  public abstract boolean isInstalled(Application paramApplication);
  
  public abstract void markApplicationAsInstalledAndAddCurrency(Application paramApplication, CounterService paramCounterService);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/autopromotion/AutopromotionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */