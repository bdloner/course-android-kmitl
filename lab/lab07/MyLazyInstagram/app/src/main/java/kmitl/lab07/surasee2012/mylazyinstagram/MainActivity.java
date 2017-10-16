package kmitl.lab07.surasee2012.mylazyinstagram;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kmitl.lab07.surasee2012.mylazyinstagram.adapter.PostAdapter;
import kmitl.lab07.surasee2012.mylazyinstagram.api.LazyInstagramApi;
import kmitl.lab07.surasee2012.mylazyinstagram.api.UserProfile;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserProfile("android");
    }

    private void getUserProfile(String usrName) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(LazyInstagramApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LazyInstagramApi lazyInstagramApi = retrofit.create(LazyInstagramApi.class);

        Call<UserProfile> call = lazyInstagramApi.getProfile(usrName);
        call.enqueue(new Callback<UserProfile>() {
            @Override
            public void onResponse(Call<UserProfile> call, Response<UserProfile> response) {
                if (response.isSuccessful()) {
                    UserProfile userProfile = response.body();

                    TextView textUser = findViewById(R.id.textUser);
                    TextView textPost = findViewById(R.id.textPost);
                    TextView textFollowing = findViewById(R.id.textFollowing);
                    TextView textFollower = findViewById(R.id.textFollower);
                    TextView textBio = findViewById(R.id.textBio);
                    ImageView imageProfile = findViewById(R.id.imageProfile);

                    textUser.setText("@"+userProfile.getUser());
//                    textUser.setText(userProfile.getPosts()[0].getUrl());
                    textPost.setText("Post\n"+userProfile.getPost());
                    textFollowing.setText("Following\n"+userProfile.getFollowing());
                    textFollower.setText("Follower\n"+userProfile.getFollower());
                    textBio.setText(userProfile.getBio());
                    Glide.with(MainActivity.this).load(userProfile.getUrlProfile()).into(imageProfile);

                    PostAdapter postAdapter = new PostAdapter(context, userProfile);
                    RecyclerView recyclerView = findViewById(R.id.list);

                    recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
                    recyclerView.setAdapter(postAdapter);
                }
            }

            @Override
            public void onFailure(Call<UserProfile> call, Throwable t) {

            }
        });
    }

    int numCheck = 1;

    public void onChangeUser(View view) {
        String profile = "";
        if (numCheck == 1) {
            profile = "nature";
            numCheck++;
        } else if (numCheck == 2) {
            profile = "cartoon";
            numCheck++;
        } else if (numCheck == 3) {
            profile = "android";
            numCheck = 1;
        }
        getUserProfile(profile);
    }
}
