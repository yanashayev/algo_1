package parking;
import static parking.calcCarLinkedList.cars;

public  class ifCycle{
    public boolean ifCycle() {
        Node tertal = cars.getHead();
        Node rabit = cars.getHead();
        boolean flag = true,ans=true;

        while (flag){
           if (tertal.getNext()==null||rabit.getNext().getNext()==null
            ||rabit.getNext()==null){
               System.out.println("not cycle");
               flag=false;
               ans=false;
            }
           else{
               tertal=tertal.getNext();
               rabit=rabit.getNext().getNext();
               if(rabit.getData()==tertal.getData()){
                   System.out.println("is cycle");
                   flag=false;
                   ans=true;
               }
           }
        }

        return ans;

    }


}
