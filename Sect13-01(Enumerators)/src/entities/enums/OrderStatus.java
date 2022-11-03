// ================ Enums ================ \\

/**
 * 'Enums' são classes estáticas contendo constantes pre-definidas.
 * São utilizadas quando temos valores pre-determinados e que não
 * devem sofrer alterações. Assim como métodos estáticos, não
 * é necessário sua instância.
 */

package entities.enums;

public enum OrderStatus {

	PENDING_PAYMENT,
	PROCESSING,
	SHIPPED,
	DELIVERED;
}
