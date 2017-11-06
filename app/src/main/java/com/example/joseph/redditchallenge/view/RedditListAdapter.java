package com.example.joseph.redditchallenge.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joseph.redditchallenge.R;
import com.example.joseph.redditchallenge.model.Child;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 11/6/17.
 */

public class RedditListAdapter extends RecyclerView.Adapter<RedditListAdapter.ViewHolder> {

    private Context context;
    private List<Child> childList = new ArrayList<>();
//    private RecipeListItemListener listener;

    public RedditListAdapter(Context context, List<Child> childList) {
        this.context = context;
//        this.listener = (RecipeListItemListener) context;
        this.childList = childList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reddit_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Child child = childList.get(position);
        holder.tvAuthor.setText(child.getData().getAuthor());
//        Picasso.with(context).load(recipe.getImage()).into(holder.recipeImage);
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }
    }
}

