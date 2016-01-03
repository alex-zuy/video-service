package org.pirat9600q.configs;

import org.atteo.evo.inflector.English;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import com.google.common.base.CaseFormat;

public class LowerUnderscoreNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if(name == null) {
            return Identifier.toIdentifier("");
        }
        else {
            return lowerCamelToLowerUnderscore(name);
        }
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return lowerCamelToLowerUnderscore(name);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        String lowerUnderscore = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name.getText());
        String pluralized = English.plural(lowerUnderscore);
        return Identifier.toIdentifier(pluralized, name.isQuoted());
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return lowerCamelToLowerUnderscore(name);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return lowerCamelToLowerUnderscore(name);
    }

    private static Identifier lowerCamelToLowerUnderscore(Identifier name) {
        String text = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name.getText());
        return Identifier.toIdentifier(text, name.isQuoted());
    }
}
