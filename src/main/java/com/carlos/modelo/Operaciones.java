package com.carlos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			System.out.println("ERROR CONEXI�N. " + e.getMessage());
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
	
	public ArrayList<Oficinas> listaroficinas(Connection cn)
	{
		ArrayList<Oficinas> listaoficinas = new ArrayList<Oficinas>();
		String consulta = "SELECT oficinas.OFICINA, oficinas.CIUDAD, regiones.nombre_re AS REGION, COUNT(repventas.numero_rep) AS NUMREP, director.nombre AS DIRECTOR "
				+ "FROM oficinas "
				+ "INNER JOIN regiones ON oficinas.cod_region = regiones.cod_region "
				+ "LEFT JOIN repventas ON oficinas.oficina = repventas.oficina_rep "
				+ "LEFT JOIN repventas director ON oficinas.director = director.numero_rep "
				+ "GROUP BY oficinas.oficina, oficinas.ciudad, regiones.nombre_re, director.nombre";
		
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				Oficinas ofi = new Oficinas(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5));
				listaoficinas.add(ofi);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LAS OFICINAS EN LA LISTA");
			// e.printStackTrace();
		}
		return listaoficinas;
	}
	
	public String insertar(Repventas rep, Connection cn)
	{
		String mensaje="";
		String consulta = "insert into repventas (numero_rep, nombre, edad, oficina_rep, director, num_ventas, imp_ventas) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement sent = cn.prepareStatement(consulta);
			sent.setInt(1, rep.getNumero_rep());
			sent.setString(2, rep.getNombre());
			sent.setInt(3, rep.getEdad());
			sent.setInt(4, rep.getOficina_rep());
			sent.setInt(5, rep.getDirector());
			sent.setInt(6, rep.getNum_ventas());
			sent.setDouble(7, rep.getImp_ventas());
			int res = sent.executeUpdate();
			mensaje = "<h2>Registro insertado correctamente</h2>";
			sent.close();

		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LOS REPRESENTANTES EN LA LISTA");
			mensaje = "<h2>ERROR AL CARGAR LOS REPRESENTANTES EN LA LISTA</h2>";
			// e.printStackTrace();
		}
		return mensaje;
	}
	
	public ArrayList<Repventas> listarrepresentantes(Connection cn)
	{
		ArrayList<Repventas> listarep = new ArrayList<Repventas>();
		String consulta = "SELECT * FROM repventas";
		
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				Repventas rep = new Repventas(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getDouble(7));
				listarep.add(rep);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LOS REPRESENTANTES EN LA LISTA");
			// e.printStackTrace();
		}
		return listarep;
	}
	
	public ArrayList<Integer> listarnombreoficinas(Connection cn)
	{
		ArrayList<Integer> listaoficinas = new ArrayList<Integer>();
		String consulta = "SELECT oficina FROM oficinas";
		
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				int ofi = res.getInt("oficina");
				listaoficinas.add(ofi);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LAS OFICINAS EN LA LISTA");
			// e.printStackTrace();
		}
		return listaoficinas;
	}

	public ArrayList<Integer> listarnumerorep(Connection cn)
	{
		ArrayList<Integer> listarep = new ArrayList<Integer>();
		String consulta = "SELECT numero_rep FROM repventas";
		
		try {
			Statement sentencia = cn.createStatement();
			ResultSet res = sentencia.executeQuery(consulta);
			while (res.next()) {
				int rep = res.getInt("numero_rep");
				listarep.add(rep);
			}
			res.close();
			sentencia.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CARGAR LOS REPRESENTANTES EN LA LISTA");
			// e.printStackTrace();
		}
		return listarep;
	}
}