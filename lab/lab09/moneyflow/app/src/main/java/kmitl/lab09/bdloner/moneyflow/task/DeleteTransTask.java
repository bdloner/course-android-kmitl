package kmitl.lab09.bdloner.moneyflow.task;

import android.os.AsyncTask;

import kmitl.lab09.bdloner.moneyflow.MoneyFlowDB;
import kmitl.lab09.bdloner.moneyflow.model.Transaction;

public class DeleteTransTask extends AsyncTask<Transaction, Void, Void> {

    private MoneyFlowDB database;
    private OnDeleteSuccessListener listener;

    public DeleteTransTask(MoneyFlowDB db, OnDeleteSuccessListener l) {
        this.database = db;
        this.listener = l;
    }

    @Override
    protected Void doInBackground(Transaction... transactions) {
        for (int i = 0; i < transactions.length; i++) {
            database.transactionDAO().delete(transactions[i]);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.onDeleteSuccess();
    }

    public interface OnDeleteSuccessListener {
        void onDeleteSuccess();
    }
}
