package com.CBRCount.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Connection {

	public static Connection con = null;

	static final String UserName_Node50 = "authuser";
	private static final String Password_Node50 = "authuser";
	private static final String ConnectionString_Node50 = "jdbc:oracle:thin:@bp-dbrac01-q-scan.gxsonline.net:1521/qa_n50_s";
	private static final String UserName_Node10 = "edidev";
	private static final String Password_Node10 = "edidev";
	private static final String ConnectionString_Node10 = "jdbc:oracle:thin:@lit-dbrac03-scan.qa.gxsonline.net:1521/qa_10cr_s";
	private static final String UserName_Node14 = "edidev";
	private static final String Password_Node14 = "edidev";
	private static final String ConnectionString_Node14 = "jdbc:oracle:thin:@lit-dbrac01-q002.qa.gxsonline.net:1521:qlos142";

	public static ResultSet getDBConnection(final String Query) throws Exception {
		final int i = 0;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(ConnectionString_Node50, UserName_Node50, Password_Node50);

		final Statement stmt = con.createStatement();

		final ResultSet executeQuery = stmt.executeQuery(DBQueryList.getQuery(Query));

		// while (executeQuery.next()) {

		// i=executeQuery.getInt("count");
		// }
		// String count =executeQuery.getString(0);

		return executeQuery;

	}

	public String prinusername() {
		return UserName_Node50;
	}
}
