import java.util.ArrayList;
public class TransferStation extends Station {
    ArrayList<Station> transfers;
    //constructor
    public TransferStation(String name, String line) {
        super(name, line);
    }

    //addTransferStationPrev
    public void addTransferStationPrev(Station prev) {
        //check if prev's next is null
        if (prev.next == null) {
            //set prev's next = transfer station
            prev.next = this;
        }
        //add the station to the list of transfers
        transfers.add(this);
        
    }

    //addTransferStationNext
    public void addTransferStationNext(Station next) {
        //check if next's prev is null
        if (next.prev == null) {
            //set next's prev = transfer station
            next.prev = this;
        }
        //add the station to the list of transfers
        transfers.add(this);
    }

    //toString TODO:
    public String toString() {
        String toPrint =  "TRANSFERSTATION" + this.name +": " + this.line + "line, in service: " + this.inService + ", previous station: " + this.prev.name +", next station: " + this.next.name +"\n\tTransfers: \n";

        //for i = 0 to transfers.size
            //toPrint += "\t" + transfers.get(i).toString();

        //return toPrint

    }
}
