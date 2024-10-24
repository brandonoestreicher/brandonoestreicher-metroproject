public class EndStation extends Station {
    //constructor
    public EndStation(String name, String line) {
        super(name, line);
    }

    //makeEnd
    public void makeEnd() {
        if (this.prev == null) {
        this.prev = this.next;
        }
        if (this.next == null) {
            this.next = this.prev;
        }
    }

    //toString
    public String toString() {
        System.out.println("test");

        System.out.println(this.getName());
        return "ENDSTATION " + this.getName() + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.getName() + " next station: " + this.next.getName();
    }
}
