package Make_Union_Find;

/**
 * DisjointSets
 */
public class DisjointSets {
    private UFList list;
    private UFList longer;
    private UFList shorter;

    public DisjointSets() {}

    @Override
    public String toString() {
        return "DisjointSets: " + "{" + longer.getHead() + "," + longer.getTail() + "}";
    }

    public String view() {
        return "{" + list.head + "}";
    }

    public void setLonger(UFList longer) {
        this.longer = longer;
    }

    public void setShorter(UFList shorter) {
        this.shorter = shorter;
    }

    public void makeSet(UFInformation x) {
        this.list = new Make_Union_Find.DisjointSets.UFList();
        this.list.head = this.list.tail = x;
        this.list.length = 1;
        x.list = this.list;
        x.next = null;
    }

    public boolean belong(UFInformation x, UFInformation y) {
        return (x.list == y.list);
    }

    public UFInformation find(UFInformation x) {
        return x.list.head;
    }

    public void union(UFInformation x, UFInformation y) {
        if (x.list.length <= y.list.length) {
            setShorter(x.list);
            setLonger(y.list);
        } else {
            setShorter(y.list);
            setLonger(x.list);
        }

        this.longer.tail.next = shorter.getHead();
        this.longer.tail = shorter.getTail();
        this.longer.length = shorter.length + longer.length;
    }

    static class UFInformation extends Node {
        private UFList list;
        private UFInformation next;

        public UFInformation(int value) {
            super(value);
        }

        @Override
        public String toString() {
            return "" + list + "";
        }
    }

    static class UFList {
        private UFInformation head;
        private UFInformation tail;
        private int length;

        public UFList() {}

        @Override
        public String toString() {
            return "" + head.getValue() + "";
        }

        public UFInformation getHead() {
            return head;
        }

        public UFInformation getTail() {
            return tail;
        }

        public int getLength() {
            return length;
        }
    }

    public static void main(String[] args) {
        DisjointSets sets = new DisjointSets();
        UFInformation a = new UFInformation(2);
        UFInformation b = new UFInformation(5);
        sets.makeSet(a);
        System.out.println(sets.view()); // {2}
        sets.makeSet(b);
        System.out.println(sets.view()); // {5}
        sets.union(a, b);
        System.out.println(sets); // DisjointSets: {5,2}
    }
}
