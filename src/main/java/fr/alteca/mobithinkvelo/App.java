package fr.alteca.mobithinkvelo;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.stop;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import fr.alteca.mobithinkvelo.dao.Trajets;
import fr.alteca.mobithinkvelo.dao.TrajetsMemory;
import fr.alteca.mobithinkvelo.model.StoreTrajet;
import fr.alteca.mobithinkvelo.model.StoreTrajetData;
import fr.alteca.mobithinkvelo.model.Trajet;


public class App 
{
	public static LocalDateTime splitSipmleDateTime(String s) {
		String[] dt = s.split(" ");
		String[] d =dt[0].split(":");
		String[] t =dt[1].split(":");
		
		return LocalDateTime.of(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), Integer.parseInt(t[0]), Integer.parseInt(t[1]),Integer.parseInt(t[2]));
		
	}
	
	
    public static void main( String[] args ) throws InterruptedException
    {
    	
    
        port(getPort());

//    	String keyStoreLocation = "deploy/keystore.jks";
//    	String keyStorePassword = "password";
//    	secure(keyStoreLocation, keyStorePassword, null, null);

//    	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
//    	SLF4J: Defaulting to no-operation (NOP) logger implementation
//    	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details
    	
        //JdbcConnectionParameters params = retrieveDbParams();


        Trajets trajets = new TrajetsMemory();
        Gson gson = new GsonBuilder().create();
        StoreTrajet storeTrajet = new StoreTrajet(trajets);
        Type listType = new TypeToken<StoreTrajetData>(){}.getType();

        System.out.println("Main " + listType.getTypeName().toString());
        post("/mobithink/trip/", (req, res) -> {
        	String buffer = req.body();
        	StoreTrajetData storeTrajetData = gson.fromJson(buffer, listType);
        	Gson gson2 = new Gson();
        	storeTrajet.store(storeTrajetData);
            res.status(201);

            return "Created";
        });

        get("/mobithink/server/wakeup", (req, res) -> "OK");
        
        addShutdownHook();
        Thread.currentThread().join();
        
        
       /* if (true) {
            String projectDir = System.getProperty("user.dir");
            String staticDir = "/src/main/resources/public";
            staticFiles.externalLocation(projectDir + staticDir);
        } else {
            staticFiles.location("/public");
        }*/
    }

    /*private static JdbcConnectionParameters retrieveDbParams() {
        JdbcConnectionParameters params;

        String env = System.getenv("DATABASE_URL");

        System.out.println(env);
        if (env != null) {
            params = JdbcConnectionParameters.fromHeroku(env);
        } else {
            params = JdbcConnectionParameters.DEFAULT_LOCAL_PGSQL_PARAMS;
            System.out.println(params.url().toString());
            System.out.println(params.username().toString());
            System.out.println(params.password().toString());
            
        }
        return params;
    }
*/
    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Exiting.");
            stop();
        }, "shutdownHook"));
    }


    private static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
     //   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName)

        //SessionFactory sf = new Configuration().configure().buildSessionFactory();

        //staticFiles.location("/public");

       /* post("/mobithink/trip/", (req, res) -> {
        	//Trip trip = gson.fromJson(req.body(), listType);
        	
            StoreTripData storeTripData = gson.fromJson(req.body(), listType);
            System.out.println(req.body());
            
           storeTrip.store(storeTripData);
          
            res.status(201);

            return "Created";
        });

        get("/mobithink/server/wakeup", (req, res) -> "OK");
        
        addShutdownHook();
        Thread.currentThread().join();*/
        
        
        
        
        
        
        
        /*post("/api/task", (req, res) -> {

            EntityManager session = sf.createEntityManager();
            try {
                req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(""));


                Integer id = Integer.parseInt(req.queryParams("id"));
                String name = req.queryParams("name");

                Task task = new Task();
                task.setId(id);
                task.setName(name);

                session.getTransaction().begin();
                session.persist(task);
                session.getTransaction().commit();

                res.redirect("/list");
                return "";
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            } finally {
                if (session.isOpen()) {
                    session.close();
                }
            }
        });*/


       /* get("/list", (req, res) -> {
            EntityManager session = sf.createEntityManager();
            try {
                List<Task> tasks = session.createQuery("FROM Task").getResultList();

                StringBuilder builder = new StringBuilder();

                builder.append("<style>\n" +
                        "table {\n" +
                        "    border-collapse: collapse;\n" +
                        "    width: 50%;\n" +
                        "}" +
                        "td, th {\n" +
                        "    border: 1px solid #dddddd;\n" +
                        "    text-align: left;\n" +
                        "    padding: 8px;\n" +
                        "}\n" +
                        "</style>");


                builder.append("<table><tr><th>Task Id</th><th>Task Name</th></tr>\n");
                for (Task task : tasks) {
                    builder.append("<tr><td>" + task.getId() + "</td><td>" + task.getName() + "</td></tr>\n");
                }
                builder.append("</table>\n");

                return builder.toString();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            } finally {
                if (session.isOpen()) {
                    session.close();
                }
            }

        });*/
   // }
}
