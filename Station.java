public class Station {
    //fields
    protected String name;
    protected String line;
    protected Station next;
    protected Station prev;
    protected boolean inService = true;
    //FIXME:
    //maybe make a "protected boolean visited"

    //constructor
    public Station (String name, String line) {
        this.name = name;
        this.line = line;
    }
    //addPrev
    public void addPrev(Station prev) {
        this.prev = prev;
    }

    //addNext
    public void addNext(Station next) {
        this.next = next;
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
    }

    //tripLength TODO:
    public int tripLength(Station other) {
        //call helper function
    }

    //TODO: make tripLength helper function

    //toString
    public String toString() {
        return ("STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + " next station: "  +this.next.name);
    }
}