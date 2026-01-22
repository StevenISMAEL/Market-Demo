package minimarketdemo.controller.gerencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import minimarketdemoFactEJB.model.entities.*;
import minimarketdemoFactEJB.model.managers.ManagerGerencia;
import minimarketdemo.controller.seguridades.BeanSegLogin;

// Imports de PrimeFaces para el gráfico
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.optionconfig.title.Title;

@Named
@SessionScoped
public class BeanGerencia implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private ManagerGerencia mGerencia;

    @Inject
    private BeanSegLogin beanSegLogin;

    private List<VwFacturasAnio> listaAnio;
    private List<VwFacturasMes> listaMes;
    private List<VwPedidosResumen> listaPedidos;
    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        try {
            listaAnio = mGerencia.findFacturasPorAnio();
            listaMes = mGerencia.findFacturasPorMes();
            listaPedidos = mGerencia.findPedidosResumen();
            createBarModel();
        } catch (Exception e) {
            e.printStackTrace(); // Revisa la consola si falla
        }
    }

    public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Total Facturado ($)");

        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        if (listaMes != null) {
            for (VwFacturasMes f : listaMes) {
                values.add(f.getTotalSum());
                labels.add(f.getNombreMes());
            }
        }

        barDataSet.setData(values);
        barDataSet.setBackgroundColor("rgba(54, 162, 235, 0.2)");
        barDataSet.setBorderColor("rgb(54, 162, 235)");
        barDataSet.setBorderWidth(1);
        data.addChartDataSet(barDataSet);
        data.setLabels(labels);
        barModel.setData(data);
        
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Evolución Mensual de Ventas");
        barModel.getOptions().setTitle(title);
    }

    // Getters necesarios para el XHTML
    public List<VwFacturasAnio> getListaAnio() { return listaAnio; }
    public List<VwFacturasMes> getListaMes() { return listaMes; }
    public List<VwPedidosResumen> getListaPedidos() { return listaPedidos; }
    public BarChartModel getBarModel() { return barModel; }
}