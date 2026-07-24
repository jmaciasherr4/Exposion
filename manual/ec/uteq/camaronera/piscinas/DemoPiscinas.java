package ec.uteq.camaronera.piscinas;

import java.sql.Date;

public class DemoPiscinas {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("0912345678", "Juan Pérez");
        Camaronera camaronera = new Camaronera("AquaGest", "Quevedo");
        Piscina piscina = new Piscina("P-01", 2.5, camaronera);
        Date fechaSiembra = Date.valueOf("2026-01-15");
        CicloCultivo ciclo = new CicloCultivo(fechaSiembra, 12, "activo", piscina);
        Date fechaMuestreo = Date.valueOf("2026-02-01");
        Muestreo muestreo = new Muestreo(fechaMuestreo, 8.5, "Sin observaciones", empleado, ciclo);
        System.out.println("Muestreos del ciclo: " + ciclo.getMuestreos().size());
    }
}
