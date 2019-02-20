package com.carlos.modelo;

public class Regiones {
	
	private int cod_region;
	private String nombre;
	private int numero_oficinas;
	private int total_ventas;
	public Regiones()
	{
		super();
	}
	
	public Regiones(int cod_region, String nombre)
	{
		super();
		this.cod_region=cod_region;
		this.nombre=nombre;
	}
	
	public Regiones(int cod_region, String nombre, int numero_oficinas, int total_ventas)
	{
		super();
		this.cod_region=cod_region;
		this.nombre=nombre;
		this.numero_oficinas=numero_oficinas;
		this.total_ventas=total_ventas;
	}

	public int getCod_region() {
		return cod_region;
	}

	public void setCod_region(int cod_region) {
		this.cod_region = cod_region;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero_oficinas() {
		return numero_oficinas;
	}

	public void setNumero_oficinas(int numero_oficinas) {
		this.numero_oficinas = numero_oficinas;
	}

	public int getTotal_ventas() {
		return total_ventas;
	}

	public void setTotal_ventas(int total_ventas) {
		this.total_ventas = total_ventas;
	}
	
}
