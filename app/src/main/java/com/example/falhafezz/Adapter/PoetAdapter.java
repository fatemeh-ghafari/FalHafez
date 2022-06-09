package com.example.falhafezz.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.falhafezz.R;
import com.example.falhafezz.model.Poet;

import java.util.List;

public class PoetAdapter extends RecyclerView.Adapter<PoetAdapter.PoetViewHolder> {

    private List<Poet> poets;
    private Context mContext;

    public PoetAdapter(Context context, List<Poet> poets) {
        this.mContext = context;
        this.poets = poets;
    }

    @Override
    public PoetAdapter.PoetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        return new PoetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PoetAdapter.PoetViewHolder holder, int position) {
        holder.bindPoets(poets.get(position));
    }

    @Override
    public int getItemCount() {
        return poets.size();
    }

    public class PoetViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        public TextView name, place, birth, death;

        public PoetViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pname);
            place = itemView.findViewById(R.id.pplace);
            birth = itemView.findViewById(R.id.pbirth);
            death = itemView.findViewById(R.id.pdeath);
            mContext = itemView.getContext();
        }

        public void bindPoets(Poet poet) {
            name.setText(" نام شاعر : " + poet.getName());
            place.setText(" زادگاه: " + poet.getBirthPlace());
            birth.setText(" تاریخ تولد: " + poet.getBirthYearInLHijri());
            death.setText(" تاریخ وفات: " + poet.getDeathYearInLHijri());
        }
    }
}

