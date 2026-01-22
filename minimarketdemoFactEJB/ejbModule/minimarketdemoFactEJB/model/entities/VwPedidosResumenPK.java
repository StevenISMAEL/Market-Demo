package minimarketdemoFactEJB.model.entities;
import java.io.Serializable;
import java.util.Objects;

public class VwPedidosResumenPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer mes;
    private String estado;

    public VwPedidosResumenPK() {}
    
    @Override
    public int hashCode() { return Objects.hash(estado, mes); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VwPedidosResumenPK other = (VwPedidosResumenPK) obj;
        return Objects.equals(estado, other.estado) && Objects.equals(mes, other.mes);
    }
}