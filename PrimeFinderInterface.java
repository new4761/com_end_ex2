import java.rmi.*;
public interface PrimeFinderInterface extends Remote {
   public PrimeInfo findPrimes(int min, int max) throws RemoteException;
} 
