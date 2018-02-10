package com.christiankula.todolist.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class DismissCallback extends ItemTouchHelper.Callback {

        private final OnItemDismissListener listener;

        public DismissCallback(OnItemDismissListener listener) {
            this.listener = listener;
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.START | ItemTouchHelper.END);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            if (listener != null) {
                listener.onItemDismiss(viewHolder.getAdapterPosition());
            }
        }

        @Override
        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public interface OnItemDismissListener {
            void onItemDismiss(int position);
        }
    }