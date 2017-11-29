package kmitl.lab09.bdloner.moneyflow;

import android.app.AlertDialog;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

import kmitl.lab09.bdloner.moneyflow.adapter.RecyclerItemClickListener;
import kmitl.lab09.bdloner.moneyflow.adapter.TransactionAdapter;
import kmitl.lab09.bdloner.moneyflow.model.Summary;
import kmitl.lab09.bdloner.moneyflow.model.Transaction;
import kmitl.lab09.bdloner.moneyflow.task.DeleteTransTask;
import kmitl.lab09.bdloner.moneyflow.task.FetchTransTask;
import kmitl.lab09.bdloner.moneyflow.task.SummaryTransTask;

public class MainActivity extends AppCompatActivity {

    private MoneyFlowDB database;

    private TextView textMoney;
    private RecyclerView list;
    private TransactionAdapter adapter;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void initInstances() {
        initDB();

        textMoney = findViewById(R.id.textMoney);
        list = findViewById(R.id.list);
        btnAdd = findViewById(R.id.btnAdd);

        adapter = new TransactionAdapter(this);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        list.addOnItemTouchListener(new RecyclerItemClickListener(this, list,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, final int position) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("แก้ไขรายการ?");
                        alertDialog.setMessage("คุณต้องการแก้ไขรายการใช่ไหม?");
                        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "ยกเลิก",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });

                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "แก้ไข",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        startTransactionActivity(adapter.getTransactionList().get(position));
                                        dialogInterface.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTransactionActivity(null);
            }
        });
    }

    private void initDB() {
        database = Room.databaseBuilder(getApplicationContext(), MoneyFlowDB.class, "DB")
                .fallbackToDestructiveMigration()
                .build();
    }

    private void startTransactionActivity(@Nullable Transaction transaction) {
        Intent intent = new Intent(MainActivity.this, TransactionActivity.class);
        intent.putExtra(Transaction.class.getSimpleName(), transaction);
        startActivity(intent);
    }

    private void fetchData() {
        new FetchTransTask(database, new FetchTransTask.OnFetchSuccessListener() {
            @Override
            public void onFetchSuccess(List<Transaction> transactionList) {
                updateList(transactionList);
            }
        }).execute();

        new SummaryTransTask(database, new SummaryTransTask.OnSummarySuccessListener() {
            @Override
            public void onSummarySuccess(Summary summary) {
                updateMoney(summary);
            }
        }).execute();
    }

    private void updateList(List<Transaction> transactionList) {
        if (transactionList.size() == 0) {
            list.setVisibility(View.GONE);
        } else {
            list.setVisibility(View.VISIBLE);
            adapter.setTransactionList(transactionList);
            adapter.notifyDataSetChanged();
        }
    }

    private void updateMoney(Summary summary) {
        int sum = summary.getSum();
        int totalIncome = summary.getTotalIncome();

        if ((float) sum / totalIncome <= 0.25) {
            textMoney.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        } else if ((float) sum / totalIncome <= 0.5) {
            textMoney.setTextColor(ContextCompat.getColor(this, android.R.color.holo_orange_light));
        } else {
            textMoney.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
        }
        textMoney.setText(NumberFormat.getNumberInstance().format(sum));
    }
}
