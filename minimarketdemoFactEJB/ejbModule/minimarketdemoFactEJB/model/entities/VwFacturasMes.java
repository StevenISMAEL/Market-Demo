package minimarketdemoFactEJB.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="vw_facturas_mes")
public class VwFacturasMes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="mes")
    private Integer mes;
    @Column(name="nombre_mes")
    private String nombreMes;
    @Column(name="cantidad")
    private Long cantidad;
    @Column(name="total_sum")
    private BigDecimal totalSum;

    // Getters y Setters
    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }
    public String getNombreMes() { return nombreMes; }
    public void setNombreMes(String nombreMes) { this.nombreMes = nombreMes; }
    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public BigDecimal getTotalSum() { return totalSum; }
    public void setTotalSum(BigDecimal totalSum) { this.totalSum = totalSum; }
}