import com.ejemploMongo.modelo.ObjetoEjemplo;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class MongoDBJDBC {


    public static void main( String args[] ) {

        try{


            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // Nos bajamos una BD
           MongoDatabase m = mongoClient.getDatabase("nuevaBD");

           //Creamos la instancia de morphia (es el parser que recomienda mongo). Le tenemos que pasar nuestro modelo
           //para que lo mapee y haga su magia
            Morphia morphia = new Morphia();
            morphia.mapPackage("com.ejemploMongo.modelo");
            Datastore datastore = morphia.createDatastore(mongoClient, "nuevaBD");
            datastore.ensureIndexes();


            //Creamos y guardamos los objetos (por defecto crea una collecion con el nombre de la clase)
            ObjetoEjemplo oe1 = new ObjetoEjemplo("pedro",4.f, true);
            ObjetoEjemplo oe2 = new ObjetoEjemplo("pablo",3.f, true);

            datastore.save(oe1);
            datastore.save(oe2);


            //Ejecutamos una consulta poderosa (Madre mia esto esta muy bien XD)
            List<ObjetoEjemplo> resultado = datastore.createQuery(ObjetoEjemplo.class)
                                                        .field("clavePrimaria").contains("p")
                                                        .field("valor").greaterThan(3.f)
                                                        .asList();
            //Lista de cosas
            for(ObjetoEjemplo i : resultado)
                System.out.println(i.toString());

            //Ejecutamos un cambio y actualizamos
            System.out.println("insertamos un nuevo valor =  new ObjetoEjemplo(\"mucientes\",4f,true)");
            resultado.get(0).setValor(1.f);
            resultado.get(0).getAsociados().add(new ObjetoEjemplo("mucientes",4f,true));
            datastore.save(resultado.get(0));

            System.out.println("Campos con un valor inferior a 4");
            resultado = datastore.createQuery(ObjetoEjemplo.class).field("valor").lessThan(3.f).asList();
            for(ObjetoEjemplo i : resultado)
                System.out.println(i.toString());

            //borramos la colección
            datastore.getCollection(ObjetoEjemplo.class).drop();


        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }


}