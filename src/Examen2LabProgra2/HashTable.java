package Examen2LabProgra2;

public class HashTable {

    private Entry inicio;
    private int size = 0;

    public boolean isEmpty() {
        return inicio == null;
    }

    public void add(String user, long pos) {
        Entry obj = new Entry(user, pos);
        if (isEmpty()) {
            inicio = obj;
        } else {
            Entry tmp = inicio;
            while (tmp.siguiente != null) {
                tmp = tmp.siguiente;
            }
            tmp.siguiente = obj;
        }
        size++;
    }

    public boolean remove(String username) {
        if (!isEmpty()) {
            Entry tmp = inicio;
            if (inicio.username == username) {
                inicio = inicio.siguiente;
                size--;
                return true;
            } else {
                while (tmp.siguiente != null) {
                    if (tmp.siguiente.username == username) {
                        tmp.siguiente = tmp.siguiente.siguiente;
                        size--;
                        return true;
                    }
                    tmp = tmp.siguiente;
                }

            }

        }
        return false;
    }
    
    
    public long Search(String username){
        Entry tmp = inicio;
        while(tmp!=null){
            if (tmp.username == username){
                return tmp.pos;
            }
            tmp = tmp.siguiente;
        }
        return -1;
    }

}
