package data.view;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import ru.curs.celesta.CallContext;
import ru.curs.celesta.ICelesta;
import ru.curs.celesta.dbutils.BasicCursor;
import ru.curs.celesta.dbutils.CursorIterator;
import ru.curs.celesta.dbutils.ParameterizedViewCursor;
import ru.curs.celesta.score.ColumnMeta;
import ru.curs.celesta.score.ParameterizedView;

@Generated(
        value = "ru.curs.celesta.plugin.maven.CursorGenerator",
        date = "2020-02-25T10:50:49"
)
public final class TestTablePvCursor extends ParameterizedViewCursor implements Iterable<TestTablePvCursor> {

    private static final String GRAIN_NAME = "test";
    private static final String OBJECT_NAME = "testTablePv";

    public final TestTablePvCursor.Columns COLUMNS;

    private Integer s;

    {
        this.COLUMNS = new TestTablePvCursor.Columns(callContext().getCelesta());
    }

    public TestTablePvCursor(CallContext context, Map<String, Object> parameters) {
        super(context, parameters);
    }

    public TestTablePvCursor(CallContext context, Map<String, Object> parameters, ColumnMeta<?>... columns) {
        super(context, parameters, columns);
    }

    @Deprecated
    public TestTablePvCursor(CallContext context, Set<String> fields, Map<String, Object> parameters) {
        super(context, fields, parameters);
    }

    public Integer getS() {
        return this.s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    @Override
    protected Object _getFieldValue(String name) {
        try {
            Field f = getClass().getDeclaredField(name);

            f.setAccessible(true);
            return f.get(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void _setFieldValue(String name, Object value) {
        try {
            Field f = getClass().getDeclaredField(name);

            f.setAccessible(true);
            f.set(this, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void _parseResult(ResultSet rs) throws SQLException {
        if (this.inRec("s")) {
            this.s = rs.getInt("s");
            if (rs.wasNull()) {
                this.s = null;
            }
        }
    }

    @Override
    public void _clearBuffer(boolean withKeys) {
        this.s = null;
    }

    @Override
    public Object[] _currentValues() {
        Object[] result = new Object[1];
        result[0] = this.s;
        return result;
    }

    @Override
    public TestTablePvCursor _getBufferCopy(CallContext context, List<String> fields) {
        final TestTablePvCursor result;

        if (Objects.isNull(fields)) {
            result = new TestTablePvCursor(context, this.parameters);
        } else {
            result = new TestTablePvCursor(context, new LinkedHashSet<>(fields), this.parameters);
        }
        result.copyFieldsFrom(this);
        return result;
    }

    @Override
    public void copyFieldsFrom(BasicCursor c) {
        TestTablePvCursor from = (TestTablePvCursor)c;
        this.s = from.s;
    }

    @Override
    public Iterator<TestTablePvCursor> iterator() {
        return new CursorIterator<TestTablePvCursor>(this);
    }

    @Override
    protected String _grainName() {
        return GRAIN_NAME;
    }

    @Override
    protected String _objectName() {
        return OBJECT_NAME;
    }

    @SuppressWarnings("unchecked")
    @Generated(
            value = "ru.curs.celesta.plugin.maven.CursorGenerator",
            date = "2020-02-25T10:50:49"
    )
    public static final class Columns {
        private final ParameterizedView element;

        public Columns(ICelesta celesta) {
            this.element = celesta.getScore().getGrains().get(GRAIN_NAME).getElements(ParameterizedView.class).get(OBJECT_NAME);
        }

        public ColumnMeta<Integer> s() {
            return (ColumnMeta<Integer>) this.element.getColumns().get("s");
        }
    }

}
