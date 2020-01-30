package parking;

public class calcCarLinkedList {
   public static LinkedListCycle cars;
   final int nLetters=23,size=70;
    final char v='v',w='w';
    public calcCarLinkedList(){ // create link in size size
        cars=new LinkedListCycle();
        for (int i=0;i<size;i++){
            char c=(char)('a'+(int)(Math.random()*nLetters));
            cars.add(c);
        }

    }
    public int calcCars(){
        cars.getHead().setData(w);
        int counter=1;
        Node temp=cars.getHead().next;
        boolean flag=false;
        while (!flag){
            if (temp.getData()==w){
                temp.setData(v);

                for(int steps=counter;steps>0;steps--){
                   temp= temp.getPrev();
                }
                if (temp.getData()==v){
                    flag=true;
                }
                else {
                    counter=1;
                    temp=cars.getHead().next;
                }

            }
            else {
                temp=temp.next;
                counter++;
            }
        }


        return counter;
    }
    public static void main(String[] args) {
        calcCarLinkedList parking = new calcCarLinkedList();
        System.out.println("number of cars = "+parking.calcCars());
    }


}
