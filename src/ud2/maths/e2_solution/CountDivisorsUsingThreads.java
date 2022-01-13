package ud2.maths.e2_solution;
// Author: David J. Eck

/**
 * This program finds the number in the range 1 to some maximum that has the 
 * largest number of divisors.  It prints that number and the number of divisors 
 * that it has.  Note that there might be several numbers that have the maximum
 * number of divisors.  Only one of them is output.
 * 
 * The program's work is divided among one to ten threads.  The number 
 * of threads is chosen by the user.
 */
public class CountDivisorsUsingThreads {

   /**
    * The upper limit of the range of integers that is to be tested.
    */
   private final static int MAX = 100_000;
   
   /**
    * The largest number of divisors found so far.  (Note: This is
    * volatile since it is referenced in unsynchronized code in the
    * countDivisorsWithThreads() method.)
    */
   private volatile static int maxDivisorCount = 0;
   
   /**
    * This method is called by a thread when it has completed its computation,
    * to report the largest number of divisors that it found in its assigned
    * range of integers.  The information is used to update the variables
    * maxDivisorCount and intWithMaxDivisorCount.
    * @param maxCountFromThread largest divisor count in the thread's assigned
    *          range
    * @param intWithMaxFromThread the integer that had the maximum number
    *          of divisors
    */
   synchronized private static void report(int maxCountFromThread, 
         int intWithMaxFromThread) {
      if (maxCountFromThread > maxDivisorCount) {
         maxDivisorCount = maxCountFromThread;
      }
   }
   
   /**
    * A thread belonging to this class counts the number of divisors for all
    * the integers in an assigned range of integers.  The range is specified
    * in the constructor.  The thread finds the integer in the range that 
    * has the largest number of divisors, and a number that has that many
    * divisors.  At the end of its computation, the thread reports its answer 
    * by calling the report() method.
    */
   private static class CountDivisorsThread extends Thread {
      int min, max;
      public CountDivisorsThread(int min, int max) {
         this.min = min;
         this.max = max;
      }
      public void run() {
         int maxDivisors = 0;
         int whichInt = 0;
         for (int i = min; i < max; i++) {
            int divisors = countDivisors(i);
            if (divisors > maxDivisors) {
               maxDivisors = divisors;
               whichInt = i;
            }
         }
         report(maxDivisors,whichInt);
      }
   }
   
   /**
    * Finds the number in the range 1 to MAX that has the largest number of
    * divisors, dividing the work among a specified number of threads.
    */
   private static int countDivisorsWithThreads(int numberOfThreads) {
      CountDivisorsThread[] worker = new CountDivisorsThread[numberOfThreads];
      int integersPerThread = MAX/numberOfThreads; 
      int start = 1;  // Starting point of the range of ints for first thread.
      int end = start + integersPerThread - 1;   // End point of the range of ints.
      for (int i = 0; i < numberOfThreads; i++) {
         if (i == numberOfThreads - 1) {
            end = MAX;  // Make sure that the last thread's range goes all
                        // the way up to MAX.  Because of rounding, this
                        // is not automatic.
         }
         worker[i] = new CountDivisorsThread( start, end );
         start = end+1;    // Determine the range of ints for the NEXT thread.
         end = start + integersPerThread - 1;
      }
      maxDivisorCount = 0;
      for (int i = 0; i < numberOfThreads; i++)
         worker[i].start();
      for (int i = 0; i < numberOfThreads; i++) {
             // Wait for each worker thread to die, because the results
             // are not complete until all threads have completed and
             // reported their results.
         while (worker[i].isAlive()) {
            try {
               worker[i].join();
            }
            catch (InterruptedException e) {
            }
         }
      }
      return maxDivisorCount;
   }
   
   /**
    * Gets the number of threads from the user and calls countDivisorsWithThreads()
    * to do the actual work.
    */
   public static void main(String[] args) {
      int MACHINE_PROCESSORS = Runtime.getRuntime().availableProcessors();
      int result = countDivisorsWithThreads(MACHINE_PROCESSORS);
      System.out.println(result);
   }
   
    /**
     * Finds the number of divisors of the integer N.  Note that this method does
     * the counting in a stupid way, since it tests every integer in the range
     * 1 to N to see whether it evenly divides N.
     */
   public static int countDivisors(int N) {
      int count = 0;
      for (int i = 1; i <= N ; i++) {
         if ( N % i == 0 )
            count ++;
      }
      return count;
   }
   
}
