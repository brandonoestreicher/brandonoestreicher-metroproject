import java.util.ArrayList;
public class TransferStation extends Station {
    public ArrayList<Station> otherStations;
    //constructor
    public TransferStation(String line, String name) {
        super(line, name);
        this.otherStations = new ArrayList<Station>();
    }

    //addTransferStationPrev
    public void addTransferStationPrev(Station prev) {
        //check if prev's next is null
        if (prev.next == null) {
            //set prev's next = transfer station
            prev.next = this;
        }
        //add the station to the list of transfers
        otherStations.add(prev);
        
    }

    //addTransferStationNext
    public void addTransferStationNext(Station next) {
        //check if next's prev is null
        if (next.prev == null) {
            //set next's prev = transfer station
            next.prev = this;
        }
        //add the station to the list of transfers
        otherStations.add(next);
    }

    public String toString() {
    String toReturn;
        if ((this.prev == null) && (this.next == null)) {
            toReturn = "TRANSFERSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: none" + ", next station: none" + "\n\tTransfers: \n";
        } else if (this.prev == null) {
           toReturn = "TRANSFERSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: none" + ", next station: "  + this.next.name + "\n\tTransfers: \n";
        } else if (this.next == null) {
            toReturn = "TRANSFERSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: none" + "\n\tTransfers: \n";
        } else {
            toReturn = "TRANSFERSTATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: " + this.next.name + "\n\tTransfers: \n";
        }
        /*String toReturn =  "TRANSFERSTATION " + this.name +": " + this.line + "line, in service: " + this.inService + ", previous station: " + this.prev.name +", next station: " + this.next.name + "\n\tTransfers: \n";*/

        for (int i = 0; i < otherStations.size(); i++) {
            toReturn += "\t" + this.otherStations.get(i).toString() + "\n";
        }
        return toReturn;

    }
}
