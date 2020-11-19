package com.example.onlineshop_v2.ui.shoppingcart;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.onlineshop_v2.MainActivity;
import com.example.onlineshop_v2.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFragment extends Fragment {

    private ShoppingCartViewModel mViewModel;

    public static ShoppingCartFragment newInstance() {
        return new ShoppingCartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }

    private List<CBook> cBookList = new ArrayList<>();
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShoppingCartViewModel.class);
        // TODO: Use the ViewModel

        initCBooks();
        CBookAdapter adapter = new CBookAdapter(getContext(),R.layout.cart_book_item,cBookList);
        ListView listView = (ListView)getActivity().findViewById(R.id.cart_list);
        listView.setAdapter(adapter);

    }

//    Intent addcart = getIntent();
    private void initCBooks(){

        cBookList.clear();
        CBook book1 = new CBook("百年孤独","31",R.drawable.label_book_bainiangudu);
        cBookList.add(book1);
        CBook book2 = new CBook("读者文摘","37",R.drawable.label_book_magazine_duzhewenzhai);
        cBookList.add(book2);
    }

}