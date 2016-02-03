package com.inmobi.commons.internal;

import com.inmobi.commons.cache.CacheController.Validator;

final class b
  implements CacheController.Validator
{
  public String validate(String paramString)
  {
    return InternalSDKUtil.a(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */