package tools;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.example.login.R;

public class LoginTitleLayout extends LinearLayout {
    public LoginTitleLayout(Context context, AttributeSet attr) {
        super(context,attr);
        LayoutInflater.from(context).inflate(R.layout.login_title,this);
    }
}
