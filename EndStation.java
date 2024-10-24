public class EndStation extends Station {
    //constructor
    public EndStation(String line, String name) {
        super(line, name);
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
        //FIXME: handle nulls
        System.out.println("endstationtest");

        System.out.println(this.name);
        return "ENDSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: " + this.next.name;
    }
}
