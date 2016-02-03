package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl
  implements Acls
{
  private static Acls.LoadAclResult x(Status paramStatus)
  {
    new Acls.LoadAclResult()
    {
      public Status getStatus()
      {
        return this.yG;
      }
      
      public void release() {}
    };
  }
  
  private static abstract class LoadNotifyAclImpl
    extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult>
  {
    public Acls.LoadAclResult z(Status paramStatus)
    {
      return AclsImpl.y(paramStatus);
    }
  }
  
  private static abstract class UpdateNotifyAclImpl
    extends Games.BaseGamesApiMethodImpl<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/api/AclsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */