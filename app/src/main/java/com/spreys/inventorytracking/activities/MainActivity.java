package com.spreys.inventorytracking.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spreys.inventorytracking.IViewHolderClickListener;
import com.spreys.inventorytracking.R;
import com.spreys.inventorytracking.data.InventoryDbHelper;
import com.spreys.inventorytracking.data.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static com.spreys.inventorytracking.activities.DetailsActivity.KEY_PRODUCT;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.activity_main_empty_view)
    TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        readDataFromDb();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.activity_main_add_product_button)
    public void addProduct() {
        Intent intent = new Intent(this, NewProductActivity.class);
        startActivity(intent);
    }

    private void readDataFromDb() {
        InventoryDbHelper dbHelper = new InventoryDbHelper(this);
        List<Product> products = dbHelper.getProducts();

        if (!products.isEmpty()) {
            recyclerView.setAdapter(new ProductsAdapter(products, this));
            emptyView.setVisibility(GONE);
        } else {
            emptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        readDataFromDb();
    }

    class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> implements IViewHolderClickListener {
        private List<Product> products;
        private Context context;

        public ProductsAdapter(List<Product> products, Context context) {
            this.products = products;
            this.context = context;
        }

        @Override
        public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false), this);
        }

        @Override
        public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
            Product product = products.get(position);

            holder.title.setText(product.getName());
            holder.quantity.setText(product.getQuantityDescription());
            holder.price.setText(product.getPriceDescription());
        }

        @Override
        public int getItemCount() {
            return products.size();
        }

        @Override
        public void onTrackSale(int itemPosition) {
            Product soldProduct = products.get(itemPosition);
            if (soldProduct.sellItem()) {
                notifyItemChanged(itemPosition);
                InventoryDbHelper dbHelper = new InventoryDbHelper(context);
                dbHelper.updateProduct(soldProduct);
            }
        }

        @Override
        public void onProductSelected(int itemPosition) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra(KEY_PRODUCT, products.get(itemPosition));
            startActivityForResult(intent, 0);
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            IViewHolderClickListener clickListener;

            @BindView(R.id.product_item_title)
            public TextView title;

            @BindView(R.id.product_item_price)
            public TextView price;

            @BindView(R.id.product_item_quantity)
            public TextView quantity;

            @OnClick(R.id.product_item_track_sale_button)
            public void sellItem() {
                clickListener.onTrackSale(getAdapterPosition());
            }

            @OnClick(R.id.product_item_frame)
            public void selectProduct() {
                clickListener.onProductSelected(getAdapterPosition());
            }

            public ViewHolder(View view, IViewHolderClickListener clickListener) {
                super(view);
                this.clickListener = clickListener;
                ButterKnife.bind(this, view);
            }
        }
    }
}
