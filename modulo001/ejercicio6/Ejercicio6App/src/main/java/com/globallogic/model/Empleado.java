package com.globallogic.model;

/**
 * 
 * @author jmpaniego
 *
 */
public class Empleado extends Persona {
	private Double sueldoBase;
	private Double horasExtra;
	private Double tipoIRPF;
	private boolean casado;
	private Integer numeroHijos;
	
	private static Double importeHoraExtra;
	
	
	public Empleado() {
		super();
	}
	
	public Empleado(String DNI) {
		super(DNI);
	}

	public Double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(Double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Double getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(Double horasExtra) {
		this.horasExtra = horasExtra;
	}

	public Double getTipoIRPF() {
		return tipoIRPF;
	}

	public void setTipoIRPF(Double tipoIRPF) {
		this.tipoIRPF = tipoIRPF;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public Integer getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public static Double getImporteHoraExtra() {
		return importeHoraExtra;
	}

	public static void setImporteHoraExtra(Double importeHoraExtra) {
		Empleado.importeHoraExtra = importeHoraExtra;
	}
	
	public Double complementoExtra() {
		return this.horasExtra*importeHoraExtra;
	}
	
	public Double sueldoBruto() {
		return this.sueldoBase + this.complementoExtra();
	}
	
	public Double retenciones() {
		double retenciones = this.tipoIRPF;
		if(this.isCasado()) {
			retenciones -= 2; 
		}
		retenciones -= numeroHijos;
		return this.sueldoBruto()*retenciones/100.0;
	}

	@Override
	public String toString() {
		StringBuilder toS =  new StringBuilder();
		toS.append(super.toString());
		toS.append(System.getProperty("line.separator"));
		toS.append("Sueldo base: ");
		toS.append(this.getSueldoBase());
		toS.append(System.getProperty("line.separator"));
		toS.append("Horas extras: ");
		toS.append(this.getHorasExtra());
		toS.append(System.getProperty("line.separator"));
		toS.append("tipo IRPF: ");
		toS.append(this.getTipoIRPF());
		toS.append(System.getProperty("line.separator"));
		toS.append("Casado: ");
		toS.append(this.isCasado()?"S":"N");
		toS.append(System.getProperty("line.separator"));
		toS.append("Numero de hijos: ");
		toS.append(this.getNumeroHijos());
		toS.append(System.getProperty("line.separator"));
		
		return toS.toString();
	}
	
	
}
