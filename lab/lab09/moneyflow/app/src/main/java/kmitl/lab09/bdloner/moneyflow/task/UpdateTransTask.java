package kmitl.lab09.bdloner.moneyflow.task;

import android.os.AsyncTask;

import kmitl.lab09.bdloner.moneyflow.sql.MoneyFlowDB;
import kmitl.lab09.bdloner.moneyflow.model.Transaction;

public class UpdateTransTask extends AsyncTask<Transaction, Void, Void> {

    private MoneyFlowDB database;
    private OnUpdateSuccessListener listener;

    public UpdateTransTask(MoneyFlowDB db, OnUpdateSuccessListener l) {
        this.database = db;
        this.listener = l;
    }

    @Override
    protected Void doInBackground(Transaction... transactions) {
        for (int i = 0; i < transactions.length; i++) {
            database.transactionDAO().update(transactions[i]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onUpdateSuccess();
    }

    public interface OnUpdateSuccessListener {
        void onUpdateSuccess();
    }
}
