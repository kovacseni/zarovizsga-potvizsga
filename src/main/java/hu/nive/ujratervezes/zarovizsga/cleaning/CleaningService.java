package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sum = 0;
        for (Iterator<Cleanable> iter = cleanables.iterator(); iter.hasNext(); ) {
            Cleanable cleanNow = iter.next();
            sum += cleanNow.clean();
            iter.remove();
        }
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        for (Iterator<Cleanable> iter = cleanables.iterator(); iter.hasNext(); ) {
            Cleanable cleanNow = iter.next();
            if (cleanNow instanceof Office) {
                sum += cleanNow.clean();
                iter.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c.getAddress().contains(address)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable c : cleanables) {
            sb.append(c.getAddress()).append(", ");
        }
        String result = sb.substring(0, sb.toString().length() - 2);
        return result;
    }
}
