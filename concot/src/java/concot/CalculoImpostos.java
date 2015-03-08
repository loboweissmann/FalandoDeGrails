package concot;
import java.math.BigDecimal;
/**
	Classe fictícia que implementa um
	calculo de impostos muito simples.

	Apenas multiplica o valor passado pela
	porcentagem do imposto
*/
public class CalculoImpostos {
	
	/** Tarifa a ser aplicada */
	private double tarifa;

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double valor) {
		this.tarifa = valor;
	}

	public double 	 calcularTarifa(double valor) {
		return valor * tarifa;
	}

}