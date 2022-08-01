package com.example.latinToKrill.service;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

/**
 * SQL function that allows using the full text search postgress operator (@@). The function also applies
 * to_tsvector and to_tsquery to its first and second arguments respectively.
 */
public class FullTextSearchFunction implements SQLFunction {
    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override
    public Type getReturnType(Type firstArgumentType, Mapping mapping) throws QueryException {
        return BooleanType.INSTANCE;
    }

    @Override
    public String render(Type firstArgumentType, List arguments, SessionFactoryImplementor factory) throws QueryException {
        if (arguments == null || arguments.size() != 2) {
            throw new IllegalArgumentException("Invalid number of parameters");
        }
        String searchColumn = (String) arguments.get(0);
        String searchTerm = (String) arguments.get(1);
        searchTerm = searchTerm.replaceAll("\\s+", " & ").replaceAll("'", "");
        searchTerm = StringUtils.stripAccents(searchTerm);
        return String.format("to_tsvector(%s) @@ plainto_tsquery(%s)", searchColumn, searchTerm);
    }
}
