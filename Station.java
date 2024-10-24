import java.util.ArrayList;
public class Station {
    //fields
    protected String name;
    protected String line;
    protected Station next;
    protected Station prev;
    protected boolean inService = true;

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
    public int tripLength(Station destStation) {
        ArrayList<Station> visitedStations = new ArrayList<Station>();
        //check if stations are equal off the bat, return 0
        if (this.equals(destStation)) {
            return 0;
        }
        //initialize counter variable to return
        int tripLength = 0;
        //call helper function
        tripLengthRecursive(destStation, this.next, visitedStations, tripLength);
        if (tripLength < 0) {
            return -1;
        }

        return tripLength;
    }

    //TODO: make tripLength helper function
    public int tripLengthRecursive(Station destStation, Station nextStation, ArrayList<Station> visitedStations, int tripLength) {
        //base cases

        //trying to visit a station that's already been visited
        if (visitedStations.contains(nextStation)) {
            return -1;
        }

        //reached a station in which .equals() == true, return 1
        if (nextStation.equals(destStation) || tripLength >= 0) {
            return tripLength;
        }
    
        //reached an end station that is not equal to the destination w/o finding it: return -1
        if ((nextStation instanceof EndStation)  && (!nextStation.equals(destStation))) {
            return -1;
        }

        //random error catcher idek anymore tbh
        if (tripLength < 0) {
            return -1;
        }

        //--------------------------------------------------------------------------------------------------------------------------------

        //case 1: on the same line w/ stops in between (type of stops doesn't really matter bc they're on the same line)
        if (destStation.line == nextStation.line) {
            visitedStations.add(nextStation);
            return (tripLengthRecursive(destStation, nextStation.next, visitedStations, tripLength + 1));
        }

        //case 2: you have to transfer-- the transfer station can lead you to multiple different paths because it not only has its own next, but it also has other nexts in the otherStations. so, you need to explore each path, and see if you get to the destination stop on that path. on a path that doesn't include the destination, you'll reach an end station that isn't the station you're looking for. so then, you want to go back to the transfer station and try going down the next path in the otherStations list, and then repeating that until you find the transfer station. 
        if (destStation.line != nextStation.line) {
            if (!(nextStation instanceof TransferStation)) {
                visitedStations.add(nextStation);
                return (tripLengthRecursive(destStation, nextStation.next, visitedStations, tripLength + 1));
            }
            if (nextStation instanceof TransferStation) {
                TransferStation nextTransferStation = (TransferStation) nextStation;
                if (!(visitedStations.contains(nextTransferStation))) {
                    visitedStations.add(nextTransferStation);
                    return tripLengthRecursive(destStation, nextStation.next, visitedStations, tripLength);
                }
                //TODO: check if you can go down regular next path first
                for (int i = 0; i < nextTransferStation.otherStations.size(); i++) {
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
        return 0;
    }

    //toString
    public String toString() {
        System.out.println("tostringtest");

        System.out.println(this.getName());

        return "STATION " + this.name + ": " + this.line + " line, in service: " + this.inService + ", previous station: " + this.prev.name + ", next station: "  + this.next.name;
    }
}