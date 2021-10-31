package rob.myappcompany.recyclerviewitemclickusinginterfaceadvanceddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface{

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    List<String> movieList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(movieList, this);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        movieList.add("Iron man");
        movieList.add("The Incredible Hulk");
        movieList.add("Iron Man 2");
        movieList.add("The Average");
        movieList.add("Iron Man 3");
        movieList.add("Ant-Man");
        movieList.add("Iron man 4");
        movieList.add("Doctor strong");
        movieList.add("Iron man");
        movieList.add("The Incredible Hulk");
        movieList.add("Iron Man 2");
        movieList.add("The Average");
        movieList.add("Iron Man 3");
        movieList.add("Ant-Man");
        movieList.add("Iron man 4");
        movieList.add("Doctor strong");

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                movieList.add("Black widow (2020)");
                movieList.add("The Eternals (2002)");
                movieList.add("Shang-chi");
                movieList.add("Doctor Strange in the Multiverse");
                movieList.add("Thor");

                recyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onItemClickInterface(int position) {
        Toast.makeText(this, movieList.get(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLongItemClickInterface(int position) {
        movieList.remove(position);
        recyclerAdapter.notifyItemRemoved(position);
    }
}