package com.christiankula.todolist.todolist;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.christiankula.todolist.R;
import com.christiankula.todolist.models.ToDo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<ToDo> data;

    public ToDoAdapter(List<ToDo> data) {
        this.data = data;
    }

    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_todo, parent, false);

        return new ToDoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        ToDo todo = data.get(position);

        holder.tvTodoDescription.setText(todo.getDescription());

        //TODO Format date
        holder.tvToDoExpirationDate.setText(todo.getExpirationDate().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ToDoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.todoitem_tv_todo_description)
        TextView tvTodoDescription;

        @BindView(R.id.todoitem_tv_todo_expiration_date)
        TextView tvToDoExpirationDate;

        ToDoViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(itemView);
        }
    }

}
