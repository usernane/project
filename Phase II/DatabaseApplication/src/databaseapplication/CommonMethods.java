package databaseapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

public class CommonMethods {
	
	public Connection getConnection(){
	   try {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ibra5him","1415620.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
		
	}

	public JTable CreateTable(Connection conn,String query) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet r = s.executeQuery(query);
		
<<<<<<< HEAD
		while(r.next());
		
		JTable a = new JTable(r.getRow()+1,r.getMetaData().getColumnCount());
		a.setRowHeight(20);
		
		r = s.executeQuery(query);
		for(int i=0;i<a.getColumnCount();i++){//attributes
=======
		//while(r.next());//no need for this, just use r.last
		r.last();
		JTable a = new JTable(r.getRow()+1,r.getMetaData().getColumnCount());
		//r = s.executeQuery(query);//Also why you are executing the query again? no need to do that
		r.first();
		for(int i=0;i<a.getColumnCount();i++)//attributes
>>>>>>> origin/master
			a.setValueAt(r.getMetaData().getColumnLabel(i+1), 0, i);
			a.getColumnModel().getColumn(i).setPreferredWidth(r.getMetaData().getColumnLabel(i+1).length()*10);
		}
		
		for(int j=1;j<a.getRowCount();j++){
			r.next();	
			for(int i=0;i<a.getColumnCount();i++){
				a.setValueAt(r.getString(i+1), j, i);
				if(r.getString(i+1)!=null)
					if(a.getColumnModel().getColumn(i).getPreferredWidth()<r.getString(i+1).length()*10)
						a.getColumnModel().getColumn(i).setPreferredWidth(r.getString(i+1).length()*10);
			}
		}//for rows
		
		return a;//table
	}


}
