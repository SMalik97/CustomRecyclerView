package com.raymedicinecorner.customrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        String[] postTitle={"item1","item2","item3","item4","item5","item6","item7","item8","item9","item10","item11","item12","item13","item14","item15","item16"};
        String[] postSubtitle={"Sitem1","Sitem2","Sitem3","Sitem4","Sitem5","Sitem6","Sitem7","Sitem8","Sitem9","Sitem10","Sitem11","Sitem12","Sitem13","Sitem14","Sitem15","Sitem8"};

        DataAdapter adpt=new DataAdapter(postTitle,postSubtitle);
        recyclerView.setAdapter(adpt);

    }






    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private String[] postTitle;
        private String[] postSubtitle;

        public DataAdapter(String[] postTitle,String[] postSubtitle) {
            this.postTitle = postTitle ;
            this.postSubtitle = postSubtitle ;
        }

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

            viewHolder.ntitle.setText(postTitle[i]);
            viewHolder.nstitle.setText(postSubtitle[i]);
        }

        @Override
        public int getItemCount() {
            return 16;
        }//return size of array

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView ntitle,nstitle;
            public ViewHolder(View view) {
                super(view);

                ntitle = (TextView)view.findViewById(R.id.ntitle);
                nstitle = (TextView)view.findViewById(R.id.nstitle);
            }
        }

    }

}
