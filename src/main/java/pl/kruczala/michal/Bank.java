package pl.kruczala.michal;

import org.springframework.stereotype.Component;
import pl.kruczala.michal.exceptions.ApplicationException;

import java.util.*;

class BanknotesIterator {
    private Iterator<Banknotes> iterator;
    public Banknotes current;

    BanknotesIterator(Iterator<Banknotes> iterator) {
        this.iterator = iterator;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public BanknotesIterator moveNext() {
        this.current = iterator.next();
        return this;
    }

    public BanknotesIterator moveTo20() {
        if (current.nominal == 20) {
            return this;
        }

        moveNext();
        return moveTo20();
    }
}

class Banknotes {
    public int nominal;
    public int count;

    public int used;

    public Banknotes(int nominal, int count) {
        this.nominal = nominal;
        this.count = count;
    }

    public int reduce(int requestedSum) {
        this.count--;
        this.used++;
        return requestedSum - this.nominal;
    }

    public boolean canTake() {
        return count > 0;
    }

    public PayOutResult toPayoutResult() {
        return new PayOutResult(this.nominal, this.count);
    }
}

public class Bank {
    public ArrayList<PayOutResult> calculate(int requestedSum, ArrayList<Casket> caskets) throws ApplicationException {
        List<Banknotes> list = caskets.stream()
                .map(x -> new Banknotes(x.nominal, x.numberOfBanknotesInCasket))
                .toList();

        boolean result = calculate(requestedSum, new BanknotesIterator(list.iterator()));
        if (!result) {
            throw new ApplicationException("cannot payout requestedSum");
        }
        return new ArrayList<>(list.stream().map(x -> x.toPayoutResult()).toList());
    }

    private boolean calculate(int requestedSum, BanknotesIterator iterator) throws ApplicationException {
        if (requestedSum == 0) {
            return true;
        }
        if (requestedSum < 20) {
            return false;
        }

        if (iterator.current == null) {
            iterator.moveNext();
        }

        Banknotes banknotes = iterator.current;

        if (!banknotes.canTake()) {
            return calculate(requestedSum, iterator.moveNext());
        }

        if ((requestedSum == 60 || requestedSum == 80)) {
            iterator.moveTo20();
            requestedSum = iterator.current.reduce(requestedSum);
            return calculate(requestedSum, iterator);
        }

        if (requestedSum >= banknotes.nominal && banknotes.canTake()) {
            requestedSum = banknotes.reduce(requestedSum);
            return calculate(requestedSum, iterator);
        }

        if (!iterator.hasNext()) {
            return false;
        }

        return calculate(requestedSum, iterator.moveNext());
    }
}
