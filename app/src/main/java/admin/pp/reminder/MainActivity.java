package admin.pp.reminder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
<<<<<<< HEAD

=======
import java.sql.SQLException;
>>>>>>> ff58cace025467ee4077eaf3494dbadffe3f31d5
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.sql.Statement;
import java.sql.PreparedStatement;


<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {

    Button btn1, events;
    EditText addShopping;
    EditText shoppingList;
=======
public class MainActivity extends AppCompatActivity{

    Button btn1, events;
    EditText dodajZakup;
    EditText listaZakupow;
>>>>>>> ff58cace025467ee4077eaf3494dbadffe3f31d5

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

<<<<<<< HEAD
    private void init() {
        addShopping = (EditText) findViewById(R.id.addShopping);
        shoppingList = (EditText) findViewById(R.id.list);
        btn1 = (Button) findViewById(R.id.add);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingList.setText(Query("SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer"));
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query("INSERT INTO SalesLT.Product (Name, ProductNumber, Color, StandardCost, ListPrice, SellStartDate) VALUES " + addShopping.getText());
            }
        });
        events = (Button) findViewById(R.id.Events);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
=======
    private void init(){
        dodajZakup=(EditText)findViewById(R.id.dodajZakup);
        listaZakupow=(EditText)findViewById(R.id.lista);
        btn1=(Button)findViewById(R.id.dodaj);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listaZakupow.setText(SelectQuery());
            }
        });
        events=(Button)findViewById(R.id.Events);
        events.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
>>>>>>> ff58cace025467ee4077eaf3494dbadffe3f31d5
                Intent browsIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prochnicki.yum.pl/Nano.php"));
                startActivity(browsIntent2);
            }
        });
    }

<<<<<<< HEAD
    String Query(String query) {
=======
    String SelectQuery() {
>>>>>>> ff58cace025467ee4077eaf3494dbadffe3f31d5
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
<<<<<<< HEAD
            selectSql = query;
=======
            selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
>>>>>>> ff58cace025467ee4077eaf3494dbadffe3f31d5
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

<<<<<<< HEAD


=======
    void InsertQuery() {
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
        PreparedStatement prepsInsertProduct = null;

        try {
            connection = DriverManager.getConnection(connectionString);

            // Create and execute an INSERT SQL prepared statement.
            String insertSql = "INSERT INTO SalesLT.Product (Name, ProductNumber, Color, StandardCost, ListPrice, SellStartDate) VALUES "
                    + "('NewBike', 'BikeNew', 'Blue', 50, 120, '2016-01-01');";

            prepsInsertProduct = connection.prepareStatement(
                    insertSql,
                    Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();

            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connections after the data has been handled.
            if (prepsInsertProduct != null) try {
                prepsInsertProduct.close();
            } catch (Exception e) {
            }
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
    }
>>>>>>> ff58cace025467ee4077eaf3494dbadffe3f31d5


}













