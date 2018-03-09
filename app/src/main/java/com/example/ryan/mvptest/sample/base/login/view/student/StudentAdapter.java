package com.example.ryan.mvptest.sample.base.login.view.student;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ryan.mvptest.R;
import com.example.ryan.mvptest.sample.base.login.MvpApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 17-9-27.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = StudentAdapter.class.getSimpleName();
    private List<StudentMode> list;
    private LayoutInflater inflater;
    private OnStudentSelectedLisener onStudentSelectedLisenter;

    public StudentAdapter(List<StudentMode> list,OnStudentSelectedLisener onStudentSelectedLisenter){
        this.list = list;
        this.onStudentSelectedLisenter = onStudentSelectedLisenter;
        inflater = LayoutInflater.from(MvpApplication.mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list,parent,false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
         BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
            StudentMode studentMode = list.get(position);
            baseViewHolder.nim.setText(studentMode.nim);
            baseViewHolder.name.setText(studentMode.name);
            baseViewHolder.address.setText(studentMode.address);
        Log.i(TAG, "onBindViewHolder: name = "+studentMode.name);
        baseViewHolder.item_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onStudentSelectedLisenter != null){
                    onStudentSelectedLisenter.onSelected(position);
                }
            }
        });

    }

    @Override
    public int getItemViewType(int position) {return position;}

    @Override
    public int getItemCount() {return list.size();}

    public class BaseViewHolder extends RecyclerView.ViewHolder{
        private TextView nim;
        private TextView name;
        private TextView address;
        private LinearLayout item_ll;

        public BaseViewHolder(View itemView) {
            super(itemView);
            nim = itemView.findViewById(R.id.nim);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            item_ll = itemView.findViewById(R.id.item_ll);
        }
    }
}
