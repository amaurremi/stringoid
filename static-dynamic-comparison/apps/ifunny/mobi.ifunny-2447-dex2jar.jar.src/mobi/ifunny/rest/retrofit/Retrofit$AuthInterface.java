package mobi.ifunny.rest.retrofit;

import mobi.ifunny.rest.content.AccessToken;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

abstract interface Retrofit$AuthInterface {
    @FormUrlEncoded
    @POST("/oauth2/token")
    public abstract AccessToken getToken(@Field("grant_type") String paramString1, @Field("client_id") String paramString2, @Field("client_token") String paramString3, @Field("client_token_secret") String paramString4, @Field("username") String paramString5, @Field("password") String paramString6);

    @FormUrlEncoded
    @POST("/oauth2/revoke")
    public abstract RestResponse<Object> revokeToken(@Field("token") String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/retrofit/Retrofit$AuthInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */