import java.net.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class PrimeFinderServer 
{
   public static void main(String[] args)
   {
     
       try
       {
        PrimeFinderImp primeFinderObj = new PrimeFinderImp();
          Registry registry = LocateRegistry.getRegistry();
          registry.bind("PrimeFinderServer", primeFinderObj);
          System.out.println("PrimeFinder Server ready");
       }
       catch (Exception re) {
          System.out.println("Execption in PrimeFinderServer: " + re);
       }
    }
}