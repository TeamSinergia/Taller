package com.example.api;


import weka.clusterers.Canopy;
import weka.core.Instances;
import weka.core.converters.DatabaseLoader;

public class apiweka {


    public void testWekaCluster() throws Exception {

        DatabaseLoader atf;
        

        atf = new DatabaseLoader();
        
        atf.setUrl("jdbc:postgresql://128.199.1.222:5432/delati");
        atf.setUser("modulo4");
        atf.setPassword("modulo4");
        atf.setQuery("select distinct o.htitulo_cat,o.htitulo,\n" +
        "vfun.descripcion_normalizada as funciones\n" +
        "from webscraping w inner join oferta o \n" +
        "on (w.id_webscraping=o.id_webscraping)\n" +
        "left outer join v_funcion vfun\n" +
        "on (o. id_oferta=vfun.id_oferta)\n" +
        "where o.id_estado is null\n" +
        "order by 1,2,3;");

        atf.setSource(atf.getUrl(), atf.getUser(),atf.getPassword());

        Instances ins = new Instances(atf.getDataSet());

       // DataSource ds = new DataSource("src/main/resources/Wekafunciones.arff");
        //Instances ins = ds.getDataSet();
        System.out.println(ins.numInstances() + " Numero de instancias");
        Canopy model = new Canopy();
       // SimpleKMeans model = new SimpleKMeans();
        model.setNumClusters(5);
        model.buildClusterer(ins);
        System.out.println(model);
    }

}
