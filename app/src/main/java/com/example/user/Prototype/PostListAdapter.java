package com.example.user.Prototype;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {
    private List<PostModel>items = new ArrayList<>();

    PostListAdapter(List<PostModel> items){
       this.items = items;
    }

    @Override
    public PostListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_view,parent,false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.strSubject.setText(items.get(position).getStrSubject());
        holder.strName.setText(items.get(position).getStrName());
        holder.dateTime.setText(items.get(position).getDateTime());
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView strSubject;
        public TextView dateTime;
        public TextView strName;

        public ViewHolder(View view){
            super(view);
            strSubject = (TextView)view.findViewById(R.id.postSubjectText);
            strName = (TextView)view.findViewById(R.id.postNameText);
            dateTime = (TextView)view.findViewById(R.id.postTimeText);
        }
    }

   /* public void add(PostModel item, int position ){
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(PostModel item){
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }*/

}
