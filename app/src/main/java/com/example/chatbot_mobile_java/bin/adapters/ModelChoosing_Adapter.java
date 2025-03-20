package com.example.chatbot_mobile_java.bin.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chatbot_mobile_java.R;
import com.example.chatbot_mobile_java.bin.activities.MainChatPage;
import com.example.chatbot_mobile_java.bin.data.clientMessage;
import com.example.chatbot_mobile_java.bin.data.Api;

import java.util.List;

public class ModelChoosing_Adapter extends RecyclerView.Adapter<ModelChoosing_Adapter.MyViewHolder> {

    List<Api> apiList;
    Context context;

    public ModelChoosing_Adapter(List<Api> apiList, Context context) {
        this.apiList = apiList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_api, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_apiName.setText(apiList.get(position).getName());
        holder.tv_apiDescription.setText(apiList.get(position).getDescription());
        Glide.with(this.context).load(apiList.get(position).getImageURL()).into(holder.iv_apiPic);

        holder.itemView.setOnClickListener(v -> {
            clientMessage.initialize_Type(apiList.get(position).getName().toString());
            LinearLayout linearLayoutContainer = ((Activity) context).findViewById(R.id.layoutExpandedModel);
            ImageButton btnOptions = ((Activity) context).findViewById(R.id.ibtnMoreOption);
            ImageButton Micro = ((Activity) context).findViewById(R.id.Micro);
            ImageButton Enter = ((Activity) context).findViewById(R.id.Enter);
            EditText etMessageInput = ((Activity) context).findViewById(R.id.etMessageInput);
            if(linearLayoutContainer.getVisibility() == View.VISIBLE){
                linearLayoutContainer.setVisibility(View.GONE);
                btnOptions.setVisibility(View.VISIBLE);
                Micro.setVisibility(View.VISIBLE);
                Enter.setVisibility(View.VISIBLE);
                etMessageInput.setVisibility(View.VISIBLE);
                MainChatPage.setModelToggleState();
            }else
            {
                Log.d("LinearLayout_container", "not visible");
            }
           Log.d("bin", "user model AI type: " + clientMessage.get_Type());
        });

    }

    @Override
    public int getItemCount() {
        return apiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_apiPic;
        TextView tv_apiName;
        TextView tv_apiDescription;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv_apiPic = itemView.findViewById(R.id.iv_apiPicture);
            tv_apiName = itemView.findViewById(R.id.tv_apiName);
            tv_apiDescription = itemView.findViewById(R.id.tv_apiDescription);


        }
    }

}
