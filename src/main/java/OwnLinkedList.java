public class OwnLinkedList<T> {
    //generic
    private long size;
    private Node tails;
    private Node head;

    public OwnLinkedList() {
        this.size = 0;
        this.tails = null;
        this.head = null;
    }

   /* public void addNode(T data) {     //метод преподавателя
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tails = newNode;
        } else {
            tails.next = newNode;
        }
        tails = newNode;
        size++;
    }*/

    public void addNodeIndx(T data, int index) {
        Node newNode = new Node(data); //если список пуст хотим добавить первый элемент
        if (head == null) {
            head = newNode;         //голове присваиваем значение нового элемента списка
            tails = newNode;       //хвосту присваиваем значение нового элемента списка (список состоит из 1 элемента)
            size++;             //увеличиваем размер
        } else {
            if ((index > size)) {           //если задаем элемент не последующие за последним имеющимся, а 2+ к концу
                System.out.println("Размер списка (" + size + ") меньше заданого индекса добавляемого элемента (" + index + ")");
                return;
            } else {
                if (index == 0) { //вставкк перед 1 текущим элементом
                    newNode.next = head; //следущее значение после нового получает ссылку на текущюю голову
                    head = newNode; //новой голове присваиваем новое значение
                } else {
                    if (index < size) {                       //если вставить элемент внутри
                        Node current = head;                 //выбранная строчка начинаем с головы списка
                        int i = 0;
                        while (current.next != null) {      //до тех пор пока следующая строчка не будет "отсутствовать" идем по списку
                            if (i == index - 1) {           //если и = (нужному индексу-1) (то есть мы вставляем в хвост текущего значения)
                                newNode.next = current.next; //хвосту нового нода дали ссылку следущего значения в текущем списке
                                current.next = newNode;     //"следущее элемент" текущего элемента ссылается на новый элемент
                                return;
                            }
                            current = current.next;         //шагаем дальше
                            i++;
                        }
                    } else {
                        tails.next = newNode; //добавляем последний элемент, то есть за хвостом появится новое значение
                    }
                }
            }
            tails = newNode; //тогда последнее значение становиться хвостом
            size++; // увеличивается размер
        }
    }

    public void deleteNodeIndx(int index) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        if ((head == tails) & (size == 1)) {
            System.out.println("Единственный элемент списка удален");
            head = null;
            tails = null;
            return;
        }
        if (index > size) {
            System.out.println("Невозможно удалить - элемента с таким индексом нет в списке");
            return;
        } else {
            if (index == 0) {
                head = head.next;               // указываем на следующий элемент после головы как на начало списка
            } else {
                Node current = head;             //выбранная строчка начинаем с головы списка
                int i = 0;
                while (current.next != null) {          //до тех пор пока следующая строчка не будет "отсутствовать" идем по списку
                    if (i == index - 1) {
                        if (index == size) {            // если убираем последний символ
                            tails = current;            // то текущий элемент (индекс-1) становиться хвостом
                            current.next = null;
                            size--;

                            return;
                        } else {
                            current.next = current.next.next;        //найденный элемент выкидываем то есть ссыка через один от текущего
                            return;
                        }
                    }
                    current = current.next;              //шагаем дальше
                    i++;
                }
            }
        }
    }


    public void display() {
        if (size == 0) {
            System.out.println("Список пуст");
            return;
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

    }


    public void displayIndx(int index) {
        if (index > size) {
            System.out.println("Размер списка меньше заданого индекса");
            return;
        } else {
            Node current = head;
            for (int i = 1; i <= index; i++) {
                current = current.next;
            }
            System.out.println(current.data);
        }

    }

    private class Node {
        T data;
        Node next;


        public Node(T data) {
            this.data = data;
            this.next = null;
        }


    }

}

