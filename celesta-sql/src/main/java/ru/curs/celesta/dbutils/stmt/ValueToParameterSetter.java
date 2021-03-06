package ru.curs.celesta.dbutils.stmt;

import ru.curs.celesta.dbutils.QueryBuildingHelper;
import ru.curs.celesta.dbutils.filter.Range;

import java.sql.PreparedStatement;

/**
 * Created by ioann on 10.05.2017.
 */
public final class ValueToParameterSetter extends ParameterSetter {
  private final Range r;

  public ValueToParameterSetter(QueryBuildingHelper queryBuildingHelper, Range r) {
    super(queryBuildingHelper);
    this.r = r;
  }

  @Override
  public void execute(PreparedStatement stmt, int paramNum, Object[] rec, int recversion)  {
    setParam(stmt, paramNum, r.getValueTo());
  }

}
