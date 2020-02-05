import java.rmi.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
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
          int min,max;
          Scanner sc = new Scanner(System.in);
          System.out.print("Min value =>"); 
          min = sc.nextInt();

          System.out.print("Max value =>"); 
          max = sc.nextInt();


          PrimeInfo outPutFromServer = stub.findPrimes(min,max);
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