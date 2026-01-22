package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="vw_pedidos_resumen")
@IdClass(VwPedidosResumenPK.class) // Vinculamos la clase PK
public class VwPedidosResumen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @Column(name="mes") private Integer mes;
    @Id @Column(name="estado") private String estado;
    @Column(name="cantidad") private Long cantidad;
    @Column(name="total_sum") private BigDecimal totalSum;

    // Getters y Setters
    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public BigDecimal getTotalSum() { return totalSum; }
    public void setTotalSum(BigDecimal totalSum) { this.totalSum = totalSum; }
}