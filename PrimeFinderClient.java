import java.rmi.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PrimeFinderClient
{
   public static void main(String[] args)
   {
       if (args.length == 0)
       {
          System.err.println("Usage java PrimeFinderClient <server-hostname>");
       }
       try
       {
          Registry registry = LocateRegistry.getRegistry(args[0]);
          PrimeFinderInterface stub = (PrimeFinderInterface) registry.lookup("PrimeFinderServer");
          PrimeInfo outPutFromServer = stub.findPrimes(1,1000);
          System.out.print("ALL PrimeNumber [ ");
          for(int x :outPutFromServer.primes)
          {
            System.out.print(x+" ");
          } 
          System.out.print("\r\n");
          System.out.println("numPrimes = "+outPutFromServer.numPrimes);
         
       }
       catch (Exception e)
       {
          System.err.println("System Exception" + e);
       }
    }
 }