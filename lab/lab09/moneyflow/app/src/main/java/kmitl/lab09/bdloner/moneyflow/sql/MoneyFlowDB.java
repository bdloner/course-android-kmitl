package kmitl.lab09.bdloner.moneyflow.sql;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import kmitl.lab09.bdloner.moneyflow.dao.TransactionDAO;
import kmitl.lab09.bdloner.moneyflow.model.Transaction;

@Database(entities = Transaction.class, version = 1)
public abstract class MoneyFlowDB extends RoomDatabase {

    public abstract TransactionDAO transactionDAO();

}
