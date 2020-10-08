class Node<K,T> {
    K pair;
    T key;
    Node right;
    Node left;

    Node (K pair,T key) {
        this.pair=pair;
        this.key=key;
        this.right=null;
        this.left=null;
    }
    public void  setkey(T t){
          this.key= t;             ;

    }
    public void setpair(K k){
        this.pair=k;

    }
}