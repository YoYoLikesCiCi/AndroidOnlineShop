package com.example.jindong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


//public class BookAdapter extends ArrayAdapter<Book>{
//    private int resourceId;
//    public BookAdapter(Context context,int textViewResourceId,List<Book> objects){
//        super(context,textViewResourceId,objects);
//        resourceId = textViewResourceId;
//    }
//
//    public View getView (int position, View convertView , ViewGroup parent){
//        Book book = getItem(position);
//        View view;
//        ViewHolder viewHolder;
//        if(convertView == null){
//            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//            viewHolder = new ViewHolder();
//            viewHolder.bookImage = (ImageView) view.findViewById(R.id.book_image);
//            viewHolder.bookName = (TextView) view.findViewById(R.id.book_name);
//            view.setTag(viewHolder);
//        }else{
//            view = convertView;
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        viewHolder.bookImage.setImageResource(book.getImageid());
//        viewHolder.bookName.setText(book.getName());
//        return view;
//
//    }
//
//    class ViewHolder{
//        ImageView bookImage;
//        TextView bookName;
//    }
//}





public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mBook;

    static class ViewHolder extends RecyclerView.ViewHolder{      //商品适配器内部类声明
        ImageView bookImage;
        TextView bookName;
        public ViewHolder(View view){               //内部类的构造方法
            super(view);
            bookImage = (ImageView) view.findViewById(R.id.book_image);
            bookName = (TextView) view.findViewById(R.id.book_name);
        }
    }

    public BookAdapter(List<Book> booklist){
        mBook = booklist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){    //方法：用于创建ViewHolder实例
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        //inflate方法用于传入子项布局

        ViewHolder holder = new ViewHolder(view);   //将子项布局传给内部类的构造方法
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
