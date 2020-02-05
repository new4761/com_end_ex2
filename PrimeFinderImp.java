import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.*; 
public class PrimeFinderImp extends UnicastRemoteObject implements PrimeFinderInterface {
    public PrimeFinderImp() throws RemoteException {
        super();
    }

    public PrimeInfo findPrimes(int min, int max) throws RemoteException {
        PrimeInfo primeObj = new PrimeInfo();
        List<Integer> arrlist = new ArrayList<Integer>();

        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {

                arrlist.add(i);
            }
        }
        primeObj.primes = new int[arrlist.size()];
        int index = 0;
        for (Integer value : arrlist) {
            primeObj.primes [index++] = value;
        }
       
        primeObj.numPrimes = (primeObj.primes.length);
        return primeObj;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
