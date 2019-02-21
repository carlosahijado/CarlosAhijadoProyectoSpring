package com.carlos.modelo;

public class Oficinas {

	private int oficina;
	private String ciudad;
	private int cod_region;
	private int director;
	private int total_ventas;
	private int num_representantes;
	private String nombre_director;
	private String nombre_region;
	public Oficinas()
	{
		super();
	}
	
	public Oficinas(int oficina, String ciudad, int cod_region, int director, int total_ventas, int num_representantes,
			String nombre_director) {
		super();
		this.oficina = oficina;
		this.ciudad = ciudad;
		this.cod_region = cod_region;
		this.director = director;
		this.total_ventas = total_ventas;
		this.num_representantes = num_representantes;
		this.nombre_director = nombre_director;
	}
	public Oficinas(int oficina, String ciudad, String nombre_region, int num_representantes,
			String nombre_director) {
		super();
		this.oficina = oficina;
		this.ciudad = ciudad;
		this.num_representantes = num_representantes;
		this.nombre_director = nombre_director;
		this.nombre_region = nombre_region;
	}
	public int getOficina() {
		return oficina;
	}
	public void setOficina(int oficina) {
		this.oficina = oficina;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getCod_region() {
		return cod_region;
	}
	public void setCod_region(int cod_region) {
		this.cod_region = cod_region;
	}
	public int getDirector() {
		return director;
	}
	public void setDirector(int director) {
		this.director = director;
	}
	public int getTotal_ventas() {
		return total_ventas;
	}
	public void setTotal_ventas(int total_ventas) {
		this.total_ventas = total_ventas;
	}
	public int getNum_representantes() {
		return num_representantes;
	}
	public void setNum_representantes(int num_representantes) {
		this.num_representantes = num_representantes;
	}
	public String getNombre_director() {
		return nombre_director;
	}
	public void setNombre_director(String nombre_director) {
		this.nombre_director = nombre_director;
	}
	public String getNombre_region() {
		return nombre_region;
	}
	public void setNombre_region(String nombre_region) {
		this.nombre_region = nombre_region;
	}
	
}
