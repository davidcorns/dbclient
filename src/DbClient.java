import java.sql.*;
import java.util.ArrayList;
import java.io.DataInputStream;

public class DbClient {
	private Connection conn;

	public static class QueryResult extends ArrayList<Object[]> {}


	public static void setDriver(String driver)
		throws 	ClassNotFoundException, 
				InstantiationException, 
				IllegalAccessException 
	{
		Class.forName(driver).newInstance();
	}

	public DbClient(String url, String username, String password) throws Exception {
		this.conn = DriverManager.getConnection(url, username, password);
	}
	
	public synchronized QueryResult query(String expression) throws SQLException {
		final Statement st = conn.createStatement();
		final ResultSet rs = st.executeQuery(expression);
		final QueryResult res = dump(rs);

		 // NOTE!! if you close a statement the associated ResultSet is closed too
		st.close();

		return res;
	}

	private static QueryResult dump(ResultSet rs) throws SQLException {
		final int colmax = rs.getMetaData().getColumnCount();
		final QueryResult result = new QueryResult();

		while(rs.next()) {
			final Object[] row = new Object[colmax];
			for(int i=0; i<colmax; ++i) {
				row[i] = rs.getObject(i+1);
			}
			result.add(row);
		}

		return result;
	}

	public synchronized int execute(String expression) throws SQLException {
		Statement st = conn.createStatement();
		int res = st.executeUpdate(expression);
		st.close();

		return res;
	}


	public void disconnect() throws Exception {
		if(conn == null) return;

		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
		st.close();
		this.conn.close();
	}



	public static void main(String[] args) throws Exception {
		DbClient.setDriver("oracle.jdbc.driver.OracleDriver");

		final String url = "jdbc:oracle:thin:@localhost:1521";
		final String username = "david";
		final String password = "lky000011";

		final DbClient dbclient = new DbClient(url, username, password);
		final DataInputStream cin = new DataInputStream(System.in);
		
		while(true) {
			try {
				System.out.print("sql:> ");
				final String msg = cin.readLine();
				if(msg.equals("quit") || msg.equals("exit")) break;

				if(msg.toUpperCase().startsWith("SELECT")) {
					final QueryResult res = dbclient.query(msg);
					for(Object[] row: res) {
						for(Object obj: row) {
							System.out.print(obj.toString() + "\t");
						}
						System.out.print("\n");
					}
				}
				else {
					dbclient.execute(msg);
				}

				}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				System.out.println("");
			}
		}
	} //main

}	//DbClient

