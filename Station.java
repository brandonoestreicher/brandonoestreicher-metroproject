import java.util.ArrayList;
public class Station {
    //fields
    protected String name;
    protected String line;
    protected Station next;
    protected Station prev;
    protected boolean inService = true;

    //constructor
    public Station (String line, String name) {
        this.name = name;
        this.line = line;
    }

    //getName, to handle null names easily
    /*public String getName() {
        if (this.name == null) {
            return "none";
        }
        return this.name;
    }*/
    //addPrev
    public void addPrev(Station prev) {
        this.prev = prev;
        //safeguard for connect
        if (prev.next == null) {
            prev.next = this;
        }
    }

    //addNext
    public void addNext(Station next) {
        this.next = next;
        //safeguard for connect
        if (next.prev == null) {
            next.prev = this;
        }
    }

    //isAvailable
    public boolean isAvailable() {
        return this.inService;
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
        other.addPrev(this);
        this.addNext(other);
    }

    
    //tripLength
    public int tripLength(Station destStation) {
        ArrayList<Station> visitedStations = new ArrayList<Station>();
        //check if stations are equal off the bat, return 0
        if (this.equals(destStation)) {
            return 0;
        }
        //check if we're being sent on a trip to nowhere (aka the bad place express)
        if (destStation == null) {
            return -1;
        }
        //initialize counter variable to return
        int tripLength = 0;
        //call helper function
        if (tripLength < 0) {
            return -1;
        }
        return tripLengthRecursive(destStation, this, visitedStations, tripLength);
    }
    
    
    //tripLength helper function
    
    public int tripLengthRecursive(Station destStation, Station nextStation, ArrayList<Station> visitedStations, int tripLength) {
        //base cases

        //trying to visit a station that's already been visited, return error
        if (visitedStations.contains(nextStation)) {
            return -1;
        }

        //reached a station in which .equals() == true, return success
        if (nextStation.equals(destStation)) {
            return tripLength;
        }
    
        //reached an end station that is not equal to the destination w/o finding it: return failure
        //bad base case... leave this commented out (keeping it here on the wall of shame for posterity)
        /*if ((nextStation instanceof EndStation)  && (!nextStation.equals(destStation))) {
            return -2;
        }*/

        if (nextStation.next == null) {
            return -3;
        }

        //random error catcher idek anymore tbh
        if (tripLength < 0) {
            return -4;
        }

        //--------------------------------------------------------------------------------------------------------------------------------
        //recursive case(s)
        visitedStations.add(nextStation);
        //case 2: transfer to a different line required
        //if you have to transfer-- the transfer station can lead you to multiple different paths because it not only has its own next, but it also has other nexts in the otherStations. so, you need to explore each path, and see if you get to the destination stop on that path. on a path that doesn't include the destination, you'll reach an end station that isn't the station you're looking for. so then, you want to go back to the transfer station and try going down the next path in the otherStations list, and then repeating that until you find the transfer station. **you will only enter this if statement if you need to transfer**, otherwise, you'll continue to the bottom of the function and the function will be called again.
            if (nextStation instanceof TransferStation) {
                TransferStation nextTransferStation = (TransferStation) nextStation;
                visitedStations.add(nextTransferStation); //safeguard against casting issues
                //going through the list of transfers and trying to go down all those paths
                for (int i = 0; i < nextTransferStation.otherStations.size(); i++) {
                    if (nextTransferStation.otherStations.get(i).line.equals(destStation.line)) {
                        int length = tripLengthRecursive(destStation, nextTransferStation.otherStations.get(i), visitedStations, tripLength + 1);
                        if (length < 0) {
                            continue;
                        }
                        if (length >= 0) {
                            return length;
                        }
                    }
                }
            }
        //case 1: no line transfer required to get to the next station-- you can move forward normally
        return tripLengthRecursive(destStation, nextStation.next, visitedStations, tripLength + 1);
    }
    

    //toString
    public String toString() {
        //System.out.println("tostringtest");
        //System.out.println(this.name);
        if ((this.prev == null) && (this.next == null)) {
            return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: none" + ", next station: none";
        } else if (this.prev == null) {
            return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: none" + ", next station: "  + this.next.name;
        } else if (this.next == null) {
            return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: none";
        } else {
            return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: " + this.next.name;
        }
    }
}