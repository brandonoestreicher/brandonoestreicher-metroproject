import java.util.ArrayList;
public class TransferStation extends Station {
    ArrayList<Station> otherStations = new ArrayList<Station>();
    //constructor
    public TransferStation(String line, String name) {
        super(line, name);
    }

    //addTransferStationPrev
    public void addTransferStationPrev(Station prev) {
        //check if prev's next is null
        if (prev.next == null) {
            //set prev's next = transfer station
            prev.next = this;
        }
        //add the station to the list of transfers
        otherStations.add(this);
        
    }

    //addTransferStationNext
    public void addTransferStationNext(Station next) {
        //check if next's prev is null
        if (next.prev == null) {
            //set next's prev = transfer station
            next.prev = this;
        }
        //add the station to the list of transfers
        otherStations.add(this);
    }

    //toString FIXME: add support for null -> none (maybe add a getName()
    public String toString() {
        //FIXME: add if statement to check if next is null, and an if statement to check is prev is null, and then handle correctly (you might even want to do one with both next and prev null)
        String toReturn =  "TRANSFERSTATION" + this.name +": " + this.line + "line, in service: " + this.inService + ", previous station: " + this.prev.name +", next station: " + this.next.name +"\n\tTransfers: \n";

        //for i = 0 to transfers.size
        for (int i = 0; i < otherStations.size(); i++) {
            //if (transfers.get(i).name == null) {
                //toReturn += "\tSTATION: " + "none" + ": line" + transfers.get(i).line + " line, in service:" + transfers.get(i).inService + ", previous station: " + transfers.get(i).prev + ", next station: " + transfers.get(i).next + "\n";
            //}
            //toReturn += /* */"\tSTATION: " + transfers.get(i).name + ": line" + transfers.get(i).line + " line, in service:" + transfers.get(i).inService + ", previous station: " + transfers.get(i).prev + ", next station: " + transfers.get(i).next + "\n";

            //toReturn += "\t" + transfers.get(i).toString();
            toReturn += "\t" + otherStations.get(i).toString() + "\n";
        }
        return toReturn;

    }
}
