package patronprototype;

import implementacion.CatalogoProductos;
import implementacion.FabricaPrototype;
import implementacion.ListaPrecios;

public class PatronPrototypeMain {

    public static void main(String[] args) {
        // Creación de la Lista Inicial de Precios
        ListaPrecios listadoEstandar = new ListaPrecios("Lista Estándar de Precios");
        for (int c = 1; c <= 5; c++) {
            CatalogoProductos item = new CatalogoProductos("Producto " + c, c * 2);
            listadoEstandar.addCatalogoItem(item);
        }

        // Añadir la lista estándar a la fábrica de prototipos
        FabricaPrototype.addPrototype(listadoEstandar.getListado(), listadoEstandar);

        // Crear la primera lista con 19% de IVA
        ListaPrecios listaConIVA19 = (ListaPrecios) FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listaConIVA19.setListado("Lista con 19% de IVA");
        for (CatalogoProductos item : listaConIVA19.getProductos()) {
            item.setPrecioProducto(item.getPrecioProducto() * 1.19);
        }
        FabricaPrototype.addPrototype(listaConIVA19.getListado(), listaConIVA19);

        // Crear la segunda lista con 5% de IVA
        ListaPrecios listaConIVA5 = (ListaPrecios) FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listaConIVA5.setListado("Lista con 5% de IVA");
        for (CatalogoProductos item : listaConIVA5.getProductos()) {
            item.setPrecioProducto(item.getPrecioProducto() * 1.05);
        }
        FabricaPrototype.addPrototype(listaConIVA5.getListado(), listaConIVA5);

        // Imprimir las diferentes listas de precios
        System.out.println(listadoEstandar);
        System.out.println(listaConIVA19);
        System.out.println(listaConIVA5);
    }
}
