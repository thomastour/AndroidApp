package gr.aueb.cf.widgetsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import gr.aueb.cf.widgetsapp.R;
import gr.aueb.cf.widgetsapp.models.Rooms;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Rooms> roomsArrayList;
    private ArrayList<Rooms> roomsArrayListFull;




    public MyAdapter(Context context, ArrayList<Rooms> roomsArrayList) {
        this.context = context;
        this.roomsArrayListFull = roomsArrayList;
        this.roomsArrayList = new ArrayList<>(roomsArrayListFull);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Rooms rooms = roomsArrayList.get(position);
        holder.heading.setText(rooms.getHeading());

    }

    @Override
    public int getItemCount() {
        return roomsArrayList.size();
    }

    @Override
    public Filter getFilter() {
        return roomsFilter;
    }

    private final Filter roomsFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Rooms> filteredArrayList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredArrayList.addAll(roomsArrayListFull);
            } else {
                String filteredPattern = constraint.toString().toLowerCase().trim();

                for (Rooms rooms : roomsArrayListFull) {
                    if (rooms.getHeading().toLowerCase().contains(filteredPattern)) {
                        filteredArrayList.add(rooms);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredArrayList;
            results.count = filteredArrayList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            roomsArrayList.clear();
            roomsArrayList.addAll((ArrayList<Rooms>) results.values);
            notifyDataSetChanged();
        }
    };



    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView heading;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
        }
    }
}
