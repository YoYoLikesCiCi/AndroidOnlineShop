package com.example.onlineshop_v2.ui.labelbook;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshop_v2.R;

import java.util.ArrayList;
import java.util.List;

public class LabelBookFragment extends Fragment {

    private LabelBookViewModel mViewModel;

    public static LabelBookFragment newInstance() {
        return new LabelBookFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_label_book, container, false);
    }




    private List<Book> bookList = new ArrayList<>();  //用于接收数据源的集合，泛型为自定义的Book类


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LabelBookViewModel.class);



        //获取编辑框的内容，并转成string格式
        EditText editText_search = (EditText) getActivity().findViewById(R.id.edit_search);
        String s = editText_search.getText().toString();


        //搜索按钮的点击事件
        Button button_search = (Button) getActivity().findViewById(R.id.button_search);
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "按了一下button", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



        //        按钮 小说 的监听事件 （初始化数据并用适配器格式化，最后加载进布局）
        Button rb_novel = (Button) getActivity().findViewById (R.id.button_novel);
        rb_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "点了一下“小说”", Toast.LENGTH_SHORT).show();
                initBooksNovel();
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),
                        3, LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gridLayoutManager);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
            }
        });



        //        按钮 教育 的点击事件
        Button rb_edu = (Button) getActivity() .findViewById(R.id.button_education);
        rb_edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBooksEdu();
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),
                        3,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gridLayoutManager);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
            }
        });


        //        按钮传记的点击事件
        Button rb_biography = (Button) getActivity() .findViewById(R.id.button_biography);
        rb_biography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBooksBiography();
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3,LinearLayoutManager.VERTICAL,false);

                recyclerView.setLayoutManager(gridLayoutManager);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
            }
        });


        //        按钮历史的点击事件
        Button rb_history = (Button) getActivity() .findViewById(R.id.button_history);
        rb_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBooksHis();
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3,LinearLayoutManager.VERTICAL,false);

                recyclerView.setLayoutManager(gridLayoutManager);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
            }
        });



        //        按钮文学的点击事件
        Button rb_literary = (Button) getActivity() .findViewById(R.id.button_literary);
        rb_literary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBooksLiterary();
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3,LinearLayoutManager.VERTICAL,false);

                recyclerView.setLayoutManager(gridLayoutManager);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
            }
        });




        //        按钮杂志的点击事件
        Button rb_magazine = (Button) getActivity() .findViewById(R.id.button_magazine);
        rb_magazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBooksMag();
                RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3,LinearLayoutManager.VERTICAL,false);

                recyclerView.setLayoutManager(gridLayoutManager);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
            }
        });
        // TODO: Use the ViewModel
    }



    //以下是  按钮点击事件中调用的  初始化数据源的方法，共六个，等连接数据库后可以整合成一个方法
    private void initBooksNovel(){
        bookList.clear();
        for(int i = 0;i<3;i++){
            Book book1 = new Book("百年孤独",R.drawable.label_book_bainiangudu);
            bookList.add(book1);
            Book book3 = new Book("海边的卡夫卡",R.drawable.label_book_haibiandekafuka);
            bookList.add(book3);
            Book book4 = new Book("红楼梦",R.drawable.label_book_hongloumeng);
            bookList.add(book4);
            Book book5 = new Book("霍乱时期的爱情",R.drawable.label_book_huoluanshiqideaiqing);
            bookList.add(book5);
        }
    }

    private void initBooksEdu(){
        bookList.clear();
        for(int i =0;i < 6;i++){
            Book book1 = new Book("高等数学",R.drawable.label_book_gaodengshuxue);
            bookList.add(book1);
            Book book2 = new Book("大学物理",R.drawable.label_book_daxuewuli);
            bookList.add(book2);
        }
    }


    private void initBooksBiography(){
        bookList.clear();
        for(int i = 0; i<3 ; i++){
            Book book1 = new Book("梁启超传",R.drawable.label_book_liangqichaozhuan);
            bookList.add(book1);
            Book book2 = new Book("钱学森传",R.drawable.label_book_qianxuesengzhuan);
            bookList.add(book2);
            Book book3= new Book("莎士比亚传",R.drawable.label_book_shashibiyazhuan);
            bookList.add(book3);
            Book book4 = new Book("王阳明传",R.drawable.label_book_wangyangmingzhuan);
            bookList.add(book4);
        }
    }

    private void initBooksHis(){
        bookList.clear();
        for(int i =0;i < 5;i++){
            Book book1 = new Book("东周列国志",R.drawable.label_book_history_dongzhoulieguozhi);
            bookList.add(book1);
            Book book2 = new Book("全球通史",R.drawable.label_book_history_quanqiutongshi);
            bookList.add(book2);
        }
    }

    private void initBooksLiterary(){
        bookList.clear();
        for(int i =0;i < 6;i++){
            Book book1 = new Book("浮生六记",R.drawable.label_book_literary_fushengliuji);
            bookList.add(book1);
            Book book2 = new Book("朝花夕拾",R.drawable.label_book_literary_zhaohuaxishi);
            bookList.add(book2);
        }
    }

    private void initBooksMag(){
        bookList.clear();
        for(int i =0;i < 7;i++){
            Book book1 = new Book("读者文摘",R.drawable.label_book_magazine_duzhewenzhai);
            bookList.add(book1);
            Book book2 = new Book("青年文摘",R.drawable.label_book_magazine_qingnianwenzhai);
            bookList.add(book2);
        }
    }

}