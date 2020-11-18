package com.example.onlineshop_v2.ui.homepage;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.onlineshop_v2.R;
import java.util.ArrayList;


public class HomePageFragment extends Fragment{
    private View view ;

    public RecyclerView mHomePageFragmentRecyclerView;
    //定義以goodsentity實體類為物件的資料集合
    private ArrayList<GoodsEntity> goodsEntityList  = new ArrayList<GoodsEntity>();
    //自定義recyclerveiw的介面卡
    private HomePageFragmentAdapter mHomePageFragmentRecyclerAdapeter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home_page, container,false);

        //對recycleview進行配置
        initRecyclerView();
        initData();
        return view;
    }

    //模拟内容，就是我的书们
    private void initData(){
        for (int i=0;i<10;i++){
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsName("模拟的书"+i);
            goodsEntity.setGoodPrice("100"+ i);
            goodsEntityList.add(goodsEntity);
        }
    }

    //对recyclerView进行配置
    private void initRecyclerView(){

        //获取recyclerView
        mHomePageFragmentRecyclerView = (RecyclerView) view.findViewById(R.id.homepage_recyclerView);

        //建立 adapter
        mHomePageFragmentRecyclerAdapeter = new HomePageFragmentAdapter(getActivity(),goodsEntityList);

        //给recyclerView设定adapter
        mHomePageFragmentRecyclerView.setAdapter(mHomePageFragmentRecyclerAdapeter);
        // 设定layoutManager， 可以设置显示效果

        //参数：上下文，列表方向，是否倒叙
//        RecyclerView.LayoutManager

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 3;  //设置每行3列
//            }
//        });
        mHomePageFragmentRecyclerView.setLayoutManager(layoutManager);

        //设定item的分割线
        mHomePageFragmentRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        //设置RecyclerView的监听事件，点击后干什么
//        mHomePageFragmentRecyclerAdapeter.setOnItemClickListener
    }
}
