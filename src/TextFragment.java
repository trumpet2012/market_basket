import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.market_basket.R;

/**
 * William Trent Holliday
 * 2/5/15
 */
public class TextFragment extends Fragment {
    TextView text;
    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState){
        View view = inflator.inflate(R.layout.text_fragment, container,false);
        text = (TextView) view.findViewById(R.id.txt);
        String menu = getArguments().getString("Menu");
        text.setText(menu);
        return view;
    }
}
