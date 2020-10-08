public class Pair<A,B> implements Comparable<Pair<A,B>>{
    A fname;
    B lname;

    Pair(A fname,B lname){
        this.fname=fname;
        this.lname=lname;
    }

    public A get(){
        return this.fname;
    }
    public B getl(){
        return this.lname;
    }

    public String toString()
    {
        return ((String)this.fname+this.lname);
    }
    public int compareTo(Pair<A,B> s){
        return ((String)this.fname).compareTo((String)s.fname);
    }
}