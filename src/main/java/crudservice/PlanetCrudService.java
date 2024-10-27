package crudservice;

import dbconfig.ConnectDb;
import entities.Planet;
import entities.Planets;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {

    public Planet getPlanetById(Planets planets){

       try(Session session = ConnectDb.getInstance().getSessionFactory().openSession()) {

           Planet planet = session.get(Planet.class, planets);

           if(planet==null){
               throw  new NoSuchPlanetFound("there is no such planet");
           }
           return planet;
       }catch (Exception ex){
           System.out.println("Failed to find planet");
           return null;
       }
    }

    public void createPlanet(Planet planet){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            session.persist(planet);

            transaction.commit();

        }catch (Exception ex){
            System.out.println("Filed to Create a planet");
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    public void updatePlanet(Planet newPlanet, Planets planetId){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Planet planet = session.get(Planet.class, planetId);
            if(planet ==null){
                throw new NoSuchPlanetFound("there is no such planet");
            }
            planet.setId(newPlanet.getId());
            planet.setName(newPlanet.getName());

            transaction.commit();

        }catch (Exception ex){
            System.out.println("Failed to update Planet");
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public  void deleteById(Planets planetId){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Planet planetById = getPlanetById(planetId);
            if(planetById==null){
                throw new NoSuchPlanetFound("There is no such planet");
            }

            session.remove(planetById);

            transaction.commit();

        }catch (Exception ex){
            System.out.println("Failed to delete");
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public List<Planet>getAllPlanets(){
        Session session = ConnectDb.getInstance().getSessionFactory().openSession();
        return session.createQuery("from Planet ", Planet.class).list();
    }

}
