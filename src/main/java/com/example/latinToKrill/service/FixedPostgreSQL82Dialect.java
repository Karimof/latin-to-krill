package com.example.latinToKrill.service;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.IntegerType;
import org.hibernate.type.ObjectType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import java.sql.Types;

public class FixedPostgreSQL82Dialect extends PostgreSQL82Dialect {

    public FixedPostgreSQL82Dialect() {
        super();
        registerColumnType(Types.BLOB, "bytea");
        registerFunction("bit_and", new SQLFunctionTemplate(IntegerType.INSTANCE, "?1 & ?2"));
        registerFunction("now()", new SQLFunctionTemplate(StringType.INSTANCE, "now()"));
        registerFunction("fts", new FullTextSearchFunction());
        registerFunction("ts_rank", new StandardSQLFunction("ts_rank", StandardBasicTypes.DOUBLE));
        registerFunction("to_tsquery", new StandardSQLFunction("to_tsquery", ObjectType.INSTANCE));
        registerFunction("to_tsvector", new StandardSQLFunction("to_tsvector", ObjectType.INSTANCE));
    }

    @Override
    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
        if (sqlTypeDescriptor.getSqlType() == Types.BLOB) {
            return BinaryTypeDescriptor.INSTANCE;
        }
        return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
    }
}
