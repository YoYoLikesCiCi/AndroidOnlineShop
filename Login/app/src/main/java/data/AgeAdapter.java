package data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.login.R;

import java.util.List;

public class AgeAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> ageList;

    public AgeAdapter(Context context, List<Integer> ageList){
        this.context = context;
        this.ageList = ageList;
    }

    @Override
    public int getCount() {
        return ageList.size();
    }

    @Override
    public Object getItem(int position) {
        return ageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        return null;
    }
}
