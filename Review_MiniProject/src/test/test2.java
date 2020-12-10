package test;

import java.util.Vector;

class Aa{
   int a;
   Aa(int a){
      this.a = a;
   }
}


class AaManager{
   Vector<Aa> Aalist = new Vector<Aa>();
}

public class test2 {
   public static void main(String[] args) {
      AaManager am = new AaManager();
      
      for(int i = 0; i < 10; i++) {
         am.Aalist.add(new Aa(i));
      }
      
      Vector<Aa> test = new Vector<Aa>();
      
      for(int i = 0; i < 4; i++) {
         test.add(am.Aalist.get(i));
      }
      
      test.get(0).a  = 100;
      
      
      for(int i = 0; i < 10; i++) {
         System.out.println(am.Aalist.get(i).a);
      }
      
      
      
      
      int arr[] = {10,20,30,40};
      int temp[] = arr;
      temp[0] = 100;
      
      System.out.println(temp[0]);
      System.out.println(arr[0]);
   }
}