public class BST<K extends Comparable<K>,T> {
    Node root;
    int count;
    boolean tell;
    T vap;
    String ad;

    BST (){
        this.root=null;
    }

    public int insert (K stu,T stu1){
        this.count =1;
        this.root=recinsert(this.root,stu,stu1);
        return this.count;
    }
    public Node recinsert (Node root,K stu,T stu1){
        if(root == null){
            root = new Node<K,T>(stu,stu1);
            return root;
        }
        else if(stu.compareTo((K)root.pair)==0){
            if(stu.toString().compareTo(((K)root.pair).toString())==0){
                this.count=-1;
                return root;
            }
            else{
                this.count+=1;
                root.left=recinsert(root.left,stu,stu1);
            }
        }
       else if (stu.compareTo((K)root.pair)<0){
            this.count+=1;
            root.left=recinsert(root.left,stu,stu1);
        }
        else if (stu.compareTo((K)root.pair)>0){
            this.count+=1;
            root.right=recinsert(root.right,stu,stu1);
        }
        return root;
    }
    public int update (K stu, T stu1){
       if(this.contains(stu)) {
           this.count = 1;
           recupdate(this.root, stu, stu1);
           return this.count;
       }
       else
           return -1;
    }
    public void recupdate (Node root,K stu,T stu1){
        if(stu.compareTo((K)root.pair)==0){
            if(stu.toString().compareTo(((K)root.pair).toString())==0){
                root.key=stu1;
            }
            else{
                this.count+=1;
                recupdate(root.left,stu,stu1);
            }
        }
        else if(stu.compareTo((K)root.pair)<0){
            this.count+=1;
            recupdate(root.left,stu,stu1);
        }
        else if(stu.compareTo((K)root.pair)>0){
            this.count+=1;
             recupdate(root.right,stu,stu1);
        }
    }

    public boolean contains (K stu){
        this.tell=false;
        reccontains(this.root,stu);
        return this.tell;
    }
    public void reccontains(Node root, K stu){
        if (root == null){
            this.tell=false;
        }
        else if(stu.compareTo((K)root.pair)==0){
            if(stu.toString().compareTo(((K)root.pair).toString())==0){
                this.tell=true;
            }
            else{
                this.count+=1;
                reccontains(root.left,stu);
            }
        }
        else if(stu.compareTo((K)root.pair)<0){
            reccontains(root.left,stu);
        }
        else if(stu.compareTo((K)root.pair)>0){
            reccontains(root.right,stu);
        }
    }

    public int delete (K stu){
        if(this.contains(stu)) {
            this.count = 0;
            this.root = recdelete(this.root, stu);
            return this.count;
        }
        else{
            return -1;
        }
    }
    public Node recdelete(Node root,K stu){
        if(root==null){
            return root;
        }
        else if(stu.compareTo((K)root.pair)<0){
            this.count+=1;
            //System.out.println("finding left count is"+this.count);
            root.left=recdelete(root.left,stu);
        }
        else if(stu.compareTo((K)root.pair)>0){
            this.count+=1;
            //System.out.println("finding right count is"+this.count);
            root.right=recdelete(root.right,stu);
        }
        else{
            if(stu.toString().compareTo(((K)root.pair).toString())==0){
                if(root.left==null && root.right==null){
                    this.count+=1;
                   // System.out.println("deleteing both nulls count is"+this.count);
                    return null;
                }
                else if(root.right==null && root.left!=null){
                    this.count+=2;
                    //System.out.println("deleteing right null count is"+this.count);
                    return root.left;
                }
                else if(root.left==null && root.right!=null){
                    this.count+=2;
                    //System.out.println("deleteing left null count is"+this.count);
                    return root.right;
                }
                else{
                    this.count+=1;
                    Node root1=minVal(root.right);
                    root.setkey(root1.key);
                    root.setpair(root1.pair);
                    //System.out.println("copied");
                    root.right=recdelete(root.right,(K)root.pair);
                }
            }
            else{
                this.count+=1;
                //System.out.println("finding left count is"+this.count);
                root.left=recdelete(root.left,stu);
            }
        }
        return root;
    }
    public Node minVal(Node root){
        while (root.left != null)
        {
            root = root.left;

        }
        return root;
    }
    public T get(K stu) throws NotFoundException {
        try{
            this.vap=null;
            T a=recget(this.root,stu);
            return this.vap;
        }
        catch(NotFoundException e){
            throw new NotFoundException();
        }
    }
    public T recget(Node root,K stu) throws NotFoundException{
        if(root==null){
            throw new NotFoundException();
        }
        else if(stu.compareTo((K)root.pair)==0){
            if(stu.toString().compareTo(((K)root.pair).toString())==0){
                this.vap=(T)root.key;
                return this.vap;
            }
            else{
                this.count+=1;
                T a=recget(root.left,stu);
            }
        }
        else if(stu.compareTo((K)root.pair)<0){
            T a=recget(root.left,stu);
        }
        else if(stu.compareTo((K)root.pair)>0){
            T a=recget(root.right,stu);
        }
        return this.vap;
    }
    public String address(K stu) throws NotFoundException{
        try {
            this.ad = "";
            root = recaddress(this.root, stu);
            return this.ad;
        }
        catch (NotFoundException e){
            throw new NotFoundException();
        }
    }
    public Node recaddress(Node root,K stu) throws NotFoundException{
        if(root==null){
            throw new NotFoundException();
        }
        else if(stu.compareTo((K)root.pair)==0){
            if(stu.toString().compareTo(((K)root.pair).toString())==0){
                return root;
            }
            else{
                this.ad=this.ad + "L";
                root.left=recaddress(root.left,stu);
            }
        }
        else if(stu.compareTo((K)root.pair)<0){
            this.ad=this.ad + "L";
            root.left=recaddress(root.left,stu);
        }
        else if (stu.compareTo((K)root.pair)>0){
            this.ad=this.ad + "R";
            root.right=recaddress(root.right,stu);
        }
        return root;
    }
}
