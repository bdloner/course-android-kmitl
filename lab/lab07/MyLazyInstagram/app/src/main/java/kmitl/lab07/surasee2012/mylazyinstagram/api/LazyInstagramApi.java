package kmitl.lab07.surasee2012.mylazyinstagram.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gun on 10/6/2017.
 */

public interface LazyInstagramApi {

    String BASE_URL = "https://us-central1-retrofit-course.cloudfunctions.net";

    @GET("/getProfile")
    Call<UserProfile> getProfile(@Query("user") String userName);

}
