package kmitl.lab08.bdloner.Espresso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.demorecord.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfoListActivity extends AppCompatActivity {

    public static final String EXTTRA_LIST = "EXTTRA_LIST";

    @BindView(R.id.list)
    public RecyclerView list;

    @BindView(R.id.textNotFound)
    public TextView textNotFound;

    private MyAdapter adapter;
    private CommonSharePreference preference;
    private UserInfoList suggestSearchList;
    private UserInfoList userInfoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_list);
        ButterKnife.bind(this);
        preference = new CommonSharePreference(this);

        adapter = new MyAdapter();
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        suggestSearchList = (UserInfoList) preference.read(UserInfoListActivity.EXTTRA_LIST, UserInfoList.class);
        if (suggestSearchList != null) {
            displaySuggestsList(suggestSearchList.getUserInfoList());
        } else {
            displaySuggestsList(new ArrayList<UserInfo>());
        }
    }

    public void displaySuggestsList(List<UserInfo> suggestsList) {
        if (suggestsList.size() <= 0) {
            textNotFound.setVisibility(View.VISIBLE);
            list.setVisibility(View.GONE);
        } else {
            textNotFound.setVisibility(View.GONE);
            list.setVisibility(View.VISIBLE);
            adapter.setData(suggestsList);
            adapter.notifyDataSetChanged();
        }

    }

    public void onClearList(View view) {
        suggestSearchList.getUserInfoList().clear();
        adapter.notifyDataSetChanged();
        textNotFound.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);

        userInfoList = new UserInfoList();
        List<UserInfo> suggests = new ArrayList<>();
        userInfoList.setUserInfoList(suggests);
        preference.save(UserInfoListActivity.EXTTRA_LIST, userInfoList);
    }
}
