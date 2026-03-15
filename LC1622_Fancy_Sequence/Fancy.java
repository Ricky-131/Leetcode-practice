package LC1622_Fancy_Sequence;
import java.util.*;
import java.math.BigInteger;

class Fancy {
    long add = 0, mult = 1, mod = 1000000007;
    List<Long> arr;
    public Fancy() {
        arr = new ArrayList<>();
    }

    public void append(int val) {
        long inv = BigInteger.valueOf(mult).modInverse(BigInteger.valueOf(mod)).longValue();
        arr.add(((val-add+mod)%mod * inv)%mod);
    }

    public void addAll(int inc) {
        add = (add + inc)%mod;
    }

    public void multAll(int m) {
        mult = (mult * m)%mod;
        add = (add * m)%mod;
    }

    public int getIndex(int idx) {
        if (idx>=arr.size())  return -1;
        return (int)((arr.get(idx) * mult + add)%mod);
    }
}