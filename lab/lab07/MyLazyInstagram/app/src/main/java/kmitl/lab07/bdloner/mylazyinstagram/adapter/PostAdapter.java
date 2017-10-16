package kmitl.lab07.bdloner.mylazyinstagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kmitl.lab07.bdloner.mylazyinstagram.R;
import kmitl.lab07.bdloner.mylazyinstagram.model.PostModel;

class Holder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView textLike;
    TextView textComment;

    public Holder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        textLike = itemView.findViewById(R.id.textLike);
        textComment = itemView.findViewById(R.id.textComment);
    }
}

public class PostAdapter extends RecyclerView.Adapter<Holder> {
    private Context context;
    private List<PostModel> data;

    private String layoutType;

    public PostAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void setData(List<PostModel> data) {
        this.data = data;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (layoutType.equals("grid")) {
            view = inflater.inflate(R.layout.grid_item, null, false);
            Holder holder = new Holder(view);
            return holder;
        } else {
            view = inflater.inflate(R.layout.list_item, null, false);
            Holder holder = new Holder(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String imageUrl = data.get(position).getUrl();
        Glide.with(context).load(imageUrl).into(holder.image);
        if (layoutType.equals("list")) {
            holder.textLike.setText(Integer.toString(data.get(position).getLike()));
            holder.textComment.setText(Integer.toString(data.get(position).getComment()));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}