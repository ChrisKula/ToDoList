package com.christiankula.todolist.todolist;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.christiankula.todolist.R;
import com.christiankula.todolist.models.ToDo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<ToDo> data;

    public ToDoAdapter() {
        this.data = new ArrayList<>();
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

        SimpleDateFormat sdf = new SimpleDateFormat(holder.tvTodoDescription.getContext().getString(R.string.date_time_format), Locale.getDefault());

        holder.tvToDoExpirationDate.setText(sdf.format(todo.getExpirationDate()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void updateToDos(List<ToDo> toDos) {
        ToDosDiffCallback diffCallback = new ToDosDiffCallback(data, toDos);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.data.clear();
        this.data.addAll(toDos);

        diffResult.dispatchUpdatesTo(this);
    }

    class ToDoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.todoitem_tv_todo_description)
        TextView tvTodoDescription;

        @BindView(R.id.todoitem_tv_todo_expiration_date)
        TextView tvToDoExpirationDate;

        ToDoViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    class ToDosDiffCallback extends DiffUtil.Callback {
        private List<ToDo> oldToDos;

        private List<ToDo> newToDos;

        ToDosDiffCallback(List<ToDo> oldToDos, List<ToDo> newToDos) {
            this.oldToDos = oldToDos;
            this.newToDos = newToDos;
        }

        @Override
        public int getOldListSize() {
            return oldToDos.size();
        }

        @Override
        public int getNewListSize() {
            return newToDos.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldToDos.get(oldItemPosition).equals(newToDos.get(newItemPosition));
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition);
        }
    }
}
