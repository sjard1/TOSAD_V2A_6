package model;

import persistence.TargetDAO;

import java.util.List;

/**
 * Created by Yorick on 23/01/2018.
 */
public class BusinessRule {
    private Integer id;
    private String name;
    private BusinessRuleType ruleType;
    private List<Value> values;
    private List<Table> tables;
    private boolean executed;
    private TargetDAO targetdb;
    private String sql;

    public BusinessRule(Integer id, String name, BusinessRuleType ruleType, List<Value> values, List<Table> tables, boolean executed, TargetDAO targetdb, String sql) {
        this.id = id;
        this.name = name;
        this.ruleType = ruleType;
        this.values = values;
        this.tables = tables;
        this.executed = executed;
        this.targetdb = targetdb;
        this.sql = sql;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BusinessRuleType getRuleType() {
        return ruleType;
    }

    public List<Value> getValues() {
        return values;
    }

    public List<Table> getTables() {
        return tables;
    }

    public boolean isExecuted() {
        return executed;
    }

    public TargetDAO getTargetdb() {
        return targetdb;
    }

    public String getSql() {
        return sql;
    }
}
