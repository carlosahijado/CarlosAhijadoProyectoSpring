package com.carlos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operaciones {

	public  Connection conexionmysql() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/regiones", "regiones", "regiones");
			System.out.println("Conexion correcta");

		} catch (ClassNotFoundException cn) {
			// cn.printStackTrace();
			System.out.println("ERROR DRIVER. " + cn.getMessage());
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("ERROR CONEXIÓN. " + e.getMessage());
		}
		return conexion;
	}
	
	public ArrayList<Regiones> listar(Connection cn)
	{
		ArrayList<Regiones> milista = new ArrayList<Regiones>();
		String consulta = "SELECT r.cod_region, r.nombre_re, count(o.oficina), SUM(o.total_ventas) FROM regiones r left join oficinas o on r.cod_region=o.cod_region GROUP BY r.cod_region, r.nombre_re";
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				Regiones reg = new Regiones(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
				milista.add(reg);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LAS REGIONES EN LA LISTA");
			// e.printStackTrace();
		}
		return milista;
	}
}
