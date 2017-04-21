package browserfilter.myclothes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private Button mSendData;
    private DatabaseReference mRef;
    private Button mAddImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
       mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://myclothes-d354f.firebaseio.com/"
       );
        mAddImage = (Button)findViewById(R.id.add);
        mAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addImage = new Intent(MainActivity.this, UploadImage.class);
                startActivity(addImage);

            }
        });

        mSendData= (Button)findViewById(R.id.sendData);
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mRefChild= mRef.child("Name");
                mRefChild.setValue("tiago");




            }
        });
    }
}
