package com.example.onlineshop_v2.ui.homepage;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.ConnectToServer;
import com.example.onlineshop_v2.ui.GetImageOnline;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class HomePageFragment extends Fragment{
    private View view ;
    private static final String TAG = "HomePageFragment";
    private Handler handlerHomePage;
    public RecyclerView mHomePageFragmentRecyclerView;
    //存储接收回来的图书数据
    JSONObject ReceiveJsonData = new JSONObject();
    //定義以goodsentity實體類為物件的資料集合
    private ArrayList<GoodsEntity> goodsEntityList  = new ArrayList<GoodsEntity>();
    //自定義recyclerveiw的介面卡
    private HomePageFragmentAdapter mHomePageFragmentRecyclerAdapeter;
    JSONObject sendJsonData = new JSONObject();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home_page, container,false);

        //對recycleview進行配置
        handlerHomePage = new Handler(Looper.getMainLooper()){
            public void handleMessage(Message msg){
                switch (msg.what){
                    case 1:
                        Log.d(TAG, "handleMessage: receive success 1 ");
                        ReceiveJsonData = (JSONObject) msg.obj;
                        Log.d(TAG, "handleMessage: receive success");
                        Log.d(TAG, "handleMessage: "+ ReceiveJsonData);
                        System.out.println("二次转换成功");
                        try{
                            initData(ReceiveJsonData);
                        } catch (JSONException | MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        initRecyclerView();
                        break;
//                    case 2:
//                        byte[] resutl = (byte[]) msg.obj;
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(resutl,0,resutl.length);


                }
            }
        };

        ConnectToServer threadPersonProfile = new ConnectToServer(handlerHomePage,sendJsonData, "getbookdata");
        threadPersonProfile.start();
        


        return view;
    }

    //模拟内容，就是我的书们
    private void initData(JSONObject initData) throws JSONException, IOException {
        for (int i=0;i<initData.length();i++){
            String ii = i + "";
            JSONObject book = initData.getJSONObject(ii);
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsName(book.getString("Btitle"));
            goodsEntity.setGoodPrice(book.getString("Bprice"));
            Log.d(TAG, "initData: "+book.getString("Bprice"));
//            String url = "http://47.93.25.50/static/9787020015092.jpg";
//            URL req = new URL(url);
//            Bitmap bitmap = BitmapFactory.decodeStream(req.openConnection().getInputStream());
//            ImageView imageView = (ImageView)getActivity().findViewById(R.id.book_image);
//            imageView.setImageBitmap(bitmap);

//            GetImageOnline threadGetImageOnline = new GetImageOnline(handlerHomePage,book.getString("BISBN"));
//            threadGetImageOnline.start();
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
