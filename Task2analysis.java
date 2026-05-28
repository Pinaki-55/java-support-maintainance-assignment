public class Task2Analysis {

    /*
      1. What is the exact cause of ConcurrentModificationException in Java?
     
     ConcurrentModificationException occurs when a collection
     is modified while it is being iterated using an Iterator
     or enhanced for-loop, except through the iterator’s own
     remove() method.
     */

    /*
      2. What code pattern at line 142 most likely triggered this error?
     
      Most likely pattern:
     
      for (Transaction t : transactions) {
          transactions.remove(t);
      }
     
      The collection is modified during iteration.
     */

    /*
      3. Provide the minimal safe fix
     
      Iterator<Transaction> iterator = transactions.iterator();
     
      while (iterator.hasNext()) {
          Transaction t = iterator.next();
     
          if (condition) {
              iterator.remove();
          }
      }
     
      Using iterator.remove() safely removes elements
      during iteration without causing
      ConcurrentModificationException.
     */
}
