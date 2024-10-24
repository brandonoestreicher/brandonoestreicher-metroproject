public class Station {
    //fields
    protected String name;
    protected String line;
    protected Station next;
    protected Station prev;
    protected boolean inService = true;
    //for use by tripLength:
    protected boolean visited;

    //constructor
    public Station (String name, String line) {
        this.name = name;
        this.line = line;
    }

    //getName, to handle null names easily
    public String getName() {
        if (this.name == null) {
            return "none";
        }
        return this.name;
    }
    //addPrev
    public void addPrev(Station prev) {
        this.prev = prev;
        prev.next = this;
    }

    //addNext
    public void addNext(Station next) {
        this.next = next;
        if (next != null) {
            next.prev = this;
        }
    }

    //isAvailable
    public boolean isAvailable() {
        return inService;
    }
    //swtichAvailable
    public void switchAvailable() {
        this.inService = !this.inService;
    }

    //equals
    public boolean equals(Station other) {
        if ((this.name == other.name) && (this.line == other.line)) {
            return true;
        }

        return false;
    }

    //connect
    public void connect(Station other) {
        this.addNext(other);
        other.addPrev(this);
    }

    //tripLength TODO:
    public int tripLength(Station other) {
        //call helper function

        return 0;
    }

    //TODO: make tripLength helper function
    public int tripLengthRecursive(Station other) {
        return 0;
    }

    //toString
    public String toString() {
        System.out.println("tostringtest");

        System.out.println(this.getName());

        return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: "  + this.next.name;
    }
}