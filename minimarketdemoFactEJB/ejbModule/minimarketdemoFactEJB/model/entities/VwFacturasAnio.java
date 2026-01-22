package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="vw_facturas_anio")
public class VwFacturasAnio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="anio")
    private Integer anio;
    @Column(name="cantidad")
    private Long cantidad;
    @Column(name="total_sum")
    private BigDecimal totalSum;

    // Getters y Setters necesarios
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public BigDecimal getTotalSum() { return totalSum; }
    public void setTotalSum(BigDecimal totalSum) { this.totalSum = totalSum; }
}