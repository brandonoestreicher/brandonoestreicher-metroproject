public class EndStation extends Station {
    //constructor
    public EndStation(String name, String line) {
        super(name, line);
    }

    //makeEnd
    public void makeEnd() {
        this.prev = this.next;
    }

    //toString
    public String toString() {
        return ("ENDSTATION " + this.getName() + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.getName() + " next station: " + this.next.getName());
    }
}
