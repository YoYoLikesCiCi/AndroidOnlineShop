package com.example.jindong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class LableActivity extends AppCompatActivity {

//    private String[] novel = {"平凡的世界","远大前程","百年孤独","北欧众神","了不起的盖茨比","挪威的森林","海边的卡夫卡","霍乱时期的爱情","伊豆的舞女",
//            "人间失格","秘密","解忧杂货店","活着","许三观卖血记","麦田的守望者","月亮与六便士","小王子",
//            "三国演义","红楼梦","西游记"};
//    private String[] edu = {"接力题典1800","考研真相","王道数据结构","高数18讲","复习全书","高分写作",
//            "高等数学","大学物理","模拟电子技术","数字电子技术","算法设计","web前端","C语言程序设计","红宝书","蓝宝书","科技英语",
//            "五年高考三年模拟","王后雄教辅导","恋恋有词"};
    private RadioGroup rg_main_label;
    private List<Book> bookList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        rg_main_label = (RadioGroup) findViewById(R.id.rg_main);
        rg_main_label.check(R.id.rb_type);

        RadioGroup rg_label = (RadioGroup) findViewById(R.id.rg_label);
//        rg_label.check(R.id.button_novel);





//小说分类按钮的点击事件
        Button rb_novel = (Button) findViewById(R.id.button_novel);
        rb_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(         //适配器中一次传入  上下文，ListView子项布局，数据
//                        LableActivity.this,android.R.layout.simple_list_item_1,novel);
//                ListView listView = (ListView) findViewById(R.id.list_items);        //新建ListView指向布局文件中的ListView
//                listView.setAdapter(adapter);                   //将新建的适配器对象传入listView


//              LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//                StaggeredGridLayoutManager layoutManager = new
//                        StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

//                for (;button_novel_click<1;button_novel_click++){
                    initBooksNovel();
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_view);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(LableActivity.this,3,LinearLayoutManager.VERTICAL,false);

                    recyclerView.setLayoutManager(gridLayoutManager);
//                BookAdapter adapter = new BookAdapter(LableActivity.this,R.layout.book_item,bookList);
                    BookAdapter adapter = new BookAdapter(bookList);
                    recyclerView.setAdapter(adapter);
//                }

            }
        });


//        教育分类的点击事件
        Button rb_edu = (Button) findViewById(R.id.button_education);
        rb_edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(         //适配器中一次传入  上下文，ListView子项布局，数据
//                        LableActivity.this,android.R.layout.simple_list_item_1,edu);
//                ListView listView = (ListView) findViewById(R.id.list_items);        //新建ListView指向布局文件中的ListView
//                listView.setAdapter(adapter);                   //将新建的适配器对象传入listView
//                for (;button_edu_click<1;button_edu_click++){
                    initBooksEdu();
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_view);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(LableActivity.this,3,LinearLayoutManager.VERTICAL,false);

                    recyclerView.setLayoutManager(gridLayoutManager);
//                BookAdapter adapter = new BookAdapter(LableActivity.this,R.layout.book_item,bookList);
                    BookAdapter adapter = new BookAdapter(bookList);
                    recyclerView.setAdapter(adapter);
//                }


            }
        });


        Button rb_biography = (Button) findViewById(R.id.button_biography);
        rb_biography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(         //适配器中一次传入  上下文，ListView子项布局，数据
//                        LableActivity.this,android.R.layout.simple_list_item_1,edu);
//                ListView listView = (ListView) findViewById(R.id.list_items);        //新建ListView指向布局文件中的ListView
//                listView.setAdapter(adapter);                   //将新建的适配器对象传入listView
//                for (;button_edu_click<1;button_edu_click++){
                initBooksBiography();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_view);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(LableActivity.this,3,LinearLayoutManager.VERTICAL,false);

                recyclerView.setLayoutManager(gridLayoutManager);
//                BookAdapter adapter = new BookAdapter(LableActivity.this,R.layout.book_item,bookList);
                BookAdapter adapter = new BookAdapter(bookList);
                recyclerView.setAdapter(adapter);
//                }


            }
        });


    }




    private void initBooksNovel(){
        bookList.clear();
        Book book1 = new Book("百年孤独",R.drawable.book_bainiangudu);
        bookList.add(book1);
        Book book2 = new Book("北欧众神",R.drawable.book_beiouzhongshen);
        bookList.add(book2);
        Book book3 = new Book("海边的卡夫卡",R.drawable.book_haibiandekafuka);
        bookList.add(book3);
        Book book4 = new Book("红楼梦",R.drawable.book_hongloumeng);
        bookList.add(book4);
        Book book5 = new Book("霍乱时期的爱情",R.drawable.book_huoluanshiqideaiqing);
        bookList.add(book5);
        Book book6 = new Book("活着",R.drawable.book_huozhe);
        bookList.add(book6);
        Book book7 = new Book("解忧杂货店",R.drawable.book_jieyouzahuodian);
        bookList.add(book7);
        Book book8 = new Book("了不起的盖茨比",R.drawable.book_liaobuqidegaicibi);
        bookList.add(book8);
        Book book9 = new Book("麦田里的守望者",R.drawable.book_maitiandeshouwangzhe);
        bookList.add(book9);
        Book book10 = new Book("秘密",R.drawable.book_mimi);
        bookList.add(book10);
        Book book11 = new Book("挪威的森林",R.drawable.book_nuoweidesenglin);
        bookList.add(book11);
        Book book12 = new Book("平凡的世界",R.drawable.book_pingfandeshijie);
        bookList.add(book12);
        Book book13 = new Book("人间失格",R.drawable.book_renjianshige);
        bookList.add(book13);
        Book book14 = new Book("三国演义",R.drawable.book_sanguoyanyi);
        bookList.add(book14);
        Book book15 = new Book("小王子",R.drawable.book_xiaowangzi);
        bookList.add(book15);
        Book book16 = new Book("西游记",R.drawable.book_xiyouji);
        bookList.add(book16);
        Book book17 = new Book("许三观卖血记",R.drawable.book_xusanguanmaixueji);
        bookList.add(book17);
        Book book18 = new Book("伊豆的舞女",R.drawable.book_yidoudewunv);
        bookList.add(book18);
        Book book19 = new Book("远大前程",R.drawable.book_yuandaqiancheng);
        bookList.add(book19);
        Book book20 = new Book("月亮与六便士",R.drawable.book_yueliangyuliubianshi);
        bookList.add(book20);
    }


    private void initBooksEdu(){
        bookList.clear();
        for(int i =0;i < 6;i++){
            Book book1 = new Book("高等数学",R.drawable.book_gaodengshuxue);
            bookList.add(book1);
            Book book2 = new Book("大学物理",R.drawable.book_daxuewuli);
            bookList.add(book2);
        }
    }


    private void initBooksBiography(){
        bookList.clear();
        for(int i = 0; i<3 ; i++){
            Book book1 = new Book("梁启超传",R.drawable.book_liangqichaozhuan);
            bookList.add(book1);
            Book book2 = new Book("钱学森传",R.drawable.book_qianxuesengzhuan);
            bookList.add(book2);
            Book book3= new Book("莎士比亚传",R.drawable.book_shashibiyazhuan);
            bookList.add(book3);
            Book book4 = new Book("王阳明传",R.drawable.book_wangyangmingzhuan);
            bookList.add(book4);
        }

    }


}