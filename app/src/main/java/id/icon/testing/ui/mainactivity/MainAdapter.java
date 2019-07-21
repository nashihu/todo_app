package id.icon.testing.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.icon.testing.R;
import id.icon.testing.model.MainItem;
import id.icon.testing.ui.detailactivity.DetailActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MainItem> titles;
    private LayoutInflater layoutInflater;
    private Context context;

    public MainAdapter(Context context, List<MainItem> titles) {
        this.titles = titles;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.main_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = titles.get(i).getTitle();
        viewHolder.title.setText(title);
        final int position = i;
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class)
                .putExtra("title",titles.get(position).getTitle())
                .putExtra("desc",titles.get(position).getDesc()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_card);
            title = itemView.findViewById(R.id.item_title);
        }
    }
}
