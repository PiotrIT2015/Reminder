package admin.pp.reminder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class MainActivity extends AppCompatActivity{
    Button btn1, events;
    EditText addShopping;
    EditText list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        addShopping=(EditText)findViewById(R.id.addShopping);
        list=(EditText)findViewById(R.id.list);
        btn1=(Button)findViewById(R.id.add);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                list.setText(Query("SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer"));
                Query("INSERT INTO SalesLT.Product (Name, ProductNumber, Color, StandardCost, ListPrice, SellStartDate) VALUES "
                        + addShopping.getText());
            }
        });
        events=(Button)findViewById(R.id.Events);
        events.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent browsIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prochnicki.yum.pl/Nano.php"));
                startActivity(browsIntent2);
            }
        });
    }

    String Query(String query) {
        String connectionString =
                "jdbc:sqlserver://sqlserverapp.database.windows.net:1433;"
                        + "database=database1;"
                        + "user=Gekon@sqlserverapp.database.windows.net;"
                        + "password=pass;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate=*.database.windows.net;"
                        + "loginTimeout=30;";
        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String selectSql = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            // Create and execute a SELECT SQL statement.
            selectSql = query;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " "
                        + resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connections after the data has been handled.
            if (resultSet != null) try {
                resultSet.close();
            } catch (Exception e) {
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
            }
        }

        return selectSql;
    }




}













