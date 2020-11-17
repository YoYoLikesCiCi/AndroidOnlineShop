package com.example.onlineshop_v2.ui.labelbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshop_v2.MainActivity;
import com.example.onlineshop_v2.R;
import com.example.onlineshop_v2.ui.homepage.HomePageFragment;

import java.util.List;


//Book适配器
//用于将数据源的数据格式化，并传给recycler，最后在界面中展示

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mBook;

    static class ViewHolder extends RecyclerView.ViewHolder{      //商品适配器内部类声明
        View bookView;
        ImageView bookImage;
        TextView bookName;
        public ViewHolder(View view){               //内部类的构造方法
            super(view);
            bookView = view;
            bookImage = (ImageView) view.findViewById(R.id.book_image);
            bookName = (TextView) view.findViewById(R.id.book_name);
        }
    }

    public BookAdapter(List<Book> booklist){
        mBook = booklist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){    //方法：用于创建ViewHolder实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.label_book_item,parent,false);
        //inflate方法用于传入子项布局

        final ViewHolder holder = new ViewHolder(view);   //将子项布局传给内部类的构造方法

        //每个子项的点击事件
        holder.bookView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Book book = mBook.get(position);
                String bookname = (String) holder.bookName.getText();
                int bookimageid = holder.bookImage.getId();
//                Intent intent = new Intent(v.getContext(), HomePageFragment.class);
//                v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(),"点了一下"+book.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;              //将ViewHolder实例返回
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){  //方法：对子项数据进行赋值
        Book book = mBook.get(position);      //先逐个获得书籍列表
        holder.bookImage.setImageResource(book.getImageid());
        holder.bookName.setText(book.getName());
    }

    @Override
    public int getItemCount(){              //方法：返回数据源长度
        return mBook.size();
    }
}
