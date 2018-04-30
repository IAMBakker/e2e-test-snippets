import datamodel.TestItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import postgres.PostgreSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectorTest {
    private PostgreSQL dbConnection;

    @BeforeEach
    public void setUp(){
        dbConnection = new PostgreSQL();
    }

    @Test
    public void connectToLocalDBTest() throws SQLException {

        Statement database = null;

        database = dbConnection.getConnection().createStatement();

        String sql = "CREATE TABLE TESTITEM " +
                "(ID INT PRIMARY KEY             NOT NULL," +
                " SEARCHTERM     VARCHAR(255)    NOT NULL, " +
                " TESTCLASS      VARCHAR(255)    NOT NULL, " +
                " TEXT           TEXT, " +
                " URL            TEXT, " +
                " DATE_CREATED   DATE            NOT NULL)";
        database.executeUpdate(sql);
        database.close();
        dbConnection.getConnection().close();
    }

    @Test
    public void insertIntoLocalDatabaseTest() throws SQLException {

        Statement database = dbConnection.getConnection().createStatement();
        dbConnection.getConnection().setAutoCommit(false);

        List<TestItem> items = new ArrayList<>();
        TestItem item = new TestItem(1, "'Cryptocurrency'", this.getClass().toString());
        item.setText("'Verge failing massively'");
        item.setUrl("'https://www.reddit.com/r/Buttcoin/comments/89tcx9/turns_out_the_verge_fiasco_is_worse_than_thought/'");
        items.add(item);

        TestItem item2 = new TestItem(2, "'Java'", this.getClass().toString());
        item2.setText("'Opinion on maven'");
        item2.setUrl("'https://blog.philipphauer.de/moving-back-from-gradle-to-maven/'");
        items.add(item2);

        TestItem item3 = new TestItem(3, "'Movies'", this.getClass().toString());
        item3.setText("'New beanie movie'");
        item3.setUrl("'https://www.youtube.com/watch?v=-Qv6p6pTz5I&feature=youtu.be'");
        items.add(item3);

        items.forEach(i -> {
            String insertStatement = "INSERT INTO TESTITEM (ID,SEARCHTERM,TESTCLASS,TEXT,URL) ";
            insertStatement += "VALUES ("
                    + i.getKey() + ", "
                    + i.getSearchTerm() + ", "
                    + wrapString(i.getTestClass()) + ", "
                    + i.getText() + ", "
                    + i.getUrl() + " );";
            try {
                database.executeUpdate(insertStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        database.close();
        dbConnection.getConnection().commit();
        dbConnection.getConnection().close();
    }

    private String wrapString(String s){
        return "'" + s + "'";
    }

    @Test
    public void selectID2Test() throws SQLException {
        Statement database = dbConnection.getConnection().createStatement();
        dbConnection.getConnection().setAutoCommit(false);

        ResultSet rs = database.executeQuery("SELECT * FROM TESTITEM WHERE ID = 2;");
        while(rs.next()){
            TestItem item2 = new TestItem(rs.getInt("id"),
                    rs.getString("searchterm"),
                    rs.getString("testclass"));
            item2.setUrl(rs.getString("url"));
            item2.setText(rs.getString("text"));

            System.out.println(item2.toString());
        }

        rs.close();
        database.close();
        dbConnection.getConnection().close();
    }

    @Test
    public void deleteID2Test() throws SQLException {
        Statement database = null;

        database = dbConnection.getConnection().createStatement();

        String sql = "DELETE from TESTITEM where ID = 2;;";
        database.executeUpdate(sql);
        database.close();
        dbConnection.getConnection().close();
    }

    @Test
    public void emptyTableTest() throws SQLException {
        Statement database = null;

        database = dbConnection.getConnection().createStatement();

        String sql = "TRUNCATE TABLE TESTITEM;";
        database.executeUpdate(sql);
        database.close();
        dbConnection.getConnection().close();
    }

    @Test
    public void dropTableTest() throws SQLException {
        Statement database = null;

        database = dbConnection.getConnection().createStatement();

        String sql = "DROP TABLE TESTITEM;";
        database.executeUpdate(sql);
        database.close();
        dbConnection.getConnection().close();
    }
}
