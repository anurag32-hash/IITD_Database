public class HashTable1<K extends Comparable<K>,T> implements MyHashTable_<K ,T>{
    BST<K, T>[] bt;
    int hashtablesize;

    HashTable1(int n){
        bt = new BST[n];
        for (int i = 0; i < n; i++)
            bt[i] = new BST();
        this.hashtablesize=n;
    }

    public int insert(K key,T obj){
        String str = key.toString();
        int index =(int) Hashfunctions.djb2(str,this.hashtablesize);
        return (bt[index].insert(key,obj));
    }
    public int update(K key,T obj){
        String str = key.toString();
        int index = (int) Hashfunctions.djb2(str,this.hashtablesize);
        return bt[index].update(key,obj);
    }
    public int delete (K key) {
        String str = key.toString();
        int index = (int) Hashfunctions.djb2(str, this.hashtablesize);
        return bt[index].delete(key);

    }
    public boolean contains(K key){
        String str = key.toString();
        int index = (int) Hashfunctions.djb2(str,this.hashtablesize);
        return bt[index].contains(key);
    }
    public T get (K key) throws NotFoundException{
        try{
            String str = key.toString();
            int index = (int) Hashfunctions.djb2(str,this.hashtablesize);
            return (T)bt[index].get(key);
        }
        catch(NotFoundException e){
            throw new NotFoundException();
        }

    }
    public String address (K key) throws NotFoundException{
        try{
            String str = key.toString();
            int index = (int) Hashfunctions.djb2(str,this.hashtablesize);
            return String.valueOf(index) + "-" + bt[index].address(key);
        }
        catch(NotFoundException e){
            throw new NotFoundException();
        }
    }
}