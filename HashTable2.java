public class HashTable2<K,T> implements MyHashTable_<K,T>{
    T[] stuarr;
    K[] pairarr;
    int hashtablesize;
    int count,index,i,j;
    int[] flag;

    HashTable2(int n){
        count = 0;
        index = 0;
        i = 0;
        j = 0;
        stuarr=(T[])new Object[n];
        pairarr=(K[])new Object[n];
        flag=new int[n];
        for(int y=0;y<n;y++){
            flag[y]=0;
        }
        for(int z=0; z<n; z++){
            stuarr[z] = null;
        }
        this.hashtablesize=n;
    }
    public int insert(K key,T obj){
        if(contains(key)==false) {
            String str = key.toString();
            this.count = 0;
            this.i = (int) Hashfunctions.djb2(str, this.hashtablesize);
            this.j = (int) Hashfunctions.sdbm(str, this.hashtablesize);
            this.index = this.i;
            //System.out.println("first index is"+" "+ this.index);
            while (this.stuarr[this.index] != null) {
                this.count += 1;
                this.index = (this.i + ((this.count) * this.j)) % this.hashtablesize;
                //  System.out.println("index is"+" "+ this.index);
            }
            //System.out.println("final index is"+" "+ this.index);
            stuarr[this.index] = obj;
            pairarr[this.index] = key;
            flag[this.index] = 2;
            return this.count + 1;
        }
        else
            return -1;
    }
    public int update(K key,T obj){
        if(contains(key)) {
            stuarr[this.index] = obj;
            return this.count + 1;
        }
        else{
            return -1;
        }
    }
    public int delete(K key){
        if(contains(key)) {
            stuarr[this.index] = null;
            pairarr[this.index] = null;
            flag[this.index] = 1;
            return this.count + 1;
        }
        else
            return -1;
    }
    public boolean contains(K key){
        String str = key.toString();
        this.count=0;
        this.i = (int) Hashfunctions.djb2(str,this.hashtablesize);
        this.j = (int) Hashfunctions.sdbm(str,this.hashtablesize);
        this.index = this.i;
        while(true && this.count<this.hashtablesize) {
            if (flag[this.index] == 0) {
                return false;
            }
            else if (flag[this.index] == 1) {
                this.count += 1;
                this.index = (this.i + ((this.count) * this.j)) % this.hashtablesize;
            }
            else if(flag[this.index]==2){
                if(pairarr[this.index].toString().compareTo(key.toString())==0){
                    return true;
                }
                else{
                    this.count += 1;
                    this.index = (this.i + ((this.count) * this.j)) % this.hashtablesize;
                }
            }
        }
        return false;
    }
    public T get (K key) throws NotFoundException{
        if(contains(key)==true){
            return (T)this.stuarr[this.index];
        }
        else
            throw new NotFoundException();
    }
    public String address(K key) throws NotFoundException{
        if(contains(key)==true){
            return String.valueOf(this.index);
        }
        else
            throw new NotFoundException();
    }
}