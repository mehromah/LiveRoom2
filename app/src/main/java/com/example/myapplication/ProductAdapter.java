package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.model.PRSMBL003;
import com.example.myapplication.model.PRSMBL004;
import com.example.myapplication.model.PRSMBL005;
import com.example.myapplication.model.api.JsonResponse;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<JsonResponse> jsonResponses;
    private List<PRSMBL003> Table;
    private List<PRSMBL004> Table1;
    private List<PRSMBL005> Table2;

    public ProductAdapter(List<PRSMBL003> Table, List<PRSMBL004> Table1, List<PRSMBL005> Table2) {
        this.Table = Table;
        this.Table1 = Table1;
        this.Table2 = Table2;
    }

    public ProductAdapter(MainActivity mainActivity) {

    }



    void setProduct(List<JsonResponse> jsonResponses) {
        this.jsonResponses = jsonResponses;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prsmbl003, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Picasso.get().load("http://37.191.82.13:6139/images/" + Table.get(position).getCMBL003010() + ".jpg").into(holder.PRSMBL003ImageView);
        holder.PRSMBL003TitleTextView.setText(Table.get(position).getCMBL003011());
        holder.PRSMBL003StockTextView.setText(Table.get(position).getNMBL003015());
        holder.PRSMBL003GroupNameTextView.setText(Table.get(position).getCMBL003016());
        holder.PRSMBL004UnitTextView.setText(Table1.get(position).getCMBL004012());
        holder.PRSMBL005FeeTextView.setText(Table2.get(position).getNMBL005011());

    }

    @Override
    public int getItemCount() {
        return Table.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {


        private ImageView PRSMBL003ImageView;
        private TextView PRSMBL003TitleTextView;
        private TextView PRSMBL003StockTextView;
        private TextView PRSMBL003GroupNameTextView;
        private TextView PRSMBL004UnitTextView;
        private TextView PRSMBL005FeeTextView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            PRSMBL003ImageView = itemView.findViewById(R.id.iv_prsmbl003_image);
            PRSMBL003TitleTextView = itemView.findViewById(R.id.tv_prsmbl003_title);
            PRSMBL003StockTextView = itemView.findViewById(R.id.tv_prsmbl003_stock);
            PRSMBL003GroupNameTextView = itemView.findViewById(R.id.tv_prsmbl003_groupName);
            PRSMBL004UnitTextView = itemView.findViewById(R.id.tv_prsmbl004_unit);
            PRSMBL005FeeTextView = itemView.findViewById(R.id.tv_prsmbl005_fee);
        }
    }
}
