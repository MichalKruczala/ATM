package pl.kruczala.michal;

import org.springframework.stereotype.Component;
import pl.kruczala.michal.exceptions.ApplicationException;
@Component
public class Quantum {
    public int getRequestedSum() {
        return requestedSum;
    }

    public void setRequestedSum(int requestedSum) {
        this.requestedSum = requestedSum;
    }

    private int requestedSum;
    private final int value;

    public Quantum() throws ApplicationException {

        this.value = this.requestedSum;
        if ((requestedSum <= 0)) {
            throw new ApplicationException("Requested sum is negative or equal 0 ");
        }
        if (!isAcceptable(requestedSum, 200)) {
            throw new ApplicationException("Can't pay out demanded amount of money, available banknotes: 200/100/50/20");
        }
    }

    private boolean isAcceptable(int requestedSum, int nominal) throws ApplicationException {
        if (requestedSum == 0) {
            return true;
        }
        if (requestedSum < 20) {
            return false;
        }
        if ((requestedSum == 60 || requestedSum == 80)) {
            return isAcceptable(requestedSum - 20, 20);
        }
        if (requestedSum >= nominal) {
            return isAcceptable(requestedSum - nominal, nominal);
        }
        return isAcceptable(requestedSum, getNextNominal(nominal));
    }

    private int getNextNominal(int nominal) throws ApplicationException {
        return switch (nominal) {
            case 200 -> 100;
            case 100 -> 50;
            case 50 -> 20;
            default -> throw new ApplicationException("Unknown nominal");
        };
    }

    public int toInt() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Quantum c) {
            return this.value == c.value;
        }
        return false;
    }
}
