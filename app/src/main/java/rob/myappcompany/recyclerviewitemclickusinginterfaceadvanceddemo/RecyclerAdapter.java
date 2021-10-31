package rob.myappcompany.recyclerviewitemclickusinginterfaceadvanceddemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{


    private static final String TAG = "Recycler Adapter";
    List<String> movieList;
    private RecyclerViewClickInterface recyclerViewClickInterface;

    public RecyclerAdapter(List<String> movieList, RecyclerViewClickInterface recyclerViewClickInterface1) {
        this.movieList = movieList;
        this.recyclerViewClickInterface = recyclerViewClickInterface1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.rowTextView.setText(String.valueOf(position));
        holder.textView.setText(movieList.get(position));

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView, rowTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            rowTextView = itemView.findViewById(R.id.rowTextView);
            textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClickInterface(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //movieList.remove(getAdapterPosition());
                    //notifyItemRemoved(getAdapterPosition());
                    recyclerViewClickInterface.onLongItemClickInterface(getAdapterPosition());
                    return false;
                }
            });
        }

    }
}
