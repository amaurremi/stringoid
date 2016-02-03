package twitter4j.api;

import twitter4j.PagableResponseList;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.User;
import twitter4j.UserList;

public abstract interface ListsResources
{
  public abstract UserList addUserListMember(int paramInt, long paramLong);
  
  public abstract UserList addUserListMember(long paramLong1, String paramString, long paramLong2);
  
  public abstract UserList addUserListMembers(int paramInt, long[] paramArrayOfLong);
  
  public abstract UserList addUserListMembers(int paramInt, String[] paramArrayOfString);
  
  public abstract UserList addUserListMembers(long paramLong, String paramString, long[] paramArrayOfLong);
  
  public abstract UserList addUserListMembers(long paramLong, String paramString, String[] paramArrayOfString);
  
  public abstract UserList createUserList(String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract UserList createUserListMember(int paramInt, long paramLong);
  
  public abstract UserList createUserListMember(long paramLong1, String paramString, long paramLong2);
  
  public abstract UserList createUserListMember(String paramString1, String paramString2, long paramLong);
  
  public abstract UserList createUserListMembers(int paramInt, long[] paramArrayOfLong);
  
  public abstract UserList createUserListMembers(int paramInt, String[] paramArrayOfString);
  
  public abstract UserList createUserListMembers(long paramLong, String paramString, long[] paramArrayOfLong);
  
  public abstract UserList createUserListMembers(long paramLong, String paramString, String[] paramArrayOfString);
  
  public abstract UserList createUserListMembers(String paramString1, String paramString2, long[] paramArrayOfLong);
  
  public abstract UserList createUserListMembers(String paramString1, String paramString2, String[] paramArrayOfString);
  
  public abstract UserList createUserListSubscription(int paramInt);
  
  public abstract UserList createUserListSubscription(long paramLong, String paramString);
  
  public abstract UserList createUserListSubscription(String paramString1, String paramString2);
  
  public abstract UserList deleteUserListMember(int paramInt, long paramLong);
  
  public abstract UserList deleteUserListMember(long paramLong1, String paramString, long paramLong2);
  
  public abstract UserList destroyUserList(int paramInt);
  
  public abstract UserList destroyUserList(long paramLong, String paramString);
  
  public abstract UserList destroyUserList(String paramString1, String paramString2);
  
  public abstract UserList destroyUserListMember(int paramInt, long paramLong);
  
  public abstract UserList destroyUserListMember(long paramLong1, String paramString, long paramLong2);
  
  public abstract UserList destroyUserListMember(String paramString1, String paramString2, long paramLong);
  
  public abstract UserList destroyUserListSubscription(int paramInt);
  
  public abstract UserList destroyUserListSubscription(long paramLong, String paramString);
  
  public abstract UserList destroyUserListSubscription(String paramString1, String paramString2);
  
  public abstract PagableResponseList getUserListMembers(int paramInt, long paramLong);
  
  public abstract PagableResponseList getUserListMembers(long paramLong1, String paramString, long paramLong2);
  
  public abstract PagableResponseList getUserListMembers(String paramString1, String paramString2, long paramLong);
  
  public abstract PagableResponseList getUserListMemberships(long paramLong);
  
  public abstract PagableResponseList getUserListMemberships(long paramLong1, long paramLong2);
  
  public abstract PagableResponseList getUserListMemberships(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract PagableResponseList getUserListMemberships(String paramString, long paramLong);
  
  public abstract PagableResponseList getUserListMemberships(String paramString, long paramLong, boolean paramBoolean);
  
  public abstract ResponseList getUserListStatuses(int paramInt, Paging paramPaging);
  
  public abstract ResponseList getUserListStatuses(long paramLong, String paramString, Paging paramPaging);
  
  public abstract ResponseList getUserListStatuses(String paramString1, String paramString2, Paging paramPaging);
  
  public abstract PagableResponseList getUserListSubscribers(int paramInt, long paramLong);
  
  public abstract PagableResponseList getUserListSubscribers(long paramLong1, String paramString, long paramLong2);
  
  public abstract PagableResponseList getUserListSubscribers(String paramString1, String paramString2, long paramLong);
  
  public abstract PagableResponseList getUserListSubscriptions(String paramString, long paramLong);
  
  public abstract ResponseList getUserLists(long paramLong);
  
  public abstract ResponseList getUserLists(String paramString);
  
  public abstract UserList showUserList(int paramInt);
  
  public abstract UserList showUserList(long paramLong, String paramString);
  
  public abstract UserList showUserList(String paramString1, String paramString2);
  
  public abstract User showUserListMembership(int paramInt, long paramLong);
  
  public abstract User showUserListMembership(long paramLong1, String paramString, long paramLong2);
  
  public abstract User showUserListMembership(String paramString1, String paramString2, long paramLong);
  
  public abstract User showUserListSubscription(int paramInt, long paramLong);
  
  public abstract User showUserListSubscription(long paramLong1, String paramString, long paramLong2);
  
  public abstract User showUserListSubscription(String paramString1, String paramString2, long paramLong);
  
  public abstract UserList updateUserList(int paramInt, String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract UserList updateUserList(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3);
  
  public abstract UserList updateUserList(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/api/ListsResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */