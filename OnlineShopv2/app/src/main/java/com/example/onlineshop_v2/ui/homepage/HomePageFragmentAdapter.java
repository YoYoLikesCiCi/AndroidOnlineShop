package com.example.onlineshop_v2.ui.homepage;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.ConnectToServer;

import org.json.JSONObject;

import java.util.ArrayList;

public class HomePageFragmentAdapter extends RecyclerView.Adapter<HomePageFragmentAdapter.myViewHodler> {

    private Context context;
    private ArrayList<GoodsEntity> goodsEntityList;

    //构建 构造函数
    public HomePageFragmentAdapter(Context context, ArrayList<GoodsEntity> goodsEntityList){
        this.context = context;
        this.goodsEntityList = goodsEntityList;
    }

    @Override
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType){
        //建立自定义布局
        View itemView = View.inflate(context, R.layout.homepage_fragment_item,null);

        return new myViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHodler holder, int position) {



        GoodsEntity data = goodsEntityList.get(position);

        holder.mItemGoodsName.setText(data.goodsName);
        holder.mItemGoodsPrice.setText(data.goodPrice);
    }

    @Override
    public int getItemCount(){
        return goodsEntityList.size();
    }

    class myViewHodler extends RecyclerView.ViewHolder{
        private ImageView mItemGoodsImg;
        private TextView mItemGoodsName;
        private TextView mItemGoodsPrice;

        public myViewHodler(View itemView){
            super(itemView);
            mItemGoodsImg = (ImageView)itemView.findViewById(R.id.item_book_img);
            mItemGoodsName = (TextView) itemView.findViewById(R.id.item_book_title);
            mItemGoodsPrice = (TextView) itemView.findViewById(R.id.item_book_price);

            //点选事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"點選了xxx", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //设置item的监听事件
    public interface OnItemCilckListener{
        public void OnItemClick(View view , GoodsEntity data);
    }
    //需要外部訪問，所以需要設定set方法，方便呼叫
    private OnItemCilckListener onItemCilckListener;

    public void setOnItemCilckListener(OnItemCilckListener onItemCilckListener){
        this.onItemCilckListener = onItemCilckListener;
    }


}
