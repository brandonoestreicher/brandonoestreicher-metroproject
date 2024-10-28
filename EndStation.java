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
        //System.out.println("endstationtest");
        //System.out.println(this.name);
        if ((this.prev == null) && (this.next == null)) {
            return "ENDSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: none" + ", next station: none";
        }
        else if (this.prev == null) {
            return "ENDSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: none" + ", next station: "  + this.next.name;
        } else if (this.next == null) {
            return "ENDSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: none";
        } else {
            return "ENDSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: " + this.next.name;
        }

        /*return "ENDSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: " + this.next.name;*/
    }
}
