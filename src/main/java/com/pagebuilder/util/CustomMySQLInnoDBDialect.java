package com.pagebuilder.util;

import org.hibernate.dialect.MySQLInnoDBDialect;

public class CustomMySQLInnoDBDialect extends MySQLInnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin";
    }
}
