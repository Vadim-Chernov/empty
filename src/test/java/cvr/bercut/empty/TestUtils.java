package cvr.bercut.empty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtils {

    public static String createUserSQL(long id, String name, String parole) {
        String ret = "insert into admin.base_object(id,name,description,dtype) \n";
        ret += "values(%d,'%s','','User'); \n";
        ret += "\n";
        ret += "insert into admin.user_object(id,role_id,parole)\n";
        ret += "values(%d,null,'%s');";
        String sql = String.format(ret, id, name, id, parole);
        return sql;
    }

    private Connection getConnection() throws SQLException {
        Connection testConnection;
        testConnection = TestConfig.dataSource().getConnection();
        return testConnection;
    }

    public void createUser(long id, String name, String parole) throws SQLException {
        Statement statement = getConnection().createStatement();
        String sql = TestUtils.createUserSQL(id, name, parole);
        statement.executeUpdate(sql);
    }

    public long allObjCount() throws SQLException {
        int count = 0;
        Statement statement = getConnection().createStatement();
        final ResultSet rs = statement.executeQuery("select count(*) as c from admin.base_object");
        while (rs.next()) {
            count = rs.getInt("c");
        }

        return count;
    }

}
