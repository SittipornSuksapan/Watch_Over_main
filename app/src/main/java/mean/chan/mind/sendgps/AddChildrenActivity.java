package mean.chan.mind.sendgps;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;

import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;




/**
 * Created by sittipornsuksapan on 6/14/2017 AD.
 */

public class AddChildrenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_children);

        initButtomBar();
    }

    private void initButtomBar(){

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {


                if (tabId == R.id.buttom_nav_item_home) {
                    Toast toast = Toast.makeText (AddChildrenActivity.this, "Home",
                            Toast.LENGTH_SHORT );
                    toast.show ();

                    startActivity(new Intent(AddChildrenActivity.this, MapsActivity.class));

                }
                else if (tabId == R.id.buttom_nav_item_child){
                    Toast toast = Toast.makeText (AddChildrenActivity.this, "Children",
                            Toast.LENGTH_SHORT );
                    toast.show ();

                }
                else if (tabId == R.id.buttom_nav_item_place) {
                    Toast toast = Toast.makeText(AddChildrenActivity.this, "Place",
                            Toast.LENGTH_SHORT);
                    toast.show();

                  //  startActivity(new Intent(AddChildrenActivity.this, FirstActivity.class));
                }
                else if (tabId == R.id.buttom_nav_item_contact) {
                    Toast toast = Toast.makeText(AddChildrenActivity.this, "Contact",
                            Toast.LENGTH_SHORT);
                    toast.show();

                    startActivity(new Intent(AddChildrenActivity.this, FirstActivity.class));
                }
                else if (tabId == R.id.buttom_nav_item_history) {
                    Toast toast = Toast.makeText(AddChildrenActivity.this, "History",
                            Toast.LENGTH_SHORT);
                    toast.show();


                }

            }
        });


    }
}
