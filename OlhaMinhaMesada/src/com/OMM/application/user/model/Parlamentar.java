package com.OMM.application.user.model;

import java.util.ArrayList;
import java.util.List;





public class Parlamentar implements Constantes_Ceap {
	
	private String nomeParlamentar;
	private int idParlamentar;
	private String partidoParlamentar;
	private double salarioParlamentar;
	private int tipoParlamentar;
	private String ufParlamentar;
		
	
public Parlamentar( String nome ) {
		
		this.nomeParlamentar = nome;
		
		this.iniciar_Ceaps(this);	
		
	}

public Parlamentar(){
	
}

	
	public int getIdParlamentar() {
		return idParlamentar;
	}

	public void setIdParlamentar(int idParlamentar) {
		this.idParlamentar = idParlamentar;
	}

	private int posicaoParlamentar = 0;
	private double gastoTotalCeap = 0;
	private List< Ceap > ceapParlamentar = new ArrayList< Ceap >( );
	
	public String getNomeParlamentar() {
		return nomeParlamentar;
	}

	public void setNomeParlamentar(String nomeParlamentar) {
		this.nomeParlamentar = nomeParlamentar;
	}

	public String getPartidoParlamentar() {
		return partidoParlamentar;
	}

	public void setPartidoParlamentar(String partidoParlamentar) {
		this.partidoParlamentar = partidoParlamentar;
	}

	public double getSalarioParlamentar() {
		return salarioParlamentar;
	}

	public void setSalarioParlamentar(double salarioParlamentar) {
		this.salarioParlamentar = salarioParlamentar;
	}

	public int getTipoParlamentar() {
		return tipoParlamentar;
	}

	public void setTipoParlamentar(int tipoParlamentar) {
		this.tipoParlamentar = tipoParlamentar;
	}

	public String getUfParlamentar() {
		return ufParlamentar;
	}

	public void setUfParlamentar(String ufParlamentar) {
		this.ufParlamentar = ufParlamentar;
	}

	

	public String get_NomeParlamentar( ) {
		
		return nomeParlamentar;
	}

	public void set_NomeParlamentar( String nomeParlamentar ) {
		
		this.nomeParlamentar = nomeParlamentar;
	}

	
	

	

	public int get_PosicaoParlamentar( ) {
		
		return posicaoParlamentar;
	}

	public void set_PosicaoParlamentar( int posicaoParlamentar ) {
		
		this.posicaoParlamentar = posicaoParlamentar;
	}

	public double get_GastoTotalCeap( ) {
		
		return gastoTotalCeap;
	}

	public void set_GastoTotalCeap( double gastoTotalParlamentar ) {
		
		this.gastoTotalCeap = gastoTotalParlamentar;
	}
	
	public void calcularGastoTotal( ) {
		
		double total = 0.0;
		
		for ( int i = 0 ; i <= QUANTIDADE_COTAS ; i++){
			
			total = total + ceapParlamentar.get(i).get_TotalGastoAnual( );
		}
		
		this.set_GastoTotalCeap(total);
	}

	public List< Ceap > get_CeapParlamentar( ) {
		
		return ceapParlamentar;
	}

	public void set_CeapParlamentar( List< Ceap > ceapParlamentar ) {
		
		this.ceapParlamentar = ceapParlamentar;
	}
	
	public void iniciar_Ceaps( Parlamentar politico ){
		
		for ( int i = 1 ; i <= QUANTIDADE_COTAS ; i++ ){
			
			Ceap cota = new Ceap ( politico , i );
			
			this.ceapParlamentar.add( cota );
			
			
		}
	}
}
