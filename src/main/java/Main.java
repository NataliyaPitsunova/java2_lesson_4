import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //Cделать добавление и удаление из односвязного списка по индексу
        OwnLinkedList<Integer> integLL = new OwnLinkedList<>();
        integLL.addNodeIndx(555, 0); //метод "добавление по индексу"
        integLL.addNodeIndx(444, 1);
        integLL.addNodeIndx(666, 2);
        integLL.addNodeIndx(111, 3);
        integLL.addNodeIndx(222, 4);
        integLL.addNodeIndx(777, 5);
        integLL.addNodeIndx(888, 6);
        integLL.display();
        System.out.println();
        integLL.addNodeIndx(999, 4);
        integLL.addNodeIndx(1, 0);

        integLL.display();
        System.out.println();


        integLL.deleteNodeIndx(8);      //метод удаление по индексу
        integLL.deleteNodeIndx(6);
        integLL.deleteNodeIndx(0);

        integLL.display();
        System.out.println();
    }
}
