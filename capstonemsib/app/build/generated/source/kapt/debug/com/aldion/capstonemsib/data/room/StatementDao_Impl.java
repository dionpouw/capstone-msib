package com.aldion.capstonemsib.data.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.aldion.capstonemsib.data.entity.Statement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StatementDao_Impl implements StatementDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Statement> __insertionAdapterOfStatement;

  public StatementDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStatement = new EntityInsertionAdapter<Statement>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `statement_table` (`id`,`optA`,`optB`,`optC`,`optD`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Statement value) {
        stmt.bindLong(1, value.getId());
        if (value.getOptA() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOptA());
        }
        if (value.getOptB() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOptB());
        }
        if (value.getOptC() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOptC());
        }
        if (value.getOptD() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOptD());
        }
      }
    };
  }

  @Override
  public void insert(final Statement statement) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStatement.insert(statement);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Statement>> getAllStatement() {
    final String _sql = "SELECT * FROM statement_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"statement_table"}, false, new Callable<List<Statement>>() {
      @Override
      public List<Statement> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOptA = CursorUtil.getColumnIndexOrThrow(_cursor, "optA");
          final int _cursorIndexOfOptB = CursorUtil.getColumnIndexOrThrow(_cursor, "optB");
          final int _cursorIndexOfOptC = CursorUtil.getColumnIndexOrThrow(_cursor, "optC");
          final int _cursorIndexOfOptD = CursorUtil.getColumnIndexOrThrow(_cursor, "optD");
          final List<Statement> _result = new ArrayList<Statement>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Statement _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpOptA;
            if (_cursor.isNull(_cursorIndexOfOptA)) {
              _tmpOptA = null;
            } else {
              _tmpOptA = _cursor.getString(_cursorIndexOfOptA);
            }
            final String _tmpOptB;
            if (_cursor.isNull(_cursorIndexOfOptB)) {
              _tmpOptB = null;
            } else {
              _tmpOptB = _cursor.getString(_cursorIndexOfOptB);
            }
            final String _tmpOptC;
            if (_cursor.isNull(_cursorIndexOfOptC)) {
              _tmpOptC = null;
            } else {
              _tmpOptC = _cursor.getString(_cursorIndexOfOptC);
            }
            final String _tmpOptD;
            if (_cursor.isNull(_cursorIndexOfOptD)) {
              _tmpOptD = null;
            } else {
              _tmpOptD = _cursor.getString(_cursorIndexOfOptD);
            }
            _item = new Statement(_tmpId,_tmpOptA,_tmpOptB,_tmpOptC,_tmpOptD);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
