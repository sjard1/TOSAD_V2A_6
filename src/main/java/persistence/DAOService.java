package persistence;

import persistence.TargetDAO;
import persistence.ToolDAO;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yorick on 23/01/2018.
 */
public class DAOService {
    private ToolDAO tooldb = new ToolDAO();
    private TargetDAO targetdb;

    public DAOService(){
        tooldb.openConnection();
    }

    public void setTargetdb(String dbname,String username, String password, String url, String dbtype){
        targetdb = new TargetDAO(dbname, username, password, url, dbtype);
    }

    public HashMap<Integer, String> getTargetDatabases(){
        return tooldb.getTargetDatabases();
    }

    public ResultSet getBusinessRule(Integer id){
        return tooldb.getBusinessRule(id);
    }

    public List<String> getTargetTables(Integer id){
        HashMap<String, String> hm = tooldb.getTargetDatabase(id);
        setTargetdb(hm.get("DBNAME"), hm.get("USERNAME"), hm.get("PASSWORD"), hm.get("URL"), hm.get("TYPE"));
        return targetdb.getTables();
    }

    public void executeBusinessRule(String sql, TargetDAO targetdb){
        this.targetdb = targetdb;
        targetdb.executeBusinessRule(sql);
    }

    public boolean triggerExists(String triggername){
        return this.targetdb.triggerExists(triggername);
    }

    public void updateBusinessRule(int id, boolean executed){
        this.tooldb.updateBusinessRule(id, executed);
    }

    public HashMap<String, String> getTargetColumns(Integer dbid, String table){
        HashMap<String, String> hm = tooldb.getTargetDatabase(dbid);
        setTargetdb(hm.get("DBNAME"), hm.get("USERNAME"), hm.get("PASSWORD"), hm.get("URL"), hm.get("TYPE"));
        return targetdb.getColumns(table);
    }

}
