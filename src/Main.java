import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
	
	public static void main(String[] args) {	
		//ingresarVendedor(7, "marcos",26, 89.3);
		//ingresarVendedor(8, "fernando",35, 120.65);
		consultarVendedor();
		ingresarVendedor(20,"juan",23,100.50);

	}
	
	public static void ingresarVendedor(int codigo_vendedor,String nombre,int edad,double ventas){
		Connection conn;
		String url="jdbc:postgresql://localhost:5432/vendedores";
		String usuario="postgres";
		String clave="1234";
		
		try {
			
			conn=DriverManager.getConnection(url, usuario, clave);
			PreparedStatement stm=conn.
			prepareStatement("INSERT INTO datosvendedor(codigo_vendedor, nombre,edad,ventas) VALUES (?, ?, ?, ?);");
			
			stm.setInt(1, codigo_vendedor);
			stm.setString(2, nombre);
			stm.setInt(3,edad);
			stm.setDouble(4, ventas);
			stm.execute();
			
			stm.close();
			conn.close();
			System.out.println("Ingreso exitoso (-.-)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void consultarVendedor(){
		Connection conn;
		String url="jdbc:postgresql://localhost:5432/vendedores";
		String usuario="postgres";
		String clave="1234";
		
		try {
			
			conn=DriverManager.getConnection(url, usuario, clave);
			Statement stm=conn.createStatement();
			ResultSet rs=stm.executeQuery("select*from datosvendedor");
			
			while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDouble(4));
				
			}
			rs.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
