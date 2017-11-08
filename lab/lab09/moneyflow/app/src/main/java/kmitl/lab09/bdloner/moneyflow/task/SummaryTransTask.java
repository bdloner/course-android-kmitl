package kmitl.lab09.bdloner.moneyflow.task;

import android.os.AsyncTask;

import kmitl.lab09.bdloner.moneyflow.sql.MoneyFlowDB;
import kmitl.lab09.bdloner.moneyflow.model.Summary;

public class SummaryTransTask extends AsyncTask<Void, Void, Summary> {

    private MoneyFlowDB database;
    private OnSummarySuccessListener listener;

    public SummaryTransTask(MoneyFlowDB db, OnSummarySuccessListener l) {
        this.database = db;
        this.listener = l;
    }

    @Override
    protected Summary doInBackground(Void... voids) {
        return database.transactionDAO().getSummary();
    }

    @Override
    protected void onPostExecute(Summary summary) {
        super.onPostExecute(summary);
        listener.onSummarySuccess(summary);
    }

    public interface OnSummarySuccessListener {
        void onSummarySuccess(Summary summary);
    }
}
