package mobi.ifunny.rest.content;

public abstract class UserFeed
        extends FeedPagingList<User> {
    public UserList users = new UserList();

    public PagingList<User> getPagingList() {
        return this.users;
    }

    public abstract int getUsersCount();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */