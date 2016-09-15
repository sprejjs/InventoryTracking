package com.spreys.inventorytracking;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spreys.inventorytracking.data.MockDataProvider;
import com.spreys.inventorytracking.data.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductsAdapter(MockDataProvider.GetMockData(), this));
    }

    class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
        private List<Product> products;
        private Context context;

        public ProductsAdapter(List<Product> products, Context context) {
            this.products = products;
            this.context = context;
        }


        @Override public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false));
        }

        @Override public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
            Product product = products.get(position);

            holder.title.setText(product.getName());
            holder.quantity.setText(product.getQuantityDescription());
            holder.price.setText(product.getPriceDescription());
        }

        @Override public int getItemCount() {
            return products.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.product_item_title)
            public TextView title;

            @BindView(R.id.product_item_price)
            public TextView price;

            @BindView(R.id.product_item_quantity)
            public TextView quantity;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }
}
